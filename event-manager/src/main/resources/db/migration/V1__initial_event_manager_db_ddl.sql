create table if not exists event
(
    id                 uuid primary key default gen_random_uuid(),
    name               varchar(255),
    description        text,
    is_active          boolean          default true,
    event_date         timestamptz,
    is_online          boolean,
    event_url          varchar(255),
    is_free            boolean,
    event_fee          numeric(10, 2),
    event_fee_currency varchar(255)
);

comment on table event is 'Stores event information';
comment on column event.id is 'Unique identifier for the event. Type is uuid';
comment on column event.name is 'Name of the event. Type is varchar(255)';
comment on column event.description is 'Description of the event. Type is text';
comment on column event.is_active is 'Indicates whether the event is active or not. Type is boolean and default is true';
comment on column event.event_date is 'Date of the event. Type is timestamp with time zone';
comment on column event.is_online is 'Indicates if the event is online. Type is boolean';
comment on column event.event_url is 'URL of the event. Type is varchar(255)';
comment on column event.is_free is 'Indicates if the event is free. Type is boolean';
comment on column event.event_fee is 'Fee of the event. Type is numeric(10,2)';
comment on column event.event_fee_currency is 'Currency of the event fee. Type is varchar(255)';

create table if not exists event_community
(
    id           uuid primary key default gen_random_uuid(),
    event_id     uuid,
    community_id uuid,
    is_active    boolean default true,
    foreign key (event_id) references event (id)
);

comment on table event_community is 'Stores event-community information';
comment on column event_community.id is 'Unique identifier for the event community relation. Type is uuid';
comment on column event_community.event_id is 'Unique identifier for the event. Type is uuid. Foreign key to event.id';
comment on column event_community.community_id is 'Unique identifier for the community. Type is uuid. Referenced to community.id in community-manager-db';
comment on column event_community.is_active is 'Indicates whether the event community relation is active or not. Type is boolean and default is true';

create table if not exists event_venue
(
    id       uuid primary key default gen_random_uuid(),
    event_id uuid,
    venue_id uuid,
    is_active boolean default true,
    foreign key (event_id) references event (id)
);

comment on table event_venue is 'Stores event-venue information';
comment on column event_venue.id is 'Unique identifier for the event venue relation. Type is uuid';
comment on column event_venue.event_id is 'Unique identifier for the event. Type is uuid. Foreign key to event.id';
comment on column event_venue.venue_id is 'Unique identifier for the venue. Type is uuid. Referenced to venue.id in venue-manager-db';
comment on column event_venue.is_active is 'Indicates whether the event venue relation is active or not. Type is boolean and default is true';

create table if not exists event_room
(
    id       uuid primary key default gen_random_uuid(),
    event_id uuid,
    room_id uuid,
    is_active boolean default true,
    foreign key (event_id) references event (id)
);

comment on table event_room is 'Stores event-room information';
comment on column event_room.id is 'Unique identifier for the event room relation. Type is uuid';
comment on column event_room.event_id is 'Unique identifier for the event. Type is uuid. Foreign key to event.id';
comment on column event_room.room_id is 'Unique identifier for the room. Type is uuid. Referenced to room.id in venue-manager-db';
comment on column event_room.is_active is 'Indicates whether the event room relation is active or not. Type is boolean and default is true';

create table if not exists event_participant
(
    id         uuid primary key default gen_random_uuid(),
    event_id   uuid,
    user_id uuid,
    user_type uuid,
    is_active  boolean default true,
    foreign key (event_id) references event (id)
);

comment on table event_participant is 'Stores event-participant information';
comment on column event_participant.id is 'Unique identifier for the event participant relation. Type is uuid';
comment on column event_participant.event_id is 'Unique identifier for the event. Type is uuid. Foreign key to event.id';
comment on column event_participant.user_id is 'Unique identifier for the application user. Type is uuid. Referenced to application_user.id in user-manager-db';
comment on column event_participant.user_type_id is 'Unique identifier for the user type. Type is uuid. Referenced to user_type.id in user-manager-db';
comment on column event_participant.is_active is 'Indicates whether the event participant relation is active or not. Type is boolean and default is true';
