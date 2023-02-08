<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Update order</h1>

<form method="post" action="/car/update-order.html?appOrderId=${appOrder.id}" enctype="multipart/form-data">
<!-- Car -->
 <div class="col-md-6">
 <label for="car.id">Choose a car:</label>
<select class="form-select" id="car.id" name="car.id">
<c:forEach items="${cars}" var="car">
<c:if test="${car.id == appOrder.car.id}">
<option selected="selected" value="${car.id}">${car.id}</option>
</c:if>
<c:if test="${car.id != appOrder.car.id}">
<option value="${car.id}">${car.id}</option>
</c:if>
</c:forEach>
</select>
</div>
     <!-- startDate -->
 <div class="col-md-2">
            <label for="startDate" class="form-label">start Date</label>
            <input value="${appOrder.startDate}" type="date" name="startDate" class="form-control" id="startDate" aria-describedby="nameHelp">
            <div id="nameHelp" class="form-text">Enter start Date</div>
           </div>
<!-- endDate -->
<div class="col-md-2">
              <label for="endDate" class="form-label">end Date</label>
              <input value="${appOrder.endDate}" type="date" name="endDate" class="form-control" id="endDate" aria-describedby="nameHelp">
              <div id="nameHelp" class="form-text">Enter end Date</div>
              </div>

<input name="car.id" id="car.id" value="${car.id}" type="hidden">
<button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="_footer.jsp"/>