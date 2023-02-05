<jsp:include page="_header.jsp"/>
<h1>Add new car body type</h1>

<form method="post" action="/car/add-bodyType.html">
 <div class="col-md-6">
    <label for="bodyType" class="form-label">Body Type</label>
    <input value="${bodyType.bodyTypeName}" type="text" name="bodyTypeName" class="form-control is-invalid" id="bodyTypeName" aria-describedby="nameHelp" required>
    <div id="nameHelp" class="invalid-feedback">
      This body type already exists.
    </div>
      <div class="mb-3">
       <button type="submit" class="btn btn-primary">Submit</button>
      </div>

</form>

<jsp:include page="_footer.jsp"/>