package com.ld5ehom.restapi.domain.books.controller;

import com.ld5ehom.restapi.RestDocsConfig;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.context.TestConstructor.AutowireMode.ALL;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RequiredArgsConstructor
@AutoConfigureRestDocs
@AutoConfigureMockMvc
@Import(RestDocsConfig.class)
@TestConstructor(autowireMode = ALL)
@SpringBootTest
public class BookControllerTest {

    private final MockMvc mockMvc;

    // Verify retrieving a single book by ID and document response fields
    // 단일 책을 ID로 조회하고 응답 필드를 문서화한다
    @Test
    void getBookById() throws Exception {
        mockMvc.perform(
                        RestDocumentationRequestBuilders.get("/books/1")
                                .contentType(APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo(MockMvcRestDocumentation.document("getBookById",
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("Book ID"),
                                fieldWithPath("title").type(JsonFieldType.STRING).description("Title"),
                                fieldWithPath("publisher").type(JsonFieldType.STRING).description("Publisher"),
                                fieldWithPath("publishedDate").type(JsonFieldType.STRING).description("Published date"),
                                fieldWithPath("authors").type(JsonFieldType.ARRAY).description("Authors"),
                                fieldWithPath("authors.[].id").type(JsonFieldType.NUMBER).description("Author ID"),
                                fieldWithPath("authors.[].name").type(JsonFieldType.STRING).description("Author name"),
                                fieldWithPath("reviews").type(JsonFieldType.ARRAY).description("Reviews"),
                                fieldWithPath("reviews.[].id").type(JsonFieldType.NUMBER).description("Review ID"),
                                fieldWithPath("reviews.[].content").type(JsonFieldType.STRING).description("Review content"),
                                fieldWithPath("reviews.[].rating").type(JsonFieldType.NUMBER).description("Rating"),
                                fieldWithPath("reviews.[].createdDate").type(JsonFieldType.STRING).description("Created date")
                        )
                ))
                .andDo(print());
    }

    // Verify retrieving all books and document response fields
    // 전체 책 목록을 조회하고 응답 필드를 문서화한다
    @Test
    void getBooks() throws Exception {
        mockMvc.perform(
                        RestDocumentationRequestBuilders.get("/books")
                                .contentType(APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo(MockMvcRestDocumentation.document("getBooks",
                        responseFields(
                                fieldWithPath("[].id").type(JsonFieldType.NUMBER).description("Book ID"),
                                fieldWithPath("[].title").type(JsonFieldType.STRING).description("Title"),
                                fieldWithPath("[].publisher").type(JsonFieldType.STRING).description("Publisher"),
                                fieldWithPath("[].publishedDate").type(JsonFieldType.STRING).description("Published date"),
                                fieldWithPath("[].authors").type(JsonFieldType.ARRAY).description("Authors"),
                                fieldWithPath("[].authors.[].id").type(JsonFieldType.NUMBER).description("Author ID"),
                                fieldWithPath("[].authors.[].name").type(JsonFieldType.STRING).description("Author name"),
                                fieldWithPath("[].reviews").type(JsonFieldType.ARRAY).description("Reviews"),
                                fieldWithPath("[].reviews.[].id").type(JsonFieldType.NUMBER).description("Review ID"),
                                fieldWithPath("[].reviews.[].content").type(JsonFieldType.STRING).description("Review content"),
                                fieldWithPath("[].reviews.[].rating").type(JsonFieldType.NUMBER).description("Rating"),
                                fieldWithPath("[].reviews.[].createdDate").type(JsonFieldType.STRING).description("Created date")
                        )
                ))
                .andDo(print());
    }
}
