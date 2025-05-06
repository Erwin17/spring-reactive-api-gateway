# spring-reactive-api-gateway

## Construir en Proyecto
El proyecto tiene una configuracion especifica con gradle para que con una sola instruccion se puedan compilar todo los proyectos al mismo tiempo.
Entonces, entando dentro del directorio principa basta con ejeuctar el siguiente comando:

```
./gradlew build
```
Y eso seria todo, tendriamos los microservicio compilados (jar) listo para ejecutar.

## Construir Imagen con Docker & Docker Compose
Cada microservicio tiene un archivo Dockerfile el cual define como se construira la imagen del microservicio en base a dicho archivo (Dockerfile).

En la raiz del proyecto hay un docker-compose el cual define los dos servicio que vamos a trabajar **[api gateway, product]**.

Basta con estar en la raiz del directorio principal y ejecutar el siguinete commando:

```
docker compose build && docker compose up
```
Y eso seria todo,  deberiamos ver los dos contenedores arriba y los servicios funcionando.

### Obtener todos los productos
```
curl -X GET \
http://localhost:8080/api/product
```

### Eliminar un producto
```
curl -X DELETE \
http://localhost:8080/api/product/1
```

### Obtener los productos por ID
```
curl -X GET \
http://localhost:8080/api/product/1
```

### Crear un producto
```
curl -X POST \
-H "Content-type: application/json" \
-d '{"id": 100, "name": "product-100", "description": "description-100", "price": 500}' \
http://localhost:8080/api/product
```
