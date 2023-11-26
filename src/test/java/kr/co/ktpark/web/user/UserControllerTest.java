package kr.co.ktpark.web.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// @SpringBootTest
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("JSON 요청 및 JSON 응답")
    public void createUser_JSON() throws Exception {

        String userJson = "{\"userName\":\"KyungTaek\",\"password\":\"4321\"}";

        mockMvc.perform(post("/user/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(userJson))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.userName", is(equalTo("KyungTaek"))))
            .andExpect(jsonPath("$.password", is(equalTo("4321"))));

    }

    @Test
    @DisplayName("JSON 요청 및 XML 응답")
    public void createUser_XML() throws Exception {

        String userJson = "{\"userName\":\"KyungTaek\",\"password\":\"4321\"}";

        mockMvc.perform(post("/user/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_XML)
                        .content(userJson))
                .andExpect(status().isOk())
                .andExpect(xpath("/User/userName").string("KyungTaek"))
                .andExpect(xpath("/User/password").string("4321"));

    }

}