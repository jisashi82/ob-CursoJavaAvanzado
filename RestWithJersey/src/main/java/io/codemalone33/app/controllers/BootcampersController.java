package io.codemalone33.app.controllers;

import java.net.URI;
import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import io.codemalone33.app.models.Bootcamper;
import io.codemalone33.app.services.BootcamperService;

@Component
@Path("/")
public class BootcampersController {

	private BootcamperService bootcamperService;

	public BootcampersController(BootcamperService bootcamperService) {
		this.bootcamperService = bootcamperService;
	}

	@GET
	public String hola() {
		return "hola";
	}

	@GET
	@Path("/bootcampers")
	@Produces("application/json")
	public List<Bootcamper> getAll() {
		return bootcamperService.getAll();
	}
	
	@GET
	@Path("/bootcampers/{name}")
	@Produces("text/json")
	public Bootcamper getOne(@PathParam("name") String name) {
		return bootcamperService.getBootcamper(name);
	}


	@POST
	@Path("/bootcampers")
	@Produces("application/json")
	@Consumes("application/json")
	public Response agregarBootcamper(Bootcamper b) {
		bootcamperService.add(b);
		return Response.created(URI.create("/bootcampers" + b.getNombre())).build();
	}
}
