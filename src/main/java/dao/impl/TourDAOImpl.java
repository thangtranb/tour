package dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.TourDAO;
import entities.Customer;
import entities.Tour;

@Repository
public class TourDAOImpl implements TourDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Tour> getTour() {
		Session session = sessionFactory.openSession();
		List<Tour> results = session.createQuery("from Tour").getResultList();
		session.close();
		return results;
	}

	@Override
	public void insert(Tour tour) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(tour);
		session.getTransaction().commit();
	}

	@Override
	public Tour getTourById(Integer id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Tour tour = session.get(Tour.class, id);
		session.getTransaction().commit();
		return tour;
	}

	@Override
	public void update(Tour tour) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(tour);
		session.getTransaction().commit();
	}

	@Override
	public void delete(Integer id) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Tour item = session.get(Tour.class, id);
			session.remove(item);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Tour> search(String tourName) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Tour where tourName like :tourName");
		query.setParameter("tourName", "%" + tourName + "%");
		return query.getResultList();
	}

	@Override
	public List<Tour> getTourPagination(Integer offset, Integer maxResult) {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Tour")
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
	public Long getTotalTourPagination() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("select count(*) from Tour").list();
			return (Long) list.get(0);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
}
