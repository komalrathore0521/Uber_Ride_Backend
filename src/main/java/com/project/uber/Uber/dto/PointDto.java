package com.project.uber.Uber.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Geographical Point object following GeoJSON structure")
public class PointDto {

    @Schema(
            description = "Array containing latitude and longitude as [lon, lat]",
            example = "[81.6337, 21.2379]",
            required = true
    )
    @NotNull
    private double[] coordinates;

    @Schema(
            description = "Type of geometry, always 'Point'",
            example = "Point",
            required = true
    )
    private String type = "Point";

    public PointDto() {
    }

    public PointDto(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
