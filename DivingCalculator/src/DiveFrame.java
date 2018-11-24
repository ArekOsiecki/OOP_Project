import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DiveFrame implements ActionListener {

    JFrame diveFrame;

    JMenuBar guiMenuBar = new JMenuBar();
    JMenu diveMenu = new JMenu("Dive Menu");
    JMenuItem createProfile = new JMenuItem("Create Profile");
    JMenuItem planDive = new JMenuItem("Plan dive");
    JMenuItem showDiveLog = new JMenuItem("Show dive log");
    JMenuItem planAnotherDive = new JMenuItem("Show RDP Table");//declaration of menu, menu bar and items
    JTextArea logArea,RDPArea; //Text areas


    String divePlace, diverName, diveDate;
    int diverAge;
    int diverSac;
    int diverExp;
    int diveDepth;
    int diveLength;
    double deviceSize, deviceTanks;
    int deviceFilter;//Attributes for classes





    public static void main(String[] args) {

            new DiveFrame();

    }

        public DiveFrame() {


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


            diveDropDown.addActionListener(e->{
                if(diveDropDown.getSelectedIndex()==1) {
                    Rebreather device = new Rebreather();
                }
                else{
                    BreathingDevice device = new BreathingDevice();
                }
            });



            confirmButton.addActionListener(e -> {
                        boolean valid = false;


                        try {
                            while(!valid) {


                                validateText(divePlaceText.getText());
                                divePlace = divePlaceText.getText();

                                validateText(diveDateText.getText());
                                diveDate = diveDateText.getText();

                                validateNumber(diveDepthText.getText());
                                diveDepth = validateDepth(diveDepthText.getText(),diverExp);

                                validateNumber(diveLengthText.getText());
                                diveLength = Integer.parseInt(diveLengthText.getText());

                                if(validateBreathingDevice(diveDropDown.getSelectedIndex(),diverExp) && diveDropDown.getSelectedIndex() == 1){
                                    JOptionPane.showMessageDialog(null,rebreatherDive(diveDepth,diveLength,deviceFilter));

                                }
                                else{
                                    validateLength(diveDepthText.getText(), diveLengthText.getText());
                                    deviceSize = airVolume(diveDepth,diveLength,diverSac);
                                    deviceTanks = tanksNeeded(deviceSize);

                                }



                                valid = true;

                                Dive dive;
                                Diver diver = new Diver(diverName,diverAge,diverSac,diverExp);
                                BreathingDevice device = new BreathingDevice(deviceTanks,deviceSize);
                                dive = new Dive(divePlace,diveDate,diveDepth,diveLength,diver,device);
                                JOptionPane.showMessageDialog(diveFrame, "Profile created"+dive.toString()+" ", "Success", JOptionPane.INFORMATION_MESSAGE);
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
    public String validateText(String text) throws RuntimeException{ //creating validation methods

        boolean valid = false;
        String textToValidate = text;
        for (char c : textToValidate.toCharArray()) {
            System.out.println("1");
            if (!Character.isLetter(c)){
                throw new RuntimeException("You must use only letters to enter name while you used "+textToValidate+"");

            }
            else{
                valid = true;
            }
        }
        return textToValidate;
    }
    public boolean validateNumber(String number) throws RuntimeException {

        boolean valid = false;
        String numberToValidate = number;
        while (!valid) {
            for (char c : numberToValidate.toCharArray()) {
                System.out.println("2");
                if (!Character.isDigit(c)) {
                    throw new RuntimeException("You must use numbers for input while you used " + numberToValidate + "");

                } else {

                    valid = true;
                }
            }
        }

        return valid;
    }
    public int validateDepth(String depth,int exp) throws RuntimeException {

        boolean valid = false;
        int depthToValidate = Integer.parseInt(depth);
        int validatedDepth;


        if (depthToValidate > 40) {

            validatedDepth = 42;

        } else if (depthToValidate < 40 && depthToValidate > 35) {

            validatedDepth = 40;

        } else if (depthToValidate < 35 && depthToValidate > 30) {

            validatedDepth = 35;

        } else if (depthToValidate < 30 && depthToValidate >=25) {

            validatedDepth = 30;

        } else if (depthToValidate < 25 && depthToValidate > 22) {

            validatedDepth = 25;

        } else if (depthToValidate < 22 && depthToValidate > 20) {

            validatedDepth = 22;

        } else if (depthToValidate < 20 && depthToValidate > 18) {

            validatedDepth = 20;

        } else if (depthToValidate < 18 && depthToValidate > 16) {

            validatedDepth = 18;

        } else if (depthToValidate < 16 && depthToValidate > 14) {

            validatedDepth = 16;

        } else if (depthToValidate < 14 && depthToValidate > 12) {

            validatedDepth = 14;

        } else if (depthToValidate < 12 && depthToValidate > 10) {

            validatedDepth = 12;

        } else {
            validatedDepth = 10;
        }

        if (validatedDepth > 18 && exp<= 1) {
            System.out.println("3");
            throw new RuntimeException("You need to hold Advanced Certificate to dive below 13 meters deep!");
        } else if (validatedDepth > 30 && exp<= 2) {
            throw new RuntimeException("You need to be a Divemaster to dive below 30 meters deep!");
        }
        if (validatedDepth == 42) {
            throw new RuntimeException("You should never dive that deep!");
        } else {
            return validatedDepth;
        }
    }
    public boolean validateLength(String depth,String length) throws RuntimeException{

        boolean valid;
        int depthToValidate = Integer.parseInt(depth);
        int lengthToValidate = Integer.parseInt(length);
        if(depthToValidate == 42 && lengthToValidate < 7 || depthToValidate <= 40 && lengthToValidate < 8 ||
                depthToValidate <= 35 && lengthToValidate < 13 || depthToValidate <= 30 && lengthToValidate < 19 ||
                depthToValidate <= 25 && lengthToValidate < 28 || depthToValidate <= 22 && lengthToValidate < 36 ||
                depthToValidate <= 20 && lengthToValidate < 45 || depthToValidate == 18 && lengthToValidate < 55 ||
                depthToValidate == 16 && lengthToValidate < 71 || depthToValidate == 14 && lengthToValidate < 97 ||
                depthToValidate == 12 && lengthToValidate < 146
                || depthToValidate == 10 && lengthToValidate < 217  ) {
            System.out.println("4");
            throw new RuntimeException("That dive will require decompression! Do not plan recreational dives in this range!");
        }else{
            valid = true;
        }

        return valid;
    }
    public boolean validateBreathingDevice(int device, int exp) throws RuntimeException{

        boolean valid;

        if(device == 1 && exp<=1){
            throw new RuntimeException("You need to hold Advanced Certificate in order to use Rebreather!!");

        }else{
            valid = true;
        }
        return valid;

    }

    public String rebreatherDive (int depth, int length, int filter) throws RuntimeException{


        double nitroxCalc = ((depth/10)+1)*1.4;
        String nitroxTimeDepth;

        if (filter>length){

            throw new RuntimeException("You have entered "+length+" , while your filter have capacity of "+filter+" in minutes!");

        }else {
            nitroxTimeDepth = "For your planned maximum depth your breathing mixture should contain " + nitroxCalc + "% nitrox" +
                    "\n You can dive up to 3 hours" +
                    "\n You can dive again after completing post-dive and pre-dive procedures on surface";
        }
        return nitroxTimeDepth;
    }

    public double airVolume (int depth,int length, int sac) {

        return  (((depth/10)+1)*sac* length);

    }

    public double tanksNeeded (double size){

        return Math.round((((size/14)/10)+5)*10);

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

