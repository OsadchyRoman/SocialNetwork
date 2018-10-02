package com.epam.training.inner.dao;

import com.epam.training.inner.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageDao extends JpaRepository<Message, Long> {

}
