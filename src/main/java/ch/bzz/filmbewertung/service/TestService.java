package ch.bzz.filmbewertung.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * test service
 *
 * @author Erion Malaj
 */
@Path("test")
public class TestService {

    /**
     * Test method to see if service works
     *
     * @return Response with successful message
     */
    @GET
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public Response test() {
        return Response
                .status(200)
                .entity("Test erfolgreich")
                .build();
    }
}
