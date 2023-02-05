<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>All orders:</h1>
<table style="width:100%" class="table table-bordered">
  <tr>
    <th>Id</th>
    <th>Time of order</th>
    <th>Start date</th>
    <th>End date</th>
    <th>Total sum</th>
    <th>Car id</th>
    <th>Car brand</th>
    <th>Car model</th>
    <th>Car body type</th>
    <th>Car transmission type</th>
    <th>Car fuel type</th>
    <th>AppUser id</th>
    <th>AppUser username</th>
    <th>Actions</th>
  </tr>
  <c:forEach items="${appOrders}" var="appOrder">
  <tr>
    <td><c:out value="${appOrder.id}"/></td>
    <td><c:out value="${appOrder.timeOfOrder}"/></td>
    <td><c:out value="${appOrder.startDate}"/></td>
    <td><c:out value="${appOrder.endDate}"/></td>
    <td><c:out value="${appOrder.totalSum}"/></td>
    <td><c:out value="${appOrder.car.id}"/></td>
    <td><c:out value="${appOrder.car.brand.brandName}"/></td>
    <td><c:out value="${appOrder.car.modelDetail.modelName}"/></td>
    <td><c:out value="${appOrder.car.bodyType.bodyTypeName}"/></td>
    <td><c:out value="${appOrder.car.transmissionType.transmissionTypeName}"/></td>
    <td><c:out value="${appOrder.car.fuelType.fuelTypeName}"/></td>
    <td><c:out value="${appOrder.appUser.id}"/></td>
    <td><c:out value="${appOrder.appUser.username}"/></td>
    <td>
    <input name="car.id" id="car.id" value="${car.id}" type="hidden">
    <input name="appUser.id" id="appUser.id" value="${appUser.id}" type="hidden">
    <input name="appOrder.id" id="appOrder.id" value="${appOrder.id}" type="hidden">
    <button type="button" class="btn btn-light"><a href="car/edit-order.html?carId=${car.id}">
    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
    <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
     </svg></button>
     <button type="button" class="btn btn-light"><a href="/car/delete-order.html?appOrderId=${appOrder.id}"/>
     <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
       <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"/>
     </svg></button>
     </td>
  </tr>
  </c:forEach>
</table>
</nav>
<jsp:include page="_footer.jsp"/>