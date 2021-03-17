package com.learn.filter;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

public class RequestWrapper  extends HttpServletRequestWrapper {
    private final String body;

    /**
     * Constructs a request object wrapping the given request.
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public RequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        // 此处是得到请求内容的长度
//        int contentLength = request.getContentLength();
//        StringBuilder stringBuilder = new StringBuilder(contentLength);
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        InputStream inputStream = null;
        try {
            // 输入流获取请求的数据
            inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        // 下面会把数据放回request的输入流中，所以要把数据恢复到与之前请求内容相同的长度
//        body = String.format("%-" + contentLength + "s", JSONObject.parseObject(stringBuilder.toString()));
        body = stringBuilder.toString();
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        // 数据放到字节流中
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.getBody().getBytes());
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener listener) {
            }

            @Override
            public int read() throws IOException {
                // 数据放回request的输入流中
                return byteArrayInputStream.read();
            }
        };
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }

    public String getBody() {
        // 请求中的数据
        return this.body;
    }
}
