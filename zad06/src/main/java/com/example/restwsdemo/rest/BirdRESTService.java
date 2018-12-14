package com.example.restwsdemo.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restwsdemo.domain.Bird;
import com.example.restwsdemo.service.BirdManager;

@Path("person")
@Stateless
public class BirdRESTService {

	@Inject
	private BirdManager pm;

	@GET
	@Path("/{personId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Bird getPerson(@PathParam("personId") Integer id) {
		Bird p = pm.getBird(id);
		return p;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bird> getPersons() {
		return pm.getAllBirds();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPerson(Bird bird) {
		pm.addBird(bird);

		return Response.status(201).entity("Bird").build();
	}

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "REST API /person is running today!";
	}

	@DELETE
	public Response clearPersons() {
		pm.deleteAllBirds();
		return Response.status(200).build();
	}

}
