<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>

<h1>Update car</h1>
<form method="post" action="/car/update-car.html?carId=${carId}" enctype="multipart/form-data">
     <!-- photo -->
     <div class="col-md-6">
          <label for="photo" class="form-label">Photo</label>
          <image height="100" width="100" src="/car/image/${carId}/photo.jpg" class="img-thumbnail">
     </div>
     <!-- brand -->
              <div class="col-md-6">
                <label for="brand.id">update brand:</label>
                <select class="form-select" id="brand.id" name="brand.id">
                 <c:forEach items="${brands}" var="brand">
                 <c:if test="${brand.id == car.brand.id}">
                 <option selected="selected" value="${brand.id}">${brand.brandName}</option>
                  </c:if>
                 <c:if test="${brand.id != car.brand.id}">
                 <option value="${brand.id}">${brand.brandName}</option>
                  </c:if>
                 </c:forEach>
               </select>
              </div>
     <!-- model -->
      <div class="col-md-6">
                    <label for="modelDetail.id">update model:</label>
                    <select class="form-select" id="modelDetail.id" name="modelDetail.id">
                     <c:forEach items="${modelDetails}" var="modelDetail">
                     <c:if test="${modelDetail.id == car.modelDetail.id}">
                     <option selected="selected" value="${modelDetail.id}">${modelDetail.modelName}</option>
                     </c:if>
                     <c:if test="${modelDetail.id != car.modelDetail.id}">
                     <option value="${modelDetail.id}">${modelDetail.modelName}</option>
                     </c:if>
                     </c:forEach>
                   </select>
                  </div>
     <!-- bodyType -->
     <div class="col-md-6">
      <label for="bodyType.id">update body Type:</label>
      <select class="form-select" id="bodyType.id" name="bodyType.id">
       <c:forEach items="${bodyTypes}" var="bodyType">
         <c:if test="${bodyType.id == car.bodyType.id}">
           <option selected="selected" value="${bodyType.id}">${bodyType.bodyTypeName}</option>
          </c:if>
           <c:if test="${bodyType.id != car.bodyType.id}">
            <option value="${bodyType.id}">${bodyType.bodyTypeName}</option>
             </c:if>
             </c:forEach>
              </select>
            </div>
            <!-- bodyType -->
                 <div class="col-md-6">
                  <label for="fuelType.id">update fuel Type:</label>
                  <select class="form-select" id="fuelType.id" name="fuelType.id">
                   <c:forEach items="${fuelTypes}" var="fuelType">
                     <c:if test="${fuelType.id == car.fuelType.id}">
                       <option selected="selected" value="${fuelType.id}">${fuelType.fuelTypeName}</option>
                      </c:if>
                       <c:if test="${fuelType.id != car.fuelType.id}">
                        <option value="${fuelType.id}">${fuelType.fuelTypeName}</option>
                         </c:if>
                         </c:forEach>
                          </select>
                        </div>
     <!-- transmissionType -->
     <div class="col-md-6">
          <label for="transmissionType.id">update transmission Type:</label>
          <select class="form-select" id="transmissionType.id" name="transmissionType.id">
           <c:forEach items="${transmissionTypes}" var="transmissionType">
             <c:if test="${transmissionType.id == car.transmissionType.id}">
               <option selected="selected" value="${transmissionType.id}">${transmissionType.transmissionTypeName}</option>
              </c:if>
               <c:if test="${transmissionType.id != car.transmissionType.id}">
                <option value="${transmissionType.id}">${transmissionType.transmissionTypeName}</option>
                 </c:if>
                 </c:forEach>
                  </select>
                </div>
     <!-- doors -->
     <div class="col-md-6">
           <label for="doors" class="form-label">Doors</label>
                <input value="${car.doors}" type="number" name="doors" class="form-control" id="doors" aria-describedby="nameHelp">
                <div id="nameHelp" class="form-text">Enter doors</div>
               </div>
      <!-- seats -->
      <div class="col-md-6">
       <label for="seats" class="form-label">Seats</label>
         <input value="${car.seats}" type="number" name="seats" class="form-control" id="seats" aria-describedby="nameHelp">
         <div id="nameHelp" class="form-text">Enter seats</div>
        </div>
     <!-- climateControl -->
       <div class="col-md-6">
    <label for="climateControl" class="form-label">Climate control</label><br/>
        <div class="form-check form-check-inline">
        <c:if test="${car.climateControl == true}">
           <input class="form-check-input" type="radio" name="climateControl" id="climateControl1" value="true" checked>
           <label class="form-check-label" for="climateControl1">yes</label>
           <div class="form-check form-check-inline">
           <input class="form-check-input" type="radio" name="climateControl" id="climateControl2" value="false">
           <label class="form-check-label" for="climateControl2">no</label>
        </c:if>
         </div>
       </div>
         <c:if test="${car.climateControl == false}">
         <div class="form-check form-check-inline">
           <input class="form-check-input" type="radio" name="climateControl" id="climateControl1" value="true">
            <label class="form-check-label" for="climateControl1">yes</label>
            <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="climateControl" id="climateControl2" value="false" checked>
              <label class="form-check-label" for="climateControl2">no</label>
         </c:if>
         </div>
      </div>
         <br/>
     <!-- price -->
    <div class="col-md-6">
          <label for="price" class="form-label">Price</label>
            <input value="${car.price}" type="number" name="price" class="form-control" id="price" aria-describedby="nameHelp">
            <div id="nameHelp" class="form-text">Enter price</div>
           </div>
      <!-- color -->
       <div class="col-md-6">
       <label for="color" class="form-label">Color</label>
            <input value="${car.color}" type="text" name="color" class="form-control" id="color" aria-describedby="nameHelp">
            <div id="nameHelp" class="form-text">Enter color</div>
           </div>
<button type="submit" class="btn btn-primary">Update</button>
</form>

<jsp:include page="_footer.jsp"/>