package com.starocto.dao.api.model.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * Author : zjx@.com
 * Date   : 2018/10/3
 * Time   : 16:56
 * ---------------------------------------
 * Desc   : 用户的生产消费消息相关信息
 */
@Data
public class UserOthersResp implements Serializable {

    private static final long serialVersionUID = -1L;

    private int userId;
    private int blogProduceRate;
    private String blogConsumeTime;
}
