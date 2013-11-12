<%-- 
    Document   : welcome
    Created on : 12/11/2013, 21:05:39
    Author     : 31281354
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
                    <h1 class="">Welcome and good luck<small>... you will need</small></h1>
                </div>
            </div>
            <div>
                <button onClick="parent.location='./mainMenu.jsp';" class="btn btn-primary btn-large" style="min-width: 150px">Start now!</button>
            </div>
        </div>
    </body>
    <script src="./lib/js/jquery-1.10.2.min.js"></script>
    <script src="./lib/js/bootstrap.min.js"></script>
</html>
