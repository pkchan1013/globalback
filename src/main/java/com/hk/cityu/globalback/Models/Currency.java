package com.hk.cityu.globalback.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Currency {
    @Id
    @GeneratedValue
    private Long id;

    @Column(precision=8, scale=2)
    @ColumnDefault("0")
    private Double hkRatio;

    @Column(precision=8, scale=2)
    @ColumnDefault("0")
    private Double jpRatio;

    @Column(precision=8, scale=2)
    @ColumnDefault("0")
    private Double cnRatio;

    @Column(precision=8, scale=2)
    @ColumnDefault("0")
    private Double usRatio;

    @Column(precision=8, scale=2)
    @ColumnDefault("0")
    private Double euRatio;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date")
    private Date modifyDate;

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @JsonProperty
    public void setId(Long id) {
        this.id = id;
    }

    public Double getHkRatio() {
        return hkRatio;
    }

    public void setHkRatio(Double hkRatio) {
        this.hkRatio = hkRatio;
    }

    public Double getJpRatio() {
        return jpRatio;
    }

    public void setJpRatio(Double jpRatio) {
        this.jpRatio = jpRatio;
    }

    public Double getCnRatio() {
        return cnRatio;
    }

    public void setCnRatio(Double cnRatio) {
        this.cnRatio = cnRatio;
    }

    public Double getUsRatio() {
        return usRatio;
    }

    public void setUsRatio(Double usRatio) {
        this.usRatio = usRatio;
    }

    public Double getEuRatio() {
        return euRatio;
    }

    public void setEuRatio(Double euRatio) {
        this.euRatio = euRatio;
    }

    @JsonIgnore
    public Date getCreateDate() {
        return createDate;
    }

    @JsonProperty
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @JsonIgnore
    public Date getModifyDate() {
        return modifyDate;
    }

    @JsonProperty
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
