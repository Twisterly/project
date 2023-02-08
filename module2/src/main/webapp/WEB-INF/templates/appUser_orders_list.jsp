<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>All your orders:</h1>
<table style="width:100%" class="table table-bordered">
  <tr>
    <th>AppOrder Id</th>
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
    <thStatus</th>
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
    <td></td>
    <td>
    <input name="car.id" id="car.id" value="${car.id}" type="hidden">
    <input name="appUser.id" id="appUser.id" value="${appUser.id}" type="hidden">
    <input name="appOrder.id" id="appOrder.id" value="${appOrder.id}" type="hidden">
    <button type="button" class="btn btn-light"><a href="/car/update-order.html?appOrderId=${appOrder.id}">
    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
    <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
     </svg></button>
     <button type="button" class="btn btn-light"><a href="/car/order.html?appOrderId=${appOrder.id}"/>
     <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-book" viewBox="0 0 16 16">
            <path d="M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811V2.828zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"/>
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
      <li class="page-item"><a class="page-link" href="appUser-orders.html?pageNumber=${currentPage + 1}">Next</a></li>
  </c:if>
  <c:if test="${currentPage + 1 > 1 && currentPage + 1 < pageCount}">
    <li class="page-item"><a class="page-link" href="appUser-orders.html?pageNumber=${currentPage - 1}">Previous</a></li>
    <li class="page-item"><a class="page-link" href="appUser-orders.html?pageNumber=${currentPage + 1}">Next</a></li>
  </c:if>
  <c:if test="${currentPage + 1 == pageCount && currentPage + 1 > 1}">
    <li class="page-item"><a class="page-link" href="appUser-orders.html?pageNumber=${currentPage - 1}">Previous</a></li>
    <li class="page-item disabled">
            <span class="page-link">Next</span>
    </li>
  </c:if>
  </ul>
</nav>
<span>Current page:
<c:out value="${currentPage}"/>
</span>
<span>Page count:
<c:out value="${pageCount}"/>
</span>
<button type="button" class="btn btn-light"><a href="appUser-orders.html?pageNumber=${currentPage + 1}">next</a></button>
</nav>
<jsp:include page="_footer.jsp"/>