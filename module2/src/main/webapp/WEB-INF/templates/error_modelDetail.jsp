<jsp:include page="_header.jsp"/>
<h1>Add new model</h1>

<form method="post" action="/car/add-modelDetail.html">
 <div class="col-md-6">
    <label for="modelDetail" class="form-label">Model name</label>
    <input value="${modelDetail.modelName}" type="text" name="modelName" class="form-control is-invalid" id="modelName" aria-describedby="nameHelp" required>
    <div id="nameHelp" class="invalid-feedback">
      This model already exists.
    </div>
      <div class="mb-3">
       <button type="submit" class="btn btn-primary">Submit</button>
      </div>

</form>

<jsp:include page="_footer.jsp"/>