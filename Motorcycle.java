package uk.ac.ncl.coursework;
/**
 * @author Ronil
 */
public interface Motorcycle {
	/**
	 * Get registration number of motorcycle
	 * @return registration number
	 */
	MotorcycleRegistration getRegistrationNumber();

	/**
	 * Get capacity of motorcycle.
	 *
	 * @return capacity
	 */
	int getCapacity();

	/**
	 * Get current charge.
	 *
	 * @return current charge of motorcycle
	 */
	int getCharge();

	/**
	 * Status of Battery
	 *
	 * @return boolean value
	 */
	boolean IsBatteryCharged();

	/**
	 * Charge Battery.
	 * @param charge
	 * @return current charge
	 */
	int ChargeBattery(int Charge);

	/**
	 * Ride Method.
	 * @param distance
	 * @return consumption.
	 */

	int ride(int distance);

}
