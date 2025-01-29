package DAOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.OrdersDAO;
import model.Orders;

public class OrdersDAOimpl implements OrdersDAO{
	String url="jdbc:mysql://localhost:3306/clothshopping";
	String dbuser="root";
	String dbpass="kandmule";
	private Connection con;
	
	public OrdersDAOimpl() throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url, dbuser, dbpass);
	}
	//insert the data
	String INSERT="insert into orders(user_id,type_id,total_amount,status,payment_mode) values(?,?,?,?,?)";
	private PreparedStatement pstmt;
	
	@Override
	public int addOrder(Orders order) {
        int status = 0;  // Default value (0 = failure)
	    
	    try {
	        // Prepare the SQL statement with the INSERT query
	        pstmt = con.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);  // Enable key generation
	        
	        // Set the parameters for the order details
	        pstmt.setInt(1, order.getUserId());
	        pstmt.setInt(2, order.getTypeId());
	        pstmt.setInt(3, order.getTotalAmount());
	        pstmt.setString(4, order.getStatus());
	        pstmt.setString(5, order.getPaymentMode());
	        
	        // Execute the update statement
	        int rowsAffected = pstmt.executeUpdate();
	        
	        // If the insert is successful, retrieve the auto-generated orderId
	        if (rowsAffected > 0) {
	            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    int orderId = generatedKeys.getInt(1);  // Get the generated orderId
	                    order.setOrderId(orderId);  // Set the orderId in the Order object
	                    status = 1;  // Set status to success
	                }
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return status;
	}

	//fetching the data all
		String FETCH="select * from orders";
		private ResultSet resultSet;
		private Statement stmt;
		static ArrayList<Orders>orderList=new ArrayList<>();
		
	@Override
	public ArrayList<Orders> fetchAll() {
		try
		{
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(FETCH);
			orderList=extractUseListFromResultSet(resultSet);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return orderList;
	}

	//fetching the data of specific
		String fetchOne="select * from orders where order_id=?";
		Orders o;
	@Override
	public Orders fetchOne(int id) {
		try
		{
			pstmt=con.prepareStatement(fetchOne);
			pstmt.setInt(1, id);			
			resultSet=pstmt.executeQuery();
			o=extractUseListFromResultSet(resultSet).get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return o;
	}
    
	//updating the data
		String UPDATE="update orders set status=? where order_id=?";
	@Override
	public int update(int id, String name) {
		try 
		{
			pstmt.setString(1, name);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;

	}
     
	//deleting the data
		String DELETE="delete from order where order_id=?";
	@Override
	public int delete(int id) {
		try
		{
			pstmt=con.prepareStatement(DELETE);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	// extracting user list from resultSet
				ArrayList<Orders> extractUseListFromResultSet(ResultSet resultSet) {
					try
					{
						
					   while(resultSet.next())
					   {
						 orderList.add(new Orders(
								 resultSet.getInt("order_id"),
								 resultSet.getInt("user_id"),       // Fetch userId from the result set
						            resultSet.getInt("type_id"),// Fetch restaurantId from the result set
						            resultSet.getTimestamp("order_date"),// Fetch orderDate from the result set
						            resultSet.getInt("total_amount"), // Fetch totalAmount from the result set
						            resultSet.getString("status"),   // Fetch status from the result set
						            resultSet.getString("payment_mode") 
								 ));
					   }
					
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					return orderList;
				}
}
