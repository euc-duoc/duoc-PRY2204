# 1. Configuración DB Mysql

## Creación de contenedor en Docker

**Creación inicial**

```bash
docker run --name datos-mysql -p 3306:3306 -v c:/mysql:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=1234 -d mysql:latest
```

**Volver a ejecutar**

```bash
docker start datos-mysql
```


