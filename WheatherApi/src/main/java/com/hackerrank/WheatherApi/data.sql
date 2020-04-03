insert into location(ID,CITY_NAME,STATE_NAME,LATITUDE,LONGITUDE) values(1001,'chennai','tamilnadu',23,56);
insert into location(ID,CITY_NAME,STATE_NAME,LATITUDE,LONGITUDE) values(1002,'chennai','tamilnadu',23,56);
insert into location(ID,CITY_NAME,STATE_NAME,LATITUDE,LONGITUDE) values(1003,'chennai','tamilnadu',23,56);


insert into weather(ID,DATER,TEMPERATURE,LOCATION_ID) values(100,sysdate(),56,1001);
insert into weather(ID,DATER,TEMPERATURE,LOCATION_ID) values(101,sysdate(),56,1002);
insert into weather(ID,DATER,TEMPERATURE,LOCATION_ID) values(102,sysdate(),56,1003);
