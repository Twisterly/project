<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Create order</h1>

<form method="post" action="/car/create-order.html?carId=${car.id}" enctype="multipart/form-data">
<div class="col-md-6">
       <label for="car.id">Choose a car:</label>
       <select class="form-select" id="car.id" name="car.id">
         <c:forEach items="${cars}" var="car">
         <option value="${car.id}">${car.brand.brandName} ${car.modelDetail.modelName} ${car.transmissionType.transmissionTypeName}</option>
         </c:forEach>
       </select>
       </div>

 <div class="col-md-2">
            <label for="startDate" class="form-label">start Date</label>
            <input type="date" name="startDate" class="form-control" id="startDate" aria-describedby="nameHelp">
            <div id="nameHelp" class="form-text">Enter start Date</div>
           </div>

<div class="col-md-2">
              <label for="endDate" class="form-label">end Date</label>
              <input type="date" name="endDate" class="form-control" id="endDate" aria-describedby="nameHelp">
              <div id="nameHelp" class="form-text">Enter end Date</div>
              </div>

<input name="appUser.id" id="appUser.id" value="${userId}" type="hidden">


<button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="_footer.jsp"/>