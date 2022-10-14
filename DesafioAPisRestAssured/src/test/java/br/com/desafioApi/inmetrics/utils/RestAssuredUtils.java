package br.com.desafioApi.inmetrics.utils;

import br.com.desafioApi.inmetrics.enums.AuthenticationType;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.net.URI;
import java.util.Map;

public class RestAssuredUtils {
        public static Response executeRestRequest(String url,
                                                  String requestService,
                                                  Method method,
                                                  Map<String,String> headers,
                                                  String jsonBody,
                                                  String authenticatorUser,
                                                  String authenticatorPassword,
                                                  AuthenticationType authenticationType){

            RequestSpecification requestSpecification = RestAssured.given();

            for (Map.Entry<String, String> header : headers.entrySet()){
                requestSpecification.headers(header.getKey(), header.getValue());
            }

            if(jsonBody !=null){
                requestSpecification.body(jsonBody);
            }

            switch (authenticationType){
                case BASIC:
                    requestSpecification.auth().basic(authenticatorUser, authenticatorPassword);
                    break;
                case PREEMPTIVE:
                    requestSpecification.auth().preemptive().basic(authenticatorUser, authenticatorPassword);
                    break;
                case NONE:
                    break;
                default:
                    try {
                        throw new Exception("Authentication type not implemented");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }

            return requestSpecification.request(method, URI.create(url+requestService));
        }

    }
