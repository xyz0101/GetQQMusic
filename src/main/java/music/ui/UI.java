package music.ui;

import music.ablum.Music;
import music.ablum.MusicAblum;
import music.pass.Midurlinfo;
import music.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class UI extends JFrame implements Runnable {

    private JTextField dicInput;
    private JButton urlButton;
    private JButton fileButton;
    private JTextField urlInput;
    private JList list;
    private JLabel jlable;
    private JButton downLoadButton;
    private Vector vc = new Vector<String>();
    private JTextArea area;
    private List<Music> musics=new ArrayList();
    private Container c;
    private MusicAblum album = new MusicAblum();
    private  JTextField percent;
    private File chooseFile;
    private Thread t ;
    private static UI u;
    public UI(){
        this.setSize(600,920);
        this.setLocation(600,100);
        this.setTitle("QQ音乐下载程序");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setUndecorated(true);
        // p = Factory.getPlane(cindex);
        c = getContentPane();
        c.setLayout(null);
        //专辑地址lable
        JLabel lable = new JLabel("请输入专辑链接地址:");
        lable.setSize(140,30);
        lable.setLocation(20,20);
        this.add(lable);
        //地址输入
        urlInput = new JTextField("");
        urlInput.setLocation(145,20);
        urlInput.setEditable(true);
        urlInput.setSize(300,30);
        this.add(urlInput);
        //进入地址按钮
        urlButton = new JButton("进入");
        urlButton.setLocation(455,20);
        urlButton.setSize(90,30);
        urlButton.addActionListener(new MyAction());
        this.add(urlButton);
        //目录选择lable
        JLabel dicLable = new JLabel("请选择目录:");
        dicLable.setSize(100,30);
        dicLable.setLocation(20,60);
        c.add( dicLable);

        //目录输入
        dicInput = new JTextField("");
        dicInput.setLocation(145,60);
        dicInput.setEditable(true);
        dicInput.setSize(300,30);
        c.add(dicInput);

        //文件选择按钮
        fileButton = new JButton("选择目录");
        fileButton.setLocation(455,60);
        fileButton.setSize(90,30);
        fileButton.addActionListener(new MyAction());
        c.add(fileButton);



        //列表
        list = new JList(vc);
        list.setLocation(20,360);
        list.setSize(540,450);
        c.add(list);

        //图片
        jlable = new JLabel();
        jlable.setLocation(20,100);
        jlable.setSize(200,200);
        c.add(jlable);

        //专辑介绍
        JTextField tf = new JTextField("专辑介绍：");
        tf.setFont(new Font("微软雅黑", Font.BOLD, 16));
        tf.setBounds(240,100,100,20);
        tf.setEditable(false);
        c.add(tf);
        //介绍内容
        area = new JTextArea();
        area.setBounds(240,130,300,170);
        area.setRows(5);
        area.setBackground(null);
        area.setEditable(false);
        area.setLineWrap(true);        //自动换行
        area.setWrapStyleWord(true);            // 断行不断字
        c.add(area);
        JScrollPane sc = new JScrollPane();
        sc.setBounds(240,130,300,160);
        c.add(sc);
        sc.setViewportView(area);
        //下载按钮

        downLoadButton = new JButton("下载已选");
        downLoadButton.setBounds(470,310,90,30);
        downLoadButton.addActionListener(new MyAction());
        c.add(downLoadButton);

        //专辑介绍
        percent = new JTextField();
        percent.setFont(new Font("微软雅黑", Font.BOLD, 16));
        percent.setBounds(20,820,400,20);
        percent.setEditable(false);
        c.add(percent);

        //菜单
        JMenuBar menubar = new JMenuBar();

        JMenu mune = new JMenu("选项");
        JMenuItem item = new JMenuItem("关于");
        item.addActionListener(new MyAction());

        mune.add(item);
        menubar.add(mune);

        this.setJMenuBar(menubar);
        c.setFocusable(true);
        this.setVisible(true);

    }

    public static void main(String[] args){

        u= new UI();

    }

    
    public void run() {
        for(int index :list.getSelectedIndices()){
            System.out.println("选择==>"+index);
            if(musics!=null) {
                Music music = musics.get(index);
                if(music!=null){
                    Midurlinfo info = new Midurlinfo();
                    info= info.getSongPassInfo(music.getSongmid());
                    System.out.println(music.getSongmid());

                    String downLoadUrl = "http://dl.stream.qqmusic.qq.com/"+info.getFilename()+"?guid=9545253443&vkey="+info.getVkey()+"&uin=0&fromtag=66";
                    Utils.downloadFileInGUI(downLoadUrl,dicInput.getText()+"/"+music.getSongname()+".m4a",music.getSongname(),percent);
                }
            }

        }
    }


    class MyAction implements ActionListener  {

        
        public void actionPerformed(ActionEvent e) {
            // System.out.println((((JButton)e.getSource()).getText()));

            if( e.getSource() instanceof  JButton) {

                if ("选择目录".equals(((JButton) e.getSource()).getText())) {
                    //文件夹选择
                    JFileChooser jfc = new JFileChooser();
                    jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    jfc.showDialog(c, null);
                    //jfc.showOpenDialog(null);
                    chooseFile = jfc.getSelectedFile();
                    dicInput.setText(chooseFile.getAbsolutePath());
                } else if ("进入".equals(((JButton) e.getSource()).getText())) {
                    if (urlInput.getText() != null) {

                        System.out.println(urlInput.getText());
                        String id = urlInput.getText().split(".html")[0];
                        id = id.substring(id.lastIndexOf("/") + 1, id.length());
                        System.out.println(id);
                        String url = "https://c.y.qq.com/v8/fcg-bin/fcg_v8_album_info_cp.fcg?albummid=" + id + "&g_tk=5381&jsonpCallback=albuminfoCallback&loginUin=0&hostUin=0&format=jsonp&inCharset=utf8&outCharset=utf-8&notice=0&platform=yqq&needNewCode=0";

                        album = album.getMusicAlbum(url);
                        vc.clear();
                        musics = album.getData().getList();
                        for (Music m : musics) {
                            Midurlinfo info = new Midurlinfo();
                            info = info.getSongPassInfo(m.getSongmid());
                            System.out.println(info.getFilename() + " & " + info.getVkey());
                            String str = m.getSongname() + "(" + m.getAlbumname() + ")";

                            vc.add(str);

                        }

                        list.setListData(vc);
                        //图片地址
                        String imageUrl = "http://y.gtimg.cn/music/photo_new/T002R300x300M000" + id + ".jpg";
                        Utils.downloadFile(imageUrl, "./images/head.jpg", "head");
                        ImageIcon icon = new ImageIcon("./images/head.jpg");
                        icon.setImage(icon.getImage().getScaledInstance(200, 200,
                                Image.SCALE_DEFAULT));
                        jlable.setIcon(icon);
                        area.setText(album.getData().getDesc());
                    }
                } else if ("下载已选".equals(((JButton) e.getSource()).getText())) {
                    if (dicInput.getText() == null || "".equals(dicInput.getText())) {
                        JOptionPane.showMessageDialog(c, "请选择下载保存目录！", "提示信息", JOptionPane.WARNING_MESSAGE);
                    } else if (urlInput.getText() == null || "".equals(urlInput.getText()) || chooseFile == null) {
                        JOptionPane.showMessageDialog(c, "请输入专辑地址！", "提示信息", JOptionPane.WARNING_MESSAGE);
                    } else if (list.getSelectedValuesList() == null || list.getSelectedValuesList().size() == 0) {
                        JOptionPane.showMessageDialog(c, "请选择需要下载的歌曲！", "提示信息", JOptionPane.WARNING_MESSAGE);
                    } else {

                        u.t = new Thread(u);
                        t.start();

                        //  JOptionPane.showMessageDialog(c,"已有任务正在下载，请等待下载完成！","提示信息",JOptionPane.WARNING_MESSAGE);

                        //System.out.println( t.isAlive());

                    }


                }
            }else if(e.getSource() instanceof JMenuItem){
                JOptionPane.showMessageDialog(c,"版本：QQ音乐下载程序V1.0\n作者：周锦\n温馨提示：此程序仅供娱乐，请勿非法使用","关于",JOptionPane.WARNING_MESSAGE);
            }
        }

    }

}
