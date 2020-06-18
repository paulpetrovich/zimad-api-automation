package Tasks;

import Managers.RequestManager;
import Utils.EndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateNewDefaultTask {

    Response response;

    @BeforeSuite
    public void beforeSuite() {

    }


    @Test
    public void TaskCreatedSuccessfully() {

        RequestManager requestManager = new RequestManager();
        requestManager.setEndPoint(EndPoints.tasks);
        response = requestManager.createTask();
        Assert.assertTrue(response.statusCode() == 200);
        Assert.assertTrue(response.jsonPath().get("url")!=null);


    }

    @Test
    public void TaskNotCreatedWithIncorrectDueDate() {

        RequestManager requestManager = new RequestManager();
        requestManager.setEndPoint(EndPoints.tasks);
        response = requestManager.createTask("tomorrow at 40:00");
        Assert.assertTrue(response.statusCode() != 200);
        Assert.assertEquals(response.getBody().asString().trim(),"Date is invalid");

    }

    @AfterSuite
    public void afterSuite() {

    }


}
