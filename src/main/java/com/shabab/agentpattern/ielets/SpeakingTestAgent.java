package com.shabab.agentpattern.ielets;

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
public class SpeakingTestAgent {


    private final ChatClient.Builder builder;
    public SpeakingTestAgent(ChatClient.Builder builder) {
        this.builder = builder;


    }

    public String startTest(String filePath) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        ClassPathResource res= new ClassPathResource(filePath);
        Media media=new Media(MimeTypeUtils.parseMimeType("audio/mp3"), res);
        List<Media> mediaList=new ArrayList<>();

        String prompt= """
                You are an IELTS Speaking examiner.
                                                                                        The user will provide you with a voice recording of their spoken response to a speaking task. Your job is to evaluate their speaking performance based on the IELTS Speaking Band Descriptors, which include:
                
                                                                                        Fluency and Coherence
                
                                                                                        Lexical Resource
                
                                                                                        Grammatical Range and Accuracy
                
                                                                                        Pronunciation
                
                                                                                        Please listen carefully to the audio and give a detailed evaluation in each of the four criteria, followed by an estimated overall band score (e.g., 6.0, 6.5, 7.0, etc.). Justify your score clearly based on IELTS standards.
                
                
         
  
         """;
        mediaList.add(media);;
        var userMessage= UserMessage.builder()
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
