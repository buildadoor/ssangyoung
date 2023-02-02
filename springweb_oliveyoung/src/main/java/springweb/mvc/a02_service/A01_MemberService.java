package springweb.mvc.a02_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb.mvc.a03_dao.A01_MemberDao;
import springweb.vo.OvMember;
import springweb.vo.OvMemberInit;

@Service
public class A01_MemberService {
	@Autowired
	private A01_MemberDao dao;
	
	public List<OvMember> getOvMemberList(OvMember sch){
		if(sch.getId()==null) sch.setId("");
		return dao.getOvMemberList(sch);
}
	public List<OvMemberInit> getOvMemberAll(){
		return dao.getOvMemberAll();
	}
}