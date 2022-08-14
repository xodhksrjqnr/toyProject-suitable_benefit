package taewan.suitable_benefit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import taewan.suitable_benefit.dto.PostDto;

import java.util.LinkedList;
import java.util.List;

@Controller
public class mainController {

    @GetMapping("")
    public String mainPage(Model model) {
        model.addAttribute("targetPage", "main");
        model.addAttribute("posts", makeDummyPost());
        return "base";
    }

    private List<PostDto> makeDummyPost() {
        List<PostDto> PostDtos = new LinkedList<>();

        for (int i = 0; i < 5; i++)
            PostDtos.add(new PostDto());
        return PostDtos;
    }

    @GetMapping("/login")
    public String postPage(Model model) {
        model.addAttribute("targetPage", "login");
        return "base";
    }
}
