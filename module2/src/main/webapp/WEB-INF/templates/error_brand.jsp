<jsp:include page="_header.jsp"/>
<h1>Add new car brand</h1>

<form method="post" action="/car/add-brand.html">
 <div class="col-md-6">
    <label for="brandName" class="form-label">Brand name</label>
    <input value="${brand.brandName}" type="text" name="brandName" class="form-control is-invalid" id="brandName" aria-describedby="nameHelp" required>
    <div id="nameHelp" class="invalid-feedback">
      This brand already exists.
    </div>
      <div class="mb-3">
       <button type="submit" class="btn btn-primary">Submit</button>
      </div>

</form>

<jsp:include page="_footer.jsp"/>

