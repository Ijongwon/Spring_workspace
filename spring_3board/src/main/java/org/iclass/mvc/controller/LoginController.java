package org.iclass.mvc.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.iclass.mvc.dto.BookUser;
import org.iclass.mvc.service.BookUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
//방법 1 : SessionAttributes 를 사용하는 세션
@Controller
@RequiredArgsConstructor
@SessionAttributes(names = {"user"})
public class LoginController {
	private final BookUserService service;

	@GetMapping("/login")    
	public void login() {	//login.jsp 뷰로 요청 전달
	}
	
	@PostMapping("/login")  //POST 요청일때 @PostMapping. param에 저장 되는 것? id 와 password
	public String loginProc(@RequestParam Map<String,String> param,
			RedirectAttributes reattr,
			Model model){
		String url="/";		//계정정보가 일치할때 context path(index)로 이동
		BookUser member = service.login(param);
		if(member==null) {	
			reattr.addFlashAttribute("incorrect","y");
			url="login";   //계정 정보가 틀릴때 다시 로그인으로 이동
		}else {
			model.addAttribute("user", member);
		}
		return "redirect:"+url;		
	}

	@GetMapping("logout")
	public String logout(SessionStatus session) {		//@SessionAttribute로 저장된 model을 삭제
		session.setComplete();		//session 사용 완료 => session attribute 삭제. JSESSIONID는 변경되지 않습니다.
		return "redirect:/";
	}

}
