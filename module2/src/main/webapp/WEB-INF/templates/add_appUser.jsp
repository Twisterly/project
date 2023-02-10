<jsp:include page="_header.jsp"/>
<h1>Registration</h1>

<form method="post" action="/car/reg-appUser.html">
  <!-- username -->
    <div class="col-md-6">
     <label for="username" class="form-label">User name</label>
     <input type="text" name="username" class="form-control" id="username" aria-describedby="nameHelp" required>
     <div id="nameHelp" class="form-text">Enter User name</div>
    </div>
    <!-- password -->
     <div class="col-md-6">
      <label for="password" class="form-label">Password</label>
      <input type="password" name="password" class="form-control" id="{noop}password" aria-describedby="nameHelp" required>
      <div id="nameHelp" class="form-text">Enter password</div>
     </div>
     <!-- firstName -->
      <div class="col-md-6">
        <label for="firstName" class="form-label">first Name</label>
        <input type="text" name="firstName" class="form-control" id="firstName" aria-describedby="nameHelp" pattern="^[A-Z]{1}[a-z]{1,15}$">
        <div id="nameHelp" class="form-text">Enter firstName</div>
      </div>
       <!-- lastName -->
          <div class="col-md-6">
           <label for="lastName" class="form-label">last Name</label>
           <input type="text" name="lastName" class="form-control" id="lastName" aria-describedby="nameHelp" pattern="^[A-Z]{1}[a-z]{1,15}$">
           <div id="nameHelp" class="form-text">Enter last Name</div>
          </div>
 <!-- gender -->
 <div class="form-check form-check-inline">
   <input class="form-check-input" type="radio" name="gender" id="gender1" value="male">
   <label class="form-check-label" for="gender1">male</label>
 </div>
 <div class="form-check form-check-inline">
   <input class="form-check-input" type="radio" name="gender" id="gender2" value="female">
   <label class="form-check-label" for="gender2">female</label>
 </div>
 <!-- birthDat -->
  <div class="col-md-2">
    <label for="birthDate" class="form-label">birthDate</label>
    <input type="date" name="birthDate" class="form-control" id="birthDate" aria-describedby="nameHelp">
    <div id="nameHelp" class="form-text">Enter birthDate</div>
   </div>
  <!-- email -->
   <div class="col-md-6">
      <label for="email" class="form-label">email</label>
      <input type="email" name="email" class="form-control" id="email" aria-describedby="nameHelp" pattern="^((https?|ftp)\:\/\/)?([a-z0-9]{1})((\.[a-z0-9-])|([a-z0-9-]))*\.([a-z]{2,6})(\/?)$" required>
      <div id="nameHelp" class="form-text">Enter email</div>
   </div>
   <!-- phoneNumber -->
      <div class="col-md-6">
         <label for="phoneNumber" class="form-label">phone number</label>
         <input type="phoneNumber" value="+375" name="phoneNumber" class="form-control" id="phoneNumber" aria-describedby="nameHelp" pattern="^\+\d{12}\$" required>
         <div id="nameHelp" class="form-text">Enter phone number</div>
      </div>
<input name="role" id="role" value="USER" type="hidden">
<button type="submit" class="btn btn-primary">Submit</button>


<jsp:include page="_footer.jsp"/>