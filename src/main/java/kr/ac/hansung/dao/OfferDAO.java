package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
@Component
//@Component("offerDAO")
public class OfferDAO
{

	private JdbcTemplate jdbcTemplateObject;

	// @Autowired
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from myinfo";
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);

	}
	
	// Querying and returning multiple object
	public List<Offer> getOffers2(int year,int semester) {

		String sqlStatement = "select * from myinfo where year=? AND semester=?";
		return jdbcTemplateObject.query(sqlStatement,new Integer[] {year,semester},new OfferMapper()); // Anonymous
																			// Classes
	}
	public List<Offer> getOffers() {

		String sqlStatement = "select * from myinfo";
		return jdbcTemplateObject.query(sqlStatement,new OfferMapper()); // Anonymous
																			// Classes
	}
	public List<Offer> getOfferYearSemester(){
		
		String sqlStatement = "select year, semester from myinfo group by year, semester";
		return jdbcTemplateObject.query(sqlStatement, new YearSemesterMapper());
		
	}
	public List<Offer> getCourseSum(){
		String sqlStatement = "select division, sum(grade) from myinfo group by division";
		return jdbcTemplateObject.query(sqlStatement, new RowMapper<Offer>(){
			public Offer mapRow(ResultSet rs,int rowNum) throws SQLException{
				Offer offer = new Offer();
				offer.setDivision(rs.getString("division"));
				offer.setGrade(rs.getInt("sum(grade)"));
				return offer;
				
			}
		});
	}
	/*
	public List<Products> getOffers2() {

		String sqlStatement = "select * from producttb";

		return jdbcTemplateObject.query(sqlStatement, new ProductsMapper()); // Anonymous
																			// Classes

	}
	*/
	public boolean insert(Offer offer){
		int year = offer.getYear();
		int semester = offer.getSemester();
		String code = offer.getCode();
		String name = offer.getName();
		String division = offer.getDivision();
		int grade = offer.getGrade();
		
		
		String sqlStatement="insert into myinfo (year, semester, code, name, division, grade ) values (?,?,?,?,?,?)";
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{year, semester, code, name, division, grade})==1);
	}

	/*
	public boolean update(Offer offer){
		
		int year = offer.getYear();
		int semester = offer.getSemester();
		String code = offer.getCode();
		String name = offer.getName();
		String division = offer.getDivision();
		int grade = offer.getGrade();
		
		String sqlStatement="update enterprise set email=?, password=?, company=? where id=?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{email, password, company, id})==1);
	}
	*/
	/*
	public boolean delete (int id) {
		
		String sqlstatement="delete from enterprise where id=?";
		return(jdbcTemplateObject.update(sqlstatement,new Object[]{id})==1);
	}

*/

	
	

	
}