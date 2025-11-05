package com.shabab.agentpattern.car_accident_insurance;

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
public class CarInsuranceAgent {


    private final ChatClient.Builder builder;
    public CarInsuranceAgent(ChatClient.Builder builder) {
        this.builder = builder;


    }

    public String startChecking(String filePath) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        ClassPathResource res= new ClassPathResource(filePath);
        Media media=new Media(MimeTypeUtils.parseMimeType("image/jpeg"), res);
        List<Media> mediaList=new ArrayList<>();

        String prompt= """
              
               You are acting as an official insurance and traffic accident expert in Iran. 
                                                          Your task is to provide a detailed analysis and report about car accidents based on the **latest Iranian traffic regulations and insurance laws (Third-Party Liability and Comprehensive Coverage, year 2025 / 1404)**. 
                
                                                          Input:
                                                          - A description or an image of the accident (will be provided). 
                
                                                          Your output must include two sections: 
                
                                                          1. **Determining the At-Fault Driver** 
                                                             - Identify which driver is responsible for the accident. 
                                                             - Cite the relevant articles and clauses from Iranian traffic laws. 
                                                             - Explain why this driver is at fault and why the other is not. 
                                                             - If applicable, refer to rules such as right-of-way, entering from a side road into a main road, lane changing, speeding, running a red light, or illegal overtaking. 
                
                                                          2. **Damage Assessment for Each Vehicle**
                                                             - Provide a detailed estimate of repair costs based on 2025 (1404) market prices for parts and labor. 
                                                             - Break down the damages for each vehicle (parts to be replaced, repaired, painted, or potential mechanical issues). 
                                                             - Give an approximate total damage cost for each vehicle. 
                                                             - State which insurance covers the damages (at-fault driver’s third-party liability, or comprehensive insurance if available). 
                                                             - Indicate cases where the driver must personally cover the costs (e.g., no comprehensive coverage). 
                
                                                          Response format: 
                                                          - Section 1: At-fault driver + legal reasoning (with references to traffic law clauses). 
                                                          - Section 2: Table or structured list of damages per vehicle + total cost + insurance coverage explanation. 
                                                          - Final Conclusion: A clear and professional summary of fault and financial responsibilities.
                                                          - Give me  Final result Just in Persian (Farsi) language.
  
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
