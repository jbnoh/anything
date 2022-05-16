package com.anything.front.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anything.front.login.service.LoginService;

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
	public String execute() {

		loginService.loginExecute();
		return "/main/view";
	}
}
