package htht.system.ocean.conpany.project;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootStarterSecurityDemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    /**
     * 在每次测试执行前构建mvc环境
     */
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    /**
     * 测试上传文件
     */
    @Test
    public void whenUploadFileSuccess() {
        try {
         final Logger logger = LoggerFactory.getLogger(this.getClass());
            logger.debug("This is a debug message");
            logger.info("This is an info message");
            logger.warn("This is a warn message");
            logger.error("This is an error message");
            String result =  mockMvc.perform(
                    MockMvcRequestBuilders
                            .fileUpload("/upload/imge")
                            .file(
                                    new MockMultipartFile("file", "test.txt", ",multipart/form-data", "hello upload".getBytes("UTF-8"))
                            )
            ).andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn().getResponse().getContentAsString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MockMultipartFile createImg(String url){
        try {
            // File转换成MutipartFile  File file = new File("F:\\test.jpg");
            File file = new File(url);
            FileInputStream inputStream = new FileInputStream(file);
            MockMultipartFile multipartFile = new MockMultipartFile(file.getName(), inputStream);
            //注意这里面填啥，MultipartFile里面对应的参数就有啥，比如我只填了name，则
            //MultipartFile.getName()只能拿到name参数，但是originalFilename是空。
            return multipartFile;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}