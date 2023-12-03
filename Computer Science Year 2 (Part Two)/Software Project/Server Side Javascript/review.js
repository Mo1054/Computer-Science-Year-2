// Route handler for forum web app
module.exports = function(app) {

///Requiring Modules
const session = require('express-session');


///Creating Session
app.use(session({
  secret: 'mysecretkey',
  resave: false,
  saveUninitialized: true
}));


//Handling post from form
app.post('/post', (req, res) => {
  const { name, lecture, course, review } = req.body;
  const sql = `INSERT INTO reviews (username, course_rating, lecture_rating, comment, submission_date) VALUES (?, ?, ?, ?, ?)`;
  const values = [name, course, lecture, review, new Date()];
  db.query(sql, values, (err, result) => {
    if (err) {
      throw err;
    }
    const sql2 = 'SELECT * FROM reviews ORDER BY submission_date DESC';
    db.query(sql2, (err, results) => {
      if (err) {
        throw err;
      }
      req.session.reviews = results;
      res.redirect('/review');
    });
  });
});



//Handling search on page
app.get('/search', (req, res) => {
  const { university } = req.query;
  const sql = `SELECT * FROM Uni WHERE Institution LIKE '%${university}%' LIMIT 1`;
  db.query(sql, (err, results) => {
    if (err) {
      throw err;
    }
    const searchResults = { universities: results, reviews: req.session.reviews || [] };
    res.render('review', searchResults);
  });
});

//Rendering reviews page
app.get('/review', (req, res) => {
  const sql = 'SELECT * FROM reviews ORDER BY submission_date DESC';
  db.query(sql, (err, results) => {
    if (err) {
      throw err;
    }
    const searchResults = { universities: [], reviews: results };
    res.render('review', searchResults);
  });
});


}
