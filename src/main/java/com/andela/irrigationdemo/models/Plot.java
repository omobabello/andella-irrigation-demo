package com.andela.irrigationdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.NumberFormat;

import java.sql.Timestamp;

@Entity(name = "plots")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Plot {

    protected static final String LATITUDE_PATTERN = "^(\\+|-)?(?:90(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-8][0-9])(?:(?:\\.[0-9]{1,6})?))$";
    protected static final String LONGITUDE_PATTERN = "^(\\+|-)?(?:180(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-9][0-9]|1[0-7][0-9])(?:(?:\\.[0-9]{1,6})?))$";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name field is required")
    @Pattern(regexp = "^[a-zA-Z\\s]{5,}$", flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE}, message = "Name field does not match format")
    @Column(unique = true)
    private String name;
    @NotNull(message = "Longitude field is required")
    @NumberFormat(pattern = LONGITUDE_PATTERN)
    private Float longitude;
    @NotNull(message = "Latitude field is required")
    @NumberFormat(pattern = LATITUDE_PATTERN)
    private Float latitude;
    @NotNull(message = "Width field is required")
    @Min(value = 10, message = "Width of pitch can't be less than 10")
    private Integer width;
    @NotNull(message = "Length field is required")
    @Min(value = 10, message = "Length of pitch can't be less than 10")
    private Integer length;

    @CreationTimestamp
    private Timestamp created_at;

    @OneToOne
    @JoinTable(
            name = "irrigation_schedule",
            joinColumns = @JoinColumn(name = "plot_id"),
            inverseJoinColumns = @JoinColumn(name = "time_slot_id")
    )
    private TimeSlot irrigation_schedule;

    public Plot() {
    }

    public TimeSlot getIrrigation_schedule() {
        return irrigation_schedule;
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

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
