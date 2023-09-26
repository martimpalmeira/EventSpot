INSERT INTO tb_user (name, email) VALUES ('João', 'joao@fiap.com');
INSERT INTO tb_user (name, email) VALUES ('Maria', 'maria@fiap.com');
INSERT INTO tb_user (name, email) VALUES ('José', 'jose@fiap.com');



-- Associando um papel (role) ao usuário
INSERT INTO tb_user_roles (user_id, role) VALUES ((SELECT id FROM tb_user WHERE email = 'joao@fiap.com'), 'ORGANIZER');
INSERT INTO tb_user_roles (user_id, role) VALUES ((SELECT id FROM tb_user WHERE email = 'maria@fiap.com'), 'USER');
INSERT INTO tb_user_roles (user_id, role) VALUES ((SELECT id FROM tb_user WHERE email = 'jose@fiap.com'), 'USER');
