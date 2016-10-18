<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
  <title>Наброски для jsp</title>
  <link rel="stylesheet" href="../../css/bootstrap.min.css"/>
  <link rel="js" href="../../js/bootstrap.min.js"/>
  <link rel="stylesheet" href="../../css/popup.css"/>

  <style type="text/css">
    div { max-width:800px; margin:5px auto;}
    button{max-width: 100px; max-height: 100px}
    body { padding-top: 70px; }
    textarea {resize:vertical;}
  </style>


</head>
<div>
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">

    <div class="navbar-header">
      <a class="navbar-brand" href="/app/">HandBook of Contacts</a>
    </div>
  </div>
</nav>


<div class="panel panel-default">
  <div class="container">
      <div class="input-group">
        <span class="input-group-addon" >Please, enter your message info.</span>
      </div>
      <div class="col-lg-11">
        <div class="input-group">
		      			<span class="input-group-btn">
		        			<label class="col-sm-2 control-label">From whom:</label>
		      			</span>
            <input type="text" class="form-control" placeholder="Your email address...">
        </div>
        <div class="input-group">
		      			<span class="input-group-btn">
		        			<label class="col-sm-2 control-label">Theme:</label>
		      			</span>
            <input type="text" class="form-control" placeholder="Theme of email...">
        </div>
        <div class="input-group">
		      			<span class="input-group-btn">
		        			<label class="col-sm-2 control-label">Pattern:</label>
		      			</span>
          <input type="text" class="form-control" placeholder="Pattern of email...">
        </div>
        <div class="input-group">
		      			<span class="input-group-btn">
		        			<label class="col-sm-2 control-label">Message:</label>
		      			</span>
          <textarea type="text" class="form-control" placeholder="Text of email..."></textarea>
        </div>
        <div class="form-group">
          <div class="btn-group pull-right">
            <span><button type="submit" class="btn btn-danger" name="save" value="${contact.getId}">Send email</button></span>
            <span><button type="submit" class="btn btn-danger" name="cancel" value="cancel">Cancel</button></span>
          </div>
        </div>
      </div>
    </div>
</div>
</div>











<!-- _____________________________________________ -->

<script src="js/bootstrap.min.js"></script>
<script src="../../js/popup.js"></script>

</body>
</html>
