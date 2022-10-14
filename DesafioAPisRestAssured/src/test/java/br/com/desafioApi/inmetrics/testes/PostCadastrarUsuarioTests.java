package br.com.desafioApi.inmetrics.testes;

import br.com.desafioApi.inmetrics.base.TestBase;
import br.com.desafioApi.inmetrics.request.CadastrarEmpregadoPost;
import br.com.desafioApi.inmetrics.utils.GeneralUtils;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class PostCadastrarUsuarioTests extends TestBase {

    @Test
    public void CadastrarNovoFuncionario() {
        SoftAssert softAssert = new SoftAssert();
        String admissao = "27/07/2020";
        String cargo = "Analista_" + GeneralUtils.RetornaNumeroRandom();
        String comissao = "1.000,00";
        String cpf = GeneralUtils.geraCPF();
        String departamentoId = "3";
        String nome = "Diego_" + GeneralUtils.RetornaNumeroRandom();
        String salario = "8.000,00";
        String sexo = "m";
        String contratacao = "pj";
        int statusCodeEsperado = HttpStatus.SC_ACCEPTED;

        CadastrarEmpregadoPost cadastrarEmpregadoPost = new CadastrarEmpregadoPost();
        cadastrarEmpregadoPost.SetJsonBody(admissao,cargo,comissao,cpf,departamentoId,nome,salario,sexo,contratacao);
        Response response = cadastrarEmpregadoPost.executeRequest();

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
