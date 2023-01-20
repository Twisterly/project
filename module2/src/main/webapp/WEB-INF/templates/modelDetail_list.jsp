<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Models</h1>

<table style="width:100%" class="table">
  <tr>
    <th>Model Name</th>
  </tr>
  <c:forEach items="${modelDetails}" var="modelDetail">
  <tr>
    <td><c:out value="${modelDetail}"/></td>
  </tr>
  </c:forEach>
</table>

<jsp:include page="_footer.jsp"/>