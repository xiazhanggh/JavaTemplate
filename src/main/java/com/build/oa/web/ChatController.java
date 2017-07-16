package com.build.oa.web;

import com.build.oa.socketio.ChatRoomHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xzhang on 7/16/2017.
 */
@Controller
@RequestMapping(value="chat")
@ResponseBody
public class ChatController {

    @Autowired
    private ChatRoomHelper chatRoomHelper;

    @RequestMapping(value = "createRoom")
    public boolean createChatRoom(@RequestParam(name = "name",required = true) String name){
       return chatRoomHelper.create(name);
    }

}
