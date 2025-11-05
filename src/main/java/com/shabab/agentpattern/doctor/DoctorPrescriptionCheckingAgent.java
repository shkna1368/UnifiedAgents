package com.shabab.agentpattern.doctor;

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
public class DoctorPrescriptionCheckingAgent {


    private final ChatClient.Builder builder;
    public DoctorPrescriptionCheckingAgent(ChatClient.Builder builder) {
        this.builder = builder;


    }

    public String startChecking(String filePath,String symptoms) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        ClassPathResource res= new ClassPathResource(filePath);
        Media media=new Media(MimeTypeUtils.parseMimeType("image/jpeg"), res);
        List<Media> mediaList=new ArrayList<>();

        String prompt= """
              
                You are an AI assistant trained in analyzing pharmaceutical and medical information. Your task is to provide a comprehensive and structured analysis based on a medical prescription and the patient's reported symptoms.
                
                Inputs:
                
          
                
                Patient Symptoms:
                [%s]
                
                Expected Output:
                
                Please provide your analysis in the exact four-part format below:
                
                1. Interpretation of Prescribed Items:
                A list of all medications from the prescription, including the drug name, form (e.g., tablet, capsule, syrup), and the prescribed quantity.
                
                Drug Name: [Scientific or brand name]
                
                Form: [e.g., Tablet]
                
                Quantity: [e.g., 30 units]
                (Repeat this section for each medication)
                
                2. Explanation and Use of Each Drug:
                For each listed medication, explain what it is and what conditions or symptoms it is typically used to treat.
                
                [Drug Name]: [Explain the drug's purpose and common uses]
                (Repeat this section for each medication)
                
                3. Daily Dosage:
                Interpret the instructions from the prescription for each medication and specify the total amount of the drug the patient would consume in a 24-hour period.
                
                [Drug Name]: [e.g., One tablet every 8 hours, equivalent to 3 tablets in 24 hours for a total daily dose of X mg.]
                (Repeat this section for each medication)
                
                4. Analysis of Prescription-Symptom Alignment (Final Assessment):
                This is the most critical section. Provide your assessment here.
                
                Logical Correlation: Is there a logical connection between the patient's symptoms and the prescribed medications? Explain which drug targets which symptom(s).
                
                Red Flags (Contraindications & Warnings): Do the patient's symptoms include anything that is a known contraindication or a serious warning for the prescribed drugs? Are there any potentially dangerous interactions between the prescribed medications?
                
                Overall Conclusion: Based on the analysis above, does the prescription appear to be a standard and appropriate therapeutic approach for the patient's condition? If there are any ambiguous or concerning points, state them clearly.
                
                !!! Very Important and Mandatory Disclaimer !!!
                At the end of your response, you must include the following paragraph:
                "Warning: This analysis is based solely on general pharmaceutical information cross-referenced with the provided input data. It is NOT a substitute for the consultation, diagnosis, or professional opinion of a qualified medical doctor or pharmacist. The information provided may not be complete, and every individual's medical situation is unique. For any decision regarding your health or treatment, including taking or stopping a medication, you must consult with your doctor or pharmacist. This tool is for informational and educational purposes only."
                give me result in persian language.
  
         """.formatted(symptoms);
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
