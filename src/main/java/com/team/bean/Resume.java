package com.team.bean;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Resume {
    private Integer resumeId;
    @Size(min=12,max=12,message="请输入12位学号")
    private String studentNo;
    @NotBlank(message="方向不可以为空")
    private String direction;
    @NotBlank(message="班级不可以为空")
    private String grade;
    @Pattern(regexp="^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0-2,5-9]))\\d{8}$",message="请输入正确的电话号码")
    private String phonenumber;
    @NotBlank(message="专业不可以为空")
    private String profession;
    @NotBlank(message="微信不可以为空") 
    private String wechat;
    @NotBlank(message="自我评价不可以为空") 
    private String evaluation;
    @NotBlank(message="技能水平不可以为空")
    private String skills;
    @NotBlank(message="实践经历不可以为空") 
    private String experience;
    @NotBlank(message="期望不可以为空") 
    private String expectation;
    @NotBlank(message="其他不可以为空") 
    private String others;

    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo == null ? null : studentNo.trim();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
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

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation == null ? null : evaluation.trim();
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills == null ? null : skills.trim();
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience == null ? null : experience.trim();
    }

    public String getExpectation() {
        return expectation;
    }

    public void setExpectation(String expectation) {
        this.expectation = expectation == null ? null : expectation.trim();
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others == null ? null : others.trim();
    }
}