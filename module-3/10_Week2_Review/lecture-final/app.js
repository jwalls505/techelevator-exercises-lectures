import service from './tenmoService.js';

document.addEventListener('DOMContentLoaded', () => {
  document.getElementById('submit-button').addEventListener('click', (event) => {
    event.preventDefault();
    loginForm();
  });
});

function loginForm() {
  const username = document.getElementById('username').value;
  const password = document.getElementById('password').value;
  const accountBalanceElement = document.getElementById('account-balance');

  service.login(username, password)
    .then(() => {
      service.getAccountBalance().then((balance) => {
        accountBalanceElement.innerText = balance;
      })
    });
}