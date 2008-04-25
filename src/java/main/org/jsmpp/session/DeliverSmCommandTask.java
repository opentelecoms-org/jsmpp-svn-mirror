package org.jsmpp.session;

import java.io.IOException;
import java.io.OutputStream;

import org.jsmpp.NumberingPlanIndicator;
import org.jsmpp.PDUSender;
import org.jsmpp.PDUStringException;
import org.jsmpp.TypeOfNumber;
import org.jsmpp.bean.DataCoding;
import org.jsmpp.bean.ESMClass;
import org.jsmpp.bean.OptionalParameter;
import org.jsmpp.bean.RegisteredDelivery;

/**
 * @author uudashr
 *
 */
public class DeliverSmCommandTask extends AbstractSendCommandTask {
    private final String serviceType;
    private final TypeOfNumber sourceAddrTon;
    private final NumberingPlanIndicator sourceAddrNpi;
    private final String sourceAddr;
    private final TypeOfNumber destAddrTon;
    private final NumberingPlanIndicator destAddrNpi;
    private final String destinationAddr;
    private final ESMClass esmClass;
    private final byte protocoId;
    private final byte priorityFlag;
    private final RegisteredDelivery registeredDelivery;
    private final DataCoding dataCoding;
    private final byte[] shortMessage;
    private final OptionalParameter[] optionalParameters;
    
    public DeliverSmCommandTask(OutputStream out, PDUSender pduSender,
            String serviceType, TypeOfNumber sourceAddrTon,
            NumberingPlanIndicator sourceAddrNpi, String sourceAddr,
            TypeOfNumber destAddrTon, NumberingPlanIndicator destAddrNpi,
            String destinationAddr, ESMClass esmClass, byte protocoId,
            byte priorityFlag, RegisteredDelivery registeredDelivery,
            DataCoding dataCoding, byte[] shortMessage,
            OptionalParameter[] optionalParameters) {
        
        super(out, pduSender);
        this.serviceType = serviceType;
        this.sourceAddrTon = sourceAddrTon;
        this.sourceAddrNpi = sourceAddrNpi;
        this.sourceAddr = sourceAddr;
        this.destAddrTon = destAddrTon;
        this.destAddrNpi = destAddrNpi;
        this.destinationAddr = destinationAddr;
        this.esmClass = esmClass;
        this.protocoId = protocoId;
        this.priorityFlag = priorityFlag;
        this.registeredDelivery = registeredDelivery;
        this.dataCoding = dataCoding;
        this.shortMessage = shortMessage;
        this.optionalParameters = optionalParameters;
    }
    
    public void executeTask(OutputStream out, int sequenceNumber)
            throws PDUStringException, IOException {
        
        pduSender.sendDeliverSm(out, sequenceNumber, serviceType,
                sourceAddrTon, sourceAddrNpi, sourceAddr, destAddrTon,
                destAddrNpi, destinationAddr, esmClass, protocoId,
                priorityFlag, registeredDelivery, dataCoding, shortMessage,
                optionalParameters);
    }
    
    public String getCommandName() {
        return "deliver_sm";
    }
}
