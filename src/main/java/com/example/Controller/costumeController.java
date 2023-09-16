package com.example.Controller;

import com.example.costumes.Costume;
import com.example.costumes.costumesRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.bson.types.ObjectId;

import java.net.URI;
import java.net.URISyntaxException;

@Path("/costumers")
public class costumeController {
    @Inject
    costumesRepository repository;

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") String id){
        Costume costume =  repository.findById(new ObjectId(id));
        return Response.ok().build();
    }

    @GET
    public Response get(){
        return Response.ok(repository.listAll()).build();
    }

    @GET
    @Path("/search/{name}")
    public Response search (@PathParam("name") String name) {
        Costume costume = repository.findByName(name);
        return costume  != null ? Response.ok(costume).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public  Response create(Costume costume) throws URISyntaxException {
        repository.persist(costume);
        return Response.created(new URI("/" + costume.id)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") String id, Costume costume){
        costume.id = new ObjectId(id);
        repository.update(costume);
        return Response.ok(costume).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
            Costume costume = repository.findById(new ObjectId(id));
            repository.delete(costume);
            return Response.noContent().build();
    }

}
