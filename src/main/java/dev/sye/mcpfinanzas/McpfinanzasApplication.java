package dev.sye.mcpfinanzas;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class McpfinanzasApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpfinanzasApplication.class, args);
	}

	@Bean
	public ToolCallbackProvider finanzasTools(FinanzasService finanzasService) {
		return MethodToolCallbackProvider.builder().toolObjects(finanzasService).build();
	}

}
