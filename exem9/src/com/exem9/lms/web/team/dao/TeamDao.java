package com.exem9.lms.web.team.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exem9.lms.web.mypage.bean.MypageBean;
import com.exem9.lms.web.team.bean.TeamBean;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository(value="ITeamDao")
public class TeamDao implements ITeamDao{
	@Autowired
	public SqlMapClient sqlMapClient;

	public List<TeamBean> getteam(HashMap params) throws Throwable {
		// TODO Auto-generated method stub
		return sqlMapClient.queryForList("team.getUserteam",params);
	}
	
	public List<TeamBean> getteam1() throws Throwable {
		// TODO Auto-generated method stub
		return sqlMapClient.queryForList("team.getteam");
	}

	public List<TeamBean> getdeptteam(HashMap params) throws Throwable {
		// TODO Auto-generated method stub
		return sqlMapClient.queryForList("team.getDeptteam",params);
	}
	
}
