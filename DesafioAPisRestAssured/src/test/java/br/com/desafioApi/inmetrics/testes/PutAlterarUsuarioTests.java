package br.com.desafioApi.inmetrics.testes;

import br.com.desafioApi.inmetrics.base.TestBase;
import br.com.desafioApi.inmetrics.request.AlterarEmpregadoPut;
import br.com.desafioApi.inmetrics.request.CadastrarEmpregadoPost;
import br.com.desafioApi.inmetrics.utils.GeneralUtils;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.Random;

public class PutAlterarUsuarioTests extends TestBase {

    @Test
    public void AlterarUmUsuario(){
        SoftAssert softAssert = new SoftAssert();
        String[]valores= {"7.500,00","4.000,00","6.000,00","1.200,00"};

        String [] nomes = {"Diego02","Godofredo","João Paulo","Felipe"};
        Random r = new Random();

        String id = "101";
        String admissao = "27/07/2020";
        String cargo = "Analista_" + GeneralUtils.RetornaNumeroRandom();
        String comissao =valores[r.nextInt(4)];
        String cpf = GeneralUtils.geraCPF();
        String departamentoId = "3";
        String nome = nomes[r.nextInt(4)];
        String salario = valores[r.nextInt(4)];
        String sexo = "m";
        String contratacao = "pj";
        int statusCodeEsperado = HttpStatus.SC_ACCEPTED;



        AlterarEmpregadoPut alterarEmpregadoPut = new AlterarEmpregadoPut(id);
        alterarEmpregadoPut.SetJsonBody(admissao,cargo,comissao,cpf,departamentoId,nome,salario,sexo,contratacao);
        Response response = alterarEmpregadoPut.executeRequest();

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
