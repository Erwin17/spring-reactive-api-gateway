# spring-reactive-api-gateway

## Construir en Proyecto
El proyecto tiene una configuración específica con Gradle para que, con una sola instrucción, se puedan compilar todos los proyectos al mismo tiempo.
Entonces, estando dentro del directorio principal, basta con ejecutar el siguiente comando:
```
./gradlew build
```
Y eso seria todo, tendriamos los microservicio compilados **(jar)** y listo para ejecutar.

## Construir Imagen con Docker & Docker Compose
Cada microservicio tiene un archivo **Dockerfile**, el cual define cómo se construirá la imagen del microservicio a partir de dicho archivo.

En la raíz del proyecto hay un archivo docker-compose que define los dos servicios con los que vamos a trabajar. **[api gateway, product]**.

Basta con estar en la raíz del directorio principal y ejecutar el siguinete commando:

```
docker compose build && docker compose up
```
Y eso seria todo,  deberiamos ver los dos contenedores arriba y los servicios funcionando.

## Consumir Servicios

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
