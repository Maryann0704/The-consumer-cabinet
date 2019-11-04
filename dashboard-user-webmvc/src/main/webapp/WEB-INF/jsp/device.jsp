<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<div class="container">


<div class="card w-95">
  <div class="card-body">
    <h5 class="card-title">${device.type}</h5>
    <p class="card-text">Meter is located in ${device.location}</p>
    <a href="#" class="btn btn-danger btn-lg btn-block">Delete</a>
  </div>
</div>
<br>
<div class="card w-95">
  <div class="card-body">
    <h5 class="card-title">Values for the last 6 months</h5>
    <p class="card-text">Хочу здесь график расхода по месяцам</p>
  </div>
</div>


</div>

<jsp:include page="footer.jsp"/>