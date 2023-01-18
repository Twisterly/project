<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Cars</h1>

<table style="width:100%" class="table">
  <tr>
    <th>Brand</th>
    <th>Registration Number</th>
    <th>VIN Number</th>
    <th>Price</th>
    <th>Year</th>
    <th>Color</th>
    <th>Model</th>
    <th>Body type</th>
    <th>Fuel type</th>
    <th>Photo</th>
  </tr>
  <c:forEach items="${cars}" var="car">
  <tr>
    <td><c:out value="${car.brand.brandName}"/></td>
     <td><c:out value="${brand.modelDetail.modelName}"/></td>
    <td><c:out value="${car.regNumber}"/></td>
    <td><c:out value="${car.vinNumber}"/></td>
    <td><c:out value="${car.price}"/></td>
    <td><c:out value="${car.year}"/></td>
    <td><c:out value="${car.color}"/></td>
    <td><c:out value="${car.bodyType.bodyTypeName}"/></td>
    <td><c:out value="${car.fuelType.fuelTypeName}"/></td>
    <td><image src="/car/image/${car.id}/photo.jpg" class="img-thumbnail"><td>
  </tr>
  </c:forEach>
</table>

<jsp:include page="_footer.jsp"/>