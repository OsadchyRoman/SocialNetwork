package com.epam.training.inner.service;

import com.epam.training.inner.dao.DialogDao;
import com.epam.training.inner.model.Dialog;
import com.epam.training.inner.model.Message;
import com.epam.training.inner.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class DialogServiceImpl implements IDialogService {

    @Autowired
    DialogDao dialogDao;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Dialog dialog) {
        dialogDao.save(dialog);
    }

    @Transactional
    @Override
    public void addMessage(Dialog dialog, Message message) {
        dialog.getMessages().add(message);
        em.merge(dialog);
    }

    @Override
    public Dialog findByFromUserAndToUser(User fromUser, User toUser) {
        return dialogDao.findByFromUserAndToUser(fromUser, toUser);
    }
}
