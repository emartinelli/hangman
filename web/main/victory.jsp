<%-- 
    Document   : victory
    Created on : 17/11/2013, 17:49:40
    Author     : elvio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/../html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./../lib/css/bootstrap-responsive.min.css">
        <link rel="stylesheet" type="text/css" href="./../lib/css/bootstrap.min.css">
        <title>Victory</title>
    </head>
    <body>
        <div class="container">
                    <img src="./../resources/hangman_style.png" width="150px">
                    <h1 class="">You win</h1>
                <button onClick="parent.location = './game.jsp';" class="btn btn-primary btn-large" style="min-width: 250px">Try again?</button>
        </div>
    </body>
    <script src="./../lib/js/jquery-1.10.2.min.js"></script>
    <script src="./../lib/js/bootstrap.min.js"></script>
</body>
</html>