package com.epam.training.inner.service;

import com.epam.training.inner.dao.DialogDao;
import com.epam.training.inner.dao.RoleDao;
import com.epam.training.inner.dao.SettingDao;
import com.epam.training.inner.dao.UserDao;
import com.epam.training.inner.model.Dialog;
import com.epam.training.inner.model.Role;
import com.epam.training.inner.model.Setting;
import com.epam.training.inner.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    @Autowired
    DialogDao dialogDao;

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    public List<Role> findAllRoles() {
        return roleDao.findAll();
    }

    @Override
    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public void updateUser(User user) {
       userDao.update(user.getId(), user.getName(), user.getSurname(), user.getMiddleName(), user.getBirthday(),
               user.getSex(), user.getCountryCityBirth(), user.getPassword());
    }

    @Override
    public List<Dialog> findAllDialogs() {
        return dialogDao.findAll();
    }

    @Transactional
    @Override
    public void remove(User user, User friend) {
        user.getFriends().remove(friend);
        em.merge(user);
    }

    @Transactional
    @Override
    public void addFriend(User user, User friend) {
        user.getFriends().add(friend);
        em.merge(user);
    }






}
