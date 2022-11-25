create table if not exists application_user
(
    id               uuid primary key default gen_random_uuid(),
    full_name        varchar(255),
    email            varchar(255),
    twitter_account  varchar(255),
    linkedin_account varchar(255),
    github_account   varchar(255),
    website_url      varchar(255),
    is_active        boolean default true
    );

comment on table application_user is 'Stores application user information';
comment on column application_user.id is 'Unique identifier for the application user. Type is uuid';
comment on column application_user.full_name is 'Full Name of the application user. Type is varchar(255)';
comment on column application_user.email is 'Email address of the application user. Type is varchar(255)';
comment on column application_user.twitter_account is 'Twitter account of the application user. Type is varchar(255)';
comment on column application_user.linkedin_account is 'Linkedin account of the application user. Type is varchar(255)';
comment on column application_user.github_account is 'Github account of the application user. Type is varchar(255)';
comment on column application_user.website_url is 'Website url of the application user. Type is varchar(255)';
comment on column application_user.is_active is 'Indicates whether the application user is active or not. Type is boolean and default is true';

create table if not exists user_type
(
    id      uuid primary key default gen_random_uuid(),
    code    varchar(16),
    description text,
    is_active boolean default true
    );

comment on table user_type is 'Stores user type information';
comment on column user_type.id is 'Unique identifier for the user type. Type is uuid';
comment on column user_type.code is 'Code of the user type. Type is varchar(16). Possible values; admin, owner, speaker, member, guest';
comment on column user_type.description is 'Description of the user type. Type is text';
comment on column user_type.is_active is 'Indicates whether the user type is active or not. Type is boolean and default is true';