package com.heyufei.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import cn.hutool.crypto.digest.DigestUtil;
import com.alibaba.fastjson.JSONObject;
import com.heyufei.common.exception.BaseException;
import com.heyufei.common.exception.ErrorCode;
import com.heyufei.common.result.ResponseMessage;
import com.heyufei.common.util.JwtUtils;
import com.heyufei.common.util.PasswordUtil;
import com.heyufei.user.dao.UserRepository;
import com.heyufei.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 服务层
 *
 * @author Administrator
 */
@Slf4j
@Service
public class UserService {
    @Resource
    private UserRepository userRepository;
    @Value("${token.secretKey}")
    private static long expireTime;
    /**
     * 用户登录
     * @param dto
     * @return
     */
    public Object login(User dto) {

        //1. 验证请求参数  做非空判断
        String username = dto.getUsername();//登录手机号
        String password = dto.getPassword();//登录密码

        if (StringUtils.isEmpty(password) ||
                StringUtils.isEmpty(username)) {
            //用户名或者密码空的
            throw new BaseException(ErrorCode.ERROR_LOGIN_PASSWORD);
        }

        User user = userRepository.findByUsername(dto.getUsername());

        if (StringUtils.isEmpty(user)) {
            throw new BaseException(ErrorCode.ERROR_LOGIN_NULL);
        }

        //用户存在 则对传入的密码进行md5加密 并且与库里的进行对比
        String mdPassword = PasswordUtil.encrypt(password);
        if (!mdPassword.equals(user.getPassword())) {
            throw new BaseException(ErrorCode.ERROR_LOGIN_PASSWORD);
        }

        //4.密码比对成功 ,生成token字符串
        //4-1 构建map集合
//        HashMap<String, Object> hashMap = new HashMap<>();
//        hashMap.put("user", user);

        String s = JSONObject.toJSONString(user);

        //4-2.存入jwt  ,并且设置有效期(24小时)
        String token = JwtUtils.generateToken(s);

        //返回结果
        return ResponseMessage.success(token);
    }



    /**
     * 查询全部列表
     *
     * @return
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }


    /**
     * 条件查询+分页
     *
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    public Page<User> findSearch(Map whereMap, int page, int size) {
        Specification<User> specification = createSpecification(whereMap);
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return userRepository.findAll(specification, pageRequest);
    }


    /**
     * 条件查询
     *
     * @param whereMap
     * @return
     */
    public List<User> findSearch(Map whereMap) {
        Specification<User> specification = createSpecification(whereMap);
        return userRepository.findAll(specification);
    }

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    /**
     * 增加
     *
     * @param user
     */
    public void add(User user) {
        userRepository.save(user);
    }

    /**
     * 修改
     *
     * @param user
     */
    public void update(User user) {
        userRepository.updateUserByUsername(user.getUsername(), user.getPassword(), user.getNickname());
//		userRepository.save(user);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * 动态条件构建
     *
     * @param searchMap
     * @return
     */
    private Specification<User> createSpecification(Map searchMap) {

        return new Specification<User>() {

            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<Predicate>();
                // 用户名
                if (searchMap.get("username") != null && !"".equals(searchMap.get("username"))) {
                    predicateList.add(cb.like(root.get("username").as(String.class), "%" + (String) searchMap.get("username") + "%"));
                }
                // 密码
                if (searchMap.get("password") != null && !"".equals(searchMap.get("password"))) {
                    predicateList.add(cb.like(root.get("password").as(String.class), "%" + (String) searchMap.get("password") + "%"));
                }
                // 昵称
                if (searchMap.get("nickname") != null && !"".equals(searchMap.get("nickname"))) {
                    predicateList.add(cb.like(root.get("nickname").as(String.class), "%" + (String) searchMap.get("nickname") + "%"));
                }
                // 头像地址
                if (searchMap.get("avatar") != null && !"".equals(searchMap.get("avatar"))) {
                    predicateList.add(cb.like(root.get("avatar").as(String.class), "%" + (String) searchMap.get("avatar") + "%"));
                }
                // 邮箱
                if (searchMap.get("email") != null && !"".equals(searchMap.get("email"))) {
                    predicateList.add(cb.like(root.get("email").as(String.class), "%" + (String) searchMap.get("email") + "%"));
                }
                // 角色访问权限
                if (searchMap.get("role") != null && !"".equals(searchMap.get("role"))) {
                    predicateList.add(cb.like(root.get("role").as(String.class), "%" + (String) searchMap.get("role") + "%"));
                }

                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));

            }
        };

    }

}
