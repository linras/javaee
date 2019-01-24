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
import com.example.restejbjpa.domain.Owner;
import com.example.restejbjpa.domain.Tail;
import com.example.restejbjpa.domain.Toy;
import com.example.restejbjpa.service.BirdManager;


@Path("owner")
public class OwnerRestService {

	@EJB
	BirdManager bm;

	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Owner getOwner(@PathParam("id") Long id){
		Owner retrieved = bm.getOwner(id);
		
		return retrieved;
	}
	
	@GET
	@Path("/mostColorfull")
	@Produces(MediaType.APPLICATION_JSON)
	public Owner getMostColorfull(){
		Owner retrieved = bm.findMostColorfullOwner();
		return retrieved;
	}
	
	@GET
	@Path("/manyToys")
	@Produces(MediaType.APPLICATION_JSON)
	public Owner getManyToys(){
		Owner retrieved = bm.findManyToys();
		return retrieved;
	}
	
	@GET
	@Path("/manyToys/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Owner> getManyToys(@PathParam("id") Long id){
		List<Owner> retrieved = bm.findManyToys(id.intValue());
		return retrieved;
	}
	
	
	@DELETE
	public Response deletAllOwners(){
		bm.deletAllOwners();
		return Response.status(Response.Status.OK).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Owner> getOwners() {
		return bm.getAllOwners();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addOwner(Owner owner) {
		bm.addOwner(owner);

		return Response.status(201).entity("Owner").build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addOwners(List<Owner> list) {
		for(Owner o : list)
			bm.addOwner(o);

		return Response.status(201).entity("Owner").build();
	}

}