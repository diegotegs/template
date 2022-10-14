package br.com.desafioApi.inmetrics.request;

import br.com.desafioApi.inmetrics.base.RequestBase;
import io.restassured.http.Method;

public class ListarTodosEmpregadosGet extends RequestBase {

    public ListarTodosEmpregadosGet(){
        method = Method.GET;
        requestService="/empregado/list_all";
    }
}
