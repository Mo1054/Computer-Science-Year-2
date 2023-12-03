document.addEventListener('DOMContentLoaded', () => {
    const form = document.querySelector('form');
    const usernameInput = document.querySelector('input[name="username"]');
    const emailInput = document.querySelector('input[name="email"]');
    const passwordInput = document.querySelector('input[name="password"]');
    const nameInput = document.querySelector('input[name="name"]');
    const surnameInput = document.querySelector('input[name="surname"]');
    const universityInput = document.querySelector('input[name="university"]');
    const degreeInput = document.querySelector('input[name="degree"]');
    const subjectInput = document.querySelector('input[name="subject"]');
    const yearOfStudyInput = document.querySelector('input[name="year_of_study"]');

    const showError = (input, message) => {
        const error = document.createElement('span');
        error.className = 'error';
        error.textContent = message;
        input.parentNode.insertBefore(error, input.nextSibling);
    };

    const clearErrors = () => {
        const errors = document.querySelectorAll('.error');
        errors.forEach(error => error.remove());
    };

    const validateInputs = (event) => {
        event.preventDefault();
        clearErrors();

        let valid = true;

        if (usernameInput.value.length < 3 || usernameInput.value.length > 20) {
            showError(usernameInput, 'Username must be between 3 and 20 characters long');
            valid = false;
        }

        if (!emailInput.value.endsWith('.ac.uk')) {
            showError(emailInput, 'Email must end with .ac.uk');
            valid = false;
        }

        if (passwordInput.value.length < 6 || passwordInput.value.length > 20) {
            showError(passwordInput, 'Password must be between 6 and 20 characters long');
            valid = false;
        }

        if (nameInput.value.length < 1 || nameInput.value.length > 50) {
            showError(nameInput, 'Name must be between 1 and 50 characters long');
            valid = false;
        }

        if (surnameInput.value.length < 1 || surnameInput.value.length > 50) {
            showError(surnameInput, 'Surname must be between 1 and 50 characters long');
            valid = false;
        }

        if (universityInput.value.length > 0 && universityInput.value.length < 3) {
            showError(universityInput, 'University name must be at least 3 characters long');
            valid = false;
        }

        if (degreeInput.value.length > 0 && degreeInput.value.length < 2) {
            showError(degreeInput, 'Degree must be at least 2 characters long');
            valid = false;
        }

        if (subjectInput.value.length > 0 && subjectInput.value.length < 3) {
            showError(subjectInput, 'Subject must be at least 3 characters long');
            valid = false;
        }

        if (yearOfStudyInput.value < 0 || yearOfStudyInput.value > 5) {
            showError(yearOfStudyInput, 'Year of study must be between 0 and 5');
            valid = false;
        }

        if (valid) {
            form.submit();
        }
    };

    form.addEventListener('submit', validateInputs);
});
