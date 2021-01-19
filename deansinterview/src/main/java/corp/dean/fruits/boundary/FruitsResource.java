package corp.dean.fruits.boundary;


import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import corp.dean.fruits.model.Fruit;

@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/fruits")
public class FruitsResource {
    
    @Inject
    FruitService fruitService;
    //Get request for all fruits in JSON format
    @GET
    public List<Fruit> getFruits(){
        System.out.println("Displayed all Fruits");
        return fruitService.getFruits();
    }
    //Post request using body
    @POST
    @Path("/save")
    public List<Fruit> saveFruits(Fruit fruits){
        System.out.println("Saved fruit name: "+fruits.getFruitName()+"\nSaved fruit colour: " +fruits.getFruitColour());
        return fruitService.getFruits();
    }
    //Post request using query parameters
    @POST
    @Path("/save1")
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveFruits1(@QueryParam("fruitName") String fruitName, @QueryParam("fruitColour") String fruitColour){
        System.out.println("Saved fruit name: "+fruitName+"\nSaved fruit colour: " +fruitColour);
        return Response.ok().build();
    }
    //Delete request where fruitname =  fruitname
    @DELETE
    @Path("/delete")
    public List<Fruit> deleteFruits(@QueryParam("fruitName") String fruitName){

        System.out.println("Deleted fruit where fruit name = "+fruitName);
        return fruitService.getFruits();
    }



   
}


