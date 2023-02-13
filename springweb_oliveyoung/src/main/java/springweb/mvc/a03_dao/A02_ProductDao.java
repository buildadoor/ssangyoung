package springweb.mvc.a03_dao;

import java.util.List;

import springweb.vo.OvProduct;

public interface A02_ProductDao {
	public List<OvProduct> OvProductList(OvProduct sch);
	public OvProduct getOvProduct(String prodNo);	
	public void insertOvProduct(OvProduct ins);
	public void deleteOvProduct(String prodNo);
}
