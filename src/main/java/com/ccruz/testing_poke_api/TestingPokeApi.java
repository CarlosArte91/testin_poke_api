package com.ccruz.testing_poke_api;

import com.ccruz.testing_poke_api.services.PokemonService;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author carlos_cruz
 */
public class TestingPokeApi {
    public static void main(String[] args) throws IOException {
        int menuSelected = -1;
        String[] options = {"1. Show Pokemon", "2. Exit"};
        String option = "";
        
        do {
            option = (String) JOptionPane.showInputDialog(
                    null,
                    "Pokemon",
                    "Main menu",
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            
            for (int i = 0; i < options.length; i++) {
                if (option.equals(options[i])) {
                    menuSelected = i;
                }
            }
            
            switch (menuSelected) {
                case 0:
                    PokemonService.showPokemon();
                    break;
                default:
                    break;
            }
        } while (menuSelected != 1);
    }
}
