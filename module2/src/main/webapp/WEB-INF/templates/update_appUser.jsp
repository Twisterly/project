<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Update appUser</h1>

<form method="post" action="/car/update-appUser.html">
  <!-- username -->
  <div class="form-group">
      <label for="username">Example label</label>
      <input type="text" name="username" class="form-control" id="username" placeholder="${appUser.username}">
    </div>

         <button type="submit" class="btn btn-primary">Submit</button>

<jsp:include page="_footer.jsp"/>