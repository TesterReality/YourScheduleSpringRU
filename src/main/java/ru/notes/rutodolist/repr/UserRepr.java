package ru.notes.rutodolist.repr;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * Created by user on 14.11.2019.
 */
public class UserRepr {
    private Long id;
    @NotEmpty (message = "Введите Имя пользователя")
    private String userName;
    @NotBlank(message = "Введите пароль")
    private String pswd;
    @NotBlank (message = "Повторите пароль")
    private String matchingPswd;

    public UserRepr() {
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

    public String getMatchingPswd() {
        return matchingPswd;
    }

    public void setMatchingPswd(String matchingPswd) {
        this.matchingPswd = matchingPswd;
    }

    @Override
    public String toString() {
        return "UserRepr{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", pswd='" + pswd + '\'' +
                ", matchingPswd='" + matchingPswd + '\'' +
                '}';
    }
}
