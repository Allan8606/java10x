

CREATE TABLE evento (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    identificador_evento VARCHAR(255) NOT NULL UNIQUE,
    inicio_evento TIMESTAMP NOT NULL,
    fim_evento TIMESTAMP NOT NULL,
    local_evento VARCHAR(255) NOT NULL,
    capacidade INTEGER NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    organizador VARCHAR(255) NOT NULL


)