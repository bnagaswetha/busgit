/**
 * 
 */
function validate(){
	var flag=false;
	var uname=form1.uname.value;
	var pwd=form1.pwd.value;
	if(uname=="" ||uname==null){
		document.getElementById('uerrormsg').innerHTML="please Enter username";
		flag=false;
		
	}else if(pwd=="" || pwd==null){
		document.getElementById('uerrormsg').innerHTML="";
		document.getElementById('perrormsg').innerHTML="Please Enter password";
		flag=false;
	}else{
		flag=true;
	}
	return flag;
}
function uservalidations(){
	var reg="/^[a-zA-Z]$";
	var fname=form2.fname.value;

}