<jsp:include page="_header.jsp"/>
<h1>Add new transmission type</h1>

<form method="post" action="/car/add-transmissionType.html">
  <div class="col-md-6">
    <label for="transmissionTypeName" class="form-label">Transmission type name</label>
    <input type="text" name="transmissionTypeName" class="form-control" id="transmissionTypeName" aria-describedby="nameHelp" required>
    <div id="nameHelp" class="form-text">Enter transmission type name</div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="_footer.jsp"/>