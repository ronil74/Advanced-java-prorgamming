/**
 * @author Ronil
 */
package uk.ac.ncl.coursework;

public class SmallMotorcycle extends AbstractMotorcycle {
    /**
     * Capacity=50KWH
     */
	public static final int capacity = 50;
	/**
	 * Charge consumed= 1KWH/KM
	 */
	public static final int ChargeConsumed = 1;// 0.1 KWH/km


	/**
	 * Constructor
	 * @param registrationNumber
	 * @param charge
	 * @param IsRented
	 */
	public SmallMotorcycle(MotorcycleRegistration registrationNumber, int charge, boolean IsRented) {
		super(registrationNumber, charge, IsRented);
	}
    
	/**
	 * 
	 * @param registrationNumber
	 */
	public SmallMotorcycle(MotorcycleRegistration registrationNumber) {
		super(registrationNumber, capacity);
	}

	/**
	 * Get Registration Number of motorcycle
	 * @return Registration number
	 */
	@Override
	public MotorcycleRegistration getRegistrationNumber() {
		// TODO Auto-generated method stub
		return super.getRegistrationNumber();
	}

	/**
	 * Get Capacity of motorcycle
	 * @return capacity
	 */
	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return capacity;
	}

	/**
	 * Get Charge of motorcycle
	 * @return charge of small motorcycle
	 */
	@Override
	public int getCharge() {
		// TODO Auto-generated method stub
		return super.getCharge();
	}

	/**
	 * Status Of Battery
	 * @return status of battery
	 */
	public final boolean IsBatteryCharged() {
		if (getCharge()==capacity) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * Method to charge small motorcycle
	 * @param input charge
	 * @return current charge
	 * @throws IllegalArgumentException
	 */

	@Override
	public int ChargeBattery(int charge) {
		// TODO Auto-generated method stub
		if (charge<=0) {
			throw new IllegalArgumentException("Motorcycle not charging");
		}
		int CurrentCharge=this.getCharge();
		if (CurrentCharge==capacity) {
			throw new IllegalArgumentException("Battery Fully Charged ");
		} else {
			if (CurrentCharge+charge<=capacity) {
				CurrentCharge=CurrentCharge+charge;
			} else if (CurrentCharge+charge>capacity) {
				CurrentCharge=capacity;
			}
		}
		this.setCharge(CurrentCharge);
		return CurrentCharge;
	}

	/**
	 * 
	 * Method to ride small motorcycle
	 * @param int distance
	 * @return consumption (consumed charge during ride)
	 * @throws IllegalArgumentException
	 */
	@Override
	public int ride(int distance) {
		// TODO Auto-generated method stub

		if (distance<= 0)
		{
			throw new IllegalArgumentException("Please ride Motorcycle");
		}
		int charge=getCharge();
		int consumption=distance*ChargeConsumed;
		if (this.getIsRented() && charge>0 && charge>consumption)
		{
			charge=charge-consumption;
			this.setCharge(charge);
			System.out.println("Total consumption by small motorcycle:"+consumption);
			return consumption;

		} 
		else 
		{
			System.out.println("Journey yet to commence");
			return 0;
		}

	}

}
