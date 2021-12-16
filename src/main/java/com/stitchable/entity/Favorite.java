package com.stitchable.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Favorite.
 */
@NoArgsConstructor
@Data

@Entity(name="Favorite")
@Table(name="favorites")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Id
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name="pattern_id", referencedColumnName = "id")
    private Pattern pattern;

    /**
     * Instantiates a new Favorite.
     *
     * @param user    the user
     * @param pattern the pattern
     */
    public Favorite(User user, Pattern pattern) {
        this.user = user;
        this.pattern = pattern;
    }
}
