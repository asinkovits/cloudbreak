package com.sequenceiq.freeipa.flow.stack.upgrade.ccm.event;

import java.util.Optional;

import com.sequenceiq.cloudbreak.ccm.cloudinit.CcmConnectivityParameters;
import com.sequenceiq.cloudbreak.clusterproxy.Tunnel;
import com.sequenceiq.freeipa.flow.stack.StackEvent;

public class UpgradeCcmEvent extends StackEvent {
    private String selector;

    private Tunnel oldTunnel;

    private CcmConnectivityParameters ccmConnectivityParameters;

    public UpgradeCcmEvent(String selector, Long stackId) {
        super(stackId);
        this.selector = selector;
    }

    public UpgradeCcmEvent(String selector, Long stackId, Tunnel oldTunnel, CcmConnectivityParameters ccmConnectivityParameters) {
        super(stackId);
        this.selector = selector;
        this.ccmConnectivityParameters = ccmConnectivityParameters;
        this.oldTunnel = oldTunnel;
    }

    @Override
    public String selector() {
        return selector;
    }

    public Optional<Tunnel> getOldTunnel() {
        return Optional.ofNullable(oldTunnel);
    }

    public void setOldTunnel(Tunnel oldTunnel) {
        this.oldTunnel = oldTunnel;
    }

    public Optional<CcmConnectivityParameters> getCcmConnectivityParameters() {
        return Optional.ofNullable(ccmConnectivityParameters);
    }

    public void setCcmConnectivityParameters(CcmConnectivityParameters ccmConnectivityParameters) {
        this.ccmConnectivityParameters = ccmConnectivityParameters;
    }

    @Override
    public String toString() {
        return "UpgradeCcmEvent{" +
                "selector=" + selector +
                ", oldTunnel=" + oldTunnel +
                ", ccmConnectivityParameter='" + ccmConnectivityParameters + '\'' +
                "} " + super.toString();
    }
}
