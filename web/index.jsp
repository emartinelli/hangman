<%-- 
    Document   : index
    Created on : 15/10/2013, 17:25:27
    Author     : E Martinelli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hangman Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./lib/css/bootstrap-responsive.min.css">
        <link rel="stylesheet" type="text/css" href="./lib/css/bootstrap.min.css">
    </head>
    <body>
        <!--<div class="jumbotron"> -->
        <div class="container">
            <div class="media">
                <a class="pull-left" href="#">
                    <img src="./resources/hangman.png" width="150px">
                </a>
                <div class="media-body">
                    <h1 class="">SAVE THE HANGMAN NOW!<small> or go away...</small></h1>
                </div>
            </div>
            <form method="post" action="controller?opcao=player.auth">
                <div class="form-group">
                    <label for="nickname">Nickname</label>
                    <input type="text" class="form-control" id="nickname" name="nickname" placeholder="Enter nickname"><br><br
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" class="form-control" name="password" placeholder="Enter password"><br>
                </div>
                <br>
                <button type="submit" class="btn btn-default navbar-btn" id="signin" name="signin" value="true">Sign in</button>
                <button type="submit" class="btn btn-default navbar-btn" id="signup" name="signup" value="true">Sign Up</button>
            </div>
        </form>
</div>
<!-- </div> -->
</body>
<script src="./lib/js/jquery-1.10.2.min.js"></script>
<script src="./lib/js/bootstrap.min.js"></script>
</html>
<script type="text/javascript">
    $(document).ready(function() {

    });
</script>

