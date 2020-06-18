package Objects;

import Helpers.PropertiesReader;
import Utils.UUIDGenerator;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class DefaultTask {

    private PropertiesReader prop = new PropertiesReader();
    public UUIDGenerator uuid = new UUIDGenerator();

    private String content = "content";
    private String due_string = "due_string";
    private String due_lang = "due_lang";
    private String priority = "priority";
    private String endPoint = "";


    Response response;
    JSONObject jsonBody;

    public DefaultTask(String endPoint) {

        this.endPoint = endPoint;
        jsonBody = new JSONObject();

        jsonBody.put(this.content, Utils.Task.content);
        jsonBody.put(this.due_string, Utils.Task.due_string);
        jsonBody.put(this.due_lang, Utils.Task.due_lang);
        jsonBody.put(this.priority, Utils.Task.priority);

    }

    public DefaultTask(String endPoint, String param) {

        this.endPoint = endPoint;
        jsonBody = new JSONObject();

        jsonBody.put(this.content, Utils.Task.content);
        jsonBody.put(this.due_string, param);
        jsonBody.put(this.due_lang, Utils.Task.due_lang);
        jsonBody.put(this.priority, Utils.Task.priority);

    }

    public Response buildTaskJSON() {

        response =
                given().
                        contentType(ContentType.JSON).
                        header("Authorization", "Bearer" + " " + prop.readProperties().getProperty("authorizationBearer")).
                        header("X-Request-Id", uuid.getUuid()).
                        body(jsonBody.toJSONString()).
                        post(endPoint);

        return response;
    }

    public Response buildTaskJSON(UUID uuid) {

        response =
                given().
                        contentType(ContentType.JSON).
                        header("Authorization", "Bearer" + " " + prop.readProperties().getProperty("authorizationBearer")).
                        header("X-Request-Id", uuid).
                        body(jsonBody.toJSONString()).
                        post(endPoint);

        return response;
    }
}
