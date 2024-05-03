public class Mobile extends Gadget
{
    // instance variables
    private int callingCredit;

    /**
     * Constructor for objects of class Mobile
     */
    public Mobile(String model, double price, int weight, String size, int callingCredit)
    {
        // initialise instance variables
        super(model, price, weight, size); // Call Gadget class constructor
        this.callingCredit = callingCredit;
    }

    public void addCredit(int additionalCredit)
    {
        if(additionalCredit > 0)
        {
            this.callingCredit += additionalCredit;
            System.out.println("Successfully added " + additionalCredit + "mins of credit.");
        } else{
            System.out.println("Please enter a positive amount of credit");
        }
    }
    
    public void makeCall(String phoneNumber, int duration)
    {
        if(callingCredit >=duration)
        {
            callingCredit -= duration;
            System.out.println("Call made to " + phoneNumber + "for " + duration + "minutes. Remaining credit is: " + callingCredit + "minutes.");
        } else{
            System.out.println("Insuficient credits to make a call. Please add credit.");
        }
    }
    
    @Override
    public String getInfo()
    {
        return super.getInfo() + "\nCalling credit: " + callingCredit + " minutes.";
    }
}

