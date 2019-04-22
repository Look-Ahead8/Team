package com.team.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.bean.Member;
import com.team.dao.MemberMapper;

@Service
public class LoginService {
	@Autowired
	private MemberMapper memberMapper;

	public boolean selectMember(String studentNo,String password,String imgcode,String text) {
		if(checkstudentNo(studentNo)&&checkpassword(password)&&checkimgcode(imgcode)&&checkimgcode(imgcode,text)&&checkmember(studentNo,password)) {
			return true;
		}
		else {
			return false;
		}
	}
	/*
	 * 获取登录成员信息
	 */
	
	public Member getMember(String studentNo){
		Member member=memberMapper.selectByStudentNo(studentNo);
		return member;
	}
	
	/*
	 * 学号不可以为空
	 */
	public boolean checkstudentNo(String studentNo) {
		if(studentNo.equals("")) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/*
	 * 密码不可以为空
	 */
	public boolean checkpassword(String password) {
		if(password.equals("")) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/*
	 * 图形验证码不可以为空
	 */
	public boolean checkimgcode(String imgcode) {
		if(imgcode.equals("")) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/*
	 * 判断图形验证码是否输入正确
	 */
	public boolean checkimgcode(String imgcode,String text) {
		if(text.equals(imgcode)) {
			return true;
		}
		else {
			return false;
		}
	}
	/*
	 * 数据库中查找账匹配
	 */
	public boolean checkmember(String studentNo,String password) {
		String pwd=memberMapper.selectPassword(studentNo);
		if(pwd.equals(MD5Util.crypt(password))) {
			return true;
		}
		else {
			return false;
		}
	}
}
