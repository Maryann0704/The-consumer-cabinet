<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Meters in the service</title>
</head>
<body>

<nav class="navbar navbar-light bg-light">
<ul class="nav">
  <li class="nav-item">
    <a class="nav-link active" href="${pageContext.request.contextPath}/">Home</a>
  </li>
  <sec:authorize access="!isAuthenticated()">
    <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/registration">Registration</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
    </li>
  </sec:authorize>
  <sec:authorize access="isAuthenticated()">
    <li class="nav-item">
         <a class="nav-link" href="${pageContext.request.contextPath}/my-devices">My devices</a>
    </li>
    <li class="nav-item">
         <a class="nav-link" href="${pageContext.request.contextPath}/add-device">Add device</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
    </li>
  </sec:authorize>

</ul>
    <sec:authorize access="!isAuthenticated()">
        <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/search">
            <input disabled = "disabled" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search-str">
            <button disabled = "disabled" class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/search">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search-str">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </sec:authorize>
</nav>
<br>

</body>
</html>