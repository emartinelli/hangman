<%-- 
    Document   : mangementMenu
    Created on : 10/11/2013, 23:18:43
    Author     : elvio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/../html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./../lib/css/bootstrap-responsive.min.css">
        <link rel="stylesheet" type="text/css" href="./../lib/css/bootstrap.min.css">
        <title>Management Menu</title>
    </head>
    <body>
        <div class="container">
            <div class="media">
                <a class="pull-left" href="#">
                    <img src="./../resources/hangman.png" width="150px">
                </a>
                <div class="media-body">
                    <h1 class="">Management Menu</h1>
                </div>
            </div>
            <div class="btn-group-vertical">
                <button onClick="parent.location = './management/users.jsp';" class="btn btn-primary btn-large" style="min-width: 100px">Users</button>
                <button onClick="parent.location = './management/words.jsp';" class="btn btn-primary btn-large" style="min-width: 100px">Words</button>
                <button onClick="parent.location = './../mainMenu.jsp';" class="btn btn-primary btn-large" style="min-width: 100px">Back</button>
            </div>
        </div>
    </body>
    <script src="./../lib/js/jquery-1.10.2.min.js"></script>
    <script src="./../lib/js/bootstrap.min.js"></script>
</body>
</html>
