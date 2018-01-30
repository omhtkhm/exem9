package com.exem9.lms.web.member.dao;

import java.util.HashMap;
import java.util.List;

import com.exem9.lms.web.member.bean.MemberBean;
import com.exem9.lms.web.mypage.bean.MypageBean;
import com.exem9.lms.web.team.bean.TeamBean;

public interface IMemberDao {

	public List<MemberBean> getUsermember(HashMap params) throws Throwable;

	public List<MemberBean> getSalsemember()throws Throwable;

	public List<MemberBean> getteamuser(HashMap params) throws Throwable ;
	
	public List<MemberBean> getteamuser1(HashMap params) throws Throwable ;
}
