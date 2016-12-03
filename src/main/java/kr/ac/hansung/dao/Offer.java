package kr.ac.hansung.dao;

public class Offer {

	private int year;
	private int semester;
	private String code;
	private String name;
	private String division;
	private int grade;
	
	
	public Offer(int year, int semester, String code, String name, String division, int grade) {
		super();
		this.year = year;
		this.semester = semester;
		this.code = code;
		this.name = name;
		this.division = division;
		this.grade = grade;
	}
	
	public Offer() {
	}

	public int getYear() {
		return year;
	}

	public int getSemester() {
		return semester;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getDivision() {
		return division;
	}

	public int getGrade() {
		return grade;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}


	@Override
	public String toString() {
		return "Offer [year=" + year + ", semester=" + semester + ", code=" + code + ", name=" + name + ",division=" + division + ",grade=" + grade + "]";
	}
	
	
	
}