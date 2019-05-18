package com.leone.boot.shiro.controller;

import com.leone.boot.shiro.common.util.ImgCodeUtil;
import com.leone.boot.shiro.common.util.UserHelper;
import com.leone.boot.shiro.entity.User;
import com.leone.boot.shiro.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("/api/shiro/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{account}")
    public User user(@PathVariable String account) {
        return userService.findByAccount(account);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.login(user.getAccount(), user.getPassword());
    }

    /**
     * 查询用户
     */

    @RequestMapping("/list")//符合user:view或user:add权限要求即可
    @RequiresPermissions(value = {"user:add", "user:select"}, logical = Logical.OR)
    public String user() {
        return "user";
    }

    /**
     * 添加用户
     */
    @RequestMapping("/add")//符合user:view和user:add权限要求
    @RequiresPermissions(value = {"user:select", "user:add"}, logical = Logical.AND)
    public String userAdd() {
        return "userAdd";
    }

    /**
     * 删除用户
     */
    @RequestMapping("/delete")
    @RequiresPermissions("user:delete")
    public String userDel() {
        return "userDel";
    }

    /**
     * 修改用户
     */
    @RequestMapping("/update")
    @RequiresPermissions("user:update")
    public String userUpdate() {
        return "userUpdate";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "home";
    }

    @RequestMapping("/index")
    public String index(ModelMap modelMap) {
        return "index";
    }
    //登录页(shiro配置需要两个/login 接口,一个是get用来获取登陆页面,一个用post用于登录,这是一个坑)
//    @GetMapping("/login")
//    public String login() {
//        log.info("跳转到login页面控制器！");
//        return "login";
//    }


    //    @ResponseStatus(HttpStatus.GONE)
//    @GetMapping(value = "/login")
//    public void loginUser(@RequestParam String token, HttpSession session) {
//        UsernamePasswordToken loginToken = new UsernamePasswordToken("jack", "jack");
//        Subject subject = SecurityUtils.getSubject();
//        try {
//            subject.login(loginToken);
//            User user = (User) subject.getPrincipal();
//            log.info("user:{}", user);
//            session.setAttribute("user", user);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "login";
    }

//    @RequiresUser
//    @RequestMapping("/guest")
//    public String guest() {
//        return "guest请求";
//    }

    // @RequiresGuest
//    @RequestMapping("/user")
//    public void reqUser() {
//        Integer user = UserHelper.userId();
//        System.out.println(user);
//    }

    @RequestMapping("/image")
    public void validCode(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        ImgCodeUtil.generate(response, 200, 20);
        String code = (String) session.getAttribute("imageCode");
        log.info("imageCode:{}", code);
    }


}