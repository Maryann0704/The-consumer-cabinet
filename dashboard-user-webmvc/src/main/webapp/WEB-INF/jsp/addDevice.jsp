<jsp:include page="header.jsp"/>

<div class="container">
    <h2>Add device</h2>
    <br>
        <form method="POST" action="${pageContext.request.contextPath}/add-device">
             <div class="form-group">
                 <label for="type">Meter type</label>
                 <select id="type" class="form-control">
                         <option>cold water meter</option>
                         <option>hot water meter</option>
                         <option>electric meter</option>
                         <option>gas meter</option>
                         <option>warm meter</option>
                 </select>
             </div>
             <div class="form-group">
                 <label for="location">Meter location</label>
                 <select id="location" class="form-control">
                        <option>bathroom</option>
                        <option>water closet</option>
                        <option>kitchen</option>
                        <option>room</option>
                 </select>
             </div>
             <button type="submit" class="btn btn-primary">Add device</button>
        </form>

<jsp:include page="footer.jsp"/>