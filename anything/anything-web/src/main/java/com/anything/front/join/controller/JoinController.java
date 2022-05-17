package com.anything.front.join.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anything.db.jpa.user.entity.UserVo;
import com.anything.db.jpa.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/join")
@RequiredArgsConstructor
public class JoinController {

	private final UserService userService;

	@GetMapping
	public String view() {

		return "/join/view";
	}

	@PostMapping
	public void execute(HttpServletResponse res, UserVo vo) throws Exception {

		if (userService.findByUserId(vo.getUserId()) != null) {
			// ing...
		}

		userService.save(vo);
		res.sendRedirect("/login");
	}
}
