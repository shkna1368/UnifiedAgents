package com.shabab.agentpattern.hr_interview;

import com.shabab.agentpattern.cv.PdfUtils;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.nio.file.Files;

@Service
public class HrInterviewAgent {
    private final ChatClient.Builder builder;



    public HrInterviewAgent(ChatClient.Builder builder) {
        this.builder = builder;


    }

    public String start(String testFilePath ,String level) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ClassPathResource resource = new ClassPathResource(testFilePath);
        String qa= new String(Files.readAllBytes(resource.getFile().toPath()));

        String prompt="""
                You are an expert HR psychologist specializing in technical hiring for software engineers. 
                                                                                                                                                   I will provide you with a transcript of an interview file containing 60 common psychological questions and 15 %s specific questions. Each question has the candidate’s answer. 
                                                                                                                                                   
                                                                                                                                                   Candid question answer:
                                                                                                                                                   %s
                
                                                                                                                                                   Your task: 
                                                                                                                                                   1. Analyze the candidate’s answers and identify their **strengths** (positive traits). 
                                                                                                                                                   2. Analyze their **weaknesses** (potential risks, red flags, or improvement areas). 
                                                                                                                                                   3. Provide a **summary evaluation** of their overall psychological fitness for a Mid-level Software Engineer role. 
                                                                                                                                                   4. Finally, make a **clear decision**: "Accepted" or "Rejected" based on the overall impression. 
                
                                                                                                                                                   Be structured and concise. Use bullet points for strengths and weaknesses, then a short final decision. 
                                              
                                            
                                              **output:
                                               All text except the questions type must be written entirely in Persian script only.
                                                                                         Do NOT include Finglish (Persian in Latin letters) or English explanations.
                                                                                         
                
                 """.formatted(level,qa);


        var client = builder.build();
        var response = client.prompt(prompt).call().content();
        System.out.println(response);
        return response;

    }



}
