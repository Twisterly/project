<jsp:include page="_header.jsp"/>
<h1>App User information</h1>
<div class="card-group">
     <h5 class="card-title">"${appUser.username}"</h5>
     <h6 class="card-title">"${appUser.password}"</h6>
    <h6 class="card-title">"${appUser.firstName}"</h6>
    <h6 class="card-title">"${appUser.lastName}"</h6>
    <h6 class="card-title">"${appUser.birthDate}"</h6>
    <h6 class="card-title">"${appUser.email}"</h6>
    <h6 class="card-title">"${appUser.phoneNumber}"</h6>
    <h6 class="card-title">"${appUser.role}"</h6>
</div>

<jsp:include page="_footer.jsp"/>