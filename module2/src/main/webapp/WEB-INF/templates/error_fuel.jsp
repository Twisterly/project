<jsp:include page="_header.jsp"/>
<h1>Add new fuel type</h1>

<form method="post" action="/car/add-fuelType.html">
 <div class="col-md-6">
    <label for="fuelType" class="form-label">Fuel type</label>
    <input value="${fuelType.fuelTypeName}" type="text" name="fuelTypeName" class="form-control is-invalid" id="fuelTypeName" aria-describedby="nameHelp" required>
    <div id="nameHelp" class="invalid-feedback">
      This fuel type already exists.
    </div>
      <div class="mb-3">
       <button type="submit" class="btn btn-primary">Submit</button>
      </div>

</form>

<jsp:include page="_footer.jsp"/>