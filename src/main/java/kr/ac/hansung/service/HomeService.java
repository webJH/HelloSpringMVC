package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.Offer;
import kr.ac.hansung.dao.OfferDAO;



@Service("homeservice")
public class HomeService {

	private OfferDAO offerDAO;
	
	@Autowired
	public void setOfferDAO(OfferDAO offerDAO) {
		this.offerDAO = offerDAO;
	}
	
	public List<Offer> getOfferYearSemester(){
		return offerDAO.getOfferYearSemester();
	}
	
	public List<Offer> getCurrent(){
		return offerDAO.getOffers();
	}
	
	public List<Offer> getCourseSum() {
		return offerDAO.getCourseSum();
	}

}




