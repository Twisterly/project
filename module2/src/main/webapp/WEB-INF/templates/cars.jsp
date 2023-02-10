<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>All cars:</h1>
<table style="width:100%" class="table table-bordered">
  <tr>
    <th>Photo</th>
    <th>id</th>
    <th>Seats</th>
    <th>Doors</th>
    <th>Color</th>
    <th>Year</th>
    <th>Price</th>
  </tr>
  <c:forEach items="${freeCars}" var="car">
  <tr>
  <td><image height="100" width="100" src="/car/image/${car.id}/photo.jpg" class="img-thumbnail"></td>
    <td><c:out value="${car.id}"/></td>
    <td><c:out value="${car.seats}"/></td>
    <td><c:out value="${car.doors}"/></td>
    <td><c:out value="${car.color}"/></td>
    <td><c:out value="${car.year}"/></td>
    <td><c:out value="${car.price}"/></td>
  </tr>
  </c:forEach>
</table>

<jsp:include page="_footer.jsp"/>