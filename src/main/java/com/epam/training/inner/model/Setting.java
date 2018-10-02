package com.epam.training.inner.model;

import javax.persistence.*;

@Entity
@Table(name = "setting")
public class Setting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "vision_for_anonymous")
    private String visionForAnonymous;

    @Column(name = "vision_for_non_friend")
    private String visionForNonFriend;

    @Column(name = "vision_friends")
    private String visionFriends;

    @Column(name = "vision_presents")
    private String visionPresents;

    @Column(name = "vision_groups")
    private String visionGroups;

    @Column(name = "vision_sex")
    private String visionSex;

    @Column(name = "vision_age")
    private String visionAge;

    @Column(name = "vision_country_city")
    private String visionCountryCity;

    public Setting() {}

    public Setting(String visionForAnonymous, String visionForNonFriend, String visionFriends,
                   String visionPresents, String visionGroups, String visionSex, String visionAge,
                   String visionCountryCity) {
        this.visionForAnonymous = visionForAnonymous;
        this.visionForNonFriend = visionForNonFriend;
        this.visionFriends = visionFriends;
        this.visionPresents = visionPresents;
        this.visionGroups = visionGroups;
        this.visionSex = visionSex;
        this.visionAge = visionAge;
        this.visionCountryCity = visionCountryCity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVisionForAnonymous() {
        return visionForAnonymous;
    }

    public void setVisionForAnonymous(String visionForAnonymous) {
        this.visionForAnonymous = visionForAnonymous;
    }

    public String getVisionForNonFriend() {
        return visionForNonFriend;
    }

    public void setVisionForNonFriend(String visionForNonFriend) {
        this.visionForNonFriend = visionForNonFriend;
    }

    public String getVisionFriends() {
        return visionFriends;
    }

    public void setVisionFriends(String visionFriends) {
        this.visionFriends = visionFriends;
    }

    public String getVisionPresents() {
        return visionPresents;
    }

    public void setVisionPresents(String visionPresents) {
        this.visionPresents = visionPresents;
    }

    public String getVisionGroups() {
        return visionGroups;
    }

    public void setVisionGroups(String visionGroups) {
        this.visionGroups = visionGroups;
    }

    public String getVisionSex() {
        return visionSex;
    }

    public void setVisionSex(String visionSex) {
        this.visionSex = visionSex;
    }

    public String getVisionAge() {
        return visionAge;
    }

    public void setVisionAge(String visionAge) {
        this.visionAge = visionAge;
    }

    public String getVisionCountryCity() {
        return visionCountryCity;
    }

    public void setVisionCountryCity(String visionCountryCity) {
        this.visionCountryCity = visionCountryCity;
    }

    @Override
    public String toString() {
        return "Setting{" +
                "id=" + id +
                ", visionForAnonymous='" + visionForAnonymous + '\'' +
                ", visionForNonFriend='" + visionForNonFriend + '\'' +
                ", visionFriends='" + visionFriends + '\'' +
                ", visionPresents='" + visionPresents + '\'' +
                ", visionGroups='" + visionGroups + '\'' +
                ", visionSex='" + visionSex + '\'' +
                ", visionAge='" + visionAge + '\'' +
                ", visionCountryCity='" + visionCountryCity + '\'' +
                '}';
    }
}
