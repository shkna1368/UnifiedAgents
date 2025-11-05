package com.shabab.agentpattern.kids_psychology;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class KidsTherapyAgent {
    private final ChatClient.Builder builder;



    public KidsTherapyAgent(ChatClient.Builder builder) {
        this.builder = builder;

    }

    public String startTherapy(String dialog,String age,String gender ) throws MalformedURLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, InterruptedException {



        String prompt = """
             You are a child psychologist specializing in conversational analysis. Below is a transcript of a conversation between an interviewer and a child. The child’s age is also provided.
                
                                  Your task is to provide a psychological interpretation of the child’s responses, based on both the content and the emotional tone implied in the answers.
                
                                  Please analyze the conversation according to the following standard dimensions:
                                  1. Attachment style (secure/insecure)
                                  2. Signs of anxiety (explicit or implicit)
                                  3. Self-esteem and confidence
                                  4. Social skills
                                  5. Imagination and emotional capacity
                                  6. Any possible signs of aggression, depression, or social withdrawal
                                  7. Any other observations worth noting
                
                                  Avoid clinical diagnoses. Focus on psychological patterns and indicators only.
                
                                  In addition, **provide two deeper interpretations**:
                
                                  **A. Lacanian Psychoanalytic Analysis:** 
                                  Analyze the child's language and narrative structure using Lacanian theory. 
                                  Consider:
                                  - The Symbolic, Imaginary, and Real registers 
                                  - Presence of desire, lack, and the Other 
                                  - Slips or metaphoric structures in speech 
                                  - Any indication of how the child positions themselves in relation to language, caregivers, or symbolic authority
                
                                  **B. Transpersonal Psychology Perspective:** 
                                  Evaluate the child’s responses from a transpersonal perspective, focusing on:
                                  - Any expression of higher meaning, spiritual insight, or inner wisdom 
                                  - Expansion of identity beyond ego (e.g. imaginative fusion, archetypal themes) 
                                  - Signs of resilience, intuitive knowing, or connection to something greater 
                                  - Moments of transcendence, awe, or symbolic/metaphoric depth
                
                                  Child’s Age: %s
                                  Child’s Gender: %s
                                  Conversation:
                
                                %s
                
                                
                
                                  Please provide:
                                  1. A standard psychological interpretation (dimensions 1–7)
                                  2. A Lacanian psychoanalytic reading
                                  3. A transpersonal psychological perspective
                
                                  Use a professional, clear, and accessible tone suitable for interdisciplinary psychological review .give me final response in Persian languge.
                                
        """.formatted(age,gender,dialog);


        var client = builder.build();
        var response = client.prompt(prompt).call().content();



        return response;

    }








}
