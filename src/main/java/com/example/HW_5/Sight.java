package com.example.HW_5;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Sight {
    @Id
    private String id;
    private String sightName; // 景點名稱
    private String zone; //區
    private String category; //景點類別
    private String photoURL; //
    private String description; //描述
    private String address; //地址
    private String googleMap; //

    public Sight(String sightName,
                 String zone,
                 String category,
                 String photoURL,
                 String description,
                 String address,
                 String googleMap) {
        this.sightName = sightName;
        this.zone = zone;
        this.category = category;
        this.photoURL = photoURL;
        this.description = description;
        this.address = address;
        this.googleMap = googleMap;
    }


}
