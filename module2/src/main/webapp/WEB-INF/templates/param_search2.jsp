<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Search car</h1>

<!-- brand -->
         <div class="col-md-6">
           <label for="brand.id">Choose a brand:</label>
           <select class="form-select" id="brand.id" name="brand.id">
            <option value="${brand.id}">${brand.brandName}</option>
            </c:forEach>
          </select>
         </div>
<form method="post" action="/car/param-search2.html" enctype="multipart/form-data">
<!-- model -->
         <div class="col-md-6">
           <label for="modelDetail.id">Choose a modelDetail:</label>
           <select class="form-select" id="modelDetail.id" name="modelDetail.id">
            <option value="${modelDetail.id}">${model.modelName}</option>
            </c:forEach>
          </select>
         </div>
</form>
<jsp:include page="_footer.jsp"/>