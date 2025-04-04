package afterwork.backend.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import afterwork.backend.domain.BoardDomain;
import afterwork.backend.model.SendBoardResponse;
import afterwork.backend.service.BoardService;
import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final  BoardService boardService;

    // @GetMapping("/hello")
    // public String Hello () {
    //     return "/board/hello";
    // }
    
    // @GetMapping("/test")
    // public String test(Model model) {
    //     model.addAttribute("cnt", boardService.boardCount());
    //     // model.addAttribute("test", boardService.getList());
    //     return "/board/hello";
    // }

    // @GetMapping("/main")
    // public String main(Model model) {
    //     model.addAttribute("list", boardService.getList());
    //     return "/board/main";
    // }

    // @GetMapping("/view")
    // public String viewBoard(Model model, Long boardId) {
    //     model.addAttribute("view", boardService.getBoard(boardId));
    //     return "/board/view";
    // }
    @GetMapping("/all")
    public ResponseEntity<SendBoardResponse> getSendBoardList() {
        try {
            List<BoardDomain> sendBoardList = boardService.getList();
            return ResponseEntity.ok(new SendBoardResponse("success", sendBoardList));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                .body(new SendBoardResponse("fail" + e.getMessage(), null));
        }
    }
}