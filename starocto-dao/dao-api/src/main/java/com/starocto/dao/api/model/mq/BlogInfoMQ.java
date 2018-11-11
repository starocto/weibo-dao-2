package com.starocto.dao.api.model.mq;

import lombok.Data;

import java.io.Serializable;

/**
 * Author : zjx@.com
 * Date   : 2018/11/11
 * Time   : 16:17
 * ---------------------------------------
 * Desc   : 生产一条微博，异步存储
 *          这里有一个（数据库构建）错误，微博图片应该是一组（即列表类型），而不是一个（只有一个String类型）
 *          另外，视频和图片的上传问题，应该需要其它技术，目前看来暂时只能是文字类型
 */
@Data
public class BlogInfoMQ implements Serializable {

    private static final long serialVersionUID = -1L;

    private int userId;
    /**
     * 1:仅文字 2:图片文字 3:视频文字
     */
    private int blogType;
    private String blogContentText;
    private String blogImageUrl;
    private String blogVideoUrl;
    private boolean blogIsOriginal;
    private long blogOriginalId;
    private String blogPlusTime;
}
