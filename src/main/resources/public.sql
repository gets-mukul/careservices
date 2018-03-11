/*
 Navicat PostgreSQL Data Transfer

 Source Server         : google db
 Source Server Type    : PostgreSQL
 Source Server Version : 90606
 Source Host           : 35.184.186.205:5432
 Source Catalog        : postgres
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90606
 File Encoding         : 65001

 Date: 11/03/2018 18:00:25
*/


-- ----------------------------
-- Table structure for care_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."care_user";
CREATE TABLE "public"."care_user" (
  "id" int4 NOT NULL,
  "code" varchar(255) COLLATE "pg_catalog"."default",
  "email" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "mobile" int8 NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "password" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "user_type" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "image_url" text COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of care_user
-- ----------------------------
INSERT INTO "public"."care_user" VALUES (2, NULL, 'invinf09@gmail.com', 9302757109, 'DEEPAK PRAJAPATI', 'DESA1263', 'EMPLOYEE', 'img/profile_small.jpg');
INSERT INTO "public"."care_user" VALUES (3, NULL, 'amit@gmail.com', 9874563210, 'Amit', 'test123', 'EMPLOYEE', 'img/profile_small.jpg');
INSERT INTO "public"."care_user" VALUES (4, NULL, 'rob@gmail.com', 987456321, ' rob', 'test123', 'EMPLOYEE', 'img/profile_small.jpg');
INSERT INTO "public"."care_user" VALUES (1, '1', 'abhinav@gmail.com', 9425465546, 'abhinav', 'test123', 'ADMIN', 'img/profile_small.jpg');
INSERT INTO "public"."care_user" VALUES (5, NULL, 'arun@gmail.com', 1234567890, 'arun', 'test123', 'EMPLOYEE', 'img/profile_small.jpg');
INSERT INTO "public"."care_user" VALUES (6, NULL, 'abc@gmail.comd', 45657, 'safsvgrg', 'test123gdgdfgdg', 'EMPLOYEE', NULL);
INSERT INTO "public"."care_user" VALUES (7, NULL, 'abc@gmail.comwe', 2345, 'werewe', 'test123', 'EMPLOYEE', NULL);

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS "public"."city";
CREATE TABLE "public"."city" (
  "id" int4 NOT NULL,
  "city" varchar(255) COLLATE "pg_catalog"."default",
  "state" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for client_trail
-- ----------------------------
DROP TABLE IF EXISTS "public"."client_trail";
CREATE TABLE "public"."client_trail" (
  "id" int4 NOT NULL,
  "contact_id" int8 NOT NULL,
  "trail_start_date" date,
  "trail_end_date" date,
  "time" time(6),
  "secrip" varchar(255) COLLATE "pg_catalog"."default",
  "long_short" varchar(255) COLLATE "pg_catalog"."default",
  "segment" varchar(255) COLLATE "pg_catalog"."default",
  "expity_date" date,
  "strike_price" numeric(10,2),
  "lot_size_qty" int4,
  "buy_sell" int8,
  "first_target" int4,
  "second_target" int4,
  "stop_loss" int4,
  "status" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for contact
-- ----------------------------
DROP TABLE IF EXISTS "public"."contact";
CREATE TABLE "public"."contact" (
  "id" int4 NOT NULL,
  "contact_location" varchar(255) COLLATE "pg_catalog"."default",
  "contact_name" varchar(255) COLLATE "pg_catalog"."default",
  "contact_number" int8 NOT NULL,
  "uploaded_by" int4 NOT NULL,
  "uploaded_at" timestamp(6)
)
;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO "public"."contact" VALUES (1, NULL, NULL, 109, 1, '2018-02-25 20:14:47.906');
INSERT INTO "public"."contact" VALUES (2, NULL, NULL, 10000000019, 1, '2018-02-25 20:14:48.088');
INSERT INTO "public"."contact" VALUES (3, NULL, NULL, 10000000029, 1, '2018-02-25 20:14:48.202');
INSERT INTO "public"."contact" VALUES (4, NULL, NULL, 10000000039, 1, '2018-02-25 20:14:48.317');
INSERT INTO "public"."contact" VALUES (5, NULL, NULL, 10000000049, 1, '2018-02-25 20:14:48.431');
INSERT INTO "public"."contact" VALUES (6, NULL, NULL, 10000000059, 1, '2018-02-25 20:14:48.547');
INSERT INTO "public"."contact" VALUES (7, NULL, NULL, 10000000069, 1, '2018-02-25 20:14:48.661');
INSERT INTO "public"."contact" VALUES (8, NULL, NULL, 10000000079, 1, '2018-02-25 20:14:48.775');
INSERT INTO "public"."contact" VALUES (9, NULL, NULL, 10000000089, 1, '2018-02-25 20:14:48.89');
INSERT INTO "public"."contact" VALUES (10, NULL, NULL, 10000000099, 1, '2018-02-25 20:14:49.004');
INSERT INTO "public"."contact" VALUES (11, NULL, NULL, 1000000019, 1, '2018-02-25 20:14:49.118');
INSERT INTO "public"."contact" VALUES (12, NULL, NULL, 10000000119, 1, '2018-02-25 20:14:49.231');
INSERT INTO "public"."contact" VALUES (13, NULL, NULL, 10000000129, 1, '2018-02-25 20:14:49.345');
INSERT INTO "public"."contact" VALUES (14, NULL, NULL, 10000000139, 1, '2018-02-25 20:14:49.459');
INSERT INTO "public"."contact" VALUES (15, NULL, NULL, 10000000149, 1, '2018-02-25 20:14:49.572');
INSERT INTO "public"."contact" VALUES (16, NULL, NULL, 10000000159, 1, '2018-02-25 20:14:49.688');
INSERT INTO "public"."contact" VALUES (17, NULL, NULL, 10000000169, 1, '2018-02-25 20:14:49.804');
INSERT INTO "public"."contact" VALUES (18, NULL, NULL, 10000000179, 1, '2018-02-25 20:14:49.918');
INSERT INTO "public"."contact" VALUES (19, NULL, NULL, 10000000189, 1, '2018-02-25 20:14:50.032');
INSERT INTO "public"."contact" VALUES (20, NULL, NULL, 10000000199, 1, '2018-02-25 20:14:50.146');
INSERT INTO "public"."contact" VALUES (21, NULL, NULL, 1000000029, 1, '2018-02-25 20:14:50.26');
INSERT INTO "public"."contact" VALUES (22, NULL, NULL, 10000000219, 1, '2018-02-25 20:14:50.374');
INSERT INTO "public"."contact" VALUES (23, NULL, NULL, 10000000229, 1, '2018-02-25 20:14:50.488');
INSERT INTO "public"."contact" VALUES (24, NULL, NULL, 10000000239, 1, '2018-02-25 20:14:50.602');
INSERT INTO "public"."contact" VALUES (25, NULL, NULL, 10000000249, 1, '2018-02-25 20:14:50.719');
INSERT INTO "public"."contact" VALUES (26, NULL, NULL, 10000000259, 1, '2018-02-25 20:14:50.834');
INSERT INTO "public"."contact" VALUES (27, NULL, NULL, 10000000269, 1, '2018-02-25 20:14:50.947');
INSERT INTO "public"."contact" VALUES (28, NULL, NULL, 10000000279, 1, '2018-02-25 20:14:51.061');
INSERT INTO "public"."contact" VALUES (29, NULL, NULL, 10000000289, 1, '2018-02-25 20:14:51.175');
INSERT INTO "public"."contact" VALUES (30, NULL, NULL, 10000000299, 1, '2018-02-25 20:14:51.289');
INSERT INTO "public"."contact" VALUES (31, NULL, NULL, 1000000039, 1, '2018-02-25 20:14:51.403');
INSERT INTO "public"."contact" VALUES (32, NULL, NULL, 10000000319, 1, '2018-02-25 20:14:51.517');
INSERT INTO "public"."contact" VALUES (33, NULL, NULL, 10000000329, 1, '2018-02-25 20:14:51.631');
INSERT INTO "public"."contact" VALUES (34, NULL, NULL, 10000000339, 1, '2018-02-25 20:14:51.744');
INSERT INTO "public"."contact" VALUES (35, NULL, NULL, 10000000349, 1, '2018-02-25 20:14:51.858');
INSERT INTO "public"."contact" VALUES (36, NULL, NULL, 10000000359, 1, '2018-02-25 20:14:51.972');
INSERT INTO "public"."contact" VALUES (37, NULL, NULL, 10000000369, 1, '2018-02-25 20:14:52.085');
INSERT INTO "public"."contact" VALUES (38, NULL, NULL, 10000000379, 1, '2018-02-25 20:14:52.198');
INSERT INTO "public"."contact" VALUES (39, NULL, NULL, 10000000389, 1, '2018-02-25 20:14:52.311');
INSERT INTO "public"."contact" VALUES (40, NULL, NULL, 10000000399, 1, '2018-02-25 20:14:52.424');
INSERT INTO "public"."contact" VALUES (41, NULL, NULL, 1000000049, 1, '2018-02-25 20:14:52.538');
INSERT INTO "public"."contact" VALUES (42, NULL, NULL, 10000000419, 1, '2018-02-25 20:14:52.651');
INSERT INTO "public"."contact" VALUES (43, NULL, NULL, 10000000429, 1, '2018-02-25 20:14:52.764');
INSERT INTO "public"."contact" VALUES (44, NULL, NULL, 10000000439, 1, '2018-02-25 20:14:52.877');
INSERT INTO "public"."contact" VALUES (45, NULL, NULL, 10000000449, 1, '2018-02-25 20:14:52.99');
INSERT INTO "public"."contact" VALUES (46, NULL, NULL, 10000000459, 1, '2018-02-25 20:14:53.103');
INSERT INTO "public"."contact" VALUES (47, NULL, NULL, 10000000469, 1, '2018-02-25 20:14:53.217');
INSERT INTO "public"."contact" VALUES (48, NULL, NULL, 10000000479, 1, '2018-02-25 20:14:53.33');
INSERT INTO "public"."contact" VALUES (49, NULL, NULL, 10000000489, 1, '2018-02-25 20:14:53.445');
INSERT INTO "public"."contact" VALUES (50, NULL, NULL, 10000000499, 1, '2018-02-25 20:14:53.558');
INSERT INTO "public"."contact" VALUES (51, NULL, NULL, 1000000059, 1, '2018-02-25 20:14:53.671');
INSERT INTO "public"."contact" VALUES (52, NULL, NULL, 10000000519, 1, '2018-02-25 20:14:53.784');
INSERT INTO "public"."contact" VALUES (53, NULL, NULL, 10000000529, 1, '2018-02-25 20:14:53.898');
INSERT INTO "public"."contact" VALUES (54, NULL, NULL, 10000000539, 1, '2018-02-25 20:14:54.011');
INSERT INTO "public"."contact" VALUES (55, NULL, NULL, 10000000549, 1, '2018-02-25 20:14:54.125');
INSERT INTO "public"."contact" VALUES (56, NULL, NULL, 10000000559, 1, '2018-02-25 20:14:54.242');
INSERT INTO "public"."contact" VALUES (57, NULL, NULL, 10000000569, 1, '2018-02-25 20:14:54.356');
INSERT INTO "public"."contact" VALUES (58, NULL, NULL, 10000000579, 1, '2018-02-25 20:14:54.47');
INSERT INTO "public"."contact" VALUES (59, NULL, NULL, 10000000589, 1, '2018-02-25 20:14:54.583');
INSERT INTO "public"."contact" VALUES (60, NULL, NULL, 10000000599, 1, '2018-02-25 20:14:54.697');
INSERT INTO "public"."contact" VALUES (61, NULL, NULL, 1000000069, 1, '2018-02-25 20:14:54.81');
INSERT INTO "public"."contact" VALUES (62, NULL, NULL, 10000000619, 1, '2018-02-25 20:14:54.923');
INSERT INTO "public"."contact" VALUES (63, NULL, NULL, 10000000629, 1, '2018-02-25 20:14:55.036');
INSERT INTO "public"."contact" VALUES (64, NULL, NULL, 10000000639, 1, '2018-02-25 20:14:55.15');
INSERT INTO "public"."contact" VALUES (65, NULL, NULL, 10000000649, 1, '2018-02-25 20:14:55.264');
INSERT INTO "public"."contact" VALUES (66, NULL, NULL, 10000000659, 1, '2018-02-25 20:14:55.377');
INSERT INTO "public"."contact" VALUES (67, NULL, NULL, 10000000669, 1, '2018-02-25 20:14:55.49');
INSERT INTO "public"."contact" VALUES (68, NULL, NULL, 10000000679, 1, '2018-02-25 20:14:55.608');
INSERT INTO "public"."contact" VALUES (69, NULL, NULL, 10000000689, 1, '2018-02-25 20:14:55.721');
INSERT INTO "public"."contact" VALUES (70, NULL, NULL, 10000000699, 1, '2018-02-25 20:14:55.835');
INSERT INTO "public"."contact" VALUES (71, NULL, NULL, 1000000079, 1, '2018-02-25 20:14:55.947');
INSERT INTO "public"."contact" VALUES (72, NULL, NULL, 10000000719, 1, '2018-02-25 20:14:56.061');
INSERT INTO "public"."contact" VALUES (73, NULL, NULL, 10000000729, 1, '2018-02-25 20:14:56.174');
INSERT INTO "public"."contact" VALUES (74, NULL, NULL, 10000000739, 1, '2018-02-25 20:14:56.287');
INSERT INTO "public"."contact" VALUES (75, NULL, NULL, 10000000749, 1, '2018-02-25 20:14:56.401');
INSERT INTO "public"."contact" VALUES (76, NULL, NULL, 10000000759, 1, '2018-02-25 20:14:56.514');
INSERT INTO "public"."contact" VALUES (77, NULL, NULL, 10000000769, 1, '2018-02-25 20:14:56.627');
INSERT INTO "public"."contact" VALUES (78, NULL, NULL, 10000000779, 1, '2018-02-25 20:14:56.74');
INSERT INTO "public"."contact" VALUES (79, NULL, NULL, 10000000789, 1, '2018-02-25 20:14:56.853');
INSERT INTO "public"."contact" VALUES (80, NULL, NULL, 10000000799, 1, '2018-02-25 20:14:56.967');
INSERT INTO "public"."contact" VALUES (81, NULL, NULL, 1000000089, 1, '2018-02-25 20:14:57.08');
INSERT INTO "public"."contact" VALUES (82, NULL, NULL, 10000000819, 1, '2018-02-25 20:14:57.195');
INSERT INTO "public"."contact" VALUES (83, NULL, NULL, 10000000829, 1, '2018-02-25 20:14:57.309');
INSERT INTO "public"."contact" VALUES (84, NULL, NULL, 10000000839, 1, '2018-02-25 20:14:57.423');
INSERT INTO "public"."contact" VALUES (85, NULL, NULL, 10000000849, 1, '2018-02-25 20:14:57.538');
INSERT INTO "public"."contact" VALUES (86, NULL, NULL, 10000000859, 1, '2018-02-25 20:14:57.651');
INSERT INTO "public"."contact" VALUES (87, NULL, NULL, 10000000869, 1, '2018-02-25 20:14:57.765');
INSERT INTO "public"."contact" VALUES (88, NULL, NULL, 10000000879, 1, '2018-02-25 20:14:57.878');
INSERT INTO "public"."contact" VALUES (89, NULL, NULL, 10000000889, 1, '2018-02-25 20:14:57.991');
INSERT INTO "public"."contact" VALUES (90, NULL, NULL, 10000000899, 1, '2018-02-25 20:14:58.104');
INSERT INTO "public"."contact" VALUES (91, NULL, NULL, 1000000099, 1, '2018-02-25 20:14:58.217');
INSERT INTO "public"."contact" VALUES (92, NULL, NULL, 10000000919, 1, '2018-02-25 20:14:58.33');
INSERT INTO "public"."contact" VALUES (93, NULL, NULL, 10000000929, 1, '2018-02-25 20:14:58.443');
INSERT INTO "public"."contact" VALUES (94, NULL, NULL, 10000000939, 1, '2018-02-25 20:14:58.564');
INSERT INTO "public"."contact" VALUES (95, NULL, NULL, 10000000949, 1, '2018-02-25 20:14:58.681');
INSERT INTO "public"."contact" VALUES (96, NULL, NULL, 10000000959, 1, '2018-02-25 20:14:58.795');
INSERT INTO "public"."contact" VALUES (97, NULL, NULL, 10000000969, 1, '2018-02-25 20:14:58.909');
INSERT INTO "public"."contact" VALUES (98, NULL, NULL, 10000000979, 1, '2018-02-25 20:14:59.024');
INSERT INTO "public"."contact" VALUES (99, NULL, NULL, 10000000989, 1, '2018-02-25 20:14:59.137');
INSERT INTO "public"."contact" VALUES (100, NULL, NULL, 10000000999, 1, '2018-02-25 20:14:59.251');
INSERT INTO "public"."contact" VALUES (101, NULL, NULL, 100000019, 1, '2018-02-25 20:14:59.365');
INSERT INTO "public"."contact" VALUES (102, NULL, NULL, 10000001019, 1, '2018-02-25 20:14:59.478');
INSERT INTO "public"."contact" VALUES (103, NULL, NULL, 10000001029, 1, '2018-02-25 20:14:59.592');
INSERT INTO "public"."contact" VALUES (104, NULL, NULL, 10000001039, 1, '2018-02-25 20:14:59.709');
INSERT INTO "public"."contact" VALUES (105, NULL, NULL, 10000001049, 1, '2018-02-25 20:14:59.822');
INSERT INTO "public"."contact" VALUES (106, NULL, NULL, 10000001059, 1, '2018-02-25 20:14:59.937');
INSERT INTO "public"."contact" VALUES (107, NULL, NULL, 10000001069, 1, '2018-02-25 20:15:00.05');
INSERT INTO "public"."contact" VALUES (108, NULL, NULL, 10000001079, 1, '2018-02-25 20:15:00.165');
INSERT INTO "public"."contact" VALUES (109, NULL, NULL, 10000001089, 1, '2018-02-25 20:15:00.278');
INSERT INTO "public"."contact" VALUES (110, NULL, NULL, 10000001099, 1, '2018-02-25 20:15:00.393');
INSERT INTO "public"."contact" VALUES (111, NULL, NULL, 1000000119, 1, '2018-02-25 20:15:00.507');
INSERT INTO "public"."contact" VALUES (112, NULL, NULL, 10000001119, 1, '2018-02-25 20:15:00.622');
INSERT INTO "public"."contact" VALUES (113, NULL, NULL, 10000001129, 1, '2018-02-25 20:15:00.736');
INSERT INTO "public"."contact" VALUES (114, NULL, NULL, 10000001139, 1, '2018-02-25 20:15:00.85');
INSERT INTO "public"."contact" VALUES (115, NULL, NULL, 10000001149, 1, '2018-02-25 20:15:00.964');
INSERT INTO "public"."contact" VALUES (116, NULL, NULL, 10000001159, 1, '2018-02-25 20:15:01.079');
INSERT INTO "public"."contact" VALUES (117, NULL, NULL, 10000001169, 1, '2018-02-25 20:15:01.194');
INSERT INTO "public"."contact" VALUES (118, NULL, NULL, 10000001179, 1, '2018-02-25 20:15:01.307');
INSERT INTO "public"."contact" VALUES (119, NULL, NULL, 10000001189, 1, '2018-02-25 20:15:01.423');
INSERT INTO "public"."contact" VALUES (120, NULL, NULL, 10000001199, 1, '2018-02-25 20:15:01.537');
INSERT INTO "public"."contact" VALUES (121, NULL, NULL, 1000000129, 1, '2018-02-25 20:15:01.651');
INSERT INTO "public"."contact" VALUES (122, NULL, NULL, 10000001219, 1, '2018-02-25 20:15:01.765');
INSERT INTO "public"."contact" VALUES (123, NULL, NULL, 10000001229, 1, '2018-02-25 20:15:01.879');
INSERT INTO "public"."contact" VALUES (124, NULL, NULL, 10000001239, 1, '2018-02-25 20:15:01.992');
INSERT INTO "public"."contact" VALUES (125, NULL, NULL, 10000001249, 1, '2018-02-25 20:15:02.106');
INSERT INTO "public"."contact" VALUES (126, NULL, NULL, 10000001259, 1, '2018-02-25 20:15:02.22');
INSERT INTO "public"."contact" VALUES (127, NULL, NULL, 10000001269, 1, '2018-02-25 20:15:02.334');
INSERT INTO "public"."contact" VALUES (128, NULL, NULL, 10000001279, 1, '2018-02-25 20:15:02.448');
INSERT INTO "public"."contact" VALUES (129, NULL, NULL, 10000001289, 1, '2018-02-25 20:15:02.563');
INSERT INTO "public"."contact" VALUES (130, NULL, NULL, 10000001299, 1, '2018-02-25 20:15:02.676');
INSERT INTO "public"."contact" VALUES (131, NULL, NULL, 1000000139, 1, '2018-02-25 20:15:02.79');
INSERT INTO "public"."contact" VALUES (132, NULL, NULL, 10000001319, 1, '2018-02-25 20:15:02.903');
INSERT INTO "public"."contact" VALUES (133, NULL, NULL, 10000001329, 1, '2018-02-25 20:15:03.016');
INSERT INTO "public"."contact" VALUES (134, NULL, NULL, 10000001339, 1, '2018-02-25 20:15:03.13');
INSERT INTO "public"."contact" VALUES (135, NULL, NULL, 10000001349, 1, '2018-02-25 20:15:03.243');
INSERT INTO "public"."contact" VALUES (136, NULL, NULL, 10000001359, 1, '2018-02-25 20:15:03.356');
INSERT INTO "public"."contact" VALUES (137, NULL, NULL, 10000001369, 1, '2018-02-25 20:15:03.47');
INSERT INTO "public"."contact" VALUES (138, NULL, NULL, 10000001379, 1, '2018-02-25 20:15:03.584');
INSERT INTO "public"."contact" VALUES (139, NULL, NULL, 10000001389, 1, '2018-02-25 20:15:03.697');
INSERT INTO "public"."contact" VALUES (140, NULL, NULL, 10000001399, 1, '2018-02-25 20:15:03.811');
INSERT INTO "public"."contact" VALUES (141, NULL, NULL, 1000000149, 1, '2018-02-25 20:15:03.924');
INSERT INTO "public"."contact" VALUES (142, NULL, NULL, 10000001419, 1, '2018-02-25 20:15:04.038');
INSERT INTO "public"."contact" VALUES (143, NULL, NULL, 10000001429, 1, '2018-02-25 20:15:04.151');
INSERT INTO "public"."contact" VALUES (144, NULL, NULL, 10000001439, 1, '2018-02-25 20:15:04.264');
INSERT INTO "public"."contact" VALUES (145, NULL, NULL, 10000001449, 1, '2018-02-25 20:15:04.378');
INSERT INTO "public"."contact" VALUES (146, NULL, NULL, 10000001459, 1, '2018-02-25 20:15:04.491');
INSERT INTO "public"."contact" VALUES (147, NULL, NULL, 10000001469, 1, '2018-02-25 20:15:04.604');
INSERT INTO "public"."contact" VALUES (148, NULL, NULL, 10000001479, 1, '2018-02-25 20:15:04.719');
INSERT INTO "public"."contact" VALUES (149, NULL, NULL, 10000001489, 1, '2018-02-25 20:15:04.832');
INSERT INTO "public"."contact" VALUES (150, NULL, NULL, 10000001499, 1, '2018-02-25 20:15:04.946');
INSERT INTO "public"."contact" VALUES (151, NULL, NULL, 1000000159, 1, '2018-02-25 20:15:05.059');
INSERT INTO "public"."contact" VALUES (152, NULL, NULL, 10000001519, 1, '2018-02-25 20:15:05.173');
INSERT INTO "public"."contact" VALUES (153, NULL, NULL, 10000001529, 1, '2018-02-25 20:15:05.287');
INSERT INTO "public"."contact" VALUES (154, NULL, NULL, 10000001539, 1, '2018-02-25 20:15:05.402');
INSERT INTO "public"."contact" VALUES (155, NULL, NULL, 10000001549, 1, '2018-02-25 20:15:05.515');
INSERT INTO "public"."contact" VALUES (156, NULL, NULL, 10000001559, 1, '2018-02-25 20:15:05.629');
INSERT INTO "public"."contact" VALUES (157, NULL, NULL, 10000001569, 1, '2018-02-25 20:15:05.742');
INSERT INTO "public"."contact" VALUES (158, NULL, NULL, 10000001579, 1, '2018-02-25 20:15:05.879');
INSERT INTO "public"."contact" VALUES (159, NULL, NULL, 10000001589, 1, '2018-02-25 20:15:05.992');
INSERT INTO "public"."contact" VALUES (160, NULL, NULL, 10000001599, 1, '2018-02-25 20:15:06.106');
INSERT INTO "public"."contact" VALUES (161, NULL, NULL, 1000000169, 1, '2018-02-25 20:15:06.219');
INSERT INTO "public"."contact" VALUES (162, NULL, NULL, 10000001619, 1, '2018-02-25 20:15:06.333');
INSERT INTO "public"."contact" VALUES (163, NULL, NULL, 10000001629, 1, '2018-02-25 20:15:06.447');
INSERT INTO "public"."contact" VALUES (164, NULL, NULL, 10000001639, 1, '2018-02-25 20:15:06.561');
INSERT INTO "public"."contact" VALUES (165, NULL, NULL, 10000001649, 1, '2018-02-25 20:15:06.674');
INSERT INTO "public"."contact" VALUES (166, NULL, NULL, 10000001659, 1, '2018-02-25 20:15:06.787');
INSERT INTO "public"."contact" VALUES (167, NULL, NULL, 10000001669, 1, '2018-02-25 20:15:06.901');
INSERT INTO "public"."contact" VALUES (168, NULL, NULL, 10000001679, 1, '2018-02-25 20:15:07.014');
INSERT INTO "public"."contact" VALUES (169, NULL, NULL, 94254655469, 1, '2018-02-26 06:03:12.802');
INSERT INTO "public"."contact" VALUES (170, NULL, NULL, 7896541238, 1, '2018-02-26 06:45:33.799');
INSERT INTO "public"."contact" VALUES (171, NULL, NULL, 9714031674, 1, '2018-02-26 07:31:31.677');
INSERT INTO "public"."contact" VALUES (172, NULL, NULL, 9922647161, 1, '2018-02-26 07:31:31.792');
INSERT INTO "public"."contact" VALUES (173, NULL, NULL, 9444484587, 1, '2018-02-26 07:31:31.906');
INSERT INTO "public"."contact" VALUES (174, NULL, NULL, 9898527223, 1, '2018-02-26 07:31:32.02');
INSERT INTO "public"."contact" VALUES (175, NULL, NULL, 9762908091, 1, '2018-02-26 07:31:32.134');
INSERT INTO "public"."contact" VALUES (176, NULL, NULL, 9001050424, 1, '2018-02-26 07:31:32.249');
INSERT INTO "public"."contact" VALUES (177, NULL, NULL, 9953240082, 1, '2018-02-26 07:31:32.363');
INSERT INTO "public"."contact" VALUES (178, NULL, NULL, 9885257564, 1, '2018-02-26 07:31:32.477');
INSERT INTO "public"."contact" VALUES (179, NULL, NULL, 8861591559, 1, '2018-02-26 07:31:32.591');
INSERT INTO "public"."contact" VALUES (180, NULL, NULL, 9902445526, 1, '2018-02-26 07:31:32.71');
INSERT INTO "public"."contact" VALUES (181, NULL, NULL, 8109305556, 1, '2018-02-26 07:31:32.824');
INSERT INTO "public"."contact" VALUES (182, NULL, NULL, 8460347299, 1, '2018-02-26 07:31:32.938');
INSERT INTO "public"."contact" VALUES (183, NULL, NULL, 9766849149, 1, '2018-02-26 07:31:33.051');
INSERT INTO "public"."contact" VALUES (184, NULL, NULL, 7359100109, 1, '2018-02-26 07:31:33.165');
INSERT INTO "public"."contact" VALUES (185, NULL, NULL, 9099374374, 1, '2018-02-26 07:31:33.279');
INSERT INTO "public"."contact" VALUES (186, NULL, NULL, 8809666009, 1, '2018-02-26 07:31:33.393');
INSERT INTO "public"."contact" VALUES (187, NULL, NULL, 9516718229, 1, '2018-02-26 07:31:33.507');
INSERT INTO "public"."contact" VALUES (188, NULL, NULL, 9375721595, 1, '2018-02-26 07:31:33.62');
INSERT INTO "public"."contact" VALUES (189, NULL, NULL, 7030673726, 1, '2018-02-26 07:31:33.734');
INSERT INTO "public"."contact" VALUES (190, NULL, NULL, 9768003427, 1, '2018-02-26 07:31:33.847');
INSERT INTO "public"."contact" VALUES (191, NULL, NULL, 9448074900, 1, '2018-02-26 07:31:33.961');
INSERT INTO "public"."contact" VALUES (192, NULL, NULL, 9998208370, 1, '2018-02-26 07:31:34.075');
INSERT INTO "public"."contact" VALUES (193, NULL, NULL, 9967769747, 1, '2018-02-26 07:31:34.189');
INSERT INTO "public"."contact" VALUES (194, NULL, NULL, 9642991488, 1, '2018-02-26 07:31:34.303');
INSERT INTO "public"."contact" VALUES (195, NULL, NULL, 9604889967, 1, '2018-02-26 07:31:34.417');
INSERT INTO "public"."contact" VALUES (196, NULL, NULL, 9742840870, 1, '2018-02-26 07:31:34.531');
INSERT INTO "public"."contact" VALUES (197, NULL, NULL, 70306737269, 1, '2018-02-26 07:31:34.683');
INSERT INTO "public"."contact" VALUES (198, NULL, NULL, 9500115128, 1, '2018-02-26 07:31:34.948');
INSERT INTO "public"."contact" VALUES (199, NULL, NULL, 7019218014, 1, '2018-02-26 07:31:35.062');
INSERT INTO "public"."contact" VALUES (200, NULL, NULL, 7405566573, 1, '2018-02-26 07:31:35.177');
INSERT INTO "public"."contact" VALUES (201, NULL, NULL, 8141703762, 1, '2018-02-26 07:31:35.291');
INSERT INTO "public"."contact" VALUES (202, NULL, NULL, 9719318255, 1, '2018-02-26 07:31:35.405');
INSERT INTO "public"."contact" VALUES (203, NULL, NULL, 9448357322, 1, '2018-02-26 07:31:35.52');
INSERT INTO "public"."contact" VALUES (204, NULL, NULL, 8888852098, 1, '2018-02-26 07:31:35.634');
INSERT INTO "public"."contact" VALUES (205, NULL, NULL, 7359098536, 1, '2018-02-26 07:31:35.747');
INSERT INTO "public"."contact" VALUES (206, NULL, NULL, 8097968010, 1, '2018-02-26 07:31:35.86');
INSERT INTO "public"."contact" VALUES (207, NULL, NULL, 9941779977, 1, '2018-02-26 07:31:35.974');
INSERT INTO "public"."contact" VALUES (208, NULL, NULL, 9909914657, 1, '2018-02-26 07:31:36.087');
INSERT INTO "public"."contact" VALUES (209, NULL, NULL, 9033834321, 1, '2018-02-26 07:31:36.204');
INSERT INTO "public"."contact" VALUES (210, NULL, NULL, 9173850046, 1, '2018-02-26 07:31:36.317');
INSERT INTO "public"."contact" VALUES (211, NULL, NULL, 9909683403, 1, '2018-02-26 07:31:36.43');
INSERT INTO "public"."contact" VALUES (212, NULL, NULL, 8527494774, 1, '2018-02-26 07:31:36.544');
INSERT INTO "public"."contact" VALUES (213, NULL, NULL, 9029865284, 1, '2018-02-26 07:31:36.657');
INSERT INTO "public"."contact" VALUES (214, NULL, NULL, 9444973016, 1, '2018-02-26 07:31:36.77');
INSERT INTO "public"."contact" VALUES (215, NULL, NULL, 9837041409, 1, '2018-02-26 07:31:36.883');
INSERT INTO "public"."contact" VALUES (216, NULL, NULL, 9904989523, 1, '2018-02-26 07:31:36.996');
INSERT INTO "public"."contact" VALUES (217, NULL, NULL, 9886488112, 1, '2018-02-26 07:31:37.11');
INSERT INTO "public"."contact" VALUES (218, NULL, NULL, 7874869883, 1, '2018-02-26 07:31:37.223');
INSERT INTO "public"."contact" VALUES (219, NULL, NULL, 9673928975, 1, '2018-02-26 07:31:37.336');
INSERT INTO "public"."contact" VALUES (220, NULL, NULL, 8141983147, 1, '2018-02-26 07:31:37.451');
INSERT INTO "public"."contact" VALUES (221, NULL, NULL, 9428300029, 1, '2018-02-26 07:31:37.564');
INSERT INTO "public"."contact" VALUES (222, NULL, NULL, 9790623835, 1, '2018-02-26 07:31:37.678');
INSERT INTO "public"."contact" VALUES (223, NULL, NULL, 9824822946, 1, '2018-02-26 07:31:37.791');
INSERT INTO "public"."contact" VALUES (224, NULL, NULL, 9868730911, 1, '2018-02-26 07:31:37.905');
INSERT INTO "public"."contact" VALUES (225, NULL, NULL, 7303484950, 1, '2018-02-26 07:31:38.018');
INSERT INTO "public"."contact" VALUES (226, NULL, NULL, 9112491268, 1, '2018-02-26 07:31:38.131');
INSERT INTO "public"."contact" VALUES (227, NULL, NULL, 9925666160, 1, '2018-02-26 07:31:38.244');
INSERT INTO "public"."contact" VALUES (228, NULL, NULL, 9998017710, 1, '2018-02-26 07:31:38.358');
INSERT INTO "public"."contact" VALUES (229, NULL, NULL, 9772121877, 1, '2018-02-26 07:31:38.471');
INSERT INTO "public"."contact" VALUES (230, NULL, NULL, 7201961919, 1, '2018-02-26 07:31:38.585');
INSERT INTO "public"."contact" VALUES (231, NULL, NULL, 9737703829, 1, '2018-02-26 07:31:38.698');
INSERT INTO "public"."contact" VALUES (232, NULL, NULL, 9324451410, 1, '2018-02-26 07:31:38.812');
INSERT INTO "public"."contact" VALUES (233, NULL, NULL, 9833555690, 1, '2018-02-26 07:31:38.925');
INSERT INTO "public"."contact" VALUES (234, NULL, NULL, 9772063085, 1, '2018-02-26 07:31:39.039');
INSERT INTO "public"."contact" VALUES (235, NULL, NULL, 8169243705, 1, '2018-02-26 07:31:39.152');
INSERT INTO "public"."contact" VALUES (236, NULL, NULL, 9028805509, 1, '2018-02-26 07:31:39.265');
INSERT INTO "public"."contact" VALUES (237, NULL, NULL, 9926675059, 1, '2018-02-26 07:33:43.589');
INSERT INTO "public"."contact" VALUES (238, NULL, NULL, 89894978089, 1, '2018-02-26 07:34:56.716');
INSERT INTO "public"."contact" VALUES (239, NULL, NULL, 1234567898, 1, '2018-02-26 07:38:04.479');
INSERT INTO "public"."contact" VALUES (240, NULL, NULL, 88888888889, 1, '2018-03-04 18:35:54.706');
INSERT INTO "public"."contact" VALUES (241, NULL, NULL, 55555555559, 1, '2018-03-04 18:41:49.43');
INSERT INTO "public"."contact" VALUES (242, NULL, NULL, 5555550, 1, '2018-03-04 18:53:04.001');
INSERT INTO "public"."contact" VALUES (243, NULL, NULL, 11111111119, 1, '2018-03-04 19:31:22.086');
INSERT INTO "public"."contact" VALUES (244, NULL, NULL, 33333333339, 1, '2018-03-04 22:36:01.715');

-- ----------------------------
-- Table structure for employee_task
-- ----------------------------
DROP TABLE IF EXISTS "public"."employee_task";
CREATE TABLE "public"."employee_task" (
  "id" int4 NOT NULL,
  "payment_amount" varchar(255) COLLATE "pg_catalog"."default",
  "payment_id" varchar(255) COLLATE "pg_catalog"."default",
  "payment_type" varchar(255) COLLATE "pg_catalog"."default",
  "status" varchar(255) COLLATE "pg_catalog"."default",
  "user_id" int4 NOT NULL,
  "contact_id" int4 NOT NULL,
  "created_by" int2,
  "created_at" timestamp(6)
)
;

-- ----------------------------
-- Records of employee_task
-- ----------------------------
INSERT INTO "public"."employee_task" VALUES (14, NULL, NULL, NULL, 'INCOMPLETE', 4, 13, 1, NULL);
INSERT INTO "public"."employee_task" VALUES (15, NULL, NULL, NULL, 'INCOMPLETE', 4, 14, 1, NULL);
INSERT INTO "public"."employee_task" VALUES (16, NULL, NULL, NULL, 'INCOMPLETE', 4, 15, 1, NULL);
INSERT INTO "public"."employee_task" VALUES (1, NULL, NULL, NULL, 'NOT_TRADE', 1, 1, 1, NULL);
INSERT INTO "public"."employee_task" VALUES (2, NULL, NULL, NULL, 'NOT_TRADE', 1, 2, 1, NULL);
INSERT INTO "public"."employee_task" VALUES (3, NULL, NULL, NULL, 'TRIAL', 1, 3, 1, NULL);
INSERT INTO "public"."employee_task" VALUES (4, NULL, NULL, NULL, 'TRIAL', 1, 4, 1, NULL);
INSERT INTO "public"."employee_task" VALUES (5, NULL, NULL, NULL, 'BUSY', 1, 5, 1, NULL);
INSERT INTO "public"."employee_task" VALUES (6, NULL, NULL, NULL, 'BUSY', 2, 239, 1, NULL);
INSERT INTO "public"."employee_task" VALUES (7, NULL, NULL, NULL, 'NOT_PICKED', 4, 6, 1, NULL);
INSERT INTO "public"."employee_task" VALUES (8, NULL, NULL, NULL, 'NO_NETWORK', 4, 7, 1, NULL);
INSERT INTO "public"."employee_task" VALUES (9, NULL, NULL, NULL, 'MOBILE_DOESNOT_EXIST', 4, 8, 1, NULL);
INSERT INTO "public"."employee_task" VALUES (10, NULL, NULL, NULL, 'CALL_LATER', 4, 9, 1, NULL);
INSERT INTO "public"."employee_task" VALUES (11, NULL, NULL, NULL, 'SWITCH_OFF', 4, 10, 1, NULL);
INSERT INTO "public"."employee_task" VALUES (12, NULL, NULL, NULL, 'NOT_REACHABLE', 4, 11, 1, NULL);
INSERT INTO "public"."employee_task" VALUES (13, NULL, NULL, NULL, 'AFTER_SOME_TIME', 4, 12, 1, NULL);

-- ----------------------------
-- Table structure for scrip_code
-- ----------------------------
DROP TABLE IF EXISTS "public"."scrip_code";
CREATE TABLE "public"."scrip_code" (
  "id" int4 NOT NULL,
  "symbol" varchar(255) COLLATE "pg_catalog"."default",
  "expiry" date,
  "mkt_lot" int4
)
;

-- ----------------------------
-- Table structure for useruser
-- ----------------------------
DROP TABLE IF EXISTS "public"."useruser";
CREATE TABLE "public"."useruser" (
  "id" int4 NOT NULL,
  "code" varchar(255) COLLATE "pg_catalog"."default",
  "email" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "mobile" int8 NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "password" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "user_type" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "image_url" text COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Uniques structure for table care_user
-- ----------------------------
ALTER TABLE "public"."care_user" ADD CONSTRAINT "care_user_email_key" UNIQUE ("email");
ALTER TABLE "public"."care_user" ADD CONSTRAINT "care_user_mobile_key" UNIQUE ("mobile");
ALTER TABLE "public"."care_user" ADD CONSTRAINT "ukekkjyv3gmmkbpiw8398iu9kgw" UNIQUE ("mobile");
ALTER TABLE "public"."care_user" ADD CONSTRAINT "ukd3q5cnojasmvb3oh32ur8ax2" UNIQUE ("email");
ALTER TABLE "public"."care_user" ADD CONSTRAINT "uk_ekkjyv3gmmkbpiw8398iu9kgw" UNIQUE ("mobile");
ALTER TABLE "public"."care_user" ADD CONSTRAINT "uk_d3q5cnojasmvb3oh32ur8ax2" UNIQUE ("email");

-- ----------------------------
-- Primary Key structure for table care_user
-- ----------------------------
ALTER TABLE "public"."care_user" ADD CONSTRAINT "care_user_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table city
-- ----------------------------
ALTER TABLE "public"."city" ADD CONSTRAINT "city_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table client_trail
-- ----------------------------
ALTER TABLE "public"."client_trail" ADD CONSTRAINT "client_trail_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table contact
-- ----------------------------
ALTER TABLE "public"."contact" ADD CONSTRAINT "contact_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table employee_task
-- ----------------------------
ALTER TABLE "public"."employee_task" ADD CONSTRAINT "employee_task_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table scrip_code
-- ----------------------------
ALTER TABLE "public"."scrip_code" ADD CONSTRAINT "scrip_code_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table client_trail
-- ----------------------------
ALTER TABLE "public"."client_trail" ADD CONSTRAINT "client_trail_contact_id_fkey" FOREIGN KEY ("contact_id") REFERENCES "public"."contact" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table contact
-- ----------------------------
ALTER TABLE "public"."contact" ADD CONSTRAINT "fk38b7242052cbbd7a" FOREIGN KEY ("uploaded_by") REFERENCES "public"."care_user" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table employee_task
-- ----------------------------
ALTER TABLE "public"."employee_task" ADD CONSTRAINT "employee_task_created_by_fkey" FOREIGN KEY ("created_by") REFERENCES "public"."care_user" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "public"."employee_task" ADD CONSTRAINT "fk87190476a3ef4f3" FOREIGN KEY ("user_id") REFERENCES "public"."care_user" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."employee_task" ADD CONSTRAINT "fk87190476ce113452" FOREIGN KEY ("contact_id") REFERENCES "public"."contact" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
