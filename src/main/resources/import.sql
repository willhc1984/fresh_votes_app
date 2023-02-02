insert into tb_users(username, password, name) values ('admin@master', '$2a$12$CtVEGjY3UJUJB91S5OrJjOxFIOQ9h1TGxrMAMWkBJOVMDQ11fq6RK', 'admin');
insert into tb_users(username, password, name) values ('maria@maria', '$2a$12$CtVEGjY3UJUJB91S5OrJjOxFIOQ9h1TGxrMAMWkBJOVMDQ11fq6RK', 'maria');
insert into tb_users(username, password, name) values ('joao@joao', '$2a$12$CtVEGjY3UJUJB91S5OrJjOxFIOQ9h1TGxrMAMWkBJOVMDQ11fq6RK', 'joao');

insert into tb_users(username, password, name) values ('marcos@marcos', '$2a$12$CtVEGjY3UJUJB91S5OrJjOxFIOQ9h1TGxrMAMWkBJOVMDQ11fq6RK', 'marcos');
insert into tb_users(username, password, name) values ('ana@ana', '$2a$12$CtVEGjY3UJUJB91S5OrJjOxFIOQ9h1TGxrMAMWkBJOVMDQ11fq6RK', 'ana');
insert into tb_users(username, password, name) values ('pedro@pedro', '$2a$12$CtVEGjY3UJUJB91S5OrJjOxFIOQ9h1TGxrMAMWkBJOVMDQ11fq6RK', 'pedro');

insert into tb_authorities(authority, user_id) values ('ROLE_OWNER', 1);
insert into tb_authorities(authority, user_id) values ('ROLE_OWNER', 2);
insert into tb_authorities(authority, user_id) values ('ROLE_OWNER', 3);

insert into tb_authorities(authority, user_id) values ('ROLE_USER', 4);
insert into tb_authorities(authority, user_id) values ('ROLE_USER', 5);
insert into tb_authorities(authority, user_id) values ('ROLE_USER', 6);

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
insert into tb_features(description, status, title, product_id, user_id) values ('Make database better', 'Pending review', 'Data base improving', 1, 2);
insert into tb_features(description, status, title, product_id, user_id) values ('Make database better', 'Pending review', 'Data base improving', 1, 1);

insert into tb_comments(text, created_date, comment_id, feature_id, user_id) values ('Teste comment #1', '2023-01-01', null, 1, 1);
insert into tb_comments(text, created_date, comment_id, feature_id, user_id) values ('Teste comment #1', '2023-01-02', 1, 1, 2);
insert into tb_comments(text, created_date, comment_id, feature_id, user_id) values ('Teste comment #1', '2023-01-03', 1, 1, 3);
insert into tb_comments(text, created_date, comment_id, feature_id, user_id) values ('Teste comment #1', '2023-01-04', 2, 1, 1);
insert into tb_comments(text, created_date, comment_id, feature_id, user_id) values ('Teste comment #1', '2023-01-05', 2, 1, 2);
insert into tb_comments(text, created_date, comment_id, feature_id, user_id) values ('Teste comment #1', '2023-01-06', 2, 1, 3);
insert into tb_comments(text, created_date, comment_id, feature_id, user_id) values ('Teste comment #1', '2023-01-07', 4, 1, 1);
insert into tb_comments(text, created_date, comment_id, feature_id, user_id) values ('Teste comment #1', '2023-01-08', 4, 1, 2);
insert into tb_comments(text, created_date, comment_id, feature_id, user_id) values ('Teste comment #1', '2023-01-09', 4, 1, 3);
insert into tb_comments(text, created_date, comment_id, feature_id, user_id) values ('Teste comment #1', '2023-01-01', null, 2, 1);
insert into tb_comments(text, created_date, comment_id, feature_id, user_id) values ('Teste comment #1', '2023-01-02', 1, 2, 2);
insert into tb_comments(text, created_date, comment_id, feature_id, user_id) values ('Teste comment #1', '2023-01-03', 1, 2, 3);
