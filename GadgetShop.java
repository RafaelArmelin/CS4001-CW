import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GadgetShop implements ActionListener {

    private JFrame frame;
    private ArrayList<Gadget> gadgets; // Array List to store gadgets

    private JTextField modelField, priceField, weightField, sizeField,
            creditField, memoryField, phoneNumberField, durationField,
            downloadSizeField, displayNumberField;

    private JButton addMobileButton, addMP3Button, clearButton,
            displayAllButton, makeCallButton, downloadMusicButton;
            
    //creating variables for the devices
    private String model;
    private double price;
    private int weight;
    private String size;
    private int credit;
    private int memory;
    private int number;
    private double duration;
    private int downloadSize;

    public GadgetShop() {

        frame = new JFrame("Gadget Shop");
        // Initialise components
        gadgets = new ArrayList<Gadget>();
        
        modelField = new JTextField(15);
        priceField = new JTextField(15);
        weightField = new JTextField(15);
        sizeField = new JTextField(15);
        creditField = new JTextField(15);
        memoryField = new JTextField(15);
        phoneNumberField = new JTextField(15);
        durationField = new JTextField(15);
        downloadSizeField = new JTextField(15);
        displayNumberField = new JTextField(15);

        addMobileButton = new JButton("Add Mobile");
        addMP3Button = new JButton("Add MP3");
        clearButton = new JButton("Clear");
        displayAllButton = new JButton("Display All");
        makeCallButton = new JButton("Make Call");
        downloadMusicButton = new JButton("Download Music");

        // Create layout
        JPanel inputPanel = new JPanel(new GridLayout(10, 2));
        inputPanel.add(new JLabel("Model: "));
        inputPanel.add(modelField);
        inputPanel.add(new JLabel("Price: "));
        inputPanel.add(priceField);
        inputPanel.add(new JLabel("Weight: "));
        inputPanel.add(weightField);
        inputPanel.add(new JLabel("Size: "));
        inputPanel.add(sizeField);
        inputPanel.add(new JLabel("Initial Credit: "));
        inputPanel.add(creditField);
        inputPanel.add(new JLabel("Initial Available Memory: "));
        inputPanel.add(memoryField);
        inputPanel.add(new JLabel("Phone Number: "));
        inputPanel.add(phoneNumberField);
        inputPanel.add(new JLabel("Duration: "));
        inputPanel.add(durationField);
        inputPanel.add(new JLabel("Download Size: "));
        inputPanel.add(downloadSizeField);
        inputPanel.add(new JLabel("Display Number: "));
        inputPanel.add(displayNumberField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addMobileButton);
        buttonPanel.add(addMP3Button);
        buttonPanel.add(clearButton);
        buttonPanel.add(displayAllButton);
        buttonPanel.add(makeCallButton);
        buttonPanel.add(downloadMusicButton);

        frame.getContentPane().add(inputPanel, BorderLayout.CENTER);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Register action listeners for buttons
        addMobileButton.addActionListener(this);
        addMP3Button.addActionListener(this);
        clearButton.addActionListener(this);
        displayAllButton.addActionListener(this);
        makeCallButton.addActionListener(this);
        downloadMusicButton.addActionListener(this);

        frame.pack(); // Adjust frame size to fit components
        frame.setVisible(true); // Make frame visible
    }

    // Methods to get input values from text fields with validation
    private String getModel() {
        return modelField.getText();
    }

    private double getPrice() {
        try{
            return Double.parseDouble(priceField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid price. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            return 0.0; //Default value
        }
    }

    private int getWeight() {
        try{
            return Integer.parseInt(weightField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid weight. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
            return 0; //default value
        }
    }

    private String getInputSize() {
        return sizeField.getText();
    }

    private int getCredit() throws NumberFormatException {
        return Integer.parseInt(creditField.getText());
    }

    private int getMemory() throws NumberFormatException {
        return Integer.parseInt(memoryField.getText());
    }

    private String getPhoneNumber() {
        return phoneNumberField.getText();
    }

    private int getDuration() throws NumberFormatException {
        return Integer.parseInt(durationField.getText());
    }

    private int getDownloadSize() throws NumberFormatException {
        return Integer.parseInt(downloadSizeField.getText());
    }
    
    private int getDisplayNumber() throws NumberFormatException
    {
        int displayNumber = -1;
        try {
            displayNumber = Integer.parseInt(displayNumberField.getText());
            if (displayNumber < 0 || displayNumber >= gadgets.size())
            {
                throw new NumberFormatException("Invalid display number. Please, enter a number between 0 and " + (gadgets.size() - 1));
            }
        } catch (NumberFormatException e)
        {
        JOptionPane.showMessageDialog(frame, "Invalid display number. Please enter an integer.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return displayNumber;
    }
    
    private void addMobile()
    {
        model = getModel();
        price = getPrice();
        weight = getWeight();
        size = getInputSize();
        credit = getCredit();
        Gadget newGadget = new Mobile(model, price, weight, size, credit);
        gadgets.add(newGadget);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
        System.out.println("Weight: " + weight);
        System.out.println("Size: " + size);
        System.out.println("Credit: " + credit);
        JOptionPane.showMessageDialog(frame, "Phone added successfully.", "Add a Phone", JOptionPane.INFORMATION_MESSAGE);

    }
    
    private void addMP3()
    {
        model = getModel();
        price = getPrice();
        weight = getWeight();
        size = getInputSize();
        memory = getMemory();
        Gadget newGadget = new MP3(model, price, weight, size, memory);
        gadgets.add(newGadget);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
        System.out.println("Weight: " + weight);
        System.out.println("Size: " + size);
        System.out.println("Memory: " + memory);
        JOptionPane.showMessageDialog(frame, "MP3 added successfully!", "Add a MP3", JOptionPane.INFORMATION_MESSAGE);

    }
    
    private void clearFields()
    {
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        creditField.setText("");
        memoryField.setText("");
        phoneNumberField.setText("");
        durationField.setText("");
        downloadSizeField.setText("");
        displayNumberField.setText("");
    }
    
    private void displayAllGadgets()
    {
        StringBuilder allGadgetsInfo = new StringBuilder();
        for (Gadget gadget : gadgets)
            {
                allGadgetsInfo.append(gadget.getInfo()).append("\n\n");
            }
        //display gadget information in a dialog box
        JOptionPane.showMessageDialog(frame, allGadgetsInfo.toString(), "All Gadgets Information", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void makeCall()
    {
        int displayNumber;
        try {
            displayNumber = getDisplayNumber();
            if(displayNumber != -1) {
                Gadget gadget = gadgets.get(displayNumber);
                if(gadget instanceof Mobile) {
                Mobile mobile = (Mobile) gadget;
                String phoneNumber = getPhoneNumber();
                int duration = getDuration();
                mobile.makeCall(phoneNumber, duration);
                JOptionPane.showMessageDialog(frame, "Call made successfully!", "Make a Call", JOptionPane.INFORMATION_MESSAGE);
                } else{
                    JOptionPane.showMessageDialog(frame, "Selected gadget is not a mobile phone.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid display number. Please enter an integer.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void downloadMusic()
    {
        int displayNumber;
        try {
            displayNumber = getDisplayNumber();
            if(displayNumber != -1){
            Gadget gadget = gadgets.get(displayNumber);
                if(gadget instanceof MP3){
                    MP3 mp3 = (MP3) gadget;
                    int downloadSize = getDownloadSize();
                    mp3.downloadMusic(downloadSize);
                    JOptionPane.showMessageDialog(frame, "Music successfully downloaded!", "Download Music", JOptionPane.INFORMATION_MESSAGE);
                }else{
                JOptionPane.showMessageDialog(frame, "Selected gadget is not an MP3 player.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(frame, "Invalid display number. Please enter an integer.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    // Get the button that was clicked
    JButton clickedButton = (JButton) e.getSource();

    switch (clickedButton.getText()) {
        case "Add Mobile":
            System.out.println("Add Mobile button clicked!");
            addMobile();
            break;
        case "Add MP3":
            System.out.println("Add MP3 button clicked!");
            addMP3();
            break;
        case "Clear":
            System.out.println("Clear button clicked!");
            clearFields();
            break;
        case "Display All": 
            System.out.println("Display All button clicked!");
            displayAllGadgets();
            break;
        case "Make Call":
            System.out.println("Make Call button clicked!");
            makeCall();
            break;
        case "Download Music":
            System.out.println("Download Music button clicked!");
            downloadMusic();
            break;
        default:
            System.out.println("Unknown button clicked!");
        }
    }
    
    public static void main (String []args)
    {
        GadgetShop GadgetShop = new GadgetShop();
    }
}   