package com.heyufei.user.controller;

import com.heyufei.common.result.PageResult;
import com.heyufei.common.result.ResponseMessage;
import com.heyufei.user.entity.User;
import com.heyufei.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 控制器层
 *
 * @author Administrator
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public ResponseMessage login(@RequestBody User user) {
        return ResponseMessage.success(userService.login(user));
    }
    @GetMapping("/token-analysis")
    public ResponseMessage login(@RequestParam String token) {
        return ResponseMessage.success(userService.tokenAnalysis(token));
    }
    /**
     * 查询全部数据
     */
    @GetMapping
    public Object findAll() {
        List<User> all = userService.findAll();
        return ResponseMessage.success(all);
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseMessage findById(@PathVariable Long id) {
        return ResponseMessage.success(userService.findById(id));
    }


    /**
     * 分页+多条件查询
     *
     * @param searchMap 查询条件封装
     * @param page      页码
     * @param size      页大小
     * @return 分页结果
     */
    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public ResponseMessage findSearch(@RequestBody Map searchMap, @PathVariable int page, @PathVariable int size) {
        Page<User> pageList = userService.findSearch(searchMap, page, size);
        return ResponseMessage.success(new PageResult<>(pageList.getTotalElements(), pageList.getContent()));
    }

    /**
     * 增加
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseMessage add(@RequestBody User user) {
        Date date = new Date();
        user.setCreate_time(date);
        user.setUpdate_time(date);
        userService.add(user);
        return ResponseMessage.success("增加成功");
    }

    /**
     * 修改
     *
     * @param user
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseMessage update(@RequestBody User user) {
        userService.update(user);
        return ResponseMessage.success("修改成功");
    }

    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseMessage delete(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseMessage.success("删除成功");
    }

}
