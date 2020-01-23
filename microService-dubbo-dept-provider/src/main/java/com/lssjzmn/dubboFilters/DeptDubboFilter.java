package com.lssjzmn.dubboFilters;

import org.apache.dubbo.rpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 简单的IP白名单访问鉴权
 */
public class DeptDubboFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(DeptDubboFilter.class);

    private IpWhiteList ipWhiteList;

    @Autowired
    public void setIpWhiteList(IpWhiteList ipWhiteList) {
        this.ipWhiteList = ipWhiteList;
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        logger.info("DeptDubboFilter className:{", invocation.getClass().getName() + "}");
        logger.info("DeptDubboFilter methodName:{", invocation.getMethodName() + "}");

        if (!ipWhiteList.isEnabled()) {
            logger.info("ip白名单已禁用");
            return invoker.invoke(invocation);
        }

        String clientIp = RpcContext.getContext().getRemoteHost();
        logger.info("client ip is :" + clientIp);
        if (ipWhiteList.getAllowedList().contains(clientIp)) {
            return invoker.invoke(invocation);
        } else {
            return new AppResponse("client ip is not allowed");
        }

    }

}
