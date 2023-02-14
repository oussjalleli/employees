package rest.ressources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import rest.entities.Employee;

@Path("employees")
public class GestionEmployee {
	private static List<Employee> employees = new ArrayList<Employee>();
	
	public GestionEmployee() {
		employees.add(new Employee("546","ben foulen", "foulen"));
		employees.add(new Employee("5852","oussama", "jalleli"));
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee>displayEmployeeList()
	{
		return employees;
		
	}
	
//	@GET
//	@Produces(MediaType.APPLICATION_XML)
//	public List<Employee> displayEmployeeList1(){
//		return employees;
//	}
//	
//	@GET
//	@Produces(MediaType.APPLICATION_XML)
//	public Response  displayEmployeeList2(){
//		if(employees.size()!=0) {
//			GenericEntity maliste = new GenericEntity<List<Employee>>(employees){};
//			return Response.status(Status.OK).entity(maliste).build();
//		}
//			
//		return Response.status(Status.NOT_FOUND).entity("la liste est vide").build();
//	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEmployee(Employee E) {
		if (employees.add(E))
			return Response.status(Status.CREATED).entity("add successfully done").build();
		return Response.status(Status.NOT_FOUND).entity("echec de l'ajout").build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("cin")
	public Response searchEmployee(@PathParam("cin")	String cin) {
		
		for(Employee E: employees) {
			if(E.getCin().equals(cin))
				return Response .status(Status.FOUND).entity(E).build();
		}
		return Response.status(Status.NOT_FOUND).entity("n'existe pas").build();
		
	}

	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update/{id}")
	
	public Response updateEmployee(@PathParam("id") String id, Employee updatedEmployee) {
	    for (Employee employee : employees) {
	    	
	        if (employee.getCin().equals(id)) {
	        	
	            employee.setNom(updatedEmployee.getNom());
	            employee.setPrenom(updatedEmployee.getPrenom());
	            
	            return Response.status(Status.OK).entity("Employee with ID " + id + " has been updated").build();
	        }
	    }
	    return Response.status(Status.NOT_FOUND).entity("Employee with ID " + id + " not found").build();
	}
	
	@POST
	@Path("delete/{id}")
	public Response deleteEmployee(@PathParam("id") String id) {
	    for (Employee employee : employees) {
	        if (employee.getCin().equals(id)) {
	            employees.remove(employee);
	            return Response.status(Status.OK).entity("Employee with ID " + id + " has been deleted").build();
	        }
	    }
	    return Response.status(Status.NOT_FOUND).entity("Employee with ID " + id + " not found").build();
	}
	
}
