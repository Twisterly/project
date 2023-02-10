<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Select dates</h1>
<form method="post" action="/car/searched-car-by-dates.html" enctype="multipart/form-data">
<!-- startDate -->
 <div class="col-md-2">
            <label for="startDate" class="form-label">start Date</label>
            <input value="${start}" type="date" name="startDate" class="form-control" id="startDate" aria-describedby="nameHelp" required>
            <div id="nameHelp" class="form-text">Enter start Date</div>
           </div>
<!-- endDate -->
<div class="col-md-2">
              <label for="endDate" class="form-label">end Date</label>
              <input value="${end}" type="date" name="endDate" class="form-control" id="endDate" aria-describedby="nameHelp" required>
              <div id="nameHelp" class="form-text">Enter end Date</div>
              </div>
 <input name="endDate" id="endDate" value="${endDate}" type="hidden">
 <input name="startDate" id="startDate" value="${startDate}" type="hidden">
<button type="submit" class="btn btn-primary">Submit</button>
  </form>
<jsp:include page="_footer.jsp"/>