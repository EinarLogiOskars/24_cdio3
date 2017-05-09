package rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
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
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
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
	

//	@GET
//	@Path("/showusers")
//	@Produces (MediaType.APPLICATION_JSON)
//	public ArrayList<UserDTO> showUsers() {
//		ArrayList<UserDTO> list = new ArrayList<UserDTO>();
//		try {list = us.getUserList(); } 
//		catch (DALException e) {e.printStackTrace(); }
//		return list;
//	}

}
