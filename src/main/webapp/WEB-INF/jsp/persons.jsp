<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<script type="text/javascript" src="resources/js/peopleandtasks.common.js" defer></script>
<script type="text/javascript" src="resources/js/peopleandtasks.persons.js" defer></script>

<div class="jumbotron pt-4">
    <div class="container">
        <h3 class="text-center">Список Пользователей</h3>
        <br/>
        <button class="btn btn-primary" onclick="add()">
            <span class="fa fa-plus">Добавить пользователя</span>
        </button>
        <table class="table table-striped" id="datatable">
            <thead>
            <tr>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Отчество</th>
                <th>Логин/email</th>
                <th>Пароль</th>
                <th>Редактирование пользователя</th>
                <th>Просмотр задачь пользователя</th>
            </tr>
            </thead>
        </table>
    </div>
</div>

<div class="modal fade" tabindex="-1" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="modalTitle"></h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form id="detailsForm">
                    <input type="hidden" id="id" name="id">

                    <div class="form-group">
                        <label for="firstName" class="col-form-label">Имя</label>
                        <input class="form-control" id="firstName" name="firstName">
                    </div>

                    <div class="form-group">
                        <label for="lastName" class="col-form-label">Фамилия</label>
                        <input type="text" class="form-control" id="lastName" name="lastName">
                    </div>

                    <div class="form-group">
                        <label for="patronymic" class="col-form-label">Отчество</label>
                        <input type="text" class="form-control" id="patronymic" name="patronymic">
                    </div>

                    <div class="form-group">
                        <label for="email" class="col-form-label">Логин/email</label>
                        <input type="text" class="form-control" id="email" name="email">
                    </div>

                    <div class="form-group">
                        <label for="password" class="col-form-label">Пароль</label>
                        <input type="text" class="form-control" id="password" name="password">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                    <span class="fa fa-close">Сбросить</span>
                </button>
                <button type="button" class="btn btn-primary" onclick="savePerson()">
                    <span class="fa fa-check">Сохранить</span>
                </button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
