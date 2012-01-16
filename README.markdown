Arquitectura del Software
==================

Aquest és el repositori del codi de l'implementació de les tres entregues que hem realitzat a Arquitectura del Software.

Autors:

+ Lorena Bes
+ Josep Lluis López
+ Miguel San Román

##Comentaris sobre el disseny

+ URL del repositori de codi: https://github.com/msanroman/AS
+ Hem intentat deixar el codi el més similar possible als diagrames de seqüència, tot i que a vegades un refactor del codi hauria estat una bona opció, a fi d'augmentar la claredat ja que la nostra idea es que es pugui seguir el codi amb el pdf dels diagrames a la ma.
+ Hem canviat la clau primària de reserva que era (nomHotel, numero, dataInici) per idReserva, ja que així ho podiem autoincrementar i ja era una clau candidata.
+ Hem passat més paràmetres a la trPagament perque si no no podiem accedir a dades com l'habitacio o el client que necessitaven afegir aquella reserva a les seves coleccions.

##Estructura de taules

    create table "ROOT".BONS_HOTELS
    (
      QUOTA_FIXA DOUBLE,
    	QUOTA_VARIABLE DOUBLE
    );
    
    
    create table "ROOT".CLIENT
    (
    	DNI VARCHAR(10) not null primary key,
    	NOM VARCHAR(50),
    	COGNOMS VARCHAR(100),
    	EMAIL VARCHAR(50)
    );
    
    create table "ROOT".CATEGORIA
    (
        NOM VARCHAR(50) not null primary key
    );
    
    create table "ROOT".POBLACIO
    (
    	NOM VARCHAR(100) not null primary key
    );
    
    create table "ROOT".HOTEL
    (
    	NOM VARCHAR(50) not null primary key,
    	DESCRIPCIO VARCHAR(500),
    	NOMCATEGORIA VARCHAR(50),
    	NOMPOBLACIO VARCHAR(100),
    FOREIGN KEY(NOMCATEGORIA) REFERENCES CATEGORIA(NOM),
    FOREIGN KEY(NOMPOBLACIO) REFERENCES POBLACIO(NOM)
    );
    
    create table "ROOT".COMENTARI
    (
    	NOM_HOTEL VARCHAR(50),
    	DNI_CLIENT VARCHAR(10),
    	DATA_COMENTARI TIMESTAMP,
    	AVALUACIO INTEGER,
    	DESCRIPCIO VARCHAR(500),
    PRIMARY KEY (NOM_HOTEL,DNI_CLIENT,DATA_COMENTARI),
    FOREIGN KEY(NOM_HOTEL) REFERENCES HOTEL(NOM),
    FOREIGN KEY(DNI_CLIENT) REFERENCES CLIENT(DNI)
    );
    
    create table "ROOT".TIPUS_HABITACIO
    (
    	NOM VARCHAR(50) not null primary key,
    	CAPACITAT INTEGER,
    	DESCRIPCIO VARCHAR(100)
    );
    
    create table "ROOT".HABITACIO
    (
    	NOM_HOTEL VARCHAR(50),
    	NUMERO INTEGER,
    	NOMTIPUS VARCHAR(50),
            PRIMARY KEY(NOM_HOTEL,NUMERO),
    FOREIGN KEY(NOMTIPUS) REFERENCES TIPUS_HABITACIO(NOM),
    FOREIGN KEY(NOM_HOTEL) REFERENCES HOTEL(NOM)
    );
    
    create table "ROOT".PREU_TIPUS_HABITACIO
    (
    	NOM_HOTEL VARCHAR(50),
    	NOMTIPUS VARCHAR(50),
    	PREU FLOAT,
    	PRIMARY KEY(NOM_HOTEL,NOMTIPUS),
    	FOREIGN KEY(NOM_HOTEL) REFERENCES HOTEL(NOM),
    	FOREIGN KEY(NOMTIPUS) REFERENCES TIPUS_HABITACIO(NOM)
    );
    
    CREATE TABLE PREUSTRATEGY (
        NOM_HOTEL VARCHAR(50),
        NOMTIPUS VARCHAR(50),
        PERCENTATGE FLOAT,
        DESCOMPTE FLOAT,
        PRIMARY KEY(NOM_HOTEL,NOMTIPUS),
        FOREIGN KEY(NOM_HOTEL,NOMTIPUS) REFERENCES PREU_TIPUS_HABITACIO(NOM_HOTEL, NOMTIPUS),
        CHECK ((PREUSTRATEGY.PERCENTATGE IS NOT NULL OR PREUSTRATEGY.DESCOMPTE IS NOT NULL) AND
        (PREUSTRATEGY.PERCENTATGE IS NULL OR PREUSTRATEGY.DESCOMPTE IS NULL))
    );
    
    
    create table "ROOT".RESERVA
    (
    	NOM_HOTEL VARCHAR(50),
    	NUMERO INTEGER,
    	DATA_INICI TIMESTAMP,
    	DATA_RESERVA TIMESTAMP,
    	DATA_FI TIMESTAMP,
    	ID_RESERVA INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    	PREU_TOTAL DOUBLE,
    	PRIMARY KEY(ID_RESERVA),
      FOREIGN KEY(NOM_HOTEL, NUMERO) REFERENCES HABITACIO(NOM_HOTEL, NUMERO)
    );

##Dades inserides

###Client

1. Miguel
2. Josep

###Poblacions

1. Manresa
2. Barcelona

###Hotels

1. Hotel Manresa
2. Hotel Pastel Manresa
3. Hotel Princesa Sofia
4. Hotel Pastel Sofia

###TipusHabitacio

1. Suite (tamany 3)
2. Standard (tamany 3)

###PreuTipusHabitacio (preus per dia amb els descomptes aplicats)

1. Una habitació al Hotel Manresa de tipus Suite val 400 €
2. Una habitació al Hotel Manresa de tipus Standard val 200 €
3. Una habitació al Hotel Pastel Manresa de tipus Suite val 200 €
4. Una habitació al Hotel Pastel Manresa de tipus Standard val 100 €
5. Una habitació al Hotel Princesa de tipus Suite val 2000 €
6. Una habitació al Hotel Princesa de tipus Standard val 1400 €
7. Una habitació al Hotel Pastel Sofia de tipus Suite val 400 €
8. Una habitació al Hotel Pastel Sofia de tipus Standard val 140 €

###Habitacio

1. Hotel Manresa té dos suites i una habitació standard
2. Hotel Pastel Manresa té una suite i dos habitacions standard.
3. Hotel Princesa Sofia té una suite i una standard.
4. Hotel Pastel Sofia només té una standard.
