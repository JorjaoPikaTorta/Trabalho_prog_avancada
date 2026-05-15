CREATE TABLE IF NOT EXISTS planetas (
    id        SERIAL PRIMARY KEY,
    tamanho   VARCHAR(50)  NOT NULL,
    nome      VARCHAR(100) NOT NULL,
    composicao VARCHAR(100) NOT NULL,
    qtde_luas INTEGER      NOT NULL DEFAULT 0
);
