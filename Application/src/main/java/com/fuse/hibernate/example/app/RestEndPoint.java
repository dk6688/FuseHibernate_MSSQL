package com.fuse.hibernate.example.app;

import com.fuse.hibernate.example.model.Person;
import com.fuse.hibernate.example.service.PersonServiceImpl;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.math.BigInteger;

@Service
@Path("/personservice/")
public class RestEndPoint {

    @Reference
    private PersonServiceImpl personService;
    static Logger LOG = LoggerFactory.getLogger(ExchangeProcessor.class);

    @GET
    @Path("/persons/{id}/")
    @Produces("application/xml")
    public Person getPerson(@PathParam("id") String id) {
        LOG.info("----invoking getPerson, Person name is: " + id);
        Person c = personService.findPerson(BigInteger.valueOf(Long.valueOf(id)));
        return c;
    }

    @PUT
    @Path("/persons/")
    public Response updatePerson(Person person) {
        LOG.info("----invoking updatePerson, Person name is: " + person.getName());
        Person c = personService.findPerson(person.getId());
        Response r;
        if (c != null) {
            personService.updateCustomer(person);
            r = Response.ok().build();
        } else {
            r = Response.notModified().build();
        }

        return r;
    }

    @POST
    @Path("/persons/")
    public Response addPerson(Person person) {
        LOG.info("----invoking addPerson, Person name is: " + person.getName());

        Person saved=personService.createPerson(person);

        return Response.ok().type("application/xml").entity(saved).build();
    }

    @DELETE
    @Path("/persons/{id}/")
    @Produces("application/xml")
    public Response deletePerson(@PathParam("id") String id) {
        LOG.info("----invoking getPerson, Person name is: " + id);
        Person c = personService.findPerson(BigInteger.valueOf(Long.valueOf(id)));
        Response r;
        if (c != null) {
            personService.removePersonById(c.getId());
            r = Response.ok().build();
        } else {
            r = Response.notModified().build();
        }
        return r;
    }

    public PersonServiceImpl getPersonService() {
        return personService;
    }

    public void setPersonService(PersonServiceImpl personService) {
        this.personService = personService;
    }

}
