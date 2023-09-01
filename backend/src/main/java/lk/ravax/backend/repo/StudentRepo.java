package lk.ravax.backend.repo;

import lk.ravax.backend.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Todo, Integer> {
}
