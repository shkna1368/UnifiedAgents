package com.shabab.agentpattern.pullrequestagent;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PullRequestCheckAgent {
    private final RestTemplate restTemplate;
    private final ChatClient chatClient;

    public PullRequestCheckAgent(RestTemplate restTemplate,ChatClient.Builder builder) {
        this.restTemplate = restTemplate;
        chatClient=builder.build();
    }

    public MergeRequestResponse callApi(){
        String url = "https://git.add.com/api/v4/projects/60/merge_requests/653/changes";

        HttpHeaders headers = new HttpHeaders();
        headers.set("PRIVATE-TOKEN", "<YOUR_TOKEN_HERE>");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<MergeRequestResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                MergeRequestResponse.class
        );
        var result=response.getBody();

        return result;
    }

    public String startPullRequestChat(){
        MergeRequestResponse  mergeRequestResponse=callApi();

      String userName=  mergeRequestResponse.getAuthor().getUsername();
      String webUrl=  mergeRequestResponse.getAuthor().getWeb_url();
        StringBuilder stringBuilder=new StringBuilder();
        mergeRequestResponse.getChanges().forEach(change -> {

           stringBuilder.append(change.getDiff()+'\n'+"------------"+'\n') ;
        });

        String prompt = """
     You are java and spring boot code reviewer.  Please review the following code or pull request based on the following criteria and provide a detailed analysis:
              
                pull request userName:{%s}
                pull webUrl:{%s}
                pull request diff:{%s}
                
                1. Code Quality:
                   - Is the code clean and readable?
                   - Are naming conventions (classes, methods, variables) clear and consistent?
                   - Is there any code duplication or logic that could be refactored?
                
                2. Design & Architecture:
                   - Is the code modular and following SOLID principles?
                   - Are layers (Controller, Service, Model, etc.) properly separated?
                   - For APIs: Are RESTful design conventions followed?
                
                3. Performance:
                   - Are there any potential performance bottlenecks?
                   - Can any parts be optimized (e.g., loops, DB calls, external services)?
                   - Should any logic be handled asynchronously or cached?
                
                4. Security:
                   - Are all inputs validated and sanitized properly?
                   - Is access control/authentication implemented correctly?
                   - Are there any vulnerabilities (e.g., injection, exposure of sensitive data)?
                
                5. Error Handling:
                   - Are exceptions properly caught and handled?
                   - Are meaningful error messages/logs returned to the client or logs?
                   - Is `ResponseEntity` (or equivalent) used for proper HTTP response codes?
                
                6. Testability:
                   - Is the code structured in a way that makes it easy to write unit/integration tests?
                   - Are interfaces and abstractions used where needed?
                   - Are side effects isolated for mocking?
                
                7. Logging & Observability:
                   - Are logs meaningful, secure, and contextual?
                   - Are key operations and failures logged?
                
                8. Documentation:
                   - Are API endpoints documented (e.g., Swagger/OpenAPI)?
                   - Are there comments or JavaDocs for complex methods or business logic?
                
                Finally:
                - add username and web url in final response
                - give me response in persian language
                - Should this code be merged as-is?
                - What improvements would you recommend before merging?
        
        """.formatted(userName,webUrl,stringBuilder.toString());


        var response = chatClient.prompt(prompt).call().content();


        return response;
    }


}
