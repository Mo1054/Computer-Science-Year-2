// Import express, ejs and body parser
var express = require ('express')
var ejs = require('ejs')
var bodyParser= require ('body-parser')
// Create the express application object
const app = express()
const port = 3000;

var validator = require("email-validator");



// Set the directory where Express will pick up HTML files
// __dirname will get the current directory
app.set('views', __dirname + '/views');

app.use(express.static(__dirname + '/public'));

// Tell Express that we want to use EJS as the templating engine
app.set('view engine', 'ejs');
// Tells Express how we should process html files
// We want to use EJS's rendering engine
app.engine('html', ejs.renderFile);
// Handle our routes
var shopData = {shopName: "The Thirsty Student",
productCategories:["Beer", "Wine", "Soft Drinks", "Hot Drinks"],
shop: [{address: "160 charles street", manager: "Jack Smith" },
{address: "26 hammersmith street", manager: "James Turkey"}]};
app.get('/',function(req,res){
res.render('index.html', shopData);
});



app.get('/about',function(req,res){
res.render('about.html', shopData);
});

app.get('/search',function(req,res){
res.render("search.html");
});

app.get('/search-result', function (req, res) {
    // TODO: search in the database
    res.send("You searched for: " + req.query.keyword);
    });

app.get('/register', function (req,res) {
        res.render('register.html',shopData);
        
        });

app.use(bodyParser.urlencoded({ extended: true }))
        
app.post('/registered', function (req,res) {
        // saving data in database

        if(validator.validate(req.body.email)){

                res.send(' Hello '+ req.body.first + ' '+ req.body.last +' you are now registered.' + ' We will now send your email to ' + req.body.email);

        }

        else {

                res.send('You have failed');
        }
        
        
        });




// Start the web app listening
app.listen(port, () => console.log(`Example app listening on port ${port}!`));

