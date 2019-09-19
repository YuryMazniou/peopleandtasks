const logUrl = "log/";
const idTask = localStorage.getItem('idTask');

$(function () {
    makeEditable({
        ajaxUrl: logUrl+idTask,
        datatableOpts: {
            "columns": [
                {
                    "data": "spentOfTime"
                },
                {
                    "data": "comment"
                }
            ]
        },
        updateTable: function () {
            $.get(logUrl+idTask, updateTableByData);
        }
    });
});