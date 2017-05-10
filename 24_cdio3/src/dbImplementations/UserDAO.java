package dbImplementations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbconnection.MySQLAccess;
import entity.UserDTO;
import entity.passwordGenerator;



public class UserDAO implements IUserDAO{
	
	
	
	static ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
	
	public UserDAO() {
		try { new MySQLAccess(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
	}

	@Override
	public UserDTO getUser(int userId) throws DALException {
		return userList.get(userId);
	}
	
	@Override
	public List<UserDTO> getUserList() throws DALException {
		ResultSet rs = MySQLAccess.doQuery("SELECT * FROM users");
		List<UserDTO> userList1 = new ArrayList<UserDTO>();
		
		try {
			while (rs.next()){
				UserDTO user = new UserDTO();
				user.setUserId(rs.getInt("userID"));
				user.setUserName(rs.getString("name"));
				user.setIni(rs.getString("initials"));
				user.setCpr(rs.getString("cpr"));
				user.setPassword(rs.getString("password"));
				String roles = rs.getString("roles");
				List<String> rolesList = new ArrayList<String>();
				if (roles.contains("Admin"))
					rolesList.add("Admin");
				if (roles.contains("Operator"))
					rolesList.add("Operator");
				if (roles.contains("Foreman"))
					rolesList.add("Foreman");
				if (roles.contains("Pharmacist"))
					rolesList.add("Pharmacist");
				user.setRoles(rolesList);
				userList1.add(user);
			}
		} catch (SQLException e) { e.printStackTrace(); }
		
		return userList1;
	}
	
	@Override
	public void createUser(UserDTO user) {
		try {
			MySQLAccess.doUpdate("INSERT INTO users(userID, name, initials, password, cpr, roles) VALUES "
					+ "(" + user.getUserId() + ", '" + user.getUserName() + "', '" + user.getIni().toUpperCase() + "', '" + new passwordGenerator().createPassword()
					+ "', '" + user.getCpr() + "', '" + user.getRoles() + "')");
		} catch (DALException e) { e.printStackTrace(); }
	}

	@Override
	public void updateUser(UserDTO user) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int userId) throws DALException {
		MySQLAccess.doUpdate("DELETE FROM USERS WHERE userID = " + userId);		
	}
	
	@Override
	public ArrayList<Integer> getUserIds() throws DALException {
		ArrayList<Integer> userIds = new ArrayList<Integer>();
		
		ResultSet rs = MySQLAccess.doQuery("SELECT userID FROM users");
		
		try {
			while(rs.next()){
				userIds.add(rs.getInt("userID"));
			}
		} catch (SQLException e) { e.printStackTrace(); }
		
		return userIds;
	}
	

}
