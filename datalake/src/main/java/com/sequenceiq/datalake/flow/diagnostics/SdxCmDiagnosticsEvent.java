package com.sequenceiq.datalake.flow.diagnostics;

import com.sequenceiq.flow.core.FlowEvent;

public enum SdxCmDiagnosticsEvent implements FlowEvent {
    SDX_CM_DIAGNOSTICS_COLLECTION_EVENT("SDX_CM_DIAGNOSTICS_COLLECTION_EVENT"),
    SDX_CM_DIAGNOSTICS_COLLECTION_IN_PROGRESS_EVENT("SDX_CM_DIAGNOSTICS_COLLECTIOM_IN_PROGRESS_EVENT"),
    SDX_CM_DIAGNOSTICS_COLLECTION_SUCCESS_EVENT("SDX_CM_DIAGNOSTICS_COLLECTION_SUCCESS_EVENT"),
    SDX_CM_DIAGNOSTICS_COLLECTION_FAILED_EVENT("SDX_CM_DIAGNOSTICS_COLLECTION_FAILED_EVENT"),
    SDX_CM_DIAGNOSTICS_COLLECTION_FAILED_HANDLED_EVENT("SDX_CM_DIAGNOSTICS_COLLECTION_FAILED_HANDLED_EVENT"),
    SDX_CM_DIAGNOSTICS_COLLECTION_FINALIZED_EVENT("SDX_CM_DIAGNOSTICS_COLLECTION_FINALIZED_EVENT");

    private final String event;

    SdxCmDiagnosticsEvent(String event) {
        this.event = event;
    }

    @Override
    public String event() {
        return event;
    }
}