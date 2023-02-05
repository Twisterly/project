<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>All orders:</h1>
<table style="width:100%" class="table table-bordered">
  <tr>
    <th>Start date</th>
    <th>End date</th>
    <th>Total</th>
    <th>Car id</th>
  </tr>
  <c:forEach items="${appOrders}" var="appOrder">
  <tr>
  <td><c:out value="${appOrder.startDate}"/></td>
  <td><c:out value="${appOrder.endDate}"/></td>
  <td><c:out value="${appOrder.totalSum}"/></td>
  <td><c:out value="${appOrder.car.id}"/></td>
     </td>
  </tr>
  </c:forEach>
</table>
</nav>
<jsp:include page="_footer.jsp"/>