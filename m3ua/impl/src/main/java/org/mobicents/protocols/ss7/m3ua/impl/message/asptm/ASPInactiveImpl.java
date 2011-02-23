package org.mobicents.protocols.ss7.m3ua.impl.message.asptm;

import java.nio.ByteBuffer;

import org.mobicents.protocols.ss7.m3ua.impl.message.M3UAMessageImpl;
import org.mobicents.protocols.ss7.m3ua.impl.parameter.ParameterImpl;
import org.mobicents.protocols.ss7.m3ua.message.MessageClass;
import org.mobicents.protocols.ss7.m3ua.message.MessageType;
import org.mobicents.protocols.ss7.m3ua.message.asptm.ASPInactive;
import org.mobicents.protocols.ss7.m3ua.parameter.InfoString;
import org.mobicents.protocols.ss7.m3ua.parameter.Parameter;
import org.mobicents.protocols.ss7.m3ua.parameter.RoutingContext;

public class ASPInactiveImpl extends M3UAMessageImpl implements ASPInactive {

    public ASPInactiveImpl() {
        super(MessageClass.ASP_TRAFFIC_MAINTENANCE, MessageType.ASP_INACTIVE);
    }

    @Override
    protected void encodeParams(ByteBuffer buffer) {

        if (parameters.containsKey(Parameter.Routing_Context)) {
            ((ParameterImpl) parameters.get(Parameter.Routing_Context)).write(buffer);
        }
        if (parameters.containsKey(Parameter.INFO_String)) {
            ((ParameterImpl) parameters.get(Parameter.INFO_String)).write(buffer);
        }
    }

    public InfoString getInfoString() {
        return (InfoString) parameters.get(Parameter.INFO_String);
    }

    public RoutingContext getRoutingContext() {
        return (RoutingContext) parameters.get(Parameter.Routing_Context);
    }

    public void setInfoString(InfoString str) {
        if (str != null) {
            parameters.put(ParameterImpl.INFO_String, str);
        }

    }

    public void setRoutingContext(RoutingContext rc) {
        parameters.put(ParameterImpl.Routing_Context, rc);

    }
}