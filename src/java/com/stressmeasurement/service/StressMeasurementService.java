/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stressmeasurement.service;



import com.stressmeasurement.hibernate.util.HibernateUtil;
import com.stressmeasurement.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author LQwabe
 */
public class StressMeasurementService {

    /**
     *
     * @param stressMeasurement
     * @return 
     */
    public boolean addStressMeasurement(StressMeasurement stressMeasurement) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	
        if (isStressMeasurementExists(stressMeasurement)) {
	    return false;
	}

	Transaction tx = null;
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    session.saveOrUpdate(stressMeasurement);
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
    
    
    public void deleteStressMeasurement(Integer id) {
	Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            StressMeasurement stressMeasurement = (StressMeasurement) session.load(StressMeasurement.class, new Integer(id));
            session.delete(stressMeasurement);
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
    public void updateStressMeasurement(StressMeasurement stressMeasurement) {
	Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(stressMeasurement);
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
public List<StressMeasurement> getAllStressMeasurements() {
	List<StressMeasurement> list = new ArrayList<StressMeasurement>();
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    list = session.createQuery("from StressMeasurement").list();
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


    public boolean isStressMeasurementExists(StressMeasurement stressMeasurement) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	boolean result = false;
	Transaction tx = null;
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    Query query = session.createQuery("from StressMeasurement where id='" + stressMeasurement.getSmId() + "'");
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
     public StressMeasurement getStressMeasurementById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
       StressMeasurement mng =null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from StressMeasurement where id='" + id + "'");
            mng = (StressMeasurement) query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return  mng;
    }
    
    
        public List<String> getAllCountries() {

        List<String> list = new ArrayList<String>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        
        String QUERY = "SELECT DISTINCT(country) from StressMeasurement";

        try {

            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery(QUERY).list();
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
      public List<String> searchByLocation(String location) {

        String QUERY_BASED_ON_LOCATION_NAME = "SELECT DISTINCT(location) from StressMeasurement s where s.location like '";

        List<String> list = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();

            list = session.createQuery(QUERY_BASED_ON_LOCATION_NAME + location + "%'").list();
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
      public List<String> searchBySite(String site) {

        String QUERY_BASED_ON_SITE_NAME = "SELECT DISTINCT(site) from StressMeasurement s where s.site like '";

        List<String> list = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();

            list = session.createQuery(QUERY_BASED_ON_SITE_NAME + site + "%'").list();
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
      
      public List<String> searchByLocality(String locality) {

        String QUERY_BASED_ON_LOCALITY_NAME = "SELECT DISTINCT(locality) from StressMeasurement s where s.locality like '";

        List<String> list = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();

            list = session.createQuery(QUERY_BASED_ON_LOCALITY_NAME + locality + "%'").list();
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
        public List<String> searchByMethod(String method) {

        String QUERY_BASED_ON_METHOD_NAME = "SELECT DISTINCT(method) from StressMeasurement s where s.method like '";

        List<String> list = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();

            list = session.createQuery(QUERY_BASED_ON_METHOD_NAME + method + "%'").list();
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
         public List<String> searchByRock(String rock) {

        String QUERY_BASED_ON_METHOD_NAME = "SELECT DISTINCT(rock) from StressMeasurement s where s.rock like '";

        List<String> list = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();

            list = session.createQuery(QUERY_BASED_ON_METHOD_NAME + rock + "%'").list();
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
    public List<String> searchBySEQ(String seq) {

        String QUERY_BASED_ON_SEQ_NAME = "SELECT DISTINCT(seq) from StressMeasurement s where s.seq like '";

        List<String> list = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();

            list = session.createQuery(QUERY_BASED_ON_SEQ_NAME + seq + "%'").list();
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
      public List<String> searchByREFF(String reff) {

        String QUERY_BASED_ON_REFF_NAME = "SELECT DISTINCT(reff) from StressMeasurement s where s.reff like '";

        List<String> list = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();

            list = session.createQuery(QUERY_BASED_ON_REFF_NAME + reff + "%'").list();
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
   
      public List<StressMeasurement> findByVerified(String verified) {
	List<StressMeasurement> list = new ArrayList<StressMeasurement>();
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;
	try {
	    tx = session.getTransaction();
	    tx.begin();
            Query query = session.createQuery("from StressMeasurement where verified='" + verified + "'");
	    list = query.list();
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
    
     
    
}