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
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Ноутбук HP', '/resources/img/i.jpeg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 20500, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Ноутбук ASUS', '/resources/img/LG-15UD530KX5DK_250x250.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 108000, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Ноутбук DELL', '/resources/img/LG-15ZD950LX10K_250x150.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 25000.50, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Ноутбук PB', '/resources/img/Medion-S2217_250x150.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 10233, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Ноутбук Star Wars', '/resources/img/Star-WarsTM-Special-Edition_center-facing-250x150.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 40340, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Ноутбук DEll INSPIRE 2', '/resources/img/1394382910_acer-aspire-e1-532-35564g50mnii.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 2500, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Ноутбук PACKARD BELL 11LV', '/resources/img/1449171179_noutbuki-ot-apple-lomayutsya-rezhe-ostalnyh.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 12200, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Ноутбук EASY NOTE2', '/resources/img/i6c6c22445.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 7843, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Ноутбук LENOVO', '/resources/img/i2889c07e9.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 95000, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Ноутбук GBDXX72 LA pgns', '/resources/img/ll_l.jpeg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 11000, 1);
