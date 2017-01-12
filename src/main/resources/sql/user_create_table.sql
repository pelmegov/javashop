DROP TABLE IF EXISTS public."user";
CREATE TABLE public."user"
(
  id SERIAL NOT NULL,
  login VARCHAR(32) NOT NULL,
  password VARCHAR(32) NOT NULL
);
CREATE UNIQUE INDEX user_id_uindex ON public."user" (id);
CREATE UNIQUE INDEX user_login_uindex ON public."user" (login);

-- insert user data
INSERT INTO "user" (login, password)
VALUES ('admin', '123456');
INSERT INTO "user" (login, password)
VALUES ('user', '123456');