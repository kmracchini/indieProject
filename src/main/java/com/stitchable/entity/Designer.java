package com.stitchable.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a designer
 */
@NoArgsConstructor
@Data
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

    @Column(name = "etsy_store")
    private int etsyId;

    @OneToMany(mappedBy = "designer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<Pattern> patterns = new HashSet<>();

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
     * Instantiates a new Designer.
     *
     * @param name    the name
     * @param website the website
     * @param logo    the logo
     * @param etsyId  the etsy id
     */
    public Designer(String name, String website, String logo, int etsyId) {
        this.name = name;
        this.website = website;
        this.logo = logo;
        this.etsyId = etsyId;
    }

    public Designer(int id, String name, String website, String logo, int etsyId) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.logo = logo;
        this.etsyId = etsyId;
    }

    /**
     * Gets patterns.
     *
     * @return the patterns
     */
    public Set<Pattern> getPatterns() {
        return patterns;
    }

    /**
     * Sets patterns.
     *
     * @param patterns the patterns
     */
    public void setPatterns(Set<Pattern> patterns) {
        this.patterns = patterns;
    }

    /**
     * Adds a pattern.
     *
     * @param pattern the pattern
     */
    public void addPattern(Pattern pattern) {
        patterns.add(pattern);
        pattern.setDesigner(this);
    }

    /**
     * Removes a pattern.
     *
     * @param pattern the pattern
     */
    public void removePattern(Pattern pattern) {
        patterns.remove(pattern);
        pattern.setDesigner(null);
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
