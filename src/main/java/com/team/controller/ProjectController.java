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
import com.team.bean.Member;
import com.team.bean.Msg;
import com.team.bean.PPirture;
import com.team.bean.Project;
import com.team.service.PPirtureService;
import com.team.service.ProjectService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@Transactional
public class ProjectController {
	@Autowired
	private ProjectService projectService;
    @Autowired
    private PPirtureService pPirtureService;
	/*
	 * 上传项目信息，包括照片
	 */
	@RequestMapping(value="/Project",method=RequestMethod.POST)
	@ResponseBody()
	@ApiOperation(value="添加一条项目信息",notes="添加一条项目信息",httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="projectId",value="项目id(不用)",dataType="integer",paramType="query"),
		@ApiImplicitParam(name="mId",value="发布的成员id(不用)",dataType="integer",paramType="query"),
		@ApiImplicitParam(name="message",value="内容(必须)",paramType="query"),
		@ApiImplicitParam(name="projectDate",value="项目展示日期(必须),规定好格式，XXXX-XX-XX",paramType="query"),
		@ApiImplicitParam(name="Path",value="照片(必须),不要超过9张，也不可以0张",paramType="query"),
	})
	public Msg saveProject(@Valid Project project,BindingResult result,@RequestParam(value="Path") MultipartFile[] file,HttpServletRequest request) throws IllegalStateException, IOException {
		if(result.hasErrors()) {
			List<FieldError> errors=result.getFieldErrors();
			Map<String,Object> maps=new HashMap<String,Object>();
			maps=Error.Traversal(errors, maps);
			return Msg.fail().add("errorFields", maps);
		}
		else if(file.length==0) {
			return Msg.fail().add("errorFields", "请上传图片");
		}
		else if(!pPirtureService.checkimg(file)) {
			return Msg.fail().add("errorFields", "图片格式不正确，上传失败");
		}
		else {
			Member member = (Member) request.getSession().getAttribute("member");
            project.setmId(member.getmId());
            projectService.saveProject(project);
            String pathRoot=request.getServletContext().getRealPath("/");
            for(int i=0;i<file.length;i++) {
            	String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				String contentType = file[i].getContentType();
				String imageName = contentType.substring(contentType.indexOf("/") + 1);
				String path = "static/project/" + uuid + "." + imageName;
				file[i].transferTo(new File(pathRoot+path));
				PPirture pPirture=new PPirture();
				pPirture.setPirturePath(path);
				pPirture.setProjectId(projectService.getprojectId());
				pPirtureService.savePPirture(pPirture);
            }
			return Msg.success();
		}
	}
	
	/*
	 * 删除项目信息，包括照片
	 */
	@RequestMapping(value="/Project",method=RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value="删除一条项目信息",notes="删除一条项目信息",httpMethod="DELETE")
	@ApiImplicitParams({
		@ApiImplicitParam(name="projectId",value="项目id(必须)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="mId",value="发布的成员id(不用)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="message",value="内容(不用)",paramType="query"),
		@ApiImplicitParam(name="projectDate",value="项目展示日期(不用)",paramType="query"),
		@ApiImplicitParam(name="Path",value="照片(不用)",paramType="query"),
	})
	public Msg deleteProject(Project project,HttpServletRequest request) {
		String pathRoot = request.getSession().getServletContext().getRealPath("/");
	    List<PPirture> list=pPirtureService.selectImaPath(project.getProjectId());
	    for(PPirture p:list) {
	    	new File(pathRoot+p.getPirturePath()).delete();
	    }
	    pPirtureService.deletePPirture(project.getProjectId());
	    projectService.deleteProject(project.getProjectId());
	    return Msg.success();
	}
	
	/*
	 * 显示项目信息，包括照片
	 */
	@RequestMapping(value="/Project",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="查询全部的项目信息",notes="查询全部的项目信息,包括分页数据",httpMethod="GET")
	@ApiImplicitParams({
    	@ApiImplicitParam(name="pn",value="分页中当前的页数，默认为第一页",dataType="int",paramType="query")
    })
	public Msg selectProject(@RequestParam(value="pn",defaultValue="1") Integer pn) {
		PageHelper.startPage(pn, 5);
		List<Project> projects=projectService.selectAll();
		PageInfo<Project> info=new PageInfo<Project>(projects,5);
		return Msg.success().add("pageinfo", info);
	}
	
	/*
	 * 返回某一条项目信息
	 */
	@RequestMapping(value="/project",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="查询一条项目信息",notes="查询一条项目信息",httpMethod="GET")
	@ApiImplicitParams({
		@ApiImplicitParam(name="projectId",value="项目id(必须)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="mId",value="发布的成员id(不用)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="message",value="内容(不用)",paramType="query"),
		@ApiImplicitParam(name="projectDate",value="项目展示日期(不用)",paramType="query"),
		@ApiImplicitParam(name="Path",value="照片(不用)",paramType="query"),
	})
	public Msg selectOneProject(Project project) {
		return Msg.success().add("project", projectService.selectOne(project));
	}
	/*
	 * 更改项目信息，包括图片的更改
	 * 把之前的图片全部删除掉，再生成新的图片信息
	 */
	@RequestMapping(value="/Project",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="修改一条项目信息",notes="修改一条项目信息",httpMethod="PUT")
	@ApiImplicitParams({
		@ApiImplicitParam(name="projectId",value="项目id(必须)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="mId",value="修改的成员id(必须)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="message",value="内容(必须)",paramType="query"),
		@ApiImplicitParam(name="projectDate",value="项目展示日期(必须),规定好格式，XXXX-XX-XX",paramType="query"),
		@ApiImplicitParam(name="Path",value="照片(必须),不要超过9张，也不可以0张",paramType="query"),
	})
	public Msg updateProject(@Valid Project project,BindingResult result,HttpServletRequest request,@RequestParam(value="Path") MultipartFile[] file) throws IllegalStateException, IOException {
		if(result.hasErrors()) {
			List<FieldError> errors=result.getFieldErrors();
			Map<String,Object> maps=new HashMap<String, Object>();
			maps=Error.Traversal(errors, maps);
			return Msg.fail().add("errorFields", maps);
		}
		else {
			String pathRoot=request.getServletContext().getRealPath("/");
			Member member = (Member) request.getSession().getAttribute("member");
			project.setmId(member.getmId());
			projectService.updateProject(project);
			List<PPirture> list=pPirtureService.selectImaPath(project.getProjectId());
			for(PPirture p:list) {
				new File(pathRoot+p.getPirturePath()).delete();
			}
			pPirtureService.deletePPirture(project.getProjectId());
			for(int i=0;i<file.length;i++) {
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				String contentType = file[i].getContentType();
				String imageName = contentType.substring(contentType.indexOf("/") + 1);
				String path = "project\\life\\" + uuid + "." + imageName;
				file[i].transferTo(new File(pathRoot+path));
				PPirture pPirture=new PPirture();
				pPirture.setPirturePath(path);
				pPirture.setProjectId(project.getProjectId());
				pPirtureService.savePPirture(pPirture);
			}
			return Msg.success();
		}
	}
}
