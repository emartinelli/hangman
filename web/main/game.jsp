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
                <img id="hangmanImage" src="./../resources/gallows/0.png" width="150px">
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

        for (i = 0; i < randomWord.length; i++) { //Fill the secret word
            finalWordContent += "_";
        }

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
                    var newfinalWordContent = "";
                    for (startIndexI = 0, j = 0; startIndexI !== -1; startIndexI, j = startIndexI) {
                        startIndexI = randomWord.indexOf(content, startIndexI);
                        if (startIndexI === -1)
                            break;
                        finalWordContent = finalWordContent.substring(0, startIndexI - 1) + content + finalWordContent.substr(startIndexI + 1);
                        //for (var i = j; i < startIndexI; i++) {
                        //  newfinalWordContent += finalWordContent[i];
                        //}
                        //newfinalWordContent += content + " ";
                        //finalWordContent = newfinalWordContent;
                        console.log("Word:" + newfinalWordContent + " " + randomWord + " Index:" + startIndexI + " Tes:" + "\n");
                    }
                    //for (i = randomWord.lastIndexOf(content) + 1; i < randomWord.length; i++) {
                    //  newfinalWordContent += "_";
                    //}
                    //finalWordContent = newfinalWordContent;
                    finalWordSpc = finalWordContent;
                    $("#finalWord").text(finalWordSpc.split('').join(' ')); //Refresh the word with correct the char

                } else {//Wrong char
                    usedLetters = usedLetters + content;
                    if (usedLetters.length > 6) {
                        console.log("gooooooooooooooooooooo");
                        $.post("./../controller?opcao=count",
                                {
                                    word: randomWord,
                                    player: '${sessionScope.username}',
                                    gameover: "true"
                                },
                        function(data, status) {
                            console.log("Data: " + data + "\nStatus: " + status);
                        });
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
</script>
