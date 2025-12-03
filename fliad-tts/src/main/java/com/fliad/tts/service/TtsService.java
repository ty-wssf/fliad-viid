package com.fliad.tts.service;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Objects;

@Component
public class TtsService {

    private static final Logger log = LoggerFactory.getLogger(TtsService.class);

    /**
     * 将文本转换为语音并保存为MP3文件
     *
     * @param text     要转换的文本
     * @param filePath 输出文件路径
     */
    public void textToSpeech(String text, String filePath) {
        textToSpeech(text, filePath, null, null);
    }

    /**
     * 将文本转换为语音并保存为MP3文件
     *
     * @param text     要转换的文本
     * @param filePath 输出文件路径
     * @param volume   音量 (0-100)，默认从配置文件获取
     * @param rate     语速 (-10-+10)，默认从配置文件获取
     */
    public void textToSpeech(String text, String filePath, Integer volume, Integer rate) {
        ActiveXComponent ax = null;
        Dispatch spFileStream = null;
        Dispatch spAudioFormat = null;
        Dispatch spVoice = null;

        // 设置默认值（从配置文件获取）
        int actualVolume = (volume != null && volume >= 0 && volume <= 100) ? volume : Solon.cfg().getInt("tts.default-volume", 50);
        int actualRate = (rate != null && rate >= -10 && rate <= 10) ? rate : Solon.cfg().getInt("tts.default-rate", 0);

        try {
            ax = new ActiveXComponent("Sapi.SpFileStream");
            spFileStream = ax.getObject();

            ax = new ActiveXComponent("Sapi.SpAudioFormat");
            spAudioFormat = ax.getObject();

            spVoice = new ActiveXComponent("Sapi.SpVoice").getObject();
            // 设置音频流格式
            Dispatch.put(spAudioFormat, "Type", new Variant(22));
            // 设置文件输出流格式
            Dispatch.putRef(spFileStream, "Format", spAudioFormat);

            // 创建父目录（如果不存在）
            File file = new File(filePath);
            File parentDir = file.getParentFile();
            if (!parentDir.exists()) {
                parentDir.mkdirs();
            }

            // 调用输出文件流打开方法，创建一个.mp3文件
            Dispatch.call(spFileStream, "Open", new Variant(filePath), new Variant(3), new Variant(true));
            // 设置声音对象的音频输出流为输出文件对象
            Dispatch.putRef(spVoice, "AudioOutputStream", spFileStream);
            // 设置音量 0 ~ 100
            Dispatch.put(spVoice, "Volume", new Variant(actualVolume));
            // 设置朗读速度 -10 ~ +10
            Dispatch.put(spVoice, "Rate", new Variant(actualRate));

            Dispatch.call(spVoice, "Speak", new Variant(text));

            System.out.println("输出语音文件成功：" + filePath);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("文本转语音失败", e);
        } finally {
            // 关闭输出文件
            if (spFileStream != null) {
                try {
                    Dispatch.call(Objects.requireNonNull(spFileStream), "Close");
                    // Dispatch.putRef(Objects.requireNonNull(spVoice), "AudioOutputStream", null);

                    Objects.requireNonNull(spAudioFormat).safeRelease();
                    spFileStream.safeRelease();
                    spVoice.safeRelease();
                    ax.safeRelease();
                } catch (Exception e) {
                    log.error("释放资源失败", e);
                }
            }
        }
    }
}