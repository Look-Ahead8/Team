package com.team.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.bean.Member;
import com.team.bean.Msg;
import com.team.service.LoginService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@Transactional
public class LoginController {
	@Autowired
	private LoginService loginService;
	private Member member;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="鐢ㄦ埛鐧诲綍",notes="鐢ㄦ埛鐧诲綍锛屽寘鎷浘褰㈤獙璇佺爜",httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="studentNo",value="瀛﹀彿(蹇呴』)",paramType="query"),
		@ApiImplicitParam(name="password",value="瀵嗙爜(蹇呴』)",paramType="query"),
		@ApiImplicitParam(name="code",value="楠岃瘉鐮�(蹇呴』)",paramType="query")
	})
	public Msg selectMember(@RequestParam(value="studentNo")String studentNo,@RequestParam(value="password")String password,@RequestParam(value="code")String imgcode,HttpServletRequest request) {
		HttpSession session=request.getSession();
		String text=(String)session.getAttribute("text");
		if(loginService.selectMember(studentNo, password, imgcode, text)) {
			member=loginService.getMember(studentNo);
			session.setAttribute("member", member);
			return Msg.success();  
		}
		else if(!loginService.checkimgcode(imgcode, text)){
			return Msg.fail().add("error", "请填写正确的验证码");
		}
		else {
			return Msg.fail().add("error", "用户名或密码不正确");
		}
	}

}
