package com.shabab.agentpattern.source_code_upgrade;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class SourceCodeUpgradeAgent {
    private final ChatClient.Builder builder;



    public SourceCodeUpgradeAgent(ChatClient.Builder builder) {
        this.builder = builder;

    }

    public void start(String userGoal ) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

      //  List<File> javaFiles = new ArrayList<>();
       //// collectJavaFiles((new File(userGoal)), javaFiles);


      //  String allJavaSources = readAllJavaSources(new File(userGoal));



      var data=  scanJavaFiles(userGoal);
        Set<String> keys = data.keySet();
int index=0;
        // Print keys
        for (String key : keys) {
            System.out.println(index++ +"/"+keys.size());
            System.out.println("File :"+key);
try {
    File file=new File(key);

    String content=  Files.readString(file.toPath());
    String prompt = """
                You are a senior Java developer and migration expert.
                I will give you the complete source code of a Java class and spring boot.
                Your task is to:
                
                1. Detect which libraries, frameworks, or APIs are being used in this code (e.g., Spring, Hibernate, Java EE, Guava, etc.).
                2. Identify if any of these imports, annotations, or method calls are outdated, deprecated, or belong to older versions.
                3. Rewrite the class so that:
                   - It uses the **latest stable versions** of the detected libraries/frameworks.
                   - Deprecated methods, annotations, or classes are replaced with the current recommended alternatives.
                   - The overall functionality of the class remains the same.
                   - use java 21 and  last version of spring boot 3+.
                   - update jpql to last verion of spring data and hibernate.
                4. At the end, explain briefly what changes you applied and why .
                
                Here is the class code:
                %s
        
        """.formatted(content);


    var client = builder.build();
    var response = client.prompt(prompt).call().content();

    writeCode(key,response);
  //  index++;

}
catch (Exception e){
    System.out.println(e);
}


        }




    }
    public  void writeCode(String path,String code) {
        Path filePath = Path.of(path+"a2");

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

    public static Map<String, List<String>> scanJavaFiles(String projectRoot) throws IOException {
         List<String> KEYWORDS = Arrays.asList(
                "@Controller", "@RestController", "@RequestMapping", "@GetMapping", "@PostMapping",
                "extends WebSecurityConfigurerAdapter", "@EnableWebSecurity",
                "javax.persistence", "jakarta.persistence", "@Entity", "@Table", "@Id",
                "javax.validation", "jakarta.validation", "@NotNull", "@Size", "@Valid",
                "javax.servlet", "jakarta.servlet",
                "java.util.Date", "java.util.Calendar", "Thread.stop(", "Thread.suspend(", "Thread.resume("
        );
      List<String> SPECIAL_FILES = Arrays.asList(
                "pom.xml", "build.gradle", "settings.gradle",
                "application.properties", "application.yml"
        );

        Map<String, List<String>> results = new HashMap<>();

        Files.walk(Paths.get(projectRoot))
                .filter(Files::isRegularFile)
                .forEach(path -> {
                    String fileName = path.getFileName().toString();
                    String fullPath = path.toAbsolutePath().toString();

                    try {
                        // فقط فایل‌های جاوا رو برای KEYWORDS چک می‌کنیم
                        if (fileName.endsWith(".java")) {
                            List<String> lines = Files.readAllLines(path);
                            List<String> matches = lines.stream()
                                    .filter(line -> KEYWORDS.stream().anyMatch(line::contains))
                                    .collect(Collectors.toList());

                            if (!matches.isEmpty()) {
                                results.put(fullPath, matches);
                            }
                        }
                        // فایل‌های خاص (pom.xml, gradle, application.yml, ...)
                        else if (SPECIAL_FILES.contains(fileName)) {
                            results.put(fullPath, List.of("SPECIAL_CONFIG_FILE"));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });


        return results;

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
