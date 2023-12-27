CREATE TABLE IF NOT EXISTS student
(
    student_id uuid NOT NULL,
    email character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    password character varying(255) COLLATE pg_catalog."default",
    username character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT student_pkey PRIMARY KEY (student_id)
)


CREATE TABLE IF NOT EXISTS book
(
    book_id uuid NOT NULL,
    student_id uuid,
    authors character varying(255) COLLATE pg_catalog."default",
    image_url_large character varying(255) COLLATE pg_catalog."default",
    image_url_medium character varying(255) COLLATE pg_catalog."default",
    image_url_small character varying(255) COLLATE pg_catalog."default",
    isbn character varying(255) COLLATE pg_catalog."default",
    published_date character varying(255) COLLATE pg_catalog."default",
    state character varying(255) COLLATE pg_catalog."default",
    subtitle character varying(255) COLLATE pg_catalog."default",
    title character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT book_pkey PRIMARY KEY (book_id),
    CONSTRAINT book_uniq UNIQUE (student_id, isbn),
    CONSTRAINT fk8ik6mo7lcgguka7gglqr88in1 FOREIGN KEY (student_id)
        REFERENCES public.student (student_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)