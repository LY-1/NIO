package bytebuffer;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 字符串与 ByteBuffer 互转
 */
public class Translate {

    public static void main(String[] args) {
        String s1 = "你好";
        String s2 = "test0";
        String s3 = "test1";
        String s4 = "test2";
        String s;

        // 分配内存
        ByteBuffer buffer1 = ByteBuffer.allocate(10);
        // 通过字符串的getByte方法得到字节数组，放入缓冲区
        buffer1.put(s1.getBytes());
        buffer1.flip();
        s = StandardCharsets.UTF_8.decode(buffer1).toString();
        System.out.println(s);

        // 通过StandardCharsets的encode方法获得ByteBuffer
        // 此时获得的ByteBuffer为读模式，无需通过flip切换模式
        ByteBuffer buffer2 = StandardCharsets.UTF_8.encode(s2);
        s = StandardCharsets.UTF_8.decode(buffer2).toString();
        System.out.println(s);

        // 通过Charset.forName("utf-8")的encode方法获得ByteBuffer
        // 此时获得的ByteBuffer为读模式，无需通过flip切换模式
        ByteBuffer buffer3 = Charset.forName("utf-8").encode(s3);
        s = StandardCharsets.UTF_8.decode(buffer3).toString();
        System.out.println(s);

        // 通过StandardCharsets的encode方法获得ByteBuffer
        // 此时获得的ByteBuffer为读模式，无需通过flip切换模式
        ByteBuffer buffer4 = ByteBuffer.wrap(s4.getBytes());
        s = StandardCharsets.UTF_8.decode(buffer4).toString();
        System.out.println(s);
    }
}
