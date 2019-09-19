const taskUrl = "task/";
const id = localStorage.getItem('idPerson');

$(function () {
    makeEditable({
        ajaxUrl: taskUrl+id,
        datatableOpts: {
            "columns": [
                {
                    "data": "name"
                },
                {
                    "data": "state"
                },
                {
                    "render": logsBtn,
                    "defaultContent": "",
                    "orderable": false
                }
            ]
        },
        updateTable: function () {
            $.get(taskUrl+id, updateTableByData);
        }
    });
});

function saveTask() {
    var contactForm = {};
    var name = $('#name').val();
    var state;
    if (document.getElementById('stateT').checked) {
        state = 'true';
    }
    else state='false';
    contactForm.name = name;
    contactForm.state = state;
    $.ajax({
        type: "POST",
        url: taskUrl+id,
        data: JSON.stringify(contactForm),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json'
    }).done(function () {
        $("#editRow").modal("hide");
        context.updateTable();
        successNoty("Задача успешно сохранена");
    });
}

function logsBtn(data, type, row) {
    if (type === "display") {
        return "<button type=\"button\" class=\"btn btn-info\" onclick='goToLogs(" + row.id + ");'>Логи</button>";
    }
}

function goToLogs(id) {
    localStorage.setItem('idTask', id);
    window.location.href='logs'
}