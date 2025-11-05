package com.shabab.agentpattern;






import com.shabab.agentpattern.appgenerator.AppGeneratorAgent;
import com.shabab.agentpattern.browseragent.BrowserAgent;
import com.shabab.agentpattern.car_accident_insurance.CarInsuranceAgent;
import com.shabab.agentpattern.coaching.CoachingAgent;
import com.shabab.agentpattern.codeagent.CodeAgent;
import com.shabab.agentpattern.cv.CvAgent;
import com.shabab.agentpattern.doctor.DoctorPrescriptionCheckingAgent;
import com.shabab.agentpattern.document_generator.DocumentGeneratorAgent;
import com.shabab.agentpattern.dream_interpretation.DreamInterpretationAgent;
import com.shabab.agentpattern.fundamental_philosophy.FundamentalPhilosophyAgent;
import com.shabab.agentpattern.hr_interview.HrInterviewAgent;
import com.shabab.agentpattern.ielets.SpeakingTestAgent;
import com.shabab.agentpattern.interpretercoaching.InterpreterCoachingAgent;
import com.shabab.agentpattern.kids_psychology.KidsTherapyAgent;
import com.shabab.agentpattern.kids_story.KidsStoryAgent;
import com.shabab.agentpattern.multi_agent.MultiAgentSupervisor;
import com.shabab.agentpattern.personal_stylist.PersonalStylistAgent;
import com.shabab.agentpattern.plan_and_exeute.PlanAndExecuteAgent;
import com.shabab.agentpattern.public_presentation.PublicPresentationAgent;
import com.shabab.agentpattern.pullrequestagent.PullRequestCheckAgent;
import com.shabab.agentpattern.reflection.ReflectionAgent;
import com.shabab.agentpattern.source_code_upgrade.SourceCodeUpgradeAgent;
import com.shabab.agentpattern.therapist.TherapistAgent;
import com.shabab.agentpattern.trend_knowledge_book.TrendKnowlegeBookAgent;
import com.shabab.agentpattern.voicetotext.VoiceToTextAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication

public class App {


    @Autowired
    PlanAndExecuteAgent planAndExecuteService;

    @Autowired
    MultiAgentSupervisor multiAgentSupervisor;


    @Autowired
    ReflectionAgent reflectionAgent;

    @Autowired
    AppGeneratorAgent appGeneratorAgent;

    @Autowired
    CodeAgent codeAgent;

    @Autowired
    BrowserAgent browserAgent;

    @Autowired
    CvAgent cvAgent;


    @Autowired
    VoiceToTextAgent voiceToTextAgent;


    @Autowired
    DocumentGeneratorAgent documentGeneratorAgent;



    @Autowired
    TherapistAgent therapistAgent;



    @Autowired
    SpeakingTestAgent speakingTestAgent;



    @Autowired
    PullRequestCheckAgent pullRequestCheckAgent;


    @Autowired
    DoctorPrescriptionCheckingAgent doctorPrescriptionCheckingAgent;



    @Autowired
    PublicPresentationAgent publicPresentationAgent;

    @Autowired
    KidsStoryAgent kidsStoryAgent;

    @Autowired
    KidsTherapyAgent kidsTherapyAgent;

    @Autowired
    CarInsuranceAgent carInsuranceAgent;


    @Autowired
    PersonalStylistAgent personalStylistAgent;


    @Autowired
    FundamentalPhilosophyAgent fundamentalPhilosophyAgent;





    @Autowired
    DreamInterpretationAgent dreamInterpretationAgent;

    @Autowired
    InterpreterCoachingAgent interpreterCoachingAgent;


    @Autowired
    TrendKnowlegeBookAgent trendKnowlegeBookAgent;


    @Autowired
    SourceCodeUpgradeAgent sourceCodeUpgradeAgent;

