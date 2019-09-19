<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<script type="text/javascript" src="resources/js/peopleandtasks.common.js" defer></script>
<script type="text/javascript" src="resources/js/peopleandtasks.logs.js" defer></script>

<div class="jumbotron pt-4">
    <div class="container">
        <h3 class="text-center">Логи задачи</h3>
        <br/>
        <table class="table table-striped" id="datatable">
            <thead>
            <tr>
                <th>Потраченное время,часов</th>
                <th>Комментарий</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
</body>
</html>
