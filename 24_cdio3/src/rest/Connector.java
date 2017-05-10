package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dbImplementations.IUserDAO;
import dbImplementations.UserDAO;
import dbImplementations.IUserDAO.DALException;
import entity.UserDTO;


@Path("/cdio3")
public class Connector {


	private IUserDAO us = new UserDAO();

	@POST
	@Path("/createuser")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean newUser(UserDTO user){
		
		try {
			us.createUser(user);
		} catch (DALException e) { System.out.println(e.getMessage()); }
		return true;
	}

	
	@GET
	@Path("/userids")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Integer> getTakenIds() {
		ArrayList<Integer> userIds = new ArrayList<Integer>();
		try {
			userIds = us.getUserIds();
		} catch (DALException e) { e.printStackTrace(); }
		return userIds;
	}
	
	
	@GET
	@Path("/showusers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDTO> getUserList(){
		List<UserDTO> userList = new ArrayList<UserDTO>();
		try {
			userList = us.getUserList();
		} catch (DALException e) { e.printStackTrace(); }
		return userList;
	}
	
	
	@DELETE
	@Path("/deleteuser/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean deleteUser(@PathParam("userId") int userId){
		try {
			us.deleteUser(userId);
		} catch (DALException e) { e.printStackTrace(); }
		return true;
	}
	
	
	@GET
	@Path("/users/{userID}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserDTO getUser(@PathParam("userID") int userID){
		UserDTO user = new UserDTO();
		try {
			user = us.getUser(userID);
		} catch (DALException e) { e.printStackTrace(); }
		
		return user;
	}
	
	
	@POST
	@Path("/updateuser")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean updateUser(UserDTO user){
		try {
			us.updateUser(user);
		} catch (DALException e) { e.printStackTrace(); }
		return true;
	}

}
