DROP TABLE IF EXISTS log_of_task;
DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS persons;

CREATE TABLE persons
(
  id               INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  firstname        VARCHAR (30)          NOT NULL,
  lastname         VARCHAR  (30)         NOT NULL,
  patronymic       VARCHAR (30)          NOT NULL,
  email            VARCHAR (50)          NOT NULL,
  password         VARCHAR  (30)         NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON persons (email);


CREATE TABLE tasks (
  id          INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  name        VARCHAR (30)   NOT NULL,
  person_id   INT            NOT NULL,
  state       BOOLEAN        NOT NULL,
  FOREIGN KEY (person_id) REFERENCES persons (id) ON DELETE CASCADE
);

CREATE TABLE log_of_task(
  id              INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  task_id         INT         NOT NULL,
  spent_of_time   BIGINT      NOT NULL,
  comment         TEXT        NOT NULL,
  FOREIGN KEY (task_id ) REFERENCES tasks (id) ON DELETE CASCADE
);