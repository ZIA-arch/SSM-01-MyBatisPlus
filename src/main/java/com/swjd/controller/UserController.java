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
@RequestMapping("/userController")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "login";
    }
    //实现登录功能
    @RequestMapping("/doLogin")
    public String doLogin(User user, Model model, HttpSession session){
        //调用service的方法
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("uName",user.getuName());
        queryWrapper.eq("password",user.getPassword());
        User u=userService.getOne(queryWrapper);
        if (u!=null){
            //账号密码正确
            if (u.getFlag().equals("1")){
                //可以登录成功
                session.setAttribute("activeName",u.getuName());
                model.addAttribute("loginState",u.getuName());
                return "redirect:/userController/toMain";
            }else {
                //被禁用的不可以登录(账户被冻结)
                model.addAttribute("errorMsg","账户被冻结，请联系客服");
                model.addAttribute("user",user);
                return "login";
            }
        }else {
            //账号密码不正确
            model.addAttribute("errorMsg","账号或密码不正确");
            model.addAttribute("user",user);
            return "login";
        }
    }
    @RequestMapping("/toMain")
    public String toMain(Model model,HttpSession session){
        String name=(String) session.getAttribute("activeName");
        String loginState="";
        if (name!=null){
            loginState=name;
        }else {
            loginState="请先登录";
        }
        model.addAttribute("loginState",loginState);
        model.addAttribute("name",name);
        return "main";
    }
}
