package com.epam.training.inner.service;

import com.epam.training.inner.dao.MessageDao;
import com.epam.training.inner.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private MessageDao messageDao;

    @Override
    public void save(Message message) {
        messageDao.save(message);
    }
}
