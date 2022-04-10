package swu.zk.io;

import cn.hutool.core.lang.Assert;
import swu.zk.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname CLassPathResource
 * @Description TODO
 * @Date 2022/4/9 14:07
 * @Created by brain
 */
public class CLassPathResource implements Resource{
    private final String path;
    private ClassLoader classLoader;

    public CLassPathResource(String path) {
        this(path,null);
    }

    public CLassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull("path must no be null",path);
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassloader());
    }

    public String getPath() {
        return path;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = this.classLoader.getResourceAsStream(this.path);
        if (is == null){
            throw new FileNotFoundException(
                    this.path + " cannot be opened because it does not exist");
        }
        return is;
    }
}
