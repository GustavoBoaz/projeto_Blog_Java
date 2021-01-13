<%-- 
    Document   : login
    Author     : gboaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Login Page</title>
        <!-- Bootstrap core CSS -->
        <%@include file="templates/ini_css.jsp" %>

        <!-- Jquery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
<body>

    <%@include file="templates/ini_theme.jsp" %>
    <main id="main_index" class="bn-1 scrollbar">
        <div id="container_login">
            <img class="medium-img" src="${pageContext.request.contextPath}/img/logo-ifsp.png">
            <br>
            <form id="content_form" action="/app/login.blog" method="post">
                <label class="font-medium tn-4" for="name">Usuario</label>
                <input class="forms-simple font-regular bn-5 tn-4" name="name" type="text" />
                <label class="font-medium tn-4" for="email">E-mail</label>
                <input class="forms-simple font-regular bn-5 tn-4" name="email" type="text" /><br>
                <button type="submit" class="btn-t bpo">
                    <h4 class="font-regular tn-4">Entrar ou Cadastrar</h4>
                </button>
            </form>
        </div>
    </main>

    <!-- Placed at the end of the document so the pages load faster -->
    <%@include file="templates/ini_js.jsp" %>
    <script src="${pageContext.request.contextPath}/js/login.js"></script>
</body>
</html>
