package uk.ac.ncl.coursework;
/**
 * @author Ronil
 */
public class LargeMotorcycle extends AbstractMotorcycle {
    /**
     * Capacity =75KWH
     */
	public static final int capacity = 75;// in KWH
	/**
	 * charge consumed=0.15 KWH/KM
	 */
	public static final int ChargeConsumed = 2;

	/**
	 * Constructor
	 * @param registartion number
	 * @param charge
	 * @param IsRented
	 */
	public LargeMotorcycle(MotorcycleRegistration registrationNumber, int charge, boolean IsRented) {
		super(registrationNumber, charge, IsRented);
	}
    
	/**
	 * 
	 * @param registrationNumber
	 */
	public LargeMotorcycle(MotorcycleRegistration registrationNumber) {
		super(registrationNumber, capacity);
	}

	/**
	 * Get Registration Number
	 * @return Registration number of large motorcycle
	 */
	@Override
	public MotorcycleRegistration getRegistrationNumber() {
		// TODO Auto-generated method stub
		return super.getRegistrationNumber();
	}

	/**
	 * Get Capacity of motorcycle
	 * @return capacity of large motorcycle
	 */
	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return capacity;
	}

	/**
	 * get Current Charge
	 * @return current charge
	 */
	@Override
	public int getCharge() {
		// TODO Auto-generated method stub
		return super.getCharge();
	}

	/**
	 * Status of Battery
	 * @return true if battery is fully charged
	 */
	public final boolean IsBatteryCharged() {
		if (this.getCharge()==capacity) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * Method is use to charge battery of large motorcycle returns current charge
	 * @param charge
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
	 * @param distance
	 * @return consumption
	 * @throws IllegalArgumentException
	 * Method to ride large motorcycle returns charge consumption after ride
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
			System.out.println("Total consumption by large motorcycle:"+consumption);
			return consumption;
		}
		else 
		{
			System.out.println("Journey yet to commence");
			return 0;
		}
	}

}
