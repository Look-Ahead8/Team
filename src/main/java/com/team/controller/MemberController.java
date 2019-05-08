package com.team.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.bean.Member;
import com.team.bean.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.Error;
import com.team.service.MD5Util;
import com.team.service.MemberService;
import com.team.service.ResumeService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@Transactional
public class MemberController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private ResumeService resumeService;

	@RequestMapping(value = "/Member", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "添加一个成员", notes = "添加一个成员，通过同意简历自动把简历信息转化为成员信息", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "mId", value = "成员id(不用)", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "studentNo", value = "学号(必须)", paramType = "query"),
			@ApiImplicitParam(name = "grade", value = "班级(必须)", paramType = "query"),
			@ApiImplicitParam(name = "phonenumber", value = "电话号码(必须)", paramType = "query"),
			@ApiImplicitParam(name = "profession", value = "专业(必须)", paramType = "query"),
			@ApiImplicitParam(name = "wechat", value = "微信(必须)", paramType = "query"),
			@ApiImplicitParam(name = "graduation", value = "毕业去向(不用)", paramType = "query"),
			@ApiImplicitParam(name = "password", value = "密码(不用)，一开始自动生成为12345678", paramType = "query"),
			@ApiImplicitParam(name = "resumeId", value = "简历id(必须),成为成员后删除其简历", dataType = "INTEGER", paramType = "query"), })
	public Msg saveMember(@Valid Member member, BindingResult result,
			@RequestParam(value = "resumeId") Integer resumeId) {
		if (result.hasErrors()) {
			List<FieldError> list = result.getFieldErrors();
			Map<String, Object> maps = new HashMap<String, Object>();
			maps = Error.Traversal(list, maps);
			return Msg.fail().add("errorFields", maps);
		} else {
			member.setPassword("12345678");
			memberService.saveMember(member);
			resumeService.deleteResume(resumeId);
			return Msg.success();
		}
	}

	@RequestMapping(value = "/Member", method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "修改一个成员信息", notes = "修改一个成员信息，在登录后可以修改自己的信息,这个页面显示自己的相关信息", httpMethod = "PUT")
	@ApiImplicitParams({ @ApiImplicitParam(name = "mId", value = "成员id(不用)", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "studentNo", value = "学号(必须)", paramType = "query"),
			@ApiImplicitParam(name = "grade", value = "班级(必须)", paramType = "query"),
			@ApiImplicitParam(name = "phonenumber", value = "电话号码(必须)", paramType = "query"),
			@ApiImplicitParam(name = "profession", value = "专业(必须)", paramType = "query"),
			@ApiImplicitParam(name = "wechat", value = "微信(必须)", paramType = "query"),
			@ApiImplicitParam(name = "graduation", value = "毕业去向(不用)", paramType = "query"),
			@ApiImplicitParam(name = "password", value = "密码(必须)", paramType = "query"), })
	public Msg updateMember(@Valid Member member, BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			List<FieldError> list = result.getFieldErrors();
			Map<String, Object> maps = new HashMap<String, Object>();
			maps = Error.Traversal(list, maps);
			return Msg.fail().add("errorFields", maps);
		} else {
			memberService.updateMember(member);
			request.getSession().setAttribute("member", member);
			return Msg.success();
		}
	}

	@RequestMapping(value = "/Member", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询全部的成员信息", notes = "查询全部的成员信息,包含分页数据", httpMethod = "GET")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pn", value = "分页中当前的页数，默认为第一页", dataType = "int", paramType = "query") })
	public Msg selectMember(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn, 5);
		List<Member> members = memberService.selectMember();
		PageInfo<Member> info = new PageInfo<Member>(members, 5);
		return Msg.success().add("pageinfo", info);
	}

	@RequestMapping(value = "/member", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询某一个成员信息", notes = "查询某一个成员信息", httpMethod = "GET")
	@ApiImplicitParams({ @ApiImplicitParam(name = "mId", value = "成员id（必须)", dataType = "int", paramType = "query") })
	public Msg selectOneMember(@RequestParam(value = "mId") Integer mId) {
		return Msg.success().add("member", memberService.selectOneMember(mId));
	}

	@RequestMapping(value = "/adminmember", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "返回登录的成员信息", notes = "返回登录的成员信息", httpMethod = "GET")
	public Msg adminmember(HttpServletRequest request) {
		Member member = (Member) request.getSession().getAttribute("member");
			return Msg.success().add("member", member);
	}

	@RequestMapping(value = "/exitmember", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "退出登录", notes = "退出登录", httpMethod = "GET")
	public Msg exitmember(HttpServletRequest request) {
		request.getSession().removeAttribute("member");
		return Msg.success();
	}
	
	@RequestMapping(value = "/updatepassword", method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "修改密码", notes = "修改密码", httpMethod = "PUT")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "mId", value = "Id(必须)", paramType = "query"),
		@ApiImplicitParam(name = "oldpassword", value = "原始密码(必须)", paramType = "query"),
		@ApiImplicitParam(name = "newpassword", value = "密码(必须)", paramType = "query")})
	public Msg updatepassword(HttpServletRequest request,@RequestParam(value="mId") Integer mId,@RequestParam(value="oldpassword") String oldpassword,@RequestParam(value="newpassword") String newpassword) {
		if(memberService.selectOldpassword(mId).equals(MD5Util.crypt(oldpassword))) {
			Member member=new Member();
			member.setmId(mId);
			member.setPassword(MD5Util.crypt(newpassword));
			memberService.updatepassword(member);
			request.getSession().removeAttribute("member");
			return Msg.success();
		}
		else {
			return Msg.fail().add("error", "修改失败");
		}
	}
}
