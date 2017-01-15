-- insert user data
INSERT INTO "user" (login, password) VALUES ('admin', '123456');
INSERT INTO "user" (login, password) VALUES ('user', '123456');

-- insert role data
INSERT INTO "role" (name) VALUES ( 'ROLE_ADMIN');
INSERT INTO "role" (name) VALUES ('ROLE_USER');
INSERT INTO "role" (name) VALUES ('ROLE_MANAGER');

-- insert user_role data
INSERT INTO "user_role" (user_id, role_id) VALUES (1, 2);
INSERT INTO "user_role" (user_id, role_id) VALUES (1, 1);
INSERT INTO "user_role" (user_id, role_id) VALUES (2, 1);

--insert good data
-- INSERT INTO "good" (id, title, quantity) VALUES (1,'Ноутбук HP', 1);
INSERT INTO "good" (id, title, quantity, category_id) VALUES (2,'Ноутбук ASUS', 1, 1);
-- INSERT INTO "good" (id, title, quantity, category_id) VALUES (3,'Ноутбук DELL', 1, 1);

--insert category data
INSERT INTO "category" (id, title) VALUES (1, 'компьютерная техника');
-- INSERT INTO "Category" (id, title, category_id) VALUES (2, 'бытовая техника', 2);