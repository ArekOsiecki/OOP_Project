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

public class DivingGUI { //This contains global references, buttons and text fields creation code

        JButton createProfileButton = new JButton("Create Profile");
        JButton planDiveButton = new JButton("Plan Dive");
        JButton showRdpButton = new JButton("Show RDP");
        JButton showLogButton = new JButton ("Show dive log");
        JButton confirmButton = new JButton("Confirm");
        JButton cancelButton = new JButton("Cancel");
        JButton okButton = new JButton("OK");
        JButton eraseButton = new JButton("Erase");//Buttons for GUI
        JTextArea logArea,RDPArea; //Text areas
        String divePlace, diveDate, diverName;
        int diverAge,diverSac,diverExp,diveDepth,diveLength,deviceTanks,deviceSize,deviceFilter;
        boolean isReabreather; //Attributes for classes


    public DivingGUI() { //Code for GUI creation and event handler registration

        JFrame guiFrame = new JFrame("Dive Planner");
        GridLayout guiFlow = new GridLayout(); //Creating a grid layout to contain buttons in two rows
        guiFrame.setLayout(guiFlow);
        guiFrame.setSize(500,500);
        guiFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Setting exit method

        guiFrame.add(createProfileButton);
        guiFrame.add(planDiveButton);
        guiFrame.add(showRdpButton);
        guiFrame.add(showLogButton); //Adding buttons to grid

        EventHandler menuButton = new EventHandler();
        createProfileButton.addActionListener(menuButton);
        planDiveButton.addActionListener(menuButton);
        showRdpButton.addActionListener(menuButton);
        showLogButton.addActionListener(menuButton);//Registering listeners

        EventHandler profileButton = new EventHandler();
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
        okButton.addActionListener(rdpButton);//listeners for rdp log frame





    }

    public static void main(String args[]){

        DivingGUI divingApp= new DivingGUI(); //GUI instantiation

    }

    public class EventHandler implements ActionListener {

        public void actionPerformed(ActionEvent click){ //This part of the program contains methods to handle clicked button events

            if(click.getSource()==createProfileButton){//Method to create diver's profile

                JLabel nameLabel = new JLabel("Enter name: ");
                nameLabel.setVisible(true);
                JTextField nameText = new JTextField(20);
                diverName = nameText.getText();

                JLabel ageLabel = new JLabel("Enter age: ");
                ageLabel.setVisible(true);
                JTextField ageText = new JTextField(20);
                diverAge = Integer.parseInt(ageText.getText());

                JLabel sacLabel = new JLabel("Enter SAC: ");
                sacLabel.setVisible(true);
                JTextField sacText = new JTextField(20);
                diverSac = Integer.parseInt(sacText.getText());//Creating fields for user input and corresponding labels and retrieving input

                JLabel experienceLabel = new JLabel("Which certificate do you have?: ");
                experienceLabel.setVisible(true);
                String [] choices = {"Open Water Diver","Advanced Diver","Divemaster"};
                final JComboBox<String> profileDropDown = new JComboBox<>(choices);
                profileDropDown.setVisible(true);
                diverExp = profileDropDown.getSelectedIndex();// Creating dropdown list of choices and retrieving input

                JFrame profileFrame = new JFrame("Create profile");
                GroupLayout profileFlow = new GroupLayout(profileFrame);//Using group layout to combine text boxes and drop down list
                profileFrame.setLayout(profileFlow);
                profileFlow.setAutoCreateContainerGaps(true); //Method to create gaps between components and edges of the frame
                profileFlow.setAutoCreateGaps(true); //Method to create gaps between components
                profileFrame.setSize(400,400);
                profileFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                GroupLayout.SequentialGroup profileBoxesLabels =  profileFlow.createSequentialGroup();//creating a sequential group to align components
                profileBoxesLabels.addGroup(profileFlow.createParallelGroup().addComponent(nameLabel)
                        .addComponent(ageLabel).addComponent(sacLabel).addComponent(experienceLabel));
                profileBoxesLabels.addGroup(profileFlow.createParallelGroup().addComponent(nameText)
                        .addComponent(ageText).addComponent(sacText).addComponent(profileDropDown));//Adding components in parallel groups along horizontal axis
                profileFlow.setHorizontalGroup(profileBoxesLabels);

                GroupLayout.SequentialGroup profileButtons  = profileFlow.createSequentialGroup();//creating a sequential group to align buttons vertically at the bottom of the frame
                profileButtons.addGroup(profileFlow.createSequentialGroup().addComponent(confirmButton).addComponent(cancelButton));
                profileFlow.setVerticalGroup(profileButtons);



                 }
            if(click.getSource()==planDiveButton){//Method to create dive
                 }
            if(click.getSource()==showRdpButton){//Method to show RDP table
            }
            if(click.getSource()==showLogButton){//Method to show dive log
            }



        }

    }



}
