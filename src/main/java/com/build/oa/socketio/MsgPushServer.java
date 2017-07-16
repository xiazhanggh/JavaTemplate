package com.build.oa.socketio;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

/**
 * Created by xzhang on 7/16/2017.
 */
@Configuration
public class MsgPushServer {


    @Value("${msgpush.server.hostname}")
    private String hostName;

    @Value(value = "${msgpush.server.port}")
    private int port;

    @Bean(destroyMethod = "stop")
    public SocketIOServer startServer(){
        com.corundumstudio.socketio.Configuration configuration = new com.corundumstudio.socketio.Configuration();
        configuration.setHostname(hostName);
        configuration.setPort(port);

        final SocketIOServer server = new SocketIOServer(configuration);

        server.addEventListener("chatevent",EmitObject.class,new DataListener<EmitObject>(){
            @Override
            public void onData(SocketIOClient client, EmitObject data, AckRequest ackSender) throws Exception {
                 server.getBroadcastOperations().sendEvent("chatevent",data);
            }
        });
        server.start();
        return server;
    }

}
