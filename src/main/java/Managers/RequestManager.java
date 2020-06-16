package Managers;


import Helpers.PropertiesReader;
import io.restassured.RestAssured;

public class RequestManager {

    private PropertiesReader prop = new PropertiesReader();
    private String baseUri = prop.readProperties().getProperty("baseUrl");
    private String newBaseUri = "";


    public RequestManager() {
        this.setBaseUri(this.baseUri);

    }

    public void setBaseUri(String newBaseUri) {

        RestAssured.baseURI = newBaseUri;

    }


    public void setEndPoint(String endPoint) {
        newBaseUri = baseUri + endPoint;
    }

    public String getEndPoint() {
        return newBaseUri;
    }
}
