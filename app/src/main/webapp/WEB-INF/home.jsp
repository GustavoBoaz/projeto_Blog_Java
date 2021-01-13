<%-- 
    Document   : home
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
        <title>Home Page</title>
        <!-- Bootstrap core CSS -->
        <%@include file="templates/ini_css.jsp" %>

        <!-- Font icons -->
        <script src="https://kit.fontawesome.com/9bcfc67907.js" crossorigin="anonymous"></script>

        <!-- Jquery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
<body>
    
    <%@include file="templates/ini_theme.jsp" %>
    <main id="main_home" class="bn-1 scrollbar">
        <%@include file="templates/comp_navbar.jsp" %>
        Welcome ${name} , ${email}
        <div id="card">
            <c:forEach items="${posts}" var="post">
                <div class="card-post bn-5">
                    <div>
                        <p class="font-semi-bold tn-4" style="margin-top: 50px; margin-bottom: 50px;">${post.descricao}</p>
                    </div>           
                    <c:choose>
                        <c:when test="${post.id == id}">
                            <a class="slogan bn-4">
                                <h4 class="font-semi-bold tn-1">${name}</h4>
                            </a>
                        </c:when>    
                        <c:otherwise>

                        </c:otherwise>
                    </c:choose>
                </div>
            </c:forEach>
        </div>

    </main>

    <!-- Placed at the end of the document so the pages load faster -->
    <%@include file="templates/ini_js.jsp" %>
    <script src="${pageContext.request.contextPath}/js/home.js"></script>
</body>
</html>