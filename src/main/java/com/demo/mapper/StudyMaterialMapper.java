package com.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.demo.entity.StudyMaterial;
@Mapper
public interface StudyMaterialMapper {
	//分页查询所有
	public List<StudyMaterial> selectAll(Map map);
	
	//总记录数
	public int selectCount();
	
	//新增
	public int insertStudyMaterial(StudyMaterial studyMaterial);
	
	//删除
	public int deleteStudyMaterial(String id);
	
	//修改
	public int updateStudyMaterial(StudyMaterial studyMaterial);
}
