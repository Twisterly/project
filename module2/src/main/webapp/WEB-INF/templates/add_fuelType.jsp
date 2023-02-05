<jsp:include page="_header.jsp"/>
<h1>Add new fuel type</h1>

<form method="post" action="/car/add-fuelType.html">
  <div class="col-md-6">
    <label for="fuelTypeName" class="form-label">Fuel type name</label>
    <input type="text" name="fuelTypeName" class="form-control" id="fuelTypeName" aria-describedby="nameHelp">
    <div id="nameHelp" class="form-text">Enter fuel type name</div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="_footer.jsp"/>