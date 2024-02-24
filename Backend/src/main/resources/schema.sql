CREATE TABLE IF NOT EXISTS public.book
(
    book_id uuid NOT NULL,
    student_id uuid,
    authors character varying(255) COLLATE pg_catalog."default",
    published_date character varying(255) COLLATE pg_catalog."default",
    state character varying(255) COLLATE pg_catalog."default",
    title character varying(255) COLLATE pg_catalog."default",
    page_count integer,
    publisher character varying COLLATE pg_catalog."default",
    categories text COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default",
    thumbnail text COLLATE pg_catalog."default",
    "timestamp" bigint,
    CONSTRAINT book_pkey PRIMARY KEY (book_id),
    CONSTRAINT fk8ik6mo7lcgguka7gglqr88in1 FOREIGN KEY (student_id)
        REFERENCES public.student (student_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

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
);