DROP TABLE admin CASCADE CONSTRAINTS;
DROP TABLE board CASCADE CONSTRAINTS;
DROP TABLE order CASCADE CONSTRAINTS;
DROP TABLE cart CASCADE CONSTRAINTS;
DROP TABLE product CASCADE CONSTRAINTS;
DROP TABLE userinfo CASCADE CONSTRAINTS;

/**********************************/
/* Table Name: userinfo */
/**********************************/
CREATE TABLE userinfo(
		user_id                       		VARCHAR2(1000)		 NOT NULL,
		user_pw                       		VARCHAR2(1000)		 NULL ,
		user_name                     		VARCHAR2(1000)		 NOT NULL
);

COMMENT ON TABLE userinfo is 'userinfo';
COMMENT ON COLUMN userinfo.user_id is 'user_id';
COMMENT ON COLUMN userinfo.user_pw is 'user_pw';
COMMENT ON COLUMN userinfo.user_name is 'user_name';


/**********************************/
/* Table Name: product */
/**********************************/
CREATE TABLE product(
		product_no                    		NUMBER(10)		 NOT NULL,
		product_name                  		VARCHAR2(100)		 NULL ,
		product_content               		VARCHAR2(4000)		 NULL ,
		product_qty                   		NUMBER(10)		 NULL ,
		product_image                 		VARCHAR2(1000)		 NULL ,
		product_price                 		NUMBER(10)		 NULL 
);

DROP SEQUENCE product_product_no_SEQ;

CREATE SEQUENCE product_product_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER product_product_no_TRG
BEFORE INSERT ON product
FOR EACH ROW
BEGIN
IF :NEW.product_no IS NOT NULL THEN
  SELECT product_product_no_SEQ.NEXTVAL INTO :NEW.product_no FROM DUAL;
END IF;
END;

COMMENT ON TABLE product is 'product';
COMMENT ON COLUMN product.product_no is 'product_no';
COMMENT ON COLUMN product.product_name is 'product_name';
COMMENT ON COLUMN product.product_content is 'product_content';
COMMENT ON COLUMN product.product_qty is 'product_qty';
COMMENT ON COLUMN product.product_image is 'product_image';
COMMENT ON COLUMN product.product_price is 'product_price';


/**********************************/
/* Table Name: cart */
/**********************************/
CREATE TABLE cart(
		cart_id                       		NUMBER(10)		 NOT NULL,
		cart_qty                      		NUMBER(10)		 NULL ,
		cart_total_price              		NUMBER(10)		 NULL ,
		COLUMN_3                      		NUMBER(10)		 NULL ,
		COLUMN_4                      		NUMBER(10)		 NULL ,
		user_id                       		VARCHAR2(1000)		 NULL ,
		product_no                    		NUMBER(10)		 NULL 
);

DROP SEQUENCE cart_cart_id_SEQ;

CREATE SEQUENCE cart_cart_id_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER cart_cart_id_TRG
BEFORE INSERT ON cart
FOR EACH ROW
BEGIN
IF :NEW.cart_id IS NOT NULL THEN
  SELECT cart_cart_id_SEQ.NEXTVAL INTO :NEW.cart_id FROM DUAL;
END IF;
END;

COMMENT ON TABLE cart is 'cart';
COMMENT ON COLUMN cart.cart_id is 'cart_id';
COMMENT ON COLUMN cart.cart_qty is 'cart_qty';
COMMENT ON COLUMN cart.cart_total_price is 'cart_total_price';
COMMENT ON COLUMN cart.COLUMN_3 is 'Column3';
COMMENT ON COLUMN cart.COLUMN_4 is 'Column4';
COMMENT ON COLUMN cart.user_id is 'user_id';
COMMENT ON COLUMN cart.product_no is 'product_no';


/**********************************/
/* Table Name: order */
/**********************************/
CREATE TABLE order(
		order_id                      		NUMBER(10)		 NOT NULL,
		order_qty                     		NUMBER(10)		 NULL ,
		order_price                   		NUMBER(10)		 NULL ,
		order_date                    		DATE		 NULL ,
		product_no                    		NUMBER(10)		 NULL 
);

DROP SEQUENCE order_order_id_SEQ;

CREATE SEQUENCE order_order_id_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER order_order_id_TRG
BEFORE INSERT ON order
FOR EACH ROW
BEGIN
IF :NEW.order_id IS NOT NULL THEN
  SELECT order_order_id_SEQ.NEXTVAL INTO :NEW.order_id FROM DUAL;
END IF;
END;

COMMENT ON TABLE order is 'order';
COMMENT ON COLUMN order.order_id is 'order_id';
COMMENT ON COLUMN order.order_qty is 'order_qty';
COMMENT ON COLUMN order.order_price is 'order_price';
COMMENT ON COLUMN order.order_date is 'order_date';
COMMENT ON COLUMN order.product_no is 'product_no';


/**********************************/
/* Table Name: board */
/**********************************/
CREATE TABLE board(
		board_no                      		NUMBER(10)		 NOT NULL,
		board_content                 		VARCHAR2(4000)		 NULL ,
		board_image                   		VARCHAR2(4000)		 NULL ,
		board_date                    		DATE		 NULL ,
		user_id                       		VARCHAR2(1000)		 NULL 
);

DROP SEQUENCE board_board_no_SEQ;

CREATE SEQUENCE board_board_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER board_board_no_TRG
BEFORE INSERT ON board
FOR EACH ROW
BEGIN
IF :NEW.board_no IS NOT NULL THEN
  SELECT board_board_no_SEQ.NEXTVAL INTO :NEW.board_no FROM DUAL;
END IF;
END;

COMMENT ON TABLE board is 'board';
COMMENT ON COLUMN board.board_no is 'board_no';
COMMENT ON COLUMN board.board_content is 'board_content';
COMMENT ON COLUMN board.board_image is 'board_image';
COMMENT ON COLUMN board.board_date is 'board_date';
COMMENT ON COLUMN board.user_id is 'user_id';


/**********************************/
/* Table Name: admin */
/**********************************/
CREATE TABLE admin(
		admin_id                      		VARCHAR2(1000)		 NOT NULL,
		admin_pw                      		VARCHAR2(1000)		 NULL 
);

COMMENT ON TABLE admin is 'admin';
COMMENT ON COLUMN admin.admin_id is 'admin_id';
COMMENT ON COLUMN admin.admin_pw is 'admin_pw';



ALTER TABLE userinfo ADD CONSTRAINT IDX_userinfo_PK PRIMARY KEY (user_id);

ALTER TABLE product ADD CONSTRAINT IDX_product_PK PRIMARY KEY (product_no);

ALTER TABLE cart ADD CONSTRAINT IDX_cart_PK PRIMARY KEY (cart_id);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK0 FOREIGN KEY (user_id) REFERENCES userinfo (user_id);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK1 FOREIGN KEY (product_no) REFERENCES product (product_no);

ALTER TABLE order ADD CONSTRAINT IDX_order_PK PRIMARY KEY (order_id);
ALTER TABLE order ADD CONSTRAINT IDX_order_FK0 FOREIGN KEY (product_no) REFERENCES product (product_no);

ALTER TABLE board ADD CONSTRAINT IDX_board_PK PRIMARY KEY (board_no);
ALTER TABLE board ADD CONSTRAINT IDX_board_FK0 FOREIGN KEY (user_id) REFERENCES userinfo (user_id);

ALTER TABLE admin ADD CONSTRAINT IDX_admin_PK PRIMARY KEY (admin_id);

