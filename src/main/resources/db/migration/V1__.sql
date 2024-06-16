CREATE TABLE account
(
    id          UUID NOT NULL,
    first_name  VARCHAR(255),
    second_name VARCHAR(255),
    patronymic  VARCHAR(255),
    department_id UUID,
    student_group_id UUID,
    CONSTRAINT pk_account PRIMARY KEY (id)
);

