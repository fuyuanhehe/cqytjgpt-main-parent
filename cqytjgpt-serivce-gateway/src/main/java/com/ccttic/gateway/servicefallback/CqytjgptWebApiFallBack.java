package com.ccttic.gateway.servicefallback;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * 说明：cqytjgpt-web-api 服务的降级数据
 * */
@Component
public class CqytjgptWebApiFallBack implements FallbackProvider {

    @Override
    public String getRoute() {
        return "cqytjgpt-web-api";
    }

    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }

            @Override
            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                Map<String, String> strMap = new HashMap<>();
                strMap.put("state", "false");
                strMap.put("error", cause.getMessage());
                strMap.put("msg", "当前访问的模块不可用");
                ByteArrayOutputStream byteArrayOutputStream = null;
                ObjectOutputStream objectOutputStream = null;
                byte[] bytes = null;
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    objectOutputStream = new ObjectOutputStream(new ByteArrayOutputStream());
                    objectOutputStream.writeObject(strMap);
                    objectOutputStream.flush();
                    bytes = byteArrayOutputStream.toByteArray();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (byteArrayOutputStream != null)
                        byteArrayOutputStream.close();
                    if (objectOutputStream != null)
                        objectOutputStream.close();
                }
                return new ByteArrayInputStream(bytes);
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));
                headers.setContentType(mt);
                return headers;
            }
        };
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }

            @Override
            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                Map<String, String> strMap = new HashMap<>();
                strMap.put("state", "false");
                strMap.put("error", "");
                strMap.put("msg", "当前访问的模块不可用");
                ByteArrayOutputStream byteArrayOutputStream = null;
                ObjectOutputStream objectOutputStream = null;
                byte[] bytes = null;
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    objectOutputStream = new ObjectOutputStream(new ByteArrayOutputStream());
                    objectOutputStream.writeObject(strMap);
                    objectOutputStream.flush();
                    bytes = byteArrayOutputStream.toByteArray();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (byteArrayOutputStream != null)
                        byteArrayOutputStream.close();
                    if (objectOutputStream != null)
                        objectOutputStream.close();
                }
                return new ByteArrayInputStream(bytes);
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));
                headers.setContentType(mt);
                return headers;
            }
        };
    }
}
