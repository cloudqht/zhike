package com.newcoder.zhike.service;

import org.springframework.stereotype.Service;

@Service
public class WendaService {
    public String getMessage(int userId){
        return "hello message:" + String.valueOf(userId);
    }
}
