package com.starocto.dao.api.model.resp;

import lombok.Data;

import java.util.Date;

/**
 * Author : zjx@.com
 * Date   : 2018/10/3
 * Time   : 16:56
 * ---------------------------------------
 * Desc   : 用户的生产消费消息相关信息
 */
@Data
public class UserOthersResp {
    private int userId;
    private int blogProduceRate;
    private Date blogConsumeTime;
}
