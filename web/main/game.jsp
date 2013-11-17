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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/../html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./../lib/css/bootstrap-responsive.min.css">
        <link rel="stylesheet" type="text/css" href="./../lib/css/bootstrap.min.css">
        <title>Hall of Fame Menu</title>
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
        var randomWord = '<c:out value="${word.getRandomWord(wordDAO.listarTodos()).realWord}" />';
        var usedLetters = "";
        var finalWordContent = "";
        for (i = 0; i < randomWord.length; i++) {
            finalWordContent += "_ ";
        }
        $("#finalWord").text(finalWordContent);

        $('#charInput').keyup(function() {
            try {
                var content = $('#charInput').val()[0];
                $('#charInput').val("");
                $("#charError").hide();
                if (usedLetters.indexOf(content) !== -1) throw "You have already tried this character and it is WRONG!";
                if (finalWordContent.indexOf(content) !== -1) throw "Ok it is right but you could try another!";
                console.log("Teste:" + content);
                //randomWord.
                var startIndex = 0;
                if (randomWord.indexOf(content, startIndex) !== -1) {
                    while (startIndex !== -1) { //Right char
                        startIndex = randomWord.indexOf(content, startIndex);
                        finalWordContent = finalWordContent.slice(0, startIndex - 1) + content + finalWordContent.slice(startIndex + 1, finalWordContent.length);
                        console.log(finalWordContent);
                    }
                    $("#finalWord").val(finalWordContent);
                } else {//Wrong char
                    usedLetters = usedLetters + content;
                    $("#usedLetters").text(usedLetters);
                    $("#hangmanImage").attr("src", "./../resources/gallows/" + usedLetters.length + ".png");
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
