package com.shabab.agentpattern.dream_interpretation;

import com.shabab.agentpattern.cv.PdfUtils;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.List;

@Service
public class DreamInterpretationAgent {
    private final ChatClient.Builder builder;

private final PdfUtils pdfUtils;

    public DreamInterpretationAgent(ChatClient.Builder builder, PdfUtils pdfUtils) {
        this.builder = builder;

        this.pdfUtils = pdfUtils;
    }

    public String start(String dreamDescription ) throws MalformedURLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {


        String prompt="""
                You are a highly skilled dream interpretation expert and a personal life/emotional coach.. For any dream I provide, you will analyze it deeply using multiple layers: scientific, psychological, cultural, symbolic, and practical. Follow these instructions for each dream:
                
                                              1. Scientific interpretation:
                                                 - Analyze the dream based on  psychology and brain theories (Freud, Jung, Activation-Synthesis, information processing, etc.).
                                                 
                                                 - Analyze the dream based on Freud theories.
                                                 - Analyze the dream based on Jung theories.
                                                 - Analyze the dream based on  Activation-Synthesis.
                                                 - Analyze the dream based on  information processing.
                                                 - Explain possible causes or triggers in the dreamer’s daily life, emotions, or subconscious mind.
                
                                              2. Symbolic/cultural interpretation:
                                                 - Explore symbols, signs, and messages according to various cultural, religious, and traditional perspectives (Islamic, Iranian, Western, etc.).
                                                 - Include possible predictions or insights drawn from these perspectives.
                
                                              3. Emotional and situational analysis:
                                                 - Assess what emotions the dream reflects (fear, joy, anxiety, desire, etc.).
                                                 - Identify any connections to current personal, social, or professional situations.
                
                                             4. Practical advice and insights and coaching::
                                                 - Suggest actionable steps, coping strategies, or self-reflection based on the scientific, cultural, and emotional analysis.
                                                 - Provide coaching advice to help the dreamer grow emotionally, mentally, and in daily life decisions.
                
                                              5. Dream positivity/negativity score:
                                                 - Rate the dream’s overall "positive or negative" impact on a scale of 1–10 (1 = very negative, 10 = very positive).
                
                                              Response format:
                                              - Dream provided: "..."
                                              - Scientific interpretation: ...
                                              - Symbolic/cultural interpretation: ...
                                              - Emotional/situational analysis: ...
                                              - Practical advice/insights: ...
                                              - Positivity/negativity score (1–10): ...
                                              
                                              
                                              
                                              user's dream : %s
                
                                              based on user's dream perform a full, detailed, multi-layered analysis following the above structure
                                              
                                            
                                              **output:
                                               All text except the questions type must be written entirely in Persian script only.
                                                                                         Do NOT include Finglish (Persian in Latin letters) or English explanations.
                                                                                         
                
                 """.formatted(dreamDescription);


        var client = builder.build();
        var response = client.prompt(prompt).call().content();
        System.out.println(response);
        return response;

    }



}
