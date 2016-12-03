package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.Offer;
import kr.ac.hansung.dao.OfferDAO;

@Service("OfferService")
public class OfferService {
	private OfferDAO offerDAO;

	@Autowired
	public void setOfferDAO(OfferDAO offerDAO) {
		this.offerDAO = offerDAO;
	}

	public List<Offer> getCurrent2(int year, int semester) {

		return offerDAO.getOffers2(year, semester);
	}

	public List<Offer> getCurrent() {

		return offerDAO.getOffers();
	}

	public List<Offer> getOfferYearSemester() {

		return offerDAO.getOfferYearSemester();
	}
	public Boolean insertOffer(Offer offer) {

		return offerDAO.insert(offer);
	}
	
}
