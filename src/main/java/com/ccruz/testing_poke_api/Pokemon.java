package com.ccruz.testing_poke_api;

/**
 *
 * @author carlos_cruz
 */
public class Pokemon {
    private int id;
    private String url;
    private String image;
    
    public Pokemon() {}
    
    public Pokemon(int id, String url, String image) {
        this.id = id;
        this.url = url;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
