package com.exem9.lms.web.maintenance.service;

import java.util.HashMap;
import java.util.List;

import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exem9.lms.web.common.bean.SupoBean;
import com.exem9.lms.web.common.dao.ICommonDao;
import com.exem9.lms.web.maintenance.dao.IMatDao;
import com.exem9.lms.web.member.bean.MemberBean;
import com.exem9.lms.web.member.dao.IMemberDao;



@RemoteProxy(name="MatService")
@Service(value="IMatService")
public class MatService implements IMatService{
	
	@Autowired
	public IMatDao iMatDao;
	
	@Autowired
	public ICommonDao iCommonDao;
	
	@Autowired
	public IMemberDao iMemberDao;
	
	public List<SupoBean> getSupolevel() throws Throwable {
		// TODO Auto-generated method stub
		return iCommonDao.getSupolevel();
	}

	public List<SupoBean> getSupovisit(String supoId) throws Throwable {
		
		HashMap params = new HashMap();
		
		if(supoId == ""){
			params.put("supoId",supoId);
		}else{
			params.put("supoId",Integer.parseInt(supoId));
		}
		
		return iCommonDao.getSupovisit(params);
	}
/*	public List getdbms() throws Throwable {
		
		// TODO Auto-generated method stub
		return iDbmsDao.getdbms();
	}*/

	public List<MemberBean> getUsermember(String userTeam) throws Throwable {
		
		HashMap params = new HashMap();
		params.put("userTeam",Integer.parseInt(userTeam));
		
		return iMemberDao.getUsermember(params);
	}

}
