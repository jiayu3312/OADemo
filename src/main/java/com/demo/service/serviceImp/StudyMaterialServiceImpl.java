package com.demo.service.serviceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.StudyMaterial;
import com.demo.mapper.StudyMaterialMapper;
import com.demo.service.StudyMaterialService;
import com.demo.utils.Page;

/**
 * 学习资料--业务逻辑层
 * 
 * @author 叶金雄
 * @date 2019年1月18日 下午3:38:07
 */
@Service
public class StudyMaterialServiceImpl implements StudyMaterialService {
	
	@Autowired
	private StudyMaterialMapper studyMaterialMapper;

	// 分页查询所有
	@Override
	public Page<StudyMaterial> selectAll(Integer currentPage) {
		// 1.定义每页展示的条数和接收当前要访问的页码
		int pageSize = 4;
		if (currentPage == null) {
			currentPage = 1;
		}
		// 2.调用方法来查询总条数
		// 3.定义page进行处理
		Map<String, Object> map = new HashMap<>();
		Integer count = studyMaterialMapper.selectCount();
		Page<StudyMaterial> page = new Page<StudyMaterial>(currentPage, pageSize, count);
		map.put("startIndex", page.getStartIndex());
		map.put("pageSize", page.getPageSize());
		// 4.分页查询
		List<StudyMaterial> list = studyMaterialMapper.selectAll(map);
		page.setDataList(list);
		return page;
	}
	
	//新增
	@Override
	public int insertStudyMaterial(StudyMaterial studyMaterial) {
		return studyMaterialMapper.insertStudyMaterial(studyMaterial);
	}
	
	//删除
	@Override
	public int deleteStudyMaterial(String id) {
		return studyMaterialMapper.deleteStudyMaterial(id);
	}
	
	//修改
	@Override
	public int updateStudyMaterial(StudyMaterial studyMaterial) {
		return studyMaterialMapper.updateStudyMaterial(studyMaterial);
	}

}
