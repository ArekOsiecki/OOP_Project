import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DiveFrame extends JFrame implements ActionListener {


    JFrame diveFrame;

    JMenuBar guiMenuBar = new JMenuBar();
    JMenu diveMenu = new JMenu("Dive Menu");
    JMenuItem createProfile = new JMenuItem("Create Profile");
    JMenuItem planDive = new JMenuItem("Plan dive");
    JMenuItem showDiveLog = new JMenuItem("Show dive log");
    JMenuItem planAnotherDive = new JMenuItem("Show RDP Table");//declaration of menu, menu bar and items
    JTextArea logArea,RDPArea; //Text areas


    String divePlace, diveDate;
    double diveDepth;
    double diveLength;
    double deviceSize, deviceTanks;
    int deviceFilter;//Attributes for classes
    BreathingDevice device;
    String diverName = Diver.getName();
    int diverAge = Diver.getAge();
    int diverExp = Diver.getExperienceLevel();
    double diverSac = Diver.getSac();





    public static void main(String[] args) {

            new DiveFrame();

    }

        public DiveFrame() {


            Diver diver = new Diver(diverName,diverAge,diverSac,diverExp);

            diveFrame = new JFrame("Create Dive");
            diveFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Setting exit method

            diveMenu.add(createProfile);
            createProfile.addActionListener(this);//adding items to menus and registering listeners

            diveMenu.add(planAnotherDive);
            planAnotherDive.addActionListener(this);

            diveMenu.add(showDiveLog);
            showDiveLog.addActionListener(this);

            guiMenuBar.add(diveMenu);
            diveFrame.setJMenuBar(guiMenuBar);

            diveFrame.setSize(320,640);
            diveFrame.setLocationRelativeTo(null);
            diveFrame.setVisible(true);
            diveFrame.setFocusable(true);//adding menu bar to frame, setting visibility and size


            GridLayout diveFrameLayout = new GridLayout(0, 1);
            diveFrame.setLayout(diveFrameLayout);
            diveFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            JMenu diveGridMenu = new JMenu("Dive Menu");
            diveGridMenu.setVisible(true);

            JTextField divePlaceText = new JTextField(20);//Creating fields for user input and corresponding labels
            divePlaceText.setBorder(BorderFactory.createTitledBorder("Where you plan to dive?"));

            JTextField diveDateText = new JTextField(20);
            diveDateText.setBorder(BorderFactory.createTitledBorder("When you plan to dive?"));

            JTextField diveDepthText = new JTextField(20);
            diveDepthText.setBorder(BorderFactory.createTitledBorder("Enter maximum planned depth in meters"));

            JTextField diveLengthText = new JTextField(20);
            diveLengthText.setBorder(BorderFactory.createTitledBorder("Enter planned length in minutes"));

            String[] choices = {"Regulator and cylinders ","Rebreather (semi - closed circut)"}; //Creating drop down list, setting it to be uneditable by user and retrieving input
            final JComboBox<String> diveDropDown = new JComboBox<>(choices);
            diveDropDown.setBorder(BorderFactory.createTitledBorder("Choose your device"));
            diveDropDown.setVisible(true);
            diveDropDown.setEditable(false);


            JPanel buttonsPanel = new JPanel();
            buttonsPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
            GridLayout buttonsLayout = new GridLayout(0, 2, 25, 0);
            buttonsPanel.setLayout(buttonsLayout);

            JButton confirmButton = new JButton("Confirm");
            JButton cancelButton = new JButton("Cancel");
            diveFrame.setJMenuBar(guiMenuBar);
            buttonsPanel.add(confirmButton);
            buttonsPanel.add(cancelButton);
            diveFrame.add(divePlaceText);
            diveFrame.add(diveDateText);
            diveFrame.add(diveDepthText);
            diveFrame.add(diveLengthText);
            diveFrame.add(diveDropDown);
            diveFrame.add(buttonsPanel);
            //adding components to layout



            //adding menu bar to frame, setting visibility and size
            diveFrame.setLocationRelativeTo(null);
            diveFrame.setVisible(true);
            diveFrame.setSize(320, 640);





            confirmButton.addActionListener(e -> {
                        boolean valid = false;


                        try {
                            while(!valid) {


                                DiveDriver.validateText(divePlaceText.getText());
                                divePlace = divePlaceText.getText();

                                DiveDriver.validateText(diveDateText.getText());
                                diveDate = diveDateText.getText();

                                DiveDriver.validateNumber(diveDepthText.getText());
                                diveDepth = DiveDriver.validateDepth(diveDepthText.getText(),diverExp);

                                DiveDriver.validateNumber(diveLengthText.getText());
                                DiveDriver.validateLength(diveDepthText.getText(),diveLengthText.getText());
                                diveLength = Double.parseDouble(diveLengthText.getText());

                                diveDropDown.addActionListener(e1->{
                                    if(DiveDriver.validateBreathingDevice(diveDropDown.getSelectedIndex(),diverExp) && diveDropDown.getSelectedIndex() == 1) {

                                        JOptionPane.showMessageDialog(null,DiveDriver.rebreatherDive(diveDepth,diveLength,deviceFilter));
                                        device = new Rebreather(deviceTanks,deviceSize,deviceFilter);
                                        JOptionPane.showMessageDialog(null, "device created"+device.toString()+" ", "Success", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    else{
                                        DiveDriver.validateLength(diveDepthText.getText(), diveLengthText.getText());
                                        deviceSize = DiveDriver.airVolume(diveDepth,diveLength,diverSac);
                                        deviceTanks = DiveDriver.tanksNeeded(deviceSize);
                                        device = new BreathingDevice(deviceSize,deviceTanks);
                                        JOptionPane.showMessageDialog(null, device.toString(), "device created", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                });



                                valid = true;

                                JOptionPane.showMessageDialog(diveFrame, "Device created"+device.toString()+" ", "Success", JOptionPane.INFORMATION_MESSAGE);
                                Dive dive = new Dive(divePlace, diveDate, diveDepth, diveLength, diver,device);
                                JOptionPane.showMessageDialog(diveFrame, "Dive created"+dive.toString()+" ", "Success", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } catch (RuntimeException f) {
                            JOptionPane.showMessageDialog(diveFrame, f.getMessage(), "Incorrect input!", JOptionPane.WARNING_MESSAGE);
                        }
                    }
            );

            cancelButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(diveFrame, "Closing dive planner", "Canceled", JOptionPane.WARNING_MESSAGE);
                diveFrame.setVisible(false);//disposing of current frame

            });//adding action listeners to buttons using lambda statements

        }


    public void actionPerformed(ActionEvent actionEvent) {


        if(actionEvent.getSource()==createProfile){

            new ProfileFrame();
            diveFrame.dispose();




        }

        if (actionEvent.getSource() == showDiveLog) {

            new LogFrame();
            diveFrame.dispose();

        }
        if (actionEvent.getSource() == planAnotherDive) {

            new RdpFrame();
            diveFrame.dispose();

        }


    }

}

