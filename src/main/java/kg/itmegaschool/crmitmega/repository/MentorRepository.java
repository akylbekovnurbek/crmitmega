package kg.itmegaschool.crmitmega.repository;

import kg.itmegaschool.crmitmega.model.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
    Optional<Mentor> findByIdAndIsDeletedFalse(Long id);
}
