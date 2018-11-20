import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.IllegalFormatException;

public class ProfileFrame extends DivingGUI{


    public static void main(String[] args) {

        String diverName,diverAgeText,diverSacText;
        int diverAge,diverSac,diverExp;


        JFrame profileFrame = new JFrame("Create Profile");
        GridLayout profileFrameLayout = new GridLayout(0,1);
        profileFrame.setLayout(profileFrameLayout);
        profileFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JMenu profileGridMenu = new JMenu("Profile Menu");
        profileGridMenu.setVisible(true);


        JTextField nameText = new JTextField(20);
        nameText.setBorder(BorderFactory.createTitledBorder("Enter name"));
        diverName = nameText.getText();
        boolean validName=false;

        while(!validName){


            try{

                String[] fullName = nameText.getText().split(" ");
                String name = fullName[0];
                String surname = fullName[1];

                for(int i = 0;i<fullName.length;i++){
                    if(!Character.isLetter(name.charAt(i)) || !Character.isLetter(surname.charAt(i))) {
                        throw new IllegalArgumentException("Name must contain only letters!");


                    }
                }

                validName = true;
            }catch (IllegalFormatException e){
                JOptionPane.showMessageDialog(null," "+diverName+" is invalid\nPlease enter only letters!");

            }

        }

        JTextField ageText = new JTextField(20);
        ageText.setBorder(BorderFactory.createTitledBorder("Enter age"));
        diverAgeText = ageText.getText();
        diverAge = Integer.parseInt(diverAgeText);

        JTextField sacText = new JTextField(20);
        sacText.setBorder(BorderFactory.createTitledBorder("Enter SAC"));
        diverSacText = sacText.getText();
        diverSac = Integer.parseInt(diverSacText);//Creating fields for user input and corresponding labels, assigning attributes to input

        String [] choices = {"Open Water Diver","Advanced Diver","Divemaster"};
        final JComboBox<String> profileDropDown = new JComboBox<>(choices);
        profileDropDown.setBorder(BorderFactory.createTitledBorder("Experience level"));
        profileDropDown.setVisible(true);
        profileDropDown.setEditable(false);
        diverExp = profileDropDown.getSelectedIndex();//Creating drop down list, setting it to be uneditable by user and retrieving input


        //add exceptions to methods, change buttons and textbox layout
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBorder(new EmptyBorder(15,15,15,15));
        GridLayout buttonsLayout = new GridLayout(0,2,25,0);
        buttonsPanel.setLayout(buttonsLayout);

        JButton confirmButton = new JButton("Confirm");
        JButton cancelButton = new JButton("Cancel");


        confirmButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Profile created","Success",JOptionPane.INFORMATION_MESSAGE);
            Diver profile = new Diver (diverName,diverAge,diverSac,diverExp);
        });

        cancelButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Profile creation canceled","Canceled",JOptionPane.WARNING_MESSAGE);
            //profileFrame.setVisible(false);//disposing of current frame
            //profileFrame.setDefaultCloseOperation((actionPerformed((int)e.getSource() ==cancelButton);

        });//adding action listeners to buttons using lambda statements

        buttonsPanel.add(confirmButton);
        buttonsPanel.add(cancelButton);

        profileFrame.add(nameText);
        profileFrame.add(ageText);
        profileFrame.add(sacText);
        profileFrame.add(profileDropDown);
        profileFrame.add(buttonsPanel);//adding components to layout


        profileFrame.setLocationRelativeTo(null);
        //how to make every frame appear exactly in the middle of the screen?
        profileFrame.setVisible(true);
        profileFrame.setSize(320,640);//adding menu bar to frame, setting visibility and size
    }
}
