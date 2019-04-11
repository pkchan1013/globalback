package com.hk.cityu.globalback.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Phone {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(length = 60, unique = true, nullable = false)
    private String name;

    @NotNull
    @Column(length = 30, nullable = false)
    private String brand;

    @Column(length = 500)
    @ColumnDefault("'n/a'")
    private String deviceImg;

    @Column(length = 500)
    @ColumnDefault("'n/a'")
    private String deviceColor;

    @Column(length = 100)
    @ColumnDefault("'n/a'")
    private String simCard;

    @Column(length = 500)
    @ColumnDefault("'n/a'")
    private String screenType;

    @Column(length = 500)
    @ColumnDefault("'n/a'")
    private String screenSize;

    @Column(length = 500)
    @ColumnDefault("'n/a'")
    private String screenRes;

    @Column(length = 500)
    @ColumnDefault("'n/a'")
    private String screenColor;

    @Column(length = 500)
    @ColumnDefault("'n/a'")
    private String screenProtection;

    @Column(length = 100)
    @ColumnDefault("'n/a'")
    private String hasSDCard;

    @Column(length = 500)
    @ColumnDefault("'n/a'")
    private String speakerSpec;

    @Column(length = 500)
    @ColumnDefault("'n/a'")
    private String soundCancelFeature;

    @Column(length = 500)
    @ColumnDefault("'n/a'")
    private String cpuSpec;

    @Column(length = 500)
    @ColumnDefault("'n/a'")
    private String cpuChipset;

    @Column(length = 500)
    @ColumnDefault("'n/a'")
    private String gpuSpec;

    @Column(length = 500)
    @ColumnDefault("'n/a'")
    private String memoryStorage;

    @Column(length = 200)
    @ColumnDefault("'n/a'")
    private String hasEarJack;

    @Column(length = 500)
    @ColumnDefault("'n/a'")
    private String wifiSpec;

    @Column(length = 500)
    @ColumnDefault("'n/a'")
    private String cellSpeedSpec;

    @Column(length = 500)
    @ColumnDefault("'n/a'")
    private String mainFeatures;

    @Column(length = 500)
    @ColumnDefault("'n/a'")
    private String subFeatures;

    @Column(length = 500)
    @ColumnDefault("'n/a'")
    private String sensorFeatures;

    @Column(length = 500)
    @ColumnDefault("'n/a'")
    private String batteryCap;

    @Column(length = 500)
    @ColumnDefault("'n/a'")
    private String chargingSpec;

    @Column(length = 500)
    @ColumnDefault("'n/a'")
    private String frontCamSpec;

    @Column(length = 500)
    @ColumnDefault("'n/a'")
    private String backCamSpec;

    @Column(length = 500)
    @ColumnDefault("'n/a'")
    private String camFeatures;

    @Column(precision=8, scale=2)
    @ColumnDefault("0")
    private Double hkPrice;

    @Column(precision=8, scale=2)
    @ColumnDefault("0")
    private Double taobaoPrice;

    @Column(length = 500)
    private String taobaoURL;

    @Column(precision=8, scale=2)
    @ColumnDefault("0")
    private Double amazonPrice;

    @Column(length = 500)
    private String amazonURL;

    @Column(precision=8, scale=2)
    @ColumnDefault("0")
    private Double jpPrice;

    @Column(length = 500)
    private String jpURL;

    @Column(precision=8, scale=2)
    @ColumnDefault("0")
    private Double euPrice;

    @Column(length = 500)
    private String euURL;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date")
    private Date modifyDate;

    public Phone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDeviceImg() {
        return deviceImg;
    }

    public void setDeviceImg(String deviceImg) {
        this.deviceImg = deviceImg;
    }

    public String getDeviceColor() {
        return deviceColor;
    }

    public void setDeviceColor(String deviceColor) {
        this.deviceColor = deviceColor;
    }

    public String getSimCard() {
        return simCard;
    }

    public void setSimCard(String simCard) {
        this.simCard = simCard;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getScreenRes() {
        return screenRes;
    }

    public void setScreenRes(String screenRes) {
        this.screenRes = screenRes;
    }

    public String getScreenColor() {
        return screenColor;
    }

    public void setScreenColor(String screenColor) {
        this.screenColor = screenColor;
    }

    public String getScreenProtection() {
        return screenProtection;
    }

    public void setScreenProtection(String screenProtection) {
        this.screenProtection = screenProtection;
    }

    public String getHasSDCard() {
        return hasSDCard;
    }

    public void setHasSDCard(String hasSDCard) {
        this.hasSDCard = hasSDCard;
    }

    public String getSpeakerSpec() {
        return speakerSpec;
    }

    public void setSpeakerSpec(String speakerSpec) {
        this.speakerSpec = speakerSpec;
    }

    public String getSoundCancelFeature() {
        return soundCancelFeature;
    }

    public void setSoundCancelFeature(String soundCancelFeature) {
        this.soundCancelFeature = soundCancelFeature;
    }

    public String getCpuSpec() {
        return cpuSpec;
    }

    public void setCpuSpec(String cpuSpec) {
        this.cpuSpec = cpuSpec;
    }

    public String getCpuChipset() {
        return cpuChipset;
    }

    public void setCpuChipset(String cpuChipset) {
        this.cpuChipset = cpuChipset;
    }

    public String getGpuSpec() {
        return gpuSpec;
    }

    public void setGpuSpec(String gpuSpec) {
        this.gpuSpec = gpuSpec;
    }

    public String getMemoryStorage() {
        return memoryStorage;
    }

    public void setMemoryStorage(String memoryStorage) {
        this.memoryStorage = memoryStorage;
    }

    public String getHasEarJack() {
        return hasEarJack;
    }

    public void setHasEarJack(String hasEarJack) {
        this.hasEarJack = hasEarJack;
    }

    public String getWifiSpec() {
        return wifiSpec;
    }

    public void setWifiSpec(String wifiSpec) {
        this.wifiSpec = wifiSpec;
    }

    public String getCellSpeedSpec() {
        return cellSpeedSpec;
    }

    public void setCellSpeedSpec(String cellSpeedSpec) {
        this.cellSpeedSpec = cellSpeedSpec;
    }

    public String getMainFeatures() {
        return mainFeatures;
    }

    public void setMainFeatures(String mainFeatures) {
        this.mainFeatures = mainFeatures;
    }

    public String getSubFeatures() {
        return subFeatures;
    }

    public void setSubFeatures(String subFeatures) {
        this.subFeatures = subFeatures;
    }

    public String getSensorFeatures() {
        return sensorFeatures;
    }

    public void setSensorFeatures(String sensorFeatures) {
        this.sensorFeatures = sensorFeatures;
    }

    public String getBatteryCap() {
        return batteryCap;
    }

    public void setBatteryCap(String batteryCap) {
        this.batteryCap = batteryCap;
    }

    public String getChargingSpec() {
        return chargingSpec;
    }

    public void setChargingSpec(String chargingSpec) {
        this.chargingSpec = chargingSpec;
    }

    public String getFrontCamSpec() {
        return frontCamSpec;
    }

    public void setFrontCamSpec(String frontCamSpec) {
        this.frontCamSpec = frontCamSpec;
    }

    public String getBackCamSpec() {
        return backCamSpec;
    }

    public void setBackCamSpec(String backCamSpec) {
        this.backCamSpec = backCamSpec;
    }

    public String getCamFeatures() {
        return camFeatures;
    }

    public void setCamFeatures(String camFeatures) {
        this.camFeatures = camFeatures;
    }

    public Double getHkPrice() {
        return hkPrice;
    }

    public void setHkPrice(Double hkPrice) {
        this.hkPrice = hkPrice;
    }

    public Double getTaobaoPrice() {
        return taobaoPrice;
    }

    public void setTaobaoPrice(Double taobaoPrice) {
        this.taobaoPrice = taobaoPrice;
    }

    @JsonIgnore
    public String getTaobaoURL() {
        return taobaoURL;
    }

    @JsonProperty
    public void setTaobaoURL(String taobaoURL) {
        this.taobaoURL = taobaoURL;
    }

    public Double getAmazonPrice() {
        return amazonPrice;
    }

    public void setAmazonPrice(Double amazonPrice) {
        this.amazonPrice = amazonPrice;
    }

    @JsonIgnore
    public String getAmazonURL() {
        return amazonURL;
    }

    @JsonProperty
    public void setAmazonURL(String amazonURL) {
        this.amazonURL = amazonURL;
    }

    public Double getJpPrice() {
        return jpPrice;
    }

    public void setJpPrice(Double jpPrice) {
        this.jpPrice = jpPrice;
    }

    @JsonIgnore
    public String getJpURL() {
        return jpURL;
    }

    @JsonProperty
    public void setJpURL(String jpURL) {
        this.jpURL = jpURL;
    }

    public Double getEuPrice() {
        return euPrice;
    }

    public void setEuPrice(Double euPrice) {
        this.euPrice = euPrice;
    }

    @JsonIgnore
    public String getEuURL() {
        return euURL;
    }

    @JsonProperty
    public void setEuURL(String euURL) {
        this.euURL = euURL;
    }

    @JsonIgnore
    public Date getCreateDate() {
        return createDate;
    }

    @JsonProperty
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
