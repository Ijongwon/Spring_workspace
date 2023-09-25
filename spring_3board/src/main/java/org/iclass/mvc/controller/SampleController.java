package org.iclass.mvc.controller;

import org.iclass.mvc.service.CommunityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//url 이 community로 시작하면 DispatcherServlet 으로 부터 CommuityController 가 위임받아 처리합니다.
@Controller
@RequestMapping("/sample")	

public class SampleController {
	
	private final CommunityService service;
	
	private SampleController(CommunityService service) {
		this.service=service;
	}
	
	//여기서부터는 핸들러 메소드 입니다.
	//URL 설게 : 글 목록 조회 : /community/list , 글쓰기 /community/writer , 글 읽기 /community/read
	
	
	@GetMapping("/list")
	public void list() {
		
		
	}
	
	@GetMapping("/read")
	public void read() {
		
	}
	@GetMapping("/write")
	public void write() {
		
	}
}
