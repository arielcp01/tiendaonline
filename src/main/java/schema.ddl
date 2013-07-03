
    create table public.DetalleCompra (
        id int8 not null,
        cantidad int8,
        total numeric(19, 2),
        primary key (id)
    );

    create table public.OrdenCompra (
        id int8 not null,
        cantidad int4,
        estado varchar(255),
        fechaDeCompra date,
        total numeric(19, 2),
        usuario_id int8,
        primary key (id)
    );

    create table public.Tarjeta (
        id int8 not null,
        ciudad varchar(255),
        digitoVerificador numeric(19, 2),
        direccion varchar(255),
        fechaDeVencimiento date,
        marca varchar(255),
        nombre varchar(255),
        observaciones varchar(255),
        telefono varchar(255),
        primary key (id)
    );

    create table public.Usuario (
        id int8 not null,
        estado varchar(255),
        nivel int4,
        nombre varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table public.productos (
        id int4 not null,
        cantidad int4,
        descripcion varchar(255),
        iva numeric(19, 2),
        observaciones varchar(255),
        precio numeric(19, 2),
        primary key (id)
    );

    alter table public.OrdenCompra 
        add constraint FKD56B31486CC4E740 
        foreign key (usuario_id) 
        references public.Usuario;

    create sequence public.DetalleCompraSequence;

    create sequence public.OrdenDeCompraSequence;

    create sequence public.productoSequence;

    create sequence public.tarjetaSequence;

    create sequence public.usuarioSequence;
