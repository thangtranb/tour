package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tourism")
public class Tourism {
	@Id
	@Column(name = "IdTour")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTour;
	@Column(name = "LocationName")
	private String locationName;
	@Column(name = "Description")
	private String description;
	@Column(name = "Image")
	private String image;
	@Column(name = "Location")
	private String location;
	@Column(name = "Price")
	private Float price;
	@Column(name = "Created_at")
	private Date created_at;
	@Column(name = "Update_at")
	private Date update_at;
	
	public Tourism() {
		// TODO Auto-generated constructor stub
	}

	public Tourism(Integer idTour, String locationName, String description, String image, String location, Float price,
			Date created_at, Date update_at) {
		super();
		this.idTour = idTour;
		this.locationName = locationName;
		this.description = description;
		this.image = image;
		this.location = location;
		this.price = price;
		this.created_at = created_at;
		this.update_at = update_at;
	}

	public Integer getIdTour() {
		return idTour;
	}

	public void setIdTour(Integer idTour) {
		this.idTour = idTour;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
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
