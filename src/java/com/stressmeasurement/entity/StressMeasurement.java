/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stressmeasurement.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LQwabe
 */
@Entity
@Table(name = "stress_measurement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StressMeasurement.findAll", query = "SELECT s FROM StressMeasurement s"),
    @NamedQuery(name = "StressMeasurement.findBySmId", query = "SELECT s FROM StressMeasurement s WHERE s.smId = :smId"),
    @NamedQuery(name = "StressMeasurement.findByAvg", query = "SELECT s FROM StressMeasurement s WHERE s.avg = :avg"),
    @NamedQuery(name = "StressMeasurement.findByGg", query = "SELECT s FROM StressMeasurement s WHERE s.gg = :gg"),
    @NamedQuery(name = "StressMeasurement.findByIg", query = "SELECT s FROM StressMeasurement s WHERE s.ig = :ig"),
    @NamedQuery(name = "StressMeasurement.findByCountry", query = "SELECT s FROM StressMeasurement s WHERE s.country = :country"),
    @NamedQuery(name = "StressMeasurement.findByProvince", query = "SELECT s FROM StressMeasurement s WHERE s.province = :province"),
    @NamedQuery(name = "StressMeasurement.findByLocality", query = "SELECT s FROM StressMeasurement s WHERE s.locality = :locality"),
    @NamedQuery(name = "StressMeasurement.findBySite", query = "SELECT s FROM StressMeasurement s WHERE s.site = :site"),
    @NamedQuery(name = "StressMeasurement.findByLocation", query = "SELECT s FROM StressMeasurement s WHERE s.location = :location"),
    @NamedQuery(name = "StressMeasurement.findByLongitude", query = "SELECT s FROM StressMeasurement s WHERE s.longitude = :longitude"),
    @NamedQuery(name = "StressMeasurement.findByLatitude", query = "SELECT s FROM StressMeasurement s WHERE s.latitude = :latitude"),
    @NamedQuery(name = "StressMeasurement.findByDate", query = "SELECT s FROM StressMeasurement s WHERE s.date = :date"),
    @NamedQuery(name = "StressMeasurement.findByMethod", query = "SELECT s FROM StressMeasurement s WHERE s.method = :method"),
    @NamedQuery(name = "StressMeasurement.findByDepth", query = "SELECT s FROM StressMeasurement s WHERE s.depth = :depth"),
    @NamedQuery(name = "StressMeasurement.findByBs1", query = "SELECT s FROM StressMeasurement s WHERE s.bs1 = :bs1"),
    @NamedQuery(name = "StressMeasurement.findByBs2", query = "SELECT s FROM StressMeasurement s WHERE s.bs2 = :bs2"),
    @NamedQuery(name = "StressMeasurement.findByBs3", query = "SELECT s FROM StressMeasurement s WHERE s.bs3 = :bs3"),
    @NamedQuery(name = "StressMeasurement.findByDips1", query = "SELECT s FROM StressMeasurement s WHERE s.dips1 = :dips1"),
    @NamedQuery(name = "StressMeasurement.findByDips2", query = "SELECT s FROM StressMeasurement s WHERE s.dips2 = :dips2"),
    @NamedQuery(name = "StressMeasurement.findByDips3", query = "SELECT s FROM StressMeasurement s WHERE s.dips3 = :dips3"),
    @NamedQuery(name = "StressMeasurement.findByS1", query = "SELECT s FROM StressMeasurement s WHERE s.s1 = :s1"),
    @NamedQuery(name = "StressMeasurement.findByS2", query = "SELECT s FROM StressMeasurement s WHERE s.s2 = :s2"),
    @NamedQuery(name = "StressMeasurement.findByS3", query = "SELECT s FROM StressMeasurement s WHERE s.s3 = :s3"),
    @NamedQuery(name = "StressMeasurement.findBySob", query = "SELECT s FROM StressMeasurement s WHERE s.sob = :sob"),
    @NamedQuery(name = "StressMeasurement.findBySx", query = "SELECT s FROM StressMeasurement s WHERE s.sx = :sx"),
    @NamedQuery(name = "StressMeasurement.findBySy", query = "SELECT s FROM StressMeasurement s WHERE s.sy = :sy"),
    @NamedQuery(name = "StressMeasurement.findBySz", query = "SELECT s FROM StressMeasurement s WHERE s.sz = :sz"),
    @NamedQuery(name = "StressMeasurement.findBySxy", query = "SELECT s FROM StressMeasurement s WHERE s.sxy = :sxy"),
    @NamedQuery(name = "StressMeasurement.findBySyz", query = "SELECT s FROM StressMeasurement s WHERE s.syz = :syz"),
    @NamedQuery(name = "StressMeasurement.findBySzx", query = "SELECT s FROM StressMeasurement s WHERE s.szx = :szx"),
    @NamedQuery(name = "StressMeasurement.findBySh1", query = "SELECT s FROM StressMeasurement s WHERE s.sh1 = :sh1"),
    @NamedQuery(name = "StressMeasurement.findBySh3", query = "SELECT s FROM StressMeasurement s WHERE s.sh3 = :sh3"),
    @NamedQuery(name = "StressMeasurement.findByBsh1", query = "SELECT s FROM StressMeasurement s WHERE s.bsh1 = :bsh1"),
    @NamedQuery(name = "StressMeasurement.findByK1", query = "SELECT s FROM StressMeasurement s WHERE s.k1 = :k1"),
    @NamedQuery(name = "StressMeasurement.findByK3", query = "SELECT s FROM StressMeasurement s WHERE s.k3 = :k3"),
    @NamedQuery(name = "StressMeasurement.findByKx", query = "SELECT s FROM StressMeasurement s WHERE s.kx = :kx"),
    @NamedQuery(name = "StressMeasurement.findByKz", query = "SELECT s FROM StressMeasurement s WHERE s.kz = :kz"),
    @NamedQuery(name = "StressMeasurement.findByNo", query = "SELECT s FROM StressMeasurement s WHERE s.no = :no"),
    @NamedQuery(name = "StressMeasurement.findByE", query = "SELECT s FROM StressMeasurement s WHERE s.e = :e"),
    @NamedQuery(name = "StressMeasurement.findByPr", query = "SELECT s FROM StressMeasurement s WHERE s.pr = :pr"),
    @NamedQuery(name = "StressMeasurement.findByRock", query = "SELECT s FROM StressMeasurement s WHERE s.rock = :rock"),
    @NamedQuery(name = "StressMeasurement.findBySeq", query = "SELECT s FROM StressMeasurement s WHERE s.seq = :seq"),
    @NamedQuery(name = "StressMeasurement.findByReff", query = "SELECT s FROM StressMeasurement s WHERE s.reff = :reff"),
    @NamedQuery(name = "StressMeasurement.findByNotes", query = "SELECT s FROM StressMeasurement s WHERE s.notes = :notes"),
    @NamedQuery(name = "StressMeasurement.findByAvgb", query = "SELECT s FROM StressMeasurement s WHERE s.avgb = :avgb"),
    @NamedQuery(name = "StressMeasurement.findByVerified", query = "SELECT s FROM StressMeasurement s WHERE s.verified = :verified")})
