package uk.ac.ncl.coursework;
/**
 * @author Ronil
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CompanyFleet {

	/**
	 * 
	 * Creates fleet of motorcycle
	 */
	public CompanyFleet() {
		super();
		addmotorcycle("Small", 20);
		addmotorcycle("Large", 10);
	}

	/**
	 * Hashmap to get list of Renters
	 * 
	 */

	private HashMap<Person, AbstractMotorcycle> mapRenterToMotorcycle = new HashMap<>();

	/**
	 * List to store fleet - consisting of 20 small and 10 large motorcycle
	 */
	private List<AbstractMotorcycle> fleetOfMotorcycle = new ArrayList<>();

	/**
	 * returns fleet of motorcycle
	 */
	public List<AbstractMotorcycle> getFleetOfMotorcycle() {
		return fleetOfMotorcycle;
	}
    /**
     * initalise fleet
     * @param motorcycleType
     * @param numberOfMotorcycles
     */
	void init_fleet(String motorcycleType, Integer numberOfMotorcycles) {
		addmotorcycle(motorcycleType, numberOfMotorcycles);
	}

	/**
	 * Add motorcycle to init fleet
	 * @param motorcycleType
	 * @param numberOfMotorcycles
	 */
	void addmotorcycle(String motorcycleType, Integer numberOfMotorcycles) {
		for (int i = 0; i < numberOfMotorcycles; i++) {
			MotorcycleRegistration RN = new MotorcycleRegistration();
			AbstractMotorcycle motorcycle;
			if (motorcycleType == "Small") {
				motorcycle = new SmallMotorcycle(RN);

			} else {
				motorcycle = new LargeMotorcycle(RN);
			}

			fleetOfMotorcycle.add(motorcycle);

		}
	}

	/**
	 * Available Motorcycle list
	 * @param typeOfMotorcycle
	 * @return available motorcycles
	 */
	public ArrayList<AbstractMotorcycle> availableMotorcycles(String typeOfMotorcycle) {
		ArrayList<AbstractMotorcycle> ListOfAvailableMotorcycle = new ArrayList<>();
		if (typeOfMotorcycle == "Small") {
			for (AbstractMotorcycle am : fleetOfMotorcycle) {
				if (am instanceof SmallMotorcycle && am.getIsRented() == false) {
					ListOfAvailableMotorcycle.add(am);
				}
			}

		} else {
			for (AbstractMotorcycle am : fleetOfMotorcycle) {
				if (am instanceof LargeMotorcycle && am.getIsRented() == false) {
					ListOfAvailableMotorcycle.add(am);
				}
			}

		}

		return ListOfAvailableMotorcycle;

	}

	/**
	 * Rented Motorcycles list
	 * @param typeOfMotorcycle
	 * @return list of Rented Motorcycle
	 */
	public ArrayList<AbstractMotorcycle> RentedMotorcycles(String typeOfMotorcycle) {
		ArrayList<AbstractMotorcycle> ListOfRentedMotorcycle = new ArrayList<>();
		if (typeOfMotorcycle == "Small") {
			for (AbstractMotorcycle am : fleetOfMotorcycle) {
				if (am instanceof SmallMotorcycle && am.getIsRented() == true) {
					ListOfRentedMotorcycle.add(am);
				}
			}

		} else {
			for (AbstractMotorcycle am : fleetOfMotorcycle) {
				if (am instanceof LargeMotorcycle && am.getIsRented() == true) {
					ListOfRentedMotorcycle.add(am);
				}
			}

		}

		return ListOfRentedMotorcycle;

	}

	/**
	 * Get details of Rented motorcycles
	 * @param Person
	 * @return details from hashmap
	 */
	public AbstractMotorcycle getMotorcycle(Person P) {

		return mapRenterToMotorcycle.get(P);
	}

	/**
	 * Method to issue Motorcycle  if  person has full licence and driving licence is older than given conditionn, returns boolean true when motorcycle is issued successfully
	 * @param Object of Person, driving licence, and type of motorcycle
	 * @return boolean value true if issued
	 */
	public boolean issueMotorcycle(Person R, String Drivinglicence, String typeOfMotorcycle) {
		AbstractMotorcycle am = this.availableMotorcycles(typeOfMotorcycle).get(0);
		if (am instanceof SmallMotorcycle || am instanceof LargeMotorcycle) {
			if (am instanceof SmallMotorcycle && R.getIsFullLicence() == true && R.getAgeOfDrivingLicense() >= 1
					&& R.getAge() >= 20) {
				am.setIsRented(true);
				mapRenterToMotorcycle.put(R, am);
				return true;
			}
			if (am instanceof LargeMotorcycle && R.getIsFullLicence() == true && R.getAgeOfDrivingLicense() >= 5
					&& R.getAge() >= 25) {
				am.setIsRented(true);
				System.out.println(am.getIsRented());
				mapRenterToMotorcycle.put(R, am);
				return true;
			}

		}

		return false;
	}

	/**
	 * Method to terminate rental and returns total charge left after cancelling the rental  if motorcycle is rented
	 * @param object of Person
	 * @return remaining charge
	 */
	public Integer terminateRental(Person R) {
		AbstractMotorcycle am = mapRenterToMotorcycle.get(R);
		if (am instanceof SmallMotorcycle || am instanceof LargeMotorcycle && am.getIsRented() == true) {
			int currentCharge = am.getCharge();

			mapRenterToMotorcycle.remove(R, am);
			if (am instanceof SmallMotorcycle) {
				am.setCharge(SmallMotorcycle.capacity);
				am.setIsRented(false);
				return SmallMotorcycle.capacity - currentCharge;

			}
			if (am instanceof LargeMotorcycle) {
				am.setCharge(LargeMotorcycle.capacity);
				am.setIsRented(false);
				return LargeMotorcycle.capacity - currentCharge;

			}
		}
		return 0;

	}

	/**
	 * 
	 * To string method to get the details of fleet of motorcycle including large
	 * and small motorcycles.
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Fleet of Motorcycles:\n");
		for (AbstractMotorcycle am : fleetOfMotorcycle) {
			result.append("Registration Number: ").append(am.getRegistrationNumber().getRegistrationNumber()).append("\n");
			result.append("Type: ");
			if (am instanceof SmallMotorcycle) {
				result.append("Small Motorcycle\n");
			} else if (am instanceof LargeMotorcycle) {
				result.append("Large Motorcycle\n");
			}
			result.append("Current Charge Level: ").append(am.getCharge()).append("\n");
			result.append("Is Electric Motorcycle Rented: ").append(am.getIsRented()).append("\n");
			result.append("\n");
		}
		return result.toString();
	}

}
