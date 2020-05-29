
var Database = (function() {
    "use strict";
    var _data = {};
  
    var _create = function(object) {
      return (_data[object.id] = object);
    };

    var _read = function(id) {
      return _data[id];
    };

    var _update = function(object) {
      return (_data[object.id] = object);
    };

    var _delete = function(id) {
      return (_data[id] = null);
    };

    var _getSize = function(){
        var total = 0;
        for (var obj in _data) {
            total++;
        }
        return total;
    };

    var _generateUniqueId = function(){
        return  Date.now();
    };

    var _deposit = function(object) {   //object should be in format {id:accountId, amount: depositAmount}
        //find the account to update balance
        var obj = _read(object.id);
        if(obj != null){            
            var balance = parseFloat(obj.balance)+parseFloat(object.amount);
            _update({id:object.id, name: obj.name, balance: balance, status: obj.status});
        }
    };

    var _withdraw = function(object) {   //object should be in format {id:accountId, amount: depositAmount}
        //find the account to update balance
        var obj = _read(object.id);
        if(obj != null){
            var balance = parseFloat(obj.balance)-parseFloat(object.amount);
            _update({id:object.id, name: obj.name, balance: balance, status: obj.status});
        }
    };

    var _transfer = function(object) {   //object should be in format: {fromId:fromAccountId, toId: toAccountId, amount: transferAmount}
        //find the accounts to update balance
        var fromObj = _read(object.fromId);
        var toObj = _read(object.toId);
        if(fromObj != null && toObj != null){
            //transfer if possible
            if(parseFloat(fromObj.balance) >= parseFloat(object.amount)){
                _withdraw({id:object.fromId, amount: parseFloat(object.amount)});
                _deposit({id:object.toId, amount: parseFloat(object.amount)});
            }
        }
    };

    var _display = function(){
        var html = "<table>";
        html += "<caption>List of accounts</caption>";
        html += "<tr>";
        html += "<th>ID</th>";
        html += "<th>Name</th>";
        html += "<th>Balance ($) </th>";
        html += "<th>Status</th>";
        html += "<th>Action</th>";
        html += "<tr>";
        for (var obj in _data) {
            if(_data[obj] !=null){
                html += "<tr>";
                html += "<td>" + _data[obj].id + "</td>";
                html += "<td>" + _data[obj].name + "</td>";
                html += "<td>" + _data[obj].balance + "</td>";
                html += "<td>" + _data[obj].status + "</td>";
                html += "<td>" + ((_data[obj].status === "active") ? "Disable" : "Enable") + "</td>";
                html += "</tr>";
            }
        }
        html += "</table>";
        return html;
    };

    return {
        create: _create,  
        getId: _generateUniqueId,      
        deposit: _deposit,      
        transfer: _transfer,
        display: _display,  
      };

}).call(this);

window.onload = function(){    

    //create 
    var btnCreate = document.getElementById("btnCreate");
    btnCreate.onclick = function(){
        var newName = document.getElementById("newName").value;
        var initialDeposit = document.getElementById("initialDeposit").value;
        if(newName !== "" &&  initialDeposit !== "" && !isNaN(initialDeposit)){
            var id = Database.getId();
            Database.create({id:id, name:newName, balance: initialDeposit, status: 'active'});
            alert("Account has been created!");                  
        }else{
            alert("Invalid input!");
        }
    };

    //deposit
    var btnDeposit = document.getElementById("btnDeposit");
    btnDeposit.onclick = function(){
        var accountId = document.getElementById("accountId").value;
        var depositAmount = document.getElementById("depositAmount").value;
        if(accountId !== "" && depositAmount !== "" && !isNaN(accountId) && !isNaN(depositAmount)){
            Database.deposit({id:accountId, amount: depositAmount});
            alert("Money has been deposited!");
        }else {
            alert("Invalid input!");
        }
    };

    //transfer
    var btnProcess = document.getElementById("btnProcess");
    btnProcess.onclick = function(){
        var fromAccountId = document.getElementById("fromAccountId").value;
        var toAccountId = document.getElementById("toAccountId").value;
        var transferAmount = document.getElementById("transferAmount").value;
        if(fromAccountId !== "" && toAccountId !== "" && transferAmount !== "" && !isNaN(fromAccountId) && !isNaN(toAccountId) && !isNaN(transferAmount)){            
            Database.transfer({fromId:fromAccountId, toId: toAccountId, amount: transferAmount});
            alert("Money has been transferred!");
        }else {
            alert("Invalid input!");
        }
    };

    //refresh
    var btnRefresh = document.getElementById("btnRefresh");
    btnRefresh.onclick = function(){
        var accountListInfo = document.getElementById("accountListInfo");
        accountListInfo.innerHTML = Database.display();
    };
};