package swu.zk.io;

import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Classname URLResource
 * @Description TODO
 * @Date 2022/4/9 14:20
 * @Created by brain
 */
public class URLResource implements Resource {
    private final URL url;

    public URLResource(URL url) {
        Assert.notNull(url,"URL must not be null");
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection conn = this.url.openConnection();
        try {
            return conn.getInputStream();
        } catch (IOException ex){
            if (conn instanceof HttpURLConnection){
                ((HttpURLConnection) conn).disconnect();
            }
            throw ex;
        }
    }
}
