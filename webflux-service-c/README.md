### Database Config
bash
```
$ docker-compose up -d
$ docker exec -it <containerID> bash;
root@<containerID>:/# mongo -u mongo -p password;
root@<containerID>:/# use service_c
root@<containerID>:/# db.createCollection("comment")
root@<containerID>:/# [paste content from {sample/data.js}]
```
