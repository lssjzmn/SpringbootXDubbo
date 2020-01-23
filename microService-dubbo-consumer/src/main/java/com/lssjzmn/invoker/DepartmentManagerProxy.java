package com.lssjzmn.invoker;

import com.lssjzmn.entity.Department;
import com.lssjzmn.manager.department.api.DepartmentManager;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 充当网关代理角色和dubbo消费者角色，接收客户端httpInvoker请求，转发给dubbo服务提供者
 */
public class DepartmentManagerProxy implements DepartmentManager {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference(timeout = 10000, check = false)
    private DepartmentManager departmentManager;

    @Override
    public List<Department> findDepartmentsByClas(Map params) {
        logger.info("DepartmentManagerProxy called");
        return departmentManager.findDepartmentsByClas(params);
    }

}
