-- Inserir um proprietário
INSERT INTO proprietarios (nome, cpf, telefone, email)
VALUES ('João da Silva', '123.456.789-00', '(12) 99999-0000', 'joao.silva@email.com');

-- Inserir um imóvel para o proprietário com id = 1
INSERT INTO imoveis (numero_unidade, bloco, tipo, status, proprietario_id)
VALUES ('101', 'A', 'PROPRIO', 'ATIVO', 1);

-- Inserir um residente associado ao imóvel com id = 1
INSERT INTO residentes (nome, cpf, telefone, email, imovel_id)
VALUES ('Maria Oliveira', '987.654.321-00', '(12) 98888-1111', 'maria.oliveira@email.com', 1);
