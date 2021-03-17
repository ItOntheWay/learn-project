package com.learn.test;

import java.io.UnsupportedEncodingException;

/**
 * @author jingpb
 * @version 1.0
 * @date 2021/1/7 11:54
 */
public class URLEncoder {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "pages/vr_room/package/room/room?hid=155355&city=ab&zid=121041&liveUid=&nickName=马洪艳&hName=水光之城&toId=111213170&groupUid=101373651@group/newhouse&headImg=&hxName=7室4厅3卫&shareImg=https%3A%2F%2Fess.leju.com%2Fcommon%2Fphoto%2F23-1-mCLpNHGPsBNyYR7HnoIMVW40vcmGKev7kSlaHQl287ACI4v6pxrjdl8ruovdueCcV4XeCXqpywfu2dQv_cm640X512_wm1_wmp5.jpg&houseid=308&specify=true&chatType=3&pageSource=buildDetail&takelook=false&shareEntry=true&vrUrl=https%3A%2F%2Fview.vr.leju.com%2Fhouse%2Findex.html%3Fm%3D08cacc30_w3xk_b6f9%26showtakelook%3Don%26source%3Dapplet%26house_id%3D308&m=08cacc30_w3xk_b6f9";
//        String res = java.net.URLEncoder.encode(str, "UTF-8");
//        System.out.println("-->"+res);
        String strs = java.net.URLDecoder.decode(str, "UTF-8");
        System.out.println(strs.replace("&showtakelook=on",""));
    }
}
