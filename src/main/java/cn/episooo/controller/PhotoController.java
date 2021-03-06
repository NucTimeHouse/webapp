package cn.episooo.controller;

import cn.episooo.po.User;
import cn.episooo.service.PhotoService;
import cn.episooo.tool.encrypt.TimeEncryptUntil;
import cn.episooo.vo.PhotoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @RequestMapping("deletePhoto")
    @ResponseBody
    public boolean deletePhoto(int id,HttpSession session){
        User user = (User) session.getAttribute("user");
        return photoService.deletePhoto(user.getId(),id);
    }

    @RequestMapping("/upload")
    @ResponseBody
    public Map<String, Object> upload(int aid, MultipartFile upload,HttpServletRequest request, HttpSession session) throws IOException {
        //使用fileupload组件完成上传
        Map<String, Object> map = new HashMap<>();

        User user = (User) session.getAttribute("user");
        String projetPath = request.getSession().getServletContext().getRealPath("/");
        System.out.println(projetPath);

        String filename = upload.getOriginalFilename();
        if(photoService.savePhoto(projetPath, filename, user.getId(),aid, upload)) {
            map.put("code", 1);
            map.put("msg", "上传成功！");
        }

        return map;
    }
    /*
     * @Description :
     * @param ： id 
     * @Return : java.util.List<cn.episooo.vo.PhotoVO>
     */
    @RequestMapping("/getPhotos")
    @ResponseBody
    public List<PhotoVO> getPhotos(@RequestParam(defaultValue = "0") int deleted,
                                   @RequestParam(defaultValue = "-1") int aid,HttpSession session){
        User user = (User) session.getAttribute("user");
        return photoService.getPhoto(user.getId(),aid,deleted);
    }

    @GetMapping("/share/photos")
    @ResponseBody
    public List<PhotoVO> getSharePhotos(@RequestParam(defaultValue = "0") int deleted,
                                        @RequestParam(defaultValue = "-1") int aid,
                                        @RequestParam(defaultValue = "-1") int userId,
                                        @RequestParam(defaultValue = "token") String token){
        if( System.currentTimeMillis() - TimeEncryptUntil.timeDecrypt(token) < 1000*60*60*24*7){
            return photoService.getPhoto(userId,aid,deleted);
        }
        throw new RuntimeException("token过期");
    }
    @RequestMapping("/recoverPhoto")
    @ResponseBody
    public boolean recoverPhoto(@RequestParam int id,HttpSession session){
        User user = (User) session.getAttribute("user");
        return photoService.recoverPhoto(user.getId(),id);
    }


    @RequestMapping("/deletePhotoAbsolutly")
    @ResponseBody
    public boolean deletePhotoAbsolutly(@RequestParam int id, HttpSession session){
        User user = (User) session.getAttribute("user");
        return photoService.deletePhotoAbsolutly(user.getId(),id,session.getServletContext().getRealPath("/"));
    }

}
