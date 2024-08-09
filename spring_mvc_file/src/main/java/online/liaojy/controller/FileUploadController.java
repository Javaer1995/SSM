package online.liaojy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author liaojy
 * @date 2023/11/5 - 18:06
 */
@Controller
public class FileUploadController {

    @RequestMapping("/test/up")
    public String testUp(MultipartFile photo, HttpSession session) throws IOException {
        // 获取上传的文件的文件名
        String originalFilename = photo.getOriginalFilename();

        // 获取上传的文件的后缀名
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 使用uuid生成的字符串和上传文件的后缀名，拼接成一个新的文件名
        String fileName = UUID.randomUUID().toString() + suffixName;

        // 获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        // 获取服务器中当前工程下photo目录的真实路径
        String photoPath = servletContext.getRealPath("photo");
        // 创建photoPath所对应的file对象
        File file = new File(photoPath);
        // 判断file所对应目录是否存在
        if (!file.exists()){
            // file所对应目录不存在，则创建该目录
            file.mkdir();
        }
        // 拼接目录路径和文件名为最终路径
        //String finalPath = photoPath + File.separator + originalFilename;

        // 拼接目录路径和新的文件名为最终路径
        String finalPath = photoPath + File.separator + fileName;

        // 上传文件
        photo.transferTo(new File(finalPath));
        return "success";
    }

}
