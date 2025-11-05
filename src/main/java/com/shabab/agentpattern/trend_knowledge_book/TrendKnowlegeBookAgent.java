package com.shabab.agentpattern.trend_knowledge_book;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import com.shabab.agentpattern.browseragent.Component;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TrendKnowlegeBookAgent {
    private final ChatClient.Builder builder;



    public TrendKnowlegeBookAgent(ChatClient.Builder builder) {
        this.builder = builder;

    }

    public void start(String userGoal ) throws MalformedURLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
      /*  String prompt = """
                find 1 valid link of site from below user request without any explanation 
                 Based  on the user goal : %s 
                  result like : http://google.com
                
                """.formatted(userGoal);


        var client = builder.build();
        var response = client.prompt(prompt).call().content();*/
     var htmlContentCategory=   goToLink("https://www.manning.com/catalog");





          String promptCategory= """
                  based on user goal extract just 1 link for user goal without extra explanitions.
                  user goal:%s
                  
                  page content:%s
                  
                  """.formatted(userGoal,htmlContentCategory);

      var resCategory=     callAi(promptCategory);




      String candidateBooks=goToLink(resCategory);


        String promptBooks= """
                  based on user goal and candidate link extract just book links from page content and seprate link by comma without extra explanitions.
                  user goal:%s
                  
                  candidate link:%s
                  
                  
                  page content:%s
                  
                  """.formatted(userGoal,resCategory,candidateBooks);
     String rawBooksLink= callAi(promptBooks);
        System.out.println(rawBooksLink);
            /////////open

var booksLink=rawBooksLink.split(",");
        System.out.println("");



        openMultipleLinks(booksLink);

        }


    public String callAi(String prompt)  {

        var client = builder.build();
       return client.prompt(prompt).call().content();
    }






    public String goToLink(String link) {


        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--kiosk")));
            Page page = browser.newPage();
            var re = page.navigate(link);


            page.waitForLoadState(LoadState.LOAD);

            page.waitForTimeout(1000);

            // محتوای کامل HTML صفحه را دریافت کنید
            String htmlContent = page.content();

            return htmlContent;
        }
    }


    public void openMultipleLinks(String[] links) {


        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--kiosk")));

            for (String url : links) {
                // 3. Create a new tab (page) for each URL
                try {
                    Page newTab = browser.newPage();

                    // 4. Navigate the new tab to the URL
                    newTab.navigate(url);
                    System.out.println("Opened: " + url);
                }
                catch (Exception e){
                    System.out.println(e);
                }

            }


        }
    }
}


