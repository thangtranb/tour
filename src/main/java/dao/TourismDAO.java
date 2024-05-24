package dao;

import java.util.List;

import entities.Tourism;

public interface TourismDAO {
	public List<Tourism> getTourism();
	public void insert(Tourism tourism);
	public Tourism getTourismById(Integer idTour);
	public void update (Tourism tourism);
	public void delete(Integer idTour);
	public List<Tourism> search(String locationName);
	public List<Tourism> getTourismPagination(Integer offset, Integer maxResult);
	public Long getTotalTourismPagination();
}
