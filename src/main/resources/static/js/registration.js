    window.onload = def;


    function def(){
        info.style.visibility = 'hidden';
    }


    function validate() {

        var password = document.getElementById( "password" ).value;
        var login = document.getElementById ( "login" ).value;

        if (password.length > 5 && login.length > 3){

            var f = document.forms["form"];

            f.method = "POST";
            f.submit();
        }
        else{
            window.location.replace( "/registration?error" );
        }
    }


    function showHintLogin() {

        var info = document.getElementById( "info" );

        info.style.visibility = 'visible';

        document.getElementById( "text" ).innerHTML = "Login powinien zawierać od 4 do 30 znaków. Login nie może zawierać znaku pustego.";

    }


    function showHintPassword() {

        var info = document.getElementById( "info" );

        info.style.visibility = 'visible';

        document.getElementById( "text" ).innerHTML = "Hasło powinno zawierać od 6 do 30 znaków. Hasło nie może zawierać znaku pustego.";

    }


    function checkPasswordIdentical(){

        var firstPassword = document.getElementById( "password" ).value;
        var secondPassword = document.getElementById( "secondPassword" ).value;

        if ( firstPassword == secondPassword ){
            validate();
        }
        else{
            window.location.replace( "/registration?passw" );
        }
    }