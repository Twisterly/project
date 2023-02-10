<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Brands</h1>

<table style="width:100%" class="table table-hover">
  <tr>
    <th>Brand Name</th>
  </tr>
  <c:forEach items="${brands}" var="brand">
  <tr>
    <td><c:out value="${brand.brandName}"/></td>
  </tr>
  </c:forEach>
</table>

 <nav aria-label="Page navigation example">
  <ul class="pagination">
  <c:if test="${currentPage + 1 == pageCount && pageCount == 1}">
      <li class="page-item disabled">
          <span class="page-link">Previous</span>
      </li>
        <li class="page-item disabled">
                <span class="page-link">Next</span>
            </li>
    </c:if>
    <c:if test="${currentPage + 1 == 1 && currentPage + 1 < pageCount}">
      <li class="page-item disabled">
          <span class="page-link">Previous</span>
      </li>
        <li class="page-item"><a class="page-link" href="brand-list.html?pageNumber=${currentPage + 1}">Next</a></li>
    </c:if>
    <c:if test="${currentPage + 1 > 1 && currentPage + 1 < pageCount}">
      <li class="page-item"><a class="page-link" href="brand-list.html?pageNumber=${currentPage - 1}">Previous</a></li>
      <li class="page-item"><a class="page-link" href="brand-list.html?pageNumber=${currentPage + 1}">Next</a></li>
    </c:if>
    <c:if test="${currentPage + 1 == pageCount && currentPage + 1 > 1}">
      <li class="page-item"><a class="page-link" href="brand-list.html?pageNumber=${currentPage - 1}">Previous</a></li>
      <li class="page-item disabled">
              <span class="page-link">Next</span>
      </li>
    </c:if>
    </ul>
  </nav>
<jsp:include page="_footer.jsp"/>