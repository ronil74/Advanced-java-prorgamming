package uk.ac.ncl.coursework;
/**
 * @author Ronil
 */
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Random;

public class RenterDrivinglicence {

	private final boolean isFulllicence;
	private final Date dateOfIssue;
	private final Date dateOfBirth;
	private final String firstName;
	private final String lastName;

	/**
	 * Get First name
	 * @return first name
	 */
	public final String getFirstName() {
		return firstName;
	}

	/**
	 * Get Last name
	 * @return last name
	 */
	public final String getLastName() {
		return lastName;
	}

	/**
	 * Get Name
	 * @return name(first name + last name)
	 */
	public final String getName() {
		return this.getFirstName() + " " + this.getLastName();
	}

	/**
	 * Get Date of Birth
	 * @return date of birth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Constructor
	 * @param firstName
	 * @param lastName
	 * @param dateOfBirth
	 * @param dateOfIssue
	 */
	public RenterDrivinglicence(String firstName, String lastName, Date dateOfBirth, Date dateOfIssue,
			boolean isFulllicence) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.dateOfIssue = dateOfIssue;
		this.isFulllicence = isFulllicence;
	}

	/**
	 * Get Frist component of driving licence number
	 * @return First character of First name + First character of last name
	 */
	public final String getFirstPartDl() {
		return this.getFirstName().charAt(0) + "" + this.getLastName().charAt(0);
	}

	/**
	 * Get Second Part of licence i.e year of issue
	 * @return year of date of issue
	 */
	public final String getSecondPartDl() {
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		return yearFormat.format(dateOfIssue);
	}

	/**
	 * Get Third component of driving licence number
	 * @return thirdpart dl
	 */
	public final int getThirdPartDl() {
		Random rand = new Random();
		return rand.nextInt(90) + 10;
	}

	/**
	 * Get Licence Number
	 * @return licence number
	 */
	public final String getlicenceNumber() {
		return this.getFirstPartDl() + "-" + this.getSecondPartDl() + "-" + getThirdPartDl();
	}

	/**
	 * Get Date of issue of licence
	 * @return date of issue
	 */
	public final Date getdateOfIssue() {
		return dateOfIssue;
	}

	/**
	 * Check If the licence is full or not
	 * @return boolean value true if full licence
	 */
	public final boolean getIsFullLicence() {
		return isFulllicence;
	}

	/**
	 * Method to display content
	 * @return toString method to display content
	 */
	public String toString() {
		return "licenceNumber: " + this.getlicenceNumber() + " issueDate: " + getdateOfIssue() + " this.isFullLicence: "
				+ isFulllicence;
	}

	/**
	 * 
	 * Method to calculate age of driving licence
	 * @return age 
	 */
	public int getAgeOfDrivingLicense() {
		Calendar current=Calendar.getInstance();
		Calendar issue=Calendar.getInstance();
		issue.setTime(dateOfIssue);
		int age = current.get(Calendar.YEAR)-issue.get(Calendar.YEAR);
		if(current.get(Calendar.DAY_OF_YEAR)<issue.get(Calendar.DAY_OF_YEAR)) 
		{
			age=age-1;
		}
		return age;
	}
    
	/**
	 * Equals Method to compare two objects
	 * @return boolean true if equals
	 */
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof RenterDrivinglicence)) {
			return false;
		}
		RenterDrivinglicence R = (RenterDrivinglicence) o;
		return this.getDateOfBirth().equals(R.getDateOfBirth()) && this.getName().equals(R.getName());
	}
	
	/**
	 * Method to check equals using hashcode
	 * @return hashcode
	 */

	public int hashCode() {
		int hc = 13;
		hc = 7 * hc + (this.getName() == null ? 0 : this.getName().hashCode());
		return 7 * hc + (this.getDateOfBirth() == null ? 0 : this.getDateOfBirth().hashCode());
	}

}
