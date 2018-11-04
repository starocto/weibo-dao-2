package com.starocto.dao.common.utils;

import com.google.common.collect.Maps;
import org.springframework.cglib.beans.BeanCopier;

import java.util.Map;

/**
 * Author : zjx@.com
 * Date   : 2018/10/4
 * Time   : 17:36
 * ---------------------------------------
 * Desc   :
 */
public class BeanUtils {

    static final Map<String, BeanCopier> BEAN_COPY_MAP = Maps.newHashMap();

    public static <T> T propertiesCopy(Object origin, T dest) {
        if(null == origin || null == dest){
            return null;
        }
        String key = origin.getClass().getName() + dest.getClass().getName();
        BeanCopier beanCopier = BEAN_COPY_MAP.get(key);
        if (null == beanCopier) {
            beanCopier = BeanCopier.create(origin.getClass(), dest.getClass(), false);
            BEAN_COPY_MAP.put(key, beanCopier);
        }
        beanCopier.copy(origin, dest, null);
        return dest;
    }
}
