package music.ablum; /**
  * Copyright 2018 bejson.com 
  */

import music.utils.Utils;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Auto-generated: 2018-11-29 14:1:50
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class MusicAblum {

    private int code;
    private Data data;
    private String message;
    private int subcode;

    public MusicAblum(int code, Data data, String message, int subcode) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.subcode = subcode;
    }

    public MusicAblum() {
    }

    public void setCode(int code) {
         this.code = code;
     }
     public int getCode() {
         return code;
     }

    public void setData(Data data) {
         this.data = data;
     }
     public Data getData() {
         return data;
     }

    public void setMessage(String message) {
         this.message = message;
     }
     public String getMessage() {
         return message;
     }

    public void setSubcode(int subcode) {
         this.subcode = subcode;
     }
     public int getSubcode() {
         return subcode;
     }
    /**
     * 获取专辑内所有歌曲信息
     * @param address
     * @return
     */
    public static MusicAblum  getMusicAlbum(String address){
        String rtnStr = Utils.getURLCollection(address);
        System.out.println(rtnStr );
        rtnStr = rtnStr.split("albuminfoCallback\\(")[1];
        // System.out.println(rtnStr);
        rtnStr = rtnStr.substring(0,rtnStr.trim().length()-1);
        JSONObject jsonobject = JSONObject.fromObject(rtnStr);
        // System.out.println(jsonobject.get("company_new"));
        Map<String,Class> classMap = new HashMap<String,Class>();
        classMap.put("company_new",Company_new.class);
        classMap.put("data", Data.class);
        classMap.put("list", Music.class);
        classMap.put("pay", Pay.class);
        classMap.put("preview", Preview.class);
        classMap.put("singer",Singer.class);
        MusicAblum bean = (MusicAblum) JSONObject.toBean(jsonobject, MusicAblum.class,classMap);
        return bean;
    }

}