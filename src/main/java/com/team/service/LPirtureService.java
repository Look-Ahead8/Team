package com.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.team.bean.LPirture;
import com.team.dao.LPirtureMapper;
@Service
public class LPirtureService {
	@Autowired
	private LPirtureMapper lPirtureMapper;

	private String[] imageName= {"bmp","jpg","jpeg","png","gif"};
	
	public void saveLPirture(LPirture lPirture) {
		lPirtureMapper.insertSelective(lPirture);
	}
	
	public void deleteLPirture(Integer lifeId) {
		lPirtureMapper.deleteByLifeId(lifeId);
	}
	public List<LPirture> selectLife(){
		List<LPirture> list=lPirtureMapper.selectALL();
		return list;
	}
	public List<LPirture> selectImaPath(Integer lifeId) {
		return lPirtureMapper.selectImgPath(lifeId);
	}
	public void updatePirture(LPirture lPirture) {
		lPirtureMapper.updateByPrimaryKey(lPirture);
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
