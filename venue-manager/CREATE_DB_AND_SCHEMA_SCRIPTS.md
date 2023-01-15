# SCRIPTS for Creating DB & Schema

You can find the initial DDL scripts to create the DB & schema for venue-manager service.


```postgresql
create database "venue-manager-db"
with owner admin;

comment on database "venue-manager-db" is 'Venue Manager DB';

create schema "venue-manager";

comment on schema "venue-manager" is 'Venue Manager Schema';

alter schema "venue-manager" owner to admin;
```