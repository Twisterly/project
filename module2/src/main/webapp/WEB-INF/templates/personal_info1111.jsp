<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h3>"${appUser.username}" Welcome to personal area</h3>
    <!-- username -->
      <div class="col-md-6">
          <label for="username" class="form-label">User name</label>
         <input value="${appUser.username}" name="username" class="form-control" id="username" aria-describedby="nameHelp" disabled>
        </div>
        <!-- password -->
         <div class="col-md-6">
          <label for="password" class="form-label">Password</label>
          <input value="${appUser.password}" name="password" class="form-control" id="{noop}password" aria-describedby="nameHelp" disabled>
          <div id="nameHelp" class="form-text">Enter password</div>
         </div>
         <!-- firstName -->
          <div class="col-md-6">
            <label for="firstName" class="form-label">first Name</label>
            <input value="${appUser.firstName}" name="firstName" class="form-control" id="firstName" aria-describedby="nameHelp" disabled>
            <div id="nameHelp" class="form-text">Enter firstName</div>
          </div>
           <!-- lastName -->
              <div class="col-md-6">
               <label for="lastName" class="form-label">last Name</label>
               <input value="${appUser.lastName}" name="lastName" class="form-control" id="lastName" aria-describedby="nameHelp" disabled>
               <div id="nameHelp" class="form-text">Enter last Name</div>
              </div>
     <!-- gender -->
      <div class="col-md-6">
         <label for="gender" class="form-label">gender</label><br/>
             <div class="form-check form-check-inline">
             <c:if test="${appUser.gender == male}">
                <input class="form-check-input" type="radio" name="gender" id="gender1" value="male" checked disabled>
                <label class="form-check-label" for="gender1">male</label>
                <div class="form-check form-check-inline" disabled>
                <input class="form-check-input" type="radio" name="gender" id="gender2" value="female" disabled>
                <label class="form-check-label" for="gender2">female</label>
             </c:if>
            </div>
      </div>
    </div>
    <br/>
     <!-- birthDat -->
      <div class="col-md-6">
        <label for="birthDate" class="form-label">birthDate</label>
        <input value="${appUser.birthDate}" name="birthDate" class="form-control" id="birthDate" aria-describedby="nameHelp" disabled>
        <div id="nameHelp" class="form-text">Enter birthDate</div>
       </div>
      <!-- email -->
      <div class="col-md-6">
            <label for="email" class="form-label">email</label>
            <input value="${appUser.email}" name="email" class="form-control" id="email" aria-describedby="nameHelp" disabled>
      </div>
     <!-- phoneNumber -->
          <div class="col-md-6">
            <label for="phoneNumber" class="form-label">phone number</label>
            <input value="${appUser.phoneNumber}" name="phoneNumber" class="form-control" id="phoneNumber" aria-describedby="nameHelp" disabled>
            <div id="nameHelp" class="form-text">Enter phone number</div>
          </div>
  </li>
    <input name="appUser.id" id="appUser.id" value="${appUser.id}" type="hidden">
    <button type="button" class="btn btn-light"><a href="car/edit-appUser-info.html?appUserId=${appUser.id}">
    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
    <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
     </svg></button>
     <button type="button" class="btn btn-light"><a href="car/delete-appUser.html"/>
     <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
       <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"/>
     </svg></button>
</ul>
<jsp:include page="_footer.jsp"/>