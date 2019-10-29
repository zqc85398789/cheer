INSERT INTO i_account (account_name,account_password,created_time,created_by) values ('Nanami','N0001',now(),'admin');

INSERT INTO i_privilege (privilege_name,privilege_url,created_time,created_by) values ('admin','/admin',now(),'admin');
INSERT INTO i_privilege (privilege_name,privilege_url,created_time,created_by) values ('boss','/boss',now(),'admin');
INSERT INTO i_privilege (privilege_name,privilege_url,created_time,created_by) values ('default','/default',now(),'admin');