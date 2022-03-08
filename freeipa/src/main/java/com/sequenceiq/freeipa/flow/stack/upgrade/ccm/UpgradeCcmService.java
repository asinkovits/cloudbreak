package com.sequenceiq.freeipa.flow.stack.upgrade.ccm;

import static com.sequenceiq.freeipa.api.v1.freeipa.stack.model.common.DetailedStackStatus.AVAILABLE;
import static com.sequenceiq.freeipa.api.v1.freeipa.stack.model.common.DetailedStackStatus.UPGRADE_CCM_FAILED;
import static com.sequenceiq.freeipa.api.v1.freeipa.stack.model.common.DetailedStackStatus.UPGRADE_CCM_IN_PROGRESS;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.sequenceiq.freeipa.api.v1.freeipa.stack.model.common.DetailedStackStatus;
import com.sequenceiq.freeipa.service.stack.StackUpdater;

@Component
public class UpgradeCcmService {

    @Inject
    private StackUpdater stackUpdater;

    public void checkPrerequsities(Long stackId) {
        return;
    }

    public void checkPrerequisitesState(Long stackId) {
        DetailedStackStatus detailedStatus = UPGRADE_CCM_IN_PROGRESS;
        String statusReason = "Upgrade CCM in progress";
        stackUpdater.updateStackStatus(stackId, detailedStatus, statusReason);
    }

    public void finishedState(Long stackId) {
        DetailedStackStatus detailedStatus = AVAILABLE;
        String statusReason = "Upgrade CCM succeed";
        stackUpdater.updateStackStatus(stackId, detailedStatus, statusReason);
    }

    public void failedState(Long stackId) {
        DetailedStackStatus detailedStatus = UPGRADE_CCM_FAILED;
        String statusReason = "Upgrade CCM failed";
        stackUpdater.updateStackStatus(stackId, detailedStatus, statusReason);
    }

    public void changeTunnelState(long stackId) {

    }

    public void changeTunnel(long stackId) {

    }

    public void pushSaltStatesState(long stackId) {

    }

    public void pushSaltStates(long stackId) {

    }

    public void upgradeState(long stackId) {

    }

    public void upgrade(long stackId) {

    }

    public void reconfigureState(long stackId) {

    }

    public void reconfigure(long stackId) {

    }

    public void registerCcmState(long stackId) {

    }

    public void registerCcm(long stackId) {

    }

    public void healthCheckState(long stackId) {

    }

    public void healthCheck(long stackId) {

    }

    public void removeMinaState(long stackId) {

    }

    public void removeMina(long stackId) {

    }
}
