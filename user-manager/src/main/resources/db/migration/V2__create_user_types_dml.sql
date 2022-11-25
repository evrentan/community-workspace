insert into user_type (id, code, description, is_active) values (gen_random_uuid(), 'admin', 'Administrator', true);
insert into user_type (id, code, description, is_active) values (gen_random_uuid(), 'owner', 'Owner of a Community', true);
insert into user_type (id, code, description, is_active) values (gen_random_uuid(), 'member', 'Member of a Community', true);
insert into user_type (id, code, description, is_active) values (gen_random_uuid(), 'speaker', 'Speaker in an Event', true);
insert into user_type (id, code, description, is_active) values (gen_random_uuid(), 'guest', 'Guest of an Event', true);