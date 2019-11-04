<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

    <div class="container">
    <h2>Search result</h2>
    <br>
    <table class="table table-striped table-success">
        <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Type</th>
              <th scope="col">Location</th>
            </tr>
          </thead>
          <tbody>
        <c:forEach var="device" items="${result}">
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