package helpers;

import config.MobileConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class Browserstack {
    private static final MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

    public static String videoUrl(String sessionId) {

        String url = String.format("https://api-cloud.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(config.browserStackUser(), config.browserStackKey())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}