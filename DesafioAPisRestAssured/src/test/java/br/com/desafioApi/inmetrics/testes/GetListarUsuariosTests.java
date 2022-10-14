package br.com.desafioApi.inmetrics.testes;

import br.com.desafioApi.inmetrics.base.TestBase;
import br.com.desafioApi.inmetrics.request.ListarTodosEmpregadosGet;
import br.com.desafioApi.inmetrics.request.ListarEmpregadoCadastradoGet;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GetListarUsuariosTests extends TestBase {

    @Test
    public void ListarTodosUsuarios(){
        int statusCodeEsperado = HttpStatus.SC_OK;
        ListarTodosEmpregadosGet listarTodosEmpregadosGet = new ListarTodosEmpregadosGet();
        Response response = listarTodosEmpregadosGet.executeRequest();
        Assert.assertEquals(response.statusCode(), statusCodeEsperado);

    }

    @Test
    public void ListarUsuarioPorId(){
        SoftAssert softAssert = new SoftAssert();
        int statusCodeEsperado = HttpStatus.SC_ACCEPTED;
        String id = "102";
        String nome = "Godofredo";
        String cargo = "Analista_7";
        String sexo = "m";
        String cpf = "479.948.151-70";
        String admissao = "27/07/2020";
        String salario = "1.200,00";
        String comissao = "7.500,00";
        String contratacao = "pj";
        ListarEmpregadoCadastradoGet listarEmpregadoCadastradoGet = new ListarEmpregadoCadastradoGet(id);
        Response response = listarEmpregadoCadastradoGet.executeRequest();
        Assert.assertEquals(response.statusCode(), statusCodeEsperado);
        softAssert.assertEquals(response.body().jsonPath().get("admissao").toString(),admissao);
        softAssert.assertEquals(response.body().jsonPath().get("cargo").toString(),cargo);
        softAssert.assertEquals(response.body().jsonPath().get("comissao").toString(),comissao);
        softAssert.assertEquals(response.body().jsonPath().get("cpf").toString(),cpf);
        softAssert.assertEquals(response.body().jsonPath().get("nome").toString(),nome);
        softAssert.assertEquals(response.body().jsonPath().get("salario").toString(),salario);
        softAssert.assertEquals(response.body().jsonPath().get("sexo").toString(),sexo);
        softAssert.assertEquals(response.body().jsonPath().get("tipoContratacao").toString(),contratacao);
        softAssert.assertAll();

    }
}
