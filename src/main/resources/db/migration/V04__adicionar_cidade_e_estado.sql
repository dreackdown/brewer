CREATE TABLE estado (
                        codigo BIGINT(20) PRIMARY KEY,
                        nome VARCHAR(50) NOT NULL,
                        sigla VARCHAR(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cidade (
                        codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
                        nome VARCHAR(50) NOT NULL,
                        codigo_estado BIGINT(20) NOT NULL,
                        FOREIGN KEY (codigo_estado) REFERENCES estado(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO estado (codigo, nome, sigla) VALUES (1,'Acre', 'AC');
INSERT INTO estado (codigo, nome, sigla) VALUES (2,'Bahia', 'BA');
INSERT INTO estado (codigo, nome, sigla) VALUES (3,'Goiás', 'GO');
INSERT INTO estado (codigo, nome, sigla) VALUES (4,'Minas Gerais', 'MG');
INSERT INTO estado (codigo, nome, sigla) VALUES (5,'Santa Catarina', 'SC');
INSERT INTO estado (codigo, nome, sigla) VALUES (6,'São Paulo', 'SP');
INSERT INTO estado (codigo, nome, sigla) VALUES (7,'Rio de Janeiro', 'RJ');
INSERT INTO estado (codigo, nome, sigla) VALUES (8,'Paraná', 'PR');
INSERT INTO estado (codigo, nome, sigla) VALUES (9,'Rio Grande do Sul', 'RS');
INSERT INTO estado (codigo, nome, sigla) VALUES (10,'Ceará', 'CE');
INSERT INTO estado (codigo, nome, sigla) VALUES (11,'Pernambuco', 'PE');
INSERT INTO estado (codigo, nome, sigla) VALUES (12,'Mato Grosso', 'MT');
INSERT INTO estado (codigo, nome, sigla) VALUES (13,'Mato Grosso do Sul', 'MS');
INSERT INTO estado (codigo, nome, sigla) VALUES (14,'Pará', 'PA');
INSERT INTO estado (codigo, nome, sigla) VALUES (15,'Paraíba', 'PB');
INSERT INTO estado (codigo, nome, sigla) VALUES (16,'Piauí', 'PI');
INSERT INTO estado (codigo, nome, sigla) VALUES (17,'Rio Grande do Norte', 'RN');
INSERT INTO estado (codigo, nome, sigla) VALUES (18,'Rondônia', 'RO');
INSERT INTO estado (codigo, nome, sigla) VALUES (19,'Roraima', 'RR');
INSERT INTO estado (codigo, nome, sigla) VALUES (20,'Sergipe', 'SE');
INSERT INTO estado (codigo, nome, sigla) VALUES (21,'Tocantins', 'TO');
INSERT INTO estado (codigo, nome, sigla) VALUES (22,'Alagoas', 'AL');
INSERT INTO estado (codigo, nome, sigla) VALUES (23,'Amapá', 'AP');
INSERT INTO estado (codigo, nome, sigla) VALUES (24,'Amazonas', 'AM');
INSERT INTO estado (codigo, nome, sigla) VALUES (25,'Distrito Federal', 'DF');
INSERT INTO estado (codigo, nome, sigla) VALUES (26,'Espírito Santo', 'ES');
INSERT INTO estado (codigo, nome, sigla) VALUES (27,'Maranhão', 'MA');

INSERT INTO cidade (nome, codigo_estado) VALUES ('Rio Branco', 1);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Cruzeiro do Sul', 1);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Salvador', 2);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Porto Seguro', 2);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Santana', 2);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Goiânia', 3);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Itumbiara', 3);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Novo Brasil', 3);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Belo Horizonte', 4);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Uberlândia', 4);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Montes Claros', 4);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Florianópolis', 5);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Criciúma', 5);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Camboriú', 5);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Lages', 5);
INSERT INTO cidade (nome, codigo_estado) VALUES ('São Paulo', 6);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Ribeirão Preto', 6);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Campinas', 6);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Santos', 6);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Rio de Janeiro', 7);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Niterói', 7);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Petrópolis', 7);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Curitiba', 8);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Londrina', 8);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Maringá', 8);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Porto Alegre', 9);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Caxias do Sul', 9);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Pelotas', 9);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Fortaleza', 10);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Sobral', 10);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Juazeiro do Norte', 10);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Recife', 11);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Olinda', 11);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Caruaru', 11);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Cuiabá', 12);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Rondonópolis', 12);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Sinop', 12);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Campo Grande', 13);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Dourados', 13);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Três Lagoas', 13);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Belém', 14);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Ananindeua', 14);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Santarém', 14);
INSERT INTO cidade (nome, codigo_estado) VALUES ('João Pessoa', 15);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Campina Grande', 15);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Santa Rita', 15);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Teresina', 16);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Parnaíba', 16);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Picos', 16);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Natal', 17);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Mossoró', 17);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Parnamirim', 17);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Porto Velho', 18);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Ji-Paraná', 18);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Ariquemes', 18);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Boa Vista', 19);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Pacaraima', 19);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Caracaraí', 19);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Aracaju', 20);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Nossa Senhora do Socorro', 20);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Lagarto', 20);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Palmas', 21);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Araguaína', 21);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Gurupi', 21);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Maceió', 22);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Arapiraca', 22);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Palmeira dos Índios', 22);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Macapá', 23);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Santana', 23);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Laranjal do Jari', 23);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Manaus', 24);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Parintins', 24);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Itacoatiara', 24);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Brasília', 25);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Taguatinga', 25);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Ceilândia', 25);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Vitória', 26);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Vila Velha', 26);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Serra', 26);
INSERT INTO cidade (nome, codigo_estado) VALUES ('São Luís', 27);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Imperatriz', 27);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Caxias', 27);