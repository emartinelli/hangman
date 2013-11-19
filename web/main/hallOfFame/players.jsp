<%-- 
    Document   : players
    Created on : 10/11/2013, 23:24:36
    Author     : elvio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<jsp:useBean id="playerDAO" class="br.mackenzie.hangman.DAO.PlayerDAO" scope="page" />
<jsp:useBean id="player" class="br.mackenzie.hangman.model.Player" scope="page" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./../../lib/css/bootstrap-responsive.min.css">
        <link rel="stylesheet" type="text/css" href="./../../lib/css/bootstrap.min.css">
        <title>Main Menu</title>
    </head>
    <body>
        <div class="container">
            <div class="media">
                <a class="pull-left" href="#">
                    <img src="./../../resources/hangman_style.png" width="150px">
                </a>
                <div class="media-body">
                    <h1 class="">Players - Hall of Fame</h1>
                </div>
            </div>
            <div>
                <br>
                <table class="table">
                    <tr>
                        <td>Nickname </td>
                        <td>Score</td>
                    </tr>
                    <c:forEach var="players" items='${playerDAO.pontuacaoGeral()}'>
                        <tr>
                            <td><c:out value="${players.nickname}"/></td>
                            <td><c:out value="${players.totalScore}"/> pontos</td>
                        </tr>
                    </c:forEach>
                </table>

            </div>
        </div>
    </body>
    <script src="./../../lib/js/jquery-1.10.2.min.js"></script>
    <script src="./../../lib/js/bootstrap.min.js"></script>
</html>