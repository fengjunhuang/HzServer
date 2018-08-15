package htht.system.ocean.system.back.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface UploadFileService {
    String uploadIcon(MultipartFile file, String userId, HttpServletRequest req) throws IOException;
}
