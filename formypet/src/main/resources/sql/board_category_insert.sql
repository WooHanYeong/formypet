insert into board_category (category_id,category_name) values (1,'자유게시판');
insert into board_category (category_id,category_name) values (2,'분양');
insert into board_category (category_id,category_name) values (3,'공지사항');
insert into board_category (category_id,category_name) values (4,'이벤트');

insert into board_sub_category (sub_category_id,sub_category_name, category_id) values (1,'전체',(select category_id from board_category where category_name = '자유게시판'));
insert into board_sub_category (sub_category_id,sub_category_name, category_id) values (2,'인기글',(select category_id from board_category where category_name = '자유게시판'));
insert into board_sub_category (sub_category_id,sub_category_name, category_id) values (3,'일상',(select category_id from board_category where category_name = '자유게시판'));
insert into board_sub_category (sub_category_id,sub_category_name, category_id) values (4,'자랑',(select category_id from board_category where category_name = '자유게시판'));

insert into board_sub_category (sub_category_id,sub_category_name, category_id) values (5,'강아지',(select category_id from board_category where category_name = '분양'));
insert into board_sub_category (sub_category_id,sub_category_name, category_id) values (6,'고양이',(select category_id from board_category where category_name = '분양'));