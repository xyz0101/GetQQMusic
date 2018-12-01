/**
  * Copyright 2018 bejson.com 
  */
package music.pass;
import java.util.List;

/**
 * Auto-generated: 2018-11-29 15:21:40
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Data {

    private long expiration;
    private String login_key;
    private List<Midurlinfo> midurlinfo;
    private String msg;
    private int retcode;
    private String servercheck;
    private List<String> sip;
    private String testfile2g;
    private String testfilewifi;
    private List<String> thirdip;
    private String uin;
    private int verify_type;
    private List<String> freeflowsip;
    private String keepalivefile;
    private String userip;
    private String vkey;

    public List<String> getFreeflowsip() {
        return freeflowsip;
    }

    public void setFreeflowsip(List<String> freeflowsip) {
        this.freeflowsip = freeflowsip;
    }

    public String getKeepalivefile() {
        return keepalivefile;
    }

    public void setKeepalivefile(String keepalivefile) {
        this.keepalivefile = keepalivefile;
    }

    public String getUserip() {
        return userip;
    }

    public void setUserip(String userip) {
        this.userip = userip;
    }

    public String getVkey() {
        return vkey;
    }

    public void setVkey(String vkey) {
        this.vkey = vkey;
    }

    public void setExpiration(long expiration) {
         this.expiration = expiration;
     }
     public long getExpiration() {
         return expiration;
     }

    public void setLogin_key(String login_key) {
         this.login_key = login_key;
     }
     public String getLogin_key() {
         return login_key;
     }

    public void setMidurlinfo(List<Midurlinfo> midurlinfo) {
         this.midurlinfo = midurlinfo;
     }
     public List<Midurlinfo> getMidurlinfo() {
         return midurlinfo;
     }

    public void setMsg(String msg) {
         this.msg = msg;
     }
     public String getMsg() {
         return msg;
     }

    public void setRetcode(int retcode) {
         this.retcode = retcode;
     }
     public int getRetcode() {
         return retcode;
     }

    public void setServercheck(String servercheck) {
         this.servercheck = servercheck;
     }
     public String getServercheck() {
         return servercheck;
     }

    public void setSip(List<String> sip) {
         this.sip = sip;
     }
     public List<String> getSip() {
         return sip;
     }

    public void setTestfile2g(String testfile2g) {
         this.testfile2g = testfile2g;
     }
     public String getTestfile2g() {
         return testfile2g;
     }

    public void setTestfilewifi(String testfilewifi) {
         this.testfilewifi = testfilewifi;
     }
     public String getTestfilewifi() {
         return testfilewifi;
     }

    public void setThirdip(List<String> thirdip) {
         this.thirdip = thirdip;
     }
     public List<String> getThirdip() {
         return thirdip;
     }

    public void setUin(String uin) {
         this.uin = uin;
     }
     public String getUin() {
         return uin;
     }

    public void setVerify_type(int verify_type) {
         this.verify_type = verify_type;
     }
     public int getVerify_type() {
         return verify_type;
     }

}