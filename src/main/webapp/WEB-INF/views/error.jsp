<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
  <link rel="stylesheet" href="../../css/style.css">
  <link rel="stylesheet" href="../../css/bootstrap.min.css">
  <link rel="stylesheet" href="../../css/bootstrap.min.css.map">
  <link rel="stylesheet" href="../../css/bootstrap.css">
  <link rel="stylesheet" href="../../css/navbar_css.css">
  <style>


/*переделать расположение элементов*/
    .my-marg-error {
      margin-top: 70px;
      position: relative;
    }
  </style>
</head>
<body>
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
  <div class="col-md-12 text-center">
    <%--<div class="h1 text-center my-marg-error">--%>
   <%--Sorry, seems to be the hardest search:(--%>
    <%--</div>--%>
    <img alt="feature1" class="img-responsive" src="../../pics/404.png">
  </div>
</div>
</body>
</html>
