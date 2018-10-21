package com.starocto.dao.server.rpc;

import com.starocto.dao.api.service.WeiboQueryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

/**
 * Author : zjx@.com
 * Date   : 2018/10/21
 * Time   : 13:48
 * ---------------------------------------
 * Desc   :
 */
//@Configuration
public class RpcServerConfig {



//    @Bean
//    public RmiServiceExporter rmiServiceExporter(WeiboQueryService weiboQueryService){
//        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
//        rmiServiceExporter.setService(weiboQueryService);
//        rmiServiceExporter.setServiceName("WeiboQueryService");
//        rmiServiceExporter.setServiceInterface(WeiboQueryService.class);
////        rmiServiceExporter.setRegistryHost("1");
////        rmiServiceExporter.setRegistryPort(1999);
//        return rmiServiceExporter;
//    }
}
