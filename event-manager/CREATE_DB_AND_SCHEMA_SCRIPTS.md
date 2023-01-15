# SCRIPTS for Creating DB & Schema

You can find the initial DDL scripts to create the DB & schema for event-manager service.


```postgresql
create database "event-manager-db"
with owner admin;

comment on database "event-manager-db" is 'Event Manager DB';

create schema "event-manager";

comment on schema "event-manager" is 'Event Manager Schema';

alter schema "event-manager" owner to admin;
```