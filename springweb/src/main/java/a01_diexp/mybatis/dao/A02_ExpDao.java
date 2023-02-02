package a01_diexp.mybatis.dao;

import java.util.List;

import springweb.z01_vo.Dept;
import springweb.z01_vo.Emp;

public interface A02_ExpDao {
	public List<Emp> getEmpData();
	public List<Emp> getHw01();
	public List<Dept> getHw02();
}
