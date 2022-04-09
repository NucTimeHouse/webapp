package cn.episooo.service;

import cn.episooo.vo.PhotoVO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface PhotoService {
    public boolean savePhoto(String path, String filename, int uid,int aid, MultipartFile upload);
    public List<PhotoVO> getPhoto(int id, int aid,int deleted);
    public boolean deletePhoto(int uid ,int id);
    @Transactional
    public boolean recoverPhoto(int uid ,int id);

    @Transactional
    boolean deletePhotoAbsolutly(int uid, int id, String path);



}
