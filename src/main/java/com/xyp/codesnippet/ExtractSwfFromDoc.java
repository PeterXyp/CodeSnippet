package com.xyp.codesnippet;

import com.xyp.codesnippet.resource.ResourceUtil;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Peter Xu
 */
public class ExtractSwfFromDoc {

    private static String FILE_DOC = "t.doc";
    private static String FILE_SWF = "target/o.swf";

    public static void main(String[] args) {
        InputStream is = ResourceUtil.loadClasspathResource(FILE_DOC);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        try {
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
        } catch (IOException ex) {
            Logger.getLogger(ExtractSwfFromDoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] bytes = baos.toByteArray();
        //find 46 57 53 hex str
        //70 87 83
        int start = 0;
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == 70) {
                if (bytes[i + 1] == 87 && bytes[i + 2] == 83) {
                    start = i;
                    break;
                }
            }
        }
        if (start == 0) {
            System.out.println("no flash found in this doc!");
            return;
        }
        baos.reset();
        for (int i = start; i < bytes.length; i++) {
            baos.write(bytes[i]);
        }
        try {
            baos.writeTo(new FileOutputStream(FILE_SWF));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExtractSwfFromDoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExtractSwfFromDoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
