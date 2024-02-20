package com.yxt.synclog.service;

import io.springboot.plugin.gemini.client.GeminiClient;
import io.springboot.plugin.gemini.pojo.Generate;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class GeminiService {
    @Resource
    private GeminiClient client;

    @PostConstruct
    void hello() {
        // 文本格式化提示词
        String prompt = """
                As a writing improvement assistant, your task is to improve the spelling, grammar, clarity, concision,
                and overall readability of the text provided, while breaking down long sentences, reducing repetition,
                and providing suggestions for improvement. Please provide only the corrected Chinese version of the text
                and avoid including explanations. Please begin by editing the following text:
                 """;
        Generate.Request request = Generate.creatTextChart("帮我规划一份春季云南的林地摄影方案");
        Generate.Response response = client.generate(request);
        String answer = Generate.toAnswer(response);
        System.err.println(answer);
    }

    //@PostConstruct
    void generate() {
        // 文本格式化提示词
        String prompt = """
                As a writing improvement assistant, your task is to improve the spelling, grammar, clarity, concision,
                and overall readability of the text provided, while breaking down long sentences, reducing repetition,
                and providing suggestions for improvement. Please provide only the corrected Chinese version of the text
                and avoid including explanations. Please begin by editing the following text:
                 """;
        Generate.Request request = Generate.creatTextChart(prompt + """
                通过此技术，前端可以定制任何数据、任何结构。后端接收到请求再也不用写 Java controller 各类接口、实体代码，可直接操作数据库获取目标结果
                """
        );
        Generate.Response response = client.generate(request);
        String answer = Generate.toAnswer(response);
        System.err.println(answer);
    }

    //验证码识别和计算
    void generateVision() throws IOException {
        String prompt = """
                I will provide you with an image CAPTCHA, please recognize the content inside the CAPTCHA and output the text
                 """;
//        String prompt = """
//                     I will provide you with an image CAPTCHA. Please recognize the content inside the CAPTCHA and output the text.
//                     If the text is a mathematical calculation, please directly output the result
//                """;
        Generate.Request request = Generate.creatImageChart(prompt, new File("/Users/lengleng/Downloads/1.png"));
        Generate.Response response = client.generate(request);
        String answer = Generate.toAnswer(response);
        System.out.println(answer);
    }
}
