package com.anything.front.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anything.bind.annotation.SupportData;
import com.anything.front.login.service.LoginService;
import com.anything.vo.Data;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

	private final LoginService loginService;

	@GetMapping
	public String view() {

		return "/login/view";
	}

	@PostMapping
	public String execute(@SupportData Data data) {

		loginService.loginExecute();
		return "/main/view";
	}
}
