package com.stitchable.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    private boolean isAdmin;

    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="favorites", joinColumns = {@JoinColumn(name="user_id", referencedColumnName = "id")},
                                 inverseJoinColumns = {@JoinColumn(name = "pattern_id", referencedColumnName = "id")})
    private Set<Pattern> favoritePatterns = new HashSet<>();

    /**
     * Instantiates a new User.
     *
     * @param name     the name
     * @param email    the email
     * @param userName the username
     * @param isAdmin if the user is an admin
     */
    public User(String name, String email, String userName, boolean isAdmin) {
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.isAdmin = isAdmin;
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

