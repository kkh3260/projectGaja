drop  sequence seq_comment;
 drop table comment_board purge;
create sequence seq_comment;
 
 create table comment_board(
cno number primary key,
contentid varchar2(50) not null,
commentname varchar2(50) not null,
commentpw number not null,
commenttxt varchar(300),
comment_date Date default sysdate,
comment_update Date default sysdate,
liked number default '0');
 
select * from seq_comment;
 
select * from comment_board;
insert into comment_board(cno,contentid, commentname,commentpw,commenttxt,liked) 
    values(seq_comment.nextval, '16650', 'user1',1234,'안녕',
   0);
    
   
  select * from comment_board where contentid =16650