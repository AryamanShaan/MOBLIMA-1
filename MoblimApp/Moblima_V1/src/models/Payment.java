package models;
import java.util.*;


public class Payment{

   
    private Date date;
    //private String transactionId;
    private double amount;
	
	
	private boolean paymentStatus;
    
     // Creates a payment that is to be paid for with a given amount and a given transaction code.
     // A payment is pending when it is initially created.
     
    public Payment(double amount, String transactionCode) {
        this.amount = amount;
        this.date = new Date();
        
		//transaction id initializer
    }

    
    public boolean getPaymentStatus() {
        return paymentStatus;
    }

    // Not sure if we need to implement this 
    // Changes the status of this payment.
     
    //   	public void setStatus(PaymentStatus status) {
    //    		this.status = status;
    //	}

    public double getAmount() {
        return amount;
    }
	
	public Date getDate() {
        return date;
    }

    
    public void setDate(Date date) {
        this.date = date;
    }

	//Not sure if we need to implement this
    //Amount is set to a new value
    public void setAmount(double amount) {
        this.amount = amount;
    }


	
	
	
	/*if (movietype == "3D")
	{
		if (agegroup == "Senior Citizen")
		{
			NA
		}
		else if (agegroup == "Student") // not public holiday
		{
			if(mon-fri, before 6)
			{
				amount = 9;
			}
		else
			{
				if(mon-thurs)
				{
					amount = 11;
				}
				else
				{
					amount= 15;
				}
			}
		}
	}
	else
	{
		if (agegroup == "Senior Citizen")
		{
			if(mon-fri,before 6)
			{
				amount = 4;
			}
		}
		else if (agegroup == "Student") //not public holiday
		{
			if(mon-fri, before 6)
			{
				amount = 7;
			}
		}
		else
		{
			if(mon-wed)
			{
				amount = 8.5;
			}
			else if(thur or fri,before 6)
			{
				amount = 9.5;
			}
			else
			{
				amount = 11;
			}
			
		}
	}
		
		
	if (movie is blockbuster)
	{
		amount = amount+1;
	}
	
	*/
}

