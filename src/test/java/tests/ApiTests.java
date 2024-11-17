package tests;

import config.apiConfig;
import io.qameta.allure.Owner;
import models.*;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static specs.UserCreateSpec.createUserRequestSpec;
import static specs.UserCreateSpec.createUserResponseSpec;
import static specs.UserDeleteSpec.responseSpecWithStatusCode204;
import static specs.UserRegisterSpec.*;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.UserRegisterSpec.getUserRequestSpec;
import static specs.UserRegisterSpec.successfulUserResponseSpec;

@Owner("yorohovsa")
public class ApiTests extends TestBase {

    private static apiConfig config = ConfigFactory.create(apiConfig.class);

    @Test
    @DisplayName("Создание пользователя")
    void successfulCreateUserTest() {

        CreateUserBodyModel userData = new CreateUserBodyModel();
        userData.setName("stas");
        userData.setJob("qa engineer");

        CreateUserResponseModel response = step("Запрос на создание", ()->
                given(createUserRequestSpec)
                        .body(userData)

                        .when()
                        .post("/users")

                        .then()
                        .spec(createUserResponseSpec)
                        .extract().as(CreateUserResponseModel.class));

        step("Проверка имени", ()->
                assertEquals("stas",response.getName()));

        step("Проверка профессии", ()->
                assertEquals("qa engineer", response.getJob()));

        step("Проверка id", ()->
                assertNotNull(response.getId()));

        step("Проверка записи времени создания", ()->
                assertNotNull(response.getCreatedAt()));
    }

    @Test
    @DisplayName("Успешная регистрация пользователя")
    void successfulRegisterUserTest() {

        RegistrationBodyModel authData = new RegistrationBodyModel();
        authData.setEmail(config.authEmail());
        authData.setPassword(config.authPassword());

        RegistrationResponseModel response = step("Запрос на регистрацию существующего пользователя", ()->
                given(registerRequestSpec)
                        .body(authData)

                        .when()
                        .post("/register")

                        .then()
                        .spec(responseSpec200)
                        .extract().as(RegistrationResponseModel.class));

        step("Проверка Id", ()->
                assertNotNull(response.getId()));

        step("Проверка token", ()->
                assertNotNull(response.getToken()));
    }

    @Test
    @DisplayName("Отправка на регистрацию с незаполненными email/password")
    void emptyAuthDataTest() {

        Error400Model response = step("Передача запроса на регистрацию с незаполненными email/password", ()->
                given(registerRequestSpec)
                        .when()
                        .post("/register")

                        .then()
                        .spec(errorResponseSpec400)
                        .extract().as(Error400Model.class));

        step("Проверка ответа", ()->
                assertEquals("Missing email or username", response.getError()));
    }

    @DisplayName("Проверка данных существующего пользователя")
    @Test
    void successfulGetSingleUserTest() {

        SingleUserSuccessfulResponseModel response = step("Отправляем запрос", ()->
                given()
                        .spec(getUserRequestSpec)

                        .when()
                        .get("/users/2")

                        .then()
                        .spec(successfulUserResponseSpec)
                        .extract().as(SingleUserSuccessfulResponseModel.class)
        );

        step("Проверяем ответ", ()-> {
            assertThat(response.getData().getId()).isEqualTo(2);
            assertThat(response.getData().getEmail()).isEqualTo("janet.weaver@reqres.in");
            assertThat(response.getData().getFirst_name()).isEqualTo("Janet");
            assertThat(response.getData().getLast_name()).isEqualTo("Weaver");
            assertThat(response.getData().getAvatar()).isEqualTo("https://reqres.in/img/faces/2-image.jpg");
        });
    }

//    заменить!
    @Test
    @DisplayName("Обновление данных")
    void putUserTest() {
        UpdateUserBodyModel updateBody = new UpdateUserBodyModel();
        updateBody.setName("Jason Statham");
        updateBody.setJob("Beekeeper");
        PutResponseUserModel responseUpdateUser = step("Обновляем Name и Job пользователя", () ->
                given(registerRequestSpec)
                        .body(updateBody)
                        .put("/users/2/")
                        .then()
                        .spec(responseSpec200)
                        .extract().as(PutResponseUserModel.class));

        step("Проверяем изменения", () -> {
            assertThat("Jason Statham").isEqualTo(responseUpdateUser.getName());
            assertThat("Beekeeper").isEqualTo(responseUpdateUser.getJob());
            assertThat(responseUpdateUser.getUpdatedAt()).isNotNull();
        });
    }

    @Test
    @DisplayName("Удаление пользователя")
    void deleteUserTest() {
        step("Проверяем статус удаления пользователя", () -> {
            given(registerRequestSpec)
                    .delete("/users/2")
                    .then()
                    .log().body()
                    .spec(responseSpecWithStatusCode204);
        });
    }

}