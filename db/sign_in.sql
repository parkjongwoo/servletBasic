CREATE TABLE member (
	memberid VARCHAR2(50),
	password VARCHAR2(30),
	name VARCHAR2(100),
	gender CHAR(4),
	email VARCHAR2(50),
	CONSTRAINT pk_member_memberid PRIMARY KEY (memberid),
	CONSTRAINT ch_member_gender CHECK (gender IN('남자','여자'))
);

INSERT INTO member values(
	'skyholds1',
	'edddee',
	'박종우',
	'남자',
	'shoong1999@gmail.com'
);

UPDATE member SET
	password = 'Qqq*%1111',
	name = '박종우',
	gender = '남자',
	email = 'shoong1999@gmail.com'
WHERE 
	memberid = 'helloworld19';

SELECT * FROM member;
SELECT * FROM member WHERE memberid='skyholds1';

DELETE FROM member WHERE memberid='skyholds';