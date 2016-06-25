function hideForm()
{
    if( document.getElementById("comboSecao").size > "0")
    	document.getElementById("formNot").style.display="none";
    else
    	document.getElementById("formNot").style.display="block";
    
    window.onload = hideForm();
}
