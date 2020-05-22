package com.swjd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.swjd.bean.User;
import com.swjd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

    @Controller
    public class UserController {
        @Autowired
        UserService userService;

        //去登录
        @RequestMapping("/toLogin")
        public String toLogin(Model model) {
            User user = new User();
            model.addAttribute("user", user);
            return "login";
        }

        //做登录
        @RequestMapping("/doLogin")
        public String doLogin(Model model, User user, HttpSession session) {
            QueryWrapper queryWrapper=new QueryWrapper();
            queryWrapper.eq("uname",user.getUname());
            queryWrapper.eq("password",user.getPassword());
            User u=userService.getOne(queryWrapper);
            if (u != null) {
                //账号密码没问题
                if (u.getFlag().equals("1")) {
                    //登录成功把信息存入到session中，进行相应判断
                    //登录成功把用户名存到session
                    session.setAttribute("activeName", u.getUname());
                    return "success";
                } else {
                    //账号被禁
                    model.addAttribute("user", user);
                    model.addAttribute("errorMsg", "账号被禁，请联系管理员");
                    return "login";
                }
            } else {
                //账号密码错了
                User user2 = new User();
                model.addAttribute("user", user2);
                model.addAttribute("errorMsg", "账号密码错误");
                return "login";
            }
        }

        //去main.jsp-测试拦截器1·
        @RequestMapping("/toMain")
        public String toMain() {
            return "main";
        }


    }

