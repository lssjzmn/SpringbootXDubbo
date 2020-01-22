package com.lssjzmn.utils;

import com.lssjzmn.manager.doctor.api.DoctorManager;
import com.lssjzmn.util.AbstractHttpInvokerService;

public class DoctorHttpInvokerService extends AbstractHttpInvokerService<DoctorManager> {

    @Override
    public String setServiceUrl() {
        return "http://localhost:8083/doctorManager";
    }

}
