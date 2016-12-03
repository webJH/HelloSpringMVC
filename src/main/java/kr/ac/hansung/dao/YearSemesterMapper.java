package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class YearSemesterMapper implements RowMapper<Offer> {

	public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

		Offer offer = new Offer();

		offer.setYear(rs.getInt("year"));
		offer.setSemester(rs.getInt("semester"));

		return offer;

	}
}
