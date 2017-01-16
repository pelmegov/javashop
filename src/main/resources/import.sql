-- insert user data
INSERT INTO "user" (login, password, active) VALUES ('admin', '123456', true);
INSERT INTO "user" (login, password, active) VALUES ('user', '123456', true);

-- insert role data
INSERT INTO "role" (name) VALUES ('ROLE_ADMIN');
INSERT INTO "role" (name) VALUES ('ROLE_USER');
INSERT INTO "role" (name) VALUES ('ROLE_MANAGER');

-- insert user_role data
INSERT INTO "user_role" (user_id, role_id) VALUES (1, 2);
INSERT INTO "user_role" (user_id, role_id) VALUES (1, 1);
INSERT INTO "user_role" (user_id, role_id) VALUES (2, 2);

--insert category data
INSERT INTO "category" (title) VALUES ('компьютерная техника');
INSERT INTO "category" (title) VALUES ('бытовая техника');

--insert good data
INSERT INTO "good" (title, quantity, category_id) VALUES ('Ноутбук HP', 1, 1);
INSERT INTO "good" (title, quantity, category_id) VALUES ('Ноутбук ASUS', 1, 1);
INSERT INTO "good" (title, quantity, category_id) VALUES ('Ноутбук DELL', 1, 1);

