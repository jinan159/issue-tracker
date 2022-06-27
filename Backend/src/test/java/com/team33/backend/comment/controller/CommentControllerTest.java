package com.team33.backend.comment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team33.backend.comment.controller.dto.CommentWriteRequest;
import com.team33.backend.comment.domain.Comment;
import com.team33.backend.comment.service.CommentService;
import com.team33.backend.emoji.controller.dto.cache.CommentCache;
import com.team33.backend.emoji.controller.dto.cache.EmojiCache;
import com.team33.backend.emoji.domain.Emoji;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static com.team33.backend.utils.ApiDocumentUtils.HOST;
import static com.team33.backend.utils.ApiDocumentUtils.SCHEME;
import static com.team33.backend.utils.ApiDocumentUtils.getDocumentRequest;
import static com.team33.backend.utils.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CommentController.class)
@AutoConfigureRestDocs(uriScheme = SCHEME, uriHost = HOST)
class CommentControllerTest {

    @MockBean
    private CommentService commentService;

    @InjectMocks
    private CommentController commentController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("이슈그룹에서 이슈 아이디로 조회하면 해당 댓글이 반환된다.")
    void findCommentsByIssueId() throws Exception {

        List<CommentCache> commentCaches = createCommentCache();
        given(commentService.findCommentsByIssueId(any()))
                .willReturn(commentCaches);
        ResultActions performResult = mockMvc.perform(get("/api/issuegroup/{issueGroupId}/issues/{issueId}/comments", 1L, 1L)
                .queryParam("issueGroupId", "1")
                .queryParam("issueId", "1"));

        performResult.andExpect(status().isOk())
                .andDo(document("comment-list",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        requestParameters(
                                parameterWithName("issueGroupId").description("이슈그룹 아이디"),
                                parameterWithName("issueId").description("이슈 아이디")),
                        responseFields(
                                fieldWithPath("[].id").type(JsonFieldType.NUMBER).description("댓글 아이디"),
                                fieldWithPath("[].content").type(JsonFieldType.STRING).description("댓글 내용"),
                                fieldWithPath("[].emojiCaches.[].id").type(JsonFieldType.NUMBER).description("댓글 이모티콘 아이디"),
                                fieldWithPath("[].emojiCaches.[].emotion").type(JsonFieldType.STRING).description("댓글 이모티콘 표정"),
                                fieldWithPath("[].emojiCaches.[].commentId").type(JsonFieldType.NUMBER).description("이모티콘의 부모 댓글")
                        )));
    }

    private List<CommentCache> createCommentCache() {
        Emoji emoji = new Emoji("Happy");
        ReflectionTestUtils.setField(emoji, "id", 1L);
        EmojiCache emojiCache = new EmojiCache(emoji);
        ReflectionTestUtils.setField(emojiCache, "commentId", 1L);

        CommentCache commentCache = new CommentCache(1L, "Hello-World");
        commentCache.registEmojis(List.of(emojiCache));
        return List.of(commentCache);
    }

    @GetMapping("/{issueGroupId}/issues/{issueId}/comments")
    public List<CommentCache> findComments(@PathVariable Long issueGroupId, @PathVariable Long issueId) {
        return commentService.findCommentsByIssueId(issueId);
    }

    @Test
    @DisplayName("게시글을 작성하면 게시글의 아이디와 내용이 조회된다.")
    void writeComment() throws Exception {
        Comment comment = new Comment("Hello-World");
        ReflectionTestUtils.setField(comment, "id", 1L);

        given(commentService.writeComment(anyLong(), anyLong(), any(), any()))
                .willReturn(comment);

        ObjectMapper objectMapper = new ObjectMapper();
        CommentWriteRequest request = new CommentWriteRequest("Hello-World");
        ResultActions perform = this.mockMvc.perform(
                post("/api/issuegroup/{issueGroupId}/issues/{issueId}/comments", 1L, 1L)
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON)
        );

        perform.andExpect(status().isOk())
                .andDo(document("comment-write",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        requestFields(fieldWithPath("content").type(JsonFieldType.STRING).description("댓글 내용")),
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("댓글 아이디"),
                                fieldWithPath("content").type(JsonFieldType.STRING).description("댓글 내용")
                        )
                )).andReturn();
    }
}
