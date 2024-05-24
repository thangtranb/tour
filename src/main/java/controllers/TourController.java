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

import dao.TourDAO;
import entities.Tour;

@Controller
@RequestMapping("/admin")
public class TourController {
	@Autowired
	TourDAO tourDAO;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}
	
	@RequestMapping(value = "/tour")
	public String index(Model model, Integer page) {

		Integer itemPage = 3;
		Integer offset;
		if (page == null)
			offset = 0;
		else
			offset = (page - 1) * itemPage;

		List<Tour> tour = tourDAO.getTourPagination(offset, itemPage);
		model.addAttribute("tour", tour);

		Long totals = tourDAO.getTotalTourPagination();
		Integer totalPage = (int) (totals / itemPage + (totals % itemPage == 0 ? 0 : 1));

		List<Integer> list = new ArrayList();
		for (int i = 1; i <= totalPage; i++) {
			list.add(i);
		}

		model.addAttribute("list", list);
		return "admin/tour/listTour";
	}
	
	@RequestMapping(value = "tour/insertTour")
	public String insert(Model model) {
		Tour tour = new Tour();
		model.addAttribute("tour", tour);
		return "admin/tour/insertTour";
	}

	@RequestMapping(value = "/tour/save")
	public String insert(@Valid @ModelAttribute("tour") Tour tour, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("tour", tour);
			return "admin/tour/insertTour";
		}
		tourDAO.insert(tour);
		return "redirect:/admin/tour";
	}
	
	@RequestMapping(value = "/tour/edit")
	private String update(Model model, @RequestParam Integer id) {
		model.addAttribute("tour", tourDAO.getTourById(id));
		return "admin/tour/update";
	}
	
	@RequestMapping(value = "/tour/update")
	private String update(@ModelAttribute("tour") Tour tour, Integer id, Model model) {
		tourDAO.update(tour);
		return "redirect:/admin/tour";
	}
	
	@RequestMapping(value = "/tour/delete")
	public String delete(@RequestParam("id") Integer id, Model model) {
		tourDAO.delete(id);
		return "redirect:/admin/tour";
	}
	
	@RequestMapping(value = "/tour/search")
	public String index(Model model, @RequestParam("key") String key) {
		System.out.println(key);
		model.addAttribute("tour", tourDAO.search(key));
		return "admin/customer/listTour";
	}
}
