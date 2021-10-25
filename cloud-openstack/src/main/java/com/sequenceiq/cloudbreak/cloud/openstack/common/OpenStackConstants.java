package com.sequenceiq.cloudbreak.cloud.openstack.common;

import org.springframework.stereotype.Service;

import com.sequenceiq.cloudbreak.cloud.CloudConstant;
import com.sequenceiq.cloudbreak.cloud.model.Platform;
import com.sequenceiq.cloudbreak.cloud.model.Variant;

@Service
public class OpenStackConstants implements CloudConstant {

    public static final Platform OPENSTACK_PLATFORM = Platform.platform("OPENSTACK");

    public static final String FACING = "facing";

    public static final String TENANT_ID = "tenantId";

    public static final String NETWORK_ID = "networkId";

    public static final String SUBNET_ID = "subnetId";

    public static final String ROUTER_ID = "routerId";

    public static final String VOLUME_MOUNT_POINT = "volumeMountPoint";

    public static final String PORT_ID = "portId";

    public static final String SERVER = "server";

    public static final String FLOATING_IP_IDS = "floatingIpIds";

    public static final String PUBLIC_NET_ID = "publicNetId";

    public static final String NETWORKING_OPTION = "networkingOption";

    private OpenStackConstants() {
    }

    @Override
    public Platform platform() {
        return OPENSTACK_PLATFORM;
    }

    @Override
    public Variant variant() {
        return OpenStackVariant.HEAT.variant();
    }

    public enum OpenStackVariant {
        HEAT("HEAT"),
        NATIVE("NATIVE");

        private final Variant variant;

        OpenStackVariant(String variant) {
            this.variant = Variant.variant(variant);
        }

        public Variant variant() {
            return variant;
        }
    }
}