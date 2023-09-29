const input = document.querySelector("#form-to-check");
async function validateCheck() {
    var value = document.getElementById( "form-to-check" ).value;

    if ( value.length > 50 || value.length == 0 ) {
        input.classList.remove( "is-valid" );
        input.classList.add( "is-invalid" );
    } else {
        input.classList.add( "is-valid" );
        input.classList.remove( "is-invalid" );
        let method={
            method: 'POST',
            mode:'cors',
            headers:{
                "Content-Type":"application/json"
            },
        }
        await fetch('/api/count/numOfSymbols?string='+value,method)
            .then(response => response.text())
            .then((response) => {
                console.log(response)
                produceMessage(response);
            })
            .catch(err=>{
                    console.log(err.message);
                })
    }
}

async function produceMessage(a){
    document.getElementById("myspan").textContent=a;
}