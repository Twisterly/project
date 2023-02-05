<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h3>${appUser.username} edit your personal info</h3>
<form method="post" action="edit-appUser-info.html">
    <!-- username -->
     <div class="col-md-6">
         <label for="username" class="form-label">User name</label>
         <input value="${appUser.username}" type="text" name="username" class="form-control" id="username" aria-describedby="nameHelp">
      </div>
        <!-- password -->
         <div class="col-md-6">
          <label for="password" class="form-label">Password</label>
          <input value="${appUser.password}" type="text" name="password" class="form-control" id="{noop}password" aria-describedby="nameHelp">
          <div id="nameHelp" class="form-text">Enter password</div>
         </div>
         <!-- firstName -->
          <div class="col-md-6">
            <label for="firstName" class="form-label">first Name</label>
            <input value="${appUser.firstName}" type="text" name="firstName" class="form-control" id="firstName" aria-describedby="nameHelp">
            <div id="nameHelp" class="form-text">Enter firstName</div>
          </div>
           <!-- lastName -->
              <div class="col-md-6">
               <label for="lastName" class="form-label">last Name</label>
               <input value="${appUser.lastName}" type="text" name="lastName" class="form-control" id="lastName" aria-describedby="nameHelp">
               <div id="nameHelp" class="form-text">Enter last Name</div>
              </div>
     <!-- gender -->
      <div class="col-md-6">
          <label for="gender" class="form-label">gender</label>
          <input value="${appUser.gender}" type="text" name="gender" class="form-control" id="gender" aria-describedby="nameHelp">
          <div id="nameHelp" class="form-text">Enter gender</div>
          </div>
     <!-- birthDat -->
      <div class="col-md-2">
        <label for="birthDate" class="form-label">birthDate</label>
        <input value="${appUser.birthDate}" type="date" name="birthDate" class="form-control" id="birthDate" aria-describedby="nameHelp">
        <div id="nameHelp" class="form-text">Enter birthDate</div>
       </div>
      <!-- email -->
      <div class="col-md-6">
            <label for="email" class="form-label">email</label>
            <input value="${appUser.email}" type="text" name="email" class="form-control" id="email" aria-describedby="nameHelp">
      </div>
     <!-- phoneNumber -->
          <div class="col-md-6">
            <label for="phoneNumber" class="form-label">phone number</label>
            <input value="${appUser.phoneNumber}" type="text" name="phoneNumber" class="form-control" id="phoneNumber" aria-describedby="nameHelp">
            <div id="nameHelp" class="form-text">Enter phone number</div>
          </div>
          <button type="submit" class="btn btn-primary">Submit</button>
</form>
<jsp:include page="_footer.jsp"/>