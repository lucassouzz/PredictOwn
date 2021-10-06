package br.com.predictown.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import com.google.gson.Gson;



public class UtilRest {

    public Response buildResponse(Object result) {

	try {
	    /*
	     * Retorna o objeto de resposta com status 200 (ok), tendo em seu corpo o objeto
	     * valorResposta (que consiste no objeto result convertido para JSON).
	     */
	    String valorResposta = new Gson().toJson(result);

	    // System.out.println(valorResposta);

	    return Response.ok(valorResposta).build();

	} catch (Exception ex) {
	    ex.printStackTrace();
	    // se algo der errado acima, cria o Response de erro
	    return this.buildResponse(ex.getMessage());
	}
    }

    /*
     * Abaixo o m�todo responsavel por enviar a resposta ao cliente sobre a
     * transa��o realizada, inclus�o, consulta, edi��o ou exclus�o ao cliente, N�O
     * REALIZADAS COM SUCESO, ou seja, que contenha algum erro. Repare que o m�todo
     * em quest�o aguarada que seja repassado um conte�do que sera referenciado pelo
     * por um objeto chamdo rb.
     */

    public Response buildErrorResponse(String str) {
	/*
	 * abaixo o objeto rb recebe o status do erro.
	 */
	ResponseBuilder rb = Response.status(Response.Status.INTERNAL_SERVER_ERROR);
	/*
	 * Define a entidade (objeto), que nesse caso � uma mensagem que ser� retornado
	 * para o cliente.
	 */
	rb = rb.entity(str);
	/*
	 * Define o tipo de retorno desta entidade(objeto), no caso � defindo como texto
	 * simples.
	 */
	rb = rb.type("text/plain");

	/*
	 * retorna o objeto de resposta com o status 500(erro), junto com a String
	 * contendo a mensagem de erro.
	 */
	return rb.build();
    }
}
