package org.iclass.mvc.controller;

import org.iclass.mvc.dto.BookUser;
import org.iclass.mvc.service.BookUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {			//회원가입을 구현해보기
	
	private final BookUserService service;

	@RequestMapping("/test")
	public void test(@SessionAttribute("user") BookUser user) { 	//로그인 방법 1로 되돌려 놓고 테스트합니다.
		//LoginController 에서 저장된 user 세션 애트리뷰트를 가져옵니다.
		log.info("user test : {}" , user);
	}
	
	@GetMapping("/join")
	public void join() {
		
	}
	
	@PostMapping("/save")
	public String save(BookUser dto,RedirectAttributes reAttr) {
		service.join(dto);
		reAttr.addFlashAttribute("message", "회원가입이 완료되었습니다.");
	return "redirect:/login";
	}
	
	
	
	
	}


