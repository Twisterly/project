<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h3>Your personal information was successfully updated!</h3>
<table style="width:100%" class="table table-hover">
  <tr>
    <th>Username</th>
    <th>First name</th>
    <th>Last name</th>
    <th>Birth date</th>
    <th>Email</th>
    <th>Phone number</th>
    <th>Gender</th>
  </tr>
  <tr>
    <td>${username}</td>
    <td>${appUser.firstName}</td>
    <td>${appUser.lastName}</td>
    <td>${birthDate}</td>
    <td>${appUser.email}</td>
    <td>${appUser.phoneNumber}</td>
    <td>${gender}</td>
  </tr>
</table>
<jsp:include page="_footer.jsp"/>