package com.stitchable.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type User.
 */
@NoArgsConstructor
@Data
@Entity(name="User")
@Table(name="user")
public class User {

    private String name;

    private String email;

    @Column(name = "user_name")
    private String userName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;


    /**
     * Instantiates a new User.
     *
     * @param name     the name
     * @param email    the email
     * @param userName the user name
     */
    public User(String name, String email, String userName) {
        this.name = name;
        this.email = email;
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, userName);
    }
}

