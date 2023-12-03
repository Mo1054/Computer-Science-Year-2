//Requires epxress
const express = require('express')
//Assigns the express object to a variable
const app = express()
//Assigns port number to variable
const port = 8000

//When the user requests the homepage then the server sends back the html below
app.get('/home', (req, res) => res.send('<h1>This is my home page</h1>'));

//When the user requests the about page then the server sends the html below
app.get('/about', (req, res) => res.send ('<h1>This is about page</h1>'));

//when the user requests the contact then the server sends the html below
app.get('/contact', (req, res) => res.send ('<h1>This is about contact</h1>'));


//Displays the name of user typed in the url when requested.
app.get('/welcome/:name', (req, res) => res.send ( '<p> Welcome <p/>' + req.params.name));

//Creates a date object and assigns it to the variable.
const today = new Date();

//Calls the get methods on the today object.
const day = today.getDate()        // 24
const month = today.getMonth()     // 10 (Month is 0-based, so 10 means 11th Month)
const year = today.getFullYear()   // 2020

//Displays the date and html when the user requests the date site
app.get('/date', (req, res) => res.send ('<h1>This is the date page</h1>' + day + ":"+ month + ":"+ year));

//Listens on port 8000 for requests
app.listen(port, () => console.log(`Example app listening on port ${port}!`));








