package com.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.bean.History;
import com.team.dao.HistoryMapper;

@Service
public class HistoryService {
	@Autowired
	private HistoryMapper historyMapper;
	
	public void saveHistory(History history) {
		historyMapper.insert(history);
	}
	
	public List<History> selectHistory() {
		List<History> list=historyMapper.selectByExample(null);
		return list;
	}
	
	public void deleteHistory(Integer historyId) {
		historyMapper.deleteByPrimaryKey(historyId);
	}
	
	public void updateHistory(History history) {
		historyMapper.updateByPrimaryKeySelective(history);
	}

}
