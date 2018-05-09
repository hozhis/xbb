package cn.dolphinsoft.glance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dolphinsoft.glance.entity.UserEntity;

public interface UserInfoRepository extends JpaRepository<UserEntity, Integer> {

	UserEntity findByUserId(String loginId);

	UserEntity findByLoginId(String loginId);
}
