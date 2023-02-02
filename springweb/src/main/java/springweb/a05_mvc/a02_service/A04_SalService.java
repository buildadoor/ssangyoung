package springweb.a05_mvc.a02_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb.a05_mvc.a03_dao.A04_SalDao;
import springweb.z01_vo.Salgrade;
@Service
public class A04_SalService {
	@Autowired(required=false)
	private A04_SalDao dao;
	
	public List<Salgrade> getSalList(){
		return dao.getSalList();
	}
	public Salgrade getSalgrade(int grade) {
		return dao.getSalgrade(grade);
	}

}
