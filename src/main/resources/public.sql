/*
Navicat PGSQL Data Transfer

Source Server         : local
Source Server Version : 90606
Source Host           : localhost:5432
Source Database       : naman
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90606
File Encoding         : 65001

Date: 2018-03-13 19:48:45
*/


-- ----------------------------
-- Table structure for care_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."care_user";
CREATE TABLE "public"."care_user" (
"id" int4 NOT NULL,
"code" varchar(255) COLLATE "default",
"email" varchar(255) COLLATE "default" NOT NULL,
"mobile" int8 NOT NULL,
"name" varchar(255) COLLATE "default" NOT NULL,
"password" varchar(255) COLLATE "default" NOT NULL,
"user_type" varchar(255) COLLATE "default" NOT NULL,
"image_url" text COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of care_user
-- ----------------------------
INSERT INTO "public"."care_user" VALUES ('1', '1', 'abhinav@gmail.com', '9425465546', 'abhinav', 'test123', 'ADMIN', 'img/profile_small.jpg');
INSERT INTO "public"."care_user" VALUES ('2', null, 'invinf09@gmail.com', '9302757109', 'DEEPAK PRAJAPATI', 'DESA1263', 'EMPLOYEE', 'img/profile_small.jpg');
INSERT INTO "public"."care_user" VALUES ('3', null, 'amit@gmail.com', '9874563210', 'Amit', 'test123', 'EMPLOYEE', 'img/profile_small.jpg');
INSERT INTO "public"."care_user" VALUES ('4', null, 'rob@gmail.com', '987456321', ' rob', 'test123', 'EMPLOYEE', 'img/profile_small.jpg');
INSERT INTO "public"."care_user" VALUES ('5', null, 'arun@gmail.com', '1234567890', 'arun', 'test123', 'EMPLOYEE', 'img/profile_small.jpg');
INSERT INTO "public"."care_user" VALUES ('6', null, 'abc@gmail.comd', '45657', 'safsvgrg', 'test123gdgdfgdg', 'EMPLOYEE', null);
INSERT INTO "public"."care_user" VALUES ('7', null, 'abc@gmail.comwe', '2345', 'werewe', 'test123', 'EMPLOYEE', null);

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS "public"."city";
CREATE TABLE "public"."city" (
"id" int4 NOT NULL,
"city" varchar(255) COLLATE "default",
"state" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of city
-- ----------------------------

-- ----------------------------
-- Table structure for client_trail
-- ----------------------------
DROP TABLE IF EXISTS "public"."client_trail";
CREATE TABLE "public"."client_trail" (
"id" int4 NOT NULL,
"trail_start_date" date,
"trail_end_date" date,
"time" time(6),
"employee_task_id" int4,
"segment_id" int4,
"status" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of client_trail
-- ----------------------------
INSERT INTO "public"."client_trail" VALUES ('1', '2018-03-28', '2018-03-15', '12:10:00', '16', '3', 'TRIAL');
INSERT INTO "public"."client_trail" VALUES ('2', '2018-03-28', '2018-03-15', '12:10:00', '16', '2', 'TRIAL');
INSERT INTO "public"."client_trail" VALUES ('3', '2018-03-03', '2018-03-04', '12:05:00', '2', '2', 'TRIAL');
INSERT INTO "public"."client_trail" VALUES ('4', '2018-03-03', '2018-03-04', '12:05:00', '2', '2', 'TRIAL');
INSERT INTO "public"."client_trail" VALUES ('5', '2018-03-08', '2018-03-05', '13:05:00', '13', '2', 'TRIAL');
INSERT INTO "public"."client_trail" VALUES ('6', '2018-02-28', '2018-03-13', '01:05:00', '8', '2', 'TRIAL');
INSERT INTO "public"."client_trail" VALUES ('7', '2018-02-28', '2018-03-13', '01:05:00', '8', '3', 'TRIAL');
INSERT INTO "public"."client_trail" VALUES ('8', '2018-02-28', '2018-03-13', '01:05:00', '8', '1', 'TRIAL');

-- ----------------------------
-- Table structure for contact
-- ----------------------------
DROP TABLE IF EXISTS "public"."contact";
CREATE TABLE "public"."contact" (
"id" int4 NOT NULL,
"contact_location" varchar(255) COLLATE "default",
"contact_name" varchar(255) COLLATE "default",
"contact_number" int8 NOT NULL,
"uploaded_by" int4 NOT NULL,
"uploaded_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO "public"."contact" VALUES ('1', null, null, '109', '1', '2018-02-25 20:14:47.906');
INSERT INTO "public"."contact" VALUES ('2', null, null, '10000000019', '1', '2018-02-25 20:14:48.088');
INSERT INTO "public"."contact" VALUES ('3', null, null, '10000000029', '1', '2018-02-25 20:14:48.202');
INSERT INTO "public"."contact" VALUES ('4', null, null, '10000000039', '1', '2018-02-25 20:14:48.317');
INSERT INTO "public"."contact" VALUES ('5', null, null, '10000000049', '1', '2018-02-25 20:14:48.431');
INSERT INTO "public"."contact" VALUES ('6', null, null, '10000000059', '1', '2018-02-25 20:14:48.547');
INSERT INTO "public"."contact" VALUES ('7', null, null, '10000000069', '1', '2018-02-25 20:14:48.661');
INSERT INTO "public"."contact" VALUES ('8', null, null, '10000000079', '1', '2018-02-25 20:14:48.775');
INSERT INTO "public"."contact" VALUES ('9', null, null, '10000000089', '1', '2018-02-25 20:14:48.89');
INSERT INTO "public"."contact" VALUES ('10', null, null, '10000000099', '1', '2018-02-25 20:14:49.004');
INSERT INTO "public"."contact" VALUES ('11', null, null, '1000000019', '1', '2018-02-25 20:14:49.118');
INSERT INTO "public"."contact" VALUES ('12', null, null, '10000000119', '1', '2018-02-25 20:14:49.231');
INSERT INTO "public"."contact" VALUES ('13', null, null, '10000000129', '1', '2018-02-25 20:14:49.345');
INSERT INTO "public"."contact" VALUES ('14', null, null, '10000000139', '1', '2018-02-25 20:14:49.459');
INSERT INTO "public"."contact" VALUES ('15', null, null, '10000000149', '1', '2018-02-25 20:14:49.572');
INSERT INTO "public"."contact" VALUES ('16', null, null, '10000000159', '1', '2018-02-25 20:14:49.688');
INSERT INTO "public"."contact" VALUES ('17', null, null, '10000000169', '1', '2018-02-25 20:14:49.804');
INSERT INTO "public"."contact" VALUES ('18', null, null, '10000000179', '1', '2018-02-25 20:14:49.918');
INSERT INTO "public"."contact" VALUES ('19', null, null, '10000000189', '1', '2018-02-25 20:14:50.032');
INSERT INTO "public"."contact" VALUES ('20', null, null, '10000000199', '1', '2018-02-25 20:14:50.146');
INSERT INTO "public"."contact" VALUES ('21', null, null, '1000000029', '1', '2018-02-25 20:14:50.26');
INSERT INTO "public"."contact" VALUES ('22', null, null, '10000000219', '1', '2018-02-25 20:14:50.374');
INSERT INTO "public"."contact" VALUES ('23', null, null, '10000000229', '1', '2018-02-25 20:14:50.488');
INSERT INTO "public"."contact" VALUES ('24', null, null, '10000000239', '1', '2018-02-25 20:14:50.602');
INSERT INTO "public"."contact" VALUES ('25', null, null, '10000000249', '1', '2018-02-25 20:14:50.719');
INSERT INTO "public"."contact" VALUES ('26', null, null, '10000000259', '1', '2018-02-25 20:14:50.834');
INSERT INTO "public"."contact" VALUES ('27', null, null, '10000000269', '1', '2018-02-25 20:14:50.947');
INSERT INTO "public"."contact" VALUES ('28', null, null, '10000000279', '1', '2018-02-25 20:14:51.061');
INSERT INTO "public"."contact" VALUES ('29', null, null, '10000000289', '1', '2018-02-25 20:14:51.175');
INSERT INTO "public"."contact" VALUES ('30', null, null, '10000000299', '1', '2018-02-25 20:14:51.289');
INSERT INTO "public"."contact" VALUES ('31', null, null, '1000000039', '1', '2018-02-25 20:14:51.403');
INSERT INTO "public"."contact" VALUES ('32', null, null, '10000000319', '1', '2018-02-25 20:14:51.517');
INSERT INTO "public"."contact" VALUES ('33', null, null, '10000000329', '1', '2018-02-25 20:14:51.631');
INSERT INTO "public"."contact" VALUES ('34', null, null, '10000000339', '1', '2018-02-25 20:14:51.744');
INSERT INTO "public"."contact" VALUES ('35', null, null, '10000000349', '1', '2018-02-25 20:14:51.858');
INSERT INTO "public"."contact" VALUES ('36', null, null, '10000000359', '1', '2018-02-25 20:14:51.972');
INSERT INTO "public"."contact" VALUES ('37', null, null, '10000000369', '1', '2018-02-25 20:14:52.085');
INSERT INTO "public"."contact" VALUES ('38', null, null, '10000000379', '1', '2018-02-25 20:14:52.198');
INSERT INTO "public"."contact" VALUES ('39', null, null, '10000000389', '1', '2018-02-25 20:14:52.311');
INSERT INTO "public"."contact" VALUES ('40', null, null, '10000000399', '1', '2018-02-25 20:14:52.424');
INSERT INTO "public"."contact" VALUES ('41', null, null, '1000000049', '1', '2018-02-25 20:14:52.538');
INSERT INTO "public"."contact" VALUES ('42', null, null, '10000000419', '1', '2018-02-25 20:14:52.651');
INSERT INTO "public"."contact" VALUES ('43', null, null, '10000000429', '1', '2018-02-25 20:14:52.764');
INSERT INTO "public"."contact" VALUES ('44', null, null, '10000000439', '1', '2018-02-25 20:14:52.877');
INSERT INTO "public"."contact" VALUES ('45', null, null, '10000000449', '1', '2018-02-25 20:14:52.99');
INSERT INTO "public"."contact" VALUES ('46', null, null, '10000000459', '1', '2018-02-25 20:14:53.103');
INSERT INTO "public"."contact" VALUES ('47', null, null, '10000000469', '1', '2018-02-25 20:14:53.217');
INSERT INTO "public"."contact" VALUES ('48', null, null, '10000000479', '1', '2018-02-25 20:14:53.33');
INSERT INTO "public"."contact" VALUES ('49', null, null, '10000000489', '1', '2018-02-25 20:14:53.445');
INSERT INTO "public"."contact" VALUES ('50', null, null, '10000000499', '1', '2018-02-25 20:14:53.558');
INSERT INTO "public"."contact" VALUES ('51', null, null, '1000000059', '1', '2018-02-25 20:14:53.671');
INSERT INTO "public"."contact" VALUES ('52', null, null, '10000000519', '1', '2018-02-25 20:14:53.784');
INSERT INTO "public"."contact" VALUES ('53', null, null, '10000000529', '1', '2018-02-25 20:14:53.898');
INSERT INTO "public"."contact" VALUES ('54', null, null, '10000000539', '1', '2018-02-25 20:14:54.011');
INSERT INTO "public"."contact" VALUES ('55', null, null, '10000000549', '1', '2018-02-25 20:14:54.125');
INSERT INTO "public"."contact" VALUES ('56', null, null, '10000000559', '1', '2018-02-25 20:14:54.242');
INSERT INTO "public"."contact" VALUES ('57', null, null, '10000000569', '1', '2018-02-25 20:14:54.356');
INSERT INTO "public"."contact" VALUES ('58', null, null, '10000000579', '1', '2018-02-25 20:14:54.47');
INSERT INTO "public"."contact" VALUES ('59', null, null, '10000000589', '1', '2018-02-25 20:14:54.583');
INSERT INTO "public"."contact" VALUES ('60', null, null, '10000000599', '1', '2018-02-25 20:14:54.697');
INSERT INTO "public"."contact" VALUES ('61', null, null, '1000000069', '1', '2018-02-25 20:14:54.81');
INSERT INTO "public"."contact" VALUES ('62', null, null, '10000000619', '1', '2018-02-25 20:14:54.923');
INSERT INTO "public"."contact" VALUES ('63', null, null, '10000000629', '1', '2018-02-25 20:14:55.036');
INSERT INTO "public"."contact" VALUES ('64', null, null, '10000000639', '1', '2018-02-25 20:14:55.15');
INSERT INTO "public"."contact" VALUES ('65', null, null, '10000000649', '1', '2018-02-25 20:14:55.264');
INSERT INTO "public"."contact" VALUES ('66', null, null, '10000000659', '1', '2018-02-25 20:14:55.377');
INSERT INTO "public"."contact" VALUES ('67', null, null, '10000000669', '1', '2018-02-25 20:14:55.49');
INSERT INTO "public"."contact" VALUES ('68', null, null, '10000000679', '1', '2018-02-25 20:14:55.608');
INSERT INTO "public"."contact" VALUES ('69', null, null, '10000000689', '1', '2018-02-25 20:14:55.721');
INSERT INTO "public"."contact" VALUES ('70', null, null, '10000000699', '1', '2018-02-25 20:14:55.835');
INSERT INTO "public"."contact" VALUES ('71', null, null, '1000000079', '1', '2018-02-25 20:14:55.947');
INSERT INTO "public"."contact" VALUES ('72', null, null, '10000000719', '1', '2018-02-25 20:14:56.061');
INSERT INTO "public"."contact" VALUES ('73', null, null, '10000000729', '1', '2018-02-25 20:14:56.174');
INSERT INTO "public"."contact" VALUES ('74', null, null, '10000000739', '1', '2018-02-25 20:14:56.287');
INSERT INTO "public"."contact" VALUES ('75', null, null, '10000000749', '1', '2018-02-25 20:14:56.401');
INSERT INTO "public"."contact" VALUES ('76', null, null, '10000000759', '1', '2018-02-25 20:14:56.514');
INSERT INTO "public"."contact" VALUES ('77', null, null, '10000000769', '1', '2018-02-25 20:14:56.627');
INSERT INTO "public"."contact" VALUES ('78', null, null, '10000000779', '1', '2018-02-25 20:14:56.74');
INSERT INTO "public"."contact" VALUES ('79', null, null, '10000000789', '1', '2018-02-25 20:14:56.853');
INSERT INTO "public"."contact" VALUES ('80', null, null, '10000000799', '1', '2018-02-25 20:14:56.967');
INSERT INTO "public"."contact" VALUES ('81', null, null, '1000000089', '1', '2018-02-25 20:14:57.08');
INSERT INTO "public"."contact" VALUES ('82', null, null, '10000000819', '1', '2018-02-25 20:14:57.195');
INSERT INTO "public"."contact" VALUES ('83', null, null, '10000000829', '1', '2018-02-25 20:14:57.309');
INSERT INTO "public"."contact" VALUES ('84', null, null, '10000000839', '1', '2018-02-25 20:14:57.423');
INSERT INTO "public"."contact" VALUES ('85', null, null, '10000000849', '1', '2018-02-25 20:14:57.538');
INSERT INTO "public"."contact" VALUES ('86', null, null, '10000000859', '1', '2018-02-25 20:14:57.651');
INSERT INTO "public"."contact" VALUES ('87', null, null, '10000000869', '1', '2018-02-25 20:14:57.765');
INSERT INTO "public"."contact" VALUES ('88', null, null, '10000000879', '1', '2018-02-25 20:14:57.878');
INSERT INTO "public"."contact" VALUES ('89', null, null, '10000000889', '1', '2018-02-25 20:14:57.991');
INSERT INTO "public"."contact" VALUES ('90', null, null, '10000000899', '1', '2018-02-25 20:14:58.104');
INSERT INTO "public"."contact" VALUES ('91', null, null, '1000000099', '1', '2018-02-25 20:14:58.217');
INSERT INTO "public"."contact" VALUES ('92', null, null, '10000000919', '1', '2018-02-25 20:14:58.33');
INSERT INTO "public"."contact" VALUES ('93', null, null, '10000000929', '1', '2018-02-25 20:14:58.443');
INSERT INTO "public"."contact" VALUES ('94', null, null, '10000000939', '1', '2018-02-25 20:14:58.564');
INSERT INTO "public"."contact" VALUES ('95', null, null, '10000000949', '1', '2018-02-25 20:14:58.681');
INSERT INTO "public"."contact" VALUES ('96', null, null, '10000000959', '1', '2018-02-25 20:14:58.795');
INSERT INTO "public"."contact" VALUES ('97', null, null, '10000000969', '1', '2018-02-25 20:14:58.909');
INSERT INTO "public"."contact" VALUES ('98', null, null, '10000000979', '1', '2018-02-25 20:14:59.024');
INSERT INTO "public"."contact" VALUES ('99', null, null, '10000000989', '1', '2018-02-25 20:14:59.137');
INSERT INTO "public"."contact" VALUES ('100', null, null, '10000000999', '1', '2018-02-25 20:14:59.251');
INSERT INTO "public"."contact" VALUES ('101', null, null, '100000019', '1', '2018-02-25 20:14:59.365');
INSERT INTO "public"."contact" VALUES ('102', null, null, '10000001019', '1', '2018-02-25 20:14:59.478');
INSERT INTO "public"."contact" VALUES ('103', null, null, '10000001029', '1', '2018-02-25 20:14:59.592');
INSERT INTO "public"."contact" VALUES ('104', null, null, '10000001039', '1', '2018-02-25 20:14:59.709');
INSERT INTO "public"."contact" VALUES ('105', null, null, '10000001049', '1', '2018-02-25 20:14:59.822');
INSERT INTO "public"."contact" VALUES ('106', null, null, '10000001059', '1', '2018-02-25 20:14:59.937');
INSERT INTO "public"."contact" VALUES ('107', null, null, '10000001069', '1', '2018-02-25 20:15:00.05');
INSERT INTO "public"."contact" VALUES ('108', null, null, '10000001079', '1', '2018-02-25 20:15:00.165');
INSERT INTO "public"."contact" VALUES ('109', null, null, '10000001089', '1', '2018-02-25 20:15:00.278');
INSERT INTO "public"."contact" VALUES ('110', null, null, '10000001099', '1', '2018-02-25 20:15:00.393');
INSERT INTO "public"."contact" VALUES ('111', null, null, '1000000119', '1', '2018-02-25 20:15:00.507');
INSERT INTO "public"."contact" VALUES ('112', null, null, '10000001119', '1', '2018-02-25 20:15:00.622');
INSERT INTO "public"."contact" VALUES ('113', null, null, '10000001129', '1', '2018-02-25 20:15:00.736');
INSERT INTO "public"."contact" VALUES ('114', null, null, '10000001139', '1', '2018-02-25 20:15:00.85');
INSERT INTO "public"."contact" VALUES ('115', null, null, '10000001149', '1', '2018-02-25 20:15:00.964');
INSERT INTO "public"."contact" VALUES ('116', null, null, '10000001159', '1', '2018-02-25 20:15:01.079');
INSERT INTO "public"."contact" VALUES ('117', null, null, '10000001169', '1', '2018-02-25 20:15:01.194');
INSERT INTO "public"."contact" VALUES ('118', null, null, '10000001179', '1', '2018-02-25 20:15:01.307');
INSERT INTO "public"."contact" VALUES ('119', null, null, '10000001189', '1', '2018-02-25 20:15:01.423');
INSERT INTO "public"."contact" VALUES ('120', null, null, '10000001199', '1', '2018-02-25 20:15:01.537');
INSERT INTO "public"."contact" VALUES ('121', null, null, '1000000129', '1', '2018-02-25 20:15:01.651');
INSERT INTO "public"."contact" VALUES ('122', null, null, '10000001219', '1', '2018-02-25 20:15:01.765');
INSERT INTO "public"."contact" VALUES ('123', null, null, '10000001229', '1', '2018-02-25 20:15:01.879');
INSERT INTO "public"."contact" VALUES ('124', null, null, '10000001239', '1', '2018-02-25 20:15:01.992');
INSERT INTO "public"."contact" VALUES ('125', null, null, '10000001249', '1', '2018-02-25 20:15:02.106');
INSERT INTO "public"."contact" VALUES ('126', null, null, '10000001259', '1', '2018-02-25 20:15:02.22');
INSERT INTO "public"."contact" VALUES ('127', null, null, '10000001269', '1', '2018-02-25 20:15:02.334');
INSERT INTO "public"."contact" VALUES ('128', null, null, '10000001279', '1', '2018-02-25 20:15:02.448');
INSERT INTO "public"."contact" VALUES ('129', null, null, '10000001289', '1', '2018-02-25 20:15:02.563');
INSERT INTO "public"."contact" VALUES ('130', null, null, '10000001299', '1', '2018-02-25 20:15:02.676');
INSERT INTO "public"."contact" VALUES ('131', null, null, '1000000139', '1', '2018-02-25 20:15:02.79');
INSERT INTO "public"."contact" VALUES ('132', null, null, '10000001319', '1', '2018-02-25 20:15:02.903');
INSERT INTO "public"."contact" VALUES ('133', null, null, '10000001329', '1', '2018-02-25 20:15:03.016');
INSERT INTO "public"."contact" VALUES ('134', null, null, '10000001339', '1', '2018-02-25 20:15:03.13');
INSERT INTO "public"."contact" VALUES ('135', null, null, '10000001349', '1', '2018-02-25 20:15:03.243');
INSERT INTO "public"."contact" VALUES ('136', null, null, '10000001359', '1', '2018-02-25 20:15:03.356');
INSERT INTO "public"."contact" VALUES ('137', null, null, '10000001369', '1', '2018-02-25 20:15:03.47');
INSERT INTO "public"."contact" VALUES ('138', null, null, '10000001379', '1', '2018-02-25 20:15:03.584');
INSERT INTO "public"."contact" VALUES ('139', null, null, '10000001389', '1', '2018-02-25 20:15:03.697');
INSERT INTO "public"."contact" VALUES ('140', null, null, '10000001399', '1', '2018-02-25 20:15:03.811');
INSERT INTO "public"."contact" VALUES ('141', null, null, '1000000149', '1', '2018-02-25 20:15:03.924');
INSERT INTO "public"."contact" VALUES ('142', null, null, '10000001419', '1', '2018-02-25 20:15:04.038');
INSERT INTO "public"."contact" VALUES ('143', null, null, '10000001429', '1', '2018-02-25 20:15:04.151');
INSERT INTO "public"."contact" VALUES ('144', null, null, '10000001439', '1', '2018-02-25 20:15:04.264');
INSERT INTO "public"."contact" VALUES ('145', null, null, '10000001449', '1', '2018-02-25 20:15:04.378');
INSERT INTO "public"."contact" VALUES ('146', null, null, '10000001459', '1', '2018-02-25 20:15:04.491');
INSERT INTO "public"."contact" VALUES ('147', null, null, '10000001469', '1', '2018-02-25 20:15:04.604');
INSERT INTO "public"."contact" VALUES ('148', null, null, '10000001479', '1', '2018-02-25 20:15:04.719');
INSERT INTO "public"."contact" VALUES ('149', null, null, '10000001489', '1', '2018-02-25 20:15:04.832');
INSERT INTO "public"."contact" VALUES ('150', null, null, '10000001499', '1', '2018-02-25 20:15:04.946');
INSERT INTO "public"."contact" VALUES ('151', null, null, '1000000159', '1', '2018-02-25 20:15:05.059');
INSERT INTO "public"."contact" VALUES ('152', null, null, '10000001519', '1', '2018-02-25 20:15:05.173');
INSERT INTO "public"."contact" VALUES ('153', null, null, '10000001529', '1', '2018-02-25 20:15:05.287');
INSERT INTO "public"."contact" VALUES ('154', null, null, '10000001539', '1', '2018-02-25 20:15:05.402');
INSERT INTO "public"."contact" VALUES ('155', null, null, '10000001549', '1', '2018-02-25 20:15:05.515');
INSERT INTO "public"."contact" VALUES ('156', null, null, '10000001559', '1', '2018-02-25 20:15:05.629');
INSERT INTO "public"."contact" VALUES ('157', null, null, '10000001569', '1', '2018-02-25 20:15:05.742');
INSERT INTO "public"."contact" VALUES ('158', null, null, '10000001579', '1', '2018-02-25 20:15:05.879');
INSERT INTO "public"."contact" VALUES ('159', null, null, '10000001589', '1', '2018-02-25 20:15:05.992');
INSERT INTO "public"."contact" VALUES ('160', null, null, '10000001599', '1', '2018-02-25 20:15:06.106');
INSERT INTO "public"."contact" VALUES ('161', null, null, '1000000169', '1', '2018-02-25 20:15:06.219');
INSERT INTO "public"."contact" VALUES ('162', null, null, '10000001619', '1', '2018-02-25 20:15:06.333');
INSERT INTO "public"."contact" VALUES ('163', null, null, '10000001629', '1', '2018-02-25 20:15:06.447');
INSERT INTO "public"."contact" VALUES ('164', null, null, '10000001639', '1', '2018-02-25 20:15:06.561');
INSERT INTO "public"."contact" VALUES ('165', null, null, '10000001649', '1', '2018-02-25 20:15:06.674');
INSERT INTO "public"."contact" VALUES ('166', null, null, '10000001659', '1', '2018-02-25 20:15:06.787');
INSERT INTO "public"."contact" VALUES ('167', null, null, '10000001669', '1', '2018-02-25 20:15:06.901');
INSERT INTO "public"."contact" VALUES ('168', null, null, '10000001679', '1', '2018-02-25 20:15:07.014');
INSERT INTO "public"."contact" VALUES ('169', null, null, '94254655469', '1', '2018-02-26 06:03:12.802');
INSERT INTO "public"."contact" VALUES ('170', null, null, '7896541238', '1', '2018-02-26 06:45:33.799');
INSERT INTO "public"."contact" VALUES ('171', null, null, '9714031674', '1', '2018-02-26 07:31:31.677');
INSERT INTO "public"."contact" VALUES ('172', null, null, '9922647161', '1', '2018-02-26 07:31:31.792');
INSERT INTO "public"."contact" VALUES ('173', null, null, '9444484587', '1', '2018-02-26 07:31:31.906');
INSERT INTO "public"."contact" VALUES ('174', null, null, '9898527223', '1', '2018-02-26 07:31:32.02');
INSERT INTO "public"."contact" VALUES ('175', null, null, '9762908091', '1', '2018-02-26 07:31:32.134');
INSERT INTO "public"."contact" VALUES ('176', null, null, '9001050424', '1', '2018-02-26 07:31:32.249');
INSERT INTO "public"."contact" VALUES ('177', null, null, '9953240082', '1', '2018-02-26 07:31:32.363');
INSERT INTO "public"."contact" VALUES ('178', null, null, '9885257564', '1', '2018-02-26 07:31:32.477');
INSERT INTO "public"."contact" VALUES ('179', null, null, '8861591559', '1', '2018-02-26 07:31:32.591');
INSERT INTO "public"."contact" VALUES ('180', null, null, '9902445526', '1', '2018-02-26 07:31:32.71');
INSERT INTO "public"."contact" VALUES ('181', null, null, '8109305556', '1', '2018-02-26 07:31:32.824');
INSERT INTO "public"."contact" VALUES ('182', null, null, '8460347299', '1', '2018-02-26 07:31:32.938');
INSERT INTO "public"."contact" VALUES ('183', null, null, '9766849149', '1', '2018-02-26 07:31:33.051');
INSERT INTO "public"."contact" VALUES ('184', null, null, '7359100109', '1', '2018-02-26 07:31:33.165');
INSERT INTO "public"."contact" VALUES ('185', null, null, '9099374374', '1', '2018-02-26 07:31:33.279');
INSERT INTO "public"."contact" VALUES ('186', null, null, '8809666009', '1', '2018-02-26 07:31:33.393');
INSERT INTO "public"."contact" VALUES ('187', null, null, '9516718229', '1', '2018-02-26 07:31:33.507');
INSERT INTO "public"."contact" VALUES ('188', null, null, '9375721595', '1', '2018-02-26 07:31:33.62');
INSERT INTO "public"."contact" VALUES ('189', null, null, '7030673726', '1', '2018-02-26 07:31:33.734');
INSERT INTO "public"."contact" VALUES ('190', null, null, '9768003427', '1', '2018-02-26 07:31:33.847');
INSERT INTO "public"."contact" VALUES ('191', null, null, '9448074900', '1', '2018-02-26 07:31:33.961');
INSERT INTO "public"."contact" VALUES ('192', null, null, '9998208370', '1', '2018-02-26 07:31:34.075');
INSERT INTO "public"."contact" VALUES ('193', null, null, '9967769747', '1', '2018-02-26 07:31:34.189');
INSERT INTO "public"."contact" VALUES ('194', null, null, '9642991488', '1', '2018-02-26 07:31:34.303');
INSERT INTO "public"."contact" VALUES ('195', null, null, '9604889967', '1', '2018-02-26 07:31:34.417');
INSERT INTO "public"."contact" VALUES ('196', null, null, '9742840870', '1', '2018-02-26 07:31:34.531');
INSERT INTO "public"."contact" VALUES ('197', null, null, '70306737269', '1', '2018-02-26 07:31:34.683');
INSERT INTO "public"."contact" VALUES ('198', null, null, '9500115128', '1', '2018-02-26 07:31:34.948');
INSERT INTO "public"."contact" VALUES ('199', null, null, '7019218014', '1', '2018-02-26 07:31:35.062');
INSERT INTO "public"."contact" VALUES ('200', null, null, '7405566573', '1', '2018-02-26 07:31:35.177');
INSERT INTO "public"."contact" VALUES ('201', null, null, '8141703762', '1', '2018-02-26 07:31:35.291');
INSERT INTO "public"."contact" VALUES ('202', null, null, '9719318255', '1', '2018-02-26 07:31:35.405');
INSERT INTO "public"."contact" VALUES ('203', null, null, '9448357322', '1', '2018-02-26 07:31:35.52');
INSERT INTO "public"."contact" VALUES ('204', null, null, '8888852098', '1', '2018-02-26 07:31:35.634');
INSERT INTO "public"."contact" VALUES ('205', null, null, '7359098536', '1', '2018-02-26 07:31:35.747');
INSERT INTO "public"."contact" VALUES ('206', null, null, '8097968010', '1', '2018-02-26 07:31:35.86');
INSERT INTO "public"."contact" VALUES ('207', null, null, '9941779977', '1', '2018-02-26 07:31:35.974');
INSERT INTO "public"."contact" VALUES ('208', null, null, '9909914657', '1', '2018-02-26 07:31:36.087');
INSERT INTO "public"."contact" VALUES ('209', null, null, '9033834321', '1', '2018-02-26 07:31:36.204');
INSERT INTO "public"."contact" VALUES ('210', null, null, '9173850046', '1', '2018-02-26 07:31:36.317');
INSERT INTO "public"."contact" VALUES ('211', null, null, '9909683403', '1', '2018-02-26 07:31:36.43');
INSERT INTO "public"."contact" VALUES ('212', null, null, '8527494774', '1', '2018-02-26 07:31:36.544');
INSERT INTO "public"."contact" VALUES ('213', null, null, '9029865284', '1', '2018-02-26 07:31:36.657');
INSERT INTO "public"."contact" VALUES ('214', null, null, '9444973016', '1', '2018-02-26 07:31:36.77');
INSERT INTO "public"."contact" VALUES ('215', null, null, '9837041409', '1', '2018-02-26 07:31:36.883');
INSERT INTO "public"."contact" VALUES ('216', null, null, '9904989523', '1', '2018-02-26 07:31:36.996');
INSERT INTO "public"."contact" VALUES ('217', null, null, '9886488112', '1', '2018-02-26 07:31:37.11');
INSERT INTO "public"."contact" VALUES ('218', null, null, '7874869883', '1', '2018-02-26 07:31:37.223');
INSERT INTO "public"."contact" VALUES ('219', null, null, '9673928975', '1', '2018-02-26 07:31:37.336');
INSERT INTO "public"."contact" VALUES ('220', null, null, '8141983147', '1', '2018-02-26 07:31:37.451');
INSERT INTO "public"."contact" VALUES ('221', null, null, '9428300029', '1', '2018-02-26 07:31:37.564');
INSERT INTO "public"."contact" VALUES ('222', null, null, '9790623835', '1', '2018-02-26 07:31:37.678');
INSERT INTO "public"."contact" VALUES ('223', null, null, '9824822946', '1', '2018-02-26 07:31:37.791');
INSERT INTO "public"."contact" VALUES ('224', null, null, '9868730911', '1', '2018-02-26 07:31:37.905');
INSERT INTO "public"."contact" VALUES ('225', null, null, '7303484950', '1', '2018-02-26 07:31:38.018');
INSERT INTO "public"."contact" VALUES ('226', null, null, '9112491268', '1', '2018-02-26 07:31:38.131');
INSERT INTO "public"."contact" VALUES ('227', null, null, '9925666160', '1', '2018-02-26 07:31:38.244');
INSERT INTO "public"."contact" VALUES ('228', null, null, '9998017710', '1', '2018-02-26 07:31:38.358');
INSERT INTO "public"."contact" VALUES ('229', null, null, '9772121877', '1', '2018-02-26 07:31:38.471');
INSERT INTO "public"."contact" VALUES ('230', null, null, '7201961919', '1', '2018-02-26 07:31:38.585');
INSERT INTO "public"."contact" VALUES ('231', null, null, '9737703829', '1', '2018-02-26 07:31:38.698');
INSERT INTO "public"."contact" VALUES ('232', null, null, '9324451410', '1', '2018-02-26 07:31:38.812');
INSERT INTO "public"."contact" VALUES ('233', null, null, '9833555690', '1', '2018-02-26 07:31:38.925');
INSERT INTO "public"."contact" VALUES ('234', null, null, '9772063085', '1', '2018-02-26 07:31:39.039');
INSERT INTO "public"."contact" VALUES ('235', null, null, '8169243705', '1', '2018-02-26 07:31:39.152');
INSERT INTO "public"."contact" VALUES ('236', null, null, '9028805509', '1', '2018-02-26 07:31:39.265');
INSERT INTO "public"."contact" VALUES ('237', null, null, '9926675059', '1', '2018-02-26 07:33:43.589');
INSERT INTO "public"."contact" VALUES ('238', null, null, '89894978089', '1', '2018-02-26 07:34:56.716');
INSERT INTO "public"."contact" VALUES ('239', null, null, '1234567898', '1', '2018-02-26 07:38:04.479');
INSERT INTO "public"."contact" VALUES ('240', null, null, '88888888889', '1', '2018-03-04 18:35:54.706');
INSERT INTO "public"."contact" VALUES ('241', null, null, '55555555559', '1', '2018-03-04 18:41:49.43');
INSERT INTO "public"."contact" VALUES ('242', null, null, '5555550', '1', '2018-03-04 18:53:04.001');
INSERT INTO "public"."contact" VALUES ('243', null, null, '11111111119', '1', '2018-03-04 19:31:22.086');
INSERT INTO "public"."contact" VALUES ('244', null, null, '33333333339', '1', '2018-03-04 22:36:01.715');

-- ----------------------------
-- Table structure for employee_task
-- ----------------------------
DROP TABLE IF EXISTS "public"."employee_task";
CREATE TABLE "public"."employee_task" (
"id" int4 NOT NULL,
"status" varchar(255) COLLATE "default",
"user_id" int4 NOT NULL,
"contact_id" int4 NOT NULL,
"created_by" int2,
"created_at" timestamp(6),
"updated_at" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of employee_task
-- ----------------------------
INSERT INTO "public"."employee_task" VALUES ('1', 'INCOMPLETE', '4', '1', '1', null, null);
INSERT INTO "public"."employee_task" VALUES ('2', 'TRIAL', '4', '2', '1', null, '2018-03-13 19:31:34.691');
INSERT INTO "public"."employee_task" VALUES ('3', 'INCOMPLETE', '4', '3', '1', null, null);
INSERT INTO "public"."employee_task" VALUES ('4', 'INCOMPLETE', '4', '4', '1', null, null);
INSERT INTO "public"."employee_task" VALUES ('5', 'INCOMPLETE', '4', '5', '1', null, null);
INSERT INTO "public"."employee_task" VALUES ('6', 'INCOMPLETE', '4', '239', '1', null, null);
INSERT INTO "public"."employee_task" VALUES ('7', 'INCOMPLETE', '4', '6', '1', null, null);
INSERT INTO "public"."employee_task" VALUES ('8', 'TRIAL', '4', '7', '1', null, '2018-03-13 19:34:05.368');
INSERT INTO "public"."employee_task" VALUES ('9', 'INCOMPLETE', '4', '8', '1', null, null);
INSERT INTO "public"."employee_task" VALUES ('10', 'INCOMPLETE', '4', '9', '1', null, null);
INSERT INTO "public"."employee_task" VALUES ('11', 'INCOMPLETE', '4', '10', '1', null, null);
INSERT INTO "public"."employee_task" VALUES ('12', 'INCOMPLETE', '4', '11', '1', null, null);
INSERT INTO "public"."employee_task" VALUES ('13', 'TRAIL', '4', '12', '1', null, '2018-03-13 19:33:30.971');
INSERT INTO "public"."employee_task" VALUES ('14', 'INCOMPLETE', '4', '13', '1', null, null);
INSERT INTO "public"."employee_task" VALUES ('15', 'INCOMPLETE', '4', '14', '1', null, null);
INSERT INTO "public"."employee_task" VALUES ('16', 'TRIAL', '4', '15', '1', null, '2018-03-13 19:27:49.859');

-- ----------------------------
-- Table structure for scrip_code
-- ----------------------------
DROP TABLE IF EXISTS "public"."scrip_code";
CREATE TABLE "public"."scrip_code" (
"id" int4 NOT NULL,
"symbol" varchar(255) COLLATE "default",
"expiry" date,
"mkt_lot" int4,
"segment_id" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of scrip_code
-- ----------------------------
INSERT INTO "public"."scrip_code" VALUES ('1', 'ACC', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('2', 'ADANIENT ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('3', 'ADANIPORTS ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('4', 'ADANIPOWER ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('5', 'AJANTPHARM ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('6', 'ALBK ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('7', 'AMARAJABAT ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('8', 'AMBUJACEM', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('9', 'ANDHRABANK ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('10', 'APOLLOHOSP', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('11', 'APOLLOTYRE', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('12', 'ARVIND', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('13', 'ASHOKLEY', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('14', 'ASIANPAINT', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('15', 'AUROPHARMA', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('16', 'AXISBANK', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('17', 'BAJAJ-AUTO', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('18', 'BAJAJFINSV', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('19', 'BAJFINANCE', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('20', 'BALKRISIND', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('21', 'BALRAMCHIN', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('22', 'BANKBARODA', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('23', 'BANKINDIA ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('24', 'BANKNIFTY ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('25', 'BATAINDIA ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('26', 'BEL ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('27', 'BEML', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('28', 'BERGEPAINT', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('29', 'BHARATFIN ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('30', 'BHARATFORG', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('31', 'BHARTIARTL', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('32', 'BHEL', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('33', 'BIOCON', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('34', 'BOSCHLTD', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('35', 'BPCL', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('36', 'BRITANNIA ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('37', 'CADILAHC', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('38', 'CANBK ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('39', 'CANFINHOME', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('40', 'CAPF', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('41', 'CASTROLIND', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('42', 'CEATLTD ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('43', 'CENTURYTEX', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('44', 'CESC', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('45', 'CGPOWER ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('46', 'CHENNPETRO', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('47', 'CHOLAFIN', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('48', 'CIPLA ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('49', 'COALINDIA ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('50', 'COLPAL', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('51', 'CONCOR', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('52', 'CUMMINSIND', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('53', 'DABUR ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('54', 'DALMIABHA ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('55', 'DCBBANK ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('56', 'DHFL', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('57', 'DISHTV', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('58', 'DIVISLAB', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('59', 'DLF ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('60', 'DRREDDY ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('61', 'EICHERMOT ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('62', 'ENGINERSIN', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('63', 'EQUITAS ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('64', 'ESCORTS ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('65', 'EXIDEIND', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('66', 'FEDERALBNK', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('67', 'FORTIS', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('68', 'FTSE100 ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('69', 'GAIL', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('70', 'GLENMARK', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('71', 'GMRINFRA', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('72', 'GODFRYPHLP', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('73', 'GODREJCP', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('74', 'GODREJIND ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('75', 'GRANULES', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('76', 'GRASIM', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('77', 'GSFC', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('78', 'HAVELLS ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('79', 'HCC ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('80', 'HCLTECH ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('81', 'HDFC', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('82', 'HDFCBANK', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('83', 'HDIL', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('84', 'HEROMOTOCO', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('85', 'HEXAWARE', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('86', 'HINDALCO', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('87', 'HINDPETRO ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('88', 'HINDUNILVR', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('89', 'HINDZINC', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('90', 'IBULHSGFIN', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('91', 'ICICIBANK ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('92', 'ICICIPRULI', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('93', 'ICIL', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('94', 'IDBI', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('95', 'IDEA', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('96', 'IDFC', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('97', 'IDFCBANK', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('98', 'IFCI', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('99', 'IGL ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('100', 'INDIACEM ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('101', 'INDIANB', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('102', 'INDIAVIX ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('103', 'INDIGO ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('104', 'INDUSINDBK ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('105', 'INFIBEAM ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('106', 'INFRATEL ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('107', 'INFY ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('108', 'IOC', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('109', 'IRB', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('110', 'ITC', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('111', 'JETAIRWAYS ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('112', 'JINDALSTEL ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('113', 'JISLJALEQS ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('114', 'JPASSOCIAT ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('115', 'JSWENERGY', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('116', 'JSWSTEEL ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('117', 'JUBLFOOD ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('118', 'JUSTDIAL ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('119', 'KAJARIACER ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('120', 'KOTAKBANK', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('121', 'KPIT ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('122', 'KSCL ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('123', 'KTKBANK', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('124', 'L&TFH', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('125', 'LICHSGFIN', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('126', 'LT ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('127', 'LUPIN', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('128', 'M&M', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('129', 'M&MFIN ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('130', 'MANAPPURAM ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('131', 'MARICO ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('132', 'MARUTI ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('133', 'MCDOWELL-N ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('134', 'MCX', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('135', 'MFSL ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('136', 'MGL', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('137', 'MINDTREE ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('138', 'MOTHERSUMI ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('139', 'MRF', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('140', 'MRPL ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('141', 'MUTHOOTFIN ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('142', 'NATIONALUM ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('143', 'NBCC ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('144', 'NCC', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('145', 'NESTLEIND', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('146', 'NHPC ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('147', 'NIFTY', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('148', 'NIFTYCPSE', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('149', 'NIFTYINFRA ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('150', 'NIFTYIT', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('151', 'NIFTYMID50 ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('152', 'NIFTYPSE ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('153', 'NIITTECH ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('154', 'NMDC ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('155', 'NTPC ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('156', 'OFSS ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('157', 'OIL', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('158', 'ONGC ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('159', 'ORIENTBANK ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('160', 'PAGEIND', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('161', 'PCJEWELLER ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('162', 'PEL', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('163', 'PETRONET ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('164', 'PFC', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('165', 'PIDILITIND ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('166', 'PNB', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('167', 'POWERGRID', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('168', 'PTC', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('169', 'PVR', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('170', 'RAMCOCEM ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('171', 'RAYMOND', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('172', 'RBLBANK', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('173', 'RCOM ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('174', 'RECLTD ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('175', 'RELCAPITAL ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('176', 'RELIANCE ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('177', 'RELINFRA ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('178', 'REPCOHOME', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('179', 'RNAVAL ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('180', 'RPOWER ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('181', 'SAIL ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('182', 'SBIN ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('183', 'SHREECEM ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('184', 'SIEMENS', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('185', 'SOUTHBANK', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('186', 'SREINFRA ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('187', 'SRF', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('188', 'SRTRANSFIN ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('189', 'STAR ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('190', 'SUNPHARMA', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('191', 'SUNTV', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('192', 'SUZLON ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('193', 'SYNDIBANK', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('194', 'TATACHEM ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('195', 'TATACOMM ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('196', 'TATAELXSI', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('197', 'TATAGLOBAL ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('198', 'TATAMOTORS ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('199', 'TATAMTRDVR ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('200', 'TATAPOWER', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('201', 'TATASTEEL', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('202', 'TCS', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('203', 'TECHM', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('204', 'TITAN', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('205', 'TORNTPHARM ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('206', 'TORNTPOWER ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('207', 'TV18BRDCST ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('208', 'TVSMOTOR ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('209', 'UBL', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('210', 'UJJIVAN', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('211', 'ULTRACEMCO ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('212', 'UNIONBANK', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('213', 'UPL', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('214', 'VEDL ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('215', 'VGUARD ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('216', 'VOLTAS ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('217', 'WIPRO', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('218', 'WOCKPHARMA ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('219', 'YESBANK', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('220', 'ZEEL ', null, null, '4');
INSERT INTO "public"."scrip_code" VALUES ('221', 'equity child 2', null, null, '8');
INSERT INTO "public"."scrip_code" VALUES ('222', 'Gold', null, null, '6');
INSERT INTO "public"."scrip_code" VALUES ('223', 'Silver', null, null, '6');
INSERT INTO "public"."scrip_code" VALUES ('224', 'B Metal', null, null, '6');
INSERT INTO "public"."scrip_code" VALUES ('225', 'Crude Oil', null, null, '6');
INSERT INTO "public"."scrip_code" VALUES ('226', 'Other', null, null, '6');
INSERT INTO "public"."scrip_code" VALUES ('227', 'Agriculture', null, null, '7');
INSERT INTO "public"."scrip_code" VALUES ('228', 'Non Agriculture', null, null, '7');
INSERT INTO "public"."scrip_code" VALUES ('229', 'equity child', null, null, '8');

-- ----------------------------
-- Table structure for segment
-- ----------------------------
DROP TABLE IF EXISTS "public"."segment";
CREATE TABLE "public"."segment" (
"id" int4 NOT NULL,
"name" varchar(255) COLLATE "default",
"parent_id" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of segment
-- ----------------------------
INSERT INTO "public"."segment" VALUES ('1', 'EQUITY', null);
INSERT INTO "public"."segment" VALUES ('2', 'DERIVATIVE', null);
INSERT INTO "public"."segment" VALUES ('3', 'COMMODITY', null);
INSERT INTO "public"."segment" VALUES ('4', 'Future', '2');
INSERT INTO "public"."segment" VALUES ('5', 'Option', '2');
INSERT INTO "public"."segment" VALUES ('6', 'MCX', '3');
INSERT INTO "public"."segment" VALUES ('7', 'NCDEX', '3');
INSERT INTO "public"."segment" VALUES ('8', 'CASH', '1');

-- ----------------------------
-- Table structure for useruser
-- ----------------------------
DROP TABLE IF EXISTS "public"."useruser";
CREATE TABLE "public"."useruser" (
"id" int4 NOT NULL,
"code" varchar(255) COLLATE "default",
"email" varchar(255) COLLATE "default" NOT NULL,
"mobile" int8 NOT NULL,
"name" varchar(255) COLLATE "default" NOT NULL,
"password" varchar(255) COLLATE "default" NOT NULL,
"user_type" varchar(255) COLLATE "default" NOT NULL,
"image_url" text COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of useruser
-- ----------------------------

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Uniques structure for table care_user
-- ----------------------------
ALTER TABLE "public"."care_user" ADD UNIQUE ("email");
ALTER TABLE "public"."care_user" ADD UNIQUE ("mobile");
ALTER TABLE "public"."care_user" ADD UNIQUE ("mobile");
ALTER TABLE "public"."care_user" ADD UNIQUE ("email");
ALTER TABLE "public"."care_user" ADD UNIQUE ("mobile");
ALTER TABLE "public"."care_user" ADD UNIQUE ("email");

-- ----------------------------
-- Primary Key structure for table care_user
-- ----------------------------
ALTER TABLE "public"."care_user" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table city
-- ----------------------------
ALTER TABLE "public"."city" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table client_trail
-- ----------------------------
ALTER TABLE "public"."client_trail" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table contact
-- ----------------------------
ALTER TABLE "public"."contact" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table employee_task
-- ----------------------------
ALTER TABLE "public"."employee_task" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table scrip_code
-- ----------------------------
ALTER TABLE "public"."scrip_code" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table segment
-- ----------------------------
ALTER TABLE "public"."segment" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Key structure for table "public"."client_trail"
-- ----------------------------
ALTER TABLE "public"."client_trail" ADD FOREIGN KEY ("segment_id") REFERENCES "public"."segment" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "public"."client_trail" ADD FOREIGN KEY ("employee_task_id") REFERENCES "public"."employee_task" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."contact"
-- ----------------------------
ALTER TABLE "public"."contact" ADD FOREIGN KEY ("uploaded_by") REFERENCES "public"."care_user" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."employee_task"
-- ----------------------------
ALTER TABLE "public"."employee_task" ADD FOREIGN KEY ("created_by") REFERENCES "public"."care_user" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "public"."employee_task" ADD FOREIGN KEY ("user_id") REFERENCES "public"."care_user" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."employee_task" ADD FOREIGN KEY ("contact_id") REFERENCES "public"."contact" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."scrip_code"
-- ----------------------------
ALTER TABLE "public"."scrip_code" ADD FOREIGN KEY ("segment_id") REFERENCES "public"."segment" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
