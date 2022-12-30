package bytebuffer;

import java.nio.ByteBuffer;

public class ByteBufferDemo {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(32);
        // 模拟粘包+半包
        buffer.put("Hello,world\nI'm Nyima\nHo".getBytes());

        split(buffer);
        buffer.put("w are you?\n".getBytes());
        split(buffer);
    }

    private static void split(ByteBuffer buffer) {
        // 切换为读模式
        buffer.flip();

        for (int i = 0; i < buffer.limit(); i ++) {
            if (buffer.get(i)  == '\n') {
                // 计算一个包的长度
                int length = i + 1 - buffer.position();
                ByteBuffer target = ByteBuffer.allocate(length);
                // 将前面的内容写入target缓冲区
                for (int j = 0; j < length; j ++) {
                    target.put(buffer.get());
                }
                target.flip();
                ByteBufferUtil.debugAll(target);
            }
        }
        buffer.compact();
    }
}
