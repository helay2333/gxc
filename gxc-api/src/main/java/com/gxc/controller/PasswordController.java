package com.gxc.controller;

import com.gxc.grace.result.GraceJSONResult;
import com.gxc.grace.utils.IPUtil;
import com.gxc.grace.utils.MailUtils;
import com.gxc.grace.utils.RedisOperator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.gxc.controller.BaseController.MOBILE_SMSCODE;

/** 登录验证信息
 * @author Green写代码
 * @date 2024-01-26 08:44
 */
@Slf4j
@RequestMapping("password")
@RestController
public class PasswordController {
    @Autowired
    private MailUtils mailUtils;
    @Autowired
    private RedisOperator redisOperator;
    @PostMapping("getMailCode")
    public GraceJSONResult getMailCode(@RequestParam String email,
                                       HttpServletRequest request) throws Exception {
        if(StringUtils.isBlank(email)){
            return GraceJSONResult.errorMsg("邮箱为空");
        }
        //获取用户ip地址
        String userIp = IPUtil.getRequestIp(request);
        //限制ip访问次数
        redisOperator.setnx60s(MOBILE_SMSCODE + ":" + userIp, userIp);
        String code = (int)((Math.random() * 9 + 1) * 100000) + "";
        MailUtils.sendTestMail(email,code);
        log.info(code);
        //存放进入redis
        redisOperator.set(MOBILE_SMSCODE + ":" + email, code, 30 * 60);
        return GraceJSONResult.ok("登录成功");
    }
}
