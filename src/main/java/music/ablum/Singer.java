package music.ablum; /**
  * Copyright 2018 bejson.com 
  */

/**
 * Auto-generated: 2018-11-29 14:1:50
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Singer {

    private int id;
    private String mid;
    private String name;

    public Singer(int id, String mid, String name) {
        this.id = id;
        this.mid = mid;
        this.name = name;
    }

    public Singer() {
    }

    public void setId(int id) {
         this.id = id;
     }
     public int getId() {
         return id;
     }

    public void setMid(String mid) {
         this.mid = mid;
     }
     public String getMid() {
         return mid;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

}