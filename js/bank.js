var Database = (function() {
    _data = {};
  
    _create = function(object) {
      return _data[object.id] = object;
    };

    _read = function(id) {
      return _data[id];
    };

    _update = function(object) {
      return _data[object.id] = object;
    };
    _delete = function(id) {
      return _data[id] = null;
    };

    _getSize = function(){
        var total = 0;
        for (var obj in _data) {
            total++;
        }
        return total;
    };

    _generateId = function(){
        return  Date.now();
    };

    _deposit = function(object) {   //object should be in format {id:accountId, amount: depositAmount}
        //find the account to update balance
        var obj = _read(object.id);
        if(obj != null){
            _update({id:object.id, name: obj.name, balance: parseFloat(obj.balance)+parseFloat(object.amount), status: obj.status});
        }
    };

    _transfer = function(object) {   //object should be in format: {fromId:fromAccountId, toId: toAccountId, amount: transferAmount}
        //find the accounts to update balance
        var fromObj = _read(object.fromId);
        var toObj = _read(object.toId);
        if(fromObj != null && toObj != null){
            //transfer if possible
            if(fromObj.balance > object.amount){
                _update({id:fromObj.id, name: fromObj.name, balance: parseFloat(fromObj.balance)-parseFloat(object.amount), status: fromObj.status});
                _update({id:toObj.id, name: toObj.name, balance: parseFloat(toObj.balance)+parseFloat(object.amount), status: toObj.status});
            }
        }
    };

    _display = function(){
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
        getUniqueId: _generateId,      
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
        var id = Database.getUniqueId();
        Database.create({id:id, name:newName, balance: initialDeposit, status: 'active'});
    };

    //deposit
    var btnDeposit = document.getElementById("btnDeposit");
    btnDeposit.onclick = function(){
        var accountId = document.getElementById("accountId").value;
        var depositAmount = document.getElementById("depositAmount").value;
        Database.deposit({id:accountId, amount: depositAmount});
    };

    //transfer
    var btnProcess = document.getElementById("btnProcess");
    btnProcess.onclick = function(){
        var fromAccountId = document.getElementById("fromAccountId").value;
        var toAccountId = document.getElementById("toAccountId").value;
        var transferAmount = document.getElementById("depositAmount").value;
        Database.transfer({fromId:fromAccountId, toId: toAccountId, amount: transferAmount});
    };

    //refresh
    var btnRefresh = document.getElementById("btnRefresh");
    btnRefresh.onclick = function(){
        var accountListInfo = document.getElementById("accountListInfo");
        accountListInfo.innerHTML = Database.display();
    };
}