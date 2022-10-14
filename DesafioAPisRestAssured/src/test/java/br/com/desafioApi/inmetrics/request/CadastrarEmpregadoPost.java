package br.com.desafioApi.inmetrics.request;

import br.com.desafioApi.inmetrics.base.RequestBase;
import br.com.desafioApi.inmetrics.utils.GeneralUtils;
import io.restassured.http.Method;

public class CadastrarEmpregadoPost extends RequestBase {

    public CadastrarEmpregadoPost(){
        requestService ="/empregado/cadastrar";
        method = Method.POST;
    }

    public void SetJsonBody(String admissao, String cargo, String comissao, String cpf,String departamento, String nome,
    String salario,String sexo, String contratacao){
        jsonBody = GeneralUtils.readFileToAString("src/test/java/br/com/desafioApi/inmetrics/json/PostCadastroJson.json");
        jsonBody = jsonBody.replace("$admissao",admissao).replace("$cargo",cargo)
                .replace("$comissao",comissao).replace("$cpf",cpf).replace("$departamentoId",departamento)
    .replace("$nome",nome)
                .replace("$salario",salario).replace("$sexo",sexo).replace("$tipoContratacao",contratacao);
    }

    }