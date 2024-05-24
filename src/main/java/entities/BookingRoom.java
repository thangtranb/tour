package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BookingRoom")
public class BookingRoom {
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "BookingId")
	private String bookingId;
	@Column(name = "DepartureDay")
	private Integer departureDay;
	@Column(name = "NumberOfParticipants")
	private Integer numberOfParticipants;
	@Column(name = "Price")
	private Integer price;
	@Column(name = "Created_at")
	private Date created_at;
	@Column(name = "Update_at")
	private Date update_at;
	
	@ManyToOne
	@JoinColumn(name = "customerId", referencedColumnName = "customerId")
	private Customer cusId;
	
	public BookingRoom() {
		// TODO Auto-generated constructor stub
	}
	
	public BookingRoom(Integer id, String bookingId, Integer departureDay, Integer numberOfParticipants, Integer price,
			Date created_at, Date update_at) {
		super();
		this.id = id;
		this.bookingId = bookingId;
		this.departureDay = departureDay;
		this.numberOfParticipants = numberOfParticipants;
		this.price = price;
		this.created_at = created_at;
		this.update_at = update_at;
	}

	public Customer getCusId() {
		return cusId;
	}

	public void setCusId(Customer cusId) {
		this.cusId = cusId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getDepartureDay() {
		return departureDay;
	}

	public void setDepartureDay(Integer departureDay) {
		this.departureDay = departureDay;
	}

	public Integer getNumberOfParticipants() {
		return numberOfParticipants;
	}

	public void setNumberOfParticipants(Integer numberOfParticipants) {
		this.numberOfParticipants = numberOfParticipants;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(Date update_at) {
		this.update_at = update_at;
	}
	
}
