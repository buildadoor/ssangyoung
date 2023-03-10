package springweb.a05_mvc.a01_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import springweb.a05_mvc.a02_service.A05_FileService;
import springweb.a05_mvc.a02_service.A06_FileService;
import springweb.z01_vo.FileRep;

@Controller
public class A05_FileUploadController {
   @Autowired(required = false)
   private A05_FileService service;

   // http://localhost:7080/springweb/uploadFrm.do
   @GetMapping("/uploadFrm.do")
   public String uploadFrm() {
      return "WEB-INF\\views\\a05_mvc\\a10_fileUpload.jsp";
   }

   @PostMapping("/upload.do")
   public String upload(@RequestParam("report") MultipartFile report, Model d) {
      System.out.println("###### 서버까지 온 파일:" + report.getOriginalFilename());
      if (service.uploadFile(report) != null) {
         d.addAttribute("msg", "업로드 성공");
      }
      return "WEB-INF\\views\\a05_mvc\\a10_fileUpload.jsp";
   }

   // uploadFrm2.do
   // upload2.do
   // a11_fileUpload2.jsp
   // A06_FileService.java로 파일 업로드 되게
   // 경로 webapp/z02_upload
   
   @Autowired(required = false)
   private A06_FileService service2;
   
   // http://localhost:7080/springweb/uploadFrm2.do
   @GetMapping("/uploadFrm2.do")
   public String uploadFrm2() {
      return "WEB-INF\\views\\a05_mvc\\a11_fileUpload.jsp";
   }

   @PostMapping("/upload2.do")
   public String upload2(@RequestParam("report") MultipartFile report2, Model d) {
      System.out.println("###### 서버까지 온 파일:" + report2.getOriginalFilename());
      if (service2.uploadFile(report2) != null) {
         d.addAttribute("msg", "업로드 성공");
      }
      return "WEB-INF\\views\\a05_mvc\\a11_fileUpload.jsp";
   }

   // http://localhost:7080/springweb/upload3.do
   // get/post방식 한번에 처리할 때..
   @RequestMapping("/upload3.do")
   public String upload3(@RequestParam(value = "report", required = false) MultipartFile report, Model d) {
      if (report != null && service2.uploadFile(report) != null) {
         d.addAttribute("msg", "업로드 성공");
      }
      return "WEB-INF\\views\\a05_mvc\\a12_fileUpload.jsp";
   }
   // http://localhost:7080/springweb/fileList.do
   @RequestMapping("/fileList.do")
   public String fileList(@RequestParam(value="title", defaultValue="")String title, Model d) {
      d.addAttribute("flist",service.getFileList(title));
      return "WEB-INF\\views\\a05_mvc\\a13_fileUpLoadList.jsp";
   }
   @PostMapping("/fileUpLoad.do")
   public String fileUpLoad(FileRep upload, Model d) {
      if(service.insertFile(upload)!="") {
         d.addAttribute("msg", "업로드 성공");
      }
      d.addAttribute("flist", service.getFileList(""));
      return "WEB-INF\\views\\a05_mvc\\a13_fileUpLoadList.jsp"; // 업로드 후에 바로 전체 리스트 검색되게 처리
   }
}