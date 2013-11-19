<%-- 
    Document   : wordsErrorFrequency
    Created on : 10/11/2013, 23:27:48
    Author     : elvio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<jsp:useBean id="wordDAO" class="br.mackenzie.hangman.DAO.WordDAO" scope="page" />
<jsp:useBean id="word" class="br.mackenzie.hangman.model.Word" scope="page" />
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
                    <img src="./../../resources/hangman.png" width="150px">
                </a>
                <div class="media-body">
                    <h1 class="">Words - Error Frequency</h1>
                </div>
            </div>
            <div>
                <br>
                <table class="table">
                    <tr>
                        <td>Word </td>
                        <td>Error frequency</td>
                    </tr>
                    <c:forEach var="words" items='${wordDAO.listarTodosJogados()}'>
                        <tr>
                            <td><c:out value="${words.realWord}"/></td>
                            <fmt:parseNumber var="i" type="number" value="${(wordDAO.Erro(wordDAO.retornaId(words))/(wordDAO.Acerto(wordDAO.retornaId(words))+wordDAO.Erro(wordDAO.retornaId(words))))*10}" />
                            <td><c:out value="${i}"/> %</td>
                        </tr>
                    </c:forEach>
                </table>

            </div>
        </div>
    </body>
    <script src="./../../lib/js/jquery-1.10.2.min.js"></script>
    <script src="./../../lib/js/bootstrap.min.js"></script>
</html>