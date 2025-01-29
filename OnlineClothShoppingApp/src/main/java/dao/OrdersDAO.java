package dao;

import java.util.ArrayList;

import model.Orders;


public interface OrdersDAO {
	int addOrder(Orders order); 
    ArrayList<Orders> fetchAll();
    Orders fetchOne(int id);
    int update(int id,String name);
    int delete(int id);
}
