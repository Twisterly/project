<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Create order</h1>
<form method="post" action="/car/create-order.html" enctype="multipart/form-data">
<!-- choose car -->
<div class="col-md-6">
<label for="car">Choose a car:</label>
       <select class="form-select" id="car" name="car">
           <c:forEach items="${cars}" var="car">
            <option value="${car}">${car.brand.brandName} ${car.modelDetail.modelName}</option>
           </c:forEach>
       </select>
 </div>
 <!-- startDate -->
  <div class="col-md-2">
             <label for="startDate" class="form-label">start Date</label>
             <input type="date" name="startDate" class="form-control" id="startDate" aria-describedby="nameHelp" required>
             <div id="nameHelp" class="form-text">Enter start Date</div>
            </div>
 <!-- endDate -->
 <div class="col-md-2">
               <label for="endDate" class="form-label">end Date</label>
               <input type="date" name="endDate" class="form-control" id="endDate" aria-describedby="nameHelp" required>
               <div id="nameHelp" class="form-text">Enter end Date</div>
               </div>
 <input name="appUser.id" id="appUser.id" value="${userId}" type="hidden">
 <input name="car" id="car" value="${car}" type="hidden">


<button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="_footer.jsp"/>






