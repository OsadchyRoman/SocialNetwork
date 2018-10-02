package com.epam.training.inner.service;

import com.epam.training.inner.model.Dialog;
import com.epam.training.inner.model.Message;
import com.epam.training.inner.model.User;

public interface IDialogService {
    void save(Dialog dialog);
    void addMessage(Dialog dialog, Message message);
    Dialog findByFromUserAndToUser(User fromUser, User toUser);
}
