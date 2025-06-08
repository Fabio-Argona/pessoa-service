-- Define valores padrão para colunas de imoveis
ALTER TABLE imoveis
ALTER COLUMN tipo SET DEFAULT 'PROPRIO';

ALTER TABLE imoveis
ALTER COLUMN status SET DEFAULT 'ATIVO';
