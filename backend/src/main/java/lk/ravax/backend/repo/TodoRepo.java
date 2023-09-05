package lk.ravax.backend.repo;

import lk.ravax.backend.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Integer> {

    @Query(value = "SELECT * FROM todo WHERE id=?1", nativeQuery = true)
    Todo existTodo (String id);

    void deleteById (String id);

}
