package com.jeon.board.Controller;

import com.jeon.board.dto.BoardDto;
import com.jeon.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//모든 필드를 인자값으로 하는 생성자를 @Autowired 없이 @AllArgsConstructor가 대신 생성하여 주입
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;
    @GetMapping("/")
    public String list(){
        return "board/list.html";
    }

    @GetMapping("/post")
    public String write(){
        return "board/write.html";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto){
        boardService.savePost(boardDto);

        return "redirect:/";
    }
}
