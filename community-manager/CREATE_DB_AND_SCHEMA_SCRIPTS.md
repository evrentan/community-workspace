# SCRIPTS for Creating DB & Schema

You can find the initial DDL scripts to create the DB & schema for community-manager service.


```postgresql
create database "community-manager-db"
with owner admin;

comment on database "community-manager-db" is 'Community Manager DB';

create schema "community-manager";

comment on schema "community-manager" is 'Community Manager Schema';

alter schema "community-manager" owner to admin;
```