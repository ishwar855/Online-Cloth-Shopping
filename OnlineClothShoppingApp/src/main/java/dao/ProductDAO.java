package dao;

import java.util.List;

import model.Products;



public interface ProductDAO {
	public List<Products> fetchOne(int type_id);
}
