package springweb.a05_mvc.a02_service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import springweb.a05_mvc.a03_dao.A05_FileDao;
import springweb.z01_vo.FileRep;

@Service
public class A05_FileService {

   @Value("${file.upload}")
   private String upload;
   
   public String uploadFile(MultipartFile report) {
      String fname = report.getOriginalFilename();
      if(fname!=null && !fname.equals("")) {
         File fObj = new File(upload+fname);
         
         try {
            report.transferTo(fObj); // 필수예외처리(IO발생)
         } catch (IllegalStateException e) {
            System.out.println("파일업로드 예외1:"+e.getMessage());
         } catch (IOException e) {
            System.out.println("파일업로드 예외2:"+e.getMessage());
         }
      }
      return fname;
   }
   @Autowired(required=false)
   A05_FileDao dao;
   public void insertFile(FileRep f) {
   }
   public List<FileRep> getFileList(String title){
	   return dao.getFileList(title);
   }
}