package com.anything.db.jpa.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anything.db.jpa.user.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	public UserEntity findBySeq(int seq);

	public UserEntity findByUserId(String userId);

	public UserEntity findByUserIdAndUserPw(String userId, String userPw);

	public void deleteBySeq(int seq);
}
