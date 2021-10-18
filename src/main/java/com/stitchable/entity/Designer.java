package com.stitchable.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type Designer.
 */
@Entity(name="Designer")
@Table(name="designer")
public class Designer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private String name;
    private String website;
    private String logo;

    @OneToMany(mappedBy = "designer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Pattern> patterns = new HashSet<>();

    /**
     * Instantiates a new Designer.
     */
    public Designer() {
    }

    /**
     * Instantiates a new Designer.
     *
     * @param name    the name
     * @param website the website
     */
    public Designer(String name, String website) {
        this.name = name;
        this.website = website;
    }

    /**
     * Instantiates a new Designer.
     *
     * @param name    the name
     * @param website the website
     * @param logo    the logo
     */
    public Designer(String name, String website, String logo) {
        this.name = name;
        this.website = website;
        this.logo = logo;
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
     * Gets website.
     *
     * @return the website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Sets website.
     *
     * @param website the website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * Gets logo.
     *
     * @return the logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * Sets logo.
     *
     * @param logo the logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Set<Pattern> getPatterns() {
        return patterns;
    }

    public void setPatterns(Set<Pattern> patterns) {
        this.patterns = patterns;
    }

//    TODO: Add patterns to designer
//    public void addPattern(Pattern pattern) {
//        patterns.add(pattern);
//    }

    @Override
    public String toString() {
        return "Designer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", website='" + website + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Designer designer = (Designer) o;
        return id == designer.id && name.equals(designer.name) && website.equals(designer.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, website);
    }
}
