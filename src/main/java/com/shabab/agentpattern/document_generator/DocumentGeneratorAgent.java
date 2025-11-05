package com.shabab.agentpattern.document_generator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DocumentGeneratorAgent {
    private final ChatClient.Builder builder;



    public DocumentGeneratorAgent(ChatClient.Builder builder) {
        this.builder = builder;

    }

    public String start(String sourceAddress ) throws MalformedURLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, InterruptedException {





        // خواندن و ترکیب تمام سورس کدها
        String allJavaSources = readAllJavaSources(new File(sourceAddress));



        String prompt = """
                You are an autonomous technical documentation specialist responsible for transforming code analysis into clear,
                             comprehensive Markdown documentation based on provided source code. Your expertise lies in creating well-structured Markdown files that explain
                             code functionality and architecture in a developer-friendly way. You work exclusively with the output from the
                             code analyzer to produce documentation that helps engineers quickly understand the codebase.
                
                source code:{%s}
                
                             Your primary goal is to generate high-quality Markdown documentation from code analysis insights. You create
                             documentation that includes package overviews, function definitions, usage examples, and data flow explanations.
                             You organize information logically with proper Markdown formatting, including headings, code blocks, lists, and
                             tables when appropriate or mermaid diagrams. You prioritize clarity, completeness, and practical usefulness for developers who need
                             to work with or extend the codebase.
                
                             Your markdown style should:
                             - Use proper hierarchical heading structure (H1 for main titles, H2 for sections, etc.)
                             - Implement code blocks with appropriate syntax highlighting
                             - Create navigable table of contents for larger documents
                             - Utilize tables and lists to organize related information
                             - Maintain consistent terminology and formatting throughout
                             - Focus on explaining "what", "why", and "how" for key components
                             - Link related documentation sections when appropriate
                             - Use separate diagrams and mermaid blocks for different parts of the codebase
                
                             You are part of an automated documentation pipeline that enhances developer onboarding and knowledge transfer.
                             You specialize in transforming technical code analysis into accessible Markdown documentation that follows
                             consistent formatting and structure. Your Markdown files serve as the primary reference for developers
                             working with the codebase, providing clear explanations of functionality, architecture, and usage patterns
                             without requiring them to dive into the code directly.
                
                         
                             Please analyze the codebase and create a comprehensive README.md file. The analysis data is available at {{repo_path}}/.ai/docs/.
                
                           
                          
                            
                
                             The README.md should include the following sections based on the code analysis:
                           
                          
                             ## Project Overview
                             - Project title and concise description
                             - Purpose and main functionality
                             - Key features and capabilities
                             - Likely intended use cases
                         
                
                             ## Table of Contents
                
                             ## Architecture
                             - High-level architecture overview
                             - Technology stack and frameworks
                             - Component relationships (with mermaid diagrams)
                             - Key design patterns
                
                             ## C4 Model Architecture
                             Create C4 model diagrams for:
                             - Context diagram: system and its relationships
                             - Container diagram: high-level technical building blocks
                             Note: Only include levels that can be reasonably deduced from the codebase.
                             Wrap diagrams in details and summary tags for better readability.
                           
                
                             ## Repository Structure
                             - Important directories and their purposes
                             - Key files and their roles
                             - Component organization
                             Keep this section minimal and concise.
                            
                
                             ## Dependencies and Integration
                             - Internal and external service dependencies
                             - Event streams or message queues (if applicable)
                             Note: Do not include external libraries.
                         
                
                             ## API Documentation
                             - API endpoints
                             - Request/response formats
                             Present API information in an easy-to-understand format without raw proto definitions.
                           
                
                             ## Development Notes
                             - Project-specific conventions
                             - Testing requirements
                             - Performance considerations
                            
                
                             ## Known Issues and Limitations
                             - TODOs and FIXMEs
                             - Incomplete features or technical debt
                           
                
                             ## Additional Documentation
                             - Links to other repository documentation (as markdown links)
                             
                          
                
                             Important guidelines:
                             1. Only use the provided headlines and ones available in current readme file and do not add any other headlines
                             2. Use only information that can be reasonably inferred from the code and repository structure
                             3. Note areas where additional documentation would be helpful
                             4. Format using proper Markdown syntax with headings, code blocks, lists, and tables
                             5. Make the README welcoming and clear for new developers
                             6. Do not include or reference any file from .ai/docs/ directory.
                             7. For mermaid diagrams:
                                - Use logical boundary groupings
                                - Include meaningful relationships (color-coded by domain)
                                - Add detailed component descriptions
                                - Maintain appropriate visual hierarchy
                                - Use descriptive relationship verbs
                                - Optimize layout for clarity
                                
                          
                                
        """.formatted(allJavaSources);


        var client = builder.build();
        var response = client.prompt(prompt).call().content();


        Pattern pattern = Pattern.compile("```markdown\\s*(.*?)\\s*```", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);
        String extracted = null;
        if (matcher.find()) {
            extracted = matcher.group(1);
        }


      writeCode(extracted,sourceAddress);

        return "extracted";

    }




    public  void writeCode(String code,String path) {
        Path filePath = Path.of(path+"//"+"README.md");

        // محتوایی که می‌خواهید در فایل ذخیره شود

        try {
            // ایجاد فایل و نوشتن محتوا (اگر فایل وجود نداشته باشد، ایجاد می‌شود)
            Files.writeString(
                    filePath,
                    code,
                    StandardOpenOption.CREATE,     // اگر فایل نبود، بساز
                    StandardOpenOption.TRUNCATE_EXISTING // اگر فایل بود، پاک و جایگزین کن
            );

            System.out.println("فایل با موفقیت ایجاد شد: " + filePath.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("خطا در نوشتن فایل:");
            e.printStackTrace();
        }
    }




    public static String readAllJavaSources(File root) {
        List<File> javaFiles = new ArrayList<>();
        collectJavaFiles(root, javaFiles);

        StringBuilder combinedSources = new StringBuilder();
        for (File file : javaFiles) {
            try {
                combinedSources.append(Files.readString(file.toPath())).append("\n\n");
            } catch (IOException e) {
                System.err.println("خطا در خواندن فایل: " + file.getAbsolutePath());
                e.printStackTrace();
            }
        }
        return combinedSources.toString();
    }

    // تابع بازگشتی برای جمع‌آوری همه فایل‌های .java
    private static void collectJavaFiles(File dir, List<File> javaFiles) {
        if (dir == null || !dir.exists()) return;

        File[] files = dir.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                collectJavaFiles(file, javaFiles);
            } else if (file.getName().endsWith(".java")) {
                javaFiles.add(file);
            }
        }
    }

}
