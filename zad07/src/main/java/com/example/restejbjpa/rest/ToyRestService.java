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
import com.example.restejbjpa.domain.Toy;
import com.example.restejbjpa.service.BirdManager;


@Path("toy")
public class ToyRestService {
	
	@EJB
	BirdManager bm;

	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Toy getToy(@PathParam("id") Long id){
		Toy retrieved = bm.getToy(id);
		
		return retrieved;
	}
	
	
	@DELETE
	public Response deletAllToys(){
		bm.deletAllToys();
		return Response.status(Response.Status.OK).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Toy> getToys() {
		return bm.getAllToys();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addToy(Toy toy) {
		bm.addToy(toy);

		return Response.status(201).entity("Toy").build();
	}

}
