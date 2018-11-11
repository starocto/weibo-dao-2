package com.starocto.dao.api.model.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * Author : zjx@.com
 * Date   : 2018/10/3
 * Time   : 17:10
 * ---------------------------------------
 * Desc   : 消息统计（一条微博消息的一些统计数据）
 *          没有收藏功能，其实可以把like功能作为收藏功能，不过，无论是收藏还是like都没有构建索引，
 *          即用户无法获取自己曾经like过或收藏过的所有微博消息。
 *          同样，没有观看记录的索引，即没有观看记录的功能。这个功能应该提供最近100条观看记录就OK。
 */
@Data
public class BlogCountResp implements Serializable {

    private static final long serialVersionUID = -1L;

    private long blogId;
    private int blogSeeNum;
    private int blogLikeNum;
    private int blogForwardNum;
    private int blogCommentNum;
}
