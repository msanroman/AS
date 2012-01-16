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
