<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<script type="text/javascript" src="resources/js/peopleandtasks.common.js" defer></script>
<script type="text/javascript" src="resources/js/peopleandtasks.tasks.js" defer></script>

<div class="jumbotron pt-4">
    <div class="container">
        <h3 class="text-center">Список Задач Пользователя</h3>
        <br/>
        <button class="btn btn-primary" onclick="add()">
            <span class="fa fa-plus">Добавить Задачу</span>
        </button>
        <table class="table table-striped" id="datatable">
            <thead>
            <tr>
                <th>Название задачи</th>
                <th>Статус</th>
                <th>Просмотр логов задачи</th>
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
                        <label for="name" class="col-form-label">Название</label>
                        <input class="form-control" id="name" name="name">
                    </div>

                    <div class="form-group">
                        <h6>Статус</h6>
                        <label for="stateT" class="col-form-label">Выполнена</label>
                        <input name="state" id="stateT" type="radio" value="true" checked>
                        <br>
                        <label for="stateF" class="col-form-label">Не выполнена</label>
                        <input name="state" id="stateF" type="radio" value="false">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                    <span class="fa fa-close">Сбросить</span>
                </button>
                <button type="button" class="btn btn-primary" onclick="saveTask()">
                    <span class="fa fa-check">Сохранить</span>
                </button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
