package com.epam.training.inner.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dialog")
public class Dialog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_user_id", nullable = false)
    private User fromUser;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "to_user_id", nullable = false)
    private User toUser;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "dialog_message",
            joinColumns = @JoinColumn(name = "dialog_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "message_id", referencedColumnName = "id", nullable = false))
    private List<Message> messages;

    public Dialog() {

    }

    public Dialog(User fromUser, User toUser, List<Message> messages) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.messages = messages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Message getLastMessage() {
        return messages.isEmpty() ? null : messages.get(messages.size() - 1);
    }

}
