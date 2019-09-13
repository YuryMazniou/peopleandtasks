DELETE FROM log_of_task;
DELETE FROM tasks;
DELETE FROM persons;

INSERT INTO persons (firstname,lastname,patronymic, email, password) VALUES
       ('Иван', 'Иванов' ,'Иванович','user@yandex.ru', 'password'),
       ('Петр', 'Петров', 'Петрович','user@gmail.com', 'password');

INSERT INTO tasks (name,person_id ,state)VALUES
       ('Теорема Пифагора',1, true),
       ('Закон Ньютона',2, false);

INSERT INTO log_of_task (task_id, spent_of_time, comment) VALUES
      (1,3,'Это было легко'),
      (2,5,'У меня не получилось');