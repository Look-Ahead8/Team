package com.team.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.Error;
import com.team.bean.Msg;
import com.team.bean.Resume;
import com.team.service.ResumeService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@Transactional
public class ResumeController{
	@Autowired
	private ResumeService resumeService;
	/**
	 *
	 * @param resume
	 */
	@RequestMapping(value="/Resume",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="添加一条简历信息",notes="添加一条简历信息",httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="resumeId",value="简历id(不用)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="studentNo",value="学号(必须)",paramType="query"),
		@ApiImplicitParam(name="direction",value="方向(必须)",paramType="query"),
		@ApiImplicitParam(name="grade",value="班级(必须)",paramType="query"),
		@ApiImplicitParam(name="phonenumber",value="电话号码(必须)",paramType="query"),
		@ApiImplicitParam(name="profession",value="专业(必须)",paramType="query"),
		@ApiImplicitParam(name="wechat",value="微信(必须)",paramType="query"),
		@ApiImplicitParam(name="evaluation",value="自我评价(必须)",paramType="query"),
		@ApiImplicitParam(name="skills",value="技能(必须)",paramType="query"),
		@ApiImplicitParam(name="experience",value="实践经历(必须)",paramType="query"),
		@ApiImplicitParam(name="expectation",value="期望(必须)",paramType="query"),
		@ApiImplicitParam(name="others",value="其他(必须)",paramType="query"),
	})
    public Msg addResume(@Valid Resume resume,BindingResult result) {
		if(result.hasErrors()) {
			List<FieldError> errors=result.getFieldErrors();
			Map<String,Object> map=new HashMap<String, Object>();
			map=Error.Traversal(errors,map);
			return Msg.fail().add("errorFields", map);
		}
		else {
			resumeService.saveResume(resume);
	    	return Msg.success();
		}
    }
	
	@RequestMapping(value="/Resume",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="查询全部的简历信息",notes="查询全部的简历信息，包含分页数据",httpMethod="GET")
	@ApiImplicitParams({
    	@ApiImplicitParam(name="pn",value="分页中当前的页数，默认为第一页",dataType="int",paramType="query")
    })
	public Msg selectResume(@RequestParam(value="pn",defaultValue="1")Integer pn) {
		PageHelper.startPage(pn, 5);
		List<Resume> resumes=resumeService.selectResume();
		PageInfo<Resume> pageinfo=new PageInfo<Resume>(resumes,5);
		return Msg.success().add("pageinfo",pageinfo);
	}
	
	@RequestMapping(value="/resume",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="查询某一条简历信息",notes="查询某一条简历信息",httpMethod="GET")
	@ApiImplicitParams({
		@ApiImplicitParam(name="resumeId",value="简历id(必须)",dataType="int",paramType="query")
	})
	public Msg selectOneResume(@RequestParam(value="resumeId") Integer resumeId) {
		return Msg.success().add("Resume", resumeService.selectOneResume(resumeId));
	}
	
	@RequestMapping(value="/Resume",method=RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value="删除一条简历信息",notes="删除一条简历信息",httpMethod="DELETE")
	@ApiImplicitParams({
		@ApiImplicitParam(name="resumeId",value="简历id(必须)",dataType="int",paramType="query")
	})
	
	public Msg deleteResume(@RequestParam(value="resumeId")Integer resumeId) {
		resumeService.deleteResume(resumeId);
		return Msg.success();
	}
}
