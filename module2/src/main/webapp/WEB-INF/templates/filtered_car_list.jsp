<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Searched cars:</h1>
<table style="width:100%" class="table table-bordered">
  <tr>
    <th>Photo</th>
    <th>Brand</th>
    <th>Model</th>
    <th>Registration number</th>
    <th>Body Type</th>
    <th>Transmission Type</th>
    <th>Fuel Type</th>
    <th>Climate Control</th>
    <th>Seats</th>
    <th>Doors</th>
    <th>Color</th>
    <th>Year</th>
    <th>Price</th>
    <th>Actions</th>
  </tr>
  <c:forEach items="${cars}" var="car">
  <tr>
  <td><image height="100" width="100" src="/car/image/${car.id}/photo.jpg" class="img-thumbnail"></td>
    <td><c:out value="${car.brand.brandName}"/></td>
    <td><c:out value="${car.modelDetail.modelName}"/></td>
    <td><c:out value="${car.regNumber}"/></td>
    <td><c:out value="${car.bodyType.bodyTypeName}"/></td>
    <td><c:out value="${car.transmissionType.transmissionTypeName}"/></td>
    <td><c:out value="${car.fuelType.fuelTypeName}"/></td>
    <td><c:if test="${car.climateControl == true}">
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus" viewBox="0 0 16 16">
          <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
        </svg>
    </c:if>
    <c:if test="${car.climateControl == false}">
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-dash" viewBox="0 0 16 16">
          <path d="M4 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 4 8z"/>
        </svg>
    </c:if>
    </td>
    <td><c:out value="${car.seats}"/></td>
    <td><c:out value="${car.doors}"/></td>
    <td><c:out value="${car.color}"/></td>
    <td><c:out value="${car.year}"/></td>
    <td><c:out value="${car.price}"/></td>
    <td>
    <input name="car.id" id="car.id" value="${car.id}" type="hidden">

    <c:if test="${role == 2}">
    <button type="button" hidden="true" class="btn btn-light"><a href="update-car.html?carId=${car.id}">
    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
    <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
     </svg></button>
     <button type="button" hidden="true" class="btn btn-light"><a href="delete-car.html"/>
     <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
       <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"/>
     </svg></button>
     <button type="button" class="btn btn-light"> <a href="create-order-from-car-list.html?carId=${car.id}"/>Book
           </button>
</c:if>
<c:if test="${role == 1}">
 <button type="button" class="btn btn-light"><a href="update-car.html?carId=${car.id}">
    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
    <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
     </svg></button>
     <button type="button" class="btn btn-light"><a href="delete-car.html"/>
     <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
       <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"/>
     </svg></button>
     <button type="button" class="btn btn-light"> <a href="create-order-from-car-list.html?carId=${car.id}"/>Book
           </button>
</c:if>

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
        <li class="page-item"><a class="page-link" href="searching-results.html?pageNumber=${currentPage + 1}">Next</a></li>
    </c:if>
    <c:if test="${currentPage + 1 > 1 && currentPage + 1 < pageCount}">
      <li class="page-item"><a class="page-link" href="searching-results.html?pageNumber=${currentPage - 1}">Previous</a></li>
      <li class="page-item"><a class="page-link" href="searching-results.html?pageNumber=${currentPage + 1}">Next</a></li>
    </c:if>
    <c:if test="${currentPage + 1 == pageCount && currentPage + 1 > 1}">
      <li class="page-item"><a class="page-link" href="searching-results.html?pageNumber=${currentPage - 1}">Previous</a></li>
      <li class="page-item disabled">
              <span class="page-link">Next</span>
      </li>
    </c:if>
    </ul>
  </nav>
<jsp:include page="_footer.jsp"/>