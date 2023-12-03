// Route handler for sign up
const bcrypt = require('bcrypt');
const path = require('path');

module.exports = function (app) {
  app.get('/signup', function (req, res) {
    const layoutPath = path.resolve(__dirname, '..', 'Html', '_layout.ejs');
    const contentPath = path.resolve(__dirname, '..', 'Html', '_signupContent.ejs');
    const footerPath = path.resolve(__dirname, '..', 'Html', '_footer.ejs');
    res.render('signup', { layoutPath, contentPath, footerPath });
  });

  // Handle the sign up form submission
  app.post('/signup', function (req, res) {
    // Handle the sign up logic here
    const { username, email, password, name, surname, university, degree, subject, yearOfStudy } = req.body;
    console.log('Received form data:', req.body); // Add this line
    bcrypt.hash(password, 10, (err, hash) => {
      if (err) throw err;
      const sql = 'INSERT INTO users (username, email, password, name, surname, university, degree, subject, year_of_study) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)';
      const values = [username, email, hash, name, surname, university, degree, subject, yearOfStudy];
      console.log('Inserting values:', values); // Add this line
      db.query(sql, values, (err, result) => {
        if (err) {
          if (err.code === 'ER_DUP_ENTRY') {
            const layoutPath = path.resolve(__dirname, '..', 'Html', '_layout.ejs');
            const contentPath = path.resolve(__dirname, '..', 'Html', '_signupContent.ejs');
            const footerPath = path.resolve(__dirname, '..', 'Html', '_footer.ejs');
            res.render('signup', {
              layoutPath,
              contentPath,
              footerPath,
              error: 'An account with this email already exists. Please use another email.'
            });
          } else {
            throw err;
          }
        } else {
          console.log('User inserted successfully:', result); // Add this line
          res.redirect('/signin');
        }
      });
    });
  });

}
