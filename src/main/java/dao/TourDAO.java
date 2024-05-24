package dao;

import java.util.List;

import entities.Tour;


public interface TourDAO {
	public List<Tour> getTour();
	public void insert(Tour tour);
	public Tour getTourById(Integer id);
	public void update (Tour tour);
	public void delete(Integer id);
	public List<Tour> search(String tourName);
	public List<Tour> getTourPagination(Integer offset, Integer maxResult);
	public Long getTotalTourPagination();
}
