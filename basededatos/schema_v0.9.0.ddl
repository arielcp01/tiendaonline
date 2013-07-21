CREATE TABLE public.productos
(
  id integer NOT NULL,
  cantidad integer,
  descripcion character varying(255),
  iva numeric(19,2),
  observaciones character varying(255),
  precio numeric(19,2),
  CONSTRAINT productos_pkey PRIMARY KEY (id)
);

CREATE TABLE public.tarjeta
(
  id bigint NOT NULL,
  nrotarjeta bigint NOT NULL,
  ciudad character varying(255),
  digitoverificador numeric(19,2),
  direccion character varying(255),
  fechadevencimiento date,
  marca character varying(255),
  nombre character varying(255),
  observaciones character varying(255),
  telefono character varying(255),
  CONSTRAINT tarjeta_pkey PRIMARY KEY (id)
);

CREATE TABLE public.usuario
(
  id bigint NOT NULL,
  estado character varying(255),
  nivel integer,
  nombre character varying(255),
  password character varying(255),
  CONSTRAINT usuario_pkey PRIMARY KEY (id)
);

CREATE TABLE public.detallecompra
(
  id bigint NOT NULL,
  cantidad bigint,
  total numeric(19,2),
  ordencompra_id bigint,
  producto_id bigint,
  CONSTRAINT detallecompra_pkey PRIMARY KEY (id)
);

CREATE TABLE public.ordencompra
(
  id bigint NOT NULL,
  cantidad integer,
  estado character varying(255),
  fechadecompra date,
  total numeric(19,2),
  usuario_id bigint,
  tarjeta_id bigint,
  CONSTRAINT ordencompra_pkey PRIMARY KEY (id),
  CONSTRAINT fkd56b31486cc4e740 FOREIGN KEY (usuario_id)
      REFERENCES usuario (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

create sequence public.DetalleCompraSequence;

create sequence public.OrdenDeCompraSequence;

create sequence public.productoSequence;

create sequence public.tarjetaSequence;

create sequence public.usuarioSequence;
