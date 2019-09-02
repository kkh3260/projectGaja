CREATE TABLE GAJA_schedule
(
userid varchar2(50) not null,
contentid NUMBER not null,
contentname VARCHAR2(30) NOT NULL,
year NUMBER NOT NULL,
month NUMBER NOT NULL,
day NUMBER NOT NULL
);


select * from GAJA_SCHEDULE;
select * from GAJA_SCHEDULE where year=2019 and month=8;
select * from GAJA_SCHEDULE;
select distinct day from GAJA_SCHEDULE where year=2019 and month=8  order by day;

CREATE TABLE GAJA_scecart(
userid varchar2(50) not null,
contentid NUMBER not null,
contenttypeid NUMBER not null,
contentname VARCHAR(30) NOT NULL
);

select * from GAJA_schedule;
select * from GAJA_scecart;

select contentname from GAJA_scecart where contentid=153;


insert into GAJA_SCHEDULE(contentid,contentname,year,month,day) 
select 153 as contentid,contentname,2019 as year, 8 as month, 17 as day 
from GAJA_scecart where contentid=153;

delete from GAJA_SCHEDULE where year=2019 and month=8 and day=19;

drop table GAJA_schedule;
drop table GAJA_scecart;


-----------------------------------------------------------------------------


create table tbl_member(
userid varchar2(50) not null primary key,
userpw varchar2(100) not null,
username varchar2(100) not null,
phone char(11),
email varchar2(200), 
gender varchar2(10), 
birth char(8),
regdate date default sysdate,
updatedate date default sysdate,
enabled char(1) default '1'
);

create table tbl_member_auth(
userid varchar2(50) not null,
auth varchar2(50) not null,
constraint fk_member_auth foreign key(userid) references tbl_member(userid));


select * from tbl_member;
select * from tbl_member_auth;

drop table tbl_member;
drop table tbl_member_auth;

// 자동 로그인 (스프링 시큐리티의 공식 문서에 나오는 지정된 형식의 테이블)
create table persistent_logins(
username varchar2(64) not null,
series varchar2(64) primary key,
token varchar2(64) not null,
last_used timestamp not null
);
select * from persistent_logins;
delete * from persistent_logins where username='67';
