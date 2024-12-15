package com.tekarch.accounts_module.Controller;

import com.tekarch.accounts_module.Models.Account;
import com.tekarch.accounts_module.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountsController {

    @Autowired
    private AccountService accountService;

    // 1. Creation (POST)
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    // 2. Updation (PUT with Account ID)
    @PutMapping("/{accountId}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long accountId, @RequestBody Account accountDetails) {
        Account updatedAccount = accountService.updateAccount(accountId, accountDetails);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    // 3. Update Account by using userId and AccountId as Query Parameters
    @PutMapping
    public ResponseEntity<Account> updateAccountByUserId(
            @RequestParam Long userId, @RequestParam Long accountId, @RequestBody Account accountDetails) {
        Account updatedAccount = accountService.updateAccountByUserId(userId, accountId, accountDetails);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    // 4. Retrieve All User Accounts
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    // 5. Retrieve Single User's Account by UserId
    @GetMapping("/userid")
    public ResponseEntity<List<Account>> getAccountsByUserId(@RequestParam String userid) {
        List<Account> accounts = accountService.getAccountsByUserId(userid);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    // 6. Retrieve Single Account by AccountId
    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long accountId) {
        Account account = accountService.getAccountById(accountId);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    // 7. Delete Account by AccountId
    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long accountId) {
        accountService.deleteAccount(accountId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // 8. Fetch Balances for Multiple Accounts of a User
    @GetMapping("/balance")
    public ResponseEntity<List<Account>> getAccountBalances(@RequestParam String userid) {
        List<Account> accounts = accountService.getAccountBalances(userid);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
}
