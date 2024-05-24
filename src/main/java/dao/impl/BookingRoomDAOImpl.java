package dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.BookingRoonDAO;
import entities.BookingRoom;
import entities.Customer;
import entities.Tour;

@Repository
public class BookingRoomDAOImpl implements BookingRoonDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<BookingRoom> getBookingRoom() {
		Session session = sessionFactory.openSession();
		List<BookingRoom> results = session.createQuery("from BookingRoom").getResultList();
		session.close();
		return results;
	}

	@Override
	public void insert(BookingRoom bookingRoom) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(bookingRoom);
		session.getTransaction().commit();
	}

	@Override
	public BookingRoom getBookingRoomById(Integer id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		BookingRoom booking = session.get(BookingRoom.class, id);
		session.getTransaction().commit();
		return booking;
	}

	@Override
	public void update(BookingRoom bookingRoom) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(bookingRoom);
		session.getTransaction().commit();
	}

	@Override
	public void delete(Integer id) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			BookingRoom item = session.get(BookingRoom.class, id);
			session.remove(item);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<BookingRoom> search(String bookingId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from BookingRoom where bookingId like :bookingId");
		query.setParameter("bookingId", "%" + bookingId + "%");
		return query.getResultList();
	}

	@Override
	public List<BookingRoom> getBookingRoomPagination(Integer offset, Integer maxResult) {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from BookingRoom")
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
	public Long getTotalBookingRoomPagination() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("select count(*) from BookingRoom").list();
			return (Long) list.get(0);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
