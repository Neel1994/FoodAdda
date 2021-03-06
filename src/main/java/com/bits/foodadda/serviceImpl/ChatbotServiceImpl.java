package com.bits.foodadda.serviceImpl;

import java.io.File;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.History;
import org.alicebot.ab.MagicBooleans;
import org.alicebot.ab.MagicStrings;
import org.springframework.stereotype.Service;

import com.bits.foodadda.service.ChatbotService;

@Service
public class ChatbotServiceImpl implements ChatbotService{
	
	private static final boolean TRACE_MODE = false;
    static String botName = "super";
    
	public String getResponse(String requestString) {
		String response = "";
		try {
            String resourcesPath = getResourcesPath();
            System.out.println(resourcesPath);
            MagicBooleans.trace_mode = TRACE_MODE;
            Bot bot = new Bot("super", resourcesPath);
            Chat chatSession = new Chat(bot);
            bot.brain.nodeStats();
            
            if ((requestString == null) || (requestString.length() < 1))
            	requestString = MagicStrings.null_input;
            
            String request = requestString;
            if (MagicBooleans.trace_mode)
                System.out.println("STATE=" + request + ":THAT=" + ((History) chatSession.thatHistory.get(0)).get(0) + ":TOPIC=" + chatSession.predicates.get("topic"));
            response = chatSession.multisentenceRespond(request);
            while (response.contains("&lt;"))
                response = response.replace("&lt;", "<");
            while (response.contains("&gt;"))
                response = response.replace("&gt;", ">");
            System.out.println("Robot : " + response);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		return response;
	}
	
	private static String getResourcesPath() {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        path = path.substring(0, path.length() - 2);
        System.out.println(path);
        String resourcesPath = path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
        return resourcesPath;
    }
}
