select * from emaillist;

select count(*)
from emaillist
order by no desc;

delete from guestbook where no=1 and password = '1234';

desc guestbook;

-- insert
insert 
into guestbook
values(null, '안대혁', '1234', '안녕하세요~', now());

-- select
select name, password, message, date_format(reg_date, '%Y년 %m월 %d일' ) as regDate from guestbook;

select count(*)
from guestbook;
-- delete
delete
from guestbook
where name="1";

update guestbook set name="1" where name is null;