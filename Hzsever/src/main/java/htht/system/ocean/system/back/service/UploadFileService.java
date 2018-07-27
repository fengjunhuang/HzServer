package htht.system.ocean.system.back.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public interface UploadFileService {
    String uploadIcon(MultipartFile file, String userId, HttpServletRequest req) throws IOException;
}
