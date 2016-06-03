/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservice;


import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import model.Funcionario;
import service.FuncionarioService;

/**
 *
 * @author Rodrigo Martins Schmitz
 * @Path indica em que url esse webservice vai estar escutando
 */
@Stateless
@Path("/funcionario")
public class FuncionarioWS {
    
    @EJB
    private FuncionarioService funcionarioService;
    
    /**
     * @GET Indica que esse metodo vai receber uma requisicao do tipo get utilizada para listar e buscar dados
     * @POST Indica que esse metodo vai receber uma requisicao do tipo pot utilizado para inserir dados
     * @PUT Indica que esse metodo vai receber uma requisicao do tipo put quando o dado e alterado
     * @DELETE Indica que esse metodo vai receber uma requisicao do tipo delete quando o dado e removido
     * @Produces Indica que o metodo vai retornar um objeto do tipo json
     * @Consumes Indica que o metodo vai consumir um objeto do tipo json
     * @QueryParam Substituiu o parametro  "coringa" do nome especificado pelo valor fornecido
     */
    
    @GET
    @Produces("application/json")
    public List<Funcionario> listAll() {
        return funcionarioService.listAll();
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Funcionario find(@PathParam("id") Integer id) {
        return funcionarioService.find(id);
    }
    
    @GET
    @Path("/filtro")
    @Produces("application/json")
    public List<Funcionario> listByParams(@QueryParam("nome") String nome) {
        return funcionarioService.listByParams(nome);
    }
    
    @POST
    @Consumes("application/json")
    public Funcionario insert(Funcionario funcionario) {
        return funcionarioService.insert(funcionario);
    }
    
    @PUT
    @Consumes("application/json")
    public Funcionario update(Funcionario funcionario) {
        return funcionarioService.update(funcionario);
    }
    
    @DELETE
    @Path("{id}")
    @Consumes("application/json")
    public Funcionario remove(@PathParam("id") Integer id) {
        return funcionarioService.remove(id);
    }
}
