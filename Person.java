package uk.ac.ncl.coursework;
/**
 * @author Ronil
 */
import java.util.Date;

public interface Person {
	
	/**
	 * 
     * Get the name.
     *
     * @return the name of the person
     */
	public String getName();
	
	/**
     * Get the DOB.
     *
     * @return the date of birth of the person
     */
	public Date getDateOfBirth();
	
	/**
     * Get driving licence.
     *
     * @return driving licence
     */
	public String getDrivinglicence();

	/**
     * Get the Age.
     *
     * @return Age of person
     */
	public int getAge();
	
	/**
     * Get the Age of Driving licence.
     *
     * @return the age of driving licence
     */
	public int getAgeOfDrivingLicense();
	
	
	/**
     * check if full licence or not
     *
     * @return boolean value
     */
	public boolean  getIsFullLicence();


}
