<%-- 
    Document   : game
    Created on : 10/11/2013, 23:18:02
    Author     : elvio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<jsp:useBean id="wordDAO" class="br.mackenzie.hangman.DAO.WordDAO" scope="page" />
<jsp:useBean id="word" class="br.mackenzie.hangman.model.Word" scope="page" />
<jsp:useBean id="tipDAO" class="br.mackenzie.hangman.DAO.TipDAO" scope="page" />
<jsp:useBean id="tip" class="br.mackenzie.hangman.model.Tip" scope="page" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/../html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./../lib/css/bootstrap-responsive.min.css">
        <link rel="stylesheet" type="text/css" href="./../lib/css/bootstrap.min.css">
        <title>Hangman THE GAME</title>
    </head>
    <body>
        <div class="container">
            <div id="hangmanImageDiv">
                <p> Let's play a game, ${sessionScope.username} </p>
                <img id="hangmanImage" src="./../resources/gallows/0.png" width="200px">
                <button id='tipButton'>I need help</button> <small id='tipMsg'></small>
            </div>
            <div id="finalWordDiv">
                <h2 id="finalWord"></h2>
            </div>
            <div id="charInputDiv">
                <input type="text" id="charInput">
                <small style="color:red; display:none;" id="charError"></small>
            </div>
            <div id="usedLettersDiv">
                <h3 id="usedLetters"></h3>
            </div>
        </div>

    </body>
    <script src="./../lib/js/jquery-1.10.2.min.js"></script>
    <script src="./../lib/js/bootstrap.min.js"></script>
</body>
</html>
<script>
    $(document).ready(function() {
        var randomWord = '<c:out value="${word.getRandomWord(wordDAO.listarTodos()).realWord}" />'.toLowerCase();
        //var tips = ;
        var usedLetters = "";
        var finalWordContent = "";
        var tipIndex = 0;
        for (i = 0; i < randomWord.length; i++) { //Fill the secret word
            finalWordContent += "_";
        }

        $("#tipButton").click(function() {
            var tips = new Array();
            var i = 0;
            console.log("Click");
            <c:forEach var="tip" items="${tipDAO.retornaTip(wordDAO.buscarPorNome('teste0'))}">
                tips[i] = '<c:out value="${tip.information}"/>';
                console.log(tips[i]);
                i++;
            </c:forEach>
            if (tipIndex < 2) {
                $("#tipMsg").text(tips[tipIndex]);
                tipIndex++;
            }
            else
            {
                $("#tipMsg").text("You have no more tips. Good luck ;)");
            }

        });
        var finalWordSpc = finalWordContent; //put spaces in the secret word
        $("#finalWord").text(finalWordSpc.split('').join(' '));
        $('#charInput').keyup(function() {
            try {
                var content = $('#charInput').val()[0]; //Receive value, treatment of errors and input management
                $('#charInput').val("");
                $("#charError").hide();
                if (usedLetters.indexOf(content) !== -1) //treatment of errors
                    throw "You have already tried this character and it is WRONG!";
                if (finalWordContent.indexOf(content) !== -1)
                    throw "Ok it is right but you could try another!";
                patt = new RegExp("[^a-zA-Z0-9]");
                if (patt.test(content) || content === undefined)
                    throw "Hey! You should not use it here."

                //Verify and handle inputed chars, correct guesses and mistakes
                var startIndex = 0;
                if (randomWord.indexOf(content, startIndex) !== -1) {//Right char
                    for (startIndexI = 0, j = 0; startIndexI !== -1; startIndexI++, j = startIndexI) {
                        startIndexI = randomWord.indexOf(content, startIndexI);
                        if (startIndexI === -1)
                            break;
                        finalWordContent = finalWordContent.substring(0, startIndexI) + content + finalWordContent.substr(startIndexI + 1);
                        console.log("Word:" + finalWordContent + " " + randomWord + " Index:" + startIndexI + " Tes:" + "\n");
                    }
                    if (finalWordContent.indexOf('_') === -1) {
                        endGame("false", randomWord);
                    }
                    finalWordSpc = finalWordContent;
                    $("#finalWord").text(finalWordSpc.split('').join(' ')); //Refresh the word with correct the char

                } else {//Wrong char
                    usedLetters = usedLetters + content;
                    if (usedLetters.length > 6) { //gameover
                        endGame("true", randomWord);
                    } else {
                        $("#usedLetters").text(usedLetters);
                        $("#hangmanImage").attr("src", "./../resources/gallows/" + usedLetters.length + ".png");
                    }
                }
            } catch (err) {
                $("#charError").show();
                $("#charError").text(err);
            }
        }
        );
    }
    );
    function endGame(isGameover, randomWord) {
        $.post("./../controller?opcao=count",
                {
                    word: randomWord,
                    player: '${sessionScope.username}',
                    gameover: isGameover
                },
        function(data, status) {
            console.log(data + status);
        });
    }
</script>
