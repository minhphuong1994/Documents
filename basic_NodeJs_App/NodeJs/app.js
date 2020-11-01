const { response } = require("express");
const express = require("express")
const app = express();
const request = require("request")

app.listen(3000,()=>{//3000 is the port number
    console.log("Hello Node Js. Running on port 3000")
}) 

app.get("/msg",(req,res)=>{
    console.log("Hello Node Js from Msg Route!")
})

app.get("/route",(req,res)=>{
    res.send("Hello Node Js from route Route!") 
})

app.get("/emp/:fname/:lname",(req,res)=>{
    const f_name = req.params.fname
    const l_name = req.params.lname
    res.send("First Name: "+f_name+" Last Name: "+l_name) 
})

app.get("/home/:name/:age",(req,res)=>{
    const ename = req.params.name 
    const eage = req.params.age 

    res.render("home.ejs",{
        name: ename,
        age: eage
    })
})


app.get("/home/:idPage",(req,res)=>{
    const id= req.params.idPage;

    request("https://api.unsplash.com/photos/?client_id=pYkggc7mee3eYD2xyQGrIf5QFx1e4Mtydmv-eYnSTO0&pages="+id,
    (error,response,body)=>{
       
        console.log(response.statusCode) //check request 200 is successful
        
        if(error){
            console.log(error)
            res.send("Error: "+error)
        }
        else{
            const data = JSON.parse(body)
            // console.log(data)
            res.render("home.ejs",{ 
                obj: data                            
            })
        }
    })    
})



