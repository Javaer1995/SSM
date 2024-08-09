package online.liaojy.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.*;

/**
 * @author liaojy
 * @date 2023/11/2 - 20:50
 */
@Controller
public class FileDownloadController {

    // ResponseEntity 可以作为控制器方法的返回值，表示响应到浏览器的完整响应报文（包含响应体、响应体和响应状态码）
    @RequestMapping("/test/down")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中工程的真实路径
        String realPath = servletContext.getRealPath("");
        //拼接工程路径和文件路径
        //File.pathSeparator 表示文件路径分隔符，其能自动适应不同系统的路径分隔符（例如Windows的分隔符是\，Linux的分隔符是/）
        realPath = realPath + File.separator + "img" + File.separator + "Windows.jpg";
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组作为响应报文的响应体，is.available() 用于获取输入流所对应的文件的字节数
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置下载方式以及下载文件的名字
        //请求头的键不区分大小写，Content Disposition头用来强制浏览器下载文件，而不是在浏览器中显示
        //attachment表示以附件形式下载，即在下载时有提示信息
        //filename表示下载的文件的名字
        headers.add("Content-Disposition", "attachment;filename=Win10.jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(bytes, headers, statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }

}
