insert into tb_users(username, password, name) values ('admin@master', '$2a$12$CtVEGjY3UJUJB91S5OrJjOxFIOQ9h1TGxrMAMWkBJOVMDQ11fq6RK', 'admin');

insert into tb_users(username, password, name) values ('maria@maria', '$2a$12$CtVEGjY3UJUJB91S5OrJjOxFIOQ9h1TGxrMAMWkBJOVMDQ11fq6RK', 'maria');

insert into tb_users(username, password, name) values ('joao@joao', '$2a$12$CtVEGjY3UJUJB91S5OrJjOxFIOQ9h1TGxrMAMWkBJOVMDQ11fq6RK', 'joao');

insert into tb_authorities(authority, user_id) values ('ROLE_USER', 1);
insert into tb_authorities(authority, user_id) values ('ROLE_USER', 2);
insert into tb_authorities(authority, user_id) values ('ROLE_USER', 3);

insert into tb_products(name, published, user_id) values("Product #1", 0, 1);
insert into tb_products(name, published, user_id) values("Product #2", 0, 1);
insert into tb_products(name, published, user_id) values("Product #3", 0, 1);
insert into tb_products(name, published, user_id) values("Product #4", 0, 1);
insert into tb_products(name, published, user_id) values("Product #5", 0, 1);
insert into tb_products(name, published, user_id) values("Product #6", 0, 1);
insert into tb_products(name, published, user_id) values("Product #7", 0, 1);
insert into tb_products(name, published, user_id) values("Product #8", 0, 1);
insert into tb_products(name, published, user_id) values("Product #9", 0, 1);
insert into tb_products(name, published, user_id) values("Product #10", 0, 2);
insert into tb_products(name, published, user_id) values("Product #11", 0, 2);
insert into tb_products(name, published, user_id) values("Product #12", 0, 2);
insert into tb_products(name, published, user_id) values("Product #13", 0, 3);
insert into tb_products(name, published, user_id) values("Product #14", 0, 3);
insert into tb_products(name, published, user_id) values("Product #15", 0, 3);

insert into tb_features(description, status, title, product_id, user_id) values ('Make database better', 'Pending review', 'Data base improving', 1, 1);
insert into tb_features(description, status, title, product_id, user_id) values ('Make database better', 'Pending review', 'Data base improving', 2, 1);
insert into tb_features(description, status, title, product_id, user_id) values ('Make database better', 'Pending review', 'Data base improving', 3, 2);
insert into tb_features(description, status, title, product_id, user_id) values ('Make database better', 'Pending review', 'Data base improving', 1, 2);
insert into tb_features(description, status, title, product_id, user_id) values ('Make database better', 'Pending review', 'Data base improving', 10, 2);
insert into tb_features(description, status, title, product_id, user_id) values ('Make database better', 'Pending review', 'Data base improving', 10, 1);