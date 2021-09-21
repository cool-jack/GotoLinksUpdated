

function emailMatch(){
	
	email = document.getElementById("email");
	cEmail = document.getElementById("cEmail");
	
	if(!email.equals(cEmail)) document.getElementById("emailNoMatch").innterHTML = "Email and confirmed email don't match";
	
}