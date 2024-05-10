CREATE TABLE account
(
    id          UUID NOT NULL,
    first_name  VARCHAR(255),
    second_name VARCHAR(255),
    patronymic  VARCHAR(255),
    CONSTRAINT pk_account PRIMARY KEY (id)
);

CREATE TABLE admin
(
    id UUID NOT NULL,
    CONSTRAINT pk_admin PRIMARY KEY (id)
);

CREATE TABLE employee
(
    id            UUID NOT NULL,
    role          VARCHAR(255),
    department_id UUID,
    CONSTRAINT pk_employee PRIMARY KEY (id)
);

CREATE TABLE student
(
    id               UUID NOT NULL,
    student_group_id UUID,
    CONSTRAINT pk_student PRIMARY KEY (id)
);

CREATE TABLE teacher
(
    id    UUID NOT NULL,
    role  VARCHAR(255),
    title VARCHAR(255),
    CONSTRAINT pk_teacher PRIMARY KEY (id)
);

ALTER TABLE admin
    ADD CONSTRAINT FK_ADMIN_ON_ID FOREIGN KEY (id) REFERENCES account (id);

ALTER TABLE employee
    ADD CONSTRAINT FK_EMPLOYEE_ON_ID FOREIGN KEY (id) REFERENCES account (id);

ALTER TABLE student
    ADD CONSTRAINT FK_STUDENT_ON_ID FOREIGN KEY (id) REFERENCES account (id);

ALTER TABLE teacher
    ADD CONSTRAINT FK_TEACHER_ON_ID FOREIGN KEY (id) REFERENCES account (id);