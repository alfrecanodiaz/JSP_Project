<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${sessionScope.user != null}">
        <c:redirect url="/pages/home" />
    </c:when>
    <c:otherwise>
        <c:redirect url="/login"></c:redirect>
    </c:otherwise>
</c:choose>