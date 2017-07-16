package com.build.oa.socketio;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by xzhang on 7/16/2017.
 */
@Component
public class ChatRoomHelper {

    @Autowired
    private SocketIOServer socketIOServer;

    public boolean create(String roomName){
        SocketIONamespace roomNameSpace = socketIOServer.getNamespace(roomName);
        if(null == roomNameSpace){
            roomNameSpace = socketIOServer.addNamespace(roomName);
            roomNameSpace.addEventListener("message", EmitObject.class, new DataListener<EmitObject>() {
                @Override
                public void onData(SocketIOClient client, EmitObject data, AckRequest ackSender) throws Exception {
                    socketIOServer.getBroadcastOperations().sendEvent("message",data);
                }
            });
            return true;
        }
        return false;
    }

    public void remove(String roomName){
        socketIOServer.removeNamespace(roomName);
    }

}
