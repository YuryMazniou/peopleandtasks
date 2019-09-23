const logUrl = "rest/tasks/";
const idTask = localStorage.getItem('idTask');

$(function () {
    makeEditable({
        ajaxUrl: logUrl+idTask+"/logs",
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