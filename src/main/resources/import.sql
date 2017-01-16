-- insert user data
INSERT INTO "user" (id, login, password) VALUES (1, 'admin', '123456');
INSERT INTO "user" (id, login, password) VALUES (2, 'user', '123456');

-- insert role data
INSERT INTO "role" (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO "role" (id, name) VALUES (2, 'ROLE_USER');
INSERT INTO "role" (id, name) VALUES (3, 'ROLE_MANAGER');

-- insert user_role data
INSERT INTO "user_role" (user_id, role_id) VALUES (1, 2);
INSERT INTO "user_role" (user_id, role_id) VALUES (1, 1);
INSERT INTO "user_role" (user_id, role_id) VALUES (2, 1);

--insert category data
INSERT INTO "category" (title) VALUES ('компьютерная техника');
INSERT INTO "category" (title) VALUES ('бытовая техника');

--insert good data
INSERT INTO "good" (title, quantity, category_id) VALUES ('Ноутбук HP', 1, 1);
INSERT INTO "good" (title, quantity, category_id) VALUES ('Ноутбук ASUS', 1, 1);
INSERT INTO "good" (title, quantity, category_id) VALUES ('Ноутбук DELL', 1, 1);

