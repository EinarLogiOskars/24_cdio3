package dbImplementations;

import java.sql.SQLException;
import java.util.ArrayList;

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
	public ArrayList<UserDTO> getUserList() throws DALException {
		return userList;
	}
	
	@Override
	public void createUser(UserDTO user) {
		try {
			MySQLAccess.doUpdate("INSERT INTO users(userID, name, initials, password, cpr, roles) VALUES "
					+ "(" + user.getUserId() + ", '" + user.getUserName() + "', '" + user.getIni().toUpperCase() + "', '" + new passwordGenerator().createPassword()
					+ "', '" + user.getCpr() + "', '" + user.getRoles().toString() + "')");
		} catch (DALException e) { e.printStackTrace(); }
	}

	@Override
	public void updateUser(UserDTO user) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int userId) throws DALException {
		// TODO Auto-generated method stub
		
	}

	


}
