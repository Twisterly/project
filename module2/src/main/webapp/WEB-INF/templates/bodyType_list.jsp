<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Body Types</h1>

<table style="width:100%" class="table">
  <tr>
    <th>Body Type Name</th>
  </tr>
  <c:forEach items="${bodyTypes}" var="bodyType">
  <tr>
    <td><c:out value="${bodyType}"/></td>
  </tr>
  </c:forEach>
</table>

<jsp:include page="_footer.jsp"/>