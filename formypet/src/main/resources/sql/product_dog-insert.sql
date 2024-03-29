-- 강아지 / 건사료 
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '건사료', '대주펫푸드 강아지사료', '대주펫푸드 강아지사료입니다.', 'defaultimg/강아지사료_대주펫푸드.jpg', 20000, 100, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '대주펫푸드 강아지사료'
);

-- 도비 강아지사료
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '건사료', '도비 강아지사료', '도비 강아지사료입니다.', 'defaultimg/강아지사료_도비.jpg', 9000, 110, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '도비 강아지사료'
);

-- 밀레쥬 강아지사료
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '건사료', '밀레쥬 강아지사료', '밀레쥬 강아지사료입니다.', 'defaultimg/강아지사료_밀레쥬.jpg', 11000, 130, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '밀레쥬 강아지사료'
);

-- 브리플래닛 강아지사료
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '건사료', '브리플래닛 강아지사료', '브리플래닛 강아지사료입니다.', 'defaultimg/강아지사료_브리플래닛.jpg', 29000, 5000, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '브리플래닛 강아지사료'
);

-- 오픈팜 강아지사료
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '건사료', '오픈팜 강아지사료', '오픈팜 강아지사료입니다.', 'defaultimg/강아지사료_오픈팜.jpg', 22000, 150, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '오픈팜 강아지사료'
);

-- 잘먹잘싸 강아지사료
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '건사료', '잘먹잘싸 강아지사료', '잘먹잘싸 강아지사료입니다.', 'defaultimg/강아지사료_잘먹잘싸.jpg', 32000, 160, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '잘먹잘싸 강아지사료'
);

-- 퍼피 강아지사료
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '건사료', '퍼피 강아지사료', '퍼피 강아지사료입니다.', 'defaultimg/강아지사료_퍼피.jpg', 16000, 180, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '퍼피 강아지사료'
);

-- 펫코어 강아지사료
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '건사료', '펫코어 강아지사료', '펫코어 강아지사료입니다.', 'defaultimg/강아지사료_펫코어.jpg', 19000, 190, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '펫코어 강아지사료'
);

-- 강아지 /배변패드
-- SSG 배변패드
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '배변패드', 'SSG 배변패드', 'SSG 강아지배변패드입니다.', 'defaultimg/강아지배변패드_ssg.jpg', 35000, 100, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = 'SSG 배변패드'
);

-- 강아지배변패드 딩동펫
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '배변패드', '강아지배변패드 딩동펫', '딩동펫 강아지배변패드입니다.', 'defaultimg/강아지배변패드_딩동펫.jpg', 27000, 110, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '강아지배변패드 딩동펫'
);

-- 강아지배변패드 벨버드
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '배변패드', '강아지배변패드 벨버드', '벨버드 강아지배변패드입니다.', 'defaultimg/강아지배변패드_벨버드.jpg', 15000, 120, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '강아지배변패드 벨버드'
);

-- 강아지배변패드 뽀시래기
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '배변패드', '강아지배변패드 뽀시래기', '뽀시래기 강아지배변패드입니다.', 'defaultimg/강아지배변패드_뽀시래기.jpg', 21000, 130, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '강아지배변패드 뽀시래기'
);

-- 강아지배변패드 영마진
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '배변패드', '강아지배변패드 영마진', '영마진 강아지배변패드입니다.', 'defaultimg/강아지배변패드_영마진.jpg', 74000, 140, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '강아지배변패드 영마진'
);

-- 강아지배변패드 요기쏘
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '배변패드', '강아지배변패드 요기쏘', '요기쏘 강아지배변패드입니다.', 'defaultimg/강아지배변패드_요기쏘.jpg', 10000, 150, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '강아지배변패드 요기쏘'
);


-- 강아지 방석/쿠션
-- 강아지방석/쿠션 바잇미
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '방석/쿠션', '강아지방석/쿠션 바잇미', '바잇미 강아지방석/쿠션입니다.', 'defaultimg/강아지방석쿠션_바잇미.jpg', 23000, 160, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '강아지방석/쿠션 바잇미'
);

-- 강아지방석/쿠션 보웰
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '방석/쿠션', '강아지방석/쿠션 보웰', '보웰 강아지방석/쿠션입니다.', 'defaultimg/강아지방석쿠션_보웰.jpg', 18000, 170, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '강아지방석/쿠션 보웰'
);

-- 강아지방석/쿠션 인터파크
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '방석/쿠션', '강아지방석/쿠션 인터파크', '인터파크 강아지방석/쿠션입니다.', 'defaultimg/강아지방석쿠션_인터파크.jpg', 17000, 180, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '강아지방석/쿠션 인터파크'
);

