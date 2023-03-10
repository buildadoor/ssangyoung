package springweb.mvc.a02_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb.mvc.a03_dao.A01_MemberDao;
import springweb.vo.OvMember;
@Service
public class A01_MemberService {
	@Autowired
	private A01_MemberDao dao;
	public List<OvMember> OvMemberList(OvMember sch){
		if(sch.getId()==null) sch.setId("");
		if(sch.getAuth()==null) sch.setAuth("");
		if(sch.getNickname()==null) sch.setNickname("");
		if(sch.getAddress()==null) sch.setAddress("");
		if(sch.getPoint()==0) sch.setPoint(0);
		return dao.OvMemberList(sch);
}
	public OvMember getOvMember(String id) {
		return dao.getOvMember(id);
	}
	public void insertOvMember(OvMember ins) {
		dao.insertOvMember(ins);
	}
	public void deleteOvMember(String id) {
		dao.deleteOvMember(id);
	}
	public OvMember idChk(String id) {
		return dao.idChk(id);
	}
	public OvMember login(OvMember ov) {
		return dao.login(ov);
	}
}