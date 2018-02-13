package com.tykj.viewTest.controller;

import java.io.File;




import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/view")
public class ViewController {
	@RequestMapping("/upload")
	public void uploadView(HttpServletRequest request,HttpServletResponse response) throws IOException{
		MultipartHttpServletRequest mRequest=(MultipartHttpServletRequest) request;
        Iterator<String> fns=mRequest.getFileNames();//获取上传的文件列表
        while(fns.hasNext()){
        	 String s =fns.next();
        	 System.out.println(s);
             MultipartFile mFile = mRequest.getFile(s); 
           String name=  mFile.getOriginalFilename();
            File file=new File("D://view/"+name);
    		File filepath=new File("D://view");
    		if (!filepath.isDirectory()) {
    			filepath.mkdirs();
    		}
    		FileUtils.copyInputStreamToFile(mFile.getInputStream(), file);
        }
        PrintWriter out = response.getWriter();
		out.println("");  
		out.flush();  
		out.close();
	}

}
