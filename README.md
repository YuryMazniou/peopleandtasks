[![Build Status](https://travis-ci.com/YuryMazniou/peopleandtasks.svg?branch=master)](https://travis-ci.com/YuryMazniou/peopleandtasks)

#### task for interview

- [Deploy application to Heroku(after click link,need time for starting app,about 10 sec)](https://peopleandtasks.herokuapp.com)

#### 1)	Запрос, возвращающий список людей и количество задач, назначенных им
`select p.*,count_task from persons p,(select t.person_id,count(t.person_id) as count_task from tasks t group by t.person_id) t where p.id=t.person_id;`
#### 2)	Запрос , возвращающий список людей, у которых есть задачи с суммарным временем выполнения больше 100 часов
`select p.*
     from persons p,(select sum.person_id,SUM(sum.spent_of_time) as sum from (select t.person_id,l.spent_of_time from tasks t,log_of_task l where t.id=l.task_id) sum group by sum.person_id) person_sum
     where p.id=person_sum.person_id and person_sum.sum>100;`
