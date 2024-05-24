package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tour")
public class Tour {
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "TourName")
	private String tourName;
	@Column(name = "Description")
	private String description;
	@Column(name = "Schedule")
	private String schedule;
	@Column(name = "Price")
	private Float price;
	@Column(name = "DepartureDay")
	private Date departureDay;
	@Column(name = "NumberoOfParticipants")
	private Integer numberoOfParticipants;
	@Column(name = "Created_at")
	private Date created_at;
	@Column(name = "Update_at")
	private Date update_at;
	
	public Tour() {
		// TODO Auto-generated constructor stub
	}

	public Tour(Integer id, String tourName, String description, String schedule, Float price, Date departureDay,
			Integer numberoOfParticipants, Date created_at, Date update_at) {
		super();
		this.id = id;
		this.tourName = tourName;
		this.description = description;
		this.schedule = schedule;
		this.price = price;
		this.departureDay = departureDay;
		this.numberoOfParticipants = numberoOfParticipants;
		this.created_at = created_at;
		this.update_at = update_at;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Date getDepartureDay() {
		return departureDay;
	}

	public void setDepartureDay(Date departureDay) {
		this.departureDay = departureDay;
	}

	public Integer getNumberoOfParticipants() {
		return numberoOfParticipants;
	}

	public void setNumberoOfParticipants(Integer numberoOfParticipants) {
		this.numberoOfParticipants = numberoOfParticipants;
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
