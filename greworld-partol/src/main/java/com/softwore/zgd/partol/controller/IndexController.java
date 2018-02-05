package com.softwore.zgd.partol.controller;

import com.softwore.zgd.dubbo.user.IUserCoreService;
import com.softwore.zgd.dubbo.user.dto.UserLoginRequest;
import com.softwore.zgd.dubbo.user.dto.UserLoginResponse;
import com.softwore.zgd.dubbo.user.dto.UserRegisterRequest;
import com.softwore.zgd.dubbo.user.dto.UserRegisterResponse;
import com.softwore.zgd.partol.controller.annotations.Anonymous;
import com.softwore.zgd.partol.controller.support.BaseController;
import com.softwore.zgd.partol.controller.support.ResponseData;
import com.softwore.zgd.partol.controller.support.ResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 风骚的GRE
 * @Descriptions TODO
 * @date 2018/2/4.
 */
@Controller
public class IndexController extends BaseController {
    @Autowired
    private IUserCoreService userCoreService;
    @Autowired
    private JmsTemplate jmsTemplate;


    @GetMapping("/index")
    public String index(Model model) {
        System.out.println("test");
        return "index";
    }

    @GetMapping("/login")
    @Anonymous
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    @Anonymous
    public ResponseEntity login(String txtUser, String txtPwd, HttpServletResponse response){
        UserLoginRequest request = new UserLoginRequest();
        request.setUsername(txtUser);
        request.setPassword(txtPwd);
        UserLoginResponse userLoginResponse = userCoreService.login(request);
        if("000000".equals(userLoginResponse.getCode())){
            response.addHeader("Set-Cookie","access_token="+userLoginResponse.getToken()+";Path=/;HttpOnly");
        }
        return ResponseEntity.ok(userLoginResponse);
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public @ResponseBody ResponseData register(String username,String password,String mobile){
        ResponseData data = new ResponseData();
        UserRegisterRequest request = new UserRegisterRequest();
        request.setUsername(username);
        request.setPassword(password);
        request.setMobile(mobile);
        try {
            UserRegisterResponse response = userCoreService.register(request);
            if(response.getCode().equals("000000")){
                //发送邮件  发送卡券
                jmsTemplate.send(new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        return session.createTextMessage("发送邮件");
                    }
                });
            }
            data.setMessage(response.getMsg());
            data.setCode(response.getCode());

        }catch (Exception e){
            data.setMessage(ResponseEnum.FAILED.getMsg());
            data.setCode(ResponseEnum.FAILED.getCode());
        }
        return data;
    }
}
