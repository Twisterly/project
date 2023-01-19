<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Search Model</h1>

<form method="post" action="/car/search-modelDetail.html" enctype="multipart/form-data">
<!-- brand -->
     <div class="mb-3">
  <label for="brand.id">Choose a brand:</label>
  <select class="form-select" id="brand.id" name="brand.id">
  <c:forEach items="${brands}" var="brand">
  <option value="${brand.id}">${brand.brandName}</option>
  </c:forEach>
   </select>
      </div>
  <form method="post" action="/car/search-modelDetail.html" enctype="multipart/form-data">
      <!-- model -->
          <div class="mb-3">
             <label for="modelDetail.id">Choose a model:</label>
             <select class="form-select" id="modelDetail.id" name="modelDetail.id">
               <c:forEach items="${modelDetails}" var="modelDetail">
               <option value="${modelDetail.id}">${modelDetail.modelName}</option>
               </c:forEach>
             </select>
             </div>

               <button type="submit" class="btn btn-primary">Search</button>
               </form>
             <jsp:include page="_footer.jsp"/>