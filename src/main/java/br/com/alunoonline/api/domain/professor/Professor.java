package br.com.alunoonline.api.domain.professor;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "professor")
@Entity(name = "Professor")
@Getter
public class Professor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String cpf;
    private Boolean ativo = true;

}
