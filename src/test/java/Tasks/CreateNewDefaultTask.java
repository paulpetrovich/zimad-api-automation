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
    public void TaskCreatedSuccessfully() throws Exception {

        RequestManager requestManager = new RequestManager();
        requestManager.setEndPoint(EndPoints.tasks);
        response = requestManager.createTask();
        if (response.statusCode() == 200) {
            Assert.assertTrue(response.jsonPath().get("url") != null);
        } else {
            throw new Exception("Task creation failed!" + "\n" + Exception.class.getName());
        }


    }

    @Test
    public void TaskNotCreatedWithIncorrectDueDate() throws Exception {

        RequestManager requestManager = new RequestManager();
        requestManager.setEndPoint(EndPoints.tasks);
        response = requestManager.createTask("tomorrow at 40:00");
        if (response.statusCode() != 200) {
            Assert.assertEquals(response.getBody().asString().trim(), "Date is invalid");
        } else {
            throw new Exception("Response is incorrect! Invalid date was accepted" + "\n" + Exception.class.getName());
        }

    }

    @Test
    public void TaskNotCreatedWithExistingUUID() throws Exception {

        RequestManager requestManager = new RequestManager();
        requestManager.setEndPoint(EndPoints.tasks);
        response = requestManager.createTaskWithExistingUUID();
        if (response.statusCode() != 200) {
            Assert.assertEquals(response.getBody().asString().trim(), "Sync item already processed. Ignored");
        } else {
            throw new Exception("Response is incorrect! Duplicate UUID was allowed" + "\n" + Exception.class.getName());
        }
    }

    @AfterSuite
    public void afterSuite() {

    }


}
