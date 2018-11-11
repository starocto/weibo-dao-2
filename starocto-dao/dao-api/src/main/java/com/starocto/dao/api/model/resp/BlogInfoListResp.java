package com.starocto.dao.api.model.resp;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Author : zjx@.com
 * Date   : 2018/11/11
 * Time   : 15:46
 * ---------------------------------------
 * Desc   : 用户加载新消息，四种情况：
 *          1 刚刚登录，直接请求30条或最近5分钟内的新消息；
 *          2 登录中，下拉刷新加载，传入最后加载的最新消息的时间；
 *          3 上滑加载旧消息，传入最后加载的最旧消息的时间；
 *          4 新添加了关注人，下拉消息加载，传入最后加载的最新消息的时间，并且要求返回新关注人的微博消息。
 */
@Data
public class BlogInfoListResp implements Serializable {

    private static final long serialVersionUID = -1L;

    private List<BlogInfoResp> blogInfoRespList;
    /**
     * 消息中离当前时间最近的消息的  时间
     */
    private String nearTime;
    /**
     * 消息中离当前时间最远的消息的  时间
     */
    private String farTime;
}
