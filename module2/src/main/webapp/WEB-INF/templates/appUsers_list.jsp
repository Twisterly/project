<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>

<h1>All users:</h1>
<table style="width:100%" class="table table-hover">
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
     <td>
     <button type="button" class="btn btn-light"><a href="/car/update-appUser.html?appUserId=${appUser.id}">
         <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
         <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
          </svg></button>
      </td>
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