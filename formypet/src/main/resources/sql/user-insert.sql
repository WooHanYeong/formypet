/*
INSERT INTO userentity(USER_ID, USER_PASSWORD, USER_NAME, USER_ADDRESS, USER_ADDRESS_DETAIL,USER_BIRTH_DATE) 
VALUES('admin', 'admin', '관리자', '서울 강남구 가로수길 5 (신사동)','아이티윌',19960410);

INSERT INTO userentity(USER_ID, USER_PASSWORD, USER_NAME, USER_ADDRESS, USER_ADDRESS_DETAIL,USER_BIRTH_DATE) 
VALUES('96why', '0410', '우한영', '경기도 안양시 수리산로11','3동1호',19960410);
*/


INSERT INTO userentity(USER_ID, USER_PASSWORD, USER_NAME, USER_ADDRESS, USER_ADDRESS_DETAIL,USER_BIRTH_DATE) 
SELECT 'admin', 'admin', '관리자', '서울 강남구 가로수길 5 (신사동)', '아이티윌', 19960410 FROM dual
WHERE NOT EXISTS (SELECT 1 FROM userentity WHERE USER_ID = 'admin');

INSERT INTO userentity(USER_ID, USER_PASSWORD, USER_NAME, USER_ADDRESS, USER_ADDRESS_DETAIL, USER_BIRTH_DATE) 
SELECT '96why', '0410', '우한영', '경기도 안양시 수리산로11', '3동1호', 19960410 FROM dual
WHERE NOT EXISTS (SELECT 1 FROM userentity WHERE USER_ID = '96why');

insert into cart(CART_TOTAL_QTY , CART_TOTAL_PRICE , USER_ID )
values(0,0,1);

insert into cart(CART_TOTAL_QTY , CART_TOTAL_PRICE , USER_ID )
values(0,0,2);

commit;
