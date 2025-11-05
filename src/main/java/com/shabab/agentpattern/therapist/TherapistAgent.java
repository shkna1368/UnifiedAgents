package com.shabab.agentpattern.therapist;

import com.shabab.agentpattern.cv.PdfUtils;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.content.Media;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TherapistAgent {
    private final ChatClient.Builder builder;


    public TherapistAgent(ChatClient.Builder builder, PdfUtils pdfUtils) {
        this.builder = builder;


    }



public String startTherapy(String filePath) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        ClassPathResource res= new ClassPathResource(filePath);
        Media media=new Media(MimeTypeUtils.parseMimeType("audio/mp3"), res);
 List<Media> mediaList=new ArrayList<>();

 String prompt= """
         You are a clinical psychologist and schema therapist.
         
                                                         Your task is to analyze the following transcript from a conversation with a client and identify any signs of **Early Maladaptive Schemas (EMS)** based on Jeffrey Young’s schema therapy model.
         
                                                         There are 18 schemas in total, including Emotional Deprivation, Abandonment, Mistrust/Abuse, Defectiveness/Shame, Social Isolation, Dependence, Vulnerability to Harm, Enmeshment, Failure, Entitlement, Insufficient Self-Control, Subjugation, Self-Sacrifice, Approval-Seeking, Emotional Inhibition, Unrelenting Standards, Negativity/Pessimism, and Punitiveness.
         
                                                         For each schema that appears relevant:
                                                         - Mention the schema name
                                                         - Provide 1–2 supporting quotes or phrases from the transcript
                                                         - Briefly explain why that quote indicates that schema (emotionally or cognitively)
                                                         - Optionally, rate the schema’s intensity (Low / Moderate / High)
         
                                                         Only analyze what’s present in the text. If a schema is not present, do not invent it. Be concise but clinically insightful.
                                                         give me result in persian
         
                                                         Here is the transcript:
         
  
         """;
 mediaList.add(media);;
        var userMessage=UserMessage.builder()
                .text(prompt)
                .media(mediaList)
                .build();




        //ChatResponse response = chatModel.call(new Prompt(List.of(this.userMessage)));


        var client = builder.build();

        var response = client.prompt(new Prompt(List.of(userMessage))).call().content();
        System.out.println(response);
        return response;

    }




}
