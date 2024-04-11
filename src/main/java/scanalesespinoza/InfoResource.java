package scanalesespinoza;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/info")
public class InfoResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String info() {
        //Gather your main service info here
        return "Welcome to the Map Service";
    }
}
