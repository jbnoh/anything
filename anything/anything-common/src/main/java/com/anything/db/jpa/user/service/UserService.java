package com.anything.db.jpa.user.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.anything.db.jpa.user.dto.UserDto;
import com.anything.db.jpa.user.entity.UserEntity;
import com.anything.db.jpa.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public UserDto findBySeq(int seq) {

		return entityConvert(userRepository.findBySeq(seq));
	}

	public UserDto findByUserId(String userId) {

		return entityConvert(userRepository.findByUserId(userId));
	}

	public UserDto findByUserIdAndUserPw(String userId, String userPw) {

		return entityConvert(userRepository.findByUserIdAndUserPw(userId, userPw));
	}

	/**
	 * 사용자가 존재할 경우 UPDATE, 않을 경우 INSERT
	 * @param user
	 * @return
	 */
	public UserDto save(UserEntity user) {

		return entityConvert(userRepository.save(user));
	}

	public void deleteBySeq(int seq) {

		userRepository.deleteBySeq(seq);
	}

	public void updatePwBySeq(int seq, String userPw) {

		UserEntity user = userRepository.findBySeq(seq);
		if (user != null) {
			user.setUserPw(userPw);
			userRepository.save(user);
		}
	}

	private UserDto entityConvert(UserEntity entity) {

		UserDto dto = null;

		try {
			ModelMapper mapper = new ModelMapper();
			dto = mapper.map(entity, UserDto.class);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return dto; 
	}
}
