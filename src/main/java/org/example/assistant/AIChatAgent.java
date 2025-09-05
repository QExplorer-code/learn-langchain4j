package org.example.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(
        wiringMode = EXPLICIT,
        chatModel = "qwenChatModel",
        chatMemoryProvider = "chatMemoryProviderChat",
        tools = "appointmentTools", // 配置tools
        contentRetriever = "contentRetrieverChat" // 配置向量存储
)
public interface AIChatAgent {

    @SystemMessage(fromResource = "AI-chat-prompt-template.txt")
    String chat(@MemoryId Long memoryId, @UserMessage String userMessage);
}
