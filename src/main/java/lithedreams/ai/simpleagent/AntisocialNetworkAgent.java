package lithedreams.ai.simpleagent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;
import com.google.adk.agents.SequentialAgent;
import com.google.adk.tools.GoogleSearchTool;

public class AntisocialNetworkAgent {

    public static BaseAgent ROOT_AGENT = initAgent();

    private static BaseAgent initAgent() {

        String baseInstructions = "Prefix the reply with the format \"YOUR NAME:\". Be succint in your reply. Address what others told if needed. Use google_search tool if needed. ";

        Map<String, String> agentInstructions = new LinkedHashMap<>();
        agentInstructions.put("Chad", "You are overly confident and dismissive.");
        agentInstructions.put("Nina", "You are supportive but slightly passive-aggressive");
        agentInstructions.put("Alex", "You are sarcastic and cynical");
        agentInstructions.put("Pat", "You are conspiratorial and paranoid");
        agentInstructions.put("John",
                "You are the most grounded, reasoning on all points of view and offering the best reply");

        List<LlmAgent> agentList = new ArrayList<>();
        for (Entry<String, String> instructions : agentInstructions.entrySet()) {
            LlmAgent singleAgent = LlmAgent.builder().name(instructions.getKey()).instruction(
                    baseInstructions
                            + instructions.getValue())
                    .model("gemini-2.5-flash").outputKey("data")
                    .tools(GoogleSearchTool.INSTANCE)
                    .build();
            agentList.add(singleAgent);
        }

        SequentialAgent pipeline = SequentialAgent.builder().name("AntisocialNetwork").subAgents(agentList).build();
        return pipeline;
    }

}