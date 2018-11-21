import javax.swing.*;
import java.util.IllegalFormatException;

public class profileMethods {

    public static diverName nameValidation(nameText) throws IllegalArgumentException{
        int spaceIndex = nameText.indexOf(' ');
        String name = nameText.getText().substring(0, spaceIndex);
        String surname = nameText.getText().substring(spaceIndex + 1);
        boolean validName=false;

        while (!validName){

            try {
                for (int i = 0; i <= name.length() - 1; i++) {

                    if (!Character.isLetter(name.charAt(i))) {


                    } else {
                        for (int j = 0; j <= surname.length(); j++) {

                            if (!Character.isLetter(surname.charAt(j))) {
                                throw new IllegalArgumentException("Surname must contain only letters!");
                            } else {

                            }
                        }
                    }

                }
            }
            catch{}


    }
}





            /* {

            try {


                }

                validName = true;
            } catch (IllegalFormatException e) {
                JOptionPane.showMessageDialog(null, " " + diverName + " is invalid\nPlease enter only letters!");

            }

        }
    }
}
