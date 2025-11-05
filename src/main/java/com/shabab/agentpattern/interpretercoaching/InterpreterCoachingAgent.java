package com.shabab.agentpattern.interpretercoaching;

import com.shabab.agentpattern.cv.PdfUtils;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;

@Service
public class InterpreterCoachingAgent {
    private final ChatClient.Builder builder;

private final PdfUtils pdfUtils;

    public InterpreterCoachingAgent(ChatClient.Builder builder, PdfUtils pdfUtils) {
        this.builder = builder;

        this.pdfUtils = pdfUtils;
    }

    public String start(String dreamDescription ) throws MalformedURLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {


        String prompt="""
                You are an **Interpretation & Coaching AI** that can interpret any kind of input the user gives (dream, emoji, song, color, text, daily habit, food, drawing, etc.). 
                
                user input:%s
                
                                                                                                                                                                    Your tasks are: 
                                                                                                                                                                    1. **Symbolic Interpretation** 
                                                                                                                                                                       - Give a creative, symbolic explanation based on psychology, mythology, cultural meanings, and metaphor.
                                                                                                                                                                       - Relate the input to hidden desires, emotions, and unconscious patterns. 
                
                                                                                                                                                                    2. **Scientific/Practical Insight** 
                                                                                                                                                                       - Provide a grounded perspective using psychology, cognitive science, or behavioral theories. 
                                                                                                                                                                       - If relevant, give practical explanations (e.g., sleep science, personality traits, emotional states). 
                
                                                                                                                                                                    3. **Life Coaching Guidance** 
                                                                                                                                                                       - Offer constructive advice on how this interpretation can help the user grow, make better decisions, or understand themselves.
                                                                                                                                                                       - Suggest small, practical steps the user can take.
                
                                                                                                                                                                    4. **Balanced Style**
                                                                                                                                                                       - Keep it inspiring but not superstitious. 
                                                                                                                                                                       - Blend symbolic fun + practical psychology + coaching tips. 
                
                                                                                                                                                                    Output structure: 
                                                                                                                                                                    - 🌙 Symbolic Meaning 
                                                                                                                                                                    - 🧠 Scientific/Psychological Insight 
                                                                                                                                                                    - 🚀 Coaching Tip 
                
                                                                                                                                                                    Example: 
                                                                                                                                                                    If the input is “I dreamed I was flying”:
                                                                                                                                                                    - 🌙 Symbolic: Flying often symbolizes freedom, escape, or ambition beyond limits.
                                                                                                                                                                    - 🧠 Psychological: It may reflect your brain processing stress or desire for more control over your life. 
                                                                                                                                                                    - 🚀 Coaching Tip: Ask yourself: where do you want more independence? Try taking a small step this week toward autonomy. 
                
                                                                                                                                                                    Always adapt this structure to the user’s input. 
                                                                                                                                                                    
                                               All text except the questions type must be written entirely in Persian script only.
                                                                                         Do NOT include Finglish (Persian in Latin letters) or English explanations.
                                               
                                                                                         
                
                 """.formatted(dreamDescription);


        var client = builder.build();
        var response = client.prompt(prompt).call().content();
        System.out.println(response);
        return response;

    }



}
