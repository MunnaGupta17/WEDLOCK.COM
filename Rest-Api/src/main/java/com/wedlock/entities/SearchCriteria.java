package com.wedlock.entities;

public class SearchCriteria {

	private Integer minAge;
	private Integer maxAge;
	private String location;
	private String education;
	private String gender;
	private String religion;
	private String caste;
	private String maritalStatus;

	// Constructors, getters, and setters
    public SearchCriteria() {
		// TODO Auto-generated constructor stub
	}

	public SearchCriteria(Integer minAge, Integer maxAge, String location, String education, String gender,
			String religion, String caste, String maritalStatus) {
		super();
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.location = location;
		this.education = education;
		this.gender = gender;
		this.religion = religion;
		this.caste = caste;
		this.maritalStatus = maritalStatus;
	}

	public Integer getMinAge() {
		return minAge;
	}

	public void setMinAge(Integer minAge) {
		this.minAge = minAge;
	}

	public Integer getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	@Override
	public String toString() {
		return "SearchCriteria [minAge=" + minAge + ", maxAge=" + maxAge + ", location=" + location + ", education="
				+ education + ", gender=" + gender + ", religion=" + religion + ", caste=" + caste + ", maritalStatus="
				+ maritalStatus + "]";
	}
    


}
