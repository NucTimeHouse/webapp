package cn.episooo.service;

import cn.episooo.po.Album;

import java.util.ArrayList;


public interface AlbumService {

    public ArrayList<Album> getAlbums(int uid);

    
    public boolean addAlbum(int uid,String name);


    public boolean deleteAlbum(int uid,int id);


    public boolean updateAlbum(String name,int uid,int id);
}