-- 강아지방석/쿠션 클라우드
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '방석/쿠션', '강아지방석/쿠션 클라우드', '클라우드 강아지방석/쿠션입니다.', 'defaultimg/강아지방석쿠션_클라우드.jpg', 25000, 6000, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '강아지방석/쿠션 클라우드'
);

-- 강아지방석/쿠션 티티오씨
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '방석/쿠션', '강아지방석/쿠션 티티오씨', '티티오씨 강아지방석/쿠션입니다.', 'defaultimg/강아지방석쿠션_티티오씨.jpg', 10000, 200, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '강아지방석/쿠션 티티오씨'
);

-- 강아지방석/쿠션 펫테일
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '방석/쿠션', '강아지방석/쿠션 펫테일', '펫테일 강아지방석/쿠션입니다.', 'defaultimg/강아지방석쿠션_펫테일.jpg', 30000, 210, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '강아지방석/쿠션 펫테일'
);


--강아지이동가방
-- 강아지이동가방 마이플러피
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '이동가방', '강아지이동가방 마이플러피', '마이플러피 강아지이동가방입니다.', 'defaultimg/강아지이동가방_마이플러피.jpg', 19000, 110, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '강아지이동가방 마이플러피'
);

-- 강아지이동가방 울리
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '이동가방', '강아지이동가방 울리', '울리 강아지이동가방입니다.', 'defaultimg/강아지이동가방_울리.jpg', 20000, 100, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '강아지이동가방 울리'
);

-- 강아지이동가방 펫츠랜드
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '이동가방', '강아지이동가방 펫츠랜드', '펫츠랜드 강아지이동가방입니다.', 'defaultimg/강아지이동가방_펫츠랜드.jpg', 30000, 120, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '강아지이동가방 펫츠랜드'
);

-- 강아지이동가방 펫테일
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '이동가방', '강아지이동가방 펫테일', '펫테일 강아지이동가방입니다.', 'defaultimg/강아지이동가방_펫테일.jpg', 11000, 130, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '강아지이동가방 펫테일'
);

-- 강아지이동가방 허메스
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '이동가방', '강아지이동가방 허메스', '허메스 강아지이동가방입니다.', 'defaultimg/강아지이동가방_허메스.jpg', 7000, 4000, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '강아지이동가방 허메스'
);


--강아지 샴푸비누

-- 강아지샴푸/비누 내개와
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '샴푸/비누', '강아지샴푸/비누 내개와', '내개와 강아지샴푸/비누입니다.', 'defaultimg/강아지샴푸비누_내개와.jpg', 11000, 100, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '강아지샴푸/비누 내개와'
);

-- 강아지샴푸/비누 댕댕이네
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '샴푸/비누', '강아지샴푸/비누 댕댕이네', '댕댕이네 강아지샴푸/비누입니다.', 'defaultimg/강아지샴푸비누_댕댕이네.jpg', 7000, 110, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '강아지샴푸/비누 댕댕이네'
);

-- 강아지샴푸/비누 동구밭
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '샴푸/비누', '강아지샴푸/비누 동구밭', '동구밭 강아지샴푸/비누입니다.', 'defaultimg/강아지샴푸비누_동구밭.jpg', 9000, 120, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '강아지샴푸/비누 동구밭'
);

-- 강아지샴푸/비누 안아줄래
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '샴푸/비누', '강아지샴푸/비누 안아줄래', '안아줄래 강아지샴푸/비누입니다.', 'defaultimg/강아지샴푸비누_안아줄래.jpg', 5000, 130, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '강아지샴푸/비누 안아줄래'
);

-- 강아지장난감 로봇
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '기타', '강아지장난감 로봇', '강아지장난감입니다.', 'defaultimg/강아지장난감_강아지로봇.jpg', 15000, 3000, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '강아지장난감 로봇'
);

-- 강아지장난감 노즈워크볼
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '기타', '강아지장난감 노즈워크볼', '강아지장난감입니다.', 'defaultimg/강아지장난감_노즈워크볼.jpg', 25000, 150, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '강아지장난감 노즈워크볼'
);

-- 강아지장난감 텐바이텐
INSERT INTO product(PRODUCT_ANIMAL_TYPE, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_IMAGE, PRODUCT_PRICE, PRODUCT_READ_COUNT, CREATED_TIME, UPDATE_TIME)
SELECT '강아지', '기타', '강아지장난감 텐바이텐', '강아지장난감입니다.', 'defaultimg/강아지장난감_텐바이텐.jpg', 24000, 130, SYSTIMESTAMP, SYSTIMESTAMP
FROM dual
WHERE NOT EXISTS (
    SELECT 1 
    FROM product 
    WHERE PRODUCT_NAME = '강아지장난감 텐바이텐'
);


--총 32개 기본데이터


commit;