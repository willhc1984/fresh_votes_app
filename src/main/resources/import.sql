insert into tb_users(username, password, name) values ('admin@master', '$2a$12$CtVEGjY3UJUJB91S5OrJjOxFIOQ9h1TGxrMAMWkBJOVMDQ11fq6RK', 'william');

insert into tb_users(username, password, name) values ('maria', '$2a$12$CtVEGjY3UJUJB91S5OrJjOxFIOQ9h1TGxrMAMWkBJOVMDQ11fq6RK', 'maria');

insert into tb_authorities(authority, user_id) values ('ROLE_USER', 1);
insert into tb_authorities(authority, user_id) values ('ROLE_USER', 2);