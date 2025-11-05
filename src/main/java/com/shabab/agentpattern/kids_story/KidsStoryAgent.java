package com.shabab.agentpattern.kids_story;

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
public class KidsStoryAgent {


    private final ChatClient.Builder builder;
    public KidsStoryAgent(ChatClient.Builder builder) {
        this.builder = builder;


    }

    public String startCheckingTrapy(String filePath,int age,String gender) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        ClassPathResource res= new ClassPathResource(filePath);
        Media media=new Media(MimeTypeUtils.parseMimeType("image/jpeg"), res);
        List<Media> mediaList=new ArrayList<>();

        String prompt= """
                You are a child psychology assistant trained in analyzing children's drawings. A drawing made by a child has been uploaded. The child is %s years old and identifies as %s. Please consider the child's age and gender developmentally when analyzing the drawing.
                
                Carefully examine and analyze the following elements:
                
                - Use of colors (e.g., bright vs. dark, use of black/red, chaotic color use)
                - Placement and size of people, animals, or objects in the drawing
                - Facial expressions, body proportions, and limb presence
                - Presence or absence of key elements like family members, home, sun, animals, etc.
                - Any unusual, repetitive, or emotionally intense symbols or themes (e.g., isolation, violence, floating objects, walls)
                
                Based on established psychological theories of children's drawings (such as Machover's House-Tree-Person, Koppitz's emotional indicators, and Lowenfeld's developmental stages), provide possible emotional or psychological indicators such as:
                - Anxiety
                - Insecurity or low self-esteem
                - Social withdrawal or fear of abandonment
                - Exposure to trauma or neglect
                - Aggression or anger
                - Depression or sadness
                
                Do **not** make any clinical diagnoses. Instead, describe **possible emotional indicators** based on the drawing, keeping the child's developmental stage in mind, and recommend seeking a professional child psychologist if any serious emotional cues are observed.
                
                Now, analyze the uploaded drawing accordingly and give me final response in Persian language.
  
         """.formatted(age,gender);
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

    public String startMakingStory(String filePath,String language,int age,String gender) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        ClassPathResource res= new ClassPathResource(filePath);
        Media media=new Media(MimeTypeUtils.parseMimeType("image/jpeg"), res);
        List<Media> mediaList=new ArrayList<>();

        String prompt= """
          You are a creative children's storyteller. A child has drawn a picture, and your task is to write a short, imaginative story (300–500 words) inspired by the drawing.
                
                 The child is %s years old and identifies as %s. Please take the child’s age and gender into account when crafting the story — use language, themes, and ideas that are developmentally appropriate and engaging for a child of that age and background.
                
                 Carefully observe the visual elements of the drawing, such as:
                 - Characters (humans, animals, imaginary or magical beings)
                 - Setting (place, time of day, fantasy or real world)
                 - Objects and symbols (e.g., stars, rainbows, monsters, cages, hearts)
                 - Colors and emotions expressed (e.g., warm and happy, dark and mysterious)
                
                 Now, based on the drawing, invent a short story that:
                 - Has a clear beginning, middle, and end
                 - Reflects the emotional tone and visual themes in the drawing
                 - Uses simple, playful, and age-appropriate language
                 - Includes a thoughtful, positive, or magical message that resonates with children
                 - (Optional) Leaves room for imagination or moral reflection
                
                 Now, look at the drawing and write the story.
                give me result in %s language.
  
         """.formatted(age,gender,language);
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

    public String startTeachSecondLanguage(String filePath,String nativeLanguge,String targetLanguage,int age,String gender) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        ClassPathResource res= new ClassPathResource(filePath);
        Media media=new Media(MimeTypeUtils.parseMimeType("image/jpeg"), res);
        List<Media> mediaList=new ArrayList<>();

        String prompt= """
                You are a bilingual storyteller and language tutor for children. A child has drawn a picture. Your job is to write a short, imaginative story (250–400 words) inspired by the drawing to help the child learn %s as a second language.consider kids native language is %s.
                
                                                      The child is %s years old and identifies as %s. Use age-appropriate vocabulary, sentence length, and grammar. Make the story engaging for a child of that age and include helpful repetition of key %s words and phrases.
                
                                                      Use the drawing as your creative guide, and pay attention to:
                                                      - Characters (e.g., animals, magical beings, family members)
                                                      - Setting (e.g., nature, city, space, fantasy worlds)
                                                      - Objects and actions in the scene
                                                      - Emotional tone and colors used in the drawing
                
                                                      Make sure the story:
                                                      - Has a beginning, middle, and end
                                                      - Reflects the visual and emotional elements of the drawing
                                                      - Repeats key English words and phrases to reinforce learning
                                                      - Includes optional translation support in the child’s native language (if necessary)
                                                      - Is playful, warm, and encouraging
                
                                                      You may include a very short glossary of new words at the end (max 5–7 words) if suitable.
                
                                                      Now, look at the drawing and write the story.
  
         """.formatted(targetLanguage,nativeLanguge,age,gender,targetLanguage);
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
