package swu.zk.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname Resource
 * @Description TODO
 * @Date 2022/4/9 14:06
 * @Created by brain
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
