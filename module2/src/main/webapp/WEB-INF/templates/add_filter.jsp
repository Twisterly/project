<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Search car</h1>

<form method="post" action="/car/add-filter.html" enctype="multipart/form-data">
  <!-- brand -->
<!-- brand -->
         <div class="col-md-6">
           <label for="brand">Choose a brand:</label>
           <select class="form-select" id="brand" name="brand">
           <option value="${null}">${null}</option>
            <c:forEach items="${brands}" var="brand">
            <option value="${brand}">${brand}</option>
            </c:forEach>
          </select>
         </div>
   <!-- model -->
       <div class="col-md-6">
          <label for="modelDetail">Choose a model:</label>
          <select class="form-select" id="modelDetail" name="modelDetail">
            <option value="${null}">${null}</option>
            <c:forEach items="${modelDetails}" var="modelDetail">
            <option value="${modelDetail}">${modelDetail}</option>
            </c:forEach>
          </select>
          </div>
  <!-- fuel type -->
     <div class="col-md-6">
        <label for="fuelType">Choose a fuel type:</label>
        <select class="form-select" id="fuelType" name="fuelType">
        <option value="${null}">${null}</option>
          <c:forEach items="${fuelTypes}" var="fuelType">
          <option value="${fuelType}">${fuelType}</option>
          </c:forEach>
        </select>
        </div>
  <!-- transmission type -->
     <div class="col-md-6">
        <label for="transmissionType">Choose a transmission type:</label>
        <select class="form-select" id="transmissionType" name="transmissionType">
        <option value="${null}">${null}</option>
          <c:forEach items="${transmissionTypes}" var="transmissionType">
          <option value="${transmissionType}">${transmissionType}</option>
          </c:forEach>
        </select>
        </div>
  <!-- doors -->
       <div class="col-md-6">
          <label for="doors">Choose doors:</label>
          <select class="form-select" id="doors" name="doors">
          <option value="${null}">${null}</option>
            <c:forEach items="${doorsList}" var="doors">
            <option value="${doors}">${doors}</option>
            </c:forEach>
          </select>
          </div>
  <!-- seats -->
            <div class="col-md-6">
               <label for="seats">Choose seats:</label>
               <select class="form-select" id="seats" name="seats">
               <option value="${null}">${null}</option>
                 <c:forEach items="${seatsList}" var="seats">
                 <option value="${seats}">${seats}</option>
                 </c:forEach>
               </select>
               </div>
<input name="carFilter" id="carFilter" value="${carFilter}" type="hidden">
<button type="submit" class="btn btn-primary">Search</button>
</form>
<jsp:include page="_footer.jsp"/>