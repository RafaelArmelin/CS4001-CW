import javax.swing.JOptionPane;

public class MP3 extends Gadget
{
    // instance variables 
    private int availableMemory;

    //Constructor for objects of class MP3
    public MP3(String model, double price, int weight, String size, int availableMemory)
    {
        // initialise instance variables
        super(model, price, weight, size); //Call Gadget class constructor
        this.availableMemory = availableMemory;
    }

    public void downloadMusic(int musicMemory)
    {
        System.out.println("available memory: "+ availableMemory);
        System.out.println("music memory --> " + musicMemory);
        if(availableMemory >= musicMemory)
        {
            availableMemory -= musicMemory;
            System.out.println("Music downloaded successfully. Available memory is: " + availableMemory + " units.");
        } else{
            JOptionPane.showMessageDialog(null, "Insuficient memory to download music.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteMusic(int musicMemory)
    {
        availableMemory += musicMemory;
        System.out.println("Music deleted successfully. Available memory is: " + availableMemory + " units.");
    }
    
    @Override
    public String getInfo()
    {
        return super.getInfo() + "\nAvailable memory: " + availableMemory + " units.";
    }
}
