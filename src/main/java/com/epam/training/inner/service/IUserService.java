package com.epam.training.inner.service;

import com.epam.training.inner.model.Dialog;
import com.epam.training.inner.model.Role;
import com.epam.training.inner.model.Setting;
import com.epam.training.inner.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAllUsers();

    void saveUser(User user);

    List<Role> findAllRoles();

    List<Dialog> findAllDialogs();

    User findByLogin(String login);

    User findById(Long id);

    void updateUser(User user);

    void remove(User user, User friend);

    void addFriend(User user, User friend);

}
