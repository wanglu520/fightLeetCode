/**
 * @param {number[]} balance
 */
 var Bank = function(balance) {
  this.balance = [0, ...balance];
  this.length = this.balance.length;
};

/** 
* @param {number} account1 
* @param {number} account2 
* @param {number} money
* @return {boolean}
*/
Bank.prototype.transfer = function(account1, account2, money) {
  if(account1 < this.length && account2 < this.length && this.balance[account1] >= money){
      this.balance[account1] -= money;
      this.balance[account2] += money;
      return true;
  }
  return false;
};

/** 
* @param {number} account 
* @param {number} money
* @return {boolean}
*/
Bank.prototype.deposit = function(account, money) {
  if(account < this.length){
      this.balance[account] += money;
      return true;
  }
  return false;
};

/** 
* @param {number} account 
* @param {number} money
* @return {boolean}
*/
Bank.prototype.withdraw = function(account, money) {
  if(account < this.length && this.balance[account] >= money){
      this.balance[account] -= money;
      return true;
  }
  return false
};

/**
* Your Bank object will be instantiated and called as such:
* var obj = new Bank(balance)
* var param_1 = obj.transfer(account1,account2,money)
* var param_2 = obj.deposit(account,money)
* var param_3 = obj.withdraw(account,money)
*/