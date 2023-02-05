<jsp:include page="_header.jsp"/>
<h1>Add new transmission type</h1>

<form method="post" action="/car/add-transmissionType.html">
 <div class="col-md-6">
    <label for="transmissionType" class="form-label">Transmission type name</label>
    <input value="${transmissionType.transmissionTypeName}" type="text" name="transmissionTypeName" class="form-control is-invalid" id="transmissionTypeName" aria-describedby="nameHelp" required>
    <div id="nameHelp" class="invalid-feedback">
      This transmission type already exists.
    </div>
      <div class="mb-3">
       <button type="submit" class="btn btn-primary">Submit</button>
      </div>

</form>

<jsp:include page="_footer.jsp"/>