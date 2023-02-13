package springweb.mvc.a02_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb.mvc.a03_dao.A02_ProductDao;
import springweb.vo.OvMember;
import springweb.vo.OvProduct;
@Service
public class A02_ProductService {
	@Autowired
	private A02_ProductDao dao;
	public List<OvProduct> OvProductList(OvProduct sch){
		if(sch.getProdNo()==null) sch.setProdNo("");
		if(sch.getCtgNo()==null) sch.setCtgNo("");
		if(sch.getPrdName()==null) sch.setPrdName("");
		if(sch.getPrdKind()==null) sch.setPrdKind("");
		if(sch.getPrdPrice()==0) sch.setPrdPrice(0);
		if(sch.getPrdImg()==null) sch.setPrdImg("");
		if(sch.getPrdDescript()==null) sch.setPrdDescript("");
		return dao.OvProductList(sch);
}
	public OvProduct getOvProduct(String prodNo) {
		return dao.getOvProduct(prodNo);
	}
	public void insertOvProduct(OvProduct ins) {
		dao.insertOvProduct(ins);
	}
	public void deleteOvProduct(String prodNo) {
		dao.deleteOvProduct(prodNo);
	}
}