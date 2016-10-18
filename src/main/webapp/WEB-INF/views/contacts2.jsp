<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.itechart.pkr.domain.*" pageEncoding="UTF-8" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Contacts</title>
    <meta charset="utf-8">
    <title>All contacts page</title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/bootstrap.min.css.map">
    <link rel="stylesheet" href="../../css/bootstrap.css">
    <link rel="stylesheet" href="../../css/navbar_css.css">
    <script src="../../js/bootstrap.min.js"></script>

</head>
<body>

<form id="form" method="post">
    <nav class="navbar my-navi navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#####">List of Contacts</a>
            </div>

            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                    <li><a href="#####"><span class="glyphicon glyphicon-log-in"></span> Home</a></li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/web/search"><span class="glyphicon glyphicon-user"></span>Search</a></li>
                </ul>
            </div>

        </div>
    </nav>

    <div class="container">
        <table class="table table-striped my-marginer">
            <%--<c:forEach var="error" items="${requestScope.errors}">--%>
                <%--<div><c:out value="${error}"/></div>--%>
            <%--</c:forEach>--%>
            <thead>
            <tr>
                <th>ContactsID</th>
                <th>Full name</th>
                <th>Date of birth</th>
                <th>Address</th>
                <th>Company</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="contact"  items="${requestScope.contacts}">
                <tr>
                    <td><input type="checkbox" name="id" value="${contact.id}" title="checkbox"> ${contact.id}</td>
                    <td><a class="my-a-contacts" href="/web/contact/edit?id=${contact.id}">${contact.fullName}</a></td>
                    <td>${contact.dateOfBirth}</td>
                    <td>${contact.shortAddress}</td>
                    <td>${contact.currentJob}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="btn-group pull-right">
            <button type="submit" class="btn btn-primary" value="/web/contact/new" onclick="setActionToForm()">Add</button>
            <button type="submit" class="btn btn-primary" value="/web/delete" onclick="setActionToForm()">Delete</button>
            <button type="submit" class="btn btn-primary" value="/web/contact/edit" onclick="setActionToForm()">Edit</button>
            <button type="submit" class="btn btn-primary" value="/web/contact/email" onclick="setActionToForm()">Send email</button>
        </div>

        <ul class="my-pagi">
            <%--<c:if test="${requestScope.currentPage != 1}">--%>
                <li><a href="/web/?page=${requestScope.currentPage - 1}" class="btn btn-primary">&laquo;</a></li>
            <%--</c:if>--%>

            <c:forEach begin="1" end="${requestScope.numOfPages}" var="i">
                <c:choose>
                    <c:when test="${requestScope.currentPage eq i}">
                        <li><a href="" class="btn btn-primary">${i}</a></li>
                    </c:when>
                    <c:otherwise>
                       <li><a href="/web/?page=${i}" class="btn btn-primary">${i}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <%--<c:if test="${requestScope.currentPage != 1}">--%>
                <li><a href="/web/?page=${requestScope.currentPage + 1}" class="btn btn-primary">&raquo;</a></li>
            <%--</c:if>--%>
        </ul>
    </div>
</form>
</body>
<script>

    var setActionToForm = function () {
        var atr = event.target.value;
        var form = document.getElementById('form');
        form.setAttribute('action', atr)
    }

</script>
</html>
