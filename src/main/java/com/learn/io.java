package com.learn;
import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * @author jingpb
 * @version 1.0
 * @date 2021/1/15 18:30
 */
public class io {
    public static void main(String[] args) {
        long length = FileUtils.sizeOf(new File("J:/PrtSc/20190321/1.png"));
               System.out.println(length);
               length = FileUtils.sizeOf(new File("J:/PrtSc/20190321"));
               System.out.println(length);
               length = FileUtils.sizeOfDirectory(new File("J:/PrtSc/20190321"));
               System.out.println(length);
    }
}
