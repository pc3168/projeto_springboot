insert into endereco (id, cep, cidade, logradouro, numero) values (1, '37128-000', 'Paraguaçu', 'Rua São José', 999);
insert into endereco (id, cep, cidade, logradouro, numero) values (2, '36326-000', 'Alfenas', 'Rua Sao Miguel', 888);
insert into endereco (id, cep, cidade, logradouro, numero) values (3, '30132-000', 'Varginha', 'Rua Salvador Dias', 100);
insert into endereco (id, cep, cidade, logradouro, numero) values (4, '31202-000', 'Pouso Alegre', 'Rua Jair de Souza', 198);
insert into endereco (id, cep, cidade, logradouro, numero) values (5, '32303-000', 'Poços de Caldas', 'Av Brasil', 500);
insert into endereco (id, cep, cidade, logradouro, numero) values (6, '33233-000', 'Eloi Mendes', 'Av Dom Bosco', 200);
insert into endereco (id, cep, cidade, logradouro, numero) values (7, '33525-000', 'Machado', 'Av Padre Vitor', 200);
insert into endereco (id, cep, cidade, logradouro, numero) values (8, '35125-000', 'Areado', 'Rua Andradas', 1000);

insert into pessoa (id,data_nascimento, nome) values (1, '1989-02-06' , 'João de Souza' );
insert into pessoa (id,data_nascimento, nome) values (2, '1988-02-06' , 'Pedro Joaquim' );
insert into pessoa (id,data_nascimento, nome) values (3, '1997-02-06' , 'Maria Eduarda' );
insert into pessoa (id,data_nascimento, nome) values (4, '1996-02-06' , 'Isabela da Silva');
insert into pessoa (id,data_nascimento, nome) values (5, '1993-02-06' , 'Paulo Cesar');
insert into pessoa (id,data_nascimento, nome) values (6, '1982-04-10' , 'Angelo Marcio');

insert into pessoa_endereco (pessoa_id, endereco_id) values (1,1);
insert into pessoa_endereco (pessoa_id, endereco_id) values (2,2);
insert into pessoa_endereco (pessoa_id, endereco_id) values (3,4);
insert into pessoa_endereco (pessoa_id, endereco_id) values (4,3);
insert into pessoa_endereco (pessoa_id, endereco_id) values (5,5);
insert into pessoa_endereco (pessoa_id, endereco_id) values (6,1);
insert into pessoa_endereco (pessoa_id, endereco_id) values (6,5);
insert into pessoa_endereco (pessoa_id, endereco_id) values (1,3);
