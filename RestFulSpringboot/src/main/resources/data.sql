INSERT INTO users(username, password)  VALUES('user' , '$2a$10$FjmvYhPOP6pcsAaUkai1m.mEY9mjRP4yJsh7kbL8LensULCGZCrUq');
INSERT INTO users(username, password)  VALUES('admin', '$2a$10$FjmvYhPOP6pcsAaUkai1m.mEY9mjRP4yJsh7kbL8LensULCGZCrUq');
INSERT INTO users(username, password)  VALUES('kakao', '$2a$10$FjmvYhPOP6pcsAaUkai1m.mEY9mjRP4yJsh7kbL8LensULCGZCrUq');
INSERT INTO users(username, password)  VALUES('pyun' , '$2a$10$FjmvYhPOP6pcsAaUkai1m.mEY9mjRP4yJsh7kbL8LensULCGZCrUq');


insert into authority(username, authority_name) values ('kakao', 'USER');
insert into authority(username, authority_name) values ('pyun' , 'USER');
insert into authority(username, authority_name) values ('admin', 'USER');
insert into authority(username, authority_name) values ('user' , 'USER');


--insert into hist_search(username,keyword) values('kakao','kakaobank');