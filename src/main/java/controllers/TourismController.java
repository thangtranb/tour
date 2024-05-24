package controllers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import dao.TourismDAO;
import entities.Tourism;

@Controller
@RequestMapping("/admin")
public class TourismController {
	@Autowired
	TourismDAO tourismDAO;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}

	@RequestMapping(value = "/tourism")
	public String index(Model model, Integer page) {

		Integer itemPage = 3;
		Integer offset;
		if (page == null)
			offset = 0;
		else
			offset = (page - 1) * itemPage;

		List<Tourism> tourism = tourismDAO.getTourismPagination(offset, itemPage);
		model.addAttribute("tourism", tourism);

		Long totals = tourismDAO.getTotalTourismPagination();
		Integer totalPage = (int) (totals / itemPage + (totals % itemPage == 0 ? 0 : 1));

		List<Integer> list = new ArrayList();
		for (int i = 1; i <= totalPage; i++) {
			list.add(i);
		}

		model.addAttribute("list", list);
		return "admin/tourism/listTourism";

		/*
		 * List<Tourism> tourism = tourismDAO.getTourism(); model.addAttribute("list",
		 * tourism); return "admin/tourism/listTourism";
		 */
	}

	@RequestMapping(value = "/tourism/insertTourism")
	public String insertTourism(Model model) {
		Tourism tourism = new Tourism();
		model.addAttribute("tourism", tourism);
		return "admin/tourism/insertTourism";
	}

	@RequestMapping(value = "/tourism/save", method = RequestMethod.POST, consumes = "multipart/form-data")
	public String save(@ModelAttribute("tourism") Tourism tourism,
			@RequestParam(value = "file", required = false) MultipartFile file, Model model, HttpServletRequest req) {

		if (file != null && !file.isEmpty()) {
			String uploadRootPath = req.getServletContext().getRealPath("resources/images/tourism");
			File destination = new File(uploadRootPath + "/" + file.getOriginalFilename());
			try {
				file.transferTo(destination);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			System.out.println(file.getOriginalFilename());
			tourism.setImage("/images/tourism/" + file.getOriginalFilename());
		}
		tourismDAO.insert(tourism);
		return "redirect:/admin/tourism";
	}
	
	@RequestMapping("/tourism/edit")
	public String editcourse(Model model, @RequestParam Integer idTour) {
		model.addAttribute("tourism", tourismDAO.getTourismById(idTour));
		return "admin/tourism/update";
	}
	
	@RequestMapping("/tourism/update")
	public String updatecourse(Model model, @ModelAttribute("tourism") Tourism tourism, Integer courseId,
			@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest req) {
		if (file.getSize() > 0) {
			String uploadRootPath = req.getSession().getServletContext().getRealPath("resources/images/tourism");
			File destination = new File(uploadRootPath + "/" + file.getOriginalFilename());
			try {
				file.transferTo(destination);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			if (file.getOriginalFilename().length() > 0)
				tourism.setImage("images/tourism/" + file.getOriginalFilename());
			else {
				tourism.setImage(tourismDAO.getTourismById(tourism.getIdTour()).getImage());
			}
		} else {
			tourism.setImage(tourismDAO.getTourismById(tourism.getIdTour()).getImage());
		}
		
		tourismDAO.update(tourism);
		return "redirect:/admin/tourism";
	}
	
	@RequestMapping(value = "/tourism/delete")
	public String deletecourse(@RequestParam("idTour") int idTour, Model model) {
		tourismDAO.delete(idTour);
		return "redirect:/admin/tourism";
	}
	
	@RequestMapping(value = "/tourism/search")
	public String index(Model model, @RequestParam("key") String key) {
		System.out.println(key);
		model.addAttribute("tourism", tourismDAO.search(key));
		return "admin/tourism/listTourism";
	}
	
	

}
