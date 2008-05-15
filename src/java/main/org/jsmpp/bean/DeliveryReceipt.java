package org.jsmpp.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsmpp.util.DeliveryReceiptState;


/**
 * @author uudashr
 * 
 */
public class DeliveryReceipt {
    // attribute of delivery receipt
    public static final String DELREC_ID = "id";
    public static final String DELREC_SUB = "sub";
    public static final String DELREC_DLVRD = "dlvrd";
    public static final String DELREC_SUBMIT_DATE = "submit date";
    public static final String DELREC_DONE_DATE = "done date";
    public static final String DELREC_STAT = "stat";
    public static final String DELREC_ERR = "err";
    public static final String DELREC_TEXT = "Text";

    /**
     * Date format for the <b>submit date</b> and <b>done date</b> attribute
     */
    private final SimpleDateFormat dateFormat = new SimpleDateFormat(
            "yyMMddHHmm");

    private String id;
    private int submitted;
    private int delivered;
    private Date submitDate;
    private Date doneDate;
    private DeliveryReceiptState finalStatus;
    private String error;
    private String text;

    public DeliveryReceipt() {

    }

    public DeliveryReceipt(String id, int submitted, int delivered,
            Date submitDate, Date doneDate, DeliveryReceiptState finalStatus,
            String error, String text) {
        this.id = id;
        this.submitted = submitted;
        this.delivered = delivered;
        this.submitDate = submitDate;
        this.doneDate = doneDate;
        this.finalStatus = finalStatus;
        this.error = error;
        if (text.length() > 20) {
            this.text = text.substring(0, 20);
        } else {
            this.text = text;
        }
    }

    /**
     * @return Returns the delivered.
     */
    public int getDelivered() {
        return delivered;
    }

    /**
     * @param delivered The delivered to set.
     */
    public void setDelivered(int delivered) {
        this.delivered = delivered;
    }

    /**
     * @return Returns the doneDate.
     */
    public Date getDoneDate() {
        return doneDate;
    }

    /**
     * @param doneDate The doneDate to set.
     */
    public void setDoneDate(Date doneDate) {
        this.doneDate = doneDate;
    }

    /**
     * @return Returns the error.
     */
    public String getError() {
        return error;
    }

    /**
     * @param error The error to set.
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * @return Returns the finalStatus.
     */
    public DeliveryReceiptState getFinalStatus() {
        return finalStatus;
    }

    /**
     * @param finalStatus The finalStatus to set.
     */
    public void setFinalStatus(DeliveryReceiptState finalStatus) {
        this.finalStatus = finalStatus;
    }

    /**
     * @return Returns the id.
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return Returns the submitDate.
     */
    public Date getSubmitDate() {
        return submitDate;
    }

    /**
     * @param submitDate The submitDate to set.
     */
    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    /**
     * @return Returns the submitted.
     */
    public int getSubmitted() {
        return submitted;
    }

    /**
     * @param submitted The submitted to set.
     */
    public void setSubmitted(int submitted) {
        this.submitted = submitted;
    }

    /**
     * @return Returns the text.
     */
    public String getText() {
        return text;
    }

    /**
     * Set the text of delivery receipt. Text more than 20 characters will be trim automatically.
     * 
     * @param text the text to set.
     */
    public void setText(String text) {
        if (text.length() > 20) {
            this.text = text.substring(0, 20);
        } else {
            this.text = text;
        }
    }

    public String toString() {
        /*
         * id:IIIIIIIIII sub:SSS dlvrd:DDD submit date:YYMMDDhhmm done
         * date:YYMMDDhhmm stat:DDDDDDD err:E Text: . . . . . . . . .
         */
        StringBuffer sBuf = new StringBuffer(120);
        sBuf.append(DELREC_ID + ":" + id);
        sBuf.append(" ");
        sBuf.append(DELREC_SUB + ":" + intToString(submitted, 3));
        sBuf.append(" ");
        sBuf.append(DELREC_DLVRD + ":" + intToString(delivered, 3));
        sBuf.append(" ");
        sBuf.append(DELREC_SUBMIT_DATE + ":" + dateFormat.format(submitDate));
        sBuf.append(" ");
        sBuf.append(DELREC_DONE_DATE + ":" + dateFormat.format(doneDate));
        sBuf.append(" ");
        sBuf.append(DELREC_STAT + ":" + finalStatus);
        sBuf.append(" ");
        sBuf.append(DELREC_STAT + ":" + error);
        sBuf.append(" ");
        sBuf.append(DELREC_TEXT + ":" + text);
        return sBuf.toString();
    }

    private static String intToString(int value, int digit) {
        StringBuffer sBuf = new StringBuffer(digit);
        sBuf.append(Integer.toString(value));
        while (sBuf.length() < digit) {
            sBuf.insert(0, "0");
        }
        return sBuf.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((dateFormat == null) ? 0 : dateFormat.hashCode());
        result = prime * result + delivered;
        result = prime * result
                + ((doneDate == null) ? 0 : doneDate.hashCode());
        result = prime * result + ((error == null) ? 0 : error.hashCode());
        result = prime * result
                + ((finalStatus == null) ? 0 : finalStatus.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result
                + ((submitDate == null) ? 0 : submitDate.hashCode());
        result = prime * result + submitted;
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final DeliveryReceipt other = (DeliveryReceipt)obj;
        if (dateFormat == null) {
            if (other.dateFormat != null)
                return false;
        } else if (!dateFormat.equals(other.dateFormat))
            return false;
        if (delivered != other.delivered)
            return false;
        if (doneDate == null) {
            if (other.doneDate != null)
                return false;
        } else if (!doneDate.equals(other.doneDate))
            return false;
        if (error == null) {
            if (other.error != null)
                return false;
        } else if (!error.equals(other.error))
            return false;
        if (finalStatus == null) {
            if (other.finalStatus != null)
                return false;
        } else if (!finalStatus.equals(other.finalStatus))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (submitDate == null) {
            if (other.submitDate != null)
                return false;
        } else if (!submitDate.equals(other.submitDate))
            return false;
        if (submitted != other.submitted)
            return false;
        if (text == null) {
            if (other.text != null)
                return false;
        } else if (!text.equals(other.text))
            return false;
        return true;
    }
    
    
}
