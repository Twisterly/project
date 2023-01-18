<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Brands</h1>

<table style="width:100%" class="table">
  <tr>
    <th>Brand Name</th>
  </tr>
  <c:forEach items="${brands}" var="brand">
  <tr>
    <td><c:out value="${brand}"/></td>
  </tr>
  </c:forEach>
</table>

<jsp:include page="_footer.jsp"/>