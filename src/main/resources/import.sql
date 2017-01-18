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
INSERT INTO "good" (title, small_image_link, description, quantity, category_id) VALUES ('Ноутбук HP', '/static/img/i.jpeg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, category_id) VALUES ('Ноутбук ASUS', '/static/img/LG-15UD530KX5DK_250x250.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, category_id) VALUES ('Ноутбук DELL', '/static/img/LG-15ZD950LX10K_250x150.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, category_id) VALUES ('Ноутбук PB', '/static/img/Medion-S2217_250x150.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, category_id) VALUES ('Ноутбук Star Wars', '/static/img/Star-WarsTM-Special-Edition_center-facing-250x150.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 1);

