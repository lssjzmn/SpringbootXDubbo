package com.lssjzmn.dubboFilters;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IpWhiteList {

    private boolean enabled = true;

    private static List<String> allowedList = new ArrayList<>();

    static {
        allowedList.add("127.0.0.1");
        allowedList.add("192.168.0.101");
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String addAllowedIp(String ip) {
        allowedList.add(ip);
        return ip;
    }

    public List<String> getAllowedList() {
        return allowedList;
    }

    public void setAllowedList(List<String> allowedList) {
        this.allowedList = allowedList;
    }
}
