<jsp:include page="_header.jsp"/>
<h1>"${appUser.username}" Welcome to personal area</h1>
<li class="nav-item">
    <a class="nav-link" href="#">About you</a>
<ul class="nav nav-pills nav-fill">
  <li class="nav-item">
    <a class="nav-link active" aria-current="page" href="#">Orders</a>
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
    <td><c:out value="${appOrder.car}"/></td>
  </tr>
</table>

  </li>
</ul>
<jsp:include page="_footer.jsp"/>