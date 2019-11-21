package ru.notes.rutodolist.persist.entity;

import com.sun.xml.bind.v2.TODO;
import ru.notes.rutodolist.repr.ToDoRepr;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by user on 16.11.2019.
 */
@Entity
@Table (name = "todos")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")//поле по которому соеденяются две таблицы
    private User user;

    @Column
    private LocalDate targetDate;

    public ToDo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }
}
