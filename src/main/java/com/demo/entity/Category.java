package com.demo.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 学习资料类别
 * @author 叶金雄
 * @date 2019年1月18日 下午2:56:24
 */
public class Category implements Serializable{
	private String id;
	private String cName;
	private List<StudyMaterial> studyMaterials;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public List<StudyMaterial> getStudyMaterials() {
		return studyMaterials;
	}
	public void setStudyMaterials(List<StudyMaterial> studyMaterials) {
		this.studyMaterials = studyMaterials;
	}
}
