<jsp:include page="_header.jsp"/>
<h1>Registration</h1>

<form method="post" action="/car/reg-appUser.html">
  <!-- username -->
    <div class="mb-3">
     <label for="username" class="form-label">User name</label>
     <input type="text" name="username" class="form-control" id="username" aria-describedby="nameHelp">
     <div id="nameHelp" class="form-text">Enter User name</div>
    </div>
    <!-- password -->
     <div class="mb-3">
      <label for="password" class="form-label">Password</label>
      <input type="text" name="password" class="form-control" id="{noop}password" aria-describedby="nameHelp">
      <div id="nameHelp" class="form-text">Enter password</div>
     </div>
     <!-- firstName -->
      <div class="mb-3">
        <label for="firstName" class="form-label">first Name</label>
        <input type="text" name="firstName" class="form-control" id="firstName" aria-describedby="nameHelp">
        <div id="nameHelp" class="form-text">Enter firstName</div>
      </div>
       <!-- lastName -->
          <div class="mb-3">
           <label for="lastName" class="form-label">last Name</label>
           <input type="text" name="lastName" class="form-control" id="lastName" aria-describedby="nameHelp">
           <div id="nameHelp" class="form-text">Enter last Name</div>
          </div>
          <!-- birthDat -->
           <div class="mb-3">
            <label for="birthDate" class="form-label">birthDate</label>
            <input type="date" name="birthDate" class="form-control" id="birthDate" aria-describedby="nameHelp">
            <div id="nameHelp" class="form-text">Enter birthDate</div>
           </div>
         <button type="submit" class="btn btn-primary">Submit</button>

<jsp:include page="_footer.jsp"/>