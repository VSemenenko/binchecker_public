
function sendBin() {
    var bin = {'value':123456};
    $.ajax({
        type: 'post',
        data: {value:123456},
        url: "/test",
        success: function () {
            document.getElementById("status_message").innerHTML='<div class="alert alert-success" role="alert"><strong>Well done!</strong> ok</div>';
        },
        error: function (error) {
        document.getElementById("status_message").innerHTML='<div class="alert alert-danger" role="alert"> <strong>Oh snap!</strong> bin not found </div>';
        }
    })
}

