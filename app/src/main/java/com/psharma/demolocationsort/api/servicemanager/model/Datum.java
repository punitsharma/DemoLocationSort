
package com.psharma.demolocationsort.api.servicemanager.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "SubFranchiseID",
    "OutletID",
    "OutletName",
    "BrandID",
    "Address",
    "NeighbourhoodID",
    "CityID",
    "Email",
    "Timings",
    "CityRank",
    "Latitude",
    "Longitude",
    "Pincode",
    "Landmark",
    "Streetname",
    "BrandName",
    "OutletURL",
    "NumCoupons",
    "NeighbourhoodName",
    "PhoneNumber",
    "CityName",
    "Distance",
    "Categories",
    "LogoURL",
    "CoverURL"
})
public class Datum {

    @JsonProperty("SubFranchiseID")
    private String SubFranchiseID;
    @JsonProperty("OutletID")
    private String OutletID;
    @JsonProperty("OutletName")
    private String OutletName;
    @JsonProperty("BrandID")
    private String BrandID;
    @JsonProperty("Address")
    private String Address;
    @JsonProperty("NeighbourhoodID")
    private String NeighbourhoodID;
    @JsonProperty("CityID")
    private String CityID;
    @JsonProperty("Email")
    private Object Email;
    @JsonProperty("Timings")
    private String Timings;
    @JsonProperty("CityRank")
    private Object CityRank;
    @JsonProperty("Latitude")
    private String Latitude;
    @JsonProperty("Longitude")
    private String Longitude;
    @JsonProperty("Pincode")
    private Object Pincode;
    @JsonProperty("Landmark")
    private Object Landmark;
    @JsonProperty("Streetname")
    private Object Streetname;
    @JsonProperty("BrandName")
    private String BrandName;
    @JsonProperty("OutletURL")
    private String OutletURL;
    @JsonProperty("NumCoupons")
    private Integer NumCoupons;
    @JsonProperty("NeighbourhoodName")
    private String NeighbourhoodName;
    @JsonProperty("PhoneNumber")
    private String PhoneNumber;
    @JsonProperty("CityName")
    private String CityName;
    @JsonProperty("Distance")
    private Double Distance;
    @JsonProperty("Categories")
    private List<Category> Categories = new ArrayList<Category>();
    @JsonProperty("LogoURL")
    private String LogoURL;
    @JsonProperty("CoverURL")
    private String CoverURL;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The SubFranchiseID
     */
    @JsonProperty("SubFranchiseID")
    public String getSubFranchiseID() {
        return SubFranchiseID;
    }

    /**
     * 
     * @param SubFranchiseID
     *     The SubFranchiseID
     */
    @JsonProperty("SubFranchiseID")
    public void setSubFranchiseID(String SubFranchiseID) {
        this.SubFranchiseID = SubFranchiseID;
    }

    /**
     * 
     * @return
     *     The OutletID
     */
    @JsonProperty("OutletID")
    public String getOutletID() {
        return OutletID;
    }

    /**
     * 
     * @param OutletID
     *     The OutletID
     */
    @JsonProperty("OutletID")
    public void setOutletID(String OutletID) {
        this.OutletID = OutletID;
    }

    /**
     * 
     * @return
     *     The OutletName
     */
    @JsonProperty("OutletName")
    public String getOutletName() {
        return OutletName;
    }

    /**
     * 
     * @param OutletName
     *     The OutletName
     */
    @JsonProperty("OutletName")
    public void setOutletName(String OutletName) {
        this.OutletName = OutletName;
    }

    /**
     * 
     * @return
     *     The BrandID
     */
    @JsonProperty("BrandID")
    public String getBrandID() {
        return BrandID;
    }

    /**
     * 
     * @param BrandID
     *     The BrandID
     */
    @JsonProperty("BrandID")
    public void setBrandID(String BrandID) {
        this.BrandID = BrandID;
    }

    /**
     * 
     * @return
     *     The Address
     */
    @JsonProperty("Address")
    public String getAddress() {
        return Address;
    }

    /**
     * 
     * @param Address
     *     The Address
     */
    @JsonProperty("Address")
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * 
     * @return
     *     The NeighbourhoodID
     */
    @JsonProperty("NeighbourhoodID")
    public String getNeighbourhoodID() {
        return NeighbourhoodID;
    }

    /**
     * 
     * @param NeighbourhoodID
     *     The NeighbourhoodID
     */
    @JsonProperty("NeighbourhoodID")
    public void setNeighbourhoodID(String NeighbourhoodID) {
        this.NeighbourhoodID = NeighbourhoodID;
    }

    /**
     * 
     * @return
     *     The CityID
     */
    @JsonProperty("CityID")
    public String getCityID() {
        return CityID;
    }

    /**
     * 
     * @param CityID
     *     The CityID
     */
    @JsonProperty("CityID")
    public void setCityID(String CityID) {
        this.CityID = CityID;
    }

    /**
     * 
     * @return
     *     The Email
     */
    @JsonProperty("Email")
    public Object getEmail() {
        return Email;
    }

    /**
     * 
     * @param Email
     *     The Email
     */
    @JsonProperty("Email")
    public void setEmail(Object Email) {
        this.Email = Email;
    }

    /**
     * 
     * @return
     *     The Timings
     */
    @JsonProperty("Timings")
    public String getTimings() {
        return Timings;
    }

    /**
     * 
     * @param Timings
     *     The Timings
     */
    @JsonProperty("Timings")
    public void setTimings(String Timings) {
        this.Timings = Timings;
    }

    /**
     * 
     * @return
     *     The CityRank
     */
    @JsonProperty("CityRank")
    public Object getCityRank() {
        return CityRank;
    }

