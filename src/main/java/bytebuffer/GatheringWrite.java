package bytebuffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 集中写入
 */
public class GatheringWrite {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("bytebuffer.ScatteringRead.txt",
                "rw")) {
            FileChannel channel = file.getChannel();
            ByteBuffer d = ByteBuffer.allocate(4);
            ByteBuffer e = ByteBuffer.allocate(4);
            channel.position(11);   // 设置从文件的哪个位置开始写
            d.put(new byte[]{'f', 'o', 'u', 'r'});
            e.put(new byte[]{'f', 'i', 'v', 'e'});
            d.flip();
            e.flip();
            ByteBufferUtil.debugAll(d);
            ByteBufferUtil.debugAll(e);
            channel.write(new ByteBuffer[]{d, e});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
