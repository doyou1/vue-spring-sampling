insert into memo (id, content, isdone)
select
   0, 'content1', false
where not exists (
    select 1 from memo where id = 0
);

insert into memo (id, content, isdone)
select
   1, 'content2', false
where not exists (
    select 1 from memo where id = 1
);

insert into memo (id, content, isdone)
select
   2, 'content3', false
where not exists (
    select 1 from memo where id = 2
);
