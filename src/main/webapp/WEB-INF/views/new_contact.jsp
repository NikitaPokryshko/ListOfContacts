<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Edit page</title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/bootstrap.min.css.map">
    <link rel="stylesheet" href="../../css/bootstrap.css">
    <link rel="stylesheet" href="../../css/navbar_css.css">
    <script src="../../js/bootstrap.min.js"></script>
    <script src="../../js/popup.js"></script>
    <script src="../../js/bootstrap.js"></script>

    <script type="text/javascript">
        function PopUpShowPhones(){
            document.getElementById('popupPhones').style.display = 'block';
        }
        function PopUpHidePhones(){
            document.getElementById('popupPhones').style.display = 'none';
        }

        function PopUpShowAttachs(){
            document.getElementById('popupAttachs').style.display = 'block';
        }
        function PopUpHideAttachs(){
            document.getElementById('popupAttachs').style.display = 'none';
        }
    </script>
</head>

<body>
<c:set var="contact" scope="request" value="${requestScope.contactToEdit}"/>

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
                <li><a href="#"><span class="glyphicon glyphicon-user"></span>Search</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row my-marginer">
        <!-- form -->

        <div class="col-sm-4"><!--конт 1-->
            <img src="../../pics/vikings.jpg" class="img-responsive" alt="Cinque Terre" width="250" height="250">
        </div>

        <div class="col-sm-8"><!--конт 2-->
            <!--                    <form action="post" role="form">       -->
            <div class="form-group">
                <label for="first name">First name*:</label>
                <input type="text" class="form-control" id="fName" value="${contact.firstName}">
            </div>
            <div class="form-group">
                <label for="last name">Last name*:</label>
                <input type="text" class="form-control" id="lName" value="${contact.lastName}">
            </div>
            <div class="form-group">
                <label for="patronymic">Patronymic:</label>
                <input type="text" class="form-control" id="patronymic" value="${contact.patronymic}">
            </div>
            <div class="form-group"><!-- -->
                <label for="date">Date of birth(изменить потом):</label>
                <input type="text" class="form-control" id="dateOfBirth" value="${contact.dateOfBirth}">
            </div>
            <div class="form-group">
                <label for="Gender">Gender:</label>
                <div class="radio">
                    <label><input type="radio" name="gender">Male</label>
                </div>
                <div class="radio">
                    <label><input type="radio" name="gender">Female</label>
                </div>
            </div>
            <div class="form-group">
                <label for="nationality">Nationality:</label>
                <input type="text" class="form-control" id="nationality" value="${contact.nationality}">
            </div>
            <div class="form-group">
                <label for="marital">Marital status:</label>
                <div class="radio">
                    <label><input type="radio" name="marital">Married</label>
                </div>
                <div class="radio">
                    <label><input type="radio" name="marital">Not married</label>
                </div>
                <div class="radio">
                    <label><input type="radio" name="marital">Divorced</label>
                </div>
            </div>
            <div class="form-group"><!-- -->
                <label for="website">Website:</label>
                <input type="text" class="form-control" id="website" value="${contact.webSite}">
            </div>
            <div class="form-group"><!-- -->
                <label for="email">Email:</label>
                <input type="text" class="form-control" id="email" value="${contact.email}">
            </div>
            <div class="form-group"><!-- -->
                <label for="workplace">Current workplace:</label>
                <input type="text" class="form-control" id="work" value="${contact.currentJob}">
            </div>
            <div class="col-sm-6">
                <label for="address">Address</label>
                <div class="form-group">
                    <label for="Country">Country:</label>
                    <input type="text" class="form-control" id="country" value="${contact.address.country}">
                    <label for="City">City:</label>
                    <input type="text" class="form-control" id="city" value="${contact.address.city}">
                    <label for="Street">Street:</label>
                    <input type="text" class="form-control" id="street" value="${contact.address.street}">
                    <label for="House">House:</label>
                    <input type="text" class="form-control" id="house" value="${contact.address.house}">
                    <label for="Flat">Flat:</label>
                    <input type="text" class="form-control" id="flat" value="${contact.address.flat}">
                    <label for="Index">Index:</label>
                    <input type="text" class="form-control" id="index" value="${contact.address.index}">
                </div>
            </div>
            <!--                    </form> -->
        </div>


        <div class="col-sm-12 my-marg-30">
            <div class="btn-group pull-right">
                <a href="javascript:PopUpShowPhones()"  class="btn btn-primary" name="add" >Add</a>
                <a href="#"  class="btn btn-primary" name="delete">Delete</a>
                <a href="#" class="btn btn-primary" name="edit">Edit</a>
            </div>

            <table class="table table-striped my-marg-30">
                <thead>
                <tr>
                    <th>Phones</th>
                    <th>Full number</th>
                    <th>Description</th>
                    <th>Comment</th>
                </tr>
                </thead>
                <tbody>

                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="col-sm-12 my-marg-30">
            <div class="btn-group pull-right">
                <a href="javascript:PopUpShowAttachs()"  class="btn btn-primary" name="add" >Add</a>
                <a href="#"  class="btn btn-primary" name="delete">Delete</a>
                <a href="#" class="btn btn-primary" name="edit">Edit</a>
            </div>

            <table class="table table-striped my-marg-30">
                <thead>
                    <tr>
                        <th>Attachments</th>
                        <th>File name</th>
                        <th>Date of download</th>
                        <th>Comment</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </div>

        <div class="b-popup" id="popupPhones">
            <div class="b-popup-content">
                <label>New phone:</label>

                <div>
                    <input type="text" class="form-control" placeholder="Country code" name="countryCode" value="">
                    <input type="text" class="form-control" placeholder="Operators code" name="operatorsCode" value="">
                    <input type="text" class="form-control" placeholder="Phone number" name="phoneNumber" value="">
                    <input type="text" class="form-control" placeholder="Phone type" name="phoneType" value="">
                    <input type="text" class="form-control" placeholder="Comment" name="comment" value="">
                </div>

                <a href="javascript:PopUpHidePhones()">
                    <div class="btn-group my-marg-popup">
                        <button type="button" class="btn btn-primary">Add</button>
                        <button type="button" class="btn btn-primary">Exit</button>
                    </div>
                </a>
            </div>
        </div>

        <div class="b-popup" id="popupAttachs">
            <div class="b-popup-content">
                <label>New attachment:</label>
                <div>
                    <input type="text" class="form-control" placeholder="File name" name="fileName" value="">
                    <input type="text" class="form-control" placeholder="Date of download" name="dateOfDownload" value="">
                    <input type="text" class="form-control" placeholder="Comment" name="comment" value="">
                </div>

                <a href="javascript:PopUpHideAttachs()">
                    <div class="btn-group my-marg-popup">
                        <button type="button" class="btn btn-primary">Add</button>
                        <button type="button" class="btn btn-primary">Exit</button>
                    </div>
                </a>
            </div>
        </div>
    </div> <!-- div class="row"-->

    <div class="btn-group col-md-6">
        <button type="submit" class="btn btn-primary btn-block" value="/web/contact/save" onclick="setActionToForm()">Save</button>
        <button type="submit" class="btn btn-primary btn-block" value="/web/" onclick="setActionToForm()">Cancel</button>
    </div>
</div>


</body>

</html>