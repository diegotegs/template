package br.com.desafioApi.inmetrics.base;

import br.com.desafioApi.inmetrics.GlobalParameters;
import br.com.desafioApi.inmetrics.enums.AuthenticationType;
import br.com.desafioApi.inmetrics.utils.ExtentReportsUtils;
import br.com.desafioApi.inmetrics.utils.RestAssuredUtils;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL;

public abstract  class RequestBase {
    protected String url = GlobalParameters.URL_DEFAULT;
    protected String requestService = null;
    protected Method method = null;
    protected String jsonBody = null;
    protected Map<String, String> headers = new HashMap<String, String>();
    protected AuthenticationType authenticationType = AuthenticationType.BASIC;
    protected String authenticatorUser = GlobalParameters.AUTHENTICATOR_USER;
    protected String authenticatorPassword = GlobalParameters.AUTHENTICATOR_PASSWORD;

    public RequestBase(){
        config = RestAssuredConfig.newConfig().jsonConfig(jsonConfig().numberReturnType(BIG_DECIMAL));
        enableLoggingOfRequestAndResponseIfValidationFails();
        headers.put("content-type", "application/json");
    }

    public Response executeRequest() {
        Response response = RestAssuredUtils.executeRestRequest(url, requestService, method, headers,  jsonBody, authenticatorUser, authenticatorPassword, authenticationType);
        ExtentReportsUtils.addRestTestInfo(url, requestService, method.toString(), headers,  jsonBody, authenticationType, authenticatorUser, authenticatorPassword, response);

        return response;
    }
}
