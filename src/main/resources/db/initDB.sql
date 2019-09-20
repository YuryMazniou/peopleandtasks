DROP TABLE IF EXISTS log_of_task;
DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS persons;

CREATE TABLE persons
(
  id               INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  firstname        VARCHAR (100)   CHARACTER SET utf8 COLLATE utf8_general_ci       NOT NULL,
  lastname         VARCHAR  (100)   CHARACTER SET utf8 COLLATE utf8_general_ci      NOT NULL,
  patronymic       VARCHAR (100)   CHARACTER SET utf8 COLLATE utf8_general_ci       NOT NULL,
  email            VARCHAR (100)   CHARACTER SET utf8 COLLATE utf8_general_ci       NOT NULL,
  password         VARCHAR  (100)   CHARACTER SET utf8 COLLATE utf8_general_ci      NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON persons (email);


CREATE TABLE tasks (
  id          INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  name        VARCHAR (100) CHARACTER SET utf8 COLLATE utf8_general_ci   NOT NULL,
  person_id   INT            NOT NULL,
  state       BOOLEAN        NOT NULL,
  FOREIGN KEY (person_id) REFERENCES persons (id) ON DELETE CASCADE
);

CREATE TABLE log_of_task(
  id              INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  task_id         INT         NOT NULL,
  spent_of_time   BIGINT      NOT NULL,
  comment         TEXT  CHARACTER SET utf8 COLLATE utf8_general_ci      NOT NULL,
  FOREIGN KEY (task_id ) REFERENCES tasks (id) ON DELETE CASCADE
);