package com.anything.front.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anything.bind.annotation.SupportData;
import com.anything.vo.Data;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

	@GetMapping
	public String view() {

		return "/login/view";
	}

	@PostMapping
	public void execute(@SupportData Data data) {
	}
}
