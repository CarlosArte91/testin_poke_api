package com.ccruz.testing_poke_api.services;

import com.ccruz.testing_poke_api.Pokemon;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/**
 *
 * @author carlos_cruz
 */
public class PokemonService {
    public static ArrayList<Pokemon> favorites = new ArrayList<>();
    
    public static void showPokemon() throws IOException {
        int id = generateId();
        Pokemon pokemon = getPokemon(id);
        ImageIcon imageToShow = getImage(pokemon);

        String labelOptions = "Menu\n1. Show other Pokemon\n2. Save as favorite\n3. Back";
        String[] buttons = {"Show other Pokemon", "Save as favorite", "Back"};
        String title = "ID: " + pokemon.getId() + "\tName: " + pokemon.getName().toUpperCase();
        String options = (String) JOptionPane.showInputDialog(null, labelOptions, title, JOptionPane.INFORMATION_MESSAGE, imageToShow, buttons, buttons[0]);
        
        int selected = -1;
        for (int i = 0; i < buttons.length; i++) {
            if (options.equals(buttons[i])) {
                selected = i;
            }
        }
        
        switch (selected) {
            case 0:
                showPokemon();
                break;
            case 1:
                putInFavorites(pokemon);
                break;
            default:
                break;
        }
    }
    
    private static int generateId() {
        Random random = new Random();
        return random.nextInt(200) + 1;
    }
    
    private static Pokemon getPokemon(int pokemonId) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://pokeapi.co/api/v2/pokemon/" + pokemonId).get().build();
        Response response = client.newCall(request).execute();        
        String json = response.body().string();
                
        JSONObject allResponse = new JSONObject(json);
        JSONObject sprites = allResponse.getJSONObject("sprites");
        JSONObject other = sprites.getJSONObject("other");
        JSONObject home = other.getJSONObject("home");
        
        int id = allResponse.getInt("id");
        String name = allResponse.getString("name");
        String image = home.getString("front_default");
        
        return new Pokemon(id, name, image);
    }
    
    private static ImageIcon getImage(Pokemon pokemon) {
        Image imageURL = null;
        ImageIcon pokeImage = null;
        try {
            URL url = new URL(pokemon.getImage());
            imageURL = ImageIO.read(url);
            pokeImage = new ImageIcon(imageURL);
            
            if (pokeImage.getIconWidth() > 800) {
                Image current = pokeImage.getImage();
                Image updated = current.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
                pokeImage = new ImageIcon(updated);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return pokeImage;
    }
    
    private static void putInFavorites(Pokemon pokemon) {
        favorites.add(pokemon);
    }
}
