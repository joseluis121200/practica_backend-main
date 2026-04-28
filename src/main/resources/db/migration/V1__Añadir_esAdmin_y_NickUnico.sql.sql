ALTER TABLE usuarios ADD COLUMN es_admin BIT NOT NULL DEFAULT 0;

ALTER TABLE usuarios ADD UNIQUE (nick_usuario);

