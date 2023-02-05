<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Do you want to delete this order?</h1>
<form method="post" action="/car/delete-order.html?appOrderId=${appOrder.id}"" enctype="multipart/form-data">
  <p>Order # ${appOrder.id}</p>
  <p>Start from ${appOrder.startDate} till ${appOrder.endDate}</p>
  <p>Total sum: ${appOrder.totalSum}</p>
  <p>Username: ${appUser.username}</p>
  <p>Car: ${car.brand.brandName} ${car.modelDetail.modelName}</p>
<input name="appOrder.id" id="appOrder.id" value="${appOrder.id}" type="hidden">
<button type="submit" class="btn btn-light">DELETE</button>
</form>
<button type="button" class="btn btn-light">RETURN<a href="car/index.html"/></button>

<jsp:include page="_footer.jsp"/>