package com.heyufei.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.heyufei.user.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * 数据访问接口
 * @author Administrator
 */
public interface UserRepository extends JpaRepository<User,Long>,JpaSpecificationExecutor<User>{

    @Query(nativeQuery = true, value = "select * from blog.user where username = ?1")
    User findByUsername(String username);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update blog.user set nickname=:nickname, password=:password, update_time=now() where username=:username")
    void updateUserByUsername(String username,String password, String nickname);
}
