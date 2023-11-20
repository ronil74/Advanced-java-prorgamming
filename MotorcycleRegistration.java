package uk.ac.ncl.coursework;
/**
 * @author Ronil
 */
import java.util.Random;

public class MotorcycleRegistration {
	private String reg1;
	private String reg2;
	private String registrationNumber;

	/**
	 * 
	 * Constructor
	 */
	MotorcycleRegistration(String reg1, String reg2, String registrationNumber) {
		this.reg1 = reg1;
		this.reg2 = reg2;
		registrationNumber = reg1 + reg2;
//		this.registrationNumber=registrationNumber;
	}

	/**
	 * 
	 * Creation of Motorcycle Registration Number
	 */
	MotorcycleRegistration() {
		Random rand = new Random();
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String digits = "0123456789";
		StringBuilder randomReg1 = new StringBuilder();
		StringBuilder randomReg2 = new StringBuilder();

		for (int i = 0; i < 2; i++) {
			char random1 = letters.charAt(rand.nextInt(letters.length()));
			randomReg1.append(random1);

		}

		for (int i = 0; i < 2; i++) {
			char randomDigit = digits.charAt(rand.nextInt(digits.length()));
			randomReg1.append(randomDigit);
		}

		this.reg1 = randomReg1.toString();

		for (int i = 0; i < 3; i++) {
			char random2 = letters.charAt(rand.nextInt(letters.length()));
			randomReg2.append(random2);

		}
		this.reg2 = randomReg2.toString();
		registrationNumber = reg1 + reg2;

	}
    
	/**
	 * 
	 * Method to get RegistrationNumber
	 * @return registration number of motorcycle
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}
    
	/**
	 * Method to set First component of Registration Number
	 * @author Ronil
	 * @return reg1
	 */
	public void setFirstComponent(String reg1) {
		this.reg1 = reg1;

	}

	/**
	 * Method to set Second component of Registration Number
	 * @return reg2
	 */
	public void setSecondComponent(String reg2) {
		this.reg1 = reg2;

	}

	/**
	 * Method to get First component of Registration Number
	 * 
	 */
	public String getFirstComponent() {
		return reg1;
	}

	/**
	 * Method to get Second component of Registration Number
	 */
	public String getSecondComponent() {
		return reg2;
	}

}
