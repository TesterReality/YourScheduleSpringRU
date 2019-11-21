package ru.notes.rutodolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.notes.rutodolist.persist.entity.ToDo;
import ru.notes.rutodolist.persist.repo.ToDoRepository;
import ru.notes.rutodolist.persist.repo.UserRepository;
import ru.notes.rutodolist.repr.ToDoRepr;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static ru.notes.rutodolist.service.UserService.getCurrentUser;

/**
 * Created by user on 16.11.2019.
 */
@Service
@Transactional
public class ToDoService {

    private final ToDoRepository toDoRepository;
    private UserRepository userRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository, UserRepository userRepository) {
        this.toDoRepository = toDoRepository;
        this.userRepository = userRepository;
    }

    public Optional<ToDoRepr> findById(Long id)
    {
        return toDoRepository.findById(id)
                .map(ToDoRepr::new);
    }

    public List<ToDoRepr> findToDosByUserId(Long userId)
    {
        return toDoRepository.findToDosByUserName(userId);
    }

    public void save(ToDoRepr toDoRepr) {
        getCurrentUser()
                .flatMap(userRepository::getUserByUserName)
                .ifPresent(user -> {
                    ToDo toDo = new ToDo();
                    toDo.setId(toDoRepr.getId());
                    toDo.setDescription(toDoRepr.getDescription());
                    toDo.setTargetDate(toDoRepr.getTargetDate());
                    toDo.setUser(user);
                    toDoRepository.save(toDo);
                });
    }

    public void delete(Long id) {
        toDoRepository.findById(id)
                .ifPresent(toDo -> toDoRepository.delete(toDo));
    }
}
