comment on database "community-manager-db" is 'Community Manager DB';

create schema if not exists "community-manager";

comment on schema "community-manager" is 'Community Manager Schema';

alter schema "community-manager" owner to admin;