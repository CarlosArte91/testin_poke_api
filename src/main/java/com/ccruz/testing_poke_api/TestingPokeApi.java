package com.ccruz.testing_poke_api;

import javax.swing.JOptionPane;

/**
 *
 * @author carlos_cruz
 */
public class TestingPokeApi {
    public static void main(String[] args) {
        int menuSelected = -1;
        String[] options = {"1. Show Pokemon", "2. Exit"};
        
        do {
            String option = (String) JOptionPane.showInputDialog(
                    null,
                    "Pokemon",
                    "Main menu",
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            
            for (int i = 0; i < options.length; i++) {
                if (option == options[i]) {
                    menuSelected = i;
                }
            }
            
            switch (menuSelected) {
                case 0:
                    break;
                default:
                    break;
            }
        } while (menuSelected != 1);
    }
}
