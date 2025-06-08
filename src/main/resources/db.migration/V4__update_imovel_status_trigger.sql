-- Função para atualizar o status do imóvel conforme residentes vinculados
CREATE OR REPLACE FUNCTION atualizar_status_imovel()
RETURNS TRIGGER AS $$
BEGIN
    -- Conta residentes ativos para o imóvel
    IF (TG_OP = 'DELETE') THEN
        PERFORM 1 FROM residentes WHERE imovel_id = OLD.imovel_id LIMIT 1;
        IF NOT FOUND THEN
            UPDATE imoveis SET status = 'INATIVO' WHERE id = OLD.imovel_id;
        END IF;
    ELSIF (TG_OP = 'INSERT') THEN
        UPDATE imoveis SET status = 'ATIVO' WHERE id = NEW.imovel_id;
    END IF;

    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

-- Trigger que chama a função após inserção ou remoção de residente
CREATE TRIGGER trg_atualizar_status_imovel
AFTER INSERT OR DELETE ON residentes
FOR EACH ROW
EXECUTE FUNCTION atualizar_status_imovel();
