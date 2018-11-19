/*This program is a simple diving calculator/logbook. It allows user to create and update profile and enter data about a planned dive.
* Program also contains features allowing to calculate amount of air needed for the dive,
 * alerts about maximum dive time and surface interval for absolute safe second dive
 * and nitrox composition if using rebreathing open-circut device.
 * Recreational diving table is included and viewable for more precise planning.
  * Program also creates the dive log that can be viewed.*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

public class DivingGUI implements ActionListener{ //This contains global references, buttons and text fields creation code

        JButton createProfileButton = new JButton("Create Profile");
        JButton planDiveButton = new JButton("Plan Dive");
        JButton showRdpButton = new JButton("Show RDP");
        JButton showLogButton = new JButton ("Show dive log");
        JButton confirmButton = new JButton("Confirm");
        JButton cancelButton = new JButton("Cancel");
        JButton okButton = new JButton("OK");
        JButton eraseButton = new JButton("Erase");//Buttons for GUI
        JMenuBar guiMenuBar = new JMenuBar();
        JMenu profileMenu = new JMenu("Profile");
        JMenu diveMenu = new JMenu("Dive Menu");
        JMenu rdpMenu = new JMenu("Check Deco Table");
        JMenuItem createProfile = new JMenuItem("Create Profile");
        JMenuItem updateProfile = new JMenuItem("Update Profile");
        JMenuItem planDive = new JMenuItem("Plan dive");
        JMenuItem showDiveLog = new JMenuItem("Show dive log");
        JMenuItem showRDP = new JMenuItem("Show RDP Table");//declaration of menu, menu bar and items
        JTextArea logArea,RDPArea; //Text areas
        String divePlace, diveDate, diverName,diverAgeText,diverSacText;
        int diverAge,diverSac,diverExp,diveDepth,diveLength,deviceTanks,deviceSize,deviceFilter;
        boolean isReabreather; //Attributes for classes


    public DivingGUI() { //Code for GUI creation and event handler registration

        JFrame guiFrame = new JFrame("Dive Planner");
        guiFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Setting exit method

        profileMenu.add(createProfile);
        createProfile.addActionListener(this);//adding items to menus and registering listeners

        profileMenu.add(updateProfile);
        updateProfile.addActionListener(this);

        diveMenu.add(planDive);
        planDive.addActionListener(this);

        diveMenu.add(showDiveLog);
        showDiveLog.addActionListener(this);

        rdpMenu.add(showRDP);
        showRDP.addActionListener(this);

        guiMenuBar.add(profileMenu);
        guiMenuBar.add(diveMenu);
        guiMenuBar.add(rdpMenu);//adding menus to bar



        guiFrame.setJMenuBar(guiMenuBar);
        guiFrame.setVisible(true);
        guiFrame.setSize(500,500);//adding menu bar to frame, setting visibility and size



        /*EventHandler profileButton = new EventHandler();
        confirmButton.addActionListener(profileButton);
        cancelButton.addActionListener(profileButton); //listeners for profile frame

        EventHandler diveButton = new EventHandler();
        confirmButton.addActionListener(diveButton);
        cancelButton.addActionListener(diveButton);//listeners for dive frame

        EventHandler breathingDeviceButton = new EventHandler();
        confirmButton.addActionListener(breathingDeviceButton);
        cancelButton.addActionListener(breathingDeviceButton);//listeners for classic breathing device frame

        EventHandler rebreatherButton = new EventHandler();
        confirmButton.addActionListener(rebreatherButton);
        cancelButton.addActionListener(rebreatherButton);//listeners for rebreather frame

        EventHandler logButton = new EventHandler();
        okButton.addActionListener(logButton);//listeners for dive log frame

        EventHandler rdpButton = new EventHandler();
        okButton.addActionListener(rdpButton);//listeners for rdp log frame*/





    }


    public static void main(String args[]){

        DivingGUI divingApp= new DivingGUI(); //GUI instantiation

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getSource()==createProfile){

            JMenu profileGridMenu = new JMenu("Profile Menu");
            profileGridMenu.setVisible(true);

            JLabel nameLabel = new JLabel("Enter name: ");
            nameLabel.setVisible(true);
            JTextField nameText = new JTextField(20);
            diverName = nameText.getText();

            JLabel ageLabel = new JLabel("Enter age: ");
            ageLabel.setVisible(true);
            JTextField ageText = new JTextField(20);
            diverAgeText = ageText.getText();

            JLabel sacLabel = new JLabel("Enter SAC: ");
            sacLabel.setVisible(true);
            JTextField sacText = new JTextField(20);
            diverSacText = sacText.getText();//Creating fields for user input and corresponding labels, assigning attributes to input

            JLabel experienceLabel = new JLabel("Which certificate do you have? ");
            experienceLabel.setVisible(true);
            String [] choices = {"Open Water Diver","Advanced Diver","Divemaster"};
            final JComboBox<String> profileDropDown = new JComboBox<>(choices);
            profileDropDown.setVisible(true);
            profileDropDown.setEditable(false);
            diverExp = profileDropDown.getSelectedIndex();// Creating dropdown list of choices and retrieving input


            JFrame profileFrame = new JFrame("Profile");
            GridLayout profileFrameLayout = new GridLayout(0,2);
            profileFrame.setLayout(profileFrameLayout);
            profileFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            profileFrame.add(nameLabel,BorderLayout.WEST);
            profileFrame.add(nameText,BorderLayout.EAST);
            profileFrame.add(ageLabel,BorderLayout.WEST);
            profileFrame.add(ageText,BorderLayout.EAST);
            profileFrame.add(sacLabel,BorderLayout.WEST);
            profileFrame.add(sacText,BorderLayout.EAST);
            profileFrame.add(experienceLabel,BorderLayout.WEST);
            profileFrame.add(profileDropDown,BorderLayout.EAST);
            profileFrame.add(confirmButton,BorderLayout.SOUTH);
            profileFrame.add(cancelButton,BorderLayout.SOUTH); //adding components to layout

            profileFrame.setJMenuBar(guiMenuBar);
            profileFrame.setVisible(true);

            profileFrame.setSize(500,500);//adding menu bar to frame, setting visibility and size



        }
        if(actionEvent.getSource()==updateProfile){

        }
        if(actionEvent.getSource()==planDive){

        }
        if(actionEvent.getSource()==showDiveLog){

        }
        if(actionEvent.getSource()==showRDP){

        }

    }

   /* public class EventHandler implements ActionListener {

        public void actionPerformed(ActionEvent clickMenu){ //This part of the program contains methods to handle main menu clicked button events

            if(clickMenu.getSource()==createProfileButton){//Method to create diver's profile

                JLabel nameLabel = new JLabel("Enter name: ");
                nameLabel.setVisible(true);
                JTextField nameText = new JTextField(20);
                diverName = nameText.getText();

                JLabel ageLabel = new JLabel("Enter age: ");
                ageLabel.setVisible(true);
                JTextField ageText = new JTextField(20);
                diverAgeText = ageText.getText();

                JLabel sacLabel = new JLabel("Enter SAC: ");
                sacLabel.setVisible(true);
                JTextField sacText = new JTextField(20);
                diverSacText = sacText.getText();//Creating fields for user input and corresponding labels, assigning attributes to input

                JLabel experienceLabel = new JLabel("Which certificate do you have?: ");
                experienceLabel.setVisible(true);
                String [] choices = {"Open Water Diver","Advanced Diver","Divemaster"};
                final JComboBox<String> profileDropDown = new JComboBox<>(choices);
                profileDropDown.setVisible(true);
                diverExp = profileDropDown.getSelectedIndex();// Creating dropdown list of choices and retrieving input


                JFrame profileFrame = new JFrame("Create profile");
                profileFrame.setVisible(true);
                GridLayout profileLayout = new GridLayout(3,2);//Using grid layout to combine text boxes, drop down list and buttons
                profileFrame.setLayout(profileLayout);
                profileFrame.setSize(400,400);
                profileFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                profileFrame.add(nameLabel);
                profileFrame.add(nameText);
                profileFrame.add(ageLabel);
                profileFrame.add(ageText);
                profileFrame.add(sacLabel);
                profileFrame.add(sacText);
                profileFrame.add(experienceLabel);
                profileFrame.add(profileDropDown);
                profileFrame.add(confirmButton);
                profileFrame.add(cancelButton); //adding components to layout

            //changing action listener to JOptionPane to add profile?,o,/p

                 }
            if(clickMenu.getSource()==planDiveButton){//Method to create dive
                 }
            if(clickMenu.getSource()==showRdpButton){//Method to show RDP table
            }
            if(clickMenu.getSource()==showLogButton){//Method to show dive log
            }



        }

    }*/



}
