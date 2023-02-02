package a01_diexp.z08_mydb;

import java.util.List;

import a01_diexp.z08_mydb.vo.BuyInfo;
import a01_diexp.z08_mydb.vo.Dept;
import a01_diexp.z08_mydb.vo.Emp;
import a01_diexp.z08_mydb.vo.EmpDeptCom;
import a01_diexp.z08_mydb.vo.EmpSalGd;
import a01_diexp.z08_mydb.vo.Member;
import a01_diexp.z08_mydb.vo.Salgrade;

public interface A02_ExpDao {
	public List<Salgrade> getSalgrade();
	public List<EmpDeptCom> getEmpDeptList();
	public List<EmpSalGd> getEmpSalgrade();
	public void insertEmp(Emp ins);
	public Emp getEmp(int empno);
	public void deleteEmp(int empno);
	public List<Member> getMemberList();
	public void insertDept(Dept ins);
	public Dept getDept(int dept);
	public void deleteDept(int deptno);
	public void deleteMember(String id);
	public List<BuyInfo> getBuyInfo();


}
