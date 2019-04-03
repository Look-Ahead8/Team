package com.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.team.bean.PPirture;
import com.team.dao.PPirtureMapper;

@Service
public class PPirtureService {
	@Autowired
	private PPirtureMapper pPirtureMapper;

	private String[] imageName={"bmp","jpg","jpeg","png","gif"};
	
	/*
	 * 根据项目id返回全部该id项目照片的路径
	 */
	public List<PPirture> selectImaPath(Integer projectId){
		return pPirtureMapper.selectImaPath(projectId);
	}
	public void deletePPirture(Integer projectId) {
		pPirtureMapper.deleteByProjetId(projectId);
	}
	public void savePPirture(PPirture pPirture) {
		pPirtureMapper.insertSelective(pPirture);
	}
	/*
	 * 用于检测上传文件的扩展名是否正确,后缀名正确返回true
	 */
	public boolean checkimg(MultipartFile[] file) {
		for(int i=0;i<file.length;i++) {
			String contentType = file[i].getContentType();
			String imagename = contentType.substring(contentType.indexOf("/") + 1);
			for(int j=0;j<imageName.length;j++) {
				if((imageName[j].equals(imagename))) {
					return true;
				}
			}
		}
		return false;
	}
}
