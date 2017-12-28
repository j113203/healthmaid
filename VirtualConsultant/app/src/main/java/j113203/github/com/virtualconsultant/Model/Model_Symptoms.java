package j113203.github.com.virtualconsultant.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by j113203 on 28/12/2017.
 */

public class Model_Symptoms {

    private String engName;

    private String chiName;

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getChiName() {
        return chiName;
    }

    public void setChiName(String chiName) {
        this.chiName = chiName;
    }

    public Model_Symptoms(String engName, String chiName) {
        this.engName = engName;
        this.chiName = chiName;
    }

    public static final ArrayList<Model_Symptoms> db = new ArrayList<Model_Symptoms>() {{
        add(new Model_Symptoms("fever", "發熱"));
        add(new Model_Symptoms("cough", "咳嗽"));
        add(new Model_Symptoms("running nose", "流鼻涕"));
        add(new Model_Symptoms("bleeding", "流血"));
        add(new Model_Symptoms("nosebleed", "流鼻血"));
        add(new Model_Symptoms("sore throat", "喉痛"));
        add(new Model_Symptoms("abdnominal pain", "肚痛"));
        add(new Model_Symptoms("headache", "頭痛"));
        add(new Model_Symptoms("short of breath", "氣促"));
        add(new Model_Symptoms("dizziness", "暈眩"));
        add(new Model_Symptoms("diarrhea", "腹瀉"));
        add(new Model_Symptoms("colic", "絞痛"));
        add(new Model_Symptoms("swollen tissue", "腫脹"));
        add(new Model_Symptoms("having blood in the stool", "便血"));
        add(new Model_Symptoms("vomitting", "嘔吐"));
        add(new Model_Symptoms("feeling obnoxious", "噁心"));
        add(new Model_Symptoms("spit blood", "吐血"));
        add(new Model_Symptoms("fatigue", "疲倦"));
        add(new Model_Symptoms("allergy", "敏感"));
        add(new Model_Symptoms("rash", "紅疹"));
        add(new Model_Symptoms("hives", "蕁麻疹"));
        add(new Model_Symptoms("inflammation", "發炎"));
        add(new Model_Symptoms("dysphagia", "吞咽困難"));
        add(new Model_Symptoms("palsy", "麻痺"));
        add(new Model_Symptoms("muscle soreness", "肌肉酸痛"));
        add(new Model_Symptoms("frequent unrination", "尿頻"));
        add(new Model_Symptoms("constapation", "便秘"));
        add(new Model_Symptoms("loss of appetite", "食欲不振"));
        add(new Model_Symptoms("sudden loss of weight", "暴瘦"));
        add(new Model_Symptoms("insomnia", "失眠"));
        add(new Model_Symptoms("tinnitus", "耳嗚"));

    }};
}
