package com.itlize.joole.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itlize.joole.entity.enums.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(name = "brand", nullable = false)
    private Brand brand;
    @Enumerated(EnumType.STRING)
    @Column(name = "manufacturer", nullable = false)
    private Manufacturer manufacturer;
    @Column(name = "series", nullable = false)
    private String series;
    @Column(name = "model", nullable = false)
    private String model;
    @Enumerated(EnumType.STRING)
    @Column(name = "use_type", nullable = false)
    private UseType useType;
    @Enumerated(EnumType.STRING)
    @Column(name = "application", nullable = false)
    private Application application;
    @Enumerated(EnumType.STRING)
    @Column(name = "mounting_location", nullable = false)
    private MountingLocation mountingLocation;
    @Enumerated(EnumType.STRING)
    @Column(name = "accessories", nullable = false)
    private Accessories accessories;
    @Column(name = "model_year")
    private Integer modelYear;
    @Column(name = "airflow")
    private Float airflow;
    @Column(name = "min_power")
    private Float minPower;
    @Column(name = "max_power")
    private Float maxPower;
    @Column(name = "min_operating_voltage")
    private Float minOperatingVoltage;
    @Column(name = "max_operating_voltage")
    private Float maxOperatingVoltage;
    @Column(name = "min_fan_speed")
    private Float minFanSpeed;
    @Column(name = "max_fan_speed")
    private Float maxFanSpeed;
    @Column(name = "number_of_fan_speeds")
    private Float numberOfFanSpeeds;
    @Column(name = "sound_at_max_speed")
    private Float soundAtMaxSpeed;
    @Column(name = "min_height")
    private Float minHeight;
    @Column(name = "max_height")
    private Float maxHeight;
    @Column(name = "wight")
    private Float wight;
    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    private Date createdDate;
    @LastModifiedDate
    @Column(name = "updated_date", nullable = false)
    private Date updatedDate;
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.TRUE)
    @OneToMany(targetEntity = ProjectProduct.class, cascade = CascadeType.MERGE, mappedBy = "project")
    private Collection<ProjectProduct> projectProducts = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public UseType getUseType() {
        return useType;
    }

    public void setUseType(UseType useType) {
        this.useType = useType;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public MountingLocation getMountingLocation() {
        return mountingLocation;
    }

    public void setMountingLocation(MountingLocation mountingLocation) {
        this.mountingLocation = mountingLocation;
    }

    public Accessories getAccessories() {
        return accessories;
    }

    public void setAccessories(Accessories accessories) {
        this.accessories = accessories;
    }

    public Integer getModelYear() {
        return modelYear;
    }

    public void setModelYear(Integer modelYear) {
        this.modelYear = modelYear;
    }

    public Float getAirflow() {
        return airflow;
    }

    public void setAirflow(Float airflow) {
        this.airflow = airflow;
    }

    public Float getMinPower() {
        return minPower;
    }

    public void setMinPower(Float minPower) {
        this.minPower = minPower;
    }

    public Float getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(Float maxPower) {
        this.maxPower = maxPower;
    }

    public Float getMinOperatingVoltage() {
        return minOperatingVoltage;
    }

    public void setMinOperatingVoltage(Float minOperatingVoltage) {
        this.minOperatingVoltage = minOperatingVoltage;
    }

    public Float getMaxOperatingVoltage() {
        return maxOperatingVoltage;
    }

    public void setMaxOperatingVoltage(Float maxOperatingVoltage) {
        this.maxOperatingVoltage = maxOperatingVoltage;
    }

    public Float getMinFanSpeed() {
        return minFanSpeed;
    }

    public void setMinFanSpeed(Float minFanSpeed) {
        this.minFanSpeed = minFanSpeed;
    }

    public Float getMaxFanSpeed() {
        return maxFanSpeed;
    }

    public void setMaxFanSpeed(Float maxFanSpeed) {
        this.maxFanSpeed = maxFanSpeed;
    }

    public Float getNumberOfFanSpeeds() {
        return numberOfFanSpeeds;
    }

    public void setNumberOfFanSpeeds(Float numberOfFanSpeeds) {
        this.numberOfFanSpeeds = numberOfFanSpeeds;
    }

    public Float getSoundAtMaxSpeed() {
        return soundAtMaxSpeed;
    }

    public void setSoundAtMaxSpeed(Float soundAtMaxSpeed) {
        this.soundAtMaxSpeed = soundAtMaxSpeed;
    }

    public Float getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(Float minHeight) {
        this.minHeight = minHeight;
    }

    public Float getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(Float maxHeight) {
        this.maxHeight = maxHeight;
    }

    public Float getWight() {
        return wight;
    }

    public void setWight(Float wight) {
        this.wight = wight;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Collection<ProjectProduct> getProjectProducts() {
        return projectProducts;
    }

    public void setProjectProducts(Collection<ProjectProduct> projectProducts) {
        this.projectProducts = projectProducts;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", brand=" + brand +
                ", manufacturer=" + manufacturer +
                ", series='" + series + '\'' +
                ", model='" + model + '\'' +
                ", useType=" + useType +
                ", application=" + application +
                ", mountingLocation=" + mountingLocation +
                ", accessories=" + accessories +
                ", modelYear=" + modelYear +
                ", airflow=" + airflow +
                ", minPower=" + minPower +
                ", maxPower=" + maxPower +
                ", minOperatingVoltage=" + minOperatingVoltage +
                ", maxOperatingVoltage=" + maxOperatingVoltage +
                ", minFanSpeed=" + minFanSpeed +
                ", maxFanSpeed=" + maxFanSpeed +
                ", numberOfFanSpeeds=" + numberOfFanSpeeds +
                ", soundAtMaxSpeed=" + soundAtMaxSpeed +
                ", minHeight=" + minHeight +
                ", maxHeight=" + maxHeight +
                ", wight=" + wight +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", projectProducts=" + projectProducts +
                '}';
    }

//    private Detail detail;
//    private Documentation documentation;
//    private Contact contact;
}
