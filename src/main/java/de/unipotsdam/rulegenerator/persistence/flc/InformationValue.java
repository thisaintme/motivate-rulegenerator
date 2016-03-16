package de.unipotsdam.rulegenerator.persistence.flc;

import de.unipotsdam.rulegenerator.statistics.Reason;

import java.util.Date;

/**
 * Created by martinhertel on 01/02/16.
 */
public class InformationValue {
    private String informationID;
    private String value;
    private Date recordedTime;
    private Reason reason;

    public InformationValue(String informationID, String value, Date recordedTime, Reason reason) {
        this.informationID = informationID;
        this.value = value;
        this.recordedTime = recordedTime;
        this.reason = reason;
    }

    public String getInformationID() {
        return informationID;
    }

    public void setInformationID(String informationID) {
        this.informationID = informationID;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getRecordedTime() {
        return recordedTime;
    }

    public void setRecordedTime(Date recordedTime) {
        this.recordedTime = recordedTime;
    }

    public Reason getReason() { return reason; }

    public void setReason(Reason reason) { this.reason = reason; }

    public boolean isMoreRecent( Date recordedTime ) { return this.recordedTime.after( recordedTime ); }
}
