create table if not exists community
(
    id          uuid primary key default gen_random_uuid(),
    name        varchar(255),
    description text,
    is_active   boolean default true
    );

comment on table community is 'Stores community information';
comment on column community.id is 'Unique identifier for the community. Type is uuid';
comment on column community.name is 'Name of the community. Type is varchar(255)';
comment on column community.description is 'Description of the community. Type is text';
comment on column community.is_active is 'Indicates whether the community is active or not. Type is boolean and default is true';

create table if not exists community_user
(
    id          uuid primary key default gen_random_uuid(),
    community_id uuid,
    user_id     uuid,
    user_type_id uuid,
    is_active   boolean default true,
    foreign key (community_id) references community(id)
    );

comment on table community_user is 'Stores community user information';
comment on column community_user.id is 'Unique identifier for the community user. Type is uuid';
comment on column community_user.community_id is 'Unique identifier for the community. Type is uuid. Foreign key to community.id';
comment on column community_user.user_id is 'Unique identifier for the application user. Type is uuid. Referenced to application_user.id in user-manager-db';
comment on column community_user.user_type_id is 'Unique identifier for the user type. Type is uuid. Referenced to user_type.id in user-manager-db';
comment on column community_user.is_active is 'Indicates whether the community user is active or not. Type is boolean and default is true';