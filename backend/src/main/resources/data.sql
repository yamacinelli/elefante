INSERT INTO software_info (rep_type, inpi, name, version, document_type, document_number, developer_legal_name, developer_email)
VALUES ("REP-P", "111111111", "Elefante", "0.0.1", "CNPJ", "YM17W4A3000197", "Elefante Software Solution", "admin@elefante.com.br");

INSERT INTO user (email, password, is_first_access, role, is_enabled)
VALUES ("admin_sp@monster.com.br", "$2a$10$C8vQ/lwF5q1jM1jtw6bSGePa0J5iFgHUDEC1Q/B0WoCtjU4QZ/KVS", FALSE, "ADMIN", TRUE);
INSERT INTO user (email, password, is_first_access, role, is_enabled)
VALUES ("yagom.ym@gmail.com", "$2a$10$JunrMi.2nXHTb5GiWrpnSOXZ.3/SKBnYXn.6SblZj5G416vOeNdqe", FALSE, "EMPLOYEE", TRUE);
INSERT INTO user (email, password, is_first_access, role, is_enabled)
VALUES ("caua@gmail.com", "$2a$10$JunrMi.2nXHTb5GiWrpnSOXZ.3/SKBnYXn.6SblZj5G416vOeNdqe", FALSE, "EMPLOYEE", TRUE);
INSERT INTO user (email, password, is_first_access, role, is_enabled)
VALUES ("carlos@gmail.com", "$2a$10$JunrMi.2nXHTb5GiWrpnSOXZ.3/SKBnYXn.6SblZj5G416vOeNdqe", FALSE, "EMPLOYEE", TRUE);
INSERT INTO user (email, password, is_first_access, role, is_enabled)
VALUES ("henrique@gmail.com", "$2a$10$JunrMi.2nXHTb5GiWrpnSOXZ.3/SKBnYXn.6SblZj5G416vOeNdqe", FALSE, "EMPLOYEE", TRUE);
INSERT INTO user (email, password, is_first_access, role, is_enabled)
VALUES ("allana@gmail.com", "$2a$10$JunrMi.2nXHTb5GiWrpnSOXZ.3/SKBnYXn.6SblZj5G416vOeNdqe", FALSE, "EMPLOYEE", TRUE);

INSERT INTO employer (legal_name, document_type, document_number, cnae, caep_cno, address)
VALUES ("MONSTER ENERGY BRASIL COMÉRCIO DE BEBIDAS LTDA.", "CNPJ", "10905379000132", "6201501", NULL, "Av. Ibirapuera, 2332 - Indianópolis, São Paulo - SP, 04028-002");

INSERT INTO job (name, is_enabled)
VALUES ("Diretor", TRUE);
INSERT INTO job (name, is_enabled)
VALUES ("Desenvolvedor de Softwares Jr I", TRUE);
INSERT INTO job (name, is_enabled)
VALUES ("Desenvolvedor de Softwares Jr II", TRUE);
INSERT INTO job (name, is_enabled)
VALUES ("Desenvolvedor de Softwares Jr III", TRUE);
INSERT INTO job (name, is_enabled)
VALUES ("Desenvolvedor de Softwares Estagiário", TRUE);
INSERT INTO job (name, is_enabled)
VALUES ("Gerente de Desenvolvimento Comercial", TRUE);

INSERT INTO employee (name, cpf, hiring_date, user_id, job_id, employer_id)
VALUES ("Jean Carlos de Souza", "65501243016", CURRENT_DATE(), 1, 1, 1);
INSERT INTO employee (name, cpf, hiring_date, user_id, job_id, employer_id)
VALUES ("Yago dos Santos", "02756365009", CURRENT_DATE(), 2, 2, 1);
INSERT INTO employee (name, cpf, hiring_date, user_id, job_id, employer_id)
VALUES ("Cauã Diego Rodrigo Duarte", "63551400857", CURRENT_DATE(), 3, 2, 1);
INSERT INTO employee (name, cpf, hiring_date, user_id, job_id, employer_id)
VALUES ("Carlos Eduardo Enrico Viana", "60493207805", CURRENT_DATE(), 4, 4, 1);
INSERT INTO employee (name, cpf, hiring_date, user_id, job_id, employer_id)
VALUES ("Henrique Davi Gonçalves", "02929668814", CURRENT_DATE(), 5, 5, 1);
INSERT INTO employee (name, cpf, hiring_date, user_id, job_id, employer_id)
VALUES ("Allana Sebastiana Souza", "37667157049", CURRENT_DATE(), 6, 6, 1);
