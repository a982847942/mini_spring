package swu.zk.io;

import cn.hutool.core.io.resource.UrlResource;
import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Classname DefaultResourceLoader
 * @Description TODO
 * @Date 2022/4/9 14:27
 * @Created by brain
 */
public class DefaultResourceLoader implements ResourceLoader{
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        if (location.startsWith(CLASS_PATH_PREFIX)){
            return new CLassPathResource(location.substring(CLASS_PATH_PREFIX.length()));
        }else {
            try {
                URL url = new URL(location);
                return new URLResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
