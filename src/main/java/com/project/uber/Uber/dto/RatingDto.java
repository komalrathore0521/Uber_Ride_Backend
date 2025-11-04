package com.project.uber.Uber.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
@Schema(description = "Rating payload used to rate drivers or riders")
public class RatingDto {
    @Schema(description = "Numeric rating score (1-5)", example = "5", required = true)
    @NotNull
    @Min(1)
    @Max(5)
    private Double rating;

    public RatingDto() {
    }

    public RatingDto(Double rating) {
        this.rating = rating;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

}
