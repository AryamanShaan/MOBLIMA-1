package models;

public class Customer {
    private final String NAME;
    private final String MOBILE;
    private final int AGE;
    private final String EMAIL;
    private final boolean IS_SENIOR_CITIZEN;
    private final boolean IS_STUDENT;

    public Customer(String name,int age, String mobile, String email, boolean isSeniorCitizen, boolean isStudent) {
        this.EMAIL = email;
        this.AGE = age;
        this.NAME = name;
        this.MOBILE = mobile;
        this.IS_SENIOR_CITIZEN = isSeniorCitizen;
        this.IS_STUDENT = isStudent;
    }

    
    public boolean isSeniorCitizen() {
        return this.IS_SENIOR_CITIZEN;
    }
	
    public boolean isStudent(){
        return this.IS_STUDENT;
    }
    
    public int getAge() {
    	return AGE;
    }

    public String getName() {
        return NAME;
    }

    
    public String getMobile() {
        return MOBILE;
    }

    
    public String getEmail() {
        return EMAIL;
    }

    
}
