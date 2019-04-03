package com.team.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
	@ApiOperation(value="用户登录",notes="用户登录，包括图形验证码",httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="studentNo",value="学号(必须)",paramType="query"),
		@ApiImplicitParam(name="password",value="密码(必须)",paramType="query"),
		@ApiImplicitParam(name="code",value="验证码(必须)",paramType="query")
	})
	public Msg selectMember(@RequestParam(value="studentNo")String studentNo,@RequestParam(value="password")String password,@RequestParam(value="code")String imgcode,HttpServletRequest request) {
		HttpSession session=request.getSession();
		String text=(String)session.getAttribute("text");
		if(loginService.selectMember(studentNo, password, imgcode, text)) {
			member=loginService.getMember(studentNo);
			session.setAttribute("member", member);
			return Msg.success();  
		}
		else {
			return Msg.fail();
		}
	}

}
