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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.Error;
import com.team.bean.LPirture;
import com.team.bean.Life;
import com.team.bean.Member;
import com.team.bean.Msg;
import com.team.service.LPirtureService;
import com.team.service.LifeService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@Transactional
public class LifeController {
	@Autowired
	private LifeService lifeService;
    @Autowired
    private LPirtureService lPirtureService;

	
	/*
	 * 上传生活信息，包括照片
	 */
	@RequestMapping(value="/Life",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="添加一条生活信息",notes="添加一条生活信息",httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="lifeId",value="生活id(不用)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="mId",value="发布的成员id(不用)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="message",value="内容(必须)",paramType="query"),
		@ApiImplicitParam(name="lifetDate",value="项目展示日期(必须),规定好格式，XXXX-XX-XX",paramType="query"),
		@ApiImplicitParam(name="Path",value="照片(必须),不要超过9张，也不可以0张",paramType="query"),
	})
	public Msg saveLife( Life life, @RequestParam(value="Path")MultipartFile[] file,HttpServletRequest request) throws IllegalStateException, IOException {
		if(lifeService.checkmessage(life)) {
			return Msg.fail().add("errorFields", "内容不可以为空");
		}
		else if(file.length==0) {
			return Msg.fail().add("errorFields", "请上传图片");
		}
		else if(!lPirtureService.checkimg(file)) {
			return Msg.fail().add("errorFields", "图片格式不正确，上传失败");
		}
		else {
			Member member = (Member) request.getSession().getAttribute("member");
			life.setmId(member.getmId());
			lifeService.saveLife(life);
			String pathRoot = request.getSession().getServletContext().getRealPath("/");
			for (int i = 0; i < file.length; i++) {
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				String contentType = file[i].getContentType();
				String imageName = contentType.substring(contentType.indexOf("/") + 1);
				String path = "static\\life\\" + uuid + "." + imageName;
				file[i].transferTo(new File(pathRoot + path));
				LPirture lPirture=new LPirture();
				lPirture.setPirturePath(path);
				lPirture.setLifeId(life.getLifeId());
				lPirtureService.saveLPirture(lPirture);
			}
			return Msg.success();
		}
	}
	
	/*
	 * 删除生活信息，包括照片
	 */
	@RequestMapping(value="/Life",method=RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value="删除一条生活信息",notes="删除一条生活信息",httpMethod="DELETE")
	@ApiImplicitParams({
		@ApiImplicitParam(name="lifeId",value="生活id(必须)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="mId",value="发布的成员id(不用)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="message",value="内容(不用)",paramType="query"),
		@ApiImplicitParam(name="lifetDate",value="生活展示日期(不用)",paramType="query"),
		@ApiImplicitParam(name="Path",value="照片(不用)",paramType="query"),
	})
	public Msg deleteLife(Life life,HttpServletRequest request) {
		String pathRoot = request.getSession().getServletContext().getRealPath("/");
		List<LPirture> list=lPirtureService.selectImaPath(life.getLifeId());
		for(LPirture l:list) {
			new File(pathRoot+l.getPirturePath()).delete();
		}
		lPirtureService.deleteLPirture(life.getLifeId());
		lifeService.deleteLife(life.getLifeId());
		return Msg.success();
	}
	
	/*
	 * 显示生活信息，包括照片
	 */
	@RequestMapping(value="/Life",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="查询全部生活信息",notes="查询全部生活信息,包括分页数据",httpMethod="GET")
	@ApiImplicitParams({
    	@ApiImplicitParam(name="pn",value="分页中当前的页数，默认为第一页",dataType="int",paramType="query")
    })
	public Msg selectLife(@RequestParam(value="pn",defaultValue="1") Integer pn) {
		PageHelper.startPage(pn, 5);
		List<Life> lifes=lifeService.selectAll();
		PageInfo<Life> info=new PageInfo<Life>(lifes,5);
		return Msg.success().add("pageinfo",info);
	}
	
	/*
	 * 返回某一条生活信息
	 */
	@RequestMapping(value="/life",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="查询某一条生活信息",notes="查询一条生活信息",httpMethod="get")
	@ApiImplicitParams({
		@ApiImplicitParam(name="lifeId",value="生活id(必须)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="mId",value="发布的成员id(不用)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="message",value="内容(不用)",paramType="query"),
		@ApiImplicitParam(name="lifeDate",value="生活展示日期(不用)",paramType="query"),
		@ApiImplicitParam(name="Path",value="照片(不用)",paramType="query"),
	})
	public Msg selectOneLife(Life life) {
		return Msg.success().add("life",lifeService.selectOne(life) );
	}
	/*
	 * 更改生活信息，包括图片的更改
	 * 把之前的图片全部删除掉，再生成新的图片信息
	 */
	@RequestMapping(value="/Life",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="更改一条生活信息",notes="更改一条生活信息",httpMethod="PUT")
	@ApiImplicitParams({
		@ApiImplicitParam(name="lifeId",value="生活id(必须)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="mId",value="修改的成员id(必须)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="message",value="内容(必须)",paramType="query"),
		@ApiImplicitParam(name="lifeDate",value="生活展示日期(必须),规定好格式，XXXX-XX-XX",paramType="query"),
		@ApiImplicitParam(name="Path",value="照片(必须),不要超过9张，也不可以0张",paramType="query"),
	})
	public Msg updateLife(@Valid Life life,BindingResult result,HttpServletRequest request,@RequestParam(value="Path")MultipartFile[] file) throws IllegalStateException, IOException {
		if(result.hasErrors()) {
			List<FieldError> errors=result.getFieldErrors();
			Map<String,Object> maps=new HashMap<String, Object>();
			maps=Error.Traversal(errors, maps);
			return Msg.fail().add("errorFields", maps);
		}
		else {
			String pathRoot=request.getServletContext().getRealPath("/");
			Member member = (Member) request.getSession().getAttribute("member");
			life.setmId(member.getmId());
			lifeService.updateLife(life);
			List<LPirture> list=lPirtureService.selectImaPath(life.getLifeId());
			for(LPirture l:list) {
				new File(pathRoot+l.getPirturePath()).delete();
			}
			lPirtureService.deleteLPirture(life.getLifeId());
			for(int i=0;i<file.length;i++) {
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				String contentType = file[i].getContentType();
				String imageName = contentType.substring(contentType.indexOf("/") + 1);
				String path = "static\\life\\" + uuid + "." + imageName;
				file[i].transferTo(new File(pathRoot + path));
				LPirture lPirture=new LPirture();
				lPirture.setPirturePath(path);
				lPirture.setLifeId(life.getLifeId());
				lPirtureService.saveLPirture(lPirture);
			}
			return Msg.success();
		}
	}
}
