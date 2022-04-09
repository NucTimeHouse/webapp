package cn.episooo.vo;

import cn.episooo.po.Photo;

import java.util.ArrayList;


public class PhotoVO {
    private String  day ;
    private ArrayList<Photo> photos;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public ArrayList<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<Photo> photos) {
        this.photos = photos;
    }
}
