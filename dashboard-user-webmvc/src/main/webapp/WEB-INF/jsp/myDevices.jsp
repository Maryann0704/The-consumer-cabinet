<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<div class="container">
     <h2>My info</h2>
     <br>
     <form class="form-horizontal">
         <div class="form-group row">
              <label for="staticName" class="col-sm-2 col-form-label">Name Surname: </label>
              <div class="col-sm-5">
                   <input type="text" readonly class="form-control-plaintext" id="staticName" value="${appUser.name}">
              </div>
         </div>
         <div class="form-group row">
               <label for="staticEmail" class="col-sm-2 col-form-label">Email: </label>
               <div class="col-sm-5">
                    <input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${appUser.email}">
               </div>
         </div>
      </form>
      <br>
      <h2>My devices</h2>
      <br>
            <table class="table table-striped table-info">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Type</th>
                        <th scope="col">Location</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="device" items="${my-devices}">
                    <tr>
                        <th scope="row">${device.id}</th>
                        <td><a href="${pageContext.request.contextPath}/my-devices/device/${device.id}" class="badge badge-light">${device.type}</a></td>
                        <td>${device.location}</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
</div>

<jsp:include page="footer.jsp"/>