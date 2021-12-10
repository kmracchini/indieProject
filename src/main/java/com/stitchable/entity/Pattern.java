package com.stitchable.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * The type Pattern.
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity(name="Pattern")
@Table(name="pattern")
public class Pattern {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private String name;
    private int width;
    private int height;

    @Column(name = "number_of_colors")
    private int numberOfColors;
    private String keywords;
    private String features;

    @Column(name = "stitched_example")
    private String stitchedExample;
    private String image;
    private String url;

    private String size;

    @ManyToOne
    private Designer designer;

    @ManyToMany(mappedBy = "favoritePatterns")
    private Set<User> users;

    public Pattern(int id, String name, int width, int height, int numberOfColors, String keywords, String features, String stitchedExample, String image, String url, String size, Designer designer) {
        this.id = id;
        this.name = name;
        this.width = width;
        this.height = height;
        this.numberOfColors = numberOfColors;
        this.keywords = keywords;
        this.features = features;
        this.stitchedExample = stitchedExample;
        this.image = image;
        this.url = url;
        this.size = size;
        this.designer = designer;
    }

    public Pattern(String name, int width, int height, int numberOfColors, String keywords, String features, String stitchedExample, String image, String url, String size, Designer designer) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.numberOfColors = numberOfColors;
        this.keywords = keywords;
        this.features = features;
        this.stitchedExample = stitchedExample;
        this.image = image;
        this.url = url;
        this.size = size;
        this.designer = designer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pattern pattern = (Pattern) o;
        return numberOfColors == pattern.numberOfColors && Objects.equals(name, pattern.name) && Objects.equals(keywords, pattern.keywords) && Objects.equals(image, pattern.image) && Objects.equals(designer, pattern.designer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberOfColors, keywords, image, designer);
    }
}
