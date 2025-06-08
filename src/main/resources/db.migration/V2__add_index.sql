-- Índices para performance em busca por CPF, email e IDs estrangeiros
CREATE UNIQUE INDEX idx_proprietarios_cpf ON proprietarios(cpf);
CREATE UNIQUE INDEX idx_proprietarios_email ON proprietarios(email);

CREATE UNIQUE INDEX idx_residentes_cpf ON residentes(cpf);
CREATE UNIQUE INDEX idx_residentes_email ON residentes(email);

CREATE INDEX idx_imoveis_proprietario_id ON imoveis(proprietario_id);
CREATE INDEX idx_residentes_imovel_id ON residentes(imovel_id);

-- Constraints extras (se necessário)
ALTER TABLE imoveis
ADD CONSTRAINT chk_tipo CHECK (tipo IN ('PROPRIO', 'ALUGADO'));

ALTER TABLE imoveis
ADD CONSTRAINT chk_status CHECK (status IN ('ATIVO', 'INATIVO'));
