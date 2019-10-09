
function sendBin() {
    $.ajax({
        type: 'post',
        data: {value : document.getElementById("bin_input").value},
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