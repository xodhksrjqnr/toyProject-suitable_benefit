package taewan.SB.tag;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import taewan.SB.controller.TagController;
import taewan.SB.dto.tag.TagDto;
import taewan.SB.service.TagService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@EnableConfigurationProperties
@ExtendWith(MockitoExtension.class)
@WebMvcTest(TagController.class)
public class TagControllerTest {

    @Autowired private MockMvc mockMvc;

    @MockBean private TagService tagService;

    @Value("${admin.origins}") private String adminUrl;

    @Value("${client.origins}") private String clientUrl;

    @Test
    void 태그_등록() throws Exception {
        //given
        String tagName = "태그1";

        when(tagService.save(tagName)).thenReturn(1L);

        //when
        ResultActions actions =
                mockMvc.perform(post(adminUrl + "/tags/" + tagName));

        //then
        actions
                .andExpect(status().isFound())
                .andExpect(redirectedUrl(adminUrl));
        verify(tagService, times(1)).save(tagName);
    }

    @Test
    void 태그_전체조회() throws Exception {
        //given
        List<TagDto> tags = new ArrayList<>();

        for (int i = 1; i <= 10; i++)
            tags.add(TagTestFixture.createTagDto((long)i, "태그" + i));

        when(tagService.findAll()).thenReturn(tags);

        //when
        ResultActions clientAction =
                mockMvc.perform(get(clientUrl + "/tags"));
        ResultActions adminAction =
                mockMvc.perform(get(adminUrl + "/tags"));

        //then
        clientAction
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        adminAction
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(tagService, times(2)).findAll();
    }
}
