insert into role (id, role) values(0,'ADMIN');
insert into role (id, role) values(1,'MEMBER');
INSERT INTO MEMBER (ID,CREATED_DATE,MODIFIED_DATE,NAME,PASSWORD,PHONE_NUMBER,STUDENT_NUM,ROLE_ID_ID)VALUES(0,NOW(),NOW(),'김동민','a','01027703018','2019631001',0);

INSERT INTO EQUIP_STATE(ID,STATE)VALUES(0,'ACTIVATE');
INSERT INTO EQUIP_STATE(ID,STATE)VALUES(1,'USE');
INSERT INTO EQUIP_STATE(ID,STATE)VALUES(2,'FIX');
INSERT INTO EQUIP_STATE(ID,STATE)VALUES(3,'DISABLE');
	
INSERT INTO EQUIPMENT(ID,CREATED_DATE,MODIFIED_DATE,EQUIP_NAME,EQUIP_NUM,EQUIP_SEQ_NUM,IS_AVAILABLE,REASON,EQUIP_STATE_ID_ID)
	VALUES(0,NOW(),NOW(),'VR기기','1234','1',true,'',0);
INSERT INTO EQUIPMENT(ID,CREATED_DATE,MODIFIED_DATE,EQUIP_NAME,EQUIP_NUM,EQUIP_SEQ_NUM,IS_AVAILABLE,REASON,EQUIP_STATE_ID_ID)
	VALUES(1,NOW(),NOW(),'VR기기','12345','2',true,'',0);
INSERT INTO EQUIPMENT(ID,CREATED_DATE,MODIFIED_DATE,EQUIP_NAME,EQUIP_NUM,EQUIP_SEQ_NUM,IS_AVAILABLE,REASON,EQUIP_STATE_ID_ID)
	VALUES(2,NOW(),NOW(),'VR기기','12346','3',true,'',0);
INSERT INTO EQUIPMENT(ID,CREATED_DATE,MODIFIED_DATE,EQUIP_NAME,EQUIP_NUM,EQUIP_SEQ_NUM,IS_AVAILABLE,REASON,EQUIP_STATE_ID_ID)
	VALUES(3,NOW(),NOW(),'VR기기','12347','4',true,'',0);
INSERT INTO EQUIPMENT(ID,CREATED_DATE,MODIFIED_DATE,EQUIP_NAME,EQUIP_NUM,EQUIP_SEQ_NUM,IS_AVAILABLE,REASON,EQUIP_STATE_ID_ID)
	VALUES(4,NOW(),NOW(),'VR기기','12348','5',true,'',0);
INSERT INTO EQUIPMENT(ID,CREATED_DATE,MODIFIED_DATE,EQUIP_NAME,EQUIP_NUM,EQUIP_SEQ_NUM,IS_AVAILABLE,REASON,EQUIP_STATE_ID_ID)
	VALUES(5,NOW(),NOW(),'VR기기','12349','6',true,'',0);