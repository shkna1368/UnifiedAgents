package com.shabab.agentpattern.public_presentation;

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
public class PublicPresentationAgent {


    private final ChatClient.Builder builder;
    public PublicPresentationAgent(ChatClient.Builder builder) {
        this.builder = builder;


    }

    public String startTest(String filePath) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        ClassPathResource res= new ClassPathResource(filePath);
        Media media=new Media(MimeTypeUtils.parseMimeType("audio/mp3"), res);
        List<Media> mediaList=new ArrayList<>();

        String prompt= """
            You are a professional public speaking coach.
             Analyze the quality of this speech in detail.
              Evaluate the speaker’s performance in terms of delivery, audience engagement, and message clarity.
               Identify both the strengths and weaknesses of the speech. 
               Finally, provide actionable suggestions for improvement, including tips on vocal tone, pacing, body language, content organization, and audience interaction.
                give me response in text in persian and english .
 
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
