<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Transmission Types</h1>

<table style="width:100%" class="table table-hover">
  <tr>
    <th>Transmission Type Name</th>
  </tr>
  <c:forEach items="${transmissionTypes}" var="transmissionType">
  <tr>
    <td><c:out value="${transmissionType}"/></td>
  </tr>
  </c:forEach>
</table>

<jsp:include page="_footer.jsp"/>