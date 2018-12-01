import music.ablum.Music;
import music.ablum.MusicAblum;
import music.pass.Midurlinfo;
import music.utils.Utils;

public class Main {

        public static void main(String[] args) {
            //获取Mid的地址
            String address = "https://c.y.qq.com/v8/fcg-bin/fcg_v8_album_info_cp.fcg?albummid=003hDFKy3I7AKA&g_tk=5381&jsonpCallback=albuminfoCallback&loginUin=0&hostUin=0&format=jsonp&inCharset=utf8&outCharset=utf-8&notice=0&platform=yqq&needNewCode=0";
            MusicAblum bean = new MusicAblum();
            bean = bean.getMusicAlbum(address);
            for(Music m :bean.getData().getList()){
                Midurlinfo info = new Midurlinfo();
                info = info.getSongPassInfo(m.getSongmid());
                //System.out.println(info.getFilename()+" & "+info.getVkey());
                downLoadMusic(info,m);
            }
        }
        /**
         * 下载music
         * @param minfo 歌曲加密信息
         * @param music 歌曲基础信息
         * @return
         */
        public static double downLoadMusic(Midurlinfo minfo ,Music music){
            String downLoadUrl = "http://dl.stream.qqmusic.qq.com/"+minfo.getFilename()+"?guid=9545253443&vkey="+minfo.getVkey()+"&uin=0&fromtag=66";
            return  Utils.downloadFile(downLoadUrl,"E:\\JavaMusic\\"+music.getSongname()+".m4a",music.getSongname());
        }


    }

