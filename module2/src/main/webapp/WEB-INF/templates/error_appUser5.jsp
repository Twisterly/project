<jsp:include page="_header.jsp"/>
<h1>Registration</h1>

<form method="post" action="/car/reg-appUser.html">
  <!-- username -->
 <div class="col-md-6">
          <label for="username" class="form-label">User name</label>
          <input value="${appUser.username}" type="text" name="username" class="form-control is-invalid" id="username" aria-describedby="nameHelp" required>
          <div id="nameHelp" class="invalid-feedback">
            This user name already exists.
        </div>
     </div>
    <!-- password -->
     <div class="col-md-6">
      <label for="password" class="form-label">Password</label>
      <input value="${appUser.password}" type="password" name="password" class="form-control" id="{noop}password" aria-describedby="nameHelp" required>
      <div id="nameHelp" class="form-text">Enter password</div>
     </div>
     <!-- firstName -->
      <div class="col-md-6">
        <label for="firstName" class="form-label">first Name</label>
        <input value="${appUser.firstName}" type="text" name="firstName" class="form-control" id="firstName" aria-describedby="nameHelp" pattern="^[A-Z]{1}[a-z]{1,15}$">
        <div id="nameHelp" class="form-text">Enter firstName</div>
      </div>
       <!-- lastName -->
          <div class="col-md-6">
           <label for="lastName" class="form-label">last Name</label>
           <input value="${appUser.lastName}" type="text" name="lastName" class="form-control" id="lastName" aria-describedby="nameHelp" pattern="^[A-Z]{1}[a-z]{1,15}$">
           <div id="nameHelp" class="form-text">Enter last Name</div>
          </div>
  <!-- gender -->
   <div class="col-md-6">
      <label for="gender" class="form-label">gender</label><br/>
          <c:if test="${appUser.gender == 'male'}">
              This is male
           </c:if>
           <c:if test="${appUser.gender == 'female'}">
             This is female
           </c:if>
           </div>
           <br/>
 <!-- birthDate -->
  <div class="col-md-2">
    <label for="birthDate" class="form-label">birthDate</label>
    <input value="${appUser.birthDate}" type="date" name="birthDate" class="form-control" id="birthDate" aria-describedby="nameHelp">
    <div id="nameHelp" class="form-text">Enter birthDate</div>
   </div>
  <!-- email -->
  <div class="col-md-6">
        <label for="email" class="form-label">email</label>
        <input value="${appUser.email}" type="text" name="email" class="form-control" id="email" aria-describedby="nameHelp" pattern="^((https?|ftp)\:\/\/)?([a-z0-9]{1})((\.[a-z0-9-])|([a-z0-9-]))*\.([a-z]{2,6})(\/?)$" required>
        <div id="nameHelp" class="form-text">Enter email</div>
    </div>
 <!-- phoneNumber -->
 <div class="col-md-6">
         <label for="phoneNumber" class="form-label">phone number</label>
         <input value="${appUser.phoneNumber}" name="phoneNumber" class="form-control" id="phoneNumber" aria-describedby="nameHelp" pattern="^\+\d{12}\$" required>
         <div id="nameHelp" class="form-text">Enter phone number</div>
       </div>
<div class="mb-3">
           <button type="submit" class="btn btn-primary">Submit</button>
         </div>
</form>
<jsp:include page="_footer.jsp"/>