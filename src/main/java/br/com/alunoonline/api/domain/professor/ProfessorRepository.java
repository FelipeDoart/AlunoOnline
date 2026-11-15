package br.com.alunoonline.api.domain.professor;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Range<Object> findAllByAtivoTrue(Pageable paginacao);
}
