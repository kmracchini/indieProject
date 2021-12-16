package com.stitchable.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * The type Pattern.
 */
@NoArgsConstructor
@Data
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

    @ManyToOne
    private Designer designer;

    private String size;

    @ManyToMany(mappedBy = "favoritePatterns", fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<User> users;

    /**
     * Instantiates a new Pattern.
     *
     * @param id              the id
     * @param name            the name
     * @param width           the width
     * @param height          the height
     * @param numberOfColors  the number of colors
     * @param keywords        the keywords
     * @param features        the features
     * @param stitchedExample the stitched example
     * @param image           the image
     * @param url             the url
     * @param designer        the designer
     * @param size            the size
     */
    public Pattern(int id, String name, int width, int height, int numberOfColors, String keywords, String features, String stitchedExample, String image, String url, Designer designer, String size) {
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
        this.designer = designer;
        this.size = size;
    }

    /**
     * Instantiates a new Pattern.
     *
     * @param name            the name
     * @param width           the width
     * @param height          the height
     * @param numberOfColors  the number of colors
     * @param keywords        the keywords
     * @param features        the features
     * @param stitchedExample the stitched example
     * @param image           the image
     * @param url             the url
     * @param designer        the designer
     * @param size            the size
     */
    public Pattern(String name, int width, int height, int numberOfColors, String keywords, String features, String stitchedExample, String image, String url, Designer designer, String size) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.numberOfColors = numberOfColors;
        this.keywords = keywords;
        this.features = features;
        this.stitchedExample = stitchedExample;
        this.image = image;
        this.url = url;
        this.designer = designer;
        this.size = size;
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
