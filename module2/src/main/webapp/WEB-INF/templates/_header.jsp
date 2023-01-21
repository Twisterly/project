<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Web shop demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <body>

<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/car/index.html">Home</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Lists
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/car/car-list.html">Show cars</a></li>
            <li><a class="dropdown-item" href="/car/modelDetail-list.html">Show models</a></li>
            <li><a class="dropdown-item" href="/car/bodyType-list.html">Show body types</a></li>
             <li><a class="dropdown-item" href="/car/brand-list.html">Show brands</a></li>
             <li><a class="dropdown-item" href="/car/fuelType-list.html">Show fuel Types</a></li>
             <li><a class="dropdown-item" href="/car/transmissionType-list.html">Show transmission Types</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Select action
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/car/add-modelDetail.html">Add modelDetail</a></li>
             <li><a class="dropdown-item" href="/car/add-car.html">Add car</a></li>
              <li><a class="dropdown-item" href="/car/add-bodyType.html">Add body type</a></li>
              <li><a class="dropdown-item" href="/car/add-brand.html">Add brand</a></li>
              <li><a class="dropdown-item" href="/car/add-fuelType.html">Add fuel type</a></li>
              <li><a class="dropdown-item" href="/car/add-transmissionType.html">Add transmission type</a></li>
           <li><a class="dropdown-item" href="/car/reg-appUser.html">Add app user</a></li>
            <li><a class="dropdown-item" href="/car/add-filter.html">Search</a></li>
          </ul>
        </li>
 <li class="nav-item">
        <security:authorize access="isAuthenticated()">
            <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
        </security:authorize>
        <security:authorize access="!isAuthenticated()">
                <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
        </security:authorize>
        </li>
      </ul>
      <security:authorize access="isAuthenticated()">
        <a class="nav-link disabled">Welcome&nbsp;<security:authentication property="name"/>&nbsp;</a>
      </security:authorize>
      <security:authorize access="!isAuthenticated()">
        <a class="nav-link disabled">Welcome&nbsp;anonymous</a>
      </security:authorize>
    </div>
  </div>
</nav>