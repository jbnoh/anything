package com.anything.db.jpa.user.service;

import org.springframework.stereotype.Service;

import com.anything.db.jpa.user.entity.UserVo;
import com.anything.db.jpa.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public UserVo findBySeq(int seq) {

		return userRepository.findBySeq(seq);
	}

	public UserVo findByUserId(String userId) {

		return userRepository.findByUserId(userId);
	}

	public UserVo findByUserIdAndUserPw(String userId, String userPw) {

		return userRepository.findByUserIdAndUserPw(userId, userPw);
	}

	public UserVo save(UserVo user) {

		return userRepository.save(user);
	}

	public void deleteBySeq(int seq) {

		userRepository.deleteBySeq(seq);
	}

	public void updatePwBySeq(int seq, String userPw) {

		UserVo user = userRepository.findBySeq(seq);
		if (user != null) {
			user.setUserPw(userPw);
			userRepository.save(user);
		}
	}
}
