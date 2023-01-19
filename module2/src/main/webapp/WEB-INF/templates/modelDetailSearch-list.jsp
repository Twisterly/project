<jsp:include page="_header.jsp"/>
<h1>Models</h1>
<div class="card-group">
<c:forEach items="${modelDetails}" var="modelDetail">
 <div class="card" style="width: 18rem;">
     <div class="card-body">
     <h5 class="card-title"><c:out value="${modelDetail.name}"/></h5>
          <a href="#" class="btn btn-primary">Book</a>
    </div>
  </div>
</c:forEach>
</div>
<jsp:include page="_footer.jsp"/>