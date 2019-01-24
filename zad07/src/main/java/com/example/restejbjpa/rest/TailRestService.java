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
import com.example.restejbjpa.domain.Tail;
import com.example.restejbjpa.domain.Toy;
import com.example.restejbjpa.service.BirdManager;


@Path("tail")
public class TailRestService {

	@EJB
	BirdManager bm;

	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Tail getTail(@PathParam("id") Long id){
		Tail retrieved = bm.getTail(id);
		
		return retrieved;
	}
	
	
	@DELETE
	public Response deletAllTails(){
		bm.deletAllTails();
		return Response.status(Response.Status.OK).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tail> getTails() {
		return bm.getAllTails();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addTail(Tail tail) {
		bm.addTail(tail);

		return Response.status(201).entity("Tail").build();
	}

}