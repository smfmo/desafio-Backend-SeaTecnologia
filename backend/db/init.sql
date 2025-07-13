CREATE TABLE endereco ( -- endereços dos clientes --
id BIGSERIAL PRIMARY KEY NOT NULL,
bairro VARCHAR(100) NOT NULL,
logradouro VARCHAR(100) NOT NULL,
cep VARCHAR(10) NOT NULL,
complemento VARCHAR(255),
localidade VARCHAR(30) NOT NULL,
uf VARCHAR(2)NOT NULL
);

CREATE TABLE clientes ( -- clientes --
id BIGSERIAL PRIMARY KEY NOT NULL,
cpf VARCHAR(14) NOT NULL,
nome VARCHAR(100) NOT NULL,
endereco_id BIGINT,

    -- constraints --
CONSTRAINT fk_endereco FOREIGN KEY (endereco_id) REFERENCES endereco(id) ON DELETE CASCADE
);

CREATE TABLE emails_cliente (
cliente_id BIGINT NOT NULL,
emails VARCHAR(100) NOT NULL,

    -- constraints --
CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES clientes(id) ON DELETE CASCADE
);

CREATE TABLE telefones_cliente (
cliente_id BIGINT NOT NULL,
numero VARCHAR(20),
tipo VARCHAR (50),

    -- constraints --
CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES clientes(id) ON DELETE CASCADE,
CONSTRAINT check_tipo CHECK (tipo IN ('CELULAR', 'COMERCIAL', 'RESIDENCIAL'))
);

CREATE TABLE usuarios(
id BIGSERIAL PRIMARY KEY NOT NULL,
password VARCHAR(255) NOT NULL,
roles VARCHAR[],
username VARCHAR(20) NOT NULL UNIQUE
);

INSERT INTO usuarios (username, password, roles) VALUES
-- senha: 123qwe!@#
('admin',
 '$2a$12$fEZyhNFNrE2IUGqLkM.S7uVLDHTdBim0L7rJJrsY.Hju3R4UGP2om',
 '{ADMIN}');

INSERT INTO usuarios (username, password, roles) VALUES
-- senha: 123qwe123
('user',
 '$2a$12$CCbsXHLP6vCddxd8.tLYB.83eMxtGalJK9A6NCHvGaFZjbF0Vc2T6',
 '{USER}');



