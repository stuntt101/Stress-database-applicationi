/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stressmeasurement.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LQwabe
 */
@Entity
@Table(name = "message")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m"),
    @NamedQuery(name = "Message.findByMessageId", query = "SELECT m FROM Message m WHERE m.messageId = :messageId"),
    @NamedQuery(name = "Message.findBySubject", query = "SELECT m FROM Message m WHERE m.subject = :subject"),
    @NamedQuery(name = "Message.findByContent", query = "SELECT m FROM Message m WHERE m.content = :content"),
    @NamedQuery(name = "Message.findByFlagSDeleted", query = "SELECT m FROM Message m WHERE m.flagSDeleted = :flagSDeleted"),
    @NamedQuery(name = "Message.findByFlagRDeleted", query = "SELECT m FROM Message m WHERE m.flagRDeleted = :flagRDeleted"),
    @NamedQuery(name = "Message.findByFlagRRead", query = "SELECT m FROM Message m WHERE m.flagRRead = :flagRRead"),
    @NamedQuery(name = "Message.findBySentDate", query = "SELECT m FROM Message m WHERE m.sentDate = :sentDate")})
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "message_id")
    private Integer messageId;
    @Size(max = 45)
    @Column(name = "subject")
    private String subject;
    @Size(max = 45)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flag_s_deleted")
    private int flagSDeleted;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flag_r_deleted")
    private int flagRDeleted;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flag_r_read")
    private int flagRRead;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sent_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentDate;
    @JoinColumn(name = "sender_id", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private User senderId;
    @JoinColumn(name = "recipient_id", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private User recipientId;
    @JoinColumn(name = "data_reff_id", referencedColumnName = "SM_ID")
    @ManyToOne(optional = false)
    private StressMeasurement dataReffId;

    public Message() {
    }

    public Message(Integer messageId) {
        this.messageId = messageId;
    }

    public Message(Integer messageId, int flagSDeleted, int flagRDeleted, int flagRRead, Date sentDate) {
        this.messageId = messageId;
        this.flagSDeleted = flagSDeleted;
        this.flagRDeleted = flagRDeleted;
        this.flagRRead = flagRRead;
        this.sentDate = sentDate;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getFlagSDeleted() {
        return flagSDeleted;
    }

    public void setFlagSDeleted(int flagSDeleted) {
        this.flagSDeleted = flagSDeleted;
    }

    public int getFlagRDeleted() {
        return flagRDeleted;
    }

    public void setFlagRDeleted(int flagRDeleted) {
        this.flagRDeleted = flagRDeleted;
    }

    public int getFlagRRead() {
        return flagRRead;
    }

    public void setFlagRRead(int flagRRead) {
        this.flagRRead = flagRRead;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public User getSenderId() {
        return senderId;
    }

    public void setSenderId(User senderId) {
        this.senderId = senderId;
    }

    public User getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(User recipientId) {
        this.recipientId = recipientId;
    }

    public StressMeasurement getDataReffId() {
        return dataReffId;
    }

    public void setDataReffId(StressMeasurement dataReffId) {
        this.dataReffId = dataReffId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (messageId != null ? messageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.messageId == null && other.messageId != null) || (this.messageId != null && !this.messageId.equals(other.messageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stressmeasurement.entity.Message[ messageId=" + messageId + " ]";
    }
    
}
