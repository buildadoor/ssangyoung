package springweb.mvc.a03_dao;

import java.util.List;

import springweb.vo.OvMember;
import springweb.vo.OvMemberInit;
// springweb.a05_mvc.a03_dao.A01_EmpDao
public interface A01_MemberDao {
	public List<OvMember> getOvMemberList(OvMember sch);
	public List<OvMemberInit> getOvMemberAll();
	
}