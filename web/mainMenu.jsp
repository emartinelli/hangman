<%-- 
    Document   : mainMenu
    Created on : 10/11/2013, 22:53:40
    Author     : elvio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./lib/css/bootstrap-responsive.min.css">
        <link rel="stylesheet" type="text/css" href="./lib/css/bootstrap.min.css">
        <title>Main Menu</title>
    </head>
    <body>
        <div class="container">
            <div class="media">
                <a class="pull-left" href="#">
                    <img src="./resources/hangman.png" width="150px">
                </a>
                <div class="media-body">
                    <h1 class="">Menu</h1>
                </div>
            </div>
            <div class="btn-group-vertical">
                <button onClick="parent.location='./main/game.jsp';" class="btn btn-primary btn-large" style="min-width: 150px">New game</button>
                <button onClick="parent.location='./main/hallOfFameMenu.jsp';" class="btn btn-primary btn-large" style="min-width: 150px">Hall of fame</button>
                <button onClick="parent.location='./main/managementMenu.jsp';" class="btn btn-primary btn-large" style="min-width: 150px">Management</button>
                <button class="btn btn-primary btn-large" style="min-width: 150px">Quit</button>
            </div>
        </div>
    </body>
    <script src="./lib/js/jquery-1.10.2.min.js"></script>
    <script src="./lib/js/bootstrap.min.js"></script>
</html>
