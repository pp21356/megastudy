package com.mysite.factory.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mysite.factory.service.BoardService;
import com.mysite.factory.service.MarkerService;
import com.mysite.factory.vo.BoardVO;
import com.mysite.factory.vo.Criteria;
import com.mysite.factory.vo.PageDTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	@Autowired
	private BoardService boardservice;
	
	@Autowired 
	private MarkerService markerservice;
	
	//메인페이지로 이동
	@RequestMapping("")
	public String gomain(Model model) {
		model.addAttribute("marker", markerservice.getMarkers());
		return "/main";
	}
	
	//게시판으로이동
	@GetMapping("/board")
	public String getBoard(Criteria cri, Model model) {
		log.info("---------------");
		log.info(cri.toString());
		log.info("---------------");
		model.addAttribute("list", boardservice.getList(cri));
		model.addAttribute("pageMaker" , new PageDTO(cri,boardservice.getTotal(cri)));
		return "/board/list";
	}
	
	//페이지이동
		@GetMapping("/board/changepage")
		public String changepage(Criteria cri, Model model) {
			log.info("---------------");
			log.info(cri.toString());
			log.info("---------------");
			if(cri.getCategorie().equals("all")) {
				model.addAttribute("list", boardservice.getList(cri));
				model.addAttribute("pageMaker" , new PageDTO(cri,boardservice.getTotal(cri)));
				return "/board/list";
			}
			model.addAttribute("list", boardservice.getListGenre(cri));
			model.addAttribute("pageMaker" , new PageDTO(cri,boardservice.getTotalGenre(cri)));
			model.addAttribute("cate", cri.getCategorie());	
			log.info(cri.getCategorie());
			return "/board/list";
		}
	
	//전체로선택되었을때
	@PostMapping("/board")
	public String getgen(Criteria cri, Model model) {
		log.info("---------------");
		log.info(cri.toString());
		log.info("---------------");
		model.addAttribute("list", boardservice.getList(cri));
		model.addAttribute("pageMaker" , new PageDTO(cri,boardservice.getTotal(cri)));
		return "/board/list :: .row";
	}
	
	//Ajax
	@PostMapping("/board/genre")
	public String getGenre(Criteria cri, Model model) {
		log.info("---------------");
		log.info(cri.toString());
		log.info("---------------");
		model.addAttribute("list", boardservice.getListGenre(cri));
		model.addAttribute("pageMaker" , new PageDTO(cri,boardservice.getTotalGenre(cri)));
		return "/board/list :: .row";
	}
		
	
	@GetMapping("/main")
	public String goMain(Model model) {
		model.addAttribute("marker", markerservice.getMarkers());
		return "/main";
	}
	
	@GetMapping("/board/register")
	public String goWtire() {
		
		return "/board/register";
	}
	
	
	//게시판 하나 보여주기
	@GetMapping("/board/{bno}")
	public String goBoard(@PathVariable("bno") Long bno, Model model) {
		BoardVO board = boardservice.getBoard(bno);
		model.addAttribute("board",board);
		return "/board/get";
	}
	
	//게시판 글업로드하기
	@PostMapping("/upload/uploadAjaxAction")
	public String upload(@RequestParam("uploadFile") MultipartFile mf, @RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("categorie") String categorie, @RequestParam("image") String image  ) {
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setContent(content);
		board.setCategorie(categorie);
		
		board.setUsername("하드코딩");
		log.info(board.toString());
		String Path = "C:/Users/82102/OneDrive/바탕 화면/factory/factory/src/main/resources/static/img";
		
		File uploadPath = new File(Path);
		
   
			log.info("Upload File Name : " + mf.getOriginalFilename());
			log.info("Upload File Size : " + mf.getSize());
			
			String uploadFileName = mf.getOriginalFilename();
			
			log.info("file name : " + uploadFileName);
			
			
			board.setImage(image);
			
			try {
				File saveFile = new File(uploadPath, uploadFileName);
				mf.transferTo(saveFile);
				boardservice.insert(board);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
        
        
        
        log.info("------------------------------------------");
      
        
        log.info("------------------------------------------");
		
		return "redirect:/board";
	}

}
