package com.epam.training.inner.dao;


import com.epam.training.inner.model.Dialog;
import com.epam.training.inner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DialogDao extends JpaRepository<Dialog, Long> {
    Dialog findByFromUserAndToUser(User fromUser, User toUser);

}
