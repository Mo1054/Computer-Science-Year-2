// Route handler for sign in
const path = require('path');
const bcrypt = require('bcrypt');


module.exports = function (app) {
  app.get('/signin', function (req, res) {
    const layoutPath = path.resolve(__dirname, '..', 'Html', '_layout.ejs');
    const contentPath = path.resolve(__dirname, '..', 'Html', '_signinContent.ejs');
    const footerPath = path.resolve(__dirname, '..', 'Html', '_footer.ejs');
    const title = 'Sign In'; // Define the title variable here
    res.render('signin', { layoutPath, contentPath, footerPath, title }); // Pass the title variable here
  });

  app.post('/signin', function (req, res) {
    const { username, password } = req.body;
    const sql = 'SELECT * FROM users WHERE username = ?';
    db.query(sql, [username], (err, results) => {
      if (err) throw err;
      if (results.length === 0) {
        res.send('User not found');
      } else {
        const user = results[0];
        bcrypt.compare(password, user.password, (err, result) => {
          if (result) {
            req.session.user = user;
            res.redirect('/profile');
          } else {
            res.send('Incorrect password');
          }
        });
      }
    });
  });
}