public class StressMeasurement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SM_ID")
    private Integer smId;
    @Size(max = 45)
    @Column(name = "AVG")
    private String avg;
    @Size(max = 45)
    @Column(name = "GG")
    private String gg;
    @Size(max = 45)
    @Column(name = "IG")
    private String ig;
    @Size(max = 45)
    @Column(name = "COUNTRY")
    private String country;
    @Size(max = 45)
    @Column(name = "PROVINCE")
    private String province;
    @Size(max = 45)
    @Column(name = "LOCALITY")
    private String locality;
    @Size(max = 45)
    @Column(name = "SITE")
    private String site;
    @Size(max = 45)
    @Column(name = "LOCATION")
    private String location;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LONGITUDE")
    private Float longitude;
    @Column(name = "LATITUDE")
    private Float latitude;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 45)
    @Column(name = "METHOD")
    private String method;
    @Column(name = "DEPTH")
    private Float depth;
    @Column(name = "BS1")
    private Integer bs1;
    @Column(name = "BS2")
    private Integer bs2;
    @Column(name = "BS3")
    private Integer bs3;
    @Column(name = "DIPS1")
    private Integer dips1;
    @Column(name = "DIPS2")
    private Integer dips2;
    @Column(name = "DIPS3")
    private Integer dips3;
    @Column(name = "S1")
    private Float s1;
    @Column(name = "S2")
    private Float s2;
    @Column(name = "S3")
    private Float s3;
    @Column(name = "SOB")
    private Float sob;
    @Column(name = "SX")
    private Float sx;
    @Column(name = "SY")
    private Float sy;
    @Column(name = "SZ")
    private Float sz;
    @Column(name = "SXY")
    private Float sxy;
    @Column(name = "SYZ")
    private Float syz;
    @Column(name = "SZX")
    private Float szx;
    @Column(name = "SH1")
    private Float sh1;
    @Column(name = "SH3")
    private Float sh3;
    @Column(name = "BSH1")
    private Integer bsh1;
    @Column(name = "K1")
    private Float k1;
    @Column(name = "K3")
    private Float k3;
    @Column(name = "KX")
    private Float kx;
    @Column(name = "KZ")
    private Float kz;
    @Column(name = "NO")
    private Integer no;
    @Column(name = "E")
    private Float e;
    @Column(name = "PR")
    private Float pr;
    @Size(max = 45)
    @Column(name = "ROCK")
    private String rock;
    @Size(max = 45)
    @Column(name = "SEQ")
    private String seq;
    @Size(max = 45)
    @Column(name = "REFF")
    private String reff;
    @Size(max = 45)
    @Column(name = "NOTES")
    private String notes;
    @Column(name = "AVGB")
    private Integer avgb;
    @Size(max = 4)
    @Column(name = "VERIFIED")
    private String verified;

    public StressMeasurement() {
    }

    public StressMeasurement(Integer smId) {
        this.smId = smId;
    }

    public Integer getSmId() {
        return smId;
    }

    public void setSmId(Integer smId) {
        this.smId = smId;
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }

    public String getGg() {
        return gg;
    }

    public void setGg(String gg) {
        this.gg = gg;
    }

    public String getIg() {
        return ig;
    }

    public void setIg(String ig) {
        this.ig = ig;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Float getDepth() {
        return depth;
    }

    public void setDepth(Float depth) {
        this.depth = depth;
    }

    public Integer getBs1() {
        return bs1;
    }

    public void setBs1(Integer bs1) {
        this.bs1 = bs1;
    }

    public Integer getBs2() {
        return bs2;
    }

    public void setBs2(Integer bs2) {
        this.bs2 = bs2;
    }

    public Integer getBs3() {
        return bs3;
    }

    public void setBs3(Integer bs3) {
        this.bs3 = bs3;
    }

    public Integer getDips1() {
        return dips1;
    }

    public void setDips1(Integer dips1) {
        this.dips1 = dips1;
    }

    public Integer getDips2() {
        return dips2;
    }

    public void setDips2(Integer dips2) {
        this.dips2 = dips2;
    }

    public Integer getDips3() {
        return dips3;
    }

    public void setDips3(Integer dips3) {
        this.dips3 = dips3;
    }

    public Float getS1() {
        return s1;
    }

    public void setS1(Float s1) {
        this.s1 = s1;
    }

    public Float getS2() {
        return s2;
    }

    public void setS2(Float s2) {
        this.s2 = s2;
    }

    public Float getS3() {
        return s3;
    }

    public void setS3(Float s3) {
        this.s3 = s3;
    }

    public Float getSob() {
        return sob;
    }

    public void setSob(Float sob) {
        this.sob = sob;
    }

    public Float getSx() {
        return sx;
    }

    public void setSx(Float sx) {
        this.sx = sx;
    }

    public Float getSy() {
        return sy;
    }

    public void setSy(Float sy) {
        this.sy = sy;
    }

    public Float getSz() {
        return sz;
    }

    public void setSz(Float sz) {
        this.sz = sz;
    }

    public Float getSxy() {
        return sxy;
    }

    public void setSxy(Float sxy) {
        this.sxy = sxy;
    }

    public Float getSyz() {
        return syz;
    }

    public void setSyz(Float syz) {
        this.syz = syz;
    }

    public Float getSzx() {
        return szx;
    }

    public void setSzx(Float szx) {
        this.szx = szx;
    }

    public Float getSh1() {
        return sh1;
    }

    public void setSh1(Float sh1) {
        this.sh1 = sh1;
    }

    public Float getSh3() {
        return sh3;
    }

    public void setSh3(Float sh3) {
        this.sh3 = sh3;
    }

    public Integer getBsh1() {
        return bsh1;
    }

    public void setBsh1(Integer bsh1) {
        this.bsh1 = bsh1;
    }

    public Float getK1() {
        return k1;
    }

    public void setK1(Float k1) {
        this.k1 = k1;
    }

    public Float getK3() {
        return k3;
    }

    public void setK3(Float k3) {
        this.k3 = k3;
    }

    public Float getKx() {
        return kx;
    }

    public void setKx(Float kx) {
        this.kx = kx;
    }

    public Float getKz() {
        return kz;
    }

    public void setKz(Float kz) {
        this.kz = kz;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Float getE() {
        return e;
    }

    public void setE(Float e) {
        this.e = e;
    }

    public Float getPr() {
        return pr;
    }

    public void setPr(Float pr) {
        this.pr = pr;
    }

    public String getRock() {
        return rock;
    }

    public void setRock(String rock) {
        this.rock = rock;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getReff() {
        return reff;
    }

    public void setReff(String reff) {
        this.reff = reff;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getAvgb() {
        return avgb;
    }

    public void setAvgb(Integer avgb) {
        this.avgb = avgb;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (smId != null ? smId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StressMeasurement)) {
            return false;
        }
        StressMeasurement other = (StressMeasurement) object;
        if ((this.smId == null && other.smId != null) || (this.smId != null && !this.smId.equals(other.smId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stressmeasurement.entity.StressMeasurement[ smId=" + smId + " ]";
    }
    
}
