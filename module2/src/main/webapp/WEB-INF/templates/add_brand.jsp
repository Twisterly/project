<jsp:include page="_header.jsp"/>
<h1>Add new car brand</h1>

<form method="post" action="/car/add-brand.html">
  <div class="col-md-6">
    <label for="brandName" class="form-label">Brand name</label>
    <input type="text" name="brandName" class="form-control" id="brandName" aria-describedby="nameHelp">
    <div id="nameHelp" class="form-text">Enter brand name</div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="_footer.jsp"/>