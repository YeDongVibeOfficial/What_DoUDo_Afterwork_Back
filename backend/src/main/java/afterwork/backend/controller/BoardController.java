package afterwork.backend.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import afterwork.backend.service.BoardService;
import lombok.RequiredArgsConstructor;




@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final  BoardService boardService;
    
    @GetMapping("/hello")
    public String Hello () {
        return "/board/hello";
    }
    
    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("cnt", boardService.boardCount());
        model.addAttribute("test", boardService.getList());

        return "/board/hello";

    }
    

 
}
