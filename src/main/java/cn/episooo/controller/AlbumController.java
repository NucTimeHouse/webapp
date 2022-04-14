package cn.episooo.controller;

import cn.episooo.po.Album;
import cn.episooo.po.User;
import cn.episooo.service.AlbumService;
import cn.episooo.tool.encrypt.TimeEncryptUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/album")
public class AlbumController  {

    @Autowired
    AlbumService albumService;

    @RequestMapping("/getAlbums")
    @ResponseBody
    public ArrayList<Album> getAlbum(HttpSession session){
        User user = (User) session.getAttribute("user");

        return albumService.getAlbums(user.getId());
    }

    @RequestMapping("/addAlbum")
    @ResponseBody
    public boolean addAlbum( String name,HttpSession session) {
        User user = (User) session.getAttribute("user");
        return albumService.addAlbum(user.getId(),name);
    }
    @GetMapping("/share/uri")
    @ResponseBody
    public Map<String,String> shareUrl(@RequestParam(defaultValue = "0") int deleted,
                                       @RequestParam(defaultValue = "-1") int aid,
                                       HttpSession session) throws UnknownHostException {
        try {
            User user = (User) session.getAttribute("user");
            Map<String,String> map = new HashMap<String,String>();
            map.put("uri","http://"+InetAddress.getLocalHost().getHostAddress() + ":8080/share.html" +
                    "?deleted="+deleted+"&aid="+aid+"&userId="+user.getId()+
                    "&token="+ TimeEncryptUntil.timeEncrypt(System.currentTimeMillis()));
            return map;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            throw e;
        }
    };
    @RequestMapping("/deleteAlbum")
    @ResponseBody
    public boolean deleteAlbum(int id,HttpSession session) {
        User user = (User) session.getAttribute("user");
        return albumService.deleteAlbum(user.getId(),id);
    }

    @RequestMapping("/updateAlbum")
    @ResponseBody
    public boolean updateAlbum(String name, int id,HttpSession session) {
        User user = (User) session.getAttribute("user");
        return albumService.updateAlbum(name,user.getId(),id);
    }

}
