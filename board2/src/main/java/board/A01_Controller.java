package board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import board.vo.Board;
import board.vo.BoardSch;

@Controller
public class A01_Controller {
   // http://localhost:7080/board2/list.do
   @Autowired(required=false)
   private A02_Service service;
   
   @RequestMapping("/list.do")
   public String boardList(@ModelAttribute("sch") BoardSch sch, Model d) {
	   d.addAttribute("list",service.boardList(sch));
	   return "a01_boardList";
   }
   @RequestMapping("/insertFrm.do")
	public String inserFrm(){
		return "a02_insertBoard";
	}
	@PostMapping("/insert.do")
	public String insert(Board ins, Model d){
		service.insertBoard(ins);
		d.addAttribute("msg","등록성공");
		return "a02_insertBoard";
	}	
	@GetMapping("/board.do")
	public String getBoard(@RequestParam("no") 
		int no, Model d){
		service.uptReadCnt(no);
		d.addAttribute("board",service.getBoard(no));
		return "a03_board";
	}	
	
	   // download.do?fname=@@@@
	   @GetMapping("/download.do")
	   public String download(@RequestParam("fname") 
	      String fname, Model d) {
	      d.addAttribute("downloadFile", fname);
	      return "downloadView";
	   }
@PostMapping("/boardUpt.do")
public String boardUpt(Board upt, Model d) {
	service.updateBoard(upt);
	d.addAttribute("board",service.getBoard(upt.getNo()));
	d.addAttribute("msg","수정완료");
	return "a03_board";
}
// /delBoard.do
@GetMapping("/delBoard.do")
public String delBoard(@RequestParam("no") int no, Model d) {
	service.deleteBoard(no);
	d.addAttribute("msg", "삭제완료");
	return "a03_board";
}
	}