package dao;

import java.util.List;

import entities.BookingRoom;

public interface BookingRoonDAO {
	public List<BookingRoom> getBookingRoom();
	public void insert(BookingRoom bookingRoom);
	public BookingRoom getBookingRoomById(Integer id);
	public void update (BookingRoom bookingRoom);
	public void delete(Integer id);
	public List<BookingRoom> search(String bookingId);
	public List<BookingRoom> getBookingRoomPagination(Integer offset, Integer maxResult);
	public Long getTotalBookingRoomPagination();
}
