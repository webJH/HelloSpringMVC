package kr.ac.hansung.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.dao.Offer;
import kr.ac.hansung.service.OfferService;

@Controller
public class OfferController {

	private OfferService offerService;

	@Autowired // auto-wiring by type
	public void setOfferservice(OfferService offerService) {
		this.offerService = offerService;
	}

	@RequestMapping("/offers")
	public String showOffers(Model model, HttpServletRequest request) {
		int year = 0, semester = 0;

		year = Integer.parseInt(request.getParameter("year"));
		semester = Integer.parseInt(request.getParameter("semester"));

		List<Offer> offers = offerService.getCurrent2(year, semester);
		model.addAttribute("offers", offers);
		return "offers";
	}

	@RequestMapping("/apply")
	public String createOffer(Model model, HttpServletRequest request) {

		Offer offer = new Offer();
		offer.setYear(2016);
		offer.setSemester(2);
		offer.setName(request.getParameter("name"));
		offer.setCode(request.getParameter("code"));
		offer.setDivision(request.getParameter("division"));
		offer.setGrade(Integer.parseInt(request.getParameter("grade")));
		
			
		if (offerService.insertOffer(offer)) {
			List<Offer> apply = offerService.getCurrent2(2016, 2);
			model.addAttribute("apply", apply);
			return "success";
		} else {

			return "fail";
		}
	}

}
