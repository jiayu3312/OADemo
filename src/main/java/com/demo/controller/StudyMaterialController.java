package com.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.demo.utils.Page;
import com.demo.entity.StudyMaterial;
import com.demo.service.StudyMaterialService;

/**
 * 学习资料--控制器层
 * 
 * @author 叶金雄
 * @date 2019年1月18日 下午3:52:49
 */
@Controller
public class StudyMaterialController {
	@Autowired
	private StudyMaterialService studyMaterialService;

	// 分页查询
	@RequestMapping("/selectAll")
	@ResponseBody
	public Page<StudyMaterial> selectAll(Model model, Integer currentPage) {
		// 判断当前页码是否为空，若为空，则赋值为1
		if (currentPage == null) {
			currentPage = 1;
		}
		// 连接数据库查询
		Page<StudyMaterial> page = studyMaterialService.selectAll(currentPage);
		model.addAttribute("page", page);
		return page;
	}

	// 学习资料上传
	@RequestMapping(value = "/uploadFile")
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		try {
			if (file.isEmpty()) {
				return "文件为空";
			}
			// 获取文件名
			String fileName = file.getOriginalFilename();
			// 设置文件存储路径
			String filePath = "I:/uploadFiles/";
			String path = filePath + fileName;
			File dest = new File(path);
			// 检测是否存在目录
			if (!dest.getParentFile().exists()) {
				dest.getParentFile().mkdirs();// 新建文件夹
			}
			file.transferTo(dest);// 文件写入
			return "上传成功";
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "上传失败";
	}
	
	// 学习资料下载
	@RequestMapping("/downloadFile")
	public void downloadFile(StudyMaterial studyMaterial, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取需下载文件的存储路径
		String url = studyMaterial.getUploadUrl();
		//获取文件名
		String fileName = studyMaterial.getFileName();
		// 组成文件的输出流
		File file = new File(url, fileName);
		FileInputStream fis = new FileInputStream(file);
		// 设置响应的内容:下载
		response.setHeader("Content-Disposition",
				"attachement;filename=" + studyMaterial.getFileName());	// 下载
		ServletOutputStream sos = response.getOutputStream();
		IOUtils.copy(fis, sos);
	}
	
	//新增
	@RequestMapping("/insertStudyMaterial")
	public int insertStudyMaterial(StudyMaterial studyMaterial){
		return studyMaterialService.insertStudyMaterial(studyMaterial);
	}
	
	//删除
	@RequestMapping("/deleteStudyMaterial")
	public int deleteStudyMaterial(String id){
		return studyMaterialService.deleteStudyMaterial(id);
	}
	
	//修改
	@RequestMapping("/updateStudyMaterial")
	public int updateStudyMaterial(StudyMaterial studyMaterial){
		return studyMaterialService.updateStudyMaterial(studyMaterial);
	}
	
	
	
}
