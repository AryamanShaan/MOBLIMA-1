package models;

public class Customer {
	
	/**
	 * This is Customer's Name
	 */
    private final String NAME;
    
    /**
     * This is Customer's Mobile
     */
    private final String MOBILE;
    
    /**
     * This is Customer's Age
     */
    private final int AGE;
    
    /**
     * This is Customer's Email
     */
    private final String EMAIL;
    
    /**
     * This is a boolean variable indicating if a Customer is a Senior Citizen
     */
    private final boolean IS_SENIOR_CITIZEN;
    
    /**
     * This is a boolean variable indicating if a Customer is a Student
     */
    private final boolean IS_STUDENT;
    
    /**
     * Creates a Customer object with the given parameters
     * @param name  This is the Name of the Customer.
     * @param age   This is the Age of the Customer.
     * @param mobile   This is the Mobile Number of the Customer.
     * @param email    This is the Email of the Customer.
     * @param isSeniorCitizen   This indicates if a customer is Senior Citizen.
     * @param isStudent   This indicates if a customer is Senior Citizen.
     */

    public Customer(String name,int age, String mobile, String email, boolean isSeniorCitizen, boolean isStudent) {
        this.EMAIL = email;
        this.AGE = age;
        this.NAME = name;
        this.MOBILE = mobile;
        this.IS_SENIOR_CITIZEN = isSeniorCitizen;
        this.IS_STUDENT = isStudent;
    }

    /**
     * Gets the boolean variable indicating if a Customer is Senior Citizen
     * @return variable indicating if customer is Senior Citizen
     */
    public boolean isSeniorCitizen() {
        return this.IS_SENIOR_CITIZEN;
    }
	
    /**
     * Gets the boolean variable indicating if a Customer is Student
     * @return variable indicating if customer is Student
     */
    public boolean isStudent(){
        return this.IS_STUDENT;
    }
    
    /**
     * Gets the age of Customer
     * @return age of Customer
     */
    public int getAge() {
    	return AGE;
    }
    
    /**
     * Gets the name of Customer
     * @return name of Customer
     */
    public String getName() {
        return NAME;
    }

    /**
     * Gets the mobile of Customer
     * @return mobile of Customer
     */
    public String getMobile() {
        return MOBILE;
    }

    /**
     * Gets the email of Customer
     * @return email of Customer
     */
    public String getEmail() {
        return EMAIL;
    }

    
}
