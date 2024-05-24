package controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.CustomerDAO;
import entities.Customer;
import entities.Tourism;


@Controller
@RequestMapping("/admin")
public class CustomerController {
	@Autowired
	CustomerDAO customerDAO;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}
	
	@RequestMapping(value = "/customer")
	public String index(Model model, Integer page) {

		Integer itemPage = 3;
		Integer offset;
		if (page == null)
			offset = 0;
		else
			offset = (page - 1) * itemPage;

		List<Customer> customer = customerDAO.getCustomerPagination(offset, itemPage);
		model.addAttribute("customer", customer);

		Long totals = customerDAO.getTotalCustomerPagination();
		Integer totalPage = (int) (totals / itemPage + (totals % itemPage == 0 ? 0 : 1));

		List<Integer> list = new ArrayList();
		for (int i = 1; i <= totalPage; i++) {
			list.add(i);
		}

		model.addAttribute("list", list);
		return "admin/customer/listCustomer";

	}
	
	@RequestMapping(value = "customer/insertCustomer")
	public String insert(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "admin/customer/insertCustomer";
	}

	@RequestMapping(value = "/customer/save")
	public String insert(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("customer", customer);
			return "admin/customer/insertCustomer";
		}
		customerDAO.insert(customer);
		return "redirect:/admin/customer";
	}
	
	@RequestMapping(value = "/customer/edit")
	private String update(Model model, @RequestParam Integer customerId) {
		model.addAttribute("customer", customerDAO.getCustomerById(customerId));
		return "admin/customer/update";
	}
	
	@RequestMapping(value = "/customer/update")
	private String update(@ModelAttribute("customer") Customer customer, Integer customerId, Model model) {
		customerDAO.update(customer);
		return "redirect:/admin/customer";
	}
	
	@RequestMapping(value = "/customer/delete")
	public String delete(@RequestParam("customerId") Integer customerId, Model model) {
		customerDAO.delete(customerId);
		return "redirect:/admin/customer";
	}
	
	@RequestMapping(value = "/customer/search")
	public String index(Model model, @RequestParam("key") String key) {
		System.out.println(key);
		model.addAttribute("customer", customerDAO.search(key));
		return "admin/customer/listCustomer";
	}
}
