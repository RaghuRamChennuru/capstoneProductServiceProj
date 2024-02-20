CREATE TABLE category
(
    id         BIGINT NOT NULL,
    created_on datetime NULL,
    updated_on datetime NULL,
    is_deleted BIT(1) NOT NULL,
    name       VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE jt_mentor
(
    id            BIGINT NOT NULL,
    qualification INT    NOT NULL,
    CONSTRAINT pk_jt_mentor PRIMARY KEY (id)
);

CREATE TABLE jt_ta
(
    id     BIGINT NOT NULL,
    rating INT    NOT NULL,
    CONSTRAINT pk_jt_ta PRIMARY KEY (id)
);

CREATE TABLE jt_user
(
    id   BIGINT NOT NULL,
    name VARCHAR(255) NULL,
    CONSTRAINT pk_jt_user PRIMARY KEY (id)
);

CREATE TABLE msc_mentor
(
    id            BIGINT NOT NULL,
    name          VARCHAR(255) NULL,
    qualification INT    NOT NULL,
    CONSTRAINT pk_msc_mentor PRIMARY KEY (id)
);

CREATE TABLE msc_ta
(
    id     BIGINT NOT NULL,
    name   VARCHAR(255) NULL,
    rating INT    NOT NULL,
    CONSTRAINT pk_msc_ta PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BIGINT NOT NULL,
    created_on    datetime NULL,
    updated_on    datetime NULL,
    is_deleted    BIT(1) NOT NULL,
    title         VARCHAR(255) NULL,
    price DOUBLE NULL,
    category_id   BIGINT NULL,
    `description` VARCHAR(255) NULL,
    url           VARCHAR(255) NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE stc_user
(
    id            BIGINT NOT NULL,
    user_type     INT NULL,
    name          VARCHAR(255) NULL,
    qualification INT    NOT NULL,
    rating        INT    NOT NULL,
    CONSTRAINT pk_stc_user PRIMARY KEY (id)
);

CREATE TABLE tpc_mentor
(
    id            BIGINT NOT NULL,
    name          VARCHAR(255) NULL,
    qualification INT    NOT NULL,
    CONSTRAINT pk_tpc_mentor PRIMARY KEY (id)
);

CREATE TABLE tpc_ta
(
    id     BIGINT NOT NULL,
    name   VARCHAR(255) NULL,
    rating INT    NOT NULL,
    CONSTRAINT pk_tpc_ta PRIMARY KEY (id)
);

CREATE TABLE tpc_user
(
    id   BIGINT NOT NULL,
    name VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_user PRIMARY KEY (id)
);

ALTER TABLE jt_mentor
    ADD CONSTRAINT FK_JT_MENTOR_ON_ID FOREIGN KEY (id) REFERENCES jt_user (id);

ALTER TABLE jt_ta
    ADD CONSTRAINT FK_JT_TA_ON_ID FOREIGN KEY (id) REFERENCES jt_user (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);