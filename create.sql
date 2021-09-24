

-- -----------------------------------------------------
-- Table marcas
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS marcas (
  mar_codigo SERIAL ,
  mar_nome VARCHAR(45) NULL,
  PRIMARY KEY (mar_codigo) )
;


-- -----------------------------------------------------
-- Table veiculos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS veiculos (
  vei_codigo INT NOT NULL,
  vei_cd_marca INT NOT NULL,
  vei_placa VARCHAR(10) NULL,
  PRIMARY KEY (vei_codigo, vei_cd_marca) ,
  CONSTRAINT fk_veiculos_marcas1
    FOREIGN KEY (vei_cd_marca)
    REFERENCES marcas (mar_codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table cidades
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS cidades (
  cid_codigo SERIAL,
  cid_nome VARCHAR(45) NULL,
  cid_uf VARCHAR(2) NULL,
  PRIMARY KEY (cid_codigo) )
;


-- -----------------------------------------------------
-- Table clientes
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS clientes (
  cli_codigo SERIAL,
  cli_nome VARCHAR(100) NULL,
  cli_cd_cidade INT NOT NULL,
  Cli_endereco VARCHAR(100) NULL,
  Cli_numero VARCHAR(45) NULL,
  Cli_complemento VARCHAR(45) NULL,
  Cli_bairro VARCHAR(45) NULL,
  Cli_cep VARCHAR(15) NULL,
  Cli_cnpj_cpf VARCHAR(20) NULL,
  Cli_telefone VARCHAR(20) NULL,
  Cli_email VARCHAR(100) NULL,
  PRIMARY KEY (cli_codigo) ,
  CONSTRAINT fk_clientes_cidades1
    FOREIGN KEY (cli_cd_cidade)
    REFERENCES cidades (cid_codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table funcionarios
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS funcionarios (
  fun_codigo SERIAL,
  fun_nome VARCHAR(50) NULL,
  PRIMARY KEY (fun_codigo) )
;


-- -----------------------------------------------------
-- Table tipo_servico
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tipo_servico (
  tip_codigo SERIAL,
  tip_nome VARCHAR(45) NULL,
  PRIMARY KEY (tip_codigo) )
;


-- -----------------------------------------------------
-- Table setor
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS setor (
  set_codigo SERIAL,
  set_nome VARCHAR(50) NULL,
  PRIMARY KEY (set_codigo) )
;


-- -----------------------------------------------------
-- Table controle_veiculos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS controle_veiculos (
  con_cd_veiculo INT NOT NULL,
  con_cd_cliente INT NOT NULL,
  PRIMARY KEY (con_cd_veiculo, con_cd_cliente))
;


-- -----------------------------------------------------
-- Table agenda
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS agenda (
  age_codigo SERIAL,
  age_cd_funcionario INT NOT NULL,
  age_cd_tipo INT NOT NULL,
  age_cd_setor INT NOT NULL,
  age_cd_veiculo INT NOT NULL,
  age_cd_cliente INT NOT NULL,
  age_status INT NOT NULL,
  age_inicial timestamp NULL,
  age_final timestamp NULL,
  PRIMARY KEY (age_codigo) ,
  CONSTRAINT fk_agenda_funcionarios1
    FOREIGN KEY (age_cd_funcionario)
    REFERENCES funcionarios (fun_codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_agenda_setor1
    FOREIGN KEY (age_cd_tipo)
    REFERENCES tipo_servico (tip_codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_agenda_setor2
    FOREIGN KEY (age_cd_setor)
    REFERENCES setor (set_codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_agenda_controle_veiculos1
    FOREIGN KEY (age_cd_veiculo , age_cd_cliente)
    REFERENCES controle_veiculos (con_cd_veiculo , con_cd_cliente)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table tipo_pagamento
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tipo_pagamento (
  tip_codigo SERIAL,
  tip_nome VARCHAR(100) NULL,
  PRIMARY KEY (tip_codigo) )
;


-- -----------------------------------------------------
-- Table pagamentos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS pagamentos (
  pag_codigo SERIAL,
  pag_cd_tipo INT NOT NULL,
  pag_data DATE NULL,
  pag_valor FLOAT NULL,
  PRIMARY KEY (pag_codigo) ,
  CONSTRAINT fk_pagamentos_tipo_pagamento1
    FOREIGN KEY (pag_cd_tipo)
    REFERENCES tipo_pagamento (tip_codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table movimentos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS movimentos (
  mov_codigo SERIAL,
  mov_cd_pagamento INT NOT NULL,
  mov_cd_agenda INT NOT NULL,
  mov_valor FLOAT NULL,
  mov_obs TEXT NULL,
  PRIMARY KEY (mov_codigo) ,
  CONSTRAINT fk_movimentos_pagamentos1
    FOREIGN KEY (mov_cd_pagamento)
    REFERENCES pagamentos (pag_codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_movimentos_agenda1
    FOREIGN KEY (mov_cd_agenda)
    REFERENCES agenda (age_codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;
