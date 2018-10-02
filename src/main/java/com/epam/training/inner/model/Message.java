package com.epam.training.inner.model;


import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "add_by_user_id")
    private User addByUserId;

    @Column(name = "text_comment")
    private String textComment;

    @Column(name = "add_date")
    private Date addDate;

    @Column(name = "add_time")
    private String time;

    public Message() {
    }

    public Message(User addByUserId, String textComment) {
        this.addByUserId = addByUserId;
        this.textComment = textComment;
        this.addDate = new Date();
        this.time = getTimeFromDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAddByUserId() {
        return addByUserId;
    }

    public void setAddByUserId(User addByUserId) {
        this.addByUserId = addByUserId;
    }

    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", addByUserId=" + addByUserId +
                ", textComment='" + textComment + '\'' +
                ", addDate=" + addDate +
                '}';
    }

    public String getTimeFromDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("k:mm");
        return simpleDateFormat.format(this.addDate);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

