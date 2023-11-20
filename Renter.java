/**
 * @author Ronil
 */
package uk.ac.ncl.coursework;
/**
 * @author Ronil
 */
import java.util.Calendar;
import java.util.Date;

public class Renter extends RenterDrivinglicence implements Person {

	/**
	 * 
	 * Constructor
	 */
	public Renter(String firstName, String lastName, Date dateOfBirth, Date dateOfIssue, boolean isFulllicence) {
		super(firstName, lastName, dateOfBirth, dateOfIssue, isFulllicence);

	}

	/**
	 * String with renter info
	 * @return String 
	 */
	public String toString() {
		return "name:" + this.getName() + " Date of Birth:" + this.getDateOfBirth();
	}

	/**
	 * Method to get age from date of birth
	 * @return age
	 */
	public int getAge() {
		Calendar current=Calendar.getInstance();
		Calendar birth=Calendar.getInstance();
		birth.setTime(this.getDateOfBirth());
		int age=current.get(Calendar.YEAR)-birth.get(Calendar.YEAR);
		if(current.get(Calendar.DAY_OF_YEAR)<birth.get(Calendar.DAY_OF_YEAR))
		{
			age=age-1;
		}

		return age;
	}

	/**
	 * Get age of licence
	 * @return get age of driving licence
	 */
	public int getAgeOfDrivingLicense() {
		return super.getAgeOfDrivingLicense();
	}

	/**
	 * licence number
	 * @return licence
	 */
	@Override
	public String getDrivinglicence() {
		// TODO Auto-generated method stub
		return super.getlicenceNumber();
	}

	/**
	 * Equals Method
	 * @param object of class
	 * @return boolean value true if equals
	 */
	public boolean equals(Object R) {

		if (this == R) {
			return true;
		}
		if (!(R instanceof Renter)) {
			return false;

		}
		Renter P = (Renter) R;
		return this.getDateOfBirth().equals(P.getDateOfBirth()) && this.getName().equals(P.getName());
	}

	/**
	 * 
	 * Generate Hashcode
	 * @return hashcode for each variable
	 */
	public int hashCode() {
		int hc = 13;
		hc = 7 * hc + (this.getFirstName() == null ? 0 : this.getFirstName().hashCode());
		hc = 7 * hc + (this.getLastName() == null ? 0 : this.getLastName().hashCode());

		return 7 * hc + this.getAge();
	}

}
