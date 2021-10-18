package com.stitchable.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Pattern.
 */
@Entity(name = "Pattern")
@Table(name = "pattern")
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

    @Column(name = "designer_id")
    private int designerId;

//    @ManyToOne
//    private Designer designer;

    /**
     * Instantiates a new Pattern.
     */
    public Pattern() {
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
     * @param designerId      the designer id
     */
    public Pattern(String name, int width, int height, int numberOfColors, String keywords, String features,
                   String stitchedExample, String image, String url, int designerId) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.numberOfColors = numberOfColors;
        this.keywords = keywords;
        this.features = features;
        this.stitchedExample = stitchedExample;
        this.image = image;
        this.url = url;
        this.designerId = designerId;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets width.
     *
     * @param width the width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets height.
     *
     * @param height the height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Gets number of colors.
     *
     * @return the number of colors
     */
    public int getNumberOfColors() {
        return numberOfColors;
    }

    /**
     * Sets number of colors.
     *
     * @param numberOfColors the number of colors
     */
    public void setNumberOfColors(int numberOfColors) {
        this.numberOfColors = numberOfColors;
    }

    /**
     * Gets keywords.
     *
     * @return the keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * Sets keywords.
     *
     * @param keywords the keywords
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * Gets features.
     *
     * @return the features
     */
    public String getFeatures() {
        return features;
    }

    /**
     * Sets features.
     *
     * @param features the features
     */
    public void setFeatures(String features) {
        this.features = features;
    }

    /**
     * Gets stitched example.
     *
     * @return the stitched example
     */
    public String getStitchedExample() {
        return stitchedExample;
    }

    /**
     * Sets stitched example.
     *
     * @param stitchedExample the stitched example
     */
    public void setStitchedExample(String stitchedExample) {
        this.stitchedExample = stitchedExample;
    }

    /**
     * Gets image.
     *
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets image.
     *
     * @param image the image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets designer id.
     *
     * @return the designer id
     */
    public int getDesignerId() {
        return designerId;
    }

    /**
     * Sets designer id.
     *
     * @param designerId the designer id
     */
    public void setDesignerId(int designerId) {
        this.designerId = designerId;
    }

    @Override
    public String toString() {
        return "Pattern{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfColors=" + numberOfColors +
                ", keywords='" + keywords + '\'' +
                ", image='" + image + '\'' +
                ", url='" + url + '\'' +
                ", designerId=" + designerId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pattern pattern = (Pattern) o;
        return id == pattern.id && numberOfColors == pattern.numberOfColors && designerId == pattern.designerId
                && Objects.equals(name, pattern.name) && Objects.equals(stitchedExample, pattern.stitchedExample);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, numberOfColors, stitchedExample, designerId);
    }
}
