package com.example.madad;


public class Model {
    private String imageUrl;
    private String photosList;
    public Model(){

    }
    public Model(String imageUrl){
        this.imageUrl=imageUrl;
    }

    public String getPhotosList() {
        return photosList;
    }

    public void setPhotosList(String photosList) {
        this.photosList = photosList;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
