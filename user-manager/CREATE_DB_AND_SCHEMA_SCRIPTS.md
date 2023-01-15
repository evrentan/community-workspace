# SCRIPTS for Creating DB & Schema

You can find the initial DDL scripts to create the DB & schema for user-manager service.


```postgresql
create database "user-manager-db"
with owner admin;

comment on database "user-manager-db" is 'User Manager DB';

create schema "user-manager";

comment on schema "user-manager" is 'User Manager Schema';

alter schema "user-manager" owner to admin;
```