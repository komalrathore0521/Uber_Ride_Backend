package com.project.uber.Uber.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Schema(description = "Represents a user's wallet containing balance and transaction history.")
public class WalletDto {

    @Schema(description = "Unique ID of the wallet", example = "1001")
    private Long id;

    @Schema(description = "User associated with this wallet", required = true, implementation = UserDto.class)
    @NotNull
    private UserDto user;

    @Schema(description = "Current available wallet balance (in INR)", example = "2500.75", required = true)
    @NotNull
    private Double balance;

    @Schema(description = "List of wallet transactions performed by the user", implementation = WalletTransactionDto.class)
    private List<WalletTransactionDto> transactions;

    public WalletDto() {
    }

    public WalletDto(Long id, UserDto user, Double balance, List<WalletTransactionDto> transactions) {
        this.id = id;
        this.user = user;
        this.balance = balance;
        this.transactions = transactions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<WalletTransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<WalletTransactionDto> transactions) {
        this.transactions = transactions;
    }
}
