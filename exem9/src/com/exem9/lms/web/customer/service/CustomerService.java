package com.exem9.lms.web.customer.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exem9.lms.common.CommonProperties;
import com.exem9.lms.web.common.bean.LineBoardBean;
import com.exem9.lms.web.common.bean.SupoBean;
import com.exem9.lms.web.common.dao.ICommonDao;
import com.exem9.lms.web.customer.bean.CustomerBean;
import com.exem9.lms.web.customer.bean.CustomerMemberBean;
import com.exem9.lms.web.customer.dao.ICustomerDao;
import com.exem9.lms.web.dbms.bean.DbmsBean;
import com.exem9.lms.web.department.bean.DeptBean;
import com.exem9.lms.web.department.dao.IDeptDao;
import com.exem9.lms.web.member.bean.MemberBean;
import com.exem9.lms.web.member.dao.IMemberDao;
import com.exem9.lms.web.mypage.bean.MypageBean;
import com.exem9.lms.web.mypage.dao.IMypageDao;
import com.exem9.lms.web.team.bean.TeamBean;
import com.exem9.lms.web.team.dao.ITeamDao;
import com.exem9.lms.web.dbms.dao.IDbmsDao;
import com.exem9.lms.web.dbms.bean.DbmsBean;


@RemoteProxy(name="ICustomerService")
@Service(value="ICustomerService")
public class CustomerService implements ICustomerService{
	
	@Autowired
	public ICustomerDao iCustomerDao;
	
	@Autowired
	public IMypageDao iMypageDao;	

	@Autowired
	public IDeptDao iDeptDao;
	
	@Autowired
	public IDbmsDao iDbmsDao;
	
	@Autowired
	public ITeamDao iTeamDao;
	
	@Autowired
	public IMemberDao iMemberDao;
	
	@Autowired
	public ICommonDao iCommonDao;
	
	public List<MypageBean> getUserinfo(String userId) throws Throwable {
		return iMypageDao.getUserinfo(userId);
		// TODO Auto-generated method stub	
	}

	public List<DeptBean> getdept() throws Throwable {
		// TODO Auto-generated method stub
		return iDeptDao.getdept();
	}

	public List<DbmsBean> getdbms() throws Throwable {
		// TODO Auto-generated method stub
		return iDbmsDao.getdbms();
	}

	public List<SupoBean> getsupo() throws Throwable {
		// TODO Auto-generated method stub
		return iCustomerDao.getsupo();
	}

	public List<CustomerBean> getcusinfo(String selectBtnVal, String selectTextVal, int pageNo) throws Throwable {
		
		HashMap params = new HashMap();
						
		params.put("selectBtnVal", Integer.parseInt(selectBtnVal));
		params.put("selectTextVal",selectTextVal);
		params.put("viewCount", CommonProperties.VIEWCOUNT);
		
		int startNo = 1+(CommonProperties.VIEWCOUNT * (pageNo-1));
		int endNo = CommonProperties.VIEWCOUNT * pageNo;
		
		if(pageNo == 1){
			params.put("pageNo", ""); 
		}else{
			params.put("pageNo", pageNo);
		}
		
		params.put("startNo", startNo);
		params.put("endNo", endNo);
		
		return iCustomerDao.getcusinfo(params);
	}

	public LineBoardBean getNCount(String selectBtnVal, String selectTextVal, int nowPage) throws Throwable {
		
		HashMap params = new HashMap();
			
		params.put("selectBtnVal", Integer.parseInt(selectBtnVal));
		params.put("selectTextVal",selectTextVal);
		
		int nCount = iCustomerDao.getNCount(params);
		int maxPage=0;
		int startPage=0;
		int endPage=0;
		int nowpage=0;
		
		if(nowPage == 0){
			nowpage = 1;
		}else if(nowPage != 0){
			nowpage = nowPage;
		}		
		
		if(nCount % CommonProperties.VIEWCOUNT == 0){
			maxPage = nCount / CommonProperties.VIEWCOUNT;
		}else{
			maxPage = (nCount / CommonProperties.VIEWCOUNT) + 1;
		}
		
		startPage = nowpage / CommonProperties.PAGECOUNT + 1;
		endPage = startPage + CommonProperties.PAGECOUNT -1;
		
		if(endPage > maxPage){
			endPage = maxPage;
		}		
		
		LineBoardBean lbb = new LineBoardBean();
		lbb.setStartPage(startPage);
		lbb.setEndPage(endPage);
		lbb.setMaxPage(maxPage);
		lbb.setNowPage(nowpage);
		return lbb;
	}
	
	public List<TeamBean> getteam(String userDept) throws Throwable {
		// TODO Auto-generated method stub
		HashMap params = new HashMap();
		params.put("userDept",Integer.parseInt(userDept));
		
		
		return iTeamDao.getteam(params);
	}

	public List<DbmsBean> getdbms(String userDept) throws Throwable {
		
		HashMap params = new HashMap();
		params.put("userDept",Integer.parseInt(userDept));
		
		return iDbmsDao.getdbms(params);
	}

	public List<MemberBean> getUsermember(String userTeam) throws Throwable {
		
		HashMap params = new HashMap();
		params.put("userTeam",Integer.parseInt(userTeam));
		
		return iMemberDao.getUsermember(params);
	}

