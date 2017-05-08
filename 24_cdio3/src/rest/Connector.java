package rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import controller.IUserDAO.DALException;
import controller.UserStore;
import entity.UserDTO;


@Path("/cdio3")
public class Connector {


	String lol = "Total lol!";

	UserStore us = new UserStore();

	@POST
	@Path("/createuser")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean newUser(UserDTO user) {

		System.out.println(user);

		return true;
	}


	@GET
	@Path("/showusers")
	@Produces (MediaType.APPLICATION_JSON)
	public ArrayList<UserDTO> showUsers() {
		ArrayList<UserDTO> list = new ArrayList<UserDTO>();
		try {list = us.getUserList(); } 
		catch (DALException e) {e.printStackTrace(); }
		return list;
	}

}
