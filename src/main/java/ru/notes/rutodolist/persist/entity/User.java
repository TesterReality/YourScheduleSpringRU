package ru.notes.rutodolist.persist.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by user on 14.11.2019.
 */
@Entity
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String pswd;

    @OneToMany(
            mappedBy = "user",//поле из ToDo
            cascade = CascadeType.ALL,
            orphanRemoval = true

    )
    private List<ToDo> todos;
    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }
}
