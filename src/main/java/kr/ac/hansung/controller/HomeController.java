package kr.ac.hansung.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.dao.Offer;
import kr.ac.hansung.service.HomeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private HomeService homeservice;

	@Autowired
	public HomeController(HomeService homeservice) {
		this.homeservice = homeservice;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// @RequestMapping(value = "/", method = RequestMethod.GET)
	@RequestMapping(value = "/")
	public String showhome(Model model) {

		List<Offer> offers = homeservice.getOfferYearSemester();
		List<Offer> offers2 = homeservice.getCurrent();
		List<Integer> grade = new ArrayList<Integer>();
		int sum = 0;
		for (int i = 0; i <offers.size(); i++) {
			if (sum > 0) {
				grade.add(sum);
				sum = 0;
			}
			for (int j = 0; j <offers2.size(); j++) {
				if (offers.get(i).getYear() == offers2.get(j).getYear()
						&& offers.get(i).getSemester() == offers2.get(j).getSemester()) {
					sum += offers2.get(j).getGrade();
				}
			}
		}
		grade.add(sum);
		model.addAttribute("offers", offers);
		model.addAttribute("grade", grade);
		
		
		List<Offer> division = homeservice.getCourseSum();
		
		model.addAttribute("division", division);
		
		
		
		
		
		
		
		return "home";
	}
	
	@RequestMapping("/createOffer")
	public String showcreateOffer() {

		return "createOffer";
	}
	

}
