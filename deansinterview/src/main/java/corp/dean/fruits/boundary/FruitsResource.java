package corp.dean.fruits.boundary;


import java.util.Arrays;
import java.util.ArrayList;
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
    //FruitService f = new FruitService();
    @Inject
    FruitService fruitService = new FruitService();
    ArrayList<Fruit> fruitList = fruitService.getFruits();
    //Get request for all fruits in JSON format
    //http://localhost:8080/fruits
    @GET
    public ArrayList<Fruit> getFruits(){
        System.out.println("Displayed all Fruits");
        return fruitService.getFruits();
    }
    //Post request using body
    //http://localhost:8080/fruits/save (add this body: {"fruitColour": "Green","fruitName": "Apple"})
    @POST
    @Path("/save")
    public ArrayList<Fruit> saveFruits(Fruit fruits){
        fruitService.addFruit(fruits.getFruitName(), fruits.getFruitColour());
        System.out.println("Saved fruit name: "+fruits.getFruitName()+"\nSaved fruit colour: " +fruits.getFruitColour());
        return fruitService.getFruits();
    }
    //Post request using query parameters
    //http://localhost:8080/fruits/save1?fruitName=Orange&fruitColour=Orange
    @POST
    @Path("/save1")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Fruit> saveFruits1(@QueryParam("fruitName") String fruitName, @QueryParam("fruitColour") String fruitColour){
        fruitService.addFruit(fruitName, fruitColour);
        System.out.println("Saved fruit name: "+fruitName+"\nSaved fruit colour: " +fruitColour);
        return fruitService.getFruits();
    }
    //Delete request where fruitname =  fruitname
    //http://localhost:8080/fruits/delete?fruitName=Orange
    @DELETE
    @Path("/delete")
    public ArrayList<Fruit> deleteFruits(@QueryParam("fruitName") String fruitName){
        fruitService.deleteFruit(fruitName);
        System.out.println("Deleted fruit where fruit name = "+fruitName);
        return fruitService.getFruits();
    }



   
}


