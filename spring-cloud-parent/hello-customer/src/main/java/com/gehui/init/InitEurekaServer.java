package com.gehui.init;

import java.net.URI;

/**
 * Created by Administrator on 2018/10/20 11:17.
 **/
public class InitEurekaServer {
    //服务地址
    private String host;
    //服务实例编号
    private String serviceId;
    //服务端口号
    private int port;
    //服务地址
    private URI uri;

    public static InitEurekaServer getEurekaServer(){
        return new InitEurekaServer();
    }

    public InitEurekaServer() {
    }

    public InitEurekaServer(String host, String serviceId, int port, URI uri) {
        this.host = host;
        this.serviceId = serviceId;
        this.port = port;
        this.uri = uri;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "InitEurekaServer{" +
                "host='" + host + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", port='" + port + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }
}
