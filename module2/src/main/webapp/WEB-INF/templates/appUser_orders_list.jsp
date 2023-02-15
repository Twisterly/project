<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>All your orders:</h1>
<table style="width:100%" class="table table-hover">
  <tr>
    <th>Car Photo</th>
    <th>AppOrder Id</th>
    <th>Time of order</th>
    <th>Start date</th>
    <th>End date</th>
    <th>Total sum</th>
    <th>Status</th>
    <th>Car brand</th>
    <th>Car model</th>
    <th>Car body type</th>
    <th>Car transmission type</th>
    <th>Car fuel type</th>
    <th>AppUser username</th>
    <th>Actions</th>
  </tr>
  <tr>
  <c:forEach items="${appOrders}" var="appOrder">
    <td><image height="100" width="100" src="/car/image/${appOrder.car.id}/photo.jpg" class="img-thumbnail"></td>
    <td><c:out value="${appOrder.id}"/></td>
    <td><c:out value="${appOrder.timeOfOrder}"/></td>
    <td><c:out value="${appOrder.startDate}"/></td>
    <td><c:out value="${appOrder.endDate}"/></td>
    <td><c:out value="${appOrder.totalSum}"/></td>
    <td>
<c:if test="${appOrder.cancellation == true}">
<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-sign-stop-fill" viewBox="0 0 16 16">
  <path d="M10.371 8.277v-.553c0-.827-.422-1.234-.987-1.234-.572 0-.99.407-.99 1.234v.553c0 .83.418 1.237.99 1.237.565 0 .987-.408.987-1.237Zm2.586-.24c.463 0 .735-.272.735-.744s-.272-.741-.735-.741h-.774v1.485h.774Z"/>
  <path d="M4.893 0a.5.5 0 0 0-.353.146L.146 4.54A.5.5 0 0 0 0 4.893v6.214a.5.5 0 0 0 .146.353l4.394 4.394a.5.5 0 0 0 .353.146h6.214a.5.5 0 0 0 .353-.146l4.394-4.394a.5.5 0 0 0 .146-.353V4.893a.5.5 0 0 0-.146-.353L11.46.146A.5.5 0 0 0 11.107 0H4.893ZM3.16 10.08c-.931 0-1.447-.493-1.494-1.132h.653c.065.346.396.583.891.583.524 0 .83-.246.83-.62 0-.303-.203-.467-.637-.572l-.656-.164c-.61-.147-.978-.51-.978-1.078 0-.706.597-1.184 1.444-1.184.853 0 1.386.475 1.436 1.087h-.645c-.064-.32-.352-.542-.797-.542-.472 0-.77.246-.77.6 0 .261.196.437.553.522l.654.161c.673.164 1.06.487 1.06 1.11 0 .736-.574 1.228-1.544 1.228Zm3.427-3.51V10h-.665V6.57H4.753V6h3.006v.568H6.587Zm4.458 1.16v.544c0 1.131-.636 1.805-1.661 1.805-1.026 0-1.664-.674-1.664-1.805V7.73c0-1.136.638-1.807 1.664-1.807 1.025 0 1.66.674 1.66 1.807ZM11.52 6h1.535c.82 0 1.316.55 1.316 1.292 0 .747-.501 1.289-1.321 1.289h-.865V10h-.665V6.001Z"/>
</svg>
</c:if>
<c:if test="${appOrder.cancellation == false}">
<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-circle" viewBox="0 0 16 16">
  <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
  <path d="M10.97 4.97a.235.235 0 0 0-.02.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-1.071-1.05z"/>
</svg>
</c:if></td>
    <td><c:out value="${appOrder.car.brand.brandName}"/></td>
    <td><c:out value="${appOrder.car.modelDetail.modelName}"/></td>
    <td><c:out value="${appOrder.car.bodyType.bodyTypeName}"/></td>
    <td><c:out value="${appOrder.car.transmissionType.transmissionTypeName}"/></td>
    <td><c:out value="${appOrder.car.fuelType.fuelTypeName}"/></td>
    <td><c:out value="${appOrder.appUser.username}"/></td>
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
<jsp:include page="_footer.jsp"/>