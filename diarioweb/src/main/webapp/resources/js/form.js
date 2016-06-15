function buttonState(){
    $("input").each(function(){
        $('#register').attr('disabled', 'disabled');
        if($(this).val() == "" ) return false;
        $('#register').attr('disabled', '');
    })
}

$(function(){
    $('#register').attr('disabled', 'disabled');
    $('input').change(buttonState);
})