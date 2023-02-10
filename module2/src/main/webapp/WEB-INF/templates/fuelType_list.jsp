<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Fuel Types</h1>

<table style="width:100%" class="table table-hover">
  <tr>
    <th>Fuel Type Name</th>
  </tr>
  <c:forEach items="${fuelTypes}" var="fuelType">
  <tr>
    <td><c:out value="${fuelType}"/></td>
  </tr>
  </c:forEach>
</table>

<jsp:include page="_footer.jsp"/>