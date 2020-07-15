### Webflux Service B

#### Database Setting
bash
```
$ docker-compose up -d
$ docker exec -it webflux_service_b bash;
root@<CONTAINER ID>:/# psql -U postgres;
postgres=# CREATE DATABASE posts;
```