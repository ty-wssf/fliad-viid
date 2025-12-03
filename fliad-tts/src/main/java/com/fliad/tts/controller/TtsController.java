package com.fliad.tts.controller;

import com.fliad.tts.service.TtsService;
import org.noear.solon.annotation.*;
import org.noear.solon.core.handle.Context;

import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TtsController {

    @Inject
    private TtsService ttsService;

    /**
     * 文本转语音接口
     *
     * @param ctx    请求上下文
     * @param text   输入的文本内容
     * @param volume 音量 (0-100)
     * @param rate   语速 (-10-+10)
     */
    @Post
    @Get
    @Mapping("/tts")
    public void textToSpeech(Context ctx, String text, Integer volume, Integer rate) throws Throwable {
        if (text == null || text.trim().isEmpty()) {
            ctx.status(400);
            Map<String, Object> result = new HashMap<>();
            result.put("code", 400);
            result.put("message", "文本内容不能为空");
            ctx.render(result);
            return;
        }

        // 生成临时文件路径
        String tempPath = System.getProperty("java.io.tmpdir");
        String fileName = "tts_" + System.currentTimeMillis() + ".mp3";
        String filePath = tempPath + File.separator + fileName;

        try {
            // 调用TTS服务生成MP3文件
            ttsService.textToSpeech(text, filePath, volume, rate);

            // 设置响应头
            ctx.contentType("audio/mpeg");
            ctx.headerSet("Content-Disposition", "inline; filename=\"" + fileName + "\"");

            // 读取文件并输出到响应流
            File mp3File = new File(filePath);
            byte[] bytes = Files.readAllBytes(mp3File.toPath());
            ctx.output(bytes);

        } finally {
            // 删除临时文件
            File tempFile = new File(filePath);
            if (tempFile.exists()) {
                tempFile.delete();
            }
        }
    }
}