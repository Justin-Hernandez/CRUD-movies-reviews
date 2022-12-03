*** Pasos a seguir para desplegar y probar los microservicios ***

1- Ejecutar docker compose en el directorio del proyecto para desplegar los contenedores de PostgreSQL, pgAdmin 4 y MongoDB.

2- Acceder a pgAdmin 4 y ejecutar los comandos en el archivo /db/PostgreSQL/db.sql

3- Acceder a MongoDB con MongoDB Compass o cualquier otra GUI y crear la base de datos "reviews_db". Una vez creada la base de datos, es necesario crear dos colecciones, "reviews" y "usuarios".

4- Importar el contenido de los archivos /db/MonogDB/reviews.json y /db/MonogDB/usuarios.json en las colecciones correspondientes.

5- Ejecutar cualquiera de los microservicios y probarlos con la coleccion de postman adjuntada (Micronaut_TFM.postman_collection.json).
