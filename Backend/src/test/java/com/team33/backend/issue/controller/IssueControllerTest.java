package com.team33.backend.issue.controller;


import com.team33.backend.issue.controller.dto.MemberResponse;
import com.team33.backend.issue.controller.dto.issue.IssueListResponse;
import com.team33.backend.issue.controller.dto.issue.IssueResponse;
import com.team33.backend.issue.controller.dto.label.LabelResponse;
import com.team33.backend.issue.controller.dto.milestone.MilestoneResponse;
import com.team33.backend.issue.service.IssueService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.team33.backend.utils.ApiDocumentUtils.HOST;
import static com.team33.backend.utils.ApiDocumentUtils.SCHEME;
import static com.team33.backend.utils.ApiDocumentUtils.getDocumentRequest;
import static com.team33.backend.utils.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(IssueController.class)
@AutoConfigureRestDocs(uriScheme = SCHEME, uriHost = HOST)
class IssueControllerTest {

    @MockBean
    private IssueService issueService;

    @InjectMocks
    private IssueController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void 열린_이슈_조회를_했을때_열린_이슈가_2개_있으면_열린_이슈_2개가_반환된다() throws Exception {
        // given
        int openIssueCount = 2;
        int closedIssueCount = 0;

        List<IssueResponse> issues = List.of(
                createNewIssueResponse(1, "이슈입니다.", 1, "제이",
                        1, "마일스톤", 1, "긴급", 1, "제이지"),
                createNewIssueResponse(2, "이슈입니다.", 2, "제이",
                        2, "마일스톤", 2, "긴급", 2, "제이지")
        );

        IssueListResponse response = new IssueListResponse(issues, openIssueCount, closedIssueCount);

        BDDMockito.given(issueService.findAllIssueWithStatus(any()))
                .willReturn(response);

        // when
        ResultActions performResult = mockMvc.perform(get("/api/issuegroup/1/issues")
                .queryParam("page", "1")
                .queryParam("size", "10")
                .queryParam("status", "OPEN"));

        // then
        ResultActions resultActions = performResult.andExpect(status().isOk())
                .andExpect(jsonPath("$.openIssueCount").value(openIssueCount))
                .andExpect(jsonPath("$.closedIssueCount").value(closedIssueCount));

        for (int i = 0; i < response.getIssues().size(); i++) {
            IssueResponse issue = response.getIssues().get(i);
            resultActions.andExpect(jsonPath("$.issues[%d]", i).exists())
                    .andExpect(jsonPath("$.issues[%d].id", i).value(issue.getId()))
                    .andExpect(jsonPath("$.issues[%d].title", i).value(issue.getTitle()))
                    .andExpect(jsonPath("$.issues[%d].author", i).exists())
                    .andExpect(jsonPath("$.issues[%d].author.id", i).value(issue.getAuthor().getId()))
                    .andExpect(jsonPath("$.issues[%d].author.name", i).value(issue.getAuthor().getName()))
                    .andExpect(jsonPath("$.issues[%d].author.profileImageUrl", i).value(issue.getAuthor().getProfileImageUrl()))
                    .andExpect(jsonPath("$.issues[%d].createdAt", i).value(issue.getCreatedAt().toString()))
                    .andExpect(jsonPath("$.issues[%d].milestone", i).exists())
                    .andExpect(jsonPath("$.issues[%d].milestone.id", i).value(issue.getMilestone().getId()))
                    .andExpect(jsonPath("$.issues[%d].milestone.title", i).value(issue.getMilestone().getTitle()))
                    .andExpect(jsonPath("$.issues[%d].milestone.deadline", i).value(issue.getMilestone().getDeadline().toString()));

            for (int j = 0; j < issue.getLabels().size(); j++) {
                LabelResponse label = issue.getLabels().get(j);
                resultActions.andExpect(jsonPath("$.issues[%d].labels[%d]", i, j).exists())
                        .andExpect(jsonPath("$.issues[%d].labels[%d].id", i, j).value(label.getId()))
                        .andExpect(jsonPath("$.issues[%d].labels[%d].name", i, j).value(label.getName()))
                        .andExpect(jsonPath("$.issues[%d].labels[%d].color", i, j).value(label.getColor()));
            }

            for (int j = 0; j < issue.getAssignees().size(); j++) {
                MemberResponse member = issue.getAssignees().get(j);
                resultActions.andExpect(jsonPath("$.issues[%d].assignees[%d]", i, j).exists())
                        .andExpect(jsonPath("$.issues[%d].assignees[%d].id", i, j).value(member.getId()))
                        .andExpect(jsonPath("$.issues[%d].assignees[%d].name", i, j).value(member.getName()))
                        .andExpect(jsonPath("$.issues[%d].assignees[%d].profileImageUrl", i, j).value(member.getProfileImageUrl()));
            }

            resultActions.andDo(document("issue-list",
                    getDocumentRequest(),
                    getDocumentResponse(),
                    requestParameters(
                            parameterWithName("page").description("현재 페이지"),
                            parameterWithName("size").description("페이지 크기"),
                            parameterWithName("status").description("이슈 상태")
                    ),
                    responseFields(
                            fieldWithPath("openIssueCount").type(JsonFieldType.NUMBER).description("열린 이슈 개수"),
                            fieldWithPath("closedIssueCount").type(JsonFieldType.NUMBER).description("닫힌 이슈 개수"),
                            fieldWithPath("issues.[].id").type(JsonFieldType.NUMBER).description("이슈 아이디"),
                            fieldWithPath("issues.[].title").type(JsonFieldType.STRING).description("이슈 제목"),
                            fieldWithPath("issues.[].author.id").type(JsonFieldType.NUMBER).description("작성자 아이디"),
                            fieldWithPath("issues.[].author.name").type(JsonFieldType.STRING).description("작성자명"),
                            fieldWithPath("issues.[].author.profileImageUrl").type(JsonFieldType.STRING).description("작성자 프로필 이미지 주소"),
                            fieldWithPath("issues.[].createdAt").type(JsonFieldType.STRING).description("이슈 작성일시"),
                            fieldWithPath("issues.[].milestone.id").type(JsonFieldType.NUMBER).description("마일스톤 아이디"),
                            fieldWithPath("issues.[].milestone.title").type(JsonFieldType.STRING).description("마일스톤 제목"),
                            fieldWithPath("issues.[].milestone.deadline").type(JsonFieldType.STRING).description("마일스톤 기한"),
                            fieldWithPath("issues.[].labels.[].id").type(JsonFieldType.NUMBER).description("레이블 아이디"),
                            fieldWithPath("issues.[].labels.[].name").type(JsonFieldType.STRING).description("레이블 이름"),
                            fieldWithPath("issues.[].labels.[].color").type(JsonFieldType.STRING).description("레이블 색상"),
                            fieldWithPath("issues.[].assignees.[].id").type(JsonFieldType.NUMBER).description("담당자 아이디"),
                            fieldWithPath("issues.[].assignees.[].name").type(JsonFieldType.STRING).description("담당자명"),
                            fieldWithPath("issues.[].assignees.[].profileImageUrl").type(JsonFieldType.STRING).description("담당자 프로필 이미지 주소")
                    )));
        }
    }

    private IssueResponse createNewIssueResponse(long issueId,
                                                 String title,
                                                 long memberId,
                                                 String author,
                                                 long milestoneId,
                                                 String milestoneTitle,
                                                 long labelId,
                                                 String labelName,
                                                 long assigneeId,
                                                 String assigneeName) {
        return new IssueResponse(
                issueId,
                title,
                LocalDateTime.of(2022, 6, 24, 21, 30, 20),
                new MemberResponse(memberId, author, "https://fake.url"),
                new MilestoneResponse(milestoneId, milestoneTitle, LocalDate.of(2022, 6, 30)),
                List.of(new LabelResponse(labelId, labelName, "545454")),
                List.of(new MemberResponse(assigneeId, assigneeName, "https://fake.url"))
        );
    }

}