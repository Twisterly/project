<jsp:include page="_header.jsp"/>
<h1>Add new body type</h1>

<form method="post" action="/car/add-bodyType.html">
  <div class="col-md-6">
    <label for="bodyTypeName" class="form-label">Body type name</label>
    <input type="text" name="bodyTypeName" class="form-control" id="bodyTypeName" aria-describedby="nameHelp">
    <div id="nameHelp" class="form-text">Enter body type name</div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="_footer.jsp"/>