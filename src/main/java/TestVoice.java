/**
 * Created by Administrator on 2017/6/27.
 */

import com.iflytek.cloud.speech.*;


public class TestVoice {
    //合成监听器
    private static SynthesizerListener mSynListener = new SynthesizerListener(){
        //会话结束回调接口，没有错误时，error为null
        public void onCompleted(SpeechError error) {
            System.out.println("stop speaking");
        }

        public void onEvent(int i, int i1, int i2, int i3, Object o, Object o1) {

        }

        //缓冲进度回调
        //percent为缓冲进度0~100，beginPos为缓冲音频在文本中开始位置，endPos表示缓冲音频在文本中结束位置，info为附加信息。
        public void onBufferProgress(int percent, int beginPos, int endPos, String info) {}
        //开始播放
        public void onSpeakBegin() {
            System.out.println("start speaking");
        }
        //暂停播放
        public void onSpeakPaused() {}
        //播放进度回调
        //percent为播放进度0~100,beginPos为播放音频在文本中开始位置，endPos表示播放音频在文本中结束位置.
        public void onSpeakProgress(int percent, int beginPos, int endPos) {}
        //恢复播放回调接口
        public void onSpeakResumed() {}

    };

    public static String text = "她走的时候，" +
            "　　夜间黑漆漆的，" +
            "　　他们都睡了。" +
            "　　现在，" +
            "　　夜间也是黑漆漆的，" +
            "　　我唤她道：" +
            "　　“回来，我的宝贝；" +
            "　　世界都在沉睡，" +
            "　　当星星互相凝视的时候，" +
            "　　你来一会儿是没有人会知道的。”" +
            "　　她走的时候，" +
            "　　树木正在萌芽，" +
            "　　春光刚刚来到。" +
            "　　现在花已盛开，" +
            "　　我唤道：“回来，我的宝贝。" +
            "　　孩子们漫不经心地在游戏，" +
            "　　把花聚在一起，" +
            "　　又把它们散开。" +
            "　　你如走来，" +
            "　　拿一朵小花去，" +
            "　　没有人会发觉的。”" +
            "　　常常在游戏的那些人，" +
            "　　仍然还在那里游戏，" +
            "　　生命总是如此地浪费。" +
            "　　我静听他们的空谈，" +
            "　　便唤道：" +
            "　　“回来，我的宝贝，" +
            "　　妈妈的心里充满着爱，" +
            "　　你如走来，" +
            "　　仅仅从她那里接一个小小的吻，" +
            "　　没有人会妒忌的。";
    //public static String text = "voice synthesizing testing program";

    public static void main(String[] args){
        SpeechUtility.createUtility(SpeechConstant.APPID +"=59520312");



        //1.创建SpeechSynthesizer对象
        SpeechSynthesizer mTts= SpeechSynthesizer.createSynthesizer( );
        //2.合成参数设置，详见《MSC Reference Manual》SpeechSynthesizer 类
        mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaokun");//设置发音人
        mTts.setParameter(SpeechConstant.SPEED, "50");//设置语速
        mTts.setParameter(SpeechConstant.VOLUME, "80");//设置音量，范围0~100
        //设置合成音频保存位置（可自定义保存位置），保存在“./tts_test.pcm”
        //如果不需要保存合成音频，注释该行代码
        mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, "./tts_test.pcm");
        //3.开始合成
        mTts.startSpeaking(text, mSynListener);

    }
}
