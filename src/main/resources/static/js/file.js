    window.onload = def;


    function checkFile(){

        var fileName = document.getElementById("image").value;

        var shortFileName = fileName.split(/(\\|\/)/g).pop();

        var fileExtension = shortFileName.split(".").pop();


        if ( !(fileExtension == "png" | fileExtension == "jpg" | fileExtension == "jpeg") ){

            document.getElementById("image").value = "";
            error.style.visibility = 'visible';
        }
        else {
            error.style.visibility = 'hidden';
        }
    }


    function def(){
        error.style.visibility = 'hidden';
    }