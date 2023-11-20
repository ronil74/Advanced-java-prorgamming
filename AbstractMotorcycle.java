/**
 * 
 */
package uk.ac.ncl.coursework;

/**
 * 
 * @author Ronil
 */
public abstract class AbstractMotorcycle implements Motorcycle {

	private boolean IsRented = false;

	private int charge;

	private MotorcycleRegistration registrationNumber;
    
	/**
	 * Method to charge battery
	 * @param Input Charge
	 * @return Current Charge
	 */
	public abstract int ChargeBattery(int charge);
    
	/**
	 * 
	 * Method to ride the motorcycle
	 * @param Input Distance
	 * @return consumption of charge
	 */
	public abstract int ride(int distance);

	/**
	 * Constructor for AbstarctMotorcycle 
	 * @param registrationNumber
	 * @param charge
	 * @param Boolean IsRented
	 */
	AbstractMotorcycle(MotorcycleRegistration registrationNumber, int charge, boolean IsRented) {
		this.setRegistrationNumber(registrationNumber);
		this.setCharge(charge);
		this.setIsRented(IsRented);
	}
    
	/**
	 * Constructor for AbstractMotorcycle
	 * @param registration number
	 * @param charge
	 */
	AbstractMotorcycle(MotorcycleRegistration registrationNumber, int charge) {
		this.setRegistrationNumber(registrationNumber);
		this.setCharge(charge);
		this.setIsRented(false);
	}
    
	/**
	 * Method to set charge
	 * @param input charge
	 * @return  charge
	 */
	public void setCharge(int charge) {
		this.charge = charge;
	}
	
    /**
     * Method to get charge
     * @return charge
     */
	public int getCharge() {
		return charge;
	}

	/**
	 * 
	 * Get Registration Number
	 * @return registration number
	 */
	public MotorcycleRegistration getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * Set Registration Number
	 * @param registrationNumber
	 */
	public void setRegistrationNumber(MotorcycleRegistration registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	/**
	 * Get Status of Motorcycle
	 * @return status isRented
	 */
	public boolean getIsRented() {
		return IsRented;
	}


	/**
	 * Set Status of Motorcycle
	 * @param isRented
	 */
	public void setIsRented(boolean isRented) {
		this.IsRented = isRented;
	}

}
