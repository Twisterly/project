<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Add new model</h1>

<form method="post" action="/car/add-modelDetail.html" enctype="multipart/form-data">
  <div class="col-md-6">
    <label for="modelName" class="form-label">Model name</label>
    <input type="text" name="modelName" class="form-control" id="modelName" aria-describedby="nameHelp" required>
    <div id="nameHelp" class="form-text">Enter model name</div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="_footer.jsp"/>