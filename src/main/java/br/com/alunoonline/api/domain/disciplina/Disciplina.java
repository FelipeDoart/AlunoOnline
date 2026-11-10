package br.com.alunoonline.api.domain.disciplina;

import br.com.alunoonline.api.domain.professor.Professor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "disciplinas  ")
@Data
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer cargaHoraria;

    /*Professor é uma classe, sendo necessario chama-lo por ele mesmo*/
    @ManyToOne //1-N
    @JoinColumn(name = "professor_id")
    private Professor professor;
}
