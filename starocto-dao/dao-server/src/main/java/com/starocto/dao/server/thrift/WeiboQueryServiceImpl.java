package com.starocto.dao.server.thrift;


import com.starocto.dao.api.model.resp.*;
import com.starocto.dao.api.service.WeiboQueryService;
import com.starocto.dao.common.utils.BeanUtils;
import com.starocto.dao.db.mapper.WeiboDataMapper;
import com.starocto.dao.db.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author : zjx@.com
 * Date   : 2018/10/3
 * Time   : 12:36
 * ---------------------------------------
 * Desc   :
 */
@Service
public class WeiboQueryServiceImpl implements WeiboQueryService {

    @Autowired
    private WeiboDataMapper weiboDataMapper;

    @Override
    public BlogCountResp queryBlogCount(long blogId){
        BlogCountDO blogCountDO = weiboDataMapper.selectBlogCountDO(blogId);
        return BeanUtils.propertiesCopy(blogCountDO, new BlogCountResp());
    }

    @Override
    public BlogInfoListResp queryBlogInfo(int userId){
        List<BlogInfoDO> blogInfoDOS = weiboDataMapper.selectBlogInfoDO(userId);
        BlogInfoListResp result = new BlogInfoListResp();
        List<BlogInfoResp> blogInfoResps = blogInfoDOS.stream()
                .map(e -> {
                    BlogInfoResp resp = BeanUtils.propertiesCopy(e, new BlogInfoResp());
                    resp.setBlogPlusTime(e.getBlogPlusTime().toString());
                    resp.setCommentList(this.queryCommentToBlog(e.getBlogId()));
                    return resp;
                })
                .collect(Collectors.toList());
        result.setBlogInfoRespList(blogInfoResps);
        // 这里存在问题，要对返回的微博消息列表进行时间上的排序，并且这里要注意 判空
        result.setNearTime(blogInfoResps.get(0).getBlogPlusTime());
        result.setFarTime(blogInfoResps.get(blogInfoResps.size() - 1).getBlogPlusTime());
        return result;
    }

    @Override
    public List<CommentToBlogResp> queryCommentToBlog(long blogId){
        List<CommentToBlogDO> commentToBlogDOS = weiboDataMapper.selectCommentToBlogDO(blogId);
        return commentToBlogDOS.stream()
                .map(e -> {
                    CommentToBlogResp resp = BeanUtils.propertiesCopy(e, new CommentToBlogResp());
                    resp.setCommentTime(e.getCommentTime().toString());
                    return resp;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<UserFollowResp> queryUserFollow(int userId){
        List<UserFollowDO> userFollowDOS = weiboDataMapper.selectUserFollowDO(userId);
        return userFollowDOS.stream()
                .map(e -> {
                    UserFollowResp resp = BeanUtils.propertiesCopy(e, new UserFollowResp());
                    resp.setFollowTime(e.getFollowTime().toString());
                    return resp;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<UserFollowResp> queryFans(int followUserId){
        List<UserFollowDO> userFollowDOS = weiboDataMapper.selectFansDO(followUserId);
        return userFollowDOS.stream()
                .map(e -> {
                    UserFollowResp resp = BeanUtils.propertiesCopy(e, new UserFollowResp());
                    resp.setFollowTime(e.getFollowTime().toString());
                    return resp;
                })
                .collect(Collectors.toList());
    }

    @Override
    public UserInfoResp queryUserInfo(int userId){
        UserInfoDO userFollowDO = weiboDataMapper.selectUserInfoDO(userId);
        return BeanUtils.propertiesCopy(userFollowDO, new UserInfoResp());
    }

    @Override
    public UserOthersResp queryUserOthers(int userId){
        UserOthersDO userOthersDO = weiboDataMapper.selectUserOthersDO(userId);
        UserOthersResp resp = BeanUtils.propertiesCopy(userOthersDO, new UserOthersResp());
        resp.setBlogConsumeTime(userOthersDO.getBlogConsumeTime().toString());
        return resp;
    }

    @Override
    public UserRegisterInfoResp queryUserRegisterInfo(String userName){
        UserRegisterInfoDO userRegisterInfoDO = weiboDataMapper.selectUserRegisterInfoDO(userName);
        UserRegisterInfoResp resp = BeanUtils.propertiesCopy(userRegisterInfoDO, new UserRegisterInfoResp());
        resp.setUserChangeTime(userRegisterInfoDO.getUserChangeTime().toString());
        resp.setUserRegisterTime(userRegisterInfoDO.getUserRegisterTime().toString());
        return resp;
    }
}
