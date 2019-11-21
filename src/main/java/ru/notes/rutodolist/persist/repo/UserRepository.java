package ru.notes.rutodolist.persist.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.notes.rutodolist.persist.entity.User;

import java.util.Optional;

/**
 * Created by user on 14.11.2019.
 */
@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    boolean existsByUserName(String userName);
    Optional<User> getUserByUserName(String userName);

}
