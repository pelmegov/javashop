-- insert user data
INSERT INTO "user" (login, password, active) VALUES ('admin', '123456', true);
INSERT INTO "user" (login, password, active) VALUES ('user', '123456', true);
INSERT INTO "user" (login, password, active) VALUES ('manager', '123456', true);
INSERT INTO "user" (login, password, active) VALUES ('user2', '123456', false);

-- insert role data
INSERT INTO "role" (name) VALUES ('ROLE_ADMIN');
INSERT INTO "role" (name) VALUES ('ROLE_USER');
INSERT INTO "role" (name) VALUES ('ROLE_MANAGER');

-- insert user_role data
INSERT INTO "user_role" (user_id, role_id) VALUES (1, 2);
INSERT INTO "user_role" (user_id, role_id) VALUES (1, 1);
INSERT INTO "user_role" (user_id, role_id) VALUES (2, 2);
INSERT INTO "user_role" (user_id, role_id) VALUES (3, 2);
INSERT INTO "user_role" (user_id, role_id) VALUES (3, 3);
INSERT INTO "user_role" (user_id, role_id) VALUES (4, 2);

--insert category data
INSERT INTO "category" (title, description) VALUES ('notebooks', 'Cards assume no specific width to start');
INSERT INTO "category" (title, description) VALUES ('tablets', 'Tablets to quickly set a card’s width.');
INSERT INTO "category" (title, description) VALUES ('mobile', 'Top mobile phones');
INSERT INTO "category" (title, description) VALUES ('Foto Cameras', 'mouse, keyboard, cards, etc.');


--insert good data
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook HP', '/resources/img/hp.jpeg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 20500, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook ASUS', '/resources/img/asus.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 108000, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook DELL', '/resources/img/dell.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 25000.50, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook PB', '/resources/img/pb.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 10233, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook Star Wars', '/resources/img/star_wars.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 40340, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook DEll INSPIRE 2', '/resources/img/dell_inspire_2.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 2500, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook PACKARD BELL 11LV', '/resources/img/packard_bell.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 12200, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook EASY NOTE2', '/resources/img/easy_note_2.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 7843, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook LENOVO', '/resources/img/lenovo.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 95000, 1);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Notebook GBDXX72 LA pgns', '/resources/img/GBDXX72.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 11000, 1);

INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Tablet EASY LA pgns', '/resources/img/tablet_easy_la.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 12000, 2);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Tablet LENOVO L BELL s', '/resources/img/tablet_lenovo_l_bell.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 15300, 2);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Tablet NOTE2pg ns', '/resources/img/tablet_note2.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 22040, 2);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Tablet GBD XX 72', '/resources/img/tablet_gbd.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 34200, 2);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Tablet LA AS NOOO70000', '/resources/img/tablet_la_as.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 23500, 2);

INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Apple IPhone 5s 16Gb', '/resources/img/5s.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 20900, 3);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Samsung Galaxy s6 32Gb', '/resources/img/samsung_galaxy_s6.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 19880, 3);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Xiaomi Redmi Note 4 64Gb', '/resources/img/xiaomi_redmi_note4.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 18990, 3);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Asus Zenfone 2 Laser 16Gb', '/resources/img/asus_zenfone2_laser.png', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 13490, 3);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Sony Xperia X 64Gb Black', '/resources/img/sony_xperia_x.png', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 32990, 3);

INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Canon EOS 100D 18-55DC Kit', '/resources/img/canon_eos_100d.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 29990, 4);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Canon EOS 70D', '/resources/img/canon_eos_70d.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 68990, 4);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Canon EOS 5D Mark 4 Body', '/resources/img/canon_eos_5d.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 229990, 4);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Canon EOS 6D', '/resources/img/canon_eos_6d.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 126990, 4);
INSERT INTO "good" (title, small_image_link, description, quantity, price, category_id) VALUES ('Nikon D5300', '/resources/img/nikon_d5300.jpg', '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 39990, 4);

-- insert user_good data
-- INSERT INTO "user_good" (user_id, good_id) VALUES (1, 2);
-- INSERT INTO "user_good" (user_id, good_id) VALUES (1, 1);
-- INSERT INTO "user_good" (user_id, good_id) VALUES (1, 5);
-- INSERT INTO "user_good" (user_id, good_id) VALUES (1, 7);
-- INSERT INTO "user_good" (user_id, good_id) VALUES (2, 4);
-- INSERT INTO "user_good" (user_id, good_id) VALUES (3, 3);

--insert news data
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('First news', 'We are opened', '/resources/img/dis1-1100x350.png', '27/01/2017' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('Second news', 'We glad to see you in our site', '/resources/img/Mturk-Consulting-1100x350.png', '27/01/2017' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('Third news', 'We glad to see you in our site', '/resources/img/web_hosting-1100x350.jpg', '27/01/2017' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('Third news', 'We glad to see you in our site', '/resources/img/web_hosting-1100x350.jpg', '27/01/2017' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('Third news', 'We glad to see you in our site', '/resources/img/web_hosting-1100x350.jpg', '27/01/2017' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('Third news', 'We glad to see you in our site', '/resources/img/web_hosting-1100x350.jpg', '27/01/2017' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('Third news', 'We glad to see you in our site', '/resources/img/web_hosting-1100x350.jpg', '27/01/2017' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('Third news', 'We glad to see you in our site', '/resources/img/web_hosting-1100x350.jpg', '27/01/2017' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('Third news', 'We glad to see you in our site', '/resources/img/web_hosting-1100x350.jpg', '27/01/2017' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('Third news', 'We glad to see you in our site', '/resources/img/web_hosting-1100x350.jpg', '27/01/2017' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('Third news', 'We glad to see you in our site', '/resources/img/web_hosting-1100x350.jpg', '27/01/2017' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('Third news', 'We glad to see you in our site', '/resources/img/web_hosting-1100x350.jpg', '27/01/2017' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('Third news', 'We glad to see you in our site', '/resources/img/web_hosting-1100x350.jpg', '27/01/2017' );
INSERT INTO "news" (title, description, news_image_link, date) VALUES ('Third news', 'We glad to see you in our site', '/resources/img/web_hosting-1100x350.jpg', '27/01/2017' );
