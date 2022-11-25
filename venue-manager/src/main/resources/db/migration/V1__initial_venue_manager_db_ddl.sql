create table if not exists venue
(
    id          uuid primary key default gen_random_uuid(),
    name        varchar(255),
    description text,
    city        varchar(255),
    address     text,
    is_active   boolean          default true
    );

comment on table venue is 'Stores venue information';
comment on column venue.id is 'Unique identifier for the venue. Type is uuid';
comment on column venue.name is 'Name of the venue. Type is varchar(255)';
comment on column venue.description is 'Description of the venue. Type is text';
comment on column venue.city is 'City of the venue. Type is varchar(255)';
comment on column venue.address is 'Address of the venue. Type is text';
comment on column venue.is_active is 'Indicates whether the venue is active or not. Type is boolean and default is true';

create table if not exists room
(
    id          uuid primary key default gen_random_uuid(),
    name        varchar(255),
    description text,
    capacity    integer,
    is_active   boolean default true
    );

comment on table room is 'Stores room information';
comment on column room.id is 'Unique identifier for the room. Type is uuid';
comment on column room.name is 'Name of the room. Type is varchar(255)';
comment on column room.description is 'Description of the room. Type is text';
comment on column room.capacity is 'Capacity of the room. Type is integer';
comment on column room.is_active is 'Indicates whether the room is active or not. Type is boolean and default is true';

create table if not exists venue_room
(
    id          uuid primary key default gen_random_uuid(),
    venue_id    uuid,
    room_id     uuid,
    is_active   boolean default true,
    foreign key (venue_id) references venue (id),
    foreign key (room_id) references room (id)
    );

comment on table venue_room is 'Stores venue-room information';
comment on column venue_room.id is 'Unique identifier for the venue-room. Type is uuid';
comment on column venue_room.venue_id is 'Unique identifier for the venue. Type is uuid. Foreign key to venue.id';
comment on column venue_room.room_id is 'Unique identifier for the room. Type is uuid. Foreign key to room.id';
comment on column venue_room.is_active is 'Indicates whether the venue-room is active or not. Type is boolean and default is true';