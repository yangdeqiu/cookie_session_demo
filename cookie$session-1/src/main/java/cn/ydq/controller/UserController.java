package cn.ydq.controller;

import cn.ydq.entity.User;
import cn.ydq.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @RequestMapping("dologin.do")
    public String doLogin(){
        return "login";
    }

    @Autowired
    private UserService userService;

    @RequestMapping("login.do")
    public String getLogin(HttpServletRequest request,HttpServletResponse response, ModelAndView mcv, User user){
        if(StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassword())){
            request.setAttribute("msg","有为空数据");
            return "login";
        }
        if(userService.getLogin(user)){
            Cookie ck = new Cookie("user", JSONObject.toJSONString(user));
//            ck.setMaxAge(60*10);
            ck.setPath("/");
            response.addCookie(ck);
            request.setAttribute("name",user.getName());
            return "welcome";
        }else{
            request.setAttribute("msg","failed");
            return "login";
        }
    }
}
