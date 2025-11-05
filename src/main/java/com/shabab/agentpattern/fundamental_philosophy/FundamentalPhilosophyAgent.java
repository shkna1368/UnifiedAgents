package com.shabab.agentpattern.fundamental_philosophy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.*;
import com.shabab.agentpattern.browseragent.Component;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import org.stringtemplate.v4.ST;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class FundamentalPhilosophyAgent {
    private final ChatClient.Builder builder;



    public FundamentalPhilosophyAgent(ChatClient.Builder builder) {
        this.builder = builder;

    }

    public String  start(String answerSheet ) throws MalformedURLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

            String prompt = """
                    Based on the following completed questionnaire, which analyzes an individual's beliefs and worldview, provide a comprehensive philosophical profile.
                    
                    In your analysis, please address the following points:
                    
                    1.  **Core Philosophy:** What is the single most central belief or principle that seems to influence all their other views?
                    2.  **Connection Between Beliefs:** Explain how their views on ethics, metaphysics, and epistemology are interconnected. Identify and discuss any notable consistencies or contradictions.
                    3.  **Hypothetical Scenario:** Describe a hypothetical situation (e.g., a difficult professional or social decision) and explain how this individual would likely approach it based on their extracted philosophy.
                    4.  **Final Summary:** Summarize their entire philosophy in one or two key, memorable sentences.
                    
                    Then move to the second part: **Philosophical Coaching**. 
                        In this section, act as a coach and help the user reflect on and apply their personal philosophy for growth and better decision-making. 
                        The coaching process should include the following steps: 
                        - **Reflection:** Provide a clear and concise summary of the person’s beliefs and philosophy. 
                        - **Highlighting Tensions:** Point out any contradictions or tensions within their worldview. 
                        - **Exploratory Questions:** Ask a few open-ended questions to encourage deeper reflection. 
                        - **Action Design:** Suggest how they can translate their philosophy into practical behaviors in life or work. 
                        - **Commitment:** Encourage the user to identify one small decision or action they will commit to based on their philosophy. 
                    
                    **Important Instruction:** The entire final analysis and all parts of your output must be written in the **Persian (Farsi)** language.
                    
                    Here is the completed questionnaire:%s
                
                """.formatted(answerSheet);
            var client = builder.build();
            var response2 = client.prompt(prompt).call().content();
          return   response2;


    }

    public String  startCoaching(String fundamentalPhilosphy ) throws MalformedURLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        String prompt = """
                  You are a professional philosophical coach. 
                      The user has completed a questionnaire about their core philosophy of life.
                    
                      Your task:
                      1. Analyze the user’s answers and extract their **core beliefs, values, contradictions, and priorities**. 
                      2. Design a **4-session coaching plan** (one session per week). 
                      3. For each session, generate **5–7 coaching questions** that are: 
                         - Clear, open-ended, and reflective 
                         - Specifically tailored to the user’s answers and philosophical profile
                         - Designed to guide the user from awareness → identifying tensions → applying philosophy → long-term commitment \s
                    
                      Structure your output as follows: 
                    
                      ### Session 1: Self-awareness & Philosophy Mapping
                      - Questions: [list of tailored questions]
                    
                      ### Session 2: Exploring Contradictions & Tensions
                      - Questions: [list of tailored questions]
                    
                      ### Session 3: Applying Philosophy in Real Life
                      - Questions: [list of tailored questions]
                    
                      ### Session 4: Commitment & Future Vision
                      - Questions: [list of tailored questions]
                    
                      Guidelines: 
                      - Questions must be **specific to the user’s philosophy**, not generic. 
                      - Avoid yes/no questions; always use open-ended formats. 
                      - Keep the language in **Persian (Farsi)** so the user can use it directly in coaching sessions. 
                    Here is the completed questionnaire:%s
                
                """.formatted(fundamentalPhilosphy);
        var client = builder.build();
        var response2 = client.prompt(prompt).call().content();
        return   response2;


    }
}




