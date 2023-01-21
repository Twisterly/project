<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Create order</h1>

<form method="post" action="/car/create-order.html">
 <div class="input-group mb-3">
            <label for="startDate" class="form-label">start Date</label>
            <input type="datetime-local" name="startDate" class="form-control" id="startDate" aria-describedby="nameHelp">
            <div id="nameHelp" class="form-text">Enter start Date</div>
           </div>

<div class="input-group mb-3">
            <label for="startTime" class="form-label">start Time</label>
            <input type="time" name="startTime" class="form-control" id="startTime" aria-describedby="nameHelp">
            <div id="nameHelp" class="form-text">Enter start time</div>
           </div>

<div class="input-group mb-3">
              <label for="endDate" class="form-label">end Date</label>
              <input type="date" name="endDate" class="form-control" id="endDate" aria-describedby="nameHelp">
              <div id="nameHelp" class="form-text">Enter end Date</div>
              </div>

<div class="input-group mb-3">
             <label for="endTime" class="form-label">end Time</label>
             <input type="time" name="endTime" class="form-control" id="endTime" aria-describedby="nameHelp">
             <div id="nameHelp" class="form-text">Enter end Time</div>
              </div>
  <button type="submit" class="btn btn-primary">Submit</button>

<jsp:include page="_footer.jsp"/>