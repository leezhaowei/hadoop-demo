package com.zwli.test;

import java.io.InputStream;
import java.net.URL;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

public class URLCat {

    static {
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
    }

    public static void main(final String[] args) throws Exception {
        InputStream in = null;
        try {
//            in = new URL(args[0]).openStream();
            in = new URL("hdfs://localhost/user/text.txt").openStream();
            IOUtils.copyBytes(in, System.out, 4096, false);
        } finally {
            IOUtils.closeStream(in);
        }
    }
}
