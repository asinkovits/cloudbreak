package com.sequenceiq.cloudbreak.converter;

import com.sequenceiq.common.api.type.LoadBalancerStatus;

public class LoadBalancerStatusConverter extends DefaultEnumConverter<LoadBalancerStatus> {

    @Override
    public LoadBalancerStatus getDefault() {
        return LoadBalancerStatus.ENABLED;
    }
}