    /**
     * 
     * @param CityRank
     *     The CityRank
     */
    @JsonProperty("CityRank")
    public void setCityRank(Object CityRank) {
        this.CityRank = CityRank;
    }

    /**
     * 
     * @return
     *     The Latitude
     */
    @JsonProperty("Latitude")
    public String getLatitude() {
        return Latitude;
    }

    /**
     * 
     * @param Latitude
     *     The Latitude
     */
    @JsonProperty("Latitude")
    public void setLatitude(String Latitude) {
        this.Latitude = Latitude;
    }

    /**
     * 
     * @return
     *     The Longitude
     */
    @JsonProperty("Longitude")
    public String getLongitude() {
        return Longitude;
    }

    /**
     * 
     * @param Longitude
     *     The Longitude
     */
    @JsonProperty("Longitude")
    public void setLongitude(String Longitude) {
        this.Longitude = Longitude;
    }

    /**
     * 
     * @return
     *     The Pincode
     */
    @JsonProperty("Pincode")
    public Object getPincode() {
        return Pincode;
    }

    /**
     * 
     * @param Pincode
     *     The Pincode
     */
    @JsonProperty("Pincode")
    public void setPincode(Object Pincode) {
        this.Pincode = Pincode;
    }

    /**
     * 
     * @return
     *     The Landmark
     */
    @JsonProperty("Landmark")
    public Object getLandmark() {
        return Landmark;
    }

    /**
     * 
     * @param Landmark
     *     The Landmark
     */
    @JsonProperty("Landmark")
    public void setLandmark(Object Landmark) {
        this.Landmark = Landmark;
    }

    /**
     * 
     * @return
     *     The Streetname
     */
    @JsonProperty("Streetname")
    public Object getStreetname() {
        return Streetname;
    }

    /**
     * 
     * @param Streetname
     *     The Streetname
     */
    @JsonProperty("Streetname")
    public void setStreetname(Object Streetname) {
        this.Streetname = Streetname;
    }

    /**
     * 
     * @return
     *     The BrandName
     */
    @JsonProperty("BrandName")
    public String getBrandName() {
        return BrandName;
    }

    /**
     * 
     * @param BrandName
     *     The BrandName
     */
    @JsonProperty("BrandName")
    public void setBrandName(String BrandName) {
        this.BrandName = BrandName;
    }

    /**
     * 
     * @return
     *     The OutletURL
     */
    @JsonProperty("OutletURL")
    public String getOutletURL() {
        return OutletURL;
    }

    /**
     * 
     * @param OutletURL
     *     The OutletURL
     */
    @JsonProperty("OutletURL")
    public void setOutletURL(String OutletURL) {
        this.OutletURL = OutletURL;
    }

    /**
     * 
     * @return
     *     The NumCoupons
     */
    @JsonProperty("NumCoupons")
    public Integer getNumCoupons() {
        return NumCoupons;
    }

    /**
     * 
     * @param NumCoupons
     *     The NumCoupons
     */
    @JsonProperty("NumCoupons")
    public void setNumCoupons(Integer NumCoupons) {
        this.NumCoupons = NumCoupons;
    }

    /**
     * 
     * @return
     *     The NeighbourhoodName
     */
    @JsonProperty("NeighbourhoodName")
    public String getNeighbourhoodName() {
        return NeighbourhoodName;
    }

    /**
     * 
     * @param NeighbourhoodName
     *     The NeighbourhoodName
     */
    @JsonProperty("NeighbourhoodName")
    public void setNeighbourhoodName(String NeighbourhoodName) {
        this.NeighbourhoodName = NeighbourhoodName;
    }

    /**
     * 
     * @return
     *     The PhoneNumber
     */
    @JsonProperty("PhoneNumber")
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    /**
     * 
     * @param PhoneNumber
     *     The PhoneNumber
     */
    @JsonProperty("PhoneNumber")
    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    /**
     * 
     * @return
     *     The CityName
     */
    @JsonProperty("CityName")
    public String getCityName() {
        return CityName;
    }

    /**
     * 
     * @param CityName
     *     The CityName
     */
    @JsonProperty("CityName")
    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    /**
     * 
     * @return
     *     The Distance
     */
    @JsonProperty("Distance")
    public Double getDistance() {
        return Distance;
    }

    /**
     * 
     * @param Distance
     *     The Distance
     */
    @JsonProperty("Distance")
    public void setDistance(Double Distance) {
        this.Distance = Distance;
    }

    /**
     * 
     * @return
     *     The Categories
     */
    @JsonProperty("Categories")
    public List<Category> getCategories() {
        return Categories;
    }

    /**
     * 
     * @param Categories
     *     The Categories
     */
    @JsonProperty("Categories")
    public void setCategories(List<Category> Categories) {
        this.Categories = Categories;
    }

    /**
     * 
     * @return
     *     The LogoURL
     */
    @JsonProperty("LogoURL")
    public String getLogoURL() {
        return LogoURL;
    }

    /**
     * 
     * @param LogoURL
     *     The LogoURL
     */
    @JsonProperty("LogoURL")
    public void setLogoURL(String LogoURL) {
        this.LogoURL = LogoURL;
    }

    /**
     * 
     * @return
     *     The CoverURL
     */
    @JsonProperty("CoverURL")
    public String getCoverURL() {
        return CoverURL;
    }

    /**
     * 
     * @param CoverURL
     *     The CoverURL
     */
    @JsonProperty("CoverURL")
    public void setCoverURL(String CoverURL) {
        this.CoverURL = CoverURL;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
