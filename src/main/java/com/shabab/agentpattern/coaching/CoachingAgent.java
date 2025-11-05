package com.shabab.agentpattern.coaching;

import com.shabab.agentpattern.cv.PdfUtils;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.List;

@Service
public class CoachingAgent {
    private final ChatClient.Builder builder;


    public CoachingAgent(ChatClient.Builder builder, PdfUtils pdfUtils) {
        this.builder = builder;


    }

    public String makeCategory( ) throws MalformedURLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        String prompt="""
                You are an expert in designing analysis and coaching systems. The goal is for users, by answering questions, to receive a profile of their personality, skills, and philosophical tendencies, and then receive personalized coaching advice and exercises.
                
                                              1. **Categories:** Must Provide 12–15 suggested categories covering psychology, philosophy, practical skills, and personal growth. For each category, provide a name and a brief description. 
                
                                            2. Questions: For each category, suggest 4–6 questions. Each question MUST be only one of two types:
                                                 1) "Multiple Choice"
                                                 2) "Descriptive"
                
                                             **Final Output:** Create a comprehensive table including : 
                                                - Category 
                                                - Description 
                                               
                                                
                                               output:
                                                give me result as  json array like below:
                                                {
                                                "catgeory":"cat1";
                                                "description":"desc";
                                                "questions":[
                                                {
                                                "title":"questionTitle"
                                                "type":"Multi choice/Descriptive"
                                                "options":[
                                                "title":"option1"
                                                ]
                                                
                                                }
                                                ]
                                                
                                                }
                                                
                              question type must be                 
               All text except the questions type must be written entirely in Persian script only.
                                                                                         Do NOT include Finglish (Persian in Latin letters) or English explanations.\s
                                                                                         Output must be 100% Persian text.
                                                                                         question type mus be one of exact: mchoise or descriptive                                              
                                                
                                                
                 """;


