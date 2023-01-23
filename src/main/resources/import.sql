insert into tb_users(username, password, name) values ('admin@master', '$2a$12$CtVEGjY3UJUJB91S5OrJjOxFIOQ9h1TGxrMAMWkBJOVMDQ11fq6RK', 'william');

insert into tb_users(username, password, name) values ('maria@maria', '$2a$12$CtVEGjY3UJUJB91S5OrJjOxFIOQ9h1TGxrMAMWkBJOVMDQ11fq6RK', 'maria');

insert into tb_users(username, password, name) values ('joao@joao', '$2a$12$CtVEGjY3UJUJB91S5OrJjOxFIOQ9h1TGxrMAMWkBJOVMDQ11fq6RK', 'joao');

insert into tb_authorities(authority, user_id) values ('ROLE_USER', 1);
insert into tb_authorities(authority, user_id) values ('ROLE_USER', 2);
insert into tb_authorities(authority, user_id) values ('ROLE_USER', 3);

insert into tb_products(name, published, user_id) values("app function", 0, 1);
insert into tb_products(name, published, user_id) values("app function2", 0, 1);
insert into tb_products(name, published, user_id) values("app function3", 0, 1);
insert into tb_products(name, published, user_id) values("app function4", 0, 2);
insert into tb_products(name, published, user_id) values("app function5", 0, 2);
insert into tb_products(name, published, user_id) values("app function6", 0, 2);
insert into tb_products(name, published, user_id) values("app function7", 0, 3);
insert into tb_products(name, published, user_id) values("app function8", 0, 3);
insert into tb_products(name, published, user_id) values("app function9", 0, 3);