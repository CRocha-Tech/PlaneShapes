/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import net.sf.json.JSONObject;
import util.NegativeValuesException;
import util.JSONBuilder;

/**
 * REST Web Service
 * 
 * @author rocha
 */
@Path("planeshapes")
public class GenericResource {

    @Context
    private UriInfo context;
    
    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }
    
    /**
     *
     * @return
     */
    @GET
    @Path("shapesList")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String createShapeListJSON() {
        return JSONBuilder.formsList();
    }
    
    /**
     *
     * @param name
     * @param parameter
     * @return
     * @throws NegativeValuesException
     */
    @GET
    @Path("shapeOne&{name}&{parameter}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String createShapeOneJSON(@PathParam("name") String name,
            @PathParam("parameter") double parameter) throws NegativeValuesException {
        
        String response = "";
        try {
            response = JSONBuilder.shapeOneParameter(name, parameter);
        } catch (NegativeValuesException ex) {
            JSONObject errrorJSON = JSONBuilder.createErrorJSON(name, ex.toString());
            response = errrorJSON.toString();
        }
            return response;
    }
    
    /**
     *
     * @param name
     * @param parameter1
     * @param parameter2
     * @return
     * @throws NegativeValuesException
     */
    @GET
    @Path("shapeTwo&{name}&{parameter1}&{parameter2}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String createShapeTwoJSON(@PathParam("name") String name,
            @PathParam("parameter1") double parameter1,
            @PathParam("parameter2") double parameter2) throws NegativeValuesException {
        
        String response = "";
        try {
            response = JSONBuilder.shapeTwoParameters(name, parameter1, parameter2);
        } catch (NegativeValuesException ex) {
            JSONObject errrorJSON = JSONBuilder.createErrorJSON(name, ex.toString());
            response = errrorJSON.toString();
        }
            return response;
    }
    
    /**
     *
     * @param name
     * @param parameter1
     * @param parameter2
     * @param parameter3
     * @return
     * @throws NegativeValuesException
     */
    @GET
    @Path("shapeThree&{name}&{parameter1}&{parameter2}&{parameter3}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String createShapeThreeJSON(@PathParam("name") String name,
            @PathParam("parameter1") double parameter1,
            @PathParam("parameter2") double parameter2,
            @PathParam("parameter3") double parameter3) throws NegativeValuesException {
        
        String response = "";
        try {
            response = JSONBuilder.shapeThreeParameters(name, parameter1, parameter2, parameter3);
        } catch (NegativeValuesException ex) {
            JSONObject errrorJSON = JSONBuilder.createErrorJSON(name, ex.toString());
            response = errrorJSON.toString();
        }
            return response;
    }
    
}