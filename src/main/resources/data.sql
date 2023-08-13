use testdb;
insert into employee values ('7fd921cfd2b64dc7b9966666209f6666','Anastasia Smeet','','2022-09-23 15:00:01','2022-09-23 15:00:01',true);
insert into employee values ('7fd921cfd2b64dc7b995633e8209f385','Joe Dou','','2022-09-23 15:00:01','2022-09-23 15:00:01',true);

insert into task_status values ('12345b26aesy9e39d1b68622f55c222','Defined','2022-09-18 12:00:00','2022-09-18 12:00:00',true);
insert into task_status values ('678910b26aesy9e39d1b68622f55c333','In-progress','2022-09-18 12:00:00','2022-09-18 12:00:00',true);
insert into task_status values ('114577b26aesy9e39d1b68622f55c444','Done','2022-09-18 12:00:00','2022-09-18 12:00:00',true);


insert into to_do values ('7fd921cfd2b64dc7b995633e8209f385','Buy
 Milk','2022-09-23 15:00:01','2022-09-23 15:00:01',false,'Done','7fd921cfd2b64dc7b9966666209f6666','7fd921cfd2b64dc7b9966666209f6666','114577b26aesy9e39d1b68622f55c444');
insert into to_do values ('5820a4c2abe74f409da89217bf905a0c','Read a
 Book','2022-09-02 16:00:01','2022-09-02 16:00:01',false,'Defined','7fd921cfd2b64dc7b9966666209f6666','7fd921cfd2b64dc7b9966666209f6666','12345b26aesy9e39d1b68622f55c222');
insert into to_do values ('a44b6db26aef49e39d1b68622f55c347','Learn Spring Boot','2022-09-18 12:00:00','2022-09-18 12:00:00',true,'In-progress','7fd921cfd2b64dc7b9966666209f6666','7fd921cfd2b64dc7b9966666209f6666','678910b26aesy9e39d1b68622f55c333');
insert into to_do values ('26ae6db26aef49e39d1b68622f55c343','Win a war!','2022-09-18 12:00:00','2022-09-18 12:00:00',false,'In-progress','7fd921cfd2b64dc7b9966666209f6666','7fd921cfd2b64dc7b9966666209f6666','678910b26aesy9e39d1b68622f55c333');
insert into to_do values ('261234526aef49e39d1b68622f55c343','Have a rest!','2022-09-18 12:00:00','2022-09-18 12:00:00',false,'Defined','7fd921cfd2b64dc7b9966666209f6666','7fd921cfd2b64dc7b9966666209f6666','12345b26aesy9e39d1b68622f55c222');




