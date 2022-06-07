package com.anything.api.join;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/join")
@RequiredArgsConstructor
public class JoinController {

	@PutMapping
	public ResponseEntity<?> save() {

		
	}
}
