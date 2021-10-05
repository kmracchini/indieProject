package com.stitchable.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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

    @Column(name = "user_id")
    private int userId;

    public Designer() {
    }

    public Designer(String name, String website) {
        this.name = name;
        this.website = website;
    }

    public Designer(String name, String website, String logo) {
        this.name = name;
        this.website = website;
        this.logo = logo;
    }

    public Designer(String name, String website, int userId) {
        this.name = name;
        this.website = website;
        this.userId = userId;
    }

    public Designer(String name, String website, String logo, int userId) {
        this.name = name;
        this.website = website;
        this.logo = logo;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


}
