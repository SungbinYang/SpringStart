package me.sungbin.put;

import me.sungbin.put.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put/{userId}")
    public PutRequestDto put(@RequestBody PutRequestDto requestDto, @PathVariable(name = "userId") String id) {
        System.out.println(requestDto);
        System.out.println(id);
        return requestDto;
    }
}
