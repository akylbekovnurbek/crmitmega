package kg.itmegaschool.crmitmega.repository;

import kg.itmegaschool.crmitmega.model.entity.Group;
import kg.itmegaschool.crmitmega.model.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Optional<Group> findByIdAndIsDeletedFalse(Long id);
}
