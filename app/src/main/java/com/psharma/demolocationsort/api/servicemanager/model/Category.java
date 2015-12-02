
package com.psharma.demolocationsort.api.servicemanager.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "OfflineCategoryID",
    "Name",
    "ParentCategoryID",
    "CategoryType"
})
public class Category {

    @JsonProperty("OfflineCategoryID")
    private String OfflineCategoryID;
    @JsonProperty("Name")
    private String Name;
    @JsonProperty("ParentCategoryID")
    private String ParentCategoryID;
    @JsonProperty("CategoryType")
    private String CategoryType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The OfflineCategoryID
     */
    @JsonProperty("OfflineCategoryID")
    public String getOfflineCategoryID() {
        return OfflineCategoryID;
    }

    /**
     * 
     * @param OfflineCategoryID
     *     The OfflineCategoryID
     */
    @JsonProperty("OfflineCategoryID")
    public void setOfflineCategoryID(String OfflineCategoryID) {
        this.OfflineCategoryID = OfflineCategoryID;
    }

    /**
     * 
     * @return
     *     The Name
     */
    @JsonProperty("Name")
    public String getName() {
        return Name;
    }

    /**
     * 
     * @param Name
     *     The Name
     */
    @JsonProperty("Name")
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * 
     * @return
     *     The ParentCategoryID
     */
    @JsonProperty("ParentCategoryID")
    public String getParentCategoryID() {
        return ParentCategoryID;
    }

    /**
     * 
     * @param ParentCategoryID
     *     The ParentCategoryID
     */
    @JsonProperty("ParentCategoryID")
    public void setParentCategoryID(String ParentCategoryID) {
        this.ParentCategoryID = ParentCategoryID;
    }

    /**
     * 
     * @return
     *     The CategoryType
     */
    @JsonProperty("CategoryType")
    public String getCategoryType() {
        return CategoryType;
    }

    /**
     * 
     * @param CategoryType
     *     The CategoryType
     */
    @JsonProperty("CategoryType")
    public void setCategoryType(String CategoryType) {
        this.CategoryType = CategoryType;
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