	public List<MemberBean> getSalsemember() throws Throwable {
		// TODO Auto-generated method stub
		return iMemberDao.getSalsemember();
	}

	public String updateCusInfo(String userId, int cusproId, int cususer, String cuslocation,   String salseman, String etc) throws Throwable {
		
		HashMap params = new HashMap();
		params.put("userId", userId);
		params.put("cusproId", cusproId);
		params.put("cususer", cususer);
		params.put("cuslocation",cuslocation);
		params.put("salseman", salseman);
		params.put("etc", etc);		
		
		return iCustomerDao.updateCusInfo(params);
	}

	//고객사 정보 등록 시 부서 리스트 가져오기
	public List<TeamBean> getteam1() throws Throwable {
		// TODO Auto-generated method stub
		return iTeamDao.getteam1();
	}

	//고객사 정보 등록시 담당부서에 해당 하는 팀정보 가져오기
	public List<TeamBean> getdeptteam(String deptId) throws Throwable {
		// TODO Auto-generated method stub
		HashMap params = new HashMap();
		params.put("deptId",Integer.parseInt(deptId));
		
		
		return iTeamDao.getdeptteam(params);
	}

	public List<DbmsBean> getdeptdbms(String deptId) throws Throwable {
		
		HashMap params = new HashMap();
		params.put("deptId",Integer.parseInt(deptId));
		
		return iDbmsDao.getdeptdbms(params);
	}
	
	public List<MemberBean> getteamuser(String teamId) throws Throwable {
		
		HashMap params = new HashMap();
		params.put("teamId",Integer.parseInt(teamId));
		
		return iMemberDao.getteamuser(params);
	}
	
	public List<MemberBean> getteamuser1(String teamId, String userId) throws Throwable {
		
		HashMap params = new HashMap();
		params.put("teamId",Integer.parseInt(teamId));
		params.put("userId",userId);
		
		return iMemberDao.getteamuser1(params);
	}

	public List<CustomerBean> getcusNminfo() throws Throwable {
		// TODO Auto-generated method stub
		return iCustomerDao.getcusNminfo();
	}

	public List<CustomerBean> getcusNmProinfo(String cusNm, String cusProNm) throws Throwable {
		// TODO Auto-generated method stub
		HashMap params = new HashMap();
		params.put("cusNm",cusNm);
		params.put("cusProNm",cusProNm);
		
		return iCustomerDao.getcusNmProinfo(params);
	}

	public List<CustomerBean> getcusNmUserinfo(String cusNm) throws Throwable {
		
		HashMap params = new HashMap();
		params.put("cusNm",cusNm);
		
		return iCustomerDao.getcusNmUserinfo(params);
	}

	public List<CustomerMemberBean> getcusUserinfo(String cusUser,String cusId, String cusUserId) throws Throwable {
		HashMap params = new HashMap();
		params.put("cusUser",cusUser);
		
		if(cusId.equals("0")){
			params.put("cusId","");
		}else{
			params.put("cusId",Integer.parseInt(cusId));
		}
		
		/*System.out.println(cusUserId);*/
		if(cusUserId.equals("0")){
			params.put("cusUserId","");
		}else{
			params.put("cusUserId",Integer.parseInt(cusUserId));
		}
		
		return iCustomerDao.getcusUserinfo(params);
	}

	public String insertCusinfo(String cusNm_hidden, String cusUser_hidden,
			String cusNm, String cusproNm, String cususerNm,
			String cususerPhone, String cususerMail, String cuslocation,
			String salesmanId, String etc) throws Throwable {
		
		WebContext wctx = WebContextFactory.get();
		HttpServletRequest request = wctx.getHttpServletRequest();
		HttpSession session = request.getSession();	
		
		HashMap params = new HashMap();
		params.put("userId", (String)session.getAttribute("sUserId"));
		params.put("cusNm_hidden",Integer.parseInt(cusNm_hidden));
		params.put("cusUser_hidden",Integer.parseInt(cusUser_hidden));
		params.put("cusNm",cusNm.toUpperCase());
		params.put("cusproNm",cusproNm.toUpperCase());		

		
		params.put("cuslocation",cuslocation.toUpperCase());
		params.put("cususerNm",cususerNm);
		params.put("cususerPhone",cususerPhone);
		params.put("cususerMail",cususerMail);
		
		params.put("salesmanId",salesmanId);
		
		params.put("etc",etc);
		
	/*	System.out.println(cusNm_hidden);
		System.out.println(cusUser_hidden);
		System.out.println(supoinsdate);
		System.out.println(supostartdate);
		System.out.println(supoenddate);*/
	
		
		if(Integer.parseInt(cusNm_hidden)  > 0){
			if(Integer.parseInt(cusUser_hidden) > 0){
				/*System.out.println("신규1");*/
				return iCustomerDao.insertCusinfo1(params);
			}else{
			/*	System.out.println("신규2");*/
				return iCustomerDao.insertCusinfo2(params);
			}
		}else{
			/*System.out.println("신규3");*/
			return iCustomerDao.insertCusinfo3(params);
		}
	}
}

