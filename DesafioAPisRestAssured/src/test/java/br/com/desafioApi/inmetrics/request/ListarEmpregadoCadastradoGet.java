package br.com.desafioApi.inmetrics.request;

import br.com.desafioApi.inmetrics.base.RequestBase;
import io.restassured.http.Method;

public class ListarEmpregadoCadastradoGet extends RequestBase {

    public ListarEmpregadoCadastradoGet(String idUsuario){
        requestService = "/empregado/list/"+idUsuario;
        method = Method.GET;

    }
}
