<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Search car</h1>

<form method="post" action="/car/add-filter.html" enctype="multipart/form-data">
  <!-- brand -->
<div class="mb-3">
    <label for="brand" class="form-label">Brand name</label>
    <input type="text" name="brand" class="form-control" id="brand" aria-describedby="nameHelp">
    <div id="nameHelp" class="form-text">Enter brand name</div>
  </div>
    <!-- model -->
    <div class="mb-3">
        <label for="modelDetail" class="form-label">Model name</label>
        <input type="text" name="modelDetail" class="form-control" id="modelDetail" aria-describedby="nameHelp">
        <div id="nameHelp" class="form-text">Enter model</div>
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
 <!-- body type -->
  <div class="mb-3">
         <label for="bodyType" class="form-label">Body type</label>
         <input type="text" name="bodyType" class="form-control" id="bodyType" aria-describedby="nameHelp">
         <div id="nameHelp" class="form-text">Enter body Type</div>
       </div>
  <!-- fuel type -->
    <div class="mb-3">
             <label for="fuelType" class="form-label">Fuel type</label>
             <input type="text" name="fuelType" class="form-control" id="fuelType" aria-describedby="nameHelp">
             <div id="nameHelp" class="form-text">Enter fuel Type</div>
           </div>
  <!-- transmission type -->
    <div class="mb-3">
             <label for="transmissionType" class="form-label">transmission Type</label>
             <input type="text" name="transmissionType" class="form-control" id="transmissionType" aria-describedby="nameHelp">
             <div id="nameHelp" class="form-text">Enter transmission Type</div>
           </div>
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

    <button type="submit" class="btn btn-primary">Search</button>
  </form>
<jsp:include page="_footer.jsp"/>