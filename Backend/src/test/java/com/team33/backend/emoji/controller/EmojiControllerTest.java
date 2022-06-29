package com.team33.backend.emoji.controller;

import com.team33.backend.emoji.domain.Emotion;
import com.team33.backend.emoji.service.EmojiService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.team33.backend.utils.ApiDocumentUtils.HOST;
import static com.team33.backend.utils.ApiDocumentUtils.SCHEME;
import static com.team33.backend.utils.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmojiController.class)
@AutoConfigureRestDocs(uriScheme = SCHEME, uriHost = HOST)
class EmojiControllerTest {

    @MockBean
    private EmojiService emojiService;

    @InjectMocks
    private EmojiController emojiController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("이모티콘을 조회하면 등록된 기본 표정들이 나온다.")
    void getEmotions() throws Exception {
        List<Emotion> emotions = createEmotions();
        given(emojiService.findEmotions()).willReturn(emotions);

        mockMvc.perform(get("/api/issuegroup/emojis")).andExpect(status().isOk())
                .andDo(document("emotion-list",
                        getDocumentResponse(),
                        responseFields(
                                fieldWithPath("[].id").type(JsonFieldType.NUMBER).description("이모티콘 아이디"),
                                fieldWithPath("[].value").type(JsonFieldType.STRING).description("감정")
                        )));
    }

    private List<Emotion> createEmotions() {
        Emotion emojiHappy = new Emotion("Happy");
        ReflectionTestUtils.setField(emojiHappy, "id", 1L);
        Emotion emojiSad = new Emotion("Sad");
        ReflectionTestUtils.setField(emojiSad, "id", 1L);
        return List.of(emojiHappy, emojiSad);
    }
}
