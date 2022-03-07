package com.sequenceiq.cloudbreak.cloud.event.platform;

import java.util.Map;

import com.sequenceiq.cloudbreak.cloud.event.CloudPlatformRequest;
import com.sequenceiq.cloudbreak.cloud.model.CloudCredential;
import com.sequenceiq.cloudbreak.cloud.model.ExtendedCloudCredential;

public class GetPlatformPrivateDnsZonesRequest extends CloudPlatformRequest<GetPlatformPrivateDnsZonesResult> {

    private final String region;

    private final String variant;

    private final ExtendedCloudCredential extendedCloudCredential;

    private final Map<String, String> filters;

    public GetPlatformPrivateDnsZonesRequest(CloudCredential cloudCredential, ExtendedCloudCredential extendedCloudCredential, String region, String variant,
            Map<String, String> filters) {
        super(null, cloudCredential);
        this.region = region;
        this.variant = variant;
        this.extendedCloudCredential = extendedCloudCredential;
        this.filters = filters;
    }

    public String getRegion() {
        return region;
    }

    public String getVariant() {
        return variant;
    }

    public ExtendedCloudCredential getExtendedCloudCredential() {
        return extendedCloudCredential;
    }

    public Map<String, String> getFilters() {
        return filters;
    }

    @Override
    public String toString() {
        return "GetPlatformPrivateDnsZonesRequest{}";
    }

}