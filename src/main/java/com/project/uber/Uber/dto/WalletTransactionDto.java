package com.project.uber.Uber.dto;

import com.project.uber.Uber.entities.enums.TransactionMethod;
import com.project.uber.Uber.entities.enums.TransactionType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Schema(description = "Represents a wallet transaction entry, including details like amount, method, type, and linked ride or wallet.")
public class WalletTransactionDto {

    @Schema(description = "Unique ID of the wallet transaction", example = "3001")
    private Long id;

    @Schema(description = "Transaction amount (positive for credit, negative for debit)", example = "250.75", required = true)
    @NotNull
    private Double amount;

    @Schema(description = "Type of transaction (CREDIT or DEBIT)", example = "CREDIT", required = true)
    @NotNull
    private TransactionType transactionType;

    @Schema(description = "Payment method used for this transaction", example = "UPI | CARD | CASH | WALLET", required = true)
    @NotNull
    private TransactionMethod transactionMethod;

    @Schema(description = "Ride associated with this transaction, if applicable", implementation = RideDto.class)
    private RideDto ride;

    @Schema(description = "External or system-generated transaction ID", example = "TXN20251104012345", required = true)
    @NotBlank
    private String transactionId;

    @Schema(description = "Wallet associated with this transaction", implementation = WalletDto.class)
    private WalletDto wallet;

    @Schema(description = "Timestamp when the transaction occurred (ISO format)", example = "2025-11-04T15:42:00")
    private LocalDateTime timestamp;

    public WalletTransactionDto() {
    }

    public WalletTransactionDto(WalletTransactionDtoBuilder builder) {
        this.id = builder.id;
        this.amount = builder.amount;
        this.transactionType = builder.transactionType;
        this.transactionMethod = builder.transactionMethod;
        this.ride = builder.ride;
        this.transactionId = builder.transactionId;
        this.wallet = builder.wallet;
        this.timestamp = builder.timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public TransactionMethod getTransactionMethod() {
        return transactionMethod;
    }

    public void setTransactionMethod(TransactionMethod transactionMethod) {
        this.transactionMethod = transactionMethod;
    }

    public RideDto getRide() {
        return ride;
    }

    public void setRide(RideDto ride) {
        this.ride = ride;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public WalletDto getWallet() {
        return wallet;
    }

    public void setWallet(WalletDto wallet) {
        this.wallet = wallet;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // -------------------------------
    // Builder class (unchanged)
    // -------------------------------
    public static class WalletTransactionDtoBuilder {
        private Long id;
        private Double amount;
        private TransactionType transactionType;
        private TransactionMethod transactionMethod;
        private RideDto ride;
        private String transactionId;
        private WalletDto wallet;
        private LocalDateTime timestamp;

        public WalletTransactionDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public WalletTransactionDtoBuilder amount(Double amount) {
            this.amount = amount;
            return this;
        }

        public WalletTransactionDtoBuilder transactionType(TransactionType transactionType) {
            this.transactionType = transactionType;
            return this;
        }

        public WalletTransactionDtoBuilder transactionMethod(TransactionMethod transactionMethod) {
            this.transactionMethod = transactionMethod;
            return this;
        }

        public WalletTransactionDtoBuilder ride(RideDto ride) {
            this.ride = ride;
            return this;
        }

        public WalletTransactionDtoBuilder transactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public WalletTransactionDtoBuilder wallet(WalletDto wallet) {
            this.wallet = wallet;
            return this;
        }

        public WalletTransactionDtoBuilder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public WalletTransactionDto build() {
            return new WalletTransactionDto(this);
        }
    }
}
