import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.IllegalFormatException;

public class ProfileFrame {

    String divePlace, diveDate,nameU, diverName,diverAgeText,diverSacText;
    int diverAge,diverSac,diverExp,diveDepth,diveLength,deviceTanks,deviceSize,deviceFilter;
    boolean isReabreather; //Attributes for classes
    JMenuBar guiMenuBar = new JMenuBar();



    public static void main(String[] args) {
        new ProfileFrame();
    }


    public ProfileFrame()
    {
        JFrame profileFrame = new JFrame("Create Profile");
        GridLayout profileFrameLayout = new GridLayout(0, 1);
        profileFrame.setLayout(profileFrameLayout);
        profileFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JMenu profileGridMenu = new JMenu("Profile Menu");
        profileGridMenu.setVisible(true);


        JTextField nameText = new JTextField(20);
        nameText.setBorder(BorderFactory.createTitledBorder("Enter name"));
        diverName = nameText.getText();



        JTextField ageText = new JTextField(20);
        ageText.setBorder(BorderFactory.createTitledBorder("Enter age"));
        diverAgeText = ageText.getText();



        JTextField sacText = new JTextField(20);
        sacText.setBorder(BorderFactory.createTitledBorder("Enter SAC"));
        diverSacText = sacText.getText();//Creating fields for user input and corresponding labels, assigning attributes to input


        String[] choices = {"Open Water Diver", "Advanced Diver", "Divemaster"};
        final JComboBox<String> profileDropDown = new JComboBox<>(choices);
        profileDropDown.setBorder(BorderFactory.createTitledBorder("Experience level"));
        profileDropDown.setVisible(true);
        profileDropDown.setEditable(false);
        diverExp = profileDropDown.getSelectedIndex();//Creating drop down list, setting it to be uneditable by user and retrieving input


        //add exceptions to methods
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        GridLayout buttonsLayout = new GridLayout(0, 2, 25, 0);
        buttonsPanel.setLayout(buttonsLayout);

        JButton confirmButton = new JButton("Confirm");
        JButton cancelButton = new JButton("Cancel");
        profileFrame.setJMenuBar(guiMenuBar);
        buttonsPanel.add(confirmButton);
        buttonsPanel.add(cancelButton);
        profileFrame.add(nameText);
        profileFrame.add(ageText);
        profileFrame.add(sacText);
        profileFrame.add(profileDropDown);
        profileFrame.add(buttonsPanel);
        //adding components to layout


        profileFrame.setLocationRelativeTo(null);
        //how to make every frame appear exactly in the middle of the screen? turn off previous frame
        profileFrame.setVisible(true);
        profileFrame.setSize(320, 640);//adding menu bar to frame, setting visibility and size


        confirmButton.addActionListener(e -> {

            boolean valid = false;
            diverSac = Integer.parseInt(diverSacText);


            //do validation now before object creation
           while(!valid)
            {
                for(int i = 0; i<= diverName.length();i++){
                    if(!Character.isLetter(diverName.charAt(i))){
                        throw new IllegalArgumentException("Name must contain only letters!");
                    }
                    else{
                        if(!Character.isDigit(diverAgeText.charAt(i))){
                            throw new IllegalArgumentException("You must use numbers to enter age");
                        }
                        else{
                            diverAge = Integer.parseInt(diverAgeText);
                            if(diverAge < 5 || diverAge > 85){
                                throw new IllegalArgumentException("Please enter correct age");
                            }
                            else{
                                if(!Character.isDigit(diverSacText.charAt(i))){
                                    throw new IllegalArgumentException("You must use numbers to enter SAC");
                            }
                        }
                    }
                }

            }
            Diver profile = new Diver(diverName, diverAge, diverSac, diverExp);

            JOptionPane.showMessageDialog(profileFrame, "Profile created", "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        cancelButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(profileFrame, "Profile creation canceled", "Canceled", JOptionPane.WARNING_MESSAGE);
            profileFrame.setVisible(false);//disposing of current frame

        });//adding action listeners to buttons using lambda statements


    }
}
