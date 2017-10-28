<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${not empty sessionScope.errors}">
        <div class="alert alert-danger alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <c:forEach items="${sessionScope.errors}" var="error">
                ${error} <br />
            </c:forEach>
            <c:remove var="errors" scope="session" />
        </div>
    </c:when>
    <c:when test="${error != null}">
        <div class="alert alert-danger alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            ${error}
            <c:remove var="error" scope="session" />
        </div>
    </c:when>
    <c:when test="${sessionScope.message != null}">
        <div class="alert alert-info alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            ${sessionScope.message}
            <c:remove var="message" scope="session" />
        </div>
    </c:when>
    <c:when test="${sessionScope.success != null}">
        <div class="alert alert-success alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            ${sessionScope.success}
            <c:remove var="success" scope="session" />
        </div>
    </c:when>
</c:choose>