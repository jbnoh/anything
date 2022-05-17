package com.anything.db.jpa.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anything.db.jpa.user.entity.UserVo;

@Repository
public interface UserRepository extends JpaRepository<UserVo, Integer> {

	public UserVo findBySeq(int seq);

	public UserVo findByUserId(String userId);

	public UserVo findByUserIdAndUserPw(String userId, String userPw);

	public void deleteBySeq(int seq);
}
