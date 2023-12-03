// Route handler for web app
module.exports = function(app) {

//The Code for forum page goes here

///Requiring Modules
const session = require('express-session');


///Creating Session
app.use(session({
  secret: 'mysecretkey',
  resave: false,
  saveUninitialized: true
}));

//Render forum page
app.get('/forum', (req, res) => {
  const sql = 'SELECT * FROM forum';
  db.query(sql, (err, results) => {
    if (err) {
      throw err;
    }
    const searchResults = { forum: [], forum: results };
    res.render('forum', searchResults);
  });
});


//write
app.post('/thread', (req, res) => {
  const { firstname, surname, username, topic, review} = req.body;
  const sql = `INSERT INTO forum (firstname, surname, username, topic_title, post_content) VALUES (?, ?, ?, ?, ?)`;
  const values = [firstname, surname, username, topic, review];
  db.query(sql, values, (err, result) => {
    if (err) {
      throw err;
    }
    const sql2 = 'SELECT * FROM forum';
    db.query(sql2, (err, results) => {
      if (err) {
        throw err;
      }
      req.session.forum = results;
      res.redirect('/forum');
    });
  });
});

}
 
