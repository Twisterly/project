<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>

<h1>All users:</h1>
<table style="width:100%">
  <tr>
    <th>Id</th>
    <th>Username</th>
    <th>Password</th>
    <th>First name</th>
    <th>Last name</th>
    <th>birth date</th>
    <th>gender</th>
    <th>email</th>
    <th>phone number</th>
    <th>role</th>
  </tr>
  <c:forEach items="${appUsers}" var="appUser">
  <tr>
  <td>
    <td><c:out value="${appUser.id}"/></td>
    <td><c:out value="${appUser.username}"/></td>
    <td><c:out value="${appUser.password}"/></td>
    <td><c:out value="${appUser.firstName}"/></td>
    <td><c:out value="${appUser.lastName}"/></td>
     <td><c:out value="${appUser.birthDate}"/></td>
     <td><c:out value="${appUser.gender}"/></td>
     <td><c:out value="${appUser.email}"/></td>
      <td><c:out value="${appUser.phoneNumber}"/></td>
     <td><c:out value="${appUser.role}"/></td>
     <td><a href="car/update-appUser.html"/>Update</td>
  </tr>
  </c:forEach>
</table>
 <nav aria-label="Page navigation example">
  <ul class="pagination">
  <c:if test="${currentPage + 1 == pageCount && pageCount == 1}">
      <li class="page-item disabled">
          <span class="page-link">Previous</span>
      </li>
        <li class="page-item disabled">
                <span class="page-link">Next</span>
            </li>
    </c:if>
    <c:if test="${currentPage + 1 == 1 && currentPage + 1 < pageCount}">
      <li class="page-item disabled">
          <span class="page-link">Previous</span>
      </li>
        <li class="page-item"><a class="page-link" href="appUsers-list.html?pageNumber=${currentPage + 1}">Next</a></li>
    </c:if>
    <c:if test="${currentPage + 1 > 1 && currentPage + 1 < pageCount}">
      <li class="page-item"><a class="page-link" href="appUsers-list.html?pageNumber=${currentPage - 1}">Previous</a></li>
      <li class="page-item"><a class="page-link" href="appUsers-list.html?pageNumber=${currentPage + 1}">Next</a></li>
    </c:if>
    <c:if test="${currentPage + 1 == pageCount && currentPage + 1 > 1}">
      <li class="page-item"><a class="page-link" href="appUsers-list.html?pageNumber=${currentPage - 1}">Previous</a></li>
      <li class="page-item disabled">
              <span class="page-link">Next</span>
      </li>
    </c:if>
    </ul>
  </nav>

<jsp:include page="_footer.jsp"/>