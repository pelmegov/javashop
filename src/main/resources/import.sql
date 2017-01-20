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
INSERT INTO "category" (title, description) VALUES ('notebooks', 'Cards assume no specific width to start');
INSERT INTO "category" (title, description) VALUES ('tablets', 'Tablets to quickly set a card’s width.');

--insert good data
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook HP', '/resources/img/i.jpeg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 20500, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook ASUS', '/resources/img/LG-15UD530KX5DK_250x250.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 108000, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook DELL', '/resources/img/LG-15ZD950LX10K_250x150.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 25000.50, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook PB', '/resources/img/Medion-S2217_250x150.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 10233, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook Star Wars', '/resources/img/Star-WarsTM-Special-Edition_center-facing-250x150.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 40340, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook DEll INSPIRE 2', '/resources/img/1394382910_acer-aspire-e1-532-35564g50mnii.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 2500, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook PACKARD BELL 11LV', '/resources/img/1449171179_noutbuki-ot-apple-lomayutsya-rezhe-ostalnyh.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 12200, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook EASY NOTE2', '/resources/img/i6c6c22445.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 7843, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook LENOVO', '/resources/img/i2889c07e9.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 95000, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook GBDXX72 LA pgns', '/resources/img/thumb_14514740241189795.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 11000, 1);

INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Tablet EASY LA pgns', '/resources/img/0_17e6e1_e00fb6d2_XL-250x150.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 12000, 2);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Tablet LENOVO L BELL s', '/resources/img/i.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 15300, 2);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Tablet NOTE2pg ns', '/resources/img/logo2.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 22040, 2);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Tablet GBD XX 72', '/resources/img/pf.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 34200, 2);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Tablet LA AS NOOO70000', '/resources/img/Samyie-nedorogie-planshetyi-1.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 23500, 2);
