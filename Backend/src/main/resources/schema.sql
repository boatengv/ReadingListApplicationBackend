CREATE TABLE IF NOT EXISTS public.book
(
    book_id character varying COLLATE pg_catalog."default" NOT NULL,
    student_id uuid NOT NULL,
    state character varying COLLATE pg_catalog."default",
    "timestamp" bigint,
    review double precision DEFAULT 0,
    CONSTRAINT book_pk PRIMARY KEY (book_id, student_id)
);


CREATE TABLE IF NOT EXISTS public.student
(
    student_id uuid NOT NULL,
    email character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    password character varying(255) COLLATE pg_catalog."default",
    salt character varying(255) COLLATE pg_catalog."default",
    logged_in boolean DEFAULT false,
    CONSTRAINT student_pkey PRIMARY KEY (student_id),
    CONSTRAINT uniq_email UNIQUE (email)
);

CREATE TABLE IF NOT EXISTS public.book_details
(
    book_id character varying COLLATE pg_catalog."default" NOT NULL,
    title character varying COLLATE pg_catalog."default" NOT NULL,
    authors character varying COLLATE pg_catalog."default",
    publisher character varying COLLATE pg_catalog."default",
    published_date character varying COLLATE pg_catalog."default",
    page_count integer NOT NULL,
    category character varying COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default",
    thumbnail text COLLATE pg_catalog."default",
    review double precision DEFAULT 0,
    CONSTRAINT "BookDetails_pkey" PRIMARY KEY (book_id)
);

CREATE TABLE IF NOT EXISTS public.category
(
    category character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_categories PRIMARY KEY (category)
);