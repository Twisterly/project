<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h3>"${appUser.username}" You can update your info</h3>
<form method="post" action="/car/update-appUser.html?appUserId=${appUser.id}">
    <!-- username -->
      <div class="col-md-6">
          <label for="username" class="form-label">User name</label>
         <input value="${appUser.username}" name="username" class="form-control" id="username" aria-describedby="nameHelp" disabled>
        <div id="nameHelp" class="form-text">Your username</div>
        </div>
        <!-- password -->
         <div class="col-md-6">
          <label for="password" class="form-label">Password</label>
          <input value="${appUser.password}" name="password" class="form-control" id="{noop}password" aria-describedby="nameHelp">
          <div id="nameHelp" class="form-text">Enter password</div>
         </div>
         <!-- firstName -->
          <div class="col-md-6">
            <label for="firstName" class="form-label">first Name</label>
            <input value="${appUser.firstName}" name="firstName" class="form-control" id="firstName" aria-describedby="nameHelp">
            <div id="nameHelp" class="form-text">Enter firstName</div>
          </div>
           <!-- lastName -->
              <div class="col-md-6">
               <label for="lastName" class="form-label">last Name</label>
               <input value="${appUser.lastName}" name="lastName" class="form-control" id="lastName" aria-describedby="nameHelp">
               <div id="nameHelp" class="form-text">Enter last Name</div>
              </div>
     <!-- gender -->
      <div class="col-md-6">
               <label for="gender" class="form-label">gender</label>
               <input value="${appUser.gender}" name="gender" class="form-control" id="gender" aria-describedby="nameHelp" disabled>
             <div id="nameHelp" class="form-text">Your gender</div>
            </div>
     <!-- birthDat -->
      <div class="col-md-6">
        <label for="birthDate" class="form-label">birthDate</label>
        <input value="${appUser.birthDate}" name="birthDate" class="form-control" id="birthDate" aria-describedby="nameHelp" disabled>
        <div id="nameHelp" class="form-text">Your birthDate</div>
       </div>
      <!-- email -->
      <div class="col-md-6">
            <label for="email" class="form-label">email</label>
            <input value="${appUser.email}" name="email" class="form-control" id="email" aria-describedby="nameHelp" pattern="^((https?|ftp)\:\/\/)?([a-z0-9]{1})((\.[a-z0-9-])|([a-z0-9-]))*\.([a-z]{2,6})(\/?)$" required>
      <div id="nameHelp" class="form-text">Enter email</div>
      </div>
     <!-- phoneNumber -->
          <div class="col-md-6">
            <label for="phoneNumber" class="form-label">phone number</label>
            <input value="${appUser.phoneNumber}" name="phoneNumber" class="form-control" id="phoneNumber" aria-describedby="nameHelp" pattern="^\+\d{12}\$" required>
            <div id="nameHelp" class="form-text">Enter phone number</div>
          </div>
<input name="appUser.id" id="appUser.id" value="${appUserId}" type="hidden">
<button type="submit" class="btn btn-primary">Submit</button>
<jsp:include page="_footer.jsp"/>
