package Tasks;

import Managers.RequestManager;
import Utils.EndPoints;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateNewTask {




        @BeforeSuite
        public void beforeSuite() {

        }


        @Test
        public void FirstTest (){

            RequestManager requestManager = new RequestManager();
            requestManager.setEndPoint(EndPoints.tasks);

            System.out.println(requestManager.getEndPoint());

        }

        @AfterSuite
        public void afterSuite() {

        }


}
