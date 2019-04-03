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

import com.team.bean.History;
import com.team.bean.Msg;
import com.team.bean.Error;
import com.team.service.HistoryService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@Transactional
public class HistoryController {
	@Autowired
	private HistoryService historyService;
	
	@ResponseBody
	@RequestMapping(value="/History",method=RequestMethod.POST)
	@ApiOperation(value="添加一条历史",notes="添加一条历史",httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="historyId",value="历史id(不用)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="message",value="历史信息(必须)",paramType="query"),
		@ApiImplicitParam(name="historyDate",value="历史时间(必须),规定好格式，XXXX-XX-XX",paramType="query")
	})
	public Msg saveHistory(@Valid History history,BindingResult result) {
		if(result.hasErrors()) {
			List<FieldError> errors=result.getFieldErrors();
			Map<String,Object> maps=new HashMap<String, Object>();
			maps=Error.Traversal(errors,maps);
			return Msg.fail().add("errorFields", maps);
		}
		else {
			historyService.saveHistory(history);
			return Msg.success();
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/History",method=RequestMethod.GET)
	@ApiOperation(value="返回全部的历史",notes="返回全部全部的历史，没有分页数据",httpMethod="GET")
	@ApiImplicitParams({
		@ApiImplicitParam(name="historyId",value="历史id(不用)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="message",value="历史信息(不用)",paramType="query"),
		@ApiImplicitParam(name="historyDate",value="历史时间(不用)",paramType="query")
	})
    public Msg selectHistory() {
		List<History> history=historyService.selectHistory();
		return Msg.success().add("history",history);
	}
	
	@ResponseBody
	@RequestMapping(value="/History",method=RequestMethod.DELETE)
	@ApiOperation(value="删除一条历史",notes="删除一条历史",httpMethod="DELETE")
	@ApiImplicitParams({
		@ApiImplicitParam(name="historyId",value="历史id(必须)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="message",value="历史信息(不用)",paramType="query"),
		@ApiImplicitParam(name="historyDate",value="历史时间(不用)",paramType="query")
	})
    public Msg DeleteHistory(@RequestParam(value="historyId")Integer historyId) {
		historyService.deleteHistory(historyId);;
		return Msg.success();
	}
	
	@ResponseBody
	@RequestMapping(value="/History",method=RequestMethod.PUT)
	@ApiOperation(value="更改一条历史",notes="更改一条历史",httpMethod="PUT")
	@ApiImplicitParams({
		@ApiImplicitParam(name="historyId",value="历史id(必须)",dataType="int",paramType="query"),
		@ApiImplicitParam(name="message",value="历史信息(必须)",paramType="query"),
		@ApiImplicitParam(name="historyDate",value="历史时间(必须),规定好格式，XXXX-XX-XX",paramType="query")
	})
	public Msg UpdateHistory(@Valid History history,BindingResult result) {
		if(result.hasErrors()) {
			List<FieldError> errors=result.getFieldErrors();
			Map<String,Object> maps=new HashMap<String, Object>();
			maps=Error.Traversal(errors,maps);
			return Msg.fail().add("errorFields", maps);
		}
		else {
			historyService.updateHistory(history);
			return Msg.success();
		}
	}
}
