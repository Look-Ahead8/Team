package com.team.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.service.ImgCode;

import io.swagger.annotations.ApiOperation;
@Controller
public class ImgCodeController {
	@Autowired
	private ImgCode imgCode;

	@RequestMapping(value="/imgcode",method=RequestMethod.GET)
	@ApiOperation(value="返回一张图形验证码",notes="返回一张图形验证码",httpMethod="GET")
	public void getImgCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
		BufferedImage img=imgCode.getImage();
		OutputStream out=response.getOutputStream();
		String text=imgCode.getText();
		HttpSession session=request.getSession();
		session.setAttribute("text", text);
		imgCode.output(img, out);
	}
}
