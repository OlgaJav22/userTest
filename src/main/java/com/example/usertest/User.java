package com.example.usertest;

import java.util.Objects;
import java.util.regex.Pattern;

public class User {
    private String login;
    public String email;

    public User() {
    }

    public User(String login, String email) {
        this.login = createLogin(login);

        this.email = createEmail(email);
    }

    public String getLogin() {
        return this.login;
    }

    public String getEmail() {
        return this.email;
    }

    public String createLogin(String login) {
        if ((login!=null&&!login.isEmpty() && !login.isBlank()) && Pattern.matches("[a-z A-Z0-9]{8}", login)) {
            return this.login = login;

        } else {
            return "Некорректно введен логин";
        }
    }


    public String createEmail(String email) {
        if ((email!=null&&!email.isEmpty() && !email.isBlank()) && Pattern.matches("[a-z A-Z0-9@.]{10}", email)) {
            return this.email = email;

        } else {
            return "Некорректно введен email";
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
