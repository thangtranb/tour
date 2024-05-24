package dao;

import java.util.List;

import entities.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomer();
	public void insert(Customer customer);
	public Customer getCustomerById(Integer customerId);
	public void update (Customer customer);
	public void delete(Integer customerId);
	public List<Customer> search(String name);
	public List<Customer> getCustomerPagination(Integer offset, Integer maxResult);
	public Long getTotalCustomerPagination();
}
