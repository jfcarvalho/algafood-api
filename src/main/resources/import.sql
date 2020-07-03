insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Chinesa');
insert into cozinha (nome) values ('Japonesa');
insert into cozinha (nome) values ('Brasileira');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Gourmet', 10, 1); 
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Delivery', 9.50, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Tuk Tuk Comida Indiane', 15, 1);

insert into estado (nome) values ('Bahia');
insert into estado (nome) values ('São Paulo');

insert into cidade (nome, estado_id) values ('Salvador', 1);
insert into cidade (nome, estado_id) values ('São Paulo', 2);
