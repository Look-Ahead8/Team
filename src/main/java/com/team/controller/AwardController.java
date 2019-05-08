package com.team.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import org.springframework.web.multipart.MultipartFile;

import com.team.bean.Error;
import com.team.bean.Member;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.APirture;
import com.team.bean.Award;
import com.team.bean.Msg;
import com.team.service.APirtureService;
import com.team.service.AwardService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@Transactional
public class AwardController {

	@Autowired
	private AwardService awardService;
	@Autowired
	private APirtureService aPirtureService;
	
	/*
	 * 上传获奖信息，包括照片
	 */
	@RequestMapping(value="/Award",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="添加一条获奖信息",notes="添加一条获奖信息",httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="awardId",value="获奖id(不用)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="mId",value="发布的成员id(不用)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="message",value="内容(必须)",paramType="query"),
		@ApiImplicitParam(name="awardtDate",value="获奖日期(必须),规定好格式，XXXX-XX-XX",paramType="query"),
		@ApiImplicitParam(name="Path",value="照片(必须),不要超过9张，也不可以0张",paramType="query"),
	})
	public Msg saveAward(@Valid Award award,BindingResult result, @RequestParam(value="Path") MultipartFile[] file,HttpServletRequest request) throws IllegalStateException, IOException {
		if(result.hasErrors()) {
			List<FieldError> errors=result.getFieldErrors();
			Map<String,Object> maps=new HashMap<String,Object>();
			Error.Traversal(errors, maps);
			return Msg.fail().add("errorFields", maps);
		}
		else {
			Member member=(Member) request.getSession().getAttribute("member");
			award.setmId(member.getmId());
			awardService.saveAward(award);
			String pathRoot = request.getSession().getServletContext().getRealPath("/");
			for(int i=0;i<file.length;i++) {
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				String contentType = file[i].getContentType();
				String imageName = contentType.substring(contentType.indexOf("/") + 1);
				String path = "static/award/" + uuid + "." + imageName;
				file[i].transferTo(new File(pathRoot+path));
				APirture aPirture=new APirture();
				aPirture.setPirturePath(path);
				aPirture.setAwardId(awardService.getawardId());
				aPirtureService.saveAPirture(aPirture);
			}
			return Msg.success();
		}
	}
	
	/*
	 * 删除获奖信息，包括照片
	 */
	@RequestMapping(value="/Award",method=RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value="删除一条获奖信息",notes="删除一条获奖信息",httpMethod="DELETE")
	@ApiImplicitParams({
		@ApiImplicitParam(name="awardId",value="获奖id(必须)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="mId",value="发布的成员id(不用)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="message",value="内容(不用)",paramType="query"),
		@ApiImplicitParam(name="awardDate",value="获奖日期(不用)",paramType="query"),
		@ApiImplicitParam(name="Path",value="照片(不用)",paramType="query"),
	})
	public Msg deleteAward(Award award,HttpServletRequest request) {
		String pathRoot=request.getServletContext().getRealPath("/");
		List<APirture> list=aPirtureService.selectImaPath(award.getAwardId());
		for(APirture a:list) {
			new File(pathRoot+a.getPirturePath()).delete();
		}
		aPirtureService.deleteAPirture(award.getAwardId());
		awardService.deleteAward(award.getAwardId());
		return Msg.success();
	}
	
	/*
	 * 显示获奖信息，包括照片
	 */
	@RequestMapping(value="/Award",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="查询全部的获奖信息",notes="查询全部的获奖信息，返回分页数据",httpMethod="GET")
	@ApiImplicitParams({
    	@ApiImplicitParam(name="pn",value="分页中当前的页数，默认为第一页",dataType="int",paramType="query")
    })
	public Msg selectAward(@RequestParam(value="pn",defaultValue="1") Integer pn) {
		PageHelper.startPage(pn,5);
		List<Award> awards=awardService.selectAll();
		PageInfo<Award> info=new PageInfo<Award>(awards,5);
		return Msg.success().add("pageinfo", info);
	}
	/*
	 * 返回某一条获奖信息
	 */
	@RequestMapping(value="/award",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="查询某一条获奖信息",notes="查询某一条获奖信息",httpMethod="GET")
	@ApiImplicitParams({
		@ApiImplicitParam(name="awardId",value="获奖id(必须)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="mId",value="发布的成员id(不用)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="message",value="内容(不用)",paramType="query"),
		@ApiImplicitParam(name="awardDate",value="获奖展示日期(不用)",paramType="query"),
		@ApiImplicitParam(name="Path",value="照片(不用)",paramType="query"),
	})
	public Msg selectOneAward(Award award) {
		return Msg.success().add("award", awardService.selectOneAward(award));
	}
	
	/*
	 * 更改获奖信息，包括图片的更改
	 * 把之前的图片全部删掉，再生成新的图片信息
	 */
	@RequestMapping(value="/Award",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="更改一条获奖信息",notes="更改一条获奖信息",httpMethod="PUT")
	@ApiImplicitParams({
		@ApiImplicitParam(name="awardId",value="获奖id(必须)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="mId",value="修改的成员id(必须)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="message",value="内容(必须)",paramType="query"),
		@ApiImplicitParam(name="awardDate",value="获奖日期(必须),规定好格式，XXXX-XX-XX",paramType="query"),
		@ApiImplicitParam(name="Path",value="照片(必须),不要超过9张，也不可以0张",paramType="query"),
	})
	public Msg updateAward(@Valid Award award,BindingResult result,HttpServletRequest request,MultipartFile[] file) throws IllegalStateException, IOException {
		if(result.hasErrors()) {
			List<FieldError> errors=result.getFieldErrors();
			Map<String,Object> maps=new HashMap<String, Object>();
			maps=Error.Traversal(errors, maps);
			return Msg.fail().add("errorFields", maps);
		}
		else {
			String pathRoot=request.getServletContext().getRealPath("/");
			Member member = (Member) request.getSession().getAttribute("member");
			award.setmId(member.getmId());
			awardService.updateAward(award);
			List<APirture> list=aPirtureService.selectImaPath(award.getAwardId());
			for(APirture a:list) {
				new File(pathRoot+a.getPirturePath()).delete();
			}
			aPirtureService.deleteAPirture(award.getAwardId());
			for(int i=0;i<file.length;i++) {
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				String contentType = file[i].getContentType();
				String imageName = contentType.substring(contentType.indexOf("/") + 1);
				String path = "static\\award\\" + uuid + "." + imageName;
				file[i].transferTo(new File(pathRoot+path));
				APirture aPirture=new APirture();
				aPirture.setPirturePath(path);
				aPirture.setAwardId(award.getAwardId());
				aPirtureService.saveAPirture(aPirture);
			}
			return Msg.success();
		}
	}
}
