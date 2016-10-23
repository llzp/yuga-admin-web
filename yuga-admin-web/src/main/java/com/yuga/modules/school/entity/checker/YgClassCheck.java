/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/ksm">ksm</a> All rights reserved.
 */
package com.yuga.modules.school.entity.checker;

import org.hibernate.validator.constraints.Length;

import com.yuga.common.persistence.DataEntity;

/**
 * 巡查情况Entity
 * @author 曾康
 * @version 2016-10-23
 */
public class YgClassCheck extends DataEntity<YgClassCheck> {
	
	private static final long serialVersionUID = 1L;
	private String gradeId;		// 所属年级
	private String courseSection;		// 课程章节
	private String teacherId;		// 教师
	private String checkerId;		// 巡查人
	private String teacherStatusId;		// 教师教学情况
	private String studentStatusId;		// 学生学习情况
	private String multimediaStatusId;		// 使用多媒体情况
	private String condition1;		// 教师教学好习惯落实
	private String condition2;		// 学生学习好习惯落实
	private String condition3;		// 使用多媒体情况
	
	public YgClassCheck() {
		super();
	}

	public YgClassCheck(String id){
		super(id);
	}

	@Length(min=0, max=11, message="所属年级长度必须介于 0 和 11 之间")
	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}
	
	@Length(min=0, max=2, message="课程章节长度必须介于 0 和 2 之间")
	public String getCourseSection() {
		return courseSection;
	}

	public void setCourseSection(String courseSection) {
		this.courseSection = courseSection;
	}
	
	@Length(min=0, max=11, message="教师长度必须介于 0 和 11 之间")
	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	
	@Length(min=0, max=11, message="巡查人长度必须介于 0 和 11 之间")
	public String getCheckerId() {
		return checkerId;
	}

	public void setCheckerId(String checkerId) {
		this.checkerId = checkerId;
	}
	
	@Length(min=0, max=11, message="教师教学情况长度必须介于 0 和 11 之间")
	public String getTeacherStatusId() {
		return teacherStatusId;
	}

	public void setTeacherStatusId(String teacherStatusId) {
		this.teacherStatusId = teacherStatusId;
	}
	
	@Length(min=0, max=11, message="学生学习情况长度必须介于 0 和 11 之间")
	public String getStudentStatusId() {
		return studentStatusId;
	}

	public void setStudentStatusId(String studentStatusId) {
		this.studentStatusId = studentStatusId;
	}
	
	@Length(min=0, max=11, message="使用多媒体情况长度必须介于 0 和 11 之间")
	public String getMultimediaStatusId() {
		return multimediaStatusId;
	}

	public void setMultimediaStatusId(String multimediaStatusId) {
		this.multimediaStatusId = multimediaStatusId;
	}
	
	@Length(min=1, max=255, message="教师教学好习惯落实长度必须介于 1 和 255 之间")
	public String getCondition1() {
		return condition1;
	}

	public void setCondition1(String condition1) {
		this.condition1 = condition1;
	}
	
	@Length(min=1, max=255, message="学生学习好习惯落实长度必须介于 1 和 255 之间")
	public String getCondition2() {
		return condition2;
	}

	public void setCondition2(String condition2) {
		this.condition2 = condition2;
	}
	
	@Length(min=1, max=255, message="使用多媒体情况长度必须介于 1 和 255 之间")
	public String getCondition3() {
		return condition3;
	}

	public void setCondition3(String condition3) {
		this.condition3 = condition3;
	}
	
}