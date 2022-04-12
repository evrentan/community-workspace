create table if not exists community (
    id uuid primary key default gen_random_uuid(),
    name varchar(255),
    description text
);

comment on table community is 'Stores community information';
comment on column community.id is 'Unique identifier for the community. Type is uuid';
comment on column community.name is 'Name of the community. Type is varchar(255)';
comment on column community.description is 'Description of the community. Type is text';

create table if not exists application_user (
    id uuid primary key default gen_random_uuid(),
    name varchar(255),
    email varchar(255),
    twitter_account varchar(255),
    linkedin_account varchar(255),
    github_account varchar(255),
    website_url varchar(255),
    user_type varchar(16)
);

comment on table application_user is 'Stores application user information';
comment on column application_user.id is 'Unique identifier for the application user. Type is uuid';
comment on column application_user.name is 'Name of the application user. Type is varchar(255)';
comment on column application_user.email is 'Email address of the application user. Type is varchar(255)';
comment on column application_user.twitter_account is 'Twitter account of the application user. Type is varchar(255)';
comment on column application_user.linkedin_account is 'Linkedin account of the application user. Type is varchar(255)';
comment on column application_user.github_account is 'Github account of the application user. Type is varchar(255)';
comment on column application_user.website_url is 'Website url of the application user. Type is varchar(255)';
comment on column application_user.user_type is 'Type of the application user. Type is varchar(16). Possible values; OWNER, ADMIN, SPEAKER, MEMBER';

create table if not exists speaker (
    id uuid primary key default gen_random_uuid(),
    user_id uuid,
    foreign key (user_id) references application_user (id)
);

comment on table speaker is 'Stores speaker information';
comment on column speaker.id is 'Unique identifier for the speaker. Type is uuid';
comment on column speaker.user_id is 'Unique identifier for the application user. Type is uuid. Foreign key to application_user.id';

create table if not exists venue (
    id uuid primary key default gen_random_uuid(),
    name varchar(255),
    description text,
    city varchar(255),
    address text
);

comment on table venue is 'Stores venue information';
comment on column venue.id is 'Unique identifier for the venue. Type is uuid';
comment on column venue.name is 'Name of the venue. Type is varchar(255)';
comment on column venue.description is 'Description of the venue. Type is text';
comment on column venue.city is 'City of the venue. Type is varchar(255)';
comment on column venue.address is 'Address of the venue. Type is text';

create table if not exists event (
    id uuid primary key default gen_random_uuid(),
    name varchar(255),
    description text,
    event_date timestamptz,
    is_online boolean,
    event_url varchar(255),
    is_free boolean,
    event_fee numeric(10,2),
    event_fee_currency varchar(255)
);

comment on table event is 'Stores event information';
comment on column event.id is 'Unique identifier for the event. Type is uuid';
comment on column event.name is 'Name of the event. Type is varchar(255)';
comment on column event.description is 'Description of the event. Type is text';
comment on column event.event_date is 'Date of the event. Type is timestamp with time zone';
comment on column event.is_online is 'Indicates if the event is online. Type is boolean';
comment on column event.event_url is 'URL of the event. Type is varchar(255)';
comment on column event.is_free is 'Indicates if the event is free. Type is boolean';
comment on column event.event_fee is 'Fee of the event. Type is numeric(10,2)';
comment on column event.event_fee_currency is 'Currency of the event fee. Type is varchar(255)';

create table if not exists guest (
    id uuid primary key default gen_random_uuid(),
    user_id uuid,
    foreign key (user_id) references application_user (id)
);

comment on table guest is 'Stores guest information';
comment on column guest.id is 'Unique identifier for the guest. Type is uuid';
comment on column guest.user_id is 'Unique identifier for the application user. Type is uuid. Foreign key to application_user.id';

create table if not exists event_community_relation (
    id uuid primary key default gen_random_uuid(),
    event_id uuid,
    community_id uuid,
    foreign key (event_id) references event (id),
    foreign key (community_id) references community (id)
);

comment on table event_community_relation is 'Stores event community relation information';
comment on column event_community_relation.id is 'Unique identifier for the event community relation. Type is uuid';
comment on column event_community_relation.event_id is 'Unique identifier for the event. Type is uuid. Foreign key to event.id';
comment on column event_community_relation.community_id is 'Unique identifier for the community. Type is uuid. Foreign key to community.id';

create table if not exists event_venue_relation (
    id uuid primary key default gen_random_uuid(),
    event_id uuid,
    venue_id uuid,
    foreign key (event_id) references event (id),
    foreign key (venue_id) references venue (id)
);

comment on table event_venue_relation is 'Stores event venue relation information';
comment on column event_venue_relation.id is 'Unique identifier for the event venue relation. Type is uuid';
comment on column event_venue_relation.event_id is 'Unique identifier for the event. Type is uuid. Foreign key to event.id';
comment on column event_venue_relation.venue_id is 'Unique identifier for the venue. Type is uuid. Foreign key to venue.id';

create table if not exists event_speaker_relation (
    id uuid primary key default gen_random_uuid(),
    event_id uuid,
    speaker_id uuid,
    foreign key (event_id) references event (id),
    foreign key (speaker_id) references speaker (id)
);

comment on table event_speaker_relation is 'Stores event speaker relation information';
comment on column event_speaker_relation.id is 'Unique identifier for the event speaker relation. Type is uuid';
comment on column event_speaker_relation.event_id is 'Unique identifier for the event. Type is uuid. Foreign key to event.id';

create table if not exists event_guest_relation (
    id uuid primary key default gen_random_uuid(),
    event_id uuid,
    guest_id uuid,
    foreign key (event_id) references event (id),
    foreign key (guest_id) references guest (id)
);

comment on table event_guest_relation is 'Stores event guest relation information';
comment on column event_guest_relation.id is 'Unique identifier for the event guest relation. Type is uuid';
comment on column event_guest_relation.event_id is 'Unique identifier for the event. Type is uuid. Foreign key to event.id';