DELETE FROM persons;
DELETE FROM tasks;
DELETE FROM log_of_task;


INSERT INTO persons (firstname,lastname,patronymic, email, password) VALUES
       ('Иван', 'Иванов' ,'Иванович','user@yandex.ru', 'password1'),
       ('Петр', 'Петров', 'Петрович','user@gmail.com', 'password2'),
       ('Сидр', 'Сидоров', 'Сидорович','user@tut.by', 'password3');

INSERT INTO tasks (name,person_id ,state)VALUES
       ('Доказать теорему Пифагора',1, true),
       ('Взломать Google',1, true),
       ('Взломать Facebook',2, true),
       ('Доказать теорию относительности',2, true),
       ('Взломать BankOfAmerica',3, true),
       ('Доказать закон Ньютона',3, false);

INSERT INTO log_of_task (task_id, spent_of_time, comment) VALUES
      (1,30,'Это было легко'),
      (2,50,'Я боялся ,но сделал'),
      (3,30,'Я это сделал'),
      (4,70,'Я не боялся и сделал'),
      (5,101,'Меня хотели схватить,но я убежал'),
      (6,100,'У меня не получилось');