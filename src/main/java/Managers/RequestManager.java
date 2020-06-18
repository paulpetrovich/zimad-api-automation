package Managers;

import Helpers.PropertiesReader;
import Objects.DefaultTask;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RequestManager {

    private DefaultTask task;
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

    public Response createTask() {

        task = new DefaultTask(getEndPoint());
        return  task.buildTaskJSON();
    }

    public Response createTask(String taskParam) {

        task = new DefaultTask(getEndPoint(),taskParam);
        return  task.buildTaskJSON();
    }
}
