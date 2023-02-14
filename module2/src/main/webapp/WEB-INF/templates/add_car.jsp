<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Add car</h1>

<form method="post" action="/car/add-car.html" enctype="multipart/form-data">
  <div class="col-md-6">
      <label for="photo" class="form-label">Photo</label>
      <input type="file" name="photo" class="form-control" id="photo">
  </div>
  <!-- brand -->
         <div class="col-md-6">
           <label for="brand.id">Choose a brand:</label>
           <select class="form-select" id="brand.id" name="brand.id">
            <c:forEach items="${brands}" var="brand">
            <option value="${brand.id}">${brand.brandName}</option>
            </c:forEach>
          </select>
         </div>
  <!-- model -->
    <div class="col-md-6">
       <label for="modelDetail.id">Choose a model:</label>
       <select class="form-select" id="modelDetail.id" name="modelDetail.id">
         <c:forEach items="${modelDetails}" var="modelDetail">
         <option value="${modelDetail.id}">${modelDetail.modelName}</option>
         </c:forEach>
       </select>
       </div>
<!-- body type -->
   <div class="col-md-6">
      <label for="bodyType.id">Choose a body type:</label>
      <select class="form-select" id="bodyType.id" name="bodyType.id">
        <c:forEach items="${bodyTypes}" var="bodyType">
        <option value="${bodyType.id}">${bodyType.bodyTypeName}</option>
        </c:forEach>
      </select>
      </div>
<!-- fuel type -->
   <div class="col-md-6">
      <label for="fuelType.id">Choose a fuel type:</label>
      <select class="form-select" id="fuelType.id" name="fuelType.id">
        <c:forEach items="${fuelTypes}" var="fuelType">
        <option value="${fuelType.id}">${fuelType.fuelTypeName}</option>
        </c:forEach>
      </select>
      </div>
<!-- transmission type -->
   <div class="col-md-6">
      <label for="transmissionType.id">Choose a transmission type:</label>
      <select class="form-select" id="transmissionType.id" name="transmissionType.id">
        <c:forEach items="${transmissionTypes}" var="transmissionType">
        <option value="${transmissionType.id}">${transmissionType.transmissionTypeName}</option>
        </c:forEach>
      </select>
      </div>
  <!-- regNumber -->
  <div class="col-md-6">
      <label for="regNumber" class="form-label">Registration Number</label>
      <input type="text" name="regNumber" class="form-control" id="regNumber" aria-describedby="nameHelp" pattern="^\d{4}[A-Z]{2}[-]\d{1}$">
      <div id="nameHelp" class="form-text">Enter Registration name</div>
  </div>
   <!-- vinNumber -->
    <div class="col-md-6">
     <label for="vinNumber" class="form-label">VIN Number</label>
     <input type="text" name="vinNumber" class="form-control" id="vinNumber" aria-describedby="nameHelp" pattern="^[0123456789ABCDEFGHJKLMNPRSTUVWXYZ]{17}$">
     <div id="nameHelp" class="form-text">Enter VIN Number using only this signs 0 1 2 3 4 5 6 7 8 9 A B C D E F G H J K L M N P R S T U V W X Y Z</div>
    </div>
    <!-- price -->
     <div class="col-md-6">
      <label for="price" class="form-label">Price</label>
      <input type="number" name="price" class="form-control" id="price" aria-describedby="nameHelp" pattern="^[0-9]{2,3}$">
      <div id="nameHelp" class="form-text">Enter price</div>
     </div>
     <!-- year -->
      <div class="col-md-6">
        <label for="year" class="form-label">Year</label>
        <input type="text" name="year" class="form-control" id="year" aria-describedby="nameHelp" pattern="^[2]{1}[0]{1}[0-2]{1}[0-9]{1}$">
        <div id="nameHelp" class="form-text">Enter year</div>
      </div>
     <!-- color -->
     <div class="col-md-6">
      <label for="color" class="form-label">Color</label>
      <input type="text" name="color" class="form-control" id="color" aria-describedby="nameHelp">
      <div id="nameHelp" class="form-text">Enter color</div>
     </div>
     <!-- climateControl -->
     <label for="climateControl" class="form-label">Climate control</label><br/>
     <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" name="climateControl" id="climateControl1" value="true">
        <label class="form-check-label" for="climateControl1">yes</label>
      </div>
      <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" name="climateControl" id="climateControl2" value="false">
        <label class="form-check-label" for="climateControl2">no</label>
      </div>
      <br/>
      <!-- doors -->
           <label for="doors" class="form-label">Doors</label><br/>
           <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="doors" id="doors1" value="2">
              <label class="form-check-label" for="doors1">2</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="doors" id="doors2" value="3">
              <label class="form-check-label" for="doors2">3</label>
            </div>
             <div class="form-check form-check-inline">
             <input class="form-check-input" type="radio" name="doors" id="doors3" value="4">
             <label class="form-check-label" for="doors3">4</label>
             </div>
            <div class="form-check form-check-inline">
             <input class="form-check-input" type="radio" name="doors" id="doors4" value="5">
             <label class="form-check-label" for="doors4">5</label>
            </div>
            <br/>
      <!-- seats -->
                 <label for="seats" class="form-label">Seats</label><br/>
                 <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="seats" id="seats1" value="2">
                    <label class="form-check-label" for="seats1">2</label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="seats" id="seats2" value="3">
                    <label class="form-check-label" for="seats2">3</label>
                  </div>
                   <div class="form-check form-check-inline">
                   <input class="form-check-input" type="radio" name="seats" id="seats3" value="4">
                   <label class="form-check-label" for="seats3">4</label>
                   </div>
                  <div class="form-check form-check-inline">
                   <input class="form-check-input" type="radio" name="seats" id="seats4" value="5">
                   <label class="form-check-label" for="seats4">5</label>
                  </div>
                   <div class="form-check form-check-inline">
                     <input class="form-check-input" type="radio" name="seats" id="seats5" value="6">
                    <label class="form-check-label" for="seats5">6</label>
                     </div>
                  <div class="form-check form-check-inline">
                   <input class="form-check-input" type="radio" name="seats" id="seats6" value="7">
                   <label class="form-check-label" for="seats6">7</label>
                    </div>
                  <br/>
     <!-- active -->
    <label for="active" class="form-label">Car is</label><br/>
     <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" name="active" id="activeYES" value="1">
        <label class="form-check-label" for="activeYES">active</label>
     </div>
     <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" name="active" id="activeNO" value="0">
        <label class="form-check-label" for="activeNO">not active</label>
     </div>
     <!-- comment -->
     <div class="col-md-4">
          <label for="comment" class="form-label">Comment</label>
          <input type="text" name="comment" class="form-control" id="comment" aria-describedby="nameHelp">
          <div id="nameHelp" class="form-text">Enter comment</div>
         </div>
     <br/>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
<jsp:include page="_footer.jsp"/>