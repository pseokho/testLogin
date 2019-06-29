INSERT INTO users(username, password, errcount)  VALUES('user' , '$2a$10$FjmvYhPOP6pcsAaUkai1m.mEY9mjRP4yJsh7kbL8LensULCGZCrUq' , 0 );
INSERT INTO users(username, password, errcount)  VALUES('admin', '$2a$10$FjmvYhPOP6pcsAaUkai1m.mEY9mjRP4yJsh7kbL8LensULCGZCrUq', 0);
INSERT INTO users(username, password, errcount)  VALUES('kakao', '$2a$10$FjmvYhPOP6pcsAaUkai1m.mEY9mjRP4yJsh7kbL8LensULCGZCrUq', 0);
INSERT INTO users(username, password, errcount)  VALUES('pyun' , '$2a$10$FjmvYhPOP6pcsAaUkai1m.mEY9mjRP4yJsh7kbL8LensULCGZCrUq' , 0);

insert into authority(username, authority_name) values ('kakao', 'USER');
insert into authority(username, authority_name) values ('pyun' , 'USER');
insert into authority(username, authority_name) values ('admin', 'USER');
insert into authority(username, authority_name) values ('user' , 'USER');