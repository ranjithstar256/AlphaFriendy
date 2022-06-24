package kpr.am.friendy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class QuestionBank {

    private boolean isSelected;

    public boolean getSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }



    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getCreatedon() {
        return createdon;
    }

    public void setCreatedon(String createdon) {
        this.createdon = createdon;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    String ques; String createdby; String createdon; String cate;

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    String ans;

    public String getFrdnum() {
        return frdnum;
    }

    public void setFrdnum(String frdnum) {
        this.frdnum = frdnum;
    }

    String frdnum;

    public String getFrdans() {
        return frdans;
    }

    public void setFrdans(String frdans) {
        this.frdans = frdans;
    }

    String frdans;

    public QuestionBank(String ques, String createdby, String createdon, String cate,String ans,String frdnum,String frdans) {
        this.ques=ques;
        this.createdby=createdby;
        this.createdon=createdon;
        this.cate=cate;
        this.ans=ans;
        this.frdnum=frdnum;
        this.frdans=frdans;

    }

    public Map<String, Object> datas(){
        Map<String, Object> data1 = new HashMap<>();
        data1.put("name", "San Francisco");
        data1.put("state", "CA");
        data1.put("country", "USA");
        data1.put("capital", false);
        data1.put("population", 860000);
        data1.put("regions", Arrays.asList("west_coast", "norcal"));
       // cities.document("SF").set(data1);
        return data1;
    }
}
