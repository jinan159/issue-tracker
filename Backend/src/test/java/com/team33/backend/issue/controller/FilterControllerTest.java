package com.team33.backend.issue.controller;

import com.team33.backend.issue.controller.dto.filter.FilterResponse;
import com.team33.backend.issue.service.FilterService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static com.team33.backend.utils.ApiDocumentUtils.HOST;
import static com.team33.backend.utils.ApiDocumentUtils.SCHEME;
import static com.team33.backend.utils.ApiDocumentUtils.getDocumentRequest;
import static com.team33.backend.utils.ApiDocumentUtils.getDocumentResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FilterController.class)
@AutoConfigureRestDocs(uriScheme = SCHEME, uriHost = HOST)
class FilterControllerTest {

    @MockBean
    private FilterService filterService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void 필터_목록을_조회하면_필터_목록이_반환된다() throws Exception {
        // given
        List<FilterResponse> filterResponses =  List.of(
                new FilterResponse("is:test", "테스트입니다"),
                new FilterResponse("commented:@me", "댓글단것"),
                new FilterResponse("assigned:@me", "할당된것")
        );

        BDDMockito.given(filterService.findAllFilters())
                .willReturn(filterResponses);

        // when
        ResultActions performResult = mockMvc.perform(get("/api/filters"));

        // then
        performResult.andExpect(status().isOk());

        for (int i = 0; i < filterResponses.size(); i++) {
            FilterResponse expectedResponse = filterResponses.get(i);

            performResult.andExpect(jsonPath("$.[%d].filter", i).value(expectedResponse.getFilter()));
            performResult.andExpect(jsonPath("$.[%d].description", i).value(expectedResponse.getDescription()));
        }

        performResult.andDo(document("filter-list",
                getDocumentRequest(),
                getDocumentResponse(),
                responseFields(
                        fieldWithPath("[].filter").type(JsonFieldType.STRING).description("필터"),
                        fieldWithPath("[].description").type(JsonFieldType.STRING).description("필터 설명")
                )));
    }


}