
function sendBin() {
    var bin = {value: document.getElementById("bin_input").value};
    $.ajax({
        type: 'post',
        url: "/",
        data: JSON.stringify(bin),
        dataType: "json",
        contentType: 'application/json; charset=utf-8',
        success: function (bankBinDto) {
            document.getElementById("status_message").innerHTML='<div class="alert alert-success" role="alert"><strong>ok</strong></div>';
            document.getElementById("bin_information_table").innerHTML='' +
                '<table class="table table-bordered">' +
                '  <tbody>' +
                '    <tr>' +
                '      <th scope="row">name</th><td>'+bankBinDto.bank.name+'</td>' +
                '    </tr>' +
                '    <tr>' +
                '      <th scope="row">url</th><td>'+bankBinDto.bank.url+'</td>' +
                '    </tr>' +
                '  </tbody>' +
                '</table>';
            if(bankBinDto.binList != null){
               var pageBinList =  document.getElementById('binList');
               pageBinList.innerHTML = '';
                for(var i = 0; i<bankBinDto.binList.length; i++){
                    var tr = document.createElement('tr');
                    var td = document.createElement('td');
                    td.textContent = bankBinDto.binList[i].value;
                    tr.appendChild(td);
                    pageBinList.append(tr);
                }
            }
        },
        error: function () {
            document.getElementById("bin_information_table").innerHTML='';
            document.getElementById("status_message").innerHTML='<div class="alert alert-danger" role="alert"> <strong>Bin not found</strong></div>';
        }
    })
}

