package htht.system.ocean.system.back.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import htht.system.ocean.system.back.service.UploadFileService;

@Service
public class UploadFileServiceImpl implements UploadFileService {
    @Override
    public String uploadIcon(MultipartFile file, String userId, HttpServletRequest req) throws IOException {
        return null;
    }
//    @Override
//    public String uploadIcon(MultipartFile file, String userId, HttpServletRequest req) throws IOException {
//        String fileId = MD5Util.getMultipartFileMD5(file);
//        String path = req.getSession().getServletContext().getRealPath(userIconPath);
//        String filename = file.getOriginalFilename();
//        int index = filename.lastIndexOf(".");
//
//        if (index < 0) {
//            return MyConstants.FILE_TYPE_NOT_FOUND;
//        }
//
//        String filetype = filename.substring(index + 1).toLowerCase();
//
//        List<String> imageTypes = Arrays.asList(MyConstants.IMAGE_TYPE);
//        if (!imageTypes.contains(filetype)){
//            return MyConstants.MEDIA_TYPE_NOT_SUPPORT;
//        }
//        String newFilename = fileId + "." + filetype;
//
//        File target = new File(path, newFilename);
//        if (!target.exists()) {
//            target.mkdirs();
//        }
//
//        file.transferTo(target);
//        UserInfo userInfo = new UserInfo();
//        String icon = userIconPath + fileId + "." + filetype;
//        userInfo.setIcon(icon);
//        userInfo.setUserId(userId);
//        int update = mUserInfoMapper.updateIcon(userInfo);
//        if (update>0) {
//            return icon;
//        }else {
//            return "保存用户头像失败";
//        }
//    }
}
