package com.sequenceiq.cloudbreak.converter.v4.userprofiles;

import java.time.Duration;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.sequenceiq.cloudbreak.api.endpoint.v4.userprofile.requests.ShowTerminatedClustersPreferencesV4Request;
import com.sequenceiq.cloudbreak.service.stack.ShowTerminatedClustersConfig;

@Component
public class ShowTerminatedClustersPreferencesV4RequestToShowTerminatedClustersPreferencesConverter {

    @Inject
    private DurationV4RequestToDurationConverter durationV4RequestToDurationConverter;

    public ShowTerminatedClustersConfig convert(ShowTerminatedClustersPreferencesV4Request source) {
        Duration duration = durationV4RequestToDurationConverter.convert(source.getTimeout());
        return new ShowTerminatedClustersConfig(getActive(source), duration, true);
    }

    private Boolean getActive(ShowTerminatedClustersPreferencesV4Request source) {
        return source.isActive() != null ? source.isActive() : false;
    }
}
