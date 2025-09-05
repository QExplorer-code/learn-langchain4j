package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.assistant.AIChatAgent;
import org.example.bean.ChatForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Tag(name = "AI助手")
@RestController
@RequestMapping("/ai-assistant")
public class AIChatAgentController {
    @Autowired
    private AIChatAgent aiChatAgent;

    @Operation(summary = "对话")
    @PostMapping(value = "/chat", produces = "text/stream;charset=utf-8") // 添加prodeces流式输出方式
    public Flux<String> chat(@RequestBody ChatForm chatForm)  {
        return aiChatAgent.chat(chatForm.getMemoryId(), chatForm.getMessage());
    }
}
