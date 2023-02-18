package ru.horn.author.controller;

import author.AuthorDto;
import author.CreateAuthorDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.horn.author.model.entity.Author;
import ru.horn.author.provider.AuthProvider;
import ru.horn.author.repository.AuthorRepository;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {
                "spring.datasource.url=jdbc:tc:postgresql:10-alpine:///auth",
                "spring.datasource.driver-class-name=org.testcontainers.jdbc.ContainerDatabaseDriver"})
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@Transactional
@Rollback
class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void createAuthor() throws Exception {
//        byte[] bytes = Files.readAllBytes(
//                ResourceUtils.getFile("classpath:author/create_author.json").toPath());
//
//        String request = new String(bytes
//        );

        CreateAuthorDto createAuthorDto = AuthProvider.getCreateAuthorDto();

        MvcResult mvcResult = mockMvc.perform(
                        post("/author")
                                .header("Content-Type", "application/json")
                                .content(objectMapper.writeValueAsString(createAuthorDto))
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(notNullValue())))
                .andExpect(jsonPath("$.name", is(createAuthorDto.getName())))
                .andExpect(jsonPath("$.surname", is(createAuthorDto.getSurname())))
                .andReturn();

        AuthorDto authorDtoActual = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), AuthorDto.class);

        Assertions.assertNotNull(authorDtoActual.getId());
        Assertions.assertEquals(createAuthorDto.getName(), authorDtoActual.getName());
        Assertions.assertEquals(createAuthorDto.getSurname(), authorDtoActual.getSurname());

        assertEquals(AuthProvider.getAuthorDto(), authorDtoActual);

        Author author = authorRepository.findById(authorDtoActual.getId())
                .orElseThrow(() -> new RuntimeException("No author found"));

        Assertions.assertEquals(createAuthorDto.getName(), author.getName());
        Assertions.assertEquals(createAuthorDto.getSurname(), author.getSurname());
    }

    @Test
    void getAuthorById() throws Exception {

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/author/{id}", 1L)
                                .header("Content-Type", "application/json")
                )
                .andDo(print())
                .andExpect(handler().handlerType(AuthorController.class))
                .andExpect(handler().methodName("getAuthorById"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(notNullValue())))
                .andExpect(jsonPath("$.name", is(notNullValue())))
                .andExpect(jsonPath("$.surname", is(notNullValue())))
                .andReturn();
    }

    @Test
    @Disabled
    void getAuthorDtoList() {
    }

    @Test
    @Disabled
    void getAuthorDtoListByName() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/author/{id}", 1L)
//                                .params()
                                .header("Content-Type", "application/json")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(notNullValue())))
                .andExpect(jsonPath("$.name", is(notNullValue())))
                .andExpect(jsonPath("$.surname", is(notNullValue())))
                .andReturn();
    }

    @Test
    @Disabled
    void getAuthorDtoListBySurName() {
    }

    @Test
    @Disabled
    void getAuthorDtoListByNameAndSurname() {
    }

    @Test
    @Disabled
    void updateAuthorDto() {
    }

    @Test
    @Disabled
    void updateAuthorName() {
    }

    @Test
    @Disabled
    void deleteAuthorDtoById() {
    }
}