package com.team33.backend.issue.controller;

import com.team33.backend.issue.domain.Milestone;
import com.team33.backend.issue.repository.MilestoneRepository;
import com.team33.backend.issue.service.MilestoneService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;

import static com.team33.backend.utils.ApiDocumentUtils.HOST;
import static com.team33.backend.utils.ApiDocumentUtils.SCHEME;
import static com.team33.backend.utils.ApiDocumentUtils.getDocumentRequest;
import static com.team33.backend.utils.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MilestoneController.class)
@AutoConfigureRestDocs(uriScheme = SCHEME, uriHost = HOST)
class MilestoneControllerTest {

    @MockBean
    private MilestoneService milestoneService;

    @InjectMocks
    private MilestoneController milestoneController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("마일스톤 아이디로 조회하면 해당 마일스톤이 나오게 된다.")
    void findMilestoneByIssuegroupId() throws Exception {
        Milestone milestone = createMilestone();
        given(milestoneService.findMilestoneByIssuegroupId(any()))
                .willReturn(milestone);

        ResultActions performResult = mockMvc.perform(get("/api/issuegroup/{issueGroupId}/milestone/{milestoneId}", 1L, 1L)
                .queryParam("issueGroupId", "1")
                .queryParam("milestoneId", "1"));

        performResult.andExpect(status().isOk())
                .andDo(document(
                        "milestone-get",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        requestParameters(
                                parameterWithName("issueGroupId").description("이슈그룹 아이디"),
                                parameterWithName("milestoneId").description("마일스톤 아이디")
                        ),
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("마일스톤 아이디"),
                                fieldWithPath("title").type(JsonFieldType.STRING).description("마일스톤 제목"),
                                fieldWithPath("deadline").type(JsonFieldType.STRING).description("마일스톤 마감일")
                        )));
    }

    private Milestone createMilestone() {
        Milestone milestone = new Milestone("issue-tracker", "issue-tracker Team33", LocalDate.now());
        ReflectionTestUtils.setField(milestone, "id", 1L);
        return milestone;
    }
}
