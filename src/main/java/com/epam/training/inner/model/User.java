package com.epam.training.inner.model;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * JavaBean object that represents a User.
 */

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "sex")
    private String sex;

    @Column(name = "country_city_birth")
    private String countryCityBirth;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role roleId;

    @OneToOne
    @JoinColumn(name = "setting_id")
    private Setting settingId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_friendship",
            joinColumns = @JoinColumn(name = "from_user_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "to_user_id", referencedColumnName = "id", nullable = false))
    private Collection<User> friends;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "dialog",
            joinColumns = @JoinColumn(name = "from_user_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "to_user_id", referencedColumnName = "id", nullable = false))
    private List<Dialog> userDialogs;

    public User() {
    }

    public User(String name, String surname, String middleName, String birthday,
                String sex, String countryCityBirth, String login, String password, Role roleId,
                Setting settingId, Collection<User> friends, List<Dialog> userDialogs) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.birthday = birthday;
        this.sex = sex;
        this.countryCityBirth = countryCityBirth;
        this.login = login;
        this.password = password;
        this.roleId = roleId;
        this.settingId = settingId;
        this.friends = friends;
        this.userDialogs = userDialogs;
    }

    public User(String name, String surname, String middleName, String birthday, String sex,
                String countryCityBirth, String password,  Collection<User> friends, List<Dialog> userDialogs) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.birthday = birthday;
        this.sex = sex;
        this.countryCityBirth = countryCityBirth;
        this.password = password;
        this.userDialogs = userDialogs;
        this.friends = friends;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCountryCityBirth() {
        return countryCityBirth;
    }

    public void setCountryCityBirth(String countryCityBirth) {
        this.countryCityBirth = countryCityBirth;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Setting getSettingId() {
        return settingId;
    }

    public void setSettingId(Setting settingId) {
        this.settingId = settingId;
    }

    public Collection<User> getFriends() {
        return friends;
    }

    public void setFriends(Collection<User> friends) {
        this.friends = friends;
    }

    public List<Dialog> getUserDialogs() {
        return userDialogs;
    }

    public void setUserDialogs(List<Dialog> userDialogs) {
        this.userDialogs = userDialogs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id != null && id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
