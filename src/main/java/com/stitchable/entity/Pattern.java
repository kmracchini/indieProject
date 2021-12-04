package com.stitchable.entity;

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

    @Transient
    private String size;

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

    @ManyToMany(mappedBy = "favoritePatterns")
    private Set<User> users;


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
     */
    public Pattern(String name, int width, int height, int numberOfColors, String keywords, String features,
                   String stitchedExample, String image, String url, Designer designer) {
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
    }

    @Transient
    public String getSize() {
        String patternSize = "";

        if ((width >= 100 && height >= 100) || (width >= 90 && height >= 100) || (height >= 90 && width >= 100)) {
            patternSize = "large";
        } else if ((width <= 50 && height <= 50) || (width < 60 && height <=50) || (height < 60 && width <=50)) {
            patternSize = "small";
        } else {
            patternSize = "medium";
        }

        return patternSize;
    }

    public void setSize(String size) {
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
