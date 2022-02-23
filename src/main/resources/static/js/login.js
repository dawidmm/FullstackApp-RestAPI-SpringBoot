    function checkWhiteSymbol() {

        var login = document.getElementById( "username" ).value;
        var password = document.getElementById( "password" ).value;

        if ( password.includes(" ") ||
             login.includes(" ") ||
             password == "" ||
             login == "") {

            window.location.replace( "/login?error" );
        }
        else {

            var f = document.forms["form"];

            f.method = "POST";
            f.submit();
        }
    }