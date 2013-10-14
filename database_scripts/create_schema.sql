CREATE SCHEMA schema1
  AUTHORIZATION postgres;

GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO public;
COMMENT ON SCHEMA public
  IS 'schema was created for hibernatejsf project';

CREATE TABLE schema1.localusers
(
  user_id bigserial NOT NULL,
  user_password character varying(10) NOT NULL,
  user_name text NOT NULL,
  CONSTRAINT localusers_pkey PRIMARY KEY (user_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE schema1.localusers
  OWNER TO postgres;

INSERT INTO schema1.localusers (user_id, user_password, user_name) VALUES (36, '123', 'mike');
INSERT INTO schema1.localusers (user_id, user_password, user_name) VALUES (37, '123', 'test');



CREATE TABLE schema1.music
(
  music_id bigserial NOT NULL,
  music_content text NOT NULL,
  music_cost integer NOT NULL,
  music_type integer NOT NULL,
  CONSTRAINT music_pkey PRIMARY KEY (music_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE schema1.music
  OWNER TO postgres;

INSERT INTO schema1.music (music_id, music_content, music_cost, music_type) VALUES (14, 'Music_2', 100, 2);
INSERT INTO schema1.music (music_id, music_content, music_cost, music_type) VALUES (15, 'Music_3', 96, 3);
INSERT INTO schema1.music (music_id, music_content, music_cost, music_type) VALUES (17, 'Music_4', 100, 1);
INSERT INTO schema1.music (music_id, music_content, music_cost, music_type) VALUES (18, 'Music_5', 100, 1);
INSERT INTO schema1.music (music_id, music_content, music_cost, music_type) VALUES (19, 'Music_6', 200, 2);
INSERT INTO schema1.music (music_id, music_content, music_cost, music_type) VALUES (20, 'Music_7', 150, 3);
INSERT INTO schema1.music (music_id, music_content, music_cost, music_type) VALUES (21, 'Music_8', 210, 2);
INSERT INTO schema1.music (music_id, music_content, music_cost, music_type) VALUES (22, 'Music_9', 100, 3);
INSERT INTO schema1.music (music_id, music_content, music_cost, music_type) VALUES (13, 'Music_1', 200, 1);

CREATE TABLE schema1.user_music
(
  user_m_id bigserial NOT NULL,
  music_u_id bigserial NOT NULL,
  CONSTRAINT user_music_pkey PRIMARY KEY (user_m_id, music_u_id),
  CONSTRAINT fk_music_u_id FOREIGN KEY (music_u_id)
      REFERENCES schema1.music (music_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_user_m_id FOREIGN KEY (user_m_id)
      REFERENCES schema1.localusers (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE schema1.user_music
  OWNER TO postgres;

INSERT INTO schema1.user_music (user_m_id, music_u_id) VALUES (37, 14);
INSERT INTO schema1.user_music (user_m_id, music_u_id) VALUES (37, 17);
INSERT INTO schema1.user_music (user_m_id, music_u_id) VALUES (36, 17);
INSERT INTO schema1.user_music (user_m_id, music_u_id) VALUES (36, 13);
INSERT INTO schema1.user_music (user_m_id, music_u_id) VALUES (36, 15);

CREATE TABLE schema1.music_type
(
  music_type_id integer NOT NULL,
  music_type_description text NOT NULL,
  CONSTRAINT pk_music_type_id PRIMARY KEY (music_type_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE schema1.music_type
  OWNER TO postgres;

INSERT INTO schema1.music_type (music_type_id, music_type_description) VALUES (1, 'Hit');
INSERT INTO schema1.music_type (music_type_id, music_type_description) VALUES (2, 'Top');
INSERT INTO schema1.music_type (music_type_id, music_type_description) VALUES (3, 'New');
INSERT INTO schema1.music_type (music_type_id, music_type_description) VALUES (4, 'Other');




CREATE TABLE schema1.help_info
(
  help_info_id bigserial NOT NULL,
  help_info_content text NOT NULL,
  help_info_title text NOT NULL,
  CONSTRAINT pk_help_info PRIMARY KEY (help_info_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE schema1.help_info
  OWNER TO postgres;

INSERT INTO schema1.help_info (help_info_id, help_info_content, help_info_title) VALUES (2, 'Each track costs 100$', 'Cost');
INSERT INTO schema1.help_info (help_info_id, help_info_content, help_info_title) VALUES (1, 'Service allows to listen and buy a content!', 'Possibilities');



