// Route handler for profile
module.exports = function (app) {
    app.get('/profile', function (req, res) {
        // Check if the user is logged in
        if (req.session.user) {
            // Render the profile page with the user's information
            res.render('profile', {
                title: 'Profile', // Add this line
                username: req.session.user.username,
                name: req.session.user.name,
                surname: req.session.user.surname,
                email: req.session.user.email,
                university: req.session.user.university,
                degree: req.session.user.degree,
                subject: req.session.user.subject,
                yearOfStudy: req.session.user.year_of_study
            });

        } else {
            // Redirect to the sign in page if the user is not logged in
            res.redirect('/signin');
        }
    });
};