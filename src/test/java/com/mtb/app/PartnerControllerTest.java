package com.mtb.app;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
class PartnerControllerTest {

    @BeforeAll
    public static void setup() {
        GenericContainer container = new GenericContainer(DockerImageName.parse("docker.io/library/mongo:4.4"))
                .withExposedPorts(27017)
                .withEnv("MONGO_INITDB_DATABASE", "mtb");
        container.start();
        System.setProperty("test.quarkus.mongodb.connection-string", "mongodb://localhost:" + String.valueOf(container.getMappedPort(27017)));
    }

    @Test
    @Order(1)
    void test_partner_onboard_endpoint() {
        given()
                .body("{\n" +
                        "  \"city\": \"MUMBAI\",\n" +
                        "  \"partnerName\": \"PVR\",\n" +
                        "  \"movieName\": \"Top Gun\",\n" +
                        "  \"genre\": \"ACTION\",\n" +
                        "  \"language\": \"ENGLISH\",\n" +
                        "  \"screenNumber\": 1,\n" +
                        "  \"availableSeats\": {\n" +
                        "    \"A1\": 250.0,\n" +
                        "    \"A2\": 250.0,\n" +
                        "    \"A3\": 250.0,\n" +
                        "    \"A4\": 250.0,\n" +
                        "    \"A5\": 250.0,\n" +
                        "    \"B1\": 300.0,\n" +
                        "    \"B2\": 300.0,\n" +
                        "    \"B3\": 300.0,\n" +
                        "    \"B4\": 300.0,\n" +
                        "    \"B5\": 300.0\n" +
                        "  },\n" +
                        "  \"unAvailableSeats\": [],\n" +
                        "  \"startTime\": \"2022-03-10T12:15:50\",\n" +
                        "  \"endTime\": \"2022-03-10T14:15:50\",\n" +
                        "  \"status\": \"ACTIVE\"\n" +
                        "}")
                .header("Content-Type", "application/json")
                .when().post("/v1/partner/onboard")
                .then()
                .statusCode(200)
                .body(containsString("id")).log();
    }

    @Test
    @Order(2)
    void test_partner_onboard_bulk_endpoint() {
        given()
                .body("[{\n" +
                        "  \"city\": \"DELHI\",\n" +
                        "  \"partnerName\": \"PVR\",\n" +
                        "  \"movieName\": \"Animal\",\n" +
                        "  \"genre\": \"ACTION\",\n" +
                        "  \"language\": \"HINDI\",\n" +
                        "  \"screenNumber\": 1,\n" +
                        "  \"availableSeats\": {\n" +
                        "    \"A1\": 250.0,\n" +
                        "    \"A2\": 250.0,\n" +
                        "    \"A3\": 250.0,\n" +
                        "    \"A4\": 250.0,\n" +
                        "    \"A5\": 250.0,\n" +
                        "    \"B1\": 300.0,\n" +
                        "    \"B2\": 300.0,\n" +
                        "    \"B3\": 300.0,\n" +
                        "    \"B4\": 300.0,\n" +
                        "    \"B5\": 300.0\n" +
                        "  },\n" +
                        "  \"unAvailableSeats\": [],\n" +
                        "   \"startTime\": \"2022-03-10T08:15:50\",\n" +
                        "  \"endTime\": \"2022-03-10T11:15:50\",\n" +
                        "  \"status\": \"ACTIVE\"\n" +
                        "},{\n" +
                        "  \"city\": \"BANGALORE\",\n" +
                        "  \"partnerName\": \"PVR\",\n" +
                        "  \"movieName\": \"Animal\",\n" +
                        "  \"genre\": \"ACTION\",\n" +
                        "  \"language\": \"TAMIL\",\n" +
                        "  \"screenNumber\": 1,\n" +
                        "  \"availableSeats\": {\n" +
                        "    \"A1\": 250.0,\n" +
                        "    \"A2\": 250.0,\n" +
                        "    \"A3\": 250.0,\n" +
                        "    \"A4\": 250.0,\n" +
                        "    \"A5\": 250.0,\n" +
                        "    \"B1\": 300.0,\n" +
                        "    \"B2\": 300.0,\n" +
                        "    \"B3\": 300.0,\n" +
                        "    \"B4\": 300.0,\n" +
                        "    \"B5\": 300.0\n" +
                        "  },\n" +
                        "  \"unAvailableSeats\": [],\n" +
                        "  \"startTime\": \"2022-03-10T08:15:50\",\n" +
                        "  \"endTime\": \"2022-03-10T11:15:50\",\n" +
                        "  \"status\": \"ACTIVE\"\n" +
                        "},{\n" +
                        "  \"city\": \"MUMBAI\",\n" +
                        "  \"partnerName\": \"PVR\",\n" +
                        "  \"movieName\": \"Nun\",\n" +
                        "  \"genre\": \"HORROR\",\n" +
                        "  \"language\": \"ENGLISH\",\n" +
                        "  \"screenNumber\": 2,\n" +
                        "  \"availableSeats\": {\n" +
                        "    \"A1\": 250.0,\n" +
                        "    \"A2\": 250.0,\n" +
                        "    \"A3\": 250.0,\n" +
                        "    \"A4\": 250.0,\n" +
                        "    \"A5\": 250.0,\n" +
                        "    \"B1\": 300.0,\n" +
                        "    \"B2\": 300.0,\n" +
                        "    \"B3\": 300.0,\n" +
                        "    \"B4\": 300.0,\n" +
                        "    \"B5\": 300.0\n" +
                        "  },\n" +
                        "  \"unAvailableSeats\": [],\n" +
                        "  \"startTime\": \"2022-03-10T11:15:50\",\n" +
                        "  \"endTime\": \"2022-03-10T13:15:50\",\n" +
                        "  \"status\": \"ACTIVE\"\n" +
                        "}]")
                .header("Content-Type", "application/json")
                .when().post("/v1/partner/onboard/bulk")
                .then()
                .statusCode(200)
                .body(containsString("id")).log();
    }

