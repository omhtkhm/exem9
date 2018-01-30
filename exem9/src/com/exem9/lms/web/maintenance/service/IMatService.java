package com.exem9.lms.web.maintenance.service;

import java.util.List;

import com.exem9.lms.web.common.bean.SupoBean;
import com.exem9.lms.web.member.bean.MemberBean;



public interface IMatService {	
	/*고객사 수정 이벤트 계약상태 리스트 데이터 가져오기 (SupoDao 연계) */
	public List<SupoBean> getSupolevel() throws Throwable;

	/*고객사 수정 이벤트 방문주기 리스트 데이터 가져오기 (SupoDao 연계) */
	public List<SupoBean> getSupovisit(String supoId)throws Throwable;

	public List<MemberBean> getUsermember(String userTeam) throws Throwable ;
}