    @Autowired
    HrInterviewAgent hrInterviewAgent;

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);

    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {

            var userGoal = "cheap travel from NC to London consist hotel and visit famous place";
           // var userGoal = "cheap travel from NC to London without reserve hotel and visit famous place";

         //var result=   planAndExecuteService.planAndExecute(userGoal);

       //     System.out.println(result);


     //   var result=    reflectionAgent.run("generate find max and min function in java", 5);

        //    System.out.println(result);

       //     multiAgentSupervisor.run();

        // var code=   codeAgent.start("give me find max number in list of number ");
     //   var code1=   codeAgent.start("give me  function find 3 biggest number in list");
      //   var code=   codeAgent.startRequest("based on salary deduction formula : (salary-0.2)+(salary-0.5) .my salary is 2500 ");
         //   System.out.println(code);
        //   System.out.println(code1);

          //  appGeneratorAgent.start("make shortlink project with ui that convert long link to short link");
         //   appGeneratorAgent.start("make banking app support : open account,fund transfer,transaction histories,check balance and close account");

     //  browserAgent.start("برو به سایت ثبت احوال ایران");


            String jobDescription= """
//                   Senior Java and spring boot Developer has at least 5 years experience.must have experience in microservice.must Bachelor's Degree in Computer Software Engineering or related field.
                    """;
        //   cvAgent.start("classpath:\\cv1.pdf",jobDescription);
           // voiceToTextAgent.start("apprequirement.mp3");
          //  voiceToTextAgent.start("appfarsi.mp3");
         // String target=  voiceToTextAgent.startMeeting("meeting.mp3");
         // String project=  appGeneratorAgent.start(target);

         var result=   voiceToTextAgent.startInterview("jobinterview.mp3");
            System.out.println(result);

           /* var result=   voiceToTextAgent.startDailyScrum("dailyscrum.mp3");
            System.out.println(result);*/

            //var result=   documentGeneratorAgent.start("D:\\src\\merchant");
           // var result2=   documentGeneratorAgent.start("D:\\src\\calculatemaster");
           // var therapy=therapistAgent.startTherapy("tarhvare2.mp3");
           // var ieletsFailed=speakingTestAgent.startTest("ielets-fail2.5.mp3");
            //var ieletsSuccess=speakingTestAgent.startTest("ielets-success.mp3");
           // String detection=  pullRequestCheckAgent.startPullRequestChat();

            String correct= """
                    درد شدید و ناگهانی: درد قولنجی (موجی و شدید) در ناحیه پهلو و پشت که به سمت پایین شکم و کشاله ران تیر می‌کشد. .
                    
                    وجود خون در ادرار: تغییر رنگ ادرار به صورتی، قرمز یا قهوه‌ای.
                    
                    تکرر ادرار.
                    
                    سوزش یا درد هنگام ادرار کردن.
                    
                    تهوع و استفراغ (که اغلب به دلیل شدت درد رخ می‌دهد).
                    
                    احساس اضطرار برای ادرار کردن اما خروج حجم کمی از ادرار.
                    """;

            String inCorrect= """
                    تب و لرز، درد غیرقابل کنترل، قطع ادرار یا افت فشار خون  
                    """;
         // String checkpointCorrect=  doctorPrescriptionCheckingAgent.startChecking("persciption.jpg",correct);
         // String checkpointFalse=  doctorPrescriptionCheckingAgent.startChecking("persciption.jpg",inCorrect);

/*
          var res1=  publicPresentationAgent.startTest("BadPublicSpeaking.mp3");
         var res2=   publicPresentationAgent.startTest("goodspeakingpresentation.mp3");*/


            //String trapy= kidsStoryAgent.startCheckingTrapy("naqashi.jpg",6,"female");
           // String trapy= kidsStoryAgent.startCheckingTrapy("asma.jpg",7,"female");
           // String story= kidsStoryAgent.startMakingStory("naqashi.jpg","Kurdish-Sorani",6,"female");
           // String secondlanguage= kidsStoryAgent.startTeachSecondLanguage("naqashi.jpg","Kurdish-Sorani","English",6,"female");

          String kidsDialoug1= """
                   راوی:
                  سلام کوچولوی ناز! امروز می‌خوایم با هم یه بازی کنیم. آماده‌ای؟
                  
                   کودک:
                  آرههه!
                  
                   راوی:
                  اگه یکی اسباب‌بازیتو بشکنه، چی کار می‌کنی؟
                  
                   کودک:
                  به مامان می‌گم... گریه می‌کنم... بعد می‌گه اشکال نداره.
                  
                   راوی:
                  اگه یه اژدهای کوچولو بیاد تو خونه‌تون، چی کار می‌کنی؟
                  
                   کودک:
                  اونو می‌ذارم توی قفس عروسکم! بعد بهش می‌گم بخواب! 
                  
                   راوی:
                  وقتی ناراحت می‌شی، کی بهت کمک می‌کنه؟
                  
                   کودک:
                  مامان... بغل می‌کنه منو.
                  
                   راوی:
                  تو چه کاری رو خیلی خوب بلدی انجام بدی؟
                  
                   کودک:
                  بلدم لگو درست کنم! قلعه ساختم دیروز!
                  
                   راوی:
                  اگه یه دوست جادویی داشتی، اون چه کارایی بلد بود؟
                  
                   کودک:
                  می‌پرید! پر داشت! می‌رفت شکلات بیاره!
                  """;

          String kidsDialog2= """
                   راوی:
                  سلام قهرمان! من یه عالمه سؤال جالب دارم. دوست داری باهام حرف بزنی؟
                  
                   کودک (۷ ساله):
                  باشه، بپرس!
                  
                   راوی:
                  تو مدرسه دوست داری با کی بازی کنی؟ چرا؟
                  
                   کودک:
                  با نازنین، چون همیشه باهام مهربونه و می‌ذاریم با هم تاب بازی کنیم.
                  
                   راوی:
                  اگه معلم ازت بخواد بلند جواب بدی، چه حسی داری؟
                  
                   کودک:
                  اممم... یه کم می‌ترسم. صدام می‌لرزه.
                  
                   راوی:
                  اگه یه کاری رو نتونی انجام بدی، چی کار می‌کنی؟
                  
                   کودک:
                  اول گریه‌م می‌گیره، ولی بعد می‌رم از مامان یا معلمم می‌پرسم.
                  
                   راوی:
                  آخرین باری که عصبانی شدی، چی شد؟
                  
                   کودک:
                  برادرم نقاشیمو پاره کرد! خیلی داد زدم... بعدش ناراحت شدم چون مامان گفت آروم باشم.
                  
                   راوی:
                  وقتی مامان یا بابا از خونه می‌رن بیرون، تو چی کار می‌کنی؟
                  
                   کودک:
                  می‌رم کنار پنجره تا وقتی برگردن نگاشون کنم.
                  """;


       //   var res= kidsTherapyAgent.startTherapy(kidsDialoug1,"4","MALE");
       //  var res2= kidsTherapyAgent.startTherapy(kidsDialog2,"7","FEMALE");
          //  System.out.println(res);
         //   System.out.println(res2);

           // System.out.println();

      //     String res= voiceToTextAgent.startSignLanguage("tarhvare.mp3");


           var phi="""
                   
                   تحليل جامع فلسفه بنيادی (نسخه کامل با تمام جزئیات)
                   =======================================================
                   
                   --- ۱. ذات انسان ---
                   
                   سوال: طبیعت بنیادین انسان چیست؟
                   
                   گزینه‌های موجود:
                   - ذاتاً خوب است، اما جامعه او را تخریب می‌کند.
                   - ترکیبی از خیر و شر است و در یک کشمکش دائمی قرار دارد.
                   - مانند یک لوح سفید است که توسط محیط و انتخاب‌هایش شکل می‌گیرد.
                   - اصالتاً منفعت‌طلب است و برای بقا تلاش می‌کند.
                   
                   >> گزینه انتخاب شده: مانند یک لوح سفید است که توسط محیط و انتخاب‌هایش شکل می‌گیرد.
                   
                   شواهد ارائه شده توسط کاربر:
                   "او معتقد بود انسان‌ها با خلاقیت و اشتیاق می‌توانند هر چیزی را خلق کنند و ذاتشان توسط ابزارهایی که در اختیار دارند و انتخاب‌هایی که می‌کنند، شکل می‌گیرد. او روی توانمندسازی افراد تمرکز داشت، نه اصلاح ذات آن‌ها."
                   
                   -------------------------------------------------------
                   
                   --- ۲. اراده آزاد در برابر جبر ---
                   
                   سوال: انسان در انتخاب‌های خود چقدر آزاد است؟
                   
                   گزینه‌های موجود:
                   - کاملاً آزاد است و مسئول تمام انتخاب‌هایش است (اختیارگرایی).
                   - آزاد است، اما انتخاب‌هایش به شدت تحت تاثیر ژنتیک و محیط است (سازگارگرایی).
                   - اراده آزاد یک توهم است و تمام اعمال توسط زنجیره علت و معلول تعیین می‌شود (جبرگرایی).
                   
                   >> گزینه انتخاب شده: کاملاً آزاد است و مسئول تمام انتخاب‌هایش است (اختیارگرایی).
                   
                   شواهد ارائه شده توسط کاربر:
                   "جمله معروف او 'ما اینجا هستیم تا در کائنات اثری بگذاریم' (to make a dent in the universe) نشان‌دهنده باور عمیق او به توانایی فرد برای شکل دادن به واقعیت و مسئولیت‌پذیری کامل در قبال آن است."
                   
                   -------------------------------------------------------
                   
                   --- ۳. هستی‌شناسی و متافیزیک ---
                   
                   سوال: نیروی محرک اصلی در جهان چیست؟
                   
                   گزینه‌های موجود:
                   - طرح یا هدفی بزرگ و از پیش تعیین‌شده (معنوی یا الهی).
                   - قوانین علمی و روابط علت و معلولی مادی.
                   - اراده و انتخاب‌های آزاد فردی که به جهان معنا می‌دهد.
                   
                   >> گزینه انتخاب شده: اراده و انتخاب‌های آزاد فردی که به جهان معنا می‌دهد.
                   
                   شواهد ارائه شده توسط کاربر:
                   "فلسفه او بر پایه ساختن آینده بود، نه کشف یک طرح از پیش تعیین شده. او بر این باور بود که بهترین راه پیش‌بینی آینده، ساختن آن است که نشان‌دهنده یک دیدگاه اگزیستانسیالیستی به جهان است."
                   
                   -------------------------------------------------------
                   
                   --- ۴. رابطه با طبیعت ---
                   
                   سوال: جایگاه انسان در طبیعت چیست؟
                   
                   گزینه‌های موجود:
                   - انسان ارباب طبیعت است و حق دارد از منابع آن برای پیشرفت خود استفاده کند.
                   - انسان نگهبان طبیعت است و مسئولیت اخلاقی برای حفظ آن دارد.
                   - انسان صرفاً بخشی برابر از شبکه پیچیده حیات در طبیعت است.
                   
                   >> گزینه انتخاب شده: انسان نگهبان طبیعت است و مسئولیت اخلاقی برای حفظ آن دارد.
                   
                   شواهد ارائه شده توسط کاربر:
                   "اگرچه یک فعال محیط زیست نبود، اما در طراحی محصول و معماری (مانند Apple Park) وسواس زیادی برای هماهنگی با طبیعت و استفاده از مواد طبیعی و پایدار داشت که نشان‌دهنده احترام و حس نگهبانی است."
                   
                   -------------------------------------------------------
                   
                   --- ۵. ارزش بنیادین زندگی (Axiology) ---
                   
                   سوال: ارزشمندترین هدف یا غایت در زندگی چیست؟
                   
                   گزینه‌های موجود:
                   - شادی، آرامش و دوری از رنج.
                   - کسب دانش، رسیدن به حقیقت و فهم جهان.
                   - داشتن هدف، رسیدن به دستاورد و به جا گذاشتن یک میراث.
                   - عشق، ارتباطات انسانی و خدمت به دیگران.
                   
                   >> گزینه انتخاب شده: داشتن هدف، رسیدن به دستاورد و به جا گذاشتن یک میراث.
                   
                   شواهد ارائه شده توسط کاربر:
                   "تمام زندگی او حول محور ساختن 'محصولات بی‌نهایت عالی' و تغییر جهان از طریق فناوری بود. او بارها اشاره کرد که اشتیاق برای ساختن و به جا گذاشتن یک میراث، مهم‌ترین انگیزه اوست."
                   
                   -------------------------------------------------------
                   
                   --- ۶. منبع معنا ---
                   
                   سوال: معنای زندگی از کجا نشأت می‌گیرد؟
                   
                   گزینه‌های موجود:
                   - از یک منبع بیرونی و متعالی (مانند خدا، یک طرح کیهانی) کشف می‌شود.
                   - توسط خود فرد و از طریق انتخاب‌ها و تعهداتش ساخته می‌شود.
                   - در بطن روابط انسانی، عشق و تعلق به یک جامعه یافت می‌شود.
                   
                   >> گزینه انتخاب شده: توسط خود فرد و از طریق انتخاب‌ها و تعهداتش ساخته می‌شود.
                   
                   شواهد ارائه شده توسط کاربر:
                   "سخنرانی معروفش در استنفورد تماماً در مورد 'پیدا کردن کاری که عاشقش هستی' و 'متصل کردن نقاط زندگی به عقب' است. این نشان می‌دهد که معنا از درون و از طریق دنبال کردن اشتیاق فردی ساخته می‌شود، نه اینکه از بیرون دریافت شود."
                   
                   -------------------------------------------------------
                   
                   --- ۷. نگرش به رنج ---
                   
                   سوال: نقش یا معنای سختی و رنج در زندگی چیست؟
                   
                   گزینه‌های موجود:
                   - بخشی ضروری برای رشد، یادگیری و قوی‌تر شدن است.
                   - مشکلی است که باید از طریق منطق، علم و فناوری آن را به حداقل رساند.
                   - پدیده‌ای تصادفی و بی‌معناست که باید آن را تحمل کرد.
                   
                   >> گزینه انتخاب شده: بخشی ضروری برای رشد، یادگیری و قوی‌تر شدن است.
                   
                   شواهد ارائه شده توسط کاربر:
                   "او اخراج شدنش از اپل را 'بهترین اتفاقی که می‌توانست برایم بیفتد' نامید. او معتقد بود این شکست سنگین به او دیدگاه یک مبتدی را داد و خلاق‌ترین دوره زندگی‌اش را رقم زد."
                   
                   -------------------------------------------------------
                   
                   --- ۸. نقش هنر و زیبایی (Aesthetics) ---
                   
                   سوال: هنر و زیبایی چه نقشی در زندگی دارند؟
                   
                   گزینه‌های موجود:
                   - هنر بازتابی از یک حقیقت یا زیبایی عینی و جهانی است.
                   - هنر ابزاری برای ابراز احساسات و تجربیات شخصی و کاملاً سوبژکتیو است.
                   - هنر یک ابزار قدرتمند برای نقد و تغییر اجتماعی و فرهنگی است.
                   
                   >> گزینه انتخاب شده: هنر بازتابی از یک حقیقت یا زیبایی عینی و جهانی است.
                   
                   شواهد ارائه شده توسط کاربر:
                   "وسواس او بر سر جزئیات طراحی، فونت‌ها و سادگی، از باوری عمیق به وجود یک زیبایی عینی و درست نشأت می‌گرفت. او معتقد بود طراحی خوب فقط ظاهر نیست، بلکه نحوه کارکرد یک وسیله است و این یک اصل جهانی است."
                   
                   -------------------------------------------------------
                   
                   --- ۹. معرفت‌شناسی ---
                   
                   سوال: معتبرترین راه برای رسیدن به حقیقت چیست؟
                   
                   گزینه‌های موجود:
                   - منطق، عقل و استدلال محض.
                   - تجربه، مشاهده و داده‌های عینی.
                   - شهود، الهام و احساسات درونی.
                   
                   >> گزینه انتخاب شده: شهود، الهام و احساسات درونی.
                   
                   شواهد ارائه شده توسط کاربر:
                   "او به طور مشهور تحقیقات بازار را رد می‌کرد و می‌گفت: 'مردم نمی‌دانند چه می‌خواهند تا زمانی که آن را به آنها نشان دهی.' این نشان‌دهنده اعتماد کامل او به شهود خودش و تیمش برای رسیدن به حقیقت محصول درست است."
                   
                   -------------------------------------------------------
                   
                   --- ۱۰. اخلاق ---
                   
                   سوال: محرک اصلی برای یک عمل "خوب" چیست؟
                   
                   گزینه‌های موجود:
                   - پیروی از اصول و وظایف جهانی (صرف نظر از نتیجه).
                   - رسیدن به بهترین نتیجه ممکن برای بیشترین افراد.
                   - پرورش شخصیت و فضایل درونی (شجاعت، صداقت).
                   
                   >> گزینه انتخاب شده: رسیدن به بهترین نتیجه ممکن برای بیشترین افراد.
                   
                   شواهد ارائه شده توسط کاربر:
                   "هدف نهایی (ساختن یک محصول انقلابی) اغلب رفتار سخت‌گیرانه و بی‌رحمانه او با کارمندانش را توجیه می‌کرد. برای او، نتیجه نهایی و تاثیر آن بر جهان، مهم‌تر از فرآیند یا اصول اخلاقی مرسوم در محیط کار بود."
                   
                   -------------------------------------------------------
                   
                   --- ۱۱. نقش فناوری ---
                   
                   سوال: فناوری چه تاثیری بر بشریت دارد؟
                   
                   گزینه‌های موجود:
                   - ابزاری قدرتمند برای آزادی، توانمندسازی و پیشرفت بشر است.
                   - منشا مشکلات جدید، از خودبیگانگی و تهدیدی برای انسانیت است.
                   - ابزاری خنثی است که تاثیر خوب یا بد آن به نحوه استفاده ما بستگی دارد.
                   
                   >> گزینه انتخاب شده: ابزاری قدرتمند برای آزادی، توانمندسازی و پیشرفت بشر است.
                   
                   شواهد ارائه شده توسط کاربر:
                   "او کامپیوتر را 'دوچرخه‌ای برای ذهن' می‌نامید؛ ابزاری که به افراد عادی قدرت می‌دهد کارهای خارق‌العاده انجام دهند. کل دیدگاه او نسبت به فناوری، توانمندسازی و پیشرفت انسان بود."
                   
                   -------------------------------------------------------
                   
                   --- ۱۲. فلسفه اجتماعی ---
                   
                   سوال: در تعارض بین فرد و جامعه، اولویت با کدام است؟
                   
                   گزینه‌های موجود:
                   - آزادی و حقوق فردی.
                   - منفعت و ثبات کل جامعه.
                   - برابری و توزیع عادلانه منابع.
                   
                   >> گزینه انتخاب شده: آزادی و حقوق فردی.
                   
                   شواهد ارائه شده توسط کاربر:
                   "تمرکز او همیشه بر توانمندسازی فردی از طریق ابزارهای شخصی (Personal Computer, iPhone) بود. او به جای سیستم‌های بزرگ اجتماعی، به قدرت افراد خلاق برای ایجاد تغییر باور داشت."
                   
                   -------------------------------------------------------
                   
                   --- ۱۳. مفهوم عدالت ---
                   
                   سوال: عدالت واقعی چیست؟
                   
                   گزینه‌های موجود:
                   - تنبیه مجرم متناسب با جرمی که انجام داده است.
                   - ترمیم آسیب وارد شده به قربانی و جامعه و اصلاح مجرم.
                   - توزیع منصفانه فرصت‌ها، منابع و قدرت در جامعه.
                   
                   >> گزینه انتخاب شده: توزیع منصفانه فرصت‌ها، منابع و قدرت در جامعه.
                   
                   شواهد ارائه شده توسط کاربر:
                   "اگرچه مستقیماً در مورد عدالت صحبت نمی‌کرد، اما هدف او از ساخت محصولات، 'توزیع' قدرت محاسباتی و خلاقیت بود تا در دسترس همگان قرار گیرد. او به دنبال ایجاد فرصت‌های برابر برای خلاقیت از طریق ابزارهای دموکراتیک بود."
                   
                   -------------------------------------------------------
                   
                   --- ۱۴. نگاه به آینده و پیشرفت ---
                   
                   سوال: مسیر کلی حرکت تاریخ چگونه است؟
                   
                   گزینه‌های موجود:
                   - خوش‌بینانه: بشر به طور کلی در حال حرکت به سوی آینده‌ای بهتر است.
                   - بدبینانه/چرخه‌ای: تاریخ تکرار می‌شود و پیشرفت یک توهم است.
                   - محتاطانه: آینده کاملاً به انتخاب‌های امروز ما بستگی دارد.
                   
                   >> گزینه انتخاب شده: خوش‌بینانه: بشر به طور کلی در حال حرکت به سوی آینده‌ای بهتر است.
                   
                   شواهد ارائه شده توسط کاربر:
                   "او عمیقاً به قدرت نوآوری و خلاقیت برای حل مشکلات و ساختن آینده‌ای بهتر ایمان داشت. تمام کمپین‌های تبلیغاتی و سخنرانی‌های او سرشار از امید و نگاهی مثبت به آینده‌ای بود که توسط فناوری شکل می‌گیرد."
                   
                   -------------------------------------------------------
                   
                   --- ۱۵. هویت شخصی ---
                   
                   سوال: چه چیزی هویت یک فرد را تعریف می‌کند؟
                   
                   گزینه‌های موجود:
                   - افکار، خاطرات و آگاهی درونی او.
                   - اعمال، نقش‌ها و تاثیری که در جهان می‌گذارد.
                   - روابط او با دیگران و جایگاهش در اجتماع.
                   
                   >> گزینه انتخاب شده: اعمال، نقش‌ها و تاثیری که در جهان می‌گذارد.
                   
                   شواهد ارائه شده توسط کاربر:
                   "در زندگی‌نامه‌اش نوشت: 'ما آن چیزی هستیم که انجام می‌دهیم، نه آن چیزی که می‌گوییم.' هویت او به طور کامل با محصولاتی که خلق کرد و تاثیری که بر فرهنگ و فناوری گذاشت، گره خورده است."
                   
                   -------------------------------------------------------
                     """;

       //     String fp= fundamentalPhilosophyAgent.start(phi);
          //  System.out.println(fp);

         //  String coachingQuestion= fundamentalPhilosophyAgent.startCoaching(fp);

      //   var carResult=  carInsuranceAgent.startChecking("tasadof.jpg");
            //System.out.println(carResult);

       /*   var mRes=  personalStylistAgent.startChecking("stmard.jpg");
           var zanRes= personalStylistAgent.startChecking("stZan.jpg");
           var zanH= personalStylistAgent.startRecommendNailAndHairColor("wHair.jpg");


            System.out.println(mRes);
            System.out.println(zanRes);
            System.out.println(zanH);*/

      /*   String cat=   coachingAgent.makeCategory();

            System.out.println(cat);



            Pattern pattern = Pattern.compile("```json\\s*(.*?)\\s*```", Pattern.DOTALL);
            Matcher matcher = pattern.matcher(cat);
            if (matcher.find()) {
                cat = matcher.group(1);
            }*/




           // coachingAgent.coaching(cat);
          /* String coach= coachingAgent.coaching(CoachingAgent.SAMPLE_RESPONSE);
            System.out.println(coach);*/


         //   var desc= dreamInterpretationAgent.start("در خواب پدربزرگم رو دیدیم که داره منو نصیحت به ارامش میکنه .خواب خیلی شفاف بود.پدر بزرگم دست من رو در خواب گرفته بود.با کلی عرق از خواب پریدم.من سنم 37 ساله و مذکر هستم");
           /* var desc= dreamInterpretationAgent.start("افتادن – احساس سقوط از ارتفاع");
            System.out.println(desc);
*/


            /*var desc= interpreterCoachingAgent.start("کاش الان دریا بودم");
            System.out.println(desc);*/

          //  trendKnowlegeBookAgent.start("topic about AI");

            String pomFile= """
                    <project xmlns="http://maven.apache.org/POM/4.0.0"
                             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                             xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
                        <modelVersion>4.0.0</modelVersion>
                        <parent>
                            <groupId>org.springframework.boot</groupId>
                            <artifactId>spring-boot-starter-parent</artifactId>
                            <version>2.4.3</version>
                            <relativePath/> <!-- lookup parent from repository -->
                        </parent>
                    
                        <groupId>com.taratechgroup</groupId>
                        <artifactId>tara-club</artifactId>
                        <version>0.0.1-SNAPSHOT</version>
                        <packaging>pom</packaging>
                        <properties>
                            <!--        https://spring.io/blog/2021/12/10/log4j2-vulnerability-and-spring-boot-->
                            <!--        https://logging.apache.org/log4j/2.x/security.html#CVE-2021-44228-->
                            <log4j2.version>2.17.1</log4j2.version>
                            <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
                            <java.version>15</java.version>
                            <org.mapstruct.version>1.4.1.Final</org.mapstruct.version>
                            <spring.boot.version>2.4.3</spring.boot.version>
                            <spring-cloud.version>2020.0.0</spring-cloud.version>
                            <hibernate.version>5.4.33.Final</hibernate.version>
                            <spring-cloud.version>2020.0.3</spring-cloud.version>
                    
                            <protobuf.version>3.19.1</protobuf.version>
                            <protobuf-plugin.version>0.6.1</protobuf-plugin.version>
                            <grpc.version>1.45.0</grpc.version>
                        </properties>
                        <profiles>
                            <profile>
                                <id>dev</id>
                                <activation>
                                    <activeByDefault>true</activeByDefault>
                                </activation>
                                <properties>
                                    <profiles.active>staging</profiles.active>
                                </properties>
                            </profile>
                            <profile>
                                <id>prod</id>
                                <properties>
                                    <profiles.active>prod</profiles.active>
                                </properties>
                            </profile>
                            <profile>
                                <id>stage</id>
                                <properties>
                                    <profiles.active>stage</profiles.active>
                                </properties>
                            </profile>
                    
                    
                        </profiles>
                        <dependencies>
                            <dependency>
                                <groupId>org.springframework.cloud</groupId>
                                <artifactId>spring-cloud-starter-openfeign</artifactId>
                            </dependency>
                            <dependency>
                                <groupId>net.bytebuddy</groupId>
                                <artifactId>byte-buddy</artifactId>
                                <version>1.10.20</version>
                                <scope>provided</scope>
                            </dependency>
                            <!-- https://mvnrepository.com/artifact/com.netflix.feign/feign-jackson -->
                            <dependency>
                                <groupId>com.netflix.feign</groupId>
                                <artifactId>feign-jackson</artifactId>
                                <version>8.18.0</version>
                            </dependency>
                            <dependency>
                                <groupId>org.springframework.cloud</groupId>
                                <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
                            </dependency>
                            <dependency>
                                <groupId>org.json</groupId>
                                <artifactId>json</artifactId>
                                <version>20240303</version>
                            </dependency>
                    
                            <dependency>
                                <groupId>org.springframework.boot</groupId>
                                <artifactId>spring-boot-starter</artifactId>
                                <exclusions>
                                    <exclusion>
                                        <groupId>org.springframework.boot</groupId>
                                        <artifactId>spring-boot-starter-logging</artifactId>
                                    </exclusion>
                                </exclusions>
                                <version>${spring.boot.version}</version>
                            </dependency>
                            <dependency>
                                <groupId>org.springframework.boot</groupId>
                                <artifactId>spring-boot-starter-log4j2</artifactId>
                                <version>${spring.boot.version}</version>
                            </dependency>
                            <dependency>
                                <groupId>org.springframework.boot</groupId>
                                <artifactId>spring-boot-starter-data-jpa</artifactId>
                            </dependency>
                            <dependency>
                                <groupId>org.springframework.boot</groupId>
                                <artifactId>spring-boot-starter-aop</artifactId>
                            </dependency>
                            <dependency>
                                <groupId>org.springframework.boot</groupId>
                                <artifactId>spring-boot-starter-validation</artifactId>
                            </dependency>
                            <dependency>
                                <groupId>org.redisson</groupId>
                                <artifactId>redisson-spring-boot-starter</artifactId>
                                <version>3.16.1</version>
                            </dependency>
                    
                            <dependency>
                                <groupId>org.springframework.boot</groupId>
                                <artifactId>spring-boot-starter-web</artifactId>
                            </dependency>
                            <dependency>
                                <groupId>org.springframework.boot</groupId>
                                <artifactId>spring-boot-starter-webflux</artifactId>
                            </dependency>
                            <dependency>
                                <groupId>org.springframework.boot</groupId>
                                <artifactId>spring-boot-starter-thymeleaf</artifactId>
                            </dependency>
                            <dependency>
                                <groupId>com.fasterxml.jackson.core</groupId>
                                <artifactId>jackson-databind</artifactId>
                                <version>2.11.4</version>
                            </dependency>
                            <dependency>
                                <groupId>org.springframework.batch</groupId>
                                <artifactId>spring-batch-core</artifactId>
                            </dependency>
                            <dependency>
                                <groupId>org.springframework.batch</groupId>
                                <artifactId>spring-batch-infrastructure</artifactId>
                            </dependency>
                            <dependency>
                                <groupId>org.apache.poi</groupId>
                                <artifactId>poi</artifactId>
                                <version>5.0.0</version>
                                <optional>true</optional>
                            </dependency>
                            <dependency>
                                <groupId>org.apache.poi</groupId>
                                <artifactId>poi-ooxml</artifactId>
                                <version>5.0.0</version>
                                <optional>true</optional>
                            </dependency>
                            <!-- https://mvnrepository.com/artifact/org.apache.camel.springboot/camel-spring-boot-starter -->
                            <dependency>
                                <groupId>org.apache.camel.springboot</groupId>
                                <artifactId>camel-spring-boot-starter</artifactId>
                                <version>3.12.0</version>
                            </dependency>
                            <!-- https://mvnrepository.com/artifact/org.apache.camel/camel-http-starter -->
                            <dependency>
                                <groupId>org.apache.camel.springboot</groupId>
                                <artifactId>camel-http-starter</artifactId>
                                <version>3.12.0</version>
                            </dependency>
                            <dependency>
                                <groupId>org.apache.camel.springboot</groupId>
                                <artifactId>camel-slack-starter</artifactId>
                                <version>3.12.0</version>
                            </dependency>
                            <dependency>
                                <groupId>org.apache.camel.springboot</groupId>
                                <artifactId>camel-kafka-starter</artifactId>
                                <version>3.12.0</version>
                            </dependency>
                            <dependency>
                                <groupId>org.apache.camel.springboot</groupId>
                                <artifactId>camel-seda-starter</artifactId>
                                <version>3.12.0</version>
                            </dependency>
                    
                            <!-- https://mvnrepository.com/artifact/com.warrenstrange/googleauth -->
                            <dependency>
                                <groupId>com.warrenstrange</groupId>
                                <artifactId>googleauth</artifactId>
                                <version>1.5.0</version>
                            </dependency>
                            <!--        <dependency>-->
                            <!--            <groupId>com.yannbriancon</groupId>-->
                            <!--            <artifactId>spring-hibernate-query-utils</artifactId>-->
                            <!--            <version>1.0.3</version>-->
                            <!--        </dependency>-->
                            <dependency>
                                <groupId>org.springframework.boot</groupId>
                                <artifactId>spring-boot-devtools</artifactId>
                                <scope>provided</scope>
                                <optional>true</optional>
                            </dependency>
                            <dependency>
                                <groupId>io.micrometer</groupId>
                                <artifactId>micrometer-registry-prometheus</artifactId>
                                <scope>runtime</scope>
                            </dependency>
                            <dependency>
                                <groupId>org.springframework.boot</groupId>
                                <artifactId>spring-boot-starter-actuator</artifactId>
                            </dependency>
                            <dependency>
                                <groupId>org.postgresql</groupId>
                                <artifactId>postgresql</artifactId>
                                <scope>runtime</scope>
                            </dependency>
                            <!--        https://stackoverflow.com/a/66981165-->
                            <dependency>
                                <groupId>org.projectlombok</groupId>
                                <artifactId>lombok</artifactId>
                                <version>1.18.22</version>
                                <optional>true</optional>
                            </dependency>
                            <dependency>
                                <groupId>org.projectlombok</groupId>
                                <artifactId>lombok-mapstruct-binding</artifactId>
                                <version>0.2.0</version>
                                <optional>true</optional>
                                <scope>provided</scope>
                            </dependency>
                            <dependency>
                                <groupId>com.deliveredtechnologies</groupId>
                                <artifactId>rulebook-spring</artifactId>
                                <version>0.12</version>
                            </dependency>
                            <dependency>
                                <groupId>org.springframework.boot</groupId>
                                <artifactId>spring-boot-starter-test</artifactId>
                                <scope>test</scope>
                            </dependency>
                            <!-- Mapper library to automate model transformations -->
                            <!-- https://www.baeldung.com/java-performance-mapping-frameworks -->
                            <dependency>
                                <groupId>org.mapstruct</groupId>
                                <artifactId>mapstruct</artifactId>
                                <version>${org.mapstruct.version}</version>
                            </dependency>
                            <dependency>
                                <groupId>org.mapstruct</groupId>
                                <artifactId>mapstruct-processor</artifactId>
                                <version>${org.mapstruct.version}</version>
                                <scope>provided</scope>
                            </dependency>
                            <dependency>
                                <groupId>org.springframework.boot</groupId>
                                <artifactId>spring-boot-configuration-processor</artifactId>
                                <optional>true</optional>
                            </dependency>
                            <dependency>
                                <groupId>org.springframework.security</groupId>
                                <artifactId>spring-security-test</artifactId>
                                <scope>test</scope>
                            </dependency>
                            <!-- JWT library for authentication -->
                            <dependency>
                                <groupId>io.jsonwebtoken</groupId>
                                <artifactId>jjwt</artifactId>
                                <version>0.9.1</version>
                            </dependency>
                            <dependency>
                                <groupId>org.springframework.boot</groupId>
                                <artifactId>spring-boot-starter-security</artifactId>
                            </dependency>
                            <dependency>
                                <groupId>org.springdoc</groupId>
                                <artifactId>springdoc-openapi-ui</artifactId>
                                <version>1.5.8</version>
                            </dependency>
                            <dependency>
                                <groupId>com.fasterxml.jackson.module</groupId>
                                <artifactId>jackson-module-jsonSchema</artifactId>
                                <version>2.11.4</version>
                            </dependency>
                            <dependency>
                                <groupId>com.fasterxml.jackson.dataformat</groupId>
                                <artifactId>jackson-dataformat-yaml</artifactId>
                            </dependency>
                            <!-- asynchronous loggers -->
                            <dependency>
                                <groupId>com.lmax</groupId>
                                <artifactId>disruptor</artifactId>
                                <version>3.4.2</version>
                            </dependency>
                            <!-- https://mvnrepository.com/artifact/com.ibm.icu/icu4j -->
                            <dependency>
                                <groupId>com.ibm.icu</groupId>
                                <artifactId>icu4j</artifactId>
                                <version>75.1</version>
                            </dependency>
                            <dependency>
                                <groupId>org.springframework.boot</groupId>
                                <artifactId>spring-boot-starter-data-redis</artifactId>
                                <version>2.4.3</version>
                            </dependency>
                            <!-- flyway database migration dependency -->
                            <dependency>
                                <groupId>org.flywaydb</groupId>
                                <artifactId>flyway-core</artifactId>
                            </dependency>
                    
                            <!--to enable geometric query-->
                            <dependency>
                                <groupId>org.hibernate</groupId>
                                <artifactId>hibernate-spatial</artifactId>
                                <version>${hibernate.version}</version>
                            </dependency>
                            <dependency>
                                <groupId>com.amazonaws</groupId>
                                <artifactId>aws-java-sdk-s3</artifactId>
                                <version>1.11.343</version>
                            </dependency>
                            <dependency>
                                <groupId>net.postgis</groupId>
                                <artifactId>postgis-jdbc</artifactId>
                                <version>2.5.0</version>
                            </dependency>
                            <dependency>
                                <groupId>org.hibernate</groupId>
                                <artifactId>hibernate-envers</artifactId>
                                <version>${hibernate.version}</version>
                            </dependency>
                            <dependency>
                                <groupId>net.devh</groupId>
                                <artifactId>grpc-spring-boot-starter</artifactId>
                                <version>2.13.1.RELEASE</version>
                            </dependency>
                            <dependency>
                                <groupId>com.google.guava</groupId>
                                <artifactId>guava</artifactId>
                                <version>31.1-jre</version>
                            </dependency>
                            <dependency>
                                <artifactId>protobuf-java</artifactId>
                                <groupId>com.google.protobuf</groupId>
                                <version>3.21.7</version>
                            </dependency>
                    
                        </dependencies>
                        <dependencyManagement>
                            <dependencies>
                                <dependency>
                                    <groupId>org.springframework.cloud</groupId>
                                    <artifactId>spring-cloud-dependencies</artifactId>
                                    <version>${spring-cloud.version}</version>
                                    <type>pom</type>
                                    <scope>import</scope>
                                </dependency>
                                <dependency>
                                    <groupId>org.springframework.cloud</groupId>
                                    <artifactId>spring-cloud-starter-sleuth</artifactId>
                                </dependency>
                            </dependencies>
                        </dependencyManagement>
                    
                        <build>
                            <resources>
                                <resource>
                                    <directory>src/main/resources</directory>
                                    <filtering>true</filtering>
                                </resource>
                            </resources>
                            <extensions>
                                <extension>
                                    <groupId>kr.motd.maven</groupId>
                                    <artifactId>os-maven-plugin</artifactId>
                                    <version>1.7.0</version>
                                </extension>
                            </extensions>
                            <plugins>
                                <plugin>
                                    <groupId>org.xolstice.maven.plugins</groupId>
                                    <artifactId>protobuf-maven-plugin</artifactId>
                                    <!--                <version>0.6.1</version>-->
                                    <version>${protobuf-plugin.version}</version>
                                    <configuration>
                                        <protocArtifact>com.google.protobuf:protoc:${protobuf.version}:exe:${os.detected.classifier}
                                        </protocArtifact>
                                        <pluginId>grpc-java</pluginId>
                                        <pluginArtifact>io.grpc:protoc-gen-grpc-java:${grpc.version}:exe:${os.detected.classifier}
                                        </pluginArtifact>
                                        <outputBaseDirectory>src/main/java/</outputBaseDirectory>
                                        <outputDirectory>src/main/java/</outputDirectory>
                                        <clearOutputDirectory>false</clearOutputDirectory>
                                    </configuration>
                                    <executions>
                                        <execution>
                                            <goals>
                                                <goal>compile</goal>
                                                <goal>compile-custom</goal>
                                            </goals>
                                        </execution>
                                    </executions>
                                </plugin>
                            </plugins>
                            <pluginManagement>
                                <plugins>
                                    <plugin>
                                        <groupId>org.springframework.boot</groupId>
                                        <artifactId>spring-boot-maven-plugin</artifactId>
                                        <executions>
                                            <execution>
                                                <id>pre-integration-test</id>
                                                <goals>
                                                    <goal>start</goal>
                                                </goals>
                                            </execution>
                                            <execution>
                                                <id>post-integration-test</id>
                                                <goals>
                                                    <goal>stop</goal>
                                                </goals>
                                            </execution>
                                        </executions>
                                        <configuration>
                                            <excludes>
                                                <exclude>
                                                    <groupId>org.projectlombok</groupId>
                                                    <artifactId>lombok</artifactId>
                                                </exclude>
                                            </excludes>
                                        </configuration>
                                    </plugin>
                    
                                    <plugin>
                                        <groupId>org.apache.maven.plugins</groupId>
                                        <artifactId>maven-resources-plugin</artifactId>
                                        <version>3.1.0</version>
                                        <dependencies>
                                            <dependency>
                                                <groupId>org.apache.maven.shared</groupId>
                                                <artifactId>maven-filtering</artifactId>
                                                <version>3.2.0</version>
                                            </dependency>
                                        </dependencies>
                                        <configuration>
                                            <nonFilteredFileExtensions>
                                                <nonFilteredFileExtension>json</nonFilteredFileExtension>
                                                <nonFilteredFileExtension>xlsx</nonFilteredFileExtension>
                                                <nonFilteredFileExtension>properties</nonFilteredFileExtension>
                                                <nonFilteredFileExtension>sql</nonFilteredFileExtension>
                                            </nonFilteredFileExtensions>
                                            <delimiters>
                                                <delimiter>@</delimiter>
                                            </delimiters>
                                            <useDefaultDelimiters>false</useDefaultDelimiters>
                                        </configuration>
                                    </plugin>
                                    <plugin>
                                        <groupId>org.apache.maven.plugins</groupId>
                                        <artifactId>maven-compiler-plugin</artifactId>
                                        <configuration>
                                            <source>${java.version}</source>
                                            <target>${java.version}</target>
                                            <annotationProcessorPaths>
                                                <path>
                                                    <groupId>org.projectlombok</groupId>
                                                    <artifactId>lombok</artifactId>
                                                    <version>1.18.22</version>
                                                </path>
                                                <path>
                                                    <groupId>org.projectlombok</groupId>
                                                    <artifactId>lombok-mapstruct-binding</artifactId>
                                                    <version>0.2.0</version>
                                                </path>
                                                <path>
                                                    <groupId>org.mapstruct</groupId>
                                                    <artifactId>mapstruct-processor</artifactId>
                                                    <version>${org.mapstruct.version}</version>
                                                </path>
                                            </annotationProcessorPaths>
                                            <compilerArgs>
                                                <compilerArg>
                                                    -Amapstruct.defaultComponentModel=spring
                                                </compilerArg>
                                            </compilerArgs>
                                        </configuration>
                                    </plugin>
                    
                                </plugins>
                            </pluginManagement>
                        </build>
                        <modules>
                            <module>authentication</module>
                            <module>core</module>
                            <module>club.app</module>
                            <module>job</module>
                            <module>document</module>
                            <module>loyalty</module>
                            <module>profile.level</module>
                            <module>report</module>
                            <module>credit</module>
                            <module>rule.engine</module>
                        </modules>
                    
                    </project>
                    
                    """;

            String entity= """
                        package com.taratechgroup.credit.core.entity.location;
                    
                    import com.taratechgroup.core.domain.model.BaseEntity;
                    import lombok.*;
                    
                    import javax.persistence.*;
                    import java.util.ArrayList;
                    import java.util.List;
                    
                    @Setter
                    @Getter
                    @Builder
                    @AllArgsConstructor
                    @NoArgsConstructor
                    @Entity
                    @Table(name = "city")
                    @EqualsAndHashCode(callSuper = true)
                    public class City extends BaseEntity {
                    
                        @Id
                        @GeneratedValue(strategy = GenerationType.IDENTITY)
                        private Long id;
                    
                        @Column(name = "c_name",length = 30, nullable = false)
                        private String name;
                    
                        @OneToMany( fetch = FetchType.LAZY ,mappedBy = "city")
                        private List<District> districts = new ArrayList<>();
                    
                        @Column(name = "province_id")
                        private Long provinceId;
                    
                        @ManyToOne
                        @JoinColumn(name = "province_id", referencedColumnName="id", insertable = false, updatable = false)
                        private Province province;
                    
                    }
                    
                    """;

        //  String entityRes=  sourceCodeUpgradeAgent.start(  entity);
         //  String pomRes= sourceCodeUpgradeAgent.start(  pomFile);
         //  sourceCodeUpgradeAgent.start(  "D:\\refactore\\club-api");

            //System.out.println(entityRes);

       //   String re1=  hrInterviewAgent.start("psych_test_mid_success.txt","mid-level");
      //    String re2=  hrInterviewAgent.start("psych_test_mid_fail.txt","mid-level");
       //     System.out.println(re2);
        };
    }
}