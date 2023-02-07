package springweb.mvc.a03_dao;

import java.util.List;

import springweb.vo.OvMember;
// springweb.a05_mvc.a03_dao.A01_EmpDao
public interface A01_MemberDao {
	public List<OvMember> OvMemberList(OvMember sch);
	public void insertOvMember(OvMember ins);
}
