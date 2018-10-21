package com.starocto.dao.api.model.resp;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Author : zjx@.com
 * Date   : 2018/10/3
 * Time   : 17:02
 * ---------------------------------------
 * Desc   : 消息（一条微博）
 */
@Data
public class BlogInfoResp implements Serializable {

    private static final long serialVersionUID = -1L;

    private int userId;
    private long blogId;
    /**
     * 1:仅文字 2:图片文字 3:视频文字
     */
    private int blogType;
    private String blogContentText;
    private String blogImageUrl;
    private String blogVideoUrl;
    private boolean blogIsOriginal;
    private long blogOriginalId;
    private Date blogPlusTime;
}
