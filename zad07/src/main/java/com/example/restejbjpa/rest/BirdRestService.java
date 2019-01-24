package com.example.restejbjpa.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restejbjpa.domain.Bird;
import com.example.restejbjpa.service.BirdManager;


@Path("bird")
public class BirdRestService {
	
	@EJB
	BirdManager bm;

	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Bird getBird(@PathParam("id") Long id){
		
		Bird retrieved = bm.getBird(id);
		
		//retrieved.setAuthors(bm.getAuthorsOfBook(id));
		
		//System.out.println("Authors :" + retrieved.getAuthors().size());
		
		return retrieved;
	}
	
	
	@DELETE
	public Response deletAll(){
		bm.deletAllBirds();
		return Response.status(Response.Status.OK).build();
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
//
//	@GET
//	@Path("/test")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String test() {
//		return "REST API /bird is running today!";
//	}
//
//	@DELETE
//	public Response clearBirds() {
//		bm.deleteAllBirds();
//		return Response.status(200).build();
//	}
	
	@DELETE
	@Path("/{birdId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteBird(@PathParam("birdId") Integer id) {
		//bm.deleteBird(id);
		return Response.status(200).build();
	}

}
