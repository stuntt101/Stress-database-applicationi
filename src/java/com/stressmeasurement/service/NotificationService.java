/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stressmeasurement.service;

import com.stressmeasurement.entity.Message;
import com.stressmeasurement.entity.StressMeasurement;
import com.stressmeasurement.entity.User;
import com.stressmeasurement.hibernate.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author LQwabe
 */
public class NotificationService {

    /**
     *
     * @param stressMeasurement
     * @return
     */
    public boolean addMessage(Message message) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        if (isMessageExists(message)) {
            return false;
        }

        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(message);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return true;
    }

    public void deleteMessage(Integer id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Message message = (Message) session.load(StressMeasurement.class, new Integer(id));
            session.delete(message);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }

    }

    public void updateMessage(Message message) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(message);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }

    }

    public List<Message> getAllStressMessages() {
        List<Message> list = new ArrayList<Message>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from Message").list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    public boolean isMessageExists(Message message) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean result = false;
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Message where messageId='" + message.getMessageId() + "'");
            StressMeasurement mng = (StressMeasurement) query.uniqueResult();
            tx.commit();
            if (mng != null) {
                result = true;
            }
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }

    public Message getMessageById(Integer messageId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Message message = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Message where messageId='" + messageId + "'");
            message = (Message) query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return message;
    }
    
     public List<Message> getMessageBySenderId(User sender, int flagSDeleted) {

        List<Message> list = new ArrayList<Message>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        
        String QUERY = "from Message m where m.senderId='" + sender.getUsername() + "'and m.flagSDeleted = '" + flagSDeleted + "'";

        try {

            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery(QUERY).list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return list;

    }
      public List<Message> getMessageByRecipientId(User recipient, int flagRDeleted) {

        List<Message> list = new ArrayList<Message>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        String QUERY = "from Message m where m.recipientId='" + recipient.getUsername() + "'and m.flagRDeleted = '" + flagRDeleted + "'";

        try {

            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery(QUERY).list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return list;

    }
       public List<Message> getReadMessages(User recipient, int flagRRead) {

        List<Message> list = new ArrayList<Message>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        String QUERY = "from Message m where m.recipientId='" + recipient.getUsername() + "'and m.flagRRead = '" + flagRRead + "'";

        try {

            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery(QUERY).list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return list;

    }
}