    @Test
    @Order(3)
    void test_list_all_endpoint() {
        given()
                .when().get("/v1/partner")
                .then()
                .statusCode(200)
                .body(notNullValue()).log();
    }


    @Test
    @Order(4)
    void test_customer_booking_with_fifty_percent_discount_scenario() {
        given().body("{\n" +
                        "  \"city\": \"DELHI\",\n" +
                        "  \"partnerName\": \"PVR\",\n" +
                        "  \"movieName\": \"Animal\",\n" +
                        "  \"genre\": \"ACTION\",\n" +
                        "  \"language\": \"HINDI\",\n" +
                        "  \"screenNumber\": 1,\n" +
                        "  \"startTime\": \"2022-03-10T08:15:50\",\n" +
                        "  \"endTime\": \"2022-03-10T11:15:50\",\n" +
                        "  \"seats\": {\n" +
                        "      \"A1\": 250,\n" +
                        "      \"B2\": 300,\n" +
                        "      \"A2\": 250,\n" +
                        "      \"B3\": 300,\n" +
                        "      \"A3\": 250,\n" +
                        "      \"B4\": 300,\n" +
                        "      \"A4\": 250\n" +
                        "  },\n" +
                        "  \"totalPrice\": 0,\n" +
                        "  \"finalPrice\": 0,\n" +
                        "  \"status\": \"ACTIVE\"\n" +
                        "}")
                .header("Content-Type", "application/json")
                .when().post("/v1/customer/booking")
                .then()
                .statusCode(200)
                .body(containsString("\"finalPrice\":1625.0")).log();
    }

    @Test
    @Order(5)
    void test_customer_booking_with_twenty_percent_discount_scenario() {
        given().body("{\n" +
                        "    \"city\": \"MUMBAI\",\n" +
                        "    \"partnerName\": \"PVR\",\n" +
                        "    \"movieName\": \"Top Gun\",\n" +
                        "    \"genre\": \"ACTION\",\n" +
                        "    \"language\": \"ENGLISH\",\n" +
                        "    \"screenNumber\": 1,\n" +
                        "    \"seats\": {\n" +
                        "      \"A1\": 250,\n" +
                        "      \"B2\": 300\n" +
                        "    },\n" +
                        "    \"totalPrice\": 0,\n" +
                        "    \"finalPrice\": 0,\n" +
                        "    \"startTime\": \"2022-03-10T12:15:50\",\n" +
                        "    \"endTime\": \"2022-03-10T14:15:50\",\n" +
                        "    \"status\": \"ACTIVE\"\n" +
                        "  }")
                .header("Content-Type", "application/json")
                .when().post("/v1/customer/booking")
                .then()
                .statusCode(200)
                .body(containsString("\"finalPrice\":440.0")).log();
    }

}