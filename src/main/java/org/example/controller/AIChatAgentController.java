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

@Tag(name = "AI助手")
@RestController
@RequestMapping("/ai-assistant")
public class AIChatAgentController {
    @Autowired
    private AIChatAgent aiChatAgent;

    @Operation(summary = "对话")
    @PostMapping("/chat")
    public String chat(@RequestBody ChatForm chatForm)  {
        return aiChatAgent.chat(chatForm.getMemoryId(), chatForm.getMessage());
    }
}
