package com.team.bean;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class Member {
    private Integer mId;
    @NotBlank(message="学号不可以为空")
    private String studentNo;
    @NotBlank(message="班级不可以为空")
    private String grade;
    @Pattern(regexp="^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0-2,5-9]))\\d{8}$",message="请输入正确的电话号码")
    private String phonenumber;
    @NotBlank(message="专业不可以为空")
    private String profession;
    @NotBlank(message="微信不可以为空")
    private String wechat;
    
    private String graduation;

    private String password;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo == null ? null : studentNo.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation == null ? null : graduation.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}