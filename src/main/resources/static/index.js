
function sendBin() {
    var bin = {'value':123456};
    $.ajax({
        type: 'post',
        data: {value:123456},
        url: "/test",
        success: function (profile) {
            alert('ok')
        },
        error: function (error) {
            console.log(error);
            alert(error.responseText);
        }
    })
}