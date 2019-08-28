package tw.hd.com.allebicycles;

import java.util.List;
import java.util.Map;

public class BicyclesData {
    private int retCode;
    private Map<String, Sno> retVal;

    public BicyclesData() {
    }

    public BicyclesData(int retCode, Map<String, Sno> retVal) {
        this.retCode = retCode;
        this.retVal = retVal;
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public Map<String, Sno> getRetVal() {
        return retVal;
    }

    public void setRetVal(Map<String, Sno> retVal) {
        this.retVal = retVal;
    }
}

class Sno{
    private String sna;
    private int tot;
    private int sbi;
    private double lat;
    private double lng;
    private int bemp;
    private int act;
    private String sno;
    private String sarea;
    private String mday;
    private String ar;
    private String sareaen;
    private String snaen;
    private String aren;

    public Sno() {
    }

    public Sno(String sna, int tot, int sbi, double lat, double lng, int bemp, int act, String sno, String sarea, String mday, String ar, String sareaen, String snaen, String aren) {
        this.sna = sna;
        this.tot = tot;
        this.sbi = sbi;
        this.lat = lat;
        this.lng = lng;
        this.bemp = bemp;
        this.act = act;
        this.sno = sno;
        this.sarea = sarea;
        this.mday = mday;
        this.ar = ar;
        this.sareaen = sareaen;
        this.snaen = snaen;
        this.aren = aren;
    }

    public String getSna() {
        return sna;
    }

    public void setSna(String sna) {
        this.sna = sna;
    }

    public int getTot() {
        return tot;
    }

    public void setTot(int tot) {
        this.tot = tot;
    }

    public int getSbi() {
        return sbi;
    }

    public void setSbi(int sbi) {
        this.sbi = sbi;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public int getBemp() {
        return bemp;
    }

    public void setBemp(int bemp) {
        this.bemp = bemp;
    }

    public int getAct() {
        return act;
    }

    public void setAct(int act) {
        this.act = act;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSarea() {
        return sarea;
    }

    public void setSarea(String sarea) {
        this.sarea = sarea;
    }

    public String getMday() {
        return mday;
    }

    public void setMday(String mday) {
        this.mday = mday;
    }

    public String getAr() {
        return ar;
    }

    public void setAr(String ar) {
        this.ar = ar;
    }

    public String getSareaen() {
        return sareaen;
    }

    public void setSareaen(String sareaen) {
        this.sareaen = sareaen;
    }

    public String getSnaen() {
        return snaen;
    }

    public void setSnaen(String snaen) {
        this.snaen = snaen;
    }

    public String getAren() {
        return aren;
    }

    public void setAren(String aren) {
        this.aren = aren;
    }
}
