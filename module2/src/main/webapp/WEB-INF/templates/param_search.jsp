<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Search car</h1>

<form method="post" action="/car/param-search.html" enctype="multipart/form-data">
  <!-- brand -->
<!-- brand -->
         <div class="col-md-6">
           <label for="brand.id">Choose a brand:</label>
           <select class="form-select" id="brand.id" name="brand.id">
            <c:forEach items="${brands}" var="brand">
            <option value="${brand.id}">${brand.brandName}</option>
            </c:forEach>
          </select>
         </div>
          <button type="submit" class="btn btn-primary">Submit</button>
</form>
<jsp:include page="_footer.jsp"/>