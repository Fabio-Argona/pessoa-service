-- Tabela: proprietarios
CREATE TABLE proprietarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100)
);

-- Tabela: imoveis
CREATE TABLE imoveis (
    id SERIAL PRIMARY KEY,
    numero_unidade VARCHAR(10) NOT NULL,
    bloco VARCHAR(10),
    tipo VARCHAR(20) CHECK (tipo IN ('ALUGADO', 'PROPRIO')),
    status VARCHAR(20) CHECK (status IN ('ATIVO', 'INATIVO')),
    proprietario_id BIGINT,
    CONSTRAINT fk_proprietario FOREIGN KEY (proprietario_id) REFERENCES proprietarios(id) ON DELETE SET NULL
);

-- Tabela: residentes
CREATE TABLE residentes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100),
    imovel_id BIGINT,
    CONSTRAINT fk_imovel FOREIGN KEY (imovel_id) REFERENCES imoveis(id) ON DELETE SET NULL
);
