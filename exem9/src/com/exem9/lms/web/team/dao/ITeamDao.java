package com.exem9.lms.web.team.dao;

import java.util.HashMap;
import java.util.List;

import com.exem9.lms.web.dbms.bean.DbmsBean;
import com.exem9.lms.web.mypage.bean.MypageBean;
import com.exem9.lms.web.team.bean.TeamBean;

public interface ITeamDao {

	public List<TeamBean> getteam(HashMap params) throws Throwable;
	
	public List<TeamBean> getteam1() throws Throwable;

	public List<TeamBean> getdeptteam(HashMap params) throws Throwable ;

}
