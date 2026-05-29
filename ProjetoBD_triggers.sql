-- Trigger 1 -- Registrar criação de aluno

CREATE OR REPLACE FUNCTION registrar_aluno()
RETURNS TRIGGER AS $$
BEGIN 
    NEW.criado_em := now();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER trg_registrar_usuario
BEFORE INSERT ON aluno
FOR EACH ROW 
EXECUTE FUNCTION registrar_aluno();

SELECT * FROM aluno a 

-- Trigger 2 -- Registrar crição de Matricula

CREATE OR REPLACE FUNCTION registrar_matricula()
RETURNS TRIGGER AS $$
BEGIN 
    NEW.criado_em := now();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER trg_registrar_matricula
BEFORE INSERT ON matricula_aluno
FOR EACH ROW 
EXECUTE FUNCTION registrar_matricula();


SELECT * FROM matricula_aluno ma 

-- View -- Select historico de matriculas completo de todos os alunos

DROP VIEW  vw_historico_aluno

CREATE VIEW vw_historico_aluno as
SELECT 
	a.id AS aluno_id,
	a.nome AS aluno,
	m.id AS matricula_id,
	d.nome AS disciplina,
	m.nota1,
	m.nota2,
	m.status
FROM matricula_aluno m
JOIN aluno a ON a.id = m.aluno_id
JOIN disciplinas d ON d.id = m.disciplina_id
	
SELECT * FROM vw_historico_aluno