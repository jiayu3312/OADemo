package com.demo.service;

import com.demo.entity.StudyMaterial;
import com.demo.utils.Page;

/**
 * 学习资料接口
 * 
 * @author 叶金雄
 * @date 2019年1月18日 下午3:33:13
 */
public interface StudyMaterialService {
	// 查询所有
	public Page<StudyMaterial> selectAll(Integer currentPage);
	
	//新增
	public int insertStudyMaterial(StudyMaterial studyMaterial);
	
	//删除
	public int deleteStudyMaterial(String id);
	
	//修改
	public int updateStudyMaterial(StudyMaterial studyMaterial);
	
}
