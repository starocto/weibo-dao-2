package com.starocto.dao.api.model.mq;

import lombok.Data;

import java.io.Serializable;

/**
 * Author : zjx@.com
 * Date   : 2018/11/11
 * Time   : 15:14
 * ---------------------------------------
 * Desc   : 用户终端中最后一次加载微博消息的时间，用于提示有多少条新消息未加载，异步
 */
@Data
public class UserOthersMQ implements Serializable {

    private static final long serialVersionUID = -1L;

    private int userId;
    private String blogConsumeTime;
}
