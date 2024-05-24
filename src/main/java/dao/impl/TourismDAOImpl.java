package dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.TourismDAO;
import entities.Tourism;

@Repository
public class TourismDAOImpl implements TourismDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Tourism> getTourism() {
		Session session = sessionFactory.openSession();
		List<Tourism> results = session.createQuery("from Tourism").getResultList();
		session.close();
		return results;
	}

	@Override
	public void insert(Tourism tourism) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(tourism);
		session.getTransaction().commit();
	}

	@Override
	public Tourism getTourismById(Integer idTour) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Tourism tourism = session.get(Tourism.class, idTour);
		session.getTransaction().commit();
		return tourism;
	}

	@Override
	public void update(Tourism tourism) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(tourism);
		session.getTransaction().commit();
	}

	@Override
	public void delete(Integer idTour) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Tourism item = session.get(Tourism.class, idTour);
			session.remove(item);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Tourism> search(String locationName) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Tourism where locationName like :locationName");
		query.setParameter("locationName", "%" + locationName + "%");
		return query.getResultList();
	}

	@Override
	public List<Tourism> getTourismPagination(Integer offset, Integer maxResult) {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Tourism")
			.setFirstResult(offset)
			.setMaxResults(maxResult)
			.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Long getTotalTourismPagination() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("select count(*) from Tourism").list();
			return (Long) list.get(0);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	
	
}
