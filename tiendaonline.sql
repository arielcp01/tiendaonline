CREATE TABLE Tarjeta (
	TarNro numeric(20, 0) NOT NULL,
	TarMar bpchar(20),
	TarFchVen date,
	TarDig numeric(10, 0),
	TarNom bpchar(50),
	TarCalle bpchar(100),
	TarTel bpchar(20),
	PaisId numeric(10, 0),
	TarCiu bpchar(100),
	TarObs bpchar(50)
);
ALTER TABLE Tarjeta ADD CONSTRAINT TarNro01 PRIMARY KEY(TarNro);
CREATE TABLE Usuario (
	UsrId bpchar(12) NOT NULL,
	UsrNom bpchar(30),
	UsrPass bpchar(100),
	UsrNivel numeric(10, 0),
	UsrEst bpchar(1)
);
ALTER TABLE Usuario ADD CONSTRAINT Usr01 PRIMARY KEY(UsrId);
CREATE TABLE Productos (
	PrdId serial NOT NULL,
	PrdDsc text,
	PrdCant numeric(15, 0),
	PrdPrice numeric(15, 2),
	PrdObs bpchar(100),
	PrdImg bytea,
	PrdIva numeric(15, 2)
);
ALTER TABLE Productos ADD CONSTRAINT PrdId01 PRIMARY KEY(PrdId);
CREATE TABLE DetalleCompra (
	ComId serial NOT NULL,
	DetId serial NOT NULL,
	PrdId serial,
	DetCant numeric(10, 0),
	DetTot numeric(15, 2),
	DetIva numeric(15, 2),
	DetImp numeric(15, 2)
);
ALTER TABLE DetalleCompra ADD CONSTRAINT DetCom01 PRIMARY KEY(ComId,DetId);
CREATE TABLE OrdenCompra (
	ComId serial NOT NULL,
	ComFch date,
	ComCant numeric(15, 0),
	ComTot numeric(15, 2),
	ComTotIva numeric(15, 2),
	ComSes text,
	ComIp bpchar(20),
	Hora time,
	TarNro numeric(20, 0),
	ComEst bpchar(1),
	UsrId bpchar(12)
);
ALTER TABLE OrdenCompra ADD CONSTRAINT ComId01 PRIMARY KEY(ComId);
ALTER TABLE DetalleCompra ADD CONSTRAINT DetCom02 FOREIGN KEY (ComId) REFERENCES OrdenCompra(ComId) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE DetalleCompra ADD CONSTRAINT DetCom03 FOREIGN KEY (PrdId) REFERENCES Productos(PrdId) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE OrdenCompra ADD CONSTRAINT TarCom01 FOREIGN KEY (TarNro) REFERENCES Tarjeta(TarNro) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE OrdenCompra ADD CONSTRAINT ComId02 FOREIGN KEY (UsrId) REFERENCES Usuario(UsrId) ON DELETE NO ACTION ON UPDATE NO ACTION;