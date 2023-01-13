alter table event add column participant_limit integer;

comment on column event.participant_limit is 'Participant limit of the event fee. Type is integer. 0 or null means there is no participant limit';