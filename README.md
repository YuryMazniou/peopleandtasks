[![Build Status](https://travis-ci.com/YuryMazniou/peopleandtasks.svg?branch=master)](https://travis-ci.com/YuryMazniou/peopleandtasks)

#### task for interview

###### REST запросы
###### GET /rest/persons  - все пользователи
###### GET /rest/persons/{id} - достать пользователя
###### POST /rest/persons - сохранить пользователя
###### GET /rest/persons/{id}/tasks - все задачи пользователя 
###### POST /rest/persons/{id}/tasks - сохранить задачу для пользователя 
###### GET /rest/tasks/{id}/logs - все логи задачи 

- [Deploy application to Heroku(after click link,need time for starting app,about 10 sec)](https://peopleandtasks.herokuapp.com)
##### Запросы составлены с учетом названий моих таблиц в БД,скрипты создания таблиц и заполнения лежат в srs/main/java/...../resources/bd
#### 1)	Запрос, возвращающий список людей и количество задач, назначенных им
`select p.*,count(*) as count from persons p INNER JOIN tasks t ON p.id = t.person_id group by p.id`
#### 2)	Запрос , возвращающий список людей, у которых есть задачи с суммарным временем выполнения больше 100 часов
`select p.* from persons p INNER JOIN tasks t on p.id = t.person_id INNER JOIN log_of_task l on t.id = l.task_id GROUP BY p.id HAVING sum(l.spent_of_time)>100;`
