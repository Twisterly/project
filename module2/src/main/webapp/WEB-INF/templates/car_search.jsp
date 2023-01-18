<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Search car</h1>

<select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
  <option selected>Select brand</option>
   <div class="mb-3">
       <select class="form-select" id="car.id" name="car.id">
         <c:forEach items="${cars}" var="car">
         <option value="${car.id}">${car.brandName}</option>
         </c:forEach>
       </select>
       </div>
</select>


<select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
  <option selected>Select color</option>
   <div class="mb-3">
       <select class="form-select" id="car.id" name="car.id">
         <c:forEach items="${cars}" var="car">
         <option value="${car.id}">${car.color}</option>
         </c:forEach>
       </select>
       </div>
</select>

<jsp:include page="_footer.jsp"/>