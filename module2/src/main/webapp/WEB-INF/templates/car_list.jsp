<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Cars</h1>
<div class="card-group">
<c:forEach items="${cars}" var="car">
 <div class="card" style="width: 18rem;">
 <image src="/car/image/${car.id}/photo.jpg" class="img-thumbnail">
     <div class="card-body">
     <h5 class="card-title"><c:out value="${car.brand.brandName}"/></h5>
          <h6 class="card-title"><c:out value="${car.regNumber}"/></h6>
          <h6 class="card-title"><c:out value="${car.price}"/></h6>
          <h6 class="card-title"><image src="door.jpg" class="img-thumbnail"><c:out value="${car.doors}"/></h6>
          <h6 class="card-title"><c:out value="${car.vinNumber}"/></h6>
          <h6 class="card-title"><c:out value="${car.year}"/></h6>
          <h6 class="card-title"><c:out value="${car.color}"/></h6>
          <h6 class="card-title"><c:out value="${car.bodyType.bodyTypeName}"/></h6>
          <h6 class="card-title"><c:out value="${car.fuelType.fuelTypeName}"/></h6>
          <a href="#" class="btn btn-primary">Book</a>
    </div>
  </div>
</c:forEach>
</div>
<jsp:include page="_footer.jsp"/>