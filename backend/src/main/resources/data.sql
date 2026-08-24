INSERT INTO users (email, password, is_first_access, role, is_enabled) VALUES ("setup@teste.com", "$2a$10$C8vQ/lwF5q1jM1jtw6bSGePa0J5iFgHUDEC1Q/B0WoCtjU4QZ/KVS", 1, "ADMIN", 1);
INSERT INTO users (email, password, is_first_access, role, is_enabled) VALUES ("yagom.ym@gmail.com", "$2a$10$JunrMi.2nXHTb5GiWrpnSOXZ.3/SKBnYXn.6SblZj5G416vOeNdqe", 1, "EMPLOYEE", 1);

INSERT INTO work_details (name, last_name, identification_number, user_id) VALUES ("Yago", "dos Santos", "02756365009", 2)

INSERT INTO branchs (name, registration_number, is_enabled) VALUES ("Matriz", "PCVJDXJ4000118", 1);

INSERT INTO jobs (name, is_enabled) VALUES ("Desenvolvedor de Softwares Jr I", 1);
