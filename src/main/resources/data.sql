INSERT INTO CONDUTOR(nome, email, telefone, documento, cpf) VALUES('Bernardo', 'bernas@email.com', '+244923587493', 'B_I', '00001000PA52');
INSERT INTO CONDUTOR(nome, email, telefone, documento, cpf) VALUES('Ana', 'anas@email.com', '+244923555893', 'B_I', '00101000PA52');

INSERT INTO ENDERECO(rua, bairro, cep, numero, cidade, estado) VALUES('Acasias', 'Camama', 'SD52585', '2', 'Luanda', 'Angola');
INSERT INTO ENDERECO(rua, bairro, cep, numero, cidade, estado) VALUES('51', 'Nova Vida', 'SD52585', '181', 'Luanda', 'Angola');

INSERT INTO ESTACIONAMENTO(nome, descricao, estado, endereco_id) VALUES('Estacionamento AngoMart', 'Pavimentado e com cobertura', 'TRUE', '1');
INSERT INTO ESTACIONAMENTO(nome, descricao, estado, endereco_id) VALUES('Estacionamento OKA', 'Pavimentado e sem cobertura', 'TRUE', '2');
INSERT INTO ESTACIONAMENTO(nome, descricao, estado, endereco_id) VALUES('Estacionamento Descontão', 'Pavimentado e sem cobertura', 'TRUE', '1');

INSERT INTO VEICULO(marca, modelo, matricula, cavalos, condutor_id) VALUES('Hyundai', 'I10', '52-25-LA-25', '10', '2');
INSERT INTO VEICULO(marca, modelo, matricula, cavalos, condutor_id) VALUES('Ford', 'Range', '52-75-HO-25', '30', '1');
INSERT INTO VEICULO(marca, modelo, matricula, cavalos, condutor_id) VALUES('Jectour', 'X-270', '52-85-LA-25', '10', '2');
INSERT INTO VEICULO(marca, modelo, matricula, cavalos, condutor_id) VALUES('Toyota', 'Hilux', '12-55-LA-25', '60', '1');

INSERT INTO FORMA_PAGAMENTO(descricao, estado) VALUES('Em Cash', 'FALSE');
INSERT INTO FORMA_PAGAMENTO(descricao, estado) VALUES('Em Cash', 'FALSE');
INSERT INTO FORMA_PAGAMENTO(descricao, estado) VALUES('Transferência', 'FALSE');

INSERT INTO PARAMETRIZACAO_PAGAMENTO(data, periodo_estacionamento, forma_pagamento_id, valor_por_hora) VALUES('2023-10-02', 'POR_HORA', '1', '500');
INSERT INTO PARAMETRIZACAO_PAGAMENTO(data, periodo_estacionamento, forma_pagamento_id, valor_por_hora) VALUES('2023-10-02', 'POR_HORA', '2', '500');

INSERT INTO ESTACIONAMENTO_VEICULO(data_entrada, data_saida, parametrizacao_id, veiculo_id, estacionamento_id, data_inicio_pago, data_fim_pago) VALUES('2023-10-02', '2023-10-02', '1', '1', '2', '2023-10-02', '2023-10-02');
INSERT INTO ESTACIONAMENTO_VEICULO(data_entrada, data_saida, parametrizacao_id, veiculo_id, estacionamento_id, data_inicio_pago, data_fim_pago) VALUES('2023-10-02', '2023-10-02', '2', '2', '1', '2023-10-02', '2023-10-02');
INSERT INTO ESTACIONAMENTO_VEICULO(data_entrada, data_saida, parametrizacao_id, veiculo_id, estacionamento_id, data_inicio_pago, data_fim_pago) VALUES('2023-10-02', '2023-10-02', '1', '3', '2', '2023-10-02', '2023-10-02');
INSERT INTO ESTACIONAMENTO_VEICULO(data_entrada, data_saida, parametrizacao_id, veiculo_id, estacionamento_id, data_inicio_pago, data_fim_pago) VALUES('2023-10-02', '2023-10-02', '1', '4', '1', '2023-10-02', '2023-10-02');

INSERT INTO CONDUTOR_ENDERECO(condutor_id, endereco_id) VALUES('1', '1');
INSERT INTO CONDUTOR_ENDERECO(condutor_id, endereco_id) VALUES('2', '2');

