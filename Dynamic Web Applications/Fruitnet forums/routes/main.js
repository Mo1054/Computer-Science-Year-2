// Route handler for forum web app
module.exports = function(app, forumData) {

    // Handle our routes
    // Home page
    app.get('/',function(req,res){
        res.render('index.ejs', forumData)
    });

    // About page
    app.get('/about',function(req,res){
        res.render('about.ejs', forumData);
    });

    // View Posts page
    app.get('/viewposts',function(req,res){
        // Query to select all posts from the database
        let sqlquery = `SELECT  post_id, post_date, topic_title, post_title, post_content, username
            FROM   vw_posts`;

        // Run the query
        db.query(sqlquery, (err, result) => {
          if (err) {
             res.redirect('./');
          }

          // Pass results to the EJS page and view it
          let data = Object.assign({}, forumData, {posts:result});
          console.log(data)
          res.render('viewposts.ejs', data);
        });
    });

    // List Users page
    app.get('/users',function(req,res){
        // Query to select all users
        let sqlquery = `SELECT   username, firstname, surname, country
                        FROM     users 
                        ORDER BY username;`
                 
        // Run the query
        db.query(sqlquery, (err, result) => {
            if (err) {
                res.redirect('./');
            }

            // Pass results to the EJS page and view it
            let data = Object.assign({}, forumData, {users:result});
            console.log(data)
            res.render('users.ejs', data);
        });                        
    });

    // List Topics page
    app.get('/topics',function(req,res){
        // Query to select all topics
        let sqlquery = `SELECT   users.username, topic_id, topic_title, topic_description
        FROM     topics
        JOIN     users
        ON       users.user_id= topics.topic_id
        ORDER BY topic_title`;

        // Run the query       
        db.query(sqlquery, (err, result) => {
            if (err) {
                res.redirect('./');
            }

            // Pass results to the EJS page and view it
            let data = Object.assign({}, forumData, {topics:result});
            console.log(data)
            res.render('topics.ejs', data);
        });    
    });

    // Add a New Post page
    app.get('/addpost',function(req,res){
        // Set the initial values for the form
        let initialvalues = {username: '', topic: '', title: '', content: ''}

        // Pass the data to the EJS page and view it
        return renderAddNewPost(res, initialvalues, "") 
    });

    // Helper function to 
    function renderAddNewPost(res, initialvalues, errormessage) {
        let data = Object.assign({}, forumData, initialvalues, {errormessage:errormessage});
        console.log(data)
        res.render("addpost.ejs", data);
        return 
    }
//add new posts
    app.post('/postadded', function (req,res) {
            let params = [req.body.title, req.body.content, req.body.topic, req.body.username]
            let sqlquery = `CALL sp_insert_post(?,?,?,?)`
            db.query(sqlquery, params, (err, result) => {
              if (err) {
                return renderAddNewPost(res, req.body, err.message)
              }
              ///sends a message letting the user a new post has been created
              res.send('You post has been added to forum');
            });  
          });
        

    // Search for Posts page
    app.get('/search',function(req,res){
        res.render("search.ejs", forumData);
    });

    // Search for Posts form handler
    app.get('/search-result', function (req, res) {
        //searching in the database
        let term = '%' + req.query.keyword + '%'
        let sqlquery = `SELECT *
                        FROM   posts p
                        JOIN     topics t
                        ON       t.topic_id=p.topic_id
                        JOIN     users
                        ON       users.user_id=p.topic_id
                        WHERE  post_title LIKE ? OR post_content LIKE ? 
                        ORDER BY post_date ASC`

        db.query(sqlquery, [term, term], (err, result) => {
            if (err) {
                res.redirect('./');
            }
            //pass in new data object
            let data = Object.assign({}, forumData, {posts:result});
            console.log(data);
            res.render("viewposts.ejs", data);
        });      
    });
}
