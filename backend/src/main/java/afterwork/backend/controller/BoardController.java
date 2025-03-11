package afterwork.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import afterwork.backend.service.BoardService;
import lombok.RequiredArgsConstructor;



@Controller
@RequestMapping("/board/**")
@RequiredArgsConstructor
public class BoardController {
    private final  BoardService boardService;

    @GetMapping("/test")
    //Model : 해시맵 형태의 key와 value값으로 사용할수 있는 객체 -> 이를 통해 view로 데이터를 넘겨줄수 있게함.
    public String test(Model model) {
        //model.addAttribute -> view에서 불러올 데이터의 값. 즉 key값 의미.
        model.addAttribute("cnt",boardService.boardCount());
        model.addAttribute("test", boardService.boardList());
        return "/boards/hello";
    }
    
    
}
