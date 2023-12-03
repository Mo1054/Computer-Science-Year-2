module.exports = function(app) {

  //The Code for homepage page goes here

  // //Render page
  app.get('/', function(req, res) {
    let sqlquery = "SELECT * FROM Uni"; // query database to get all the uni info

    // execute sql query
    db.query(sqlquery, (err, result) => {
      if (err) {
        console.log(err);
        res.status(500).send("Error retrieving universities");
      } else {
        // Sort the results by default column and order
        const sortedResult = result.sort((a, b) => a.Ranks - b.Ranks);
        const uniData = { universities: sortedResult, reviews: [] };    
        console.log(uniData);
        res.render('homepage.ejs', uniData);
      }
    });
  });

// Handle sorting when user clicks on table header
app.get('/sort/:column/:order', function(req, res) {
  var column = req.params.column;
  var paramOrder = req.params.order;
  var sqlquery;
  
  

  if(paramOrder == 'asc'){
        sqlquery = `SELECT * FROM Uni ORDER BY ${column} ${'asc'}`;

  }else{
    sqlquery = `SELECT * FROM Uni ORDER BY ${column} ${'desc'}`;
}


  // Execute the query and send the results to the client

 
  // execute sql query
  db.query(sqlquery, (err, result) => {
    if (err) {
      console.log(err);
      res.status(500).send("Error retrieving universities");
    } else {
      const uniData = { universities: result, reviews: [] };    
      // console.log(uniData);
      const route = `sort-${column}-${paramOrder}.ejs`;
      res.render(route, uniData);
    }
  });
});
  
};
