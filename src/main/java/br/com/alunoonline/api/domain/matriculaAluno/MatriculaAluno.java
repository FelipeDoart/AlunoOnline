package br.com.alunoonline.api.domain.matriculaAluno;

import br.com.alunoonline.api.MatriculaAlunoStatusEnum;
import br.com.alunoonline.api.domain.aluno.Aluno;
import br.com.alunoonline.api.domain.disciplina.Disciplina;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "matricula_aluno")
@Data
@Entity
public class MatriculaAluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    private Double nota1;
    private Double nota2;

    @Enumerated(EnumType.STRING)
    private MatriculaAlunoStatusEnum status;
}
