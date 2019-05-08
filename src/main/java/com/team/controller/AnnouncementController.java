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

import com.team.bean.Error;
import com.team.bean.Member;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.Announcement;
import com.team.bean.Msg;
import com.team.service.AnnouncementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
@Controller
@Transactional
@Api(tags= {"通告操作接口"})
public class AnnouncementController {
    @Autowired
	private AnnouncementService announcementService;
    
    @RequestMapping(value="/Announcement",method=RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="添加通告",notes="添加通告",httpMethod="POST")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="announcementId",value="通告的id(不用)",paramType="query",dataType="int"),
    	@ApiImplicitParam(name="mId",value="发送者的id(不用)",dataType="int",paramType="query"),
    	@ApiImplicitParam(name="message",value="通告内容(必须)",paramType="query"),
    	@ApiImplicitParam(name="announcementTime",value="通告的时间(不用),后台自动获取",paramType="query")
    })
    public Msg saveAnnouncement(@Valid Announcement announcement,BindingResult result,HttpServletRequest request) {
    	if(result.hasErrors()) {
    		List<FieldError> errors=result.getFieldErrors();
    		Map<String,Object> maps=new HashMap<String,Object>();
    		maps=Error.Traversal(errors, maps);
    		return Msg.fail().add("errorFields", maps);
    	}
    	else {
    		Member member=(Member)request.getSession().getAttribute("member");
    		announcement.setmId(member.getmId());
    		System.out.println(member.getmId());
    		announcementService.saveAnnouncement(announcement);
    		return Msg.success();
    	}	
    }
    /*
     * 返回最新的通告
     */
    @RequestMapping(value="/announcement",method=RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="返回最新的通告",notes="返回最新的通告",httpMethod="GET")
    public Msg selectAnnouncementNew() {
    	Announcement announcement=announcementService.selectAnnouncementNew();
    	return Msg.success().add("announcement", announcement);
    }
    
    /*
     * 返回全部的通告
     */
    @RequestMapping(value="/Announcement",method=RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="返回全部的通告",notes="返回全部的通告,并且带有分页的数据",httpMethod="GET")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="pn",value="分页中当前的页数，默认为第一页",paramType="query",dataType="int")
    })
    public Msg selectAll(@RequestParam(value="pn",defaultValue="1") Integer pn) {
    	PageHelper.startPage(pn,5);
    	List<Announcement> announcements=announcementService.selectAll();
    	PageInfo<Announcement> info=new PageInfo<Announcement>(announcements,5);
    	return Msg.success().add("pageinfo", info);
    }
    
    /*
     * 删除一条通告
     */
    @RequestMapping(value="/Announcement",method=RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value="删除一条通告",notes="删除一条通告",httpMethod="DELETE")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="mId",value="删除成员的id(不用)",dataType="int",paramType="query"),
    	@ApiImplicitParam(name="message",value="(不用)",paramType="query"),
    	@ApiImplicitParam(name="announcementId",value="要删除的通告的id(必须)",dataType="int",paramType="query"),
    	@ApiImplicitParam(name="announcementTime",value="(不用)",paramType="query")
    })
    public Msg deleteAnnouncement(Announcement announcement) {
    	announcementService.deleteAnnouncement(announcement);
    	return Msg.success();
    }
}
