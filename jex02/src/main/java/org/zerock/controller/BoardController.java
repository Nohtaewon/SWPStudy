package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller		// 스프링의 빈으로 인식할 수 있게
@Log4j
@RequestMapping("/board/*")		// '/board'로 시작하는 모든 처리
@AllArgsConstructor		// BoardService 에 의존적이므로 이것을 이용해서 생성자를 만들고 자동으로 주입
public class BoardController {
	//만일 생성자를 만들지 않을 경우 @Setter(onMethod_-{@Autowired})
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) { //게시물의 목록을 전달해야 하므로 Model을 파라미터로 지정
		log.info("list");
		model.addAttribute("list", service.getList());
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register: "+board);
		
		service.register(board);
		
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, Model model) {
		// bno 값을 좀 더 명시적으로 처리하는 @RequestParam 또한 화면쪽으로 해당 번호의 게시물을 전달해야 하므로 Model을 파라미터로 지정
		log.info("/get");
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modify:"+board);
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("remove..."+bno);
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
	}
}
