package com.shabab.agentpattern.personal_stylist;

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
public class PersonalStylistAgent {


    private final ChatClient.Builder builder;
    public PersonalStylistAgent(ChatClient.Builder builder) {
        this.builder = builder;


    }

    public String startChecking(String filePath) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        ClassPathResource res= new ClassPathResource(filePath);
        Media media=new Media(MimeTypeUtils.parseMimeType("image/jpeg"), res);
        List<Media> mediaList=new ArrayList<>();

        String prompt= """

You are a personal fashion stylist AI.
I will upload a photo of the clothes I am wearing. Your tasks are:

Identify the clothing items in the photo (shirt, pants, shoes, and any other visible items).

Analyze the color combination, patterns, and fabric harmony.

Tell me whether this outfit is suitable for casual, semi-formal, or formal settings.

Suggest accessories (such as a watch, bag, sunglasses, or jewelry) that can complete and elevate my style.

Recommend improvements if needed (for example, changing the color of shoes, adding a layer, or adjusting the fit).

All your analysis and suggestions should be delivered in Persian (Farsi), with a friendly yet professional tone.
  
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

    public String startRecommendNailAndHairColor(String filePath) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        ClassPathResource res= new ClassPathResource(filePath);
        Media media=new Media(MimeTypeUtils.parseMimeType("image/jpeg"), res);
        List<Media> mediaList=new ArrayList<>();

        String prompt= """
You are a personal stylist and beauty advisor AI.
I will upload a photo of myself. Your tasks are:

Identify my current hairstyle.

Identify my current hair color.

Identify my current nail color (if visible).

Suggest alternative hairstyles that suit my face shape.

Recommend hair colors that harmonize with my skin tone and overall style.

Suggest nail colors that best complement my hair and overall look.

Provide three different sets of recommendations:

For formal settings (business meetings, ceremonies, elegant parties).

For casual settings (everyday life, friendly gatherings, leisure).

For date style (romantic setting: attractive, charming, and natural look).
For each setting, explain which hairstyle, hair color, and nail color combination would be most suitable.

All analysis and recommendations must be delivered in Persian (Farsi), with a friendly yet professional tone.
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
