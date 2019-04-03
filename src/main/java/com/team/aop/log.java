package com.team.aop;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component  
@Aspect
public class log {
	private final String fileName="log.txt";
	private Calendar calendar = Calendar.getInstance();
	private FileWriter fw;
	
	@Before("execution(* com.team.service..*.*(..))")
	public void before(JoinPoint jp) {
		try {
			ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpServletRequest request = attributes.getRequest();
			File file=new File(request.getServletContext().getRealPath("/")+fileName);
			fw=new FileWriter(file, true);
			fw.write(getTime()+"    "+request.getRemoteAddr()+"   "+jp.getSignature()+"开始执行");
		} 
		catch (IOException e) {
			System.out.println("日志文件写入失败");
			e.printStackTrace();
		}
		finally {
			try {
				fw.close();
			} 
			catch (IOException e) {
				System.out.println("文件输出流关闭失败");
				e.printStackTrace();
			}
		}
		System.out.println(getTime()+"  "+jp.getSignature()+"开始执行");
	}
	
	@After("execution(* com.team.service..*.*(..))")
	public void after(JoinPoint jp) {
		try {
			ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpServletRequest request = attributes.getRequest();
			File file=new File(request.getServletContext().getRealPath("/")+fileName);
			fw=new FileWriter(file, true);
			fw.write(getTime()+"    "+request.getRemoteAddr()+"   "+jp.getSignature()+"执行成功");
		}
		catch(IOException e) {
			System.out.println("日志文件写入失败");
			e.printStackTrace();
		}
		finally {
			try {
				fw.close();
			}
			catch(IOException e) {
				System.out.println("文件输出流关闭失败");
				e.printStackTrace();
			}
		}
	}
	
	public int getYear() {
		return calendar.get(Calendar.YEAR);
	}
	public int getMonth() {
		return (calendar.get(Calendar.MONTH))+1;
	}
	public int getDay() {
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	public int getHour() {
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
	public int getMinute() {
		return calendar.get(Calendar.MINUTE);
	}
	public int getSecond() {
		return calendar.get(Calendar.SECOND);
	}
	public String getTime() {
		return getYear()+"-"+getMonth()+"-"+getDay()+" "+getHour()+":"+getMinute()+":"+getSecond();
	}
}
