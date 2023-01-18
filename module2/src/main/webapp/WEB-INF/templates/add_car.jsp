<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Add car</h1>

<form method="post" action="/car/add-car.html" enctype="multipart/form-data">
  <div class="mb-3">
      <label for="photo" class="form-label">Photo</label>
      <input type="file" name="photo" class="form-control" id="photo">
  </div>
  <!-- brand -->
         <div class="mb-3">
           <label for="brand.id">Choose a brand:</label>
           <select class="form-select" id="brand.id" name="brand.id">
            <c:forEach items="${brands}" var="brand">
            <option value="${brand.id}">${brand.brandName}</option>
            </c:forEach>
          </select>
         </div>
  <!-- model -->
    <div class="mb-3">
       <label for="modelDetail.id">Choose a model:</label>
       <select class="form-select" id="modelDetail.id" name="modelDetail.id">
         <c:forEach items="${modelDetails}" var="modelDetail">
         <option value="${modelDetail.id}">${modelDetail.modelName}</option>
         </c:forEach>
       </select>
       </div>
<!-- body type -->
   <div class="mb-3">
      <label for="bodyType.id">Choose a body type:</label>
      <select class="form-select" id="bodyType.id" name="bodyType.id">
        <c:forEach items="${bodyTypes}" var="bodyType">
        <option value="${bodyType.id}">${bodyType.bodyTypeName}</option>
        </c:forEach>
      </select>
      </div>
<!-- fuel type -->
   <div class="mb-3">
      <label for="fuelType.id">Choose a fuel type:</label>
      <select class="form-select" id="fuelType.id" name="fuelType.id">
        <c:forEach items="${fuelTypes}" var="fuelType">
        <option value="${fuelType.id}">${fuelType.fuelTypeName}</option>
        </c:forEach>
      </select>
      </div>
<!-- transmission type -->
   <div class="mb-3">
      <label for="transmissionType.id">Choose a transmission type:</label>
      <select class="form-select" id="transmissionType.id" name="transmissionType.id">
        <c:forEach items="${transmissionTypes}" var="transmissionType">
        <option value="${transmissionType.id}">${transmissionType.transmissionTypeName}</option>
        </c:forEach>
      </select>
      </div>
  <!-- regNumber -->
  <div class="mb-3">
      <label for="regNumber" class="form-label">Registration Number</label>
      <input type="text" name="regNumber" class="form-control" id="regNumber" aria-describedby="nameHelp">
      <div id="nameHelp" class="form-text">Enter Registration name</div>
  </div>
   <!-- vinNumber -->
    <div class="mb-3">
     <label for="vinNumber" class="form-label">VIN Number</label>
     <input type="text" name="vinNumber" class="form-control" id="vinNumber" aria-describedby="nameHelp">
     <div id="nameHelp" class="form-text">Enter VIN Number</div>
    </div>
    <!-- price -->
     <div class="mb-3">
      <label for="price" class="form-label">Price</label>
      <input type="number" name="price" class="form-control" id="price" aria-describedby="nameHelp">
      <div id="nameHelp" class="form-text">Enter price</div>
     </div>
     <!-- year -->
      <div class="mb-3">
        <label for="year" class="form-label">Year</label>
        <input type="text" name="year" class="form-control" id="year" aria-describedby="nameHelp">
        <div id="nameHelp" class="form-text">Enter year</div>
      </div>
     <!-- color -->
     <div class="mb-3">
      <label for="color" class="form-label">Color</label>
      <input type="text" name="color" class="form-control" id="color" aria-describedby="nameHelp">
      <div id="nameHelp" class="form-text">Enter color</div>
     </div>



    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
<jsp:include page="_footer.jsp"/>