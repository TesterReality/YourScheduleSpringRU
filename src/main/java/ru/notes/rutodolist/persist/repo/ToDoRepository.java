package ru.notes.rutodolist.persist.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.notes.rutodolist.persist.entity.ToDo;
import ru.notes.rutodolist.repr.ToDoRepr;

import java.util.List;

/**
 * Created by user on 16.11.2019.
 */
@Repository
public interface ToDoRepository extends CrudRepository<ToDo,Long> {

    @Query("select new ru.notes.rutodolist.repr.ToDoRepr(t) " +
            "from ToDo t " +
            "where t.user.id = :userId")
    List<ToDoRepr> findToDosByUserName(@Param("userId") Long userId);
}