        var client = builder.build();
        var response = client.prompt(prompt).call().content();
        System.out.println(response);
        return response;

    }



    public String coaching(String userAnswer ) throws MalformedURLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        String prompt="""
                You are a professional coach and psychologist assistant.
                The user has answered a set of questions related to psychology, philosophy, personal growth, or practical skills.\s
                Your task is to:
                
                1. Analyze the user’s answers and identify key personality traits, strengths, and areas of improvement.
                2. Summarize the user’s profile in a clear way (in Persian).
                3. Provide personalized coaching advice and exercises (in Persian), including:
                   - Practical tips the user can apply in daily life.
                   - Exercises or reflective practices to strengthen weak areas.
                   - Motivational guidance to support personal growth.
                
                Important rules:
                - All analysis and coaching advice must be written in Persian only.
                - Be supportive, constructive, and motivational.
                - Coaching output should be structured in 3 sections:
                   الف) خلاصه تحلیل شخصیت 
                   ب) نقاط قوت و ضعف 
                   ج) توصیه‌ها و تمرین‌های کوچینگ شخصی‌سازی‌شده
                   
                   
                   user answer:%s
                                                
                 """.formatted(userAnswer);


        var client = builder.build();
        var response = client.prompt(prompt).call().content();
        System.out.println(response);
        return response;

    }


   public static String SAMPLE_RESPONSE= """
                    [
                      {
                        "category": "خودآگاهی",
                        "description": "شناخت فرد از افکار، احساسات و ارزش‌های شخصی خود.",
                        "questions": [
                          {
                            "title": "تا چه حد خودتان را فردی با خودآگاهی بالا می‌دانید؟",
                            "type": "چند گزینه‌ای",
                            "options": [
                              "خیلی زیاد",
                              "متوسط",
                              "کم"
                            ],
                            "answer": "متوسط"
                          },
                          {
                            "title": "چه چیزی بیشتر شما را به فکر فرو می‌برد؟",
                            "type": "تشریحی",
                            "options": [],
                            "answer": "وقتی در روابط اجتماعی دچار چالش می‌شوم."
                          },
                          {
                            "title": "آیا برای شناخت بهتر خود وقت می‌گذارید؟",
                            "type": "چند گزینه‌ای",
                            "options": [
                              "بله",
                              "خیر",
                              "گاهی اوقات"
                            ],
                            "answer": "گاهی اوقات"
                          }
                        ]
                      },
                      {
                        "category": "هوش هیجانی",
                        "description": "توانایی مدیریت و درک احساسات خود و دیگران.",
                        "questions": [
                          {
                            "title": "وقتی کسی از شما انتقاد می‌کند چه واکنشی دارید؟",
                            "type": "چند گزینه‌ای",
                            "options": [
                              "آرام برخورد می‌کنم",
                              "دفاعی می‌شوم",
                              "بی‌تفاوت می‌مانم"
                            ],
                            "answer": "دفاعی می‌شوم"
                          },
                          {
                            "title": "آخرین باری که احساسات خود را خوب مدیریت کردید چه زمانی بود؟",
                            "type": "تشریحی",
                            "options": [],
                            "answer": "هفته گذشته وقتی در محل کار دچار استرس شدم."
                          },
                          {
                            "title": "آیا احساسات دیگران را به راحتی تشخیص می‌دهید؟",
                            "type": "چند گزینه‌ای",
                            "options": [
                              "بله",
                              "خیر",
                              "گاهی اوقات"
                            ],
                            "answer": "بله"
                          }
                        ]
                      },
                      {
                        "category": "روابط اجتماعی",
                        "description": "نحوه تعامل فرد با دیگران و کیفیت روابط اجتماعی.",
                        "questions": [
                          {
                            "title": "در جمع‌های اجتماعی چگونه رفتار می‌کنید؟",
                            "type": "چند گزینه‌ای",
                            "options": [
                              "فعال و اجتماعی",
                              "ساکت و منفعل",
                              "بستگی به شرایط دارد"
                            ],
                            "answer": "بستگی به شرایط دارد"
                          },
                          {
                            "title": "چه چیزی بیشترین ارزش را در دوستی‌ها برایتان دارد؟",
                            "type": "تشریحی",
                            "options": [],
                            "answer": "صداقت و حمایت متقابل."
                          },
                          {
                            "title": "آیا به راحتی دوست جدید پیدا می‌کنید؟",
                            "type": "چند گزینه‌ای",
                            "options": [
                              "بله",
                              "خیر",
                              "گاهی اوقات"
                            ],
                            "answer": "گاهی اوقات"
                          }
                        ]
                      },
                      {
                        "category": "مدیریت استرس",
                        "description": "توانایی فرد در مقابله با فشارها و شرایط سخت.",
                        "questions": [
                          {
                            "title": "زمانی که تحت فشار هستید چه کاری انجام می‌دهید؟",
                            "type": "چند گزینه‌ای",
                            "options": [
                              "ورزش می‌کنم",
                              "گوش دادن به موسیقی",
                              "عصبی می‌شوم"
                            ],
                            "answer": "گوش دادن به موسیقی"
                          },
                          {
                            "title": "چه چیزی بیشترین استرس را در زندگی شما ایجاد می‌کند؟",
                            "type": "تشریحی",
                            "options": [],
                            "answer": "فشار کاری و عدم اطمینان مالی."
                          },
                          {
                            "title": "چند وقت یکبار احساس استرس شدید دارید؟",
                            "type": "چند گزینه‌ای",
                            "options": [
                              "تقریباً هر روز",
                              "گاهی اوقات",
                              "به ندرت"
                            ],
                            "answer": "گاهی اوقات"
                          }
                        ]
                      },
                      {
                        "category": "رشد شخصی",
                        "description": "تمایل به پیشرفت و یادگیری در زندگی شخصی و شغلی.",
                        "questions": [
                          {
                            "title": "آیا برای یادگیری مهارت‌های جدید وقت می‌گذارید؟",
                            "type": "چند گزینه‌ای",
                            "options": [
                              "بله",
                              "خیر",
                              "گاهی اوقات"
                            ],
                            "answer": "بله"
                          },
                          {
                            "title": "بزرگ‌ترین هدفی که در حال حاضر دنبال می‌کنید چیست؟",
                            "type": "تشریحی",
                            "options": [],
                            "answer": "بهبود زبان انگلیسی برای فرصت‌های کاری بهتر."
                          },
                          {
                            "title": "تا چه حد خود را فردی علاقه‌مند به رشد می‌دانید؟",
                            "type": "چند گزینه‌ای",
                            "options": [
                              "خیلی زیاد",
                              "متوسط",
                              "کم"
                            ],
                            "answer": "خیلی زیاد"
                          }
                        ]
                      }
                    ]
                    """;




}
