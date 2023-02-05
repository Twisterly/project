<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>Choose car:</h1>
<table style="width:100%">
  <tr>
    <th>Select</th>
    <th>Brand</th>
    <th>Model</th>
    <th>Body Type</th>
    <th>Transmission Type</th>
    <th>Fuel Type</th>
    <th>Climate Control</th>
    <th>Seats</th>
    <th>Doors</th>
    <th>Color</th>
    <th>Year</th>
    <th>Price</th>
  </tr>
  <c:forEach items="${cars}" var="car">
  <tr>
  <td>
  <div class="form-check">
    <input class="form-check-input" type="checkbox" value="${car}" id="flexCheckDefault">
    <label class="form-check-label" for="flexCheckDefault">
    </label>
  </div>
    <td><c:out value="${car.brand.brandName}"/></td>
    <td><c:out value="${car.modelDetail.modelName}"/></td>
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
  </tr>
  </c:forEach>
</table>
</nav>