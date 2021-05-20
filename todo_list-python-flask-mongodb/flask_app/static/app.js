URL_Update = "http://127.0.0.1:5000/update"

console.log("js here")

const updateItem = (e) =>{
    id = e.target.id
    task = document.querySelector("#task").value
    fetch(URL_Update,{
        method: "PUT",
        body: JSON.stringify({"_id":id,"task":task}),
        headers: {"content-type": "application/json"}
    })
    .then(function (response) { //check if POST success
            if (response.status !== 200) {
              console.log("Error: "+response.status);
              return
            }
//            response.json().then(function (data) {//convert json files to know what server received
//              console.log(data)
//            })
        })
        .catch(function (error) {
          console.log("Fetch error: " + error)
        })
    window.location.reload()
}