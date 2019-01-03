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

@Path("bird")
@Stateless
public class BirdRESTService {

	@Inject
	private BirdManager bm;

	@GET
	@Path("/{birdId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Bird getBird(@PathParam("birdId") Integer id) {
		Bird b = bm.getBird(id);
		return b;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bird> getBirds() {
		return bm.getAllBirds();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBird(Bird bird) {
		bm.addBird(bird);

		return Response.status(201).entity("Bird").build();
	}

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "REST API /bird is running today!";
	}

	@DELETE
	public Response clearBirds() {
		bm.deleteAllBirds();
		return Response.status(200).build();
	}

}
