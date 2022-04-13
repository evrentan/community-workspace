create table if not exists community
(
    id          uuid primary key default gen_random_uuid(),
    name        varchar(255),
    description text,
    is_active   boolean          default true
);

comment on table community is 'Stores community information';
comment on column community.id is 'Unique identifier for the community. Type is uuid';
comment on column community.name is 'Name of the community. Type is varchar(255)';
comment on column community.description is 'Description of the community. Type is text';
comment on column community.is_active is 'Indicates whether the community is active or not. Type is boolean and default is true';

create table if not exists application_user
(
    id               uuid primary key default gen_random_uuid(),
    full_name        varchar(255),
    email            varchar(255),
    twitter_account  varchar(255),
    linkedin_account varchar(255),
    github_account   varchar(255),
    website_url      varchar(255),
    user_type        varchar(16),
    is_active        boolean          default true
);

comment on table application_user is 'Stores application user information';
comment on column application_user.id is 'Unique identifier for the application user. Type is uuid';
comment on column application_user.full_name is 'Full Name of the application user. Type is varchar(255)';
comment on column application_user.email is 'Email address of the application user. Type is varchar(255)';
comment on column application_user.twitter_account is 'Twitter account of the application user. Type is varchar(255)';
comment on column application_user.linkedin_account is 'Linkedin account of the application user. Type is varchar(255)';
comment on column application_user.github_account is 'Github account of the application user. Type is varchar(255)';
comment on column application_user.website_url is 'Website url of the application user. Type is varchar(255)';
comment on column application_user.user_type is 'Type of the application user. Type is varchar(16). Possible values; OWNER, ADMIN, SPEAKER, MEMBER';
comment on column application_user.is_active is 'Indicates whether the application user is active or not. Type is boolean and default is true';

create table if not exists speaker
(
    id      uuid primary key default gen_random_uuid(),
    user_id uuid,
    is_active boolean default true,
    foreign key (user_id) references application_user (id)
);

comment on table speaker is 'Stores speaker information';
comment on column speaker.id is 'Unique identifier for the speaker. Type is uuid';
comment on column speaker.user_id is 'Unique identifier for the application user. Type is uuid. Foreign key to application_user.id';
comment on column speaker.is_active is 'Indicates whether the speaker is active or not. Type is boolean and default is true';

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

create table if not exists guest
(
    id      uuid primary key default gen_random_uuid(),
    user_id uuid,
    is_active boolean default true,
    foreign key (user_id) references application_user (id)
);

comment on table guest is 'Stores guest information';
comment on column guest.id is 'Unique identifier for the guest. Type is uuid';
comment on column guest.user_id is 'Unique identifier for the application user. Type is uuid. Foreign key to application_user.id';
comment on column guest.is_active is 'Indicates whether the guest is active or not. Type is boolean and default is true';

create table if not exists event_community
(
    id           uuid primary key default gen_random_uuid(),
    event_id     uuid,
    community_id uuid,
    is_active    boolean default true,
    foreign key (event_id) references event (id),
    foreign key (community_id) references community (id)
);

comment on table event_community is 'Stores event-community information';
comment on column event_community.id is 'Unique identifier for the event community relation. Type is uuid';
comment on column event_community.event_id is 'Unique identifier for the event. Type is uuid. Foreign key to event.id';
comment on column event_community.community_id is 'Unique identifier for the community. Type is uuid. Foreign key to community.id';
comment on column event_community.is_active is 'Indicates whether the event community relation is active or not. Type is boolean and default is true';

create table if not exists event_venue
(
    id       uuid primary key default gen_random_uuid(),
    event_id uuid,
    venue_id uuid,
    is_active boolean default true,
    foreign key (event_id) references event (id),
    foreign key (venue_id) references venue (id)
);

comment on table event_venue is 'Stores event-venue information';
comment on column event_venue.id is 'Unique identifier for the event venue relation. Type is uuid';
comment on column event_venue.event_id is 'Unique identifier for the event. Type is uuid. Foreign key to event.id';
comment on column event_venue.venue_id is 'Unique identifier for the venue. Type is uuid. Foreign key to venue.id';
comment on column event_venue.is_active is 'Indicates whether the event venue relation is active or not. Type is boolean and default is true';

create table if not exists event_room
(
    id       uuid primary key default gen_random_uuid(),
    event_id uuid,
    room_id uuid,
    is_active boolean default true,
    foreign key (event_id) references event (id),
    foreign key (room_id) references room (id)
);

comment on table event_room is 'Stores event-room information';
comment on column event_room.id is 'Unique identifier for the event room relation. Type is uuid';
comment on column event_room.event_id is 'Unique identifier for the event. Type is uuid. Foreign key to event.id';
comment on column event_room.room_id is 'Unique identifier for the room. Type is uuid. Foreign key to room.id';
comment on column event_room.is_active is 'Indicates whether the event room relation is active or not. Type is boolean and default is true';

create table if not exists event_speaker
(
    id         uuid primary key default gen_random_uuid(),
    event_id   uuid,
    speaker_id uuid,
    is_active  boolean default true,
    foreign key (event_id) references event (id),
    foreign key (speaker_id) references speaker (id)
);

comment on table event_speaker is 'Stores event-speaker information';
comment on column event_speaker.id is 'Unique identifier for the event speaker relation. Type is uuid';
comment on column event_speaker.event_id is 'Unique identifier for the event. Type is uuid. Foreign key to event.id';
comment on column event_speaker.speaker_id is 'Unique identifier for the speaker. Type is uuid. Foreign key to speaker.id';

create table if not exists event_guest
(
    id       uuid primary key default gen_random_uuid(),
    event_id uuid,
    guest_id uuid,
    is_active boolean default true,
    foreign key (event_id) references event (id),
    foreign key (guest_id) references guest (id)
);

comment on table event_guest is 'Stores event-guest information';
comment on column event_guest.id is 'Unique identifier for the event guest relation. Type is uuid';
comment on column event_guest.event_id is 'Unique identifier for the event. Type is uuid. Foreign key to event.id';
comment on column event_guest.guest_id is 'Unique identifier for the guest. Type is uuid. Foreign key to guest.id';