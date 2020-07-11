### spring mvc sample app a

#### Database Setting
bash
```
$ docker-compose up -d
$ docker exec -it mvc-service-a bash;
root@<CONTAINER ID>:/# psql -U postgres;
postgres=# CREATE DATABASE user;
``` 