package controller;

import java.util.ArrayList;

import entity.UserDTO;
import entity.passwordGenerator;
import database.MySQLAccess;



public class UserStore implements IUserDAO{
	
	MySQLAccess sql = new MySQLAccess();
	passwordGenerator pg = new passwordGenerator();
	
	static ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
	
	public UserStore() {
		
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
	public void createUser(UserDTO user) throws DALException {
		user.setPassword(pg.createPassword());
		userList.add(user);
		//sql.writeUser(user.toString(), user.getUserId());
		System.out.println(user.toString());
		System.out.println(userList.toString());
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
