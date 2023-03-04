package com.github.fabriciolfj.usecase;

import com.github.fabriciolfj.entities.Transaction;

public interface TransactionCreateUseCase {

    Transaction execute(final Transaction transaction);
}
