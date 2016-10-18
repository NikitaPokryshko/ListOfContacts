<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Наброски для jsp</title>
    <link rel="stylesheet" href="../../css/bootstrap.min.css"/>
    <%--<script type="text/javascript" src="../../js/bootstrap.min.js"></script>--%>
    <script type="text/javascript" src="../../js/childsHandler.js"></script>
    <link rel="stylesheet" href="../../css/popup.css"/>
    <link rel="stylesheet" href="../../css/editForm.css"/>
    <%--<script src="../../js/jquery-2.1.4.min.js"></script>--%>


    <%--<script>--%>
        <%--function PopUpShow(){--%>
            <%--document.getElementById('popup1').style.display = 'block';--%>
        <%--}--%>
        <%--function PopUpHide(){--%>
            <%--document.getElementById('popup1').style.display = 'none';--%>
        <%--}--%>
        <%--function PopUpShowA(){--%>
            <%--document.getElementById('popup2').style.display = 'block';--%>
        <%--}--%>
        <%--function PopUpHideA(){--%>
            <%--document.getElementById('popup2').style.display = 'none';--%>
        <%--}--%>

    <%--</script>--%>


</head>
<body>

    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">

            <div class="navbar-header">
                <a class="navbar-brand" href="/app/">HandBook of Contacts</a>
            </div>
        </div>
    </nav>


        <div class="container">

            <div class="input-group">
                <span class="input-group-addon" >Please, enter your personal data.</span>
            </div>
            <div class="row">
                <div class="col-md-4 col-sm-3 col-xs-12 profile-photo" id="profilePhotoId">
                    <div class="text-center">
                        <img src="${ requestScope.contact.photo.photoReference }" class="avatar img-thumbnail" alt="avatar">
                    </div>
                    <input type="file" name="Contact.photo"  />
                </div>
                <div class="col-md-8 col-sm-9 col-xs-12 personal-info pull-right">
                    <form action="/app/contact/new" method="POST" class="form-horizontal" id="formId" >
                        <input type="hidden" name="contact.id" value="${ requestScope.contact.id }">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">First name:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="First name..." name="firstName" value="${ requestScope.contact.firstName}">
                            </div>
                        </div>
                        <div class="form-group">

                            <label class="col-sm-2 control-label">Last name:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="Last name..." name="lastName" value="${ requestScope.contact.lastName}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Patronymic:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="Patronymic..." name="patronymic" value="${ requestScope.contact.patronymic}">
                            </div>
                        </div>

                        <div class="form-group">

                            <label class="col-sm-2 control-label">Date of birth:</label>
                            <div class="col-sm-10">
                                <c:choose>
                                    <c:when test="${requestScope.contact.dateOfBirth != null}">
                                        <input type="date" class="form-control" id="date" name="dateOfBirth"
                                               value="<fmt:formatDate value="${ requestScope.contact.dateOfBirth }" pattern="yyyy-MM-dd"/>" required>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="date" class="form-control" id="date" name="dateOfBirth" required>
                                    </c:otherwise>
                                </c:choose>

                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-2 control-label">Gender:</label>
                            <div class="col-sm-10">
                              <span>
                                <label class="btn btn-danger" id="male">
                                    <input type="radio" name="gender"  value="${requestScope.contact.gender=='MALE'}" autocomplete="off"> Male
                                </label>
                             </span>
                             <span>
                              <label class="btn btn-danger" id="female">
                                  <input type="radio" name="gender"  value="${requestScope.contact.gender=='FEMALE'}" autocomplete="off"> Female
                              </label>
                           </span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">Nationality:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="Nationality..." name="nationality" value="${ requestScope.contact.nationality}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label  class="col-sm-2 control-label">Marital status:</label>
                            <div class="col-sm-10">
                                <span>
                                  <label class="btn btn-danger"  id="married">
                                      <input type="radio" name="marriedStatus"  value="${requestScope.contact.maritalStatus=='MARRIED'}" autocomplete="off"> Married
                                  </label>
                               </span>
                                <span>
                                <label class="btn btn-danger" id="notmarried">
                                    <input type="radio" name="marriedStatus"  value="${requestScope.contact.maritalStatus='NOT_MARRIED'}" autocomplete="off" > Not married
                                </label>
                                </span>
                                <span>
                                  <label class="btn btn-danger" id="divorced">
                                      <input type="radio" name="marriedStatus"  value="${requestScope.contact.maritalStatus=='DIVORCED'}" autocomplete="off"> Divorced
                                  </label>
                                </span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">Website:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="Website..."  name="website" value="${ requestScope.contact.webSite }">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Email:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="Email..." name="email" value="${ requestScope.contact.email }">
                            </div>
                        </div>
                        <div class="form-group">

                            <label class="col-sm-2 control-label">Company:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="Your current workplace..." name="currentJob" value="${ requestScope.contact.currentJob}">
                            </div>
                        </div>
                        <div class="form-group">

                            <label class="col-sm-2 control-label">Country:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="Country..." name="country" value="${ requestScope.contact.address.country }">
                            </div>
                        </div>
                        <div class="form-group">

                            <label class="col-sm-2 control-label">City:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="City..." name="city" value="${ requestScope.contact.address.city }">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Street:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="Street..." name="street" value="${ requestScope.contact.address.street}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">House:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="House..." name="house" value="${ requestScope.contact.address.house }">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Flat:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="Flat..." name="flat" value="${ requestScope.contact.address.flat}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Zipcode:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="Zipcode..." name="index" value="${ requestScope.contact.address.index}">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="btn-group">
                                <span><input value="Save" type="submit" class="btn btn-danger" name="save" /></span>
                                <span><a href="/app/" type="submit" class="btn btn-danger" name="cancel">Cancel</a></span>
                            </div>
                        </div>

                        <div id="attachmentsId" >

                            <div id="${ requestScope.attachmentclassname }.typeInfo" >

                                ${ requestScope.attachmentdescribe }

                            </div>

                            <div id="${ requestScope.attachmentclassname }.elements" >

                                <c:forEach var="attach" items="${ requestScope.contact.attachments }" >

                                    <div objectid="Attachment.${ attach.id }">

                                            ${ attach.JSONDescribe }

                                    </div>

                                </c:forEach>

                            </div>

                        </div>

                        <div id="phonesId" >

                            <div id="${ requestScope.phoneclassname }.typeInfo" >

                                ${ requestScope.phonedescribe }

                            </div>

                            <div id="${ requestScope.phoneclassname }.elements" >

                                <c:forEach var="phone" items="${ requestScope.contact.phones }" >

                                    <div>

                                            ${ phone.JSONDescribe }

                                    </div>

                                </c:forEach>

                            </div>

                        </div>
                    </form>
                </div>
            </div>


            <div class="bs-example">
                <div class="panel panel-default">
                    <table class="table table-striped" id="phoneTableId">
                        <%--<thead>--%>
                        <%--<tr>--%>
                            <%--<th>Phones#</th>--%>
                            <%--<th>Phone number</th>--%>
                            <%--<th>Type</th>--%>
                            <%--<th>Comment</th>--%>
                        <%--</tr>--%>
                        <%--</thead>--%>
                        <%--<tbody>--%>
                        <%--<c:forEach var="phone" items="${requestScope.contact.phones}" varStatus="status">--%>
                            <%--<tr>--%>
                                <%--<td>--%>
                                    <%--<div class="checkbox">--%>
                                        <%--<label><c:out value="${status.count}"/></label>--%>
                                        <%--<input type="checkbox" name="phoneCheck" value="${phone.id}">--%>
                                    <%--</div>--%>
                                <%--</td>--%>
                                <%--<td><c:out value="${phone.getFullNumber}"/></td>--%>
                                <%--<td><c:out value="${phone.getPhoneType()}"/></td>--%>
                                <%--<td><c:out value="${phone.getComment()}"/></td>   <!-- методы для вставки кратких данных о клиенте-->--%>
                            <%--</tr>--%>
                        <%--</c:forEach>--%>


                        <%--</tbody>--%>
                    </table>
                    <div class="btn-group pull-right">
                        <span><a id="phoneCreateId" class="btn btn-danger">Create</a></span>
                        <%--<span><a id="attachPopupId" class="btn btn-danger">Edit</a></span>--%>
                        <span><a id="phoneDeleteId" class="btn btn-danger">Delete</a></span>
                        <!--возможно поменять на SUBMIT  -->
                    </div>



                </div>
            </div>

            <div class="bs-example">
                <div class="panel panel-default">
                    <table class="table table-striped" id="attachTableId" >
                        <%--<thead>--%>
                        <%--<tr>--%>
                            <%--<th>Attachments#</th>--%>
                            <%--<th>File name</th>--%>
                            <%--<th>Date of download</th>--%>
                            <%--<th>Comment</th>--%>
                        <%--</tr>--%>
                        <%--</thead>--%>
                        <%--<tbody>--%>
                        <%--<c:forEach var="attach" items="${requestScope.contact.attachments}" varStatus="status">--%>
                            <%--<tr>--%>
                                <%--<td>--%>
                                    <%--<div class="checkbox">--%>
                                        <%--<label><c:out value="${status.count}"/></label>--%>
                                        <%--<input type="checkbox" name="phoneCheck" value="${attach.id()}">--%>
                                    <%--</div>--%>
                                <%--</td>--%>
                                <%--<td><c:out value="${attach.attachmentFileName}"/></td>--%>
                                <%--<td><c:out value="${attach.dateOfDownload}"/></td>--%>
                                <%--<td><c:out value="${attach.comment}"/></td>   <!-- методы для вставки кратких данных о клиенте-->--%>
                            <%--</tr>--%>
                        <%--</c:forEach>--%>
                        <%--</tbody>--%>
                    </table>
                    <div class="btn-group pull-right">
                        <span><a id="attachCreateId" class="btn btn-danger">Create</a></span>
                        <%--<span><a id="attachPopupId" class="btn btn-danger">Edit</a></span>--%>
                        <span><a id="attachDeleteId" class="btn btn-danger">Delete</a></span>
                        <!--возможно поменять на SUBMIT  -->
                    </div>

                </div>
            </div>


        </div>

        <div class="b-popup" id="phonePopupId">
            <div class="b-popup-content">
                <label>New phone:</label>

                <div>
                    <input type="text" class="form-control" placeholder="Country code" name="Phone.countryCode" value="">
                    <input type="text" class="form-control" placeholder="Operators code" name="Phone.operatorsCode" value="">
                    <input type="text" class="form-control" placeholder="Phone number" name="Phone.phoneNumber" value="">
                    <input type="text" class="form-control" placeholder="Phone type" name="Phone.type" value="">
                    <input type="text" class="form-control" placeholder="Comment" name="Phone.comment" value="">
                </div>

              <span class="input-group-addon">
                    <a id="phonePopupCreateId" class="btn btn-danger">Save</a>
                  <a  id="phonePopupCancelId" class="btn btn-danger">Cancel</a>
              </span>
            </div>
        </div>

        <div class="b-popup" id="attachPopupId">
            <div class="b-popup-content">
                <label>New attachment:</label>

                <div>
                    <input type="text" class="form-control" placeholder="File name" name="Attachment.attachmentFileName" value="">
                    <input type="text" class="form-control" placeholder="File name" name="Attachment.attachPath" value="">
                    <input type="text" class="form-control" placeholder="Date of download" name="Attachment.dateOfDownload" value="">
                    <input type="text" class="form-control" placeholder="Comment" name="Attachment.comment" value="">
                    <input type="file" />
                </div>

              <span class="input-group-addon">
                <a id="attachPopupCreateId" class="btn btn-danger">Save</a>
                <a id="attachPopupCancelId"  class="btn btn-danger">Cancel</a>
              </span>
            </div>
        </div>


</body>
</html>
